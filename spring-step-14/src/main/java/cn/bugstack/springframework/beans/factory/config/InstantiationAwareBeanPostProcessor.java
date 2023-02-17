package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/31 16:45
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
