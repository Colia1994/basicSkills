package org.kly.javaCode.others;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * SFTP 会话管理
 *
 * @author david
 * @version 1.0
 * @created 2018/8/6 上午11:15
 **/
@Slf4j
public class SFTP {

    private static final ThreadLocal<ChannelSftp> current = new ThreadLocal<ChannelSftp>();

    private static final String STR_SFTP = "sftp";
    @Getter
    private SftpConfig config;

    protected Session session;


    public SFTP(SftpConfig sftpConfig) {
        config = sftpConfig;
    }

    /**
     * 获取当前SFTP会话
     *
     * @return
     * @throws JSchException
     */
    public Session getSession() throws JSchException {
        if (!isActive()) startup();
        return session;
    }

    /**
     * 获取channel
     *
     * @return
     * @throws JSchException
     */
    public ChannelSftp channel() throws JSchException {
        ChannelSftp ch = current.get();
        if (null == ch || !ch.isConnected()) {
            ch = newChannel();
            current.set(ch);
        }
        return ch;
    }

    /**
     * 基于当前连接创建Channel
     *
     * @return
     * @throws JSchException
     */
    private ChannelSftp newChannel() throws JSchException {
        ChannelSftp ch = (ChannelSftp) getSession().openChannel(STR_SFTP);
        ch.connect();
        return ch;
    }

    /**
     * 启动SFTP连接
     *
     * @throws JSchException
     */
    public synchronized void startup() throws JSchException {
        if (isActive()) return;
        session = config.createSession();
    }

    /**
     * 释放SFTP连接
     */
    public void shutdown() {
        if (!isActive()) return;
        session.disconnect();
        session = null;
    }

    /**
     * 会话是否存活
     *
     * @return
     */
    boolean isActive() {
        return null != session && session.isConnected();
    }

    private static final ThreadLocal<String> oneTimeCtx = new ThreadLocal<String>();

    static String oneTimeContext() {
        return oneTimeCtx.get();
    }

    static void clearOneTimeContext() {
        oneTimeCtx.remove();
    }


}
