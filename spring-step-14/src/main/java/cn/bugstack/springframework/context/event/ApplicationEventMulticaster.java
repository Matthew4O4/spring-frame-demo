package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.context.ApplicationListener;
import cn.bugstack.springframework.context.support.ApplicationEvent;

/**
 * @Description: 事件广播器
 * @Author: matthew
 */
public interface ApplicationEventMulticaster {


    /**
     * Add a listener to be notified of events.
     * 添加监听
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * 删除监听
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * 广播事件
     */
    void multicastEvent(ApplicationEvent event);
}
