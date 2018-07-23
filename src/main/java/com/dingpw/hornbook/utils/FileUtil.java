package com.dingpw.hornbook.utils;

import com.dingpw.hornbook.ApplicationConfigure;
import io.minio.MinioClient;
import java.io.InputStream;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 18:09.
 */
public class FileUtil {

    public static void uploadByInputStream(String bucketName, String fileName,
        InputStream inputStream, String contentType) throws Exception {
        MinioClient minioClient = getMinioClient(bucketName);
        minioClient
            .putObject(bucketName, fileName, inputStream, inputStream.available(), contentType);
        inputStream.close();
    }

    public static String getFileUrl(String bucketName, String fileName) throws Exception {
        MinioClient minioClient = getMinioClient(bucketName);
        String url = minioClient.getObjectUrl(bucketName, fileName);
        return url;
    }

    public static String getFileUrlInMeta(String fileName) throws Exception {
        MinioClient minioClient = getMinioClient("hornbook-metadata");
        String url = minioClient.getObjectUrl("hornbook-metadata", fileName);
        return url;
    }

    private static MinioClient getMinioClient(String bucketName) throws Exception {
        MinioClient minioClient = new MinioClient(ApplicationConfigure.getFileDomain(),
            ApplicationConfigure.getFileAccessKey(), ApplicationConfigure.getFileSecretKey());
        boolean isExist = minioClient.bucketExists(bucketName);
        if (!isExist) {
            minioClient.makeBucket(bucketName);
        }
        return minioClient;
    }
}
