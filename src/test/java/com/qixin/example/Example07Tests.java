package com.qixin.example;

import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 与Web集成
 * http://jinnianshilongnian.iteye.com/blog/2024723
 * 文    件     名： Example07Tests
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/31 0:50
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class Example07Tests {

    /*
        一、ShiroFilter入口
        1.1、Shiro 1.1及以前版本配置方式
        1.2、Shiro 1.2及以后版本的配置方式
        二、Web INI配置
        2.1、身份验证（登录）
        2.2、基于Basic的拦截器身份验证
        2.3、基于表单的拦截器身份验证
        三、授权（角色/权限验证）
        四、退出
     */
}
