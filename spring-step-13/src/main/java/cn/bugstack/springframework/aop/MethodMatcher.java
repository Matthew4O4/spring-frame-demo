package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Description:
 * 方法匹配
 * Check whether(是否) the target method is eligible(符合条件) for advice
 * @Author: matthew
 * @Date: 2023/1/25 15:34
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
