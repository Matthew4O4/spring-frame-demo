package cn.bugstack.springframework.aop.framework;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/25 16:37
 */
public interface AopProxy {
    /**
     * 用于获取代理类
     * @return
     */
    Object getProxy();
}
