package cn.bugstack.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 模拟用户的DAO
 * @Author: matthew
 * @Date: 2023/1/8 22:06
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行: init-method");
        hashMap.put("10001", "Matthew");
        hashMap.put("10002", "张允泊");
        hashMap.put("10003", "张一凡");
    }

    public void destroyDataMethod() {
        System.out.println("执行: destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
