package cn.bugstack.springframework.test.common;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryProcessor;

/**
 * @Description:
 * BeanFactoryPostProcessor 实例化 Bean 对象之前,修改BeanDefinition 属性
 * @Author: matthew
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company","修改后: google"));
    }
}
