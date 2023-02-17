package cn.bugstack.springframework.test.bean;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/24 23:26
 */
public interface IUserService {

    String queryUserInfo();

    String register(String userName);
}
