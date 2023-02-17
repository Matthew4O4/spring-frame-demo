package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * Advice invoked before a method is invoked.
 * e.g. advices cannot prevent the method call proceeding,
 * unless they throw a Throwable
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    /**
     * 在调用 指定方法之前 调用
     * Callback before a given method is invoked.
     *
     * @param method method being invoked
     * @param args arguments to the method
     * @param target target of the method invocation. May be <code>null</code>
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the
     *                   caller if it's allowed by the method signature.
     *                   Other wishes the exception will be wrapped as
     *                   a runtime exception.
     */
    void before(Method method, Object[] args, Object target) throws Throwable;

}
