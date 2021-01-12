package org.kly.javaCode.others;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Properties;

public class SftpConfig {

    public static final String CONF_HOST = "osgl.sftp.host";
    public static final String CONF_PORT = "osgl.sftp.port";
    public static final String CONF_USERNAME = "osgl.sftp.username";
    public static final String CONF_PASSWORD = "osgl.sftp.password";
    public static final String CONF_BYPASS_HOST_KEY_CHECKING = "osgl.sftp.no_host_key_checking";
    public static final String CONF_CONTEXT_PATH = "osgl.sftp.context_path";

    private static final int DEF_PORT = 22;

    private String host;
    private int port = DEF_PORT;
    private String username;
    private String password;
    private boolean byPassHostKeyChecking = false;
    private String contextPath = "/";

    public SftpConfig(Map conf) {
        host = getConf(CONF_HOST, conf);
        username = getConf(CONF_USERNAME, conf);
        password = getConf(CONF_PASSWORD, conf);
        if(StringUtils.isAnyEmpty(host,username)){
            throw new RuntimeException("missing configuration of host or username or password");
        }
        String s = getConf(CONF_PORT, conf);
        if (StringUtils.isNotEmpty(s)) {
            port = Integer.parseInt(s);
        }

        s = getConf(CONF_BYPASS_HOST_KEY_CHECKING, conf);
        if (StringUtils.isNotEmpty(s)) {
            byPassHostKeyChecking = Boolean.parseBoolean(s);
        }

        s = getConf(CONF_CONTEXT_PATH, conf);
        if (StringUtils.isNotEmpty(s)) {
            contextPath = regulateContextPath(s);
        }
    }

    static String regulateContextPath(String s) {
        if (!s.startsWith("/")) s = "/" + s;
        if (s.endsWith("/")) s = s.substring(0, s.length() - 1);
        return s;
    }

    private static String getConf(String key, Map conf) {
        Object o = null == conf ? null : conf.get(key);
        return null == o ? System.getProperty(key) : o.toString();
    }

    Session createSession() throws JSchException {
        JSch jSch = new JSch();
        Session session = jSch.getSession(username, host, port);
        if (StringUtils.isNotEmpty(password)) {
            session.setPassword(password);
        }
        if (byPassHostKeyChecking) {
            Properties p = new Properties();
            p.setProperty("StrictHostKeyChecking", "no");
            session.setConfig(p);
        }
        session.connect();
        return session;
    }

    String ensurePath(String path) {
        if (!path.startsWith("/")) path = "/" + path;

        String ctx = SFTP.oneTimeContext();
        if (null == ctx) ctx = contextPath;

        return path.startsWith(ctx) ? path : ctx + path;
    }
}
