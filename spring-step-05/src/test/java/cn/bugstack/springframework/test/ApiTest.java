package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.bugstack.springframework.core.io.DefaultResourceLoader;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.test.bean.UserDao;
import cn.bugstack.springframework.test.bean.UserService;
import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 测试类
 * @Author: matthew
 * @Date: 2023/1/2 23:31
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserDao.class);
        beanFactory.registerBeanDefinition("userDao", beanDefinition);

        // 3.使用UserService 填充属性 uId,userDao
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4.使用 UserService 注册 Bean 对象
        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", userServiceBeanDefinition);

        // 3.获取 Bean
        // 3.获取 BeanÎ
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        String result = userService_singleton.queryUserInfo();
        System.out.println("测试结果" + result);
    }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException{
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_file() throws IOException{
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url()throws IOException{
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        Resource resource = resourceLoader.getResource("src/test/resources/spring.xml");
        reader.loadBeanDefinitions(resource);

        // 3.获取Bean对象的调用方法
        UserService userService =(UserService) beanFactory.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());

    }
}
