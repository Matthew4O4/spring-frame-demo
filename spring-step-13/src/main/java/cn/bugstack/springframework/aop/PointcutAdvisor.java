package cn.bugstack.springframework.aop;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/31 15:08
 */
public interface PointcutAdvisor extends Advisor {
    /**
     * Get the pointcut that drives advisor.
     */
    Pointcut getPointcut();
}
