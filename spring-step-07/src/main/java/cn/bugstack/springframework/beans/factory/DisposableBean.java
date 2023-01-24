package cn.bugstack.springframework.beans.factory;

/**
 * @Description: Interface to be implemented by  beans that want to release(释放) resources
 * on destruction(破坏\销毁). A BeanFactory is supposed(应该) to invoke the destroy
 * method if it disposes a cached singleton. An application context
 * is supposed to dispose all of its singletons on close.
 * @Author: matthew
 * @Date: 2023/1/16 13:50
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
