package org.kly.javaCode.others;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * SFTP 应用服务
 *
 * @author david
 * @version 1.0
 * @created 2018/8/6 上午11:15
 **/
@Slf4j
public class SFTPClient extends SFTP {

    private static final Logger LOG = Logger.getLogger(SFTPClient.class.getName());

    private CryptoUtils cryptoUtils;

    private boolean runCrypto;


    public SFTPClient(SftpConfig sftpConfig) {
        this(sftpConfig, null);
    }

    public SFTPClient(SftpConfig sftpConfig, String secretKey) {
        this(sftpConfig, false, secretKey, "AES");

    }

    public SFTPClient(SftpConfig sftpConfig, boolean runCrypto, String secretKey, String algorithm) {
        super(sftpConfig);
        this.runCrypto = runCrypto;
        if (runCrypto) {
            this.cryptoUtils = new CryptoUtils(secretKey, algorithm);
        }
    }

    public String copy(String source, String target) throws Exception {
        ChannelSftp sftpChannel = channel();
        copyInternal(sftpChannel, source, target);
        shutdown();
        LOG.info("Copied files successfully...");

        return target;
    }

    public String copyLatest(String source, String target) throws Exception {
        ChannelSftp sftpChannel = channel();
        String latestSource = getLatestSource(sftpChannel, source);
        copyInternal(sftpChannel, latestSource, target);
        shutdown();
        LOG.info("Copied files successfully...");

        return getCopiedFilePath(latestSource, target);
    }



    public String copyToFTP(String source, String target) throws Exception {
        ChannelSftp sftpChannel = channel();
        copyInternalToFTP(sftpChannel, source, target);
        shutdown();
        LOG.info("Copied files successfully...");

        return target;
    }

    private String getCopiedFilePath(String latestSource, String target) {
        String copiedFileName = FilenameUtils.getName(latestSource);
        return FilenameUtils.concat(target, copiedFileName);
    }

    private String getLatestSource(ChannelSftp sftpChannel, String source) throws Exception {
        Vector ls = sftpChannel.ls(source);

        String basePath = FilenameUtils.getPath(source);
        if (!basePath.startsWith("/")) {
            basePath = "/" + basePath;
        }

        LOG.fine("Base Path : " + basePath);
        int latestModTime = 0;
        String fileName = FilenameUtils.getBaseName(source);
        for (int i = 0, size = ls.size(); i < size; i++) {
            LsEntry entry = (LsEntry) ls.get(i);
            int modTime = entry.getAttrs().getMTime();
            if (latestModTime < modTime) {
                latestModTime = modTime;
                fileName = entry.getFilename();
            }
        }

        return FilenameUtils.concat(basePath, fileName);
    }



    private void copyInternal(ChannelSftp sftpChannel, String source, String target) throws Exception {
        source = getConfig().ensurePath(source);
        LOG.info("Copying file from " + source + " to " + target);


        try {
            sftpChannel.cd(source);
            createLocalDir(target, false);
//            copyDir(sftpChannel, source, target);
        } catch (Exception e) {
            // Source is a file
            createLocalDir(target, true);
            sftpChannel.get(source, target);
            decrypt(target);
        }
    }

    /**
     * 创建本地文件
     *
     * @param target
     * @param isFile
     */
    private void createLocalDir(String target, boolean isFile) {
        if (isFile) {
            target = target.substring(0, target.lastIndexOf("/"));
        }
        File file = new File(target);
        if (!file.exists())
            file.mkdirs();
    }




    private void decrypt(String fileLocation) throws Exception {
        if (runCrypto) {
            LOG.info("Decrypting " + fileLocation);
            String tempFileLocation = fileLocation + ".temp";
            File tempFile = new File(tempFileLocation);
            File actualFile = new File(fileLocation);
            FileUtils.moveFile(actualFile, tempFile);

            cryptoUtils.decrypt(tempFile, actualFile);

            FileUtils.deleteQuietly(tempFile);
        }
    }

    private void copyInternalToFTP(ChannelSftp sftpChannel, String source, String target) throws Exception {
        LOG.info("Copying files from " + source + " to " + target);
        try {
            // Source is a dir
            sftpChannel.lcd(source);
            autoCreateDirByTarget(sftpChannel, target, false);
            copyDirToFTP(sftpChannel, source, getConfig().ensurePath(target));
        } catch (Exception e) {
            // Source is a file
            autoCreateDirByTarget(sftpChannel, target, true);
            encrypt(source);
            sftpChannel.put(source, getConfig().ensurePath(target));
        }
    }

    /**
     * 自动创建文件夹
     *
     * @param sftpChannel
     * @param target
     * @param isFile
     */
    private void autoCreateDirByTarget(ChannelSftp sftpChannel, String target, boolean isFile) throws SftpException {
        try {
            sftpChannel.cd(getConfig().ensurePath(target));
        } catch (Exception e) {
            LOG.info("Copying files start mkdir " + target);
            String[] paths = target.split("/");
            String targetPath = "";
            for (int i = 0; i < paths.length; i++) {
                if (isFile && (i == paths.length - 1)) {
                    continue;
                }
                String path = paths[i];
                if (StringUtils.isNotEmpty(path)) {
                    targetPath = targetPath + File.separator + path;
                    String tmpPath = getConfig().ensurePath(targetPath);
//                    log.info("Copying files auto mkdir " + tmpPath);
                    try {
                        sftpChannel.cd(tmpPath);
                    } catch (Exception e1) {
                        sftpChannel.mkdir(tmpPath);
                    }
                }
            }
        }
    }


    private void copyDirToFTP(ChannelSftp sftpChannel, String source, String target) throws Exception {
        LOG.info("Copying files from " + source + " to " + target);

        sftpChannel.lcd(source);
        sftpChannel.cd(target);

        Collection<File> childFiles = FileUtils.listFiles(new File(source), null, false);
        for (File file : childFiles) {
            String entryName = file.getName();
            LOG.fine("File Entry " + entryName);

            if (!entryName.equals(".") && !entryName.equals("src/main")) {
                if (file.isDirectory()) {
                    copyInternalToFTP(sftpChannel, source + entryName + "/", target);
                } else {
                    LOG.info("Copying file " + entryName);
                    encrypt(source + File.separator + entryName);
                    sftpChannel.put(entryName, entryName, new ProgressMonitor());
                }
            }
        }
    }

    private void encrypt(String fileLocation) throws Exception {
        if (runCrypto) {
            LOG.info("Encrypting " + fileLocation);
            String tempFileLocation = fileLocation + ".temp";
            File tempFile = new File(tempFileLocation);
            File actualFile = new File(fileLocation);
            FileUtils.moveFile(actualFile, tempFile);

            cryptoUtils.encrypt(tempFile, actualFile);

            FileUtils.deleteQuietly(tempFile);
        }
    }
}
