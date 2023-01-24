package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.UserService;
import cn.bugstack.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.bugstack.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * @Description: 测试类
 * @Author: matthew
 * @Date: 2023/1/2 23:31
 */
public class ApiTest {
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1. 初始化BeanFactory 接口
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件,注册Bean对象
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成,在将Bean对象实例化之前,修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor myBeanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        myBeanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. 在 Bean 对象实例化后,修改 Bean 对象属性信息
        MyBeanPostProcessor myBeanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(myBeanPostProcessor);

        // 5. 获取 Bean 对象的调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);

        System.out.println(userService);
    }

    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取 Bean 对象调用方法
        applicationContext.refresh();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
    }

}
