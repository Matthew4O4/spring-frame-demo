package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.context.support.ApplicationEvent;

/**
 * @Description:
 * Base class for events raised for an <code>ApplicationContext</code>
 * @Author: matthew
 */
public class ContextClosedEvent extends ApplicationEvent {
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
