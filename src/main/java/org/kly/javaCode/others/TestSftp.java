package org.kly.javaCode.others;

import com.jcraft.jsch.JSchException;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @Author konglingyao
 * @Date 2020/12/21
 */
@Slf4j
public class TestSftp {

    public boolean setup() {
        Properties conf = new Properties();
        conf.setProperty(SftpConfig.CONF_BYPASS_HOST_KEY_CHECKING, "true");
        conf.setProperty(SftpConfig.CONF_HOST, sftpProperties.getHost());
        conf.setProperty(SftpConfig.CONF_USERNAME, sftpProperties.getUsername());
        conf.setProperty(SftpConfig.CONF_PASSWORD, sftpProperties.getPassword());
        conf.setProperty(SftpConfig.CONF_PORT, String.valueOf(sftpProperties.getPort()));
        conf.setProperty(SftpConfig.CONF_CONTEXT_PATH, FilePathHelp.build(sftpPathProperties.getRemote()).getPath());
        SftpConfig sftpConfig = new SftpConfig(conf);
        log.info("【差错补账文件】：连接服务器信息：" + JSON.toJSONString(sftpConfig));

        sftpClient = new SFTPClient(sftpConfig);
        try {
            sftpClient.startup();
        } catch (JSchException e) {
            log.warn("【差错补账文件】：连接服务器异常：{}，传输终止！", e.getMessage(), e);
            return false;

        }
        log.info("【差错补账文件】：连接服务器正常！");
        return true;
    }
}
