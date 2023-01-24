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


    private String initMethodName;
    private String destroyMethodName;

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

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
