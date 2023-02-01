package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Support base class for singleton registries which need to handle
 * {@link cn.bugstack.springframework.beans.factory.FactoryBean} instances,
 * integrated with {@link DefaultSingletonBeanRegistry}'s singleton management
 * @Author: matthew
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    /**
     * Cache singleton object created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != NULL_OBJECT ? object : null);
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    /**
     * 获取 FactoryBean#getObject 的方法,因为既要处理缓存又要获取对象
     * 所以额外提供了 doGetObjectFromFactoryBean 方法进行逻辑包装,
     *
     * @param factory
     * @param beanName
     * @return
     */
    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object [" + beanName + "] creation", e);
        }
    }

}
