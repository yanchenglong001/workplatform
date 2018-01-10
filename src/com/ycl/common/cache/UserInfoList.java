package com.ycl.common.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.ycl.bean.manager.user.TUser;

/**
 * 用户缓存
 * @author huayu
 *
 */
public class UserInfoList {

    private Map<String, TUser> userMap = new HashMap<String, TUser>();

    /** 单例实例 */
    private static UserInfoList m_instance = new UserInfoList();

    /** 隐藏构造方法 */
    private UserInfoList() {
    }

    /** 获得实例 */
    public static UserInfoList getInstance() {
        return m_instance;
    }

    /**
     * 加载所有用户
     * @param users
     */
    public void loadAllUser(List<TUser> users) {
        userMap.clear();
        for (TUser user : users) {
            userMap.put(user.getcId(), user);
        }
    }

    /**
     * 添加用户
     * @param user
     */
    public void addUser(TUser user) {
        if (user == null) {
            return;
        }
        if (!userMap.containsKey(user.getcId())) {
            userMap.put(user.getcId(), user);
        }
    }

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(TUser user) {
        if (user == null) {
            return;
        }
        if (userMap.containsKey(user.getcId())) {
            userMap.put(user.getcId(), user);
        }
    }

    /**
     * 删除用户
     * @param user
     */
    public void deleteUser(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return;
        }
        userMap.remove(userId);
    }

    /**
     * 
     * @return
     */
    public TUser getUserById(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        return userMap.get(userId);
    }

    /**
     * 
     * @return
     */
    public TUser getUserByLoginId(String loginId) {

        if (StringUtils.isEmpty(loginId)) {
            return null;
        }

        for (Map.Entry<String, TUser> entry : userMap.entrySet()) {
            if (loginId.equals(entry.getValue().getcLoginId())) {
                return entry.getValue();
            }
        }
        return null;
    }

}
