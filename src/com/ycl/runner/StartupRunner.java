package com.ycl.runner;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.cache.UserInfoList;
import com.ycl.common.util.DateUtil;
import com.ycl.service.user.IUserService;

@Component
@Order(value = 1)
public class StartupRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Inject
    //    @Named("userService")
    private IUserService userService;

    @Override
    public void run(String... arg0) throws Exception {
        logger.info("{}开始加载用户缓存》》》》》》》》》》》》》》》", DateUtil.getCurrentDateTime());
        List<TUser> users = userService.getAllUser();
        UserInfoList.getInstance().loadAllUser(users);
        logger.info("{}结束加载用户缓存》》》》》》》》》》》》》》》", DateUtil.getCurrentDateTime());
    }

}
