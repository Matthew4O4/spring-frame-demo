package cn.bugstack.springframework.aop;

/**
 * @Description: 被代理目标对象
 * @Author: matthew
 */
public class TargetSource {
    private Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * 获得所有的接口类型
     */
    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }


    /**
     *
     */
    public Object getTarget() {
        return this.target;
    }


}
