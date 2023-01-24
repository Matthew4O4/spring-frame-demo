package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @Description:
 * @Author: matthew
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws Exception {

        InvocationHandler handler = (proxy, method, args) -> {
            if ("toString".equals(method.getName())) return this.toString();

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "Matthew");
            hashMap.put("10002", "张允泊");
            hashMap.put("10003", "张一凡");

            return "你被代理了" + method.getName() + ":" + hashMap.get(args[0].toString());
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
