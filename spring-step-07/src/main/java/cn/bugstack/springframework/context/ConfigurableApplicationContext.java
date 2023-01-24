package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: SPI 接口配置应用上下文
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition(除了)
 * to the application context client methods in the {@link ApplicationContext} interface
 * @Author: matthew
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

}
