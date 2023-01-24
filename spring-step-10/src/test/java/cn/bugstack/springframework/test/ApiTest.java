package cn.bugstack.springframework.test;

import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.event.CustomEvent;
import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: matthew
 * @Date: 2023/1/2 23:31
 */
public class ApiTest {

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 10086l, "super"));
        applicationContext.registerShutdownHook();
    }
}
