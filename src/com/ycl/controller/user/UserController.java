package com.ycl.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.cache.UserInfoList;
import com.ycl.common.constants.CommonConstants.NValid;
import com.ycl.common.constants.CommonConstants.NumberConstant;
import com.ycl.common.constants.CommonConstants.UserState;
import com.ycl.common.controller.BaseController;
import com.ycl.common.util.CommonUtil;
import com.ycl.common.util.EndecryptUtils;
import com.ycl.service.user.IUserService;

/**
 * 用户controller
 * @author huayu
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    //    @Named("userService")
    private IUserService userService;

    /**
     * 显示用户管理页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String userList(HttpServletRequest request) {
        String limit = request.getParameter("limit");
        String fyid = request.getParameter("fyid");
        return "user/userlist";
    }

    /**
     * 显示用户信息、新增、编辑、注册、忘记密码
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/showuser", method = RequestMethod.GET)
    public String showUser(Model model, HttpServletRequest request) {
        String method = request.getParameter("method");
        model.addAttribute("method", method);
        String userId = request.getParameter("userId");
        TUser user = UserInfoList.getInstance().getUserById(userId);
        if (user == null) {
            user = new TUser();
        }
        model.addAttribute("user", user);
        return "user/user";
    }

    /**
     * 新增、编辑用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> user(HttpServletRequest request) {
        // 返回结果
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            // 判断用户登录名、密码不能为空
            String loginId = request.getParameter("cLoginId");
            String cPassword = request.getParameter("cPassword");
            if (StringUtils.isEmpty(loginId)) {
                return getErrorMap("登录用户名不能为空！");
            }
            if (StringUtils.isEmpty(cPassword)) {
                return getErrorMap("密码不能为空！");
            }
            // 用户id
            String cId = request.getParameter("cId");
            TUser user = null;
            TUser curUser = getCurrentUser();
            boolean isInsert = true;
            // 判断是新增还是更新用户
            if (StringUtils.isEmpty(cId)) {
                // 新建用户
                user = new TUser();
                // 设置id
                user.setcId(CommonUtil.getUUID());
                // 设置创建时间
                user.setdCreateDate(new Date());
                // 设置创建用户（如果是注册用户，则没有登录用户信息）
                if (curUser != null) {
                    user.setcCreateUser(curUser.getcId());
                }
            } else {
                // 更新用户
                isInsert = false;
                user = userService.getUserById(cId);
                if (user == null) {
                    return getErrorMap("用户不存在！");
                }
                // 设置更新时间
                user.setdUpdateDate(new Date());
                // 设置更新用户
                user.setcUpdateUser(curUser.getcId());
            }
            // 判断登录名不能重复
            Map<String, Object> isExistLoginIdMap = isExistLoginId(loginId,
                isInsert, user.getcId());
            if (isExistLoginIdMap != null) {
                return isExistLoginIdMap;
            }
            // 设置用户登录id
            user.setcLoginId(loginId);
            // 设置用户名
            String cName = request.getParameter("cName");
            user.setcName(cName);
            // 设置盐值
            user.setcSalt(EndecryptUtils.getSlat());
            //        user.setcSalt(user.getcLoginId());

            //        user.setcPassword(EndecryptUtils.getMd52Base64Password(
            //            user.getcLoginId(), "123", user.getcSalt()));
            // 设置密码
            user.setcPassword(EndecryptUtils.getMd5Password(cPassword,
                user.getcSalt(), NumberConstant.TWO.getValue()));
            // 设置状态
            String nState = request.getParameter("nState");
            if (!StringUtils.isEmpty(nState)) {
                user.setnState(Integer.valueOf(nState));
            } else {
                user.setnState(UserState.UNAUTHORIZED.getValue());
            }

            // 设置是否有效
            String nValid = request.getParameter("nValid");
            if (!StringUtils.isEmpty(nValid)) {
                user.setnValid(Integer.valueOf(nValid));
            } else {
                user.setnValid(NValid.VALID.getValue());
            }
            // 新增或更新用户
            if (isInsert) {
                userService.addUser(user);
            } else {
                userService.updateUser(user);
            }
            result.put("success", true);
            result.put("msg", "操作成功!");
        } catch (NullPointerException e) {
            logger.error("操作错误：", e);
            return getErrorMap("操作错误!");
        } catch (Exception e) {
            logger.error("操作错误：", e);
            return getErrorMap("操作错误!");
        }
        return result;
    }

    /**
     * 判断登录用户名是否存在
     * @param loginId 登录id
     * @param isInsert 是否为新增：true：新增；false：更新
     * @param userId 如果是更新，则判断是否为同一个用户
     * @return
     */
    private Map<String, Object> isExistLoginId(String loginId, boolean isInsert,
            String userId) {
        // 判断登录名不能重复
        TUser oldUser = userService.findByLoginName(loginId);
        if (isInsert && oldUser != null) {
            // 非本身登录用户名数据存在则登录用户名重复
            return getErrorMap("登录用户名重复！");

        }

        // 非本身登录用户名数据存在则登录用户名重复
        if (oldUser != null && !StringUtils.equals(userId, oldUser.getcId())) {
            return getErrorMap("登录用户名重复！");
        }
        return null;
    }

}
