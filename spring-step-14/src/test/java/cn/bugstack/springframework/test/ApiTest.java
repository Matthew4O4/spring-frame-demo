package cn.bugstack.springframework.test;

import cn.bugstack.springframework.aop.AdvisedSupport;
import cn.bugstack.springframework.aop.ClassFilter;
import cn.bugstack.springframework.aop.MethodMatcher;
import cn.bugstack.springframework.aop.TargetSource;
import cn.bugstack.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.bugstack.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.bugstack.springframework.aop.framework.ProxyFactory;
import cn.bugstack.springframework.aop.framework.ReflectiveMethodInvocation;
import cn.bugstack.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.IUserService;
import cn.bugstack.springframework.test.bean.UserService;
import cn.bugstack.springframework.test.bean.UserServiceBeforeAdvice;
import cn.bugstack.springframework.test.bean.UserServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 测试类
 *
 * 目前.在Spring框架中添加的功能都是在 AOP IOC 上扩展
 * 这些扩展的功能完善了Bean的生命周期
 *
 * ---
 * 我们也可以将如何动态切换数据源\线程池是如何提供配置等
 *
 *
 *
 *
 * @Author: matthew
 * @Date: 2023/1/2 23:31
 */
public class ApiTest {
    @Test
    public void test_property(){
        // 注解扫描路径
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");

        // Test
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(" 测试结果: "+ userService);
    }

    /**
     * scanscanscanscanscanscan.
     */
    @Test
    public void test_scan(){
            // get every item package
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println(userService);
    }

}