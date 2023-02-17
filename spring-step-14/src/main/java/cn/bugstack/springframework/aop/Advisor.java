package cn.bugstack.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Description: 访问者
 * Base interface holding AOP <b>advice</b> (action to take a join point)
 * and a filter determining(确定\决定) the applicability(适用性) of the advice
 * (such as a pointcut).
 * <i>This interface is not for use by Spring users,
 * but to allow for commonality(共性) in support for different types of advice.
 * </i>
 * @Author: matthew
 * @Date: 2023/1/31 15:06
 */
public interface Advisor {
    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc(等等).
     * @return
     */
    Advice getAdvice();
}
