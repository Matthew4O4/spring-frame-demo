package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.DisposableBean;
import cn.bugstack.springframework.beans.factory.InitializingBean;
import cn.bugstack.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Description: 实现默认 bean 创建的抽象 bean 工厂超类
 * @Author: matthew
 * @Date: 2023/1/2 22:57
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给 Bean 对象填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 注册实现了 DisposableBean 接口的 Bean 对象   Necessary(必要的)
        registerDisposableBeanIfNecessary(bean, beanName, beanDefinition);

        registerSingleton(beanName, bean);
        return bean;
    }

    protected void registerDisposableBeanIfNecessary(Object bean, String beanName, BeanDefinition beanDefinition) {
        if ((bean instanceof DisposableBean) || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition.getDestroyMethodName()));
        }
    }


    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorBeforeInitialization(bean, beanName);
        // 待完成
        try {
            invokerInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }
        // 2. 执行BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorAfterInitialization(bean, beanName);
        return wrappedBean;
    }


    public Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor process : getBeanProcessors()) {
            Object current = process.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }


    private void invokerInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 1. 实现InitializingBean 接口
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        // 2. 注解配置 init-method {判断是为了避免二次执行初始化}
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(bean instanceof InitializingBean)) {
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeansException("Cloud not find an init method named '" + initMethodName + "' on bean with name '" + beanName + " '");
            }
            initMethod.invoke(bean);
        }
    }


    public Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor process : getBeanProcessors()) {
            Object current = process.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws InstantiationException, IllegalAccessException {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 填充属性
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException(" Error setting property values: " + beanName);
        }
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

}
