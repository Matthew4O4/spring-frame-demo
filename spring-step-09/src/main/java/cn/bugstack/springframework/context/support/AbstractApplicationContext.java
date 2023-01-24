package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.context.ConfigurableApplicationContext;
import cn.bugstack.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Description: 抽象应用上下文
 * Doesn't mandate the type of storage used for configuration;
 * simply implements common context functionality. Uses the Template Method design pattern,
 * requiring concrete subclass to implement abstract method.
 * @Link: Abstract implementation of the  {@link cn.bugstack.springframework.context.ApplicationContext}
 * interface.
 * @Author: matthew
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1.创建 BeanFactory, 并加载BeanDefinition
        refreshBeanFactory();

        // 2.获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3.添加 ApplicationContextAwareProcessor 类, 让继承自
        // ApplicationContextAware 的 Bean 对象感知所属 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 5.在 Bean 实例化之前,执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 6.BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 7.提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }


    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanOfType = beanFactory.getBeanOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanOfType.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanOfType = beanFactory.getBeanOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanOfType.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }


    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();


    @Override
    public <T> Map<String, T> getBeanOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeanOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requestType) throws BeansException {
        return getBeanFactory().getBean(name, requestType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
