package cn.bugstack.springframework.test;

import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: matthew
 * @Date: 2023/1/2 23:31
 */
public class ApiTest {
    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2.获取 Bean 对象调用方法
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);
        // 3.配置 scope="prototype/singleton"
        System.out.println(userService1);
        System.out.println(userService2);
//        // 4.打印十六进制哈希
//        System.out.println(userService1 + "十六进制哈希" + Integer.toHexString(userService1.hashCode()));
//        System.out.println(ClassLayout.parseInstance(userService1).toPrintable());

    }

    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");

        applicationContext.registerShutdownHook();

        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService.queryUserInfo());
    }

}
