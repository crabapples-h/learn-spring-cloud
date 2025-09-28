package cn.crabapples.wechatofficial.utils;

import cn.crabapples.common.ApplicationException;
import cn.crabapples.common.utils.AssertUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;


/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/31 18:41
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
public class WechatUtils {
    private static final Logger logger = LoggerFactory.getLogger(WechatUtils.class);
    private static final RestTemplate restTemplate = new RestTemplate();

    /**
     * 微信获取assertToken
     *
     * @param url 请求地址
     * @return 获取到的assertToken
     */
    public static String getAccessToken(String url) {
        logger.debug("准备从微信获取token");
        JSONObject result = restTemplate.getForObject(url, JSONObject.class);
        AssertUtils.notNull(result, "token获取失败");
        String token = String.valueOf(result.get("access_token"));
        AssertUtils.notNull(token, "token获取失败");
        logger.debug("获取token成功:[{}]", token);
        return token;
    }

    /**
     * 下载临时图片文件
     *
     * @param fileSavePath 文件保存路径
     * @param url          下载地址
     * @return 文件全路径
     */
    public static String downloadTempImageFile(String fileSavePath, String file, String url) {
        try {
            logger.debug("准备下载临时文件");
            byte[] result = restTemplate.getForObject(url, byte[].class);
            File path = new File(fileSavePath);
            if (path.exists() | path.mkdirs()) {
                File temp = new File(path.getPath() + "/" + file);
                assert result != null;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(result);
                FileOutputStream fileOutputStream = new FileOutputStream(temp);
                byte[] dataArray = new byte[1024];
                for (int i = 0; i != -1; i = byteArrayInputStream.read(dataArray)) {
                    fileOutputStream.write(dataArray, 0, i);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                logger.debug("临时文件下载完成,路径:[{}]", temp.getAbsolutePath());
                return temp.getAbsolutePath();
            }
        } catch (Exception e) {
            logger.warn("文件下载失败:[{}]", e.getMessage(), e);
        }
        throw new ApplicationException("文件下载失败");
    }
}
