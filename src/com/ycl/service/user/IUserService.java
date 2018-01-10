package com.ycl.service.user;

import java.util.List;

import com.ycl.bean.manager.user.TUser;

/**
 * 用户服务
 * @author Administrator
 *
 */
public interface IUserService {

    /**
     * 根据id获取用户信息
     * @param id
     * @return 用户信息
     */
    TUser getUserById(String id);

    /**
     * 根据条件查询用户信息
     * @param loginId 登录名
     * @param password 密码
     * @return 用户信息
     */
    List<TUser> getLoginUser(String loginId, String password);

    /**
     * 根据登录用户名查询用户信息
     * @param loginId 登录名
     * @return 用户信息
     */
    TUser findByLoginName(String loginId);

    /**
     * 获取所有用户
     * @return
     */
    List<TUser> getAllUser();

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(TUser user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(TUser user);

}
