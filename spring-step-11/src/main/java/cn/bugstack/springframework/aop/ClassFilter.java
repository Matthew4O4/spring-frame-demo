package cn.bugstack.springframework.aop;

/**
 * @Description: 用于帮助切点找到给定的接口和目标类
 * <p>
 * Filter that restricts(限定) matching of a pointcut or introduction(介绍) to
 * a given set fo target classes
 * @Author: matthew
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
