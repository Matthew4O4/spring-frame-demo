package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.factory.ListableBeanFactory;

/**
 * @Description:
 *  应用上下文接口
 *  Central interface to provide configuration for an application.
 *  This is read-only while the application is running, but may be
 *  reloaded if the implementation supports this.
 * @Author: matthew
 */
public interface ApplicationContext extends ListableBeanFactory {

}
