package cn.crabapples.wechatofficial.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/31 18:41
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
public class AliUtils {
    private static final Logger logger = LoggerFactory.getLogger(AliUtils.class);
    private static final String END_POINT = "https://oss-cn-chengdu.aliyuncs.com";
    private static final String ACCESS_KEY_ID = "xxx";
    private static final String ACCESS_KEY_SECRET = "xxx";
    private static final String BUCKET_NAME = "crabapples";
    private static final String CONTENT_OF_TEXT = "text/";
    private static final String CONTENT_OF_FILE = "file/";

    /**
     * 上传文本到阿里云oss
     *
     * @param content 需要上传的文本
     */
    public static void putObject2Oss(String objectName, String content) {
        String name = CONTENT_OF_TEXT + objectName;
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ossClient.putObject(BUCKET_NAME, name, new ByteArrayInputStream(content.getBytes()));
        ossClient.shutdown();
    }

    /**
     * 上传byte数组到阿里云oss
     *
     * @param data 需要上传的byte数组
     */
    public static void putObject2Oss(String objectName, byte[] data) {
        String name = CONTENT_OF_FILE + objectName;
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ossClient.putObject(BUCKET_NAME, name, new ByteArrayInputStream(data));
        ossClient.shutdown();
    }

    /**
     * 上传字符串到阿里云oss
     *
     * @param inputStream 需要上传的网络流
     */
    public static void putObject2Oss(String objectName, InputStream inputStream) {
        String name = CONTENT_OF_FILE + objectName;
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        ossClient.putObject(BUCKET_NAME, name, inputStream);
        ossClient.shutdown();
    }

    /**
     * 上传文件到阿里云oss
     *
     * @param file 需要上传的文件
     */
    public static void putObject2Oss(String objectName, File file) {
        String name = CONTENT_OF_FILE + objectName;
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, name, file);
        ossClient.putObject(putObjectRequest);
        ossClient.shutdown();
    }


}
