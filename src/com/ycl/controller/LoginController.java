package com.ycl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.cache.UserInfoList;
import com.ycl.common.controller.BaseController;
import com.ycl.common.exception.UserStateException;
import com.ycl.service.user.IUserService;

/**
 * 登录用controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;

    /**
     * 登录页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/showlogin", method = RequestMethod.GET)
    public String showLogin(HttpServletRequest request, Model model) {

        TUser user = (TUser) request.getAttribute("curUser");
        if (user == null) {
            user = new TUser();
        }
        model.addAttribute("user", user);
        return "login";
    }

    /**
     * ajax登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> doLogin(HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        String cLoginId = request.getParameter("cLoginId");
        String cPassword = request.getParameter("cPassword");

        Map<String, Object> result = new HashMap<String, Object>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(cLoginId,
                    cPassword);
            //获取当前的Subject  
            Subject currentUser = SecurityUtils.getSubject();

            try {
                //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
                //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
                //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
                logger.info(String.format("对用户[%s]进行登录验证..验证开始", cLoginId));
                currentUser.login(token);
                logger.info(String.format("对用户[%s]进行登录验证..验证通过", cLoginId));
            } catch (UnknownAccountException uae) {
                logger.info(
                    String.format("对用户[%s]进行登录验证..验证未通过,未知账户", cLoginId));
                redirectAttributes.addFlashAttribute("message", "未知账户");
                return getErrorMap("用户名或密码错误");
            } catch (IncorrectCredentialsException ice) {
                logger.info(
                    String.format("对用户[%s]进行登录验证..验证未通过,错误的凭证", cLoginId));
                redirectAttributes.addFlashAttribute("message", "密码不正确");
                return getErrorMap("用户名或密码错误");
            } catch (LockedAccountException lae) {
                logger.info(
                    String.format("对用户[%s]进行登录验证..验证未通过,账户已锁定", cLoginId));
                redirectAttributes.addFlashAttribute("message", "账户已锁定");
                return getErrorMap("账户已锁定");
            } catch (DisabledAccountException dae) {
                logger.info(
                    String.format("对用户[%s]进行登录验证..验证未通过,禁用账户", cLoginId));
                redirectAttributes.addFlashAttribute("message", "禁用账户");
                return getErrorMap("禁用账户");
            } catch (UserStateException use) {
                logger.info(
                    String.format("对用户[%s]进行登录验证..验证未通过,账户未审批", cLoginId));
                redirectAttributes.addFlashAttribute("message", "账户未审批");
                return getErrorMap("账户未审批");
            } catch (ExcessiveAttemptsException eae) {
                logger.info(
                    String.format("对用户[%s]进行登录验证..验证未通过,错误次数过多", cLoginId));
                redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
                return getErrorMap("用户名或密码错误次数过多");
            } catch (AuthenticationException ae) {
                //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
                logger.info(
                    String.format("对用户[%s]进行登录验证..验证未通过,堆栈轨迹如下", cLoginId));
                redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
                return getErrorMap("用户名或密码错误");
            }

            //验证是否登录成功  
            if (!currentUser.isAuthenticated()) {
                token.clear();
                return getErrorMap("用户名或密码错误");

            }
            logger.info(String.format("用户[%s]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)",
                cLoginId));
            TUser user = UserInfoList.getInstance().getUserByLoginId(cLoginId);
            // 设置当前登录用户信息
            setCurrentUser(user);
            result.put("success", true);

            //            List<TUser> users = userService.getLoginUser(cLoginId, cPassword);
            //            if (!users.isEmpty()) {
            //                result.put("success", true);
            //                request.setAttribute(
            //                    CommonConstants.SessionKey.CURRENT_USER.getValue(),
            //                    users.get(NumberConstant.ZERO.getValue()));
            //            } else {
            //                result.put("success", false);
            //                result.put("msg", "用户名或密码错误");
            //            }
        } catch (Exception e) {
            logger.error("登录用户验证错误：", e);
            return getErrorMap("用户名或密码错误");
        }
        return result;
    }

    /**
     * 退出系统
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:/showlogin";
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    @ResponseBody
    public String ajaxTest(HttpServletRequest request) {
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("passwd", passwd);
        //        userService.getUserByCondition(param);
        userService.getUserById("1");
        return String.format("%s%s", username, passwd);
    }

}
