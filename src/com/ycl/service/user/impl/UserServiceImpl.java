package com.ycl.service.user.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.cache.UserInfoList;
import com.ycl.common.constants.CommonConstants;
import com.ycl.dao.user.IUserDao;
import com.ycl.service.user.IUserService;

/**
 * 用户服务
 * @author Administrator
 *
 */
@Repository("userService")
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;

    @Override
    public TUser getUserById(String id) {

        return userDao.getUserById(id);
    }

    @Override
    public List<TUser> getLoginUser(String loginId, String password) {
        return userDao.getLoginUser(loginId, password);
    }

    @Override
    public TUser findByLoginName(String loginId) {

        return userDao.findByLoginName(loginId);
    }

    @Override
    public int addUser(TUser user) {

        try {
            int result = userDao.addUser(user);
            UserInfoList.getInstance().addUser(user);
            return result;
        } catch (Exception e) {
            logger.error("新增用户错误：", e);
            return CommonConstants.NumberConstant.MINUS_ONE.getValue();
        }
    }

    @Override
    public List<TUser> getAllUser() {

        return userDao.getAllUser();
    }

    @Override
    public int updateUser(TUser user) {
        try {
            int result = userDao.updateUser(user);
            UserInfoList.getInstance().updateUser(user);
            return result;
        } catch (Exception e) {
            logger.error("更新用户错误：", e);
            return CommonConstants.NumberConstant.MINUS_ONE.getValue();
        }

    }

}
