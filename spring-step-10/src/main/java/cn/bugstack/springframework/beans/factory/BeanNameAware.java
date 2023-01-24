package cn.bugstack.springframework.beans.factory;

/**
 * @Description:
 * Interface to be implemented by beans that want to be aware of their
 * bean name in a bean factory. Note that it is not usually recommended(推荐)
 * that an object depend on its bean name, as this represents(代表) a potentially(潜在的)
 * brittle(脆) dependence on external(外部) configuration, as well as a possibly(可能的)
 * unnecessary(不必要的) dependence on a Spring API.
 * @Author: matthew
 * @Date: 2023/1/17 16:19
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
