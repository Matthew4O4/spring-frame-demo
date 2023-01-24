package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: 定义 Bean 工厂接口
 * @Author: matthew
 * @Date: 2023/1/2 22:06
 */
public interface BeanFactory {

    /**
     * 返回 Bean 的实例化对象
     *
     * @param name 需要检索的 bean 对象名称
     * @return 实例化的 bean 对象
     * @throws BeansException 不能获取 Bean 对象
     */
    Object getBean(String name) throws BeansException;

    /**
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requestType) throws BeansException;

}