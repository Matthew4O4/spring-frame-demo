package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Description:
 * 抽象基类 XML 上下文
 * -----
 * Convenient(方便|便利) base class for {@link cn.bugstack.springframework.context.ApplicationContext}
 * implementations, drawing(画) configuration from XML documents containing(包含) bean definitions
 * understood(被充分理解的) by an {@link XmlBeanDefinitionReader}
 * @Author: matthew
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableBeanFactory{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
