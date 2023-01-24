package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanClassLoaderAware;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeanFactoryAware;
import cn.bugstack.springframework.beans.factory.BeanNameAware;
import cn.bugstack.springframework.context.ApplicationContext;
import cn.bugstack.springframework.context.ApplicationContextAware;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/2 23:30
 */
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                ", uId='" + uId + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    private UserDao userDao;
    private String uId;

    private String company;

    private String location;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean ClassLoader is:" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
