package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * @Description: Bean 定义注册接口
 * @Author: matthew
 * @Date: 2023/1/2 23:23
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 判断是否包含指定名称的 BeanDefinition
     * @param name
     * @return
     */
    boolean containsBeanDefinition(String name);
}
