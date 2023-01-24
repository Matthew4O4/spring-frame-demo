package cn.bugstack.springframework.util;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/10 11:46
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
