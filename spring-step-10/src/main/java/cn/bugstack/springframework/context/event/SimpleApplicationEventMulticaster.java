package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.bugstack.springframework.context.ApplicationListener;
import cn.bugstack.springframework.context.support.ApplicationEvent;

/**
 * @Description:
 * @Author: matthew
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public  SimpleApplicationEventMulticaster(ConfigurableBeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
