package cn.bugstack.springframework.test;

import cn.bugstack.springframework.aop.AdvisedSupport;
import cn.bugstack.springframework.aop.TargetSource;
import cn.bugstack.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.bugstack.springframework.aop.framework.Cglib2AopProxy;
import cn.bugstack.springframework.aop.framework.JdkDynamicAopProxy;
import cn.bugstack.springframework.test.bean.IUserService;
import cn.bugstack.springframework.test.bean.UserService;
import cn.bugstack.springframework.test.bean.UserServiceInterceptor;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Description: 测试类
 * @Author: matthew
 * @Date: 2023/1/2 23:31
 */
public class ApiTest {

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut =
                new AspectJExpressionPointcut("execution(* cn.bugstack.springframework.test.bean.UserService.queryUserInfo())");
        Class<UserService> userServiceClass = UserService.class;
        Method queryUserInfo = userServiceClass.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(userServiceClass));
        System.out.println(pointcut.matches(queryUserInfo, userServiceClass));
    }


    @Test
    public void test_dynamic() {
        // 目标对象
        UserService userService = new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.bugstack.springframework.test.bean.IUserService.*(..))"));
        advisedSupport.setTargetSource(new TargetSource(userService));

        //代理对象JDK
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 调用
        System.out.println("proxy_jdk测试结果"+proxy_jdk.queryUserInfo());

        //代理对象Cglib
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("proxy_cglib测试结果"+proxy_cglib.register("fuck"));
    }
}