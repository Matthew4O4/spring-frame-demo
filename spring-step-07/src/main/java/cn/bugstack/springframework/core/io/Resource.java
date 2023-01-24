package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 资源处理接口
 * @Author: matthew
 * @Date: 2023/1/10 11:39
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
