package com.ycl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.controller.BaseController;

/**
 * index页面
 * @author huayu
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
    /**
     * 登录页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {

        TUser user = getCurrentUser();
        if (user == null) {
            user = new TUser();
        }
        model.addAttribute("user", user);
        return "index";
    }
}
