package cn.bugstack.springframework.core.io;

/**
 * @Description: 资源加载器
 * @Author: matthew
 * @Date: 2023/1/10 13:16
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
