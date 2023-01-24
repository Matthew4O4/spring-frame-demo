package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Description: 抽象基类刷新应用上下文 : 获取Bean 和 加载资源
 * Base class for {@link cn.bugstack.springframework.context.ApplicationContext}
 * implementations(安装\实施\实做\实现) which are supposed to support multiple calls to {@link #refresh()},
 * creating a new internal(内部) bean factory instance every time.
 * Typically(典型的), (but not necessarily(一定)), such a context will be driven by
 * a set of config locations to load bean definition from.
 * <p>
 * ----
 * every time 每一次
 * @Link:
 * @Author: matthew
 */
public abstract class AbstractRefreshableBeanFactory extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }


}
