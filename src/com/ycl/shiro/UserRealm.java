package com.ycl.shiro;

import javax.inject.Inject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.ycl.bean.manager.user.TUser;
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
