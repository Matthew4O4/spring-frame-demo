package cn.bugstack.springframework.test.event;

import cn.bugstack.springframework.context.ApplicationListener;
import cn.bugstack.springframework.context.event.ContextClosedEvent;
import cn.bugstack.springframework.context.event.ContextRefreshedEvent;

/**
 * @Description:
 * @Author: matthew
 */
public class ContextCloseEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件: " + this.getClass().getName());
    }
}
