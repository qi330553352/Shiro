package com.qixin.example;

import junit.framework.Assert;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 身份认证
 * http://jinnianshilongnian.iteye.com/blog/2019547
 * 文    件     名： Example02Tests
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/30 23:29
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class Example02Tests {

    @Test
    public void test1(){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token); //4、登录，即身份验证
        } catch (AuthenticationException e) {
            e.printStackTrace();  //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }
    /*  身份验证的步骤
        1、获得 SecurityManager
        2、通过将SecurityManager绑定到SecurityUtils中获得Subject
        3、创建用户身份凭证token
        4、登录
     */

    /*  功能扩展
        1、直接使用ini文件中的用户
        2、使用realm、multi-realm、jdbc-realm
        3、Authenticator及AuthenticationStrategy
    */
}
