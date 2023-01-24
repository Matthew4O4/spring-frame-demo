package cn.bugstack.springframework.test.bean;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/2 23:30
 */
public class UserService {


    private UserDao userDao;


    public void queryUserInfo(String uId) {
        System.out.println(" 查询用户信息 :" + userDao.queryUserName(uId));
    }


}
