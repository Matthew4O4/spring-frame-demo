package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.PropertyValues;

/**
 * @Description: 定义Bean 实例信息
 * @Author: matthew
 * @Date: 2023/1/2 22:03
 */
public class BeanDefinition {
    private Class beanClass;

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
