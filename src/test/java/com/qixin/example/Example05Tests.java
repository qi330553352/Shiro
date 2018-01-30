package com.qixin.example;

import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 编码/解码
 * http://jinnianshilongnian.iteye.com/blog/2021439
 * 文    件     名： Example05Tests
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/31 0:23
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class Example05Tests {

    /*
        一、编码/解码
        1.1、Shiro提供了base64和16进制字符串编码/解码的API支持
        二、散列算法
        2.1、如：MD5、SHA、SHA1、SHA512等
        三、加密/解密
        3.1、对称式加密/解密算法，如：AES、Blowfish等
        四、PasswordService/CredentialsMatcher
        4.1、PasswordService及CredentialsMatcher用于提供加密密码及验证密码服务
        4.2、DefaultPasswordService配合PasswordMatcher实现简单的密码加密与验证服务
        4.3、HashedCredentialsMatcher实现密码验证服务
        五、密码重试次数限制
     */
}
