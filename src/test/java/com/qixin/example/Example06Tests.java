package com.qixin.example;

import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** Realm及相关对象
 * http://jinnianshilongnian.iteye.com/blog/2022468
 * 文    件     名： Example06Tests
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/31 0:39
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class Example06Tests {

    /*
        一、UserRealm
        1.1、public class UserRealm extends AuthorizingRealm {
        1.2、AuthenticationToken
        1.3、AuthenticationInfo
        1.4、PrincipalCollection
        1.5、AuthorizationInfo
        二、Subject
        2.1、身份信息获取
        2.2、身份验证
        2.3、角色授权验证
        2.4、权限授权验证
        2.5、会话
        2.6、退出
        2.7、RunAs
        2.8、多线程
     */
}
