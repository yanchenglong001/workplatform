package com.ycl.shiro;

import javax.inject.Inject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.constants.CommonConstants.NValid;
import com.ycl.common.constants.CommonConstants.UserState;
import com.ycl.common.exception.UserStateException;
import com.ycl.service.user.IUserService;

/**
 * 实现Realm,继承AuthorizingRealm，
 * 并重写doGetAuthorizationInfo(用于获取认证成功后的角色、权限等信息) 
 * 和 doGetAuthenticationInfo(验证当前登录的Subject)方法
 * @author Administrator
 *
 */
public class UserRealm extends AuthorizingRealm {

    @Inject
    //    @Named("userService")
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {

        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        TUser user = userService.findByLoginName(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        // 判断账号是否禁用
        if (user.getnValid() == null
                || NValid.VALID.getValue() != user.getnValid().intValue()) {
            throw new DisabledAccountException();// 禁用账号
        }
        // 判断账号是否审批通过
        if (user.getnState() == null) {
            throw new UserStateException("账号未审批");// 账号是否审批通过
        }
        // 判断账号是否审批通过
        if (UserState.UNAUTHORIZED.getValue() == user.getnState().intValue()) {
            throw new UserStateException("账号未审批");// 账号是否审批通过
        }
        // 账号锁定
        if (UserState.LOCK.getValue() == user.getnState().intValue()) {
            throw new LockedAccountException();// 账号锁定
        }
        //        AuthenticationException
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getcLoginId(), //用户名
                user.getcPassword(), //密码
                // 身份信息（用户名）、凭据（密文密码）、盐（username+salt），
                // CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
                //                ByteSource.Util.bytes(
                //                    String.format("%s%s", user.getcLoginId(), user.getcSalt())), //salt=username+salt,采用明文访问时，不需要此句
                ByteSource.Util.bytes(user.getcSalt()), getName() //realm name
        );
        return authenticationInfo;
    }

}
