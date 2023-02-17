package cn.bugstack.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 包装切面通知信息
 * Base Class for AOP proxy configuration managers.
 * These are not themselves(他们自己) AOP  proxies.
 * but subclasses of this class are normally factories
 * from which AOP proxy instances are obtained directly.
 * <p>
 * adj. 形容
 * v.   动词
 * n.   名词
 * adv. 副词
 * pron.代词
 * conj.连词
 *
 * @Description:
 * @Author: matthew
 */
public class AdvisedSupport {
    /**
     * ProxyConfig
     */
    private boolean proxyTargetClass = false;
    /**
     * 被代理目标对象
     */
    private TargetSource targetSource;
    /**
     * 方法拦截器
     */
    private MethodInterceptor methodInterceptor;
    /**
     * 方法匹配器(检查目标方法是否符合通知条件)
     */
    private MethodMatcher methodMatcher;

    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
