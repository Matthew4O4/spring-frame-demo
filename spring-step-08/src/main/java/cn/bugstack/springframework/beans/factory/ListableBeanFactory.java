package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Description:
 * Extension (扩展) of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate (列出) all their bean instances, rather than attempting(尝试) bean lookup
 * by name one by one as request by clients. BeanFactory implementations that
 * preload all their bean definitions (such as XML-based factories) may implement
 * this interface .
 *
 * @Author: matthew
 * @Date: 2023/1/12
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeanOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans definition in this registry
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
