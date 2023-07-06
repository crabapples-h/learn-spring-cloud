package cn.crabapples.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 静态资源虚拟路径配置文件
 * 使用springboot时才使用此配置文件
 */
//@Configuration
public class ResourceConfigure implements WebMvcConfigurer {
    //文件存储路径
    @Value("${uploadPath}")
    private String uploadPath;
    //文件访问路径
    @Value("${virtualPath}")
    private String virtualPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getVirtualPath() {
        return virtualPath;
    }

    public void setVirtualPath(String virtualPath) {
        this.virtualPath = virtualPath;
    }

    /**
     * 虚拟路径配置
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(virtualPath + "/**").addResourceLocations("file:" + uploadPath + "/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
