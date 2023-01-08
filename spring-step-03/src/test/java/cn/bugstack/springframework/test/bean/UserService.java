package cn.bugstack.springframework.test.bean;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/2 23:30
 */
public class UserService {
    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {
    }


    public void queryUserInfo() {
        System.out.println(" 查询用户信息 " + name);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(name);
        return sb.toString();
    }
}
