package cn.bugstack.springframework.context.support;

/**
 * @Description:
 * ApplicationEventPublish 是事件发布接口,所有事件都要通过这个接口发布出去
 * @Author: matthew
 */
public interface ApplicationEventPublisher {

    /**
     *
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
