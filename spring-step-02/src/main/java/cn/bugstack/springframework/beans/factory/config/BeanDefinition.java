package cn.bugstack.springframework.beans.factory.config;

/**
 * @Description: 定义Bean 实例信息
 * @Author: matthew
 * @Date: 2023/1/2 22:03
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
