package cn.bugstack.springframework.aop;


/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/25 15:33
 */
public interface Pointcut {

    /**
     *
     */
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
