package com.ycl.common.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.ycl.common.constants.CommonConstants;
import com.ycl.common.constants.CommonConstants.HashAlgorithmName;

/**
 * salt生成工具
 * @author Administrator
 *
 */
public class EndecryptUtils {
    /**
     * 获取盐值
     * @return
     */
    public static String getSlat() {
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        return secureRandomNumberGenerator.nextBytes().toHex();
    }

    /**
     * 根据密码+用户名+盐值生成md5tobase64密码
     * @param username
     * @param password
     * @param salt
     * @return
     */
    public static String getMd52Base64Password(String username, String password,
            String salt) {
        return new Md5Hash(password, username + salt,
                CommonConstants.NumberConstant.TWO.getValue()).toBase64();
    }

    /**
     * 根据密码+盐值生成md5密码
     * @param password
     * @param salt
     * @return
     */
    public static String getMd5Password(String password, String salt) {
        return new Md5Hash(password, salt,
                CommonConstants.NumberConstant.TWO.getValue()).toString();
    }

    public static String getMd5Password(String password, String salt,
            int hashIterations) {
        return new SimpleHash(HashAlgorithmName.MD5.getValue(), password,
                ByteSource.Util.bytes(salt), hashIterations).toHex();
    }

    /**
     * 根据密码+盐值生成SHA256密码
     * @param password
     * @param salt
     * @return
     */
    public static String getSHA256Password(String password, String salt) {
        return new Sha256Hash(password, salt).toString();
    }
}
