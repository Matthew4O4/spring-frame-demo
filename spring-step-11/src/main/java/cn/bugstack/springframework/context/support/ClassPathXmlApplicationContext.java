package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: XML 文件应用上下文
 * Standalone XML application context definition files
 * from the class path, interpreting(解释) plain(基础) paths as class path resource names
 * that include that the package path (e.g. "mypackage/myresource.text). Useful for
 * that harnesses(利用) as well as for application contexts embedded(嵌入式) within(在..) JARs
 * <p>
 * ----
 * as well as :还有...
 * @Author: matthew
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition, 并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }


    /**
     * 从 XML 中加载 BeanDefinition, 并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    public String[] getConfigLocations() {
        return configLocations;
    }
}
