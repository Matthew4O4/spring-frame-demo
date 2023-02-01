package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.BeanFactory;

/**
 * @Description: Extension of the {@link BeanFactory}
 *  interface to be implemented by Bean factories that are capable(有能力的) of
 *  autowiring , provided that they want to expose this functionality for
 *  existing bean instances.
 *
 *
 * @Author: matthew
 * @Date: 2023/1/12 14:59
 */
public interface AutowireCapableBeanFactory extends BeanFactory{

//    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean,String beanName);
//    Object applyBeanPostProcessorsAfterInitialization(Object existingBean,String beanName);

}
