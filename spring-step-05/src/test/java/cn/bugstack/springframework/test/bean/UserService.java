package cn.bugstack.springframework.test.bean;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/2 23:30
 */
public class UserService {

    private UserDao userDao;
    private String uId;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
