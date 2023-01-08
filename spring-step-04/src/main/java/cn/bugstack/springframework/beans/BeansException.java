package cn.bugstack.springframework.beans;

/**
 * @Description: 定义Bean异常
 * @Author: matthew
 * @Date: 2023/1/2 22:09
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
