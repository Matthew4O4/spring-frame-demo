package cn.bugstack.springframework.beans.factory;

/**
 * @Description: 实现此接口的 Bean 对象,会在 BeanFactory 设置属性后做出相应处理
 * e.g. 设置初始化或者仅仅检查是否设置了所有强制属性.
 * @Author: matthew
 * @Date: 2023/1/16 12:53
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用.
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
