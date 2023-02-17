package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/2 23:30
 */
@Component(value = "userService")
public class UserService implements IUserService {


    private String uId;

    private String company;

    private String location;

    private String token;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return uId;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "注册用户: " + userName + "success! ";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
