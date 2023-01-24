package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Description: 创建bean对象前修改BeanDefinition的属性
 * @Author: matthew
 */
public interface BeanFactoryProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后,实例化 Bean 对象之前,提供修改 BeanDefinition 属性机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
