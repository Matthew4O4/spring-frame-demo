package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.context.ApplicationContext;
import cn.bugstack.springframework.context.ApplicationContextAware;

/**
 * 包装处理器
 *
 * @Description: 通过 BeanPostProcessor 实现类感知应用上下文
 * @Author: matthew
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 由于不能直接在创建Bean的时候获得 ApplicationContext 属性,
     * 所以需要在执行 refresh 时,
     * 将 ApplicationContext 写入一个包装的 BeanPostProcessor 类中,
     * 再使用:
     * AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization
     * 方法调用时获得ApplicationContext属性.
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
