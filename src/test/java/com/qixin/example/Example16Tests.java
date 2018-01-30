package com.qixin.example;

import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** SSL
 * http://jinnianshilongnian.iteye.com/blog/2036420
 * 文    件     名： Example16Tests
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/31 1:26
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class Example16Tests {

    /*
        对于SSL的支持，Shiro只是判断当前url是否需要SSL登录，如果需要自动重定向到https进行访问

     */
}
