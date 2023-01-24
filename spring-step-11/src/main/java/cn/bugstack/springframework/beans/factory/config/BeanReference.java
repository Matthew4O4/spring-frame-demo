package cn.bugstack.springframework.beans.factory.config;

/**
 * @Description: Bean 引用
 * @Author: matthew
 * @Date: 2023/1/8 21:55
 */
public class BeanReference {


    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }


}
