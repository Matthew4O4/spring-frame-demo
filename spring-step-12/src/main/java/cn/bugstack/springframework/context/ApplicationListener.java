package cn.bugstack.springframework.context;

import cn.bugstack.springframework.context.support.ApplicationEvent;

import java.util.EventListener;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/21 19:14
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * the event to respond to
     * @param event
     */
    void onApplicationEvent(E event);
}
