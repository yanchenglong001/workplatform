package com.ycl.dao.user;

import java.util.List;

import com.ycl.bean.manager.user.TUser;

/**
 * 用户dao
 * @author Administrator
 *
 */
public interface IUserDao {
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
     * 根据登录用户名获取用户信息
     * @param loginId
     * @return 用户信息
     */
    TUser findByLoginName(String loginId);

    /**
     * 获取所有账号
     * @return
     */
    List<TUser> getAllUser();

    /**
     * 新建用户
     * @param user
     * @return
     */
    int addUser(TUser user) throws Exception;

    /**
     * 更新用户
     * @param user
     * @return
     * @throws Exception
     */
    int updateUser(TUser user) throws Exception;
}
