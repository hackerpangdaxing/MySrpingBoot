package com.springboot.main.test;

import com.springboot.main.realm.MyRealm1Impl;
import com.springboot.main.realmService.RealmService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 * Created by Channing on 2018/1/30.
 */
public class  LoginLogoutTest{

    @Test
    public void TestHelloShiro() {
        // 获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 得到SecurityManager实例，并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
        // 得到Subject及用户密码身份验证Token
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            // 登录
            subject.login(token);
            System.out.println("恭喜您，登录成功！");
        }
        catch (AuthenticationException e) {
            // 身份验证失败
            e.printStackTrace();
            System.out.println("很遗憾，登录失败请重试！");
        }

        // 断言用户已经登录
        Assert.assertEquals(true, subject.isAuthenticated());

        // 退出
        subject.logout();

    }


    @Test
    public void TestLogin() {
        // 获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        // 得到SecurityManager实例，并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
        // 得到Subject及用户密码身份验证Token
        RealmService myRealm1 = new MyRealm1Impl();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");


        try {
            // 登录
            myRealm1.getAuthenticationInfo(token);
            System.out.println(myRealm1.getName());
            System.out.println("恭喜您，登录成功！");
        }
        catch (AuthenticationException e) {
            // 身份验证失败
            e.printStackTrace();
            System.out.println("很遗憾，登录失败请重试！");
        }

    }

}
