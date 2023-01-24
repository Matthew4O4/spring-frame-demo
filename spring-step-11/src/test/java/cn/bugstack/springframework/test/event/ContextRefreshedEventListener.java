package cn.bugstack.springframework.test.event;

import cn.bugstack.springframework.context.ApplicationListener;
import cn.bugstack.springframework.context.event.ContextRefreshedEvent;

/**
 * @Description:
 * @Author: matthew
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件: " + this.getClass().getName());
    }
}
