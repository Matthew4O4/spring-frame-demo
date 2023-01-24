package cn.bugstack.springframework.beans.factory;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/18 17:21
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
