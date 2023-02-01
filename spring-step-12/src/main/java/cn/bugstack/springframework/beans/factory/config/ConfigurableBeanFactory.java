package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Description: Configuration interface to be implemented by most bean factories . Provides
 * facilities(设施工具) to configure a bean factory , in addition to the bean factory
 * client methods in the {@link cn.bugstack.springframework.beans.factory.BeanFactory}
 * @Author: matthew
 * @Date: 2023/1/12 15:10
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例实体对象
     */
    void destroySingletons();
}
