package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 * @Description: BeanDefinition 阅读器的模板接口
 *               Simple interface for bean definition readers.
 *               这是一样个用于读取 Bean 对象定义的简单接口
 *               其中 getRegistry 和 getResourceLoader 方法,
 *               他们都为加载Bean对象定义的方法提供了工具,
 *               这两个方法的实现会被包装到抽象类中,以免与具体的接口实现冲突.
 * @Author: matthew
 * @Date: 2023/1/10 13:28
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
