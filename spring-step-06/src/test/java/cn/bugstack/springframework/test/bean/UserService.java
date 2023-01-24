package cn.bugstack.springframework.test.bean;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/2 23:30
 */
public class UserService {

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                ", uId='" + uId + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    private UserDao userDao;
    private String uId;

    private String company;

    private String location;

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
