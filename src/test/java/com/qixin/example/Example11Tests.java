package com.qixin.example;

import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** JSP标签
 * http://jinnianshilongnian.iteye.com/blog/2026398
 * 文    件     名： Example11Tests
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/31 1:10
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class Example11Tests {

    /*
        1、guest标签
        2、user标签
        3、authenticated标签
        4、notAuthenticated标签
        5、principal标签
        6、hasRole标签
        7、hasAnyRoles标签
        8、acksRole标签
        9、hasPermission标签
        10、lacksPermission标签
        11、导入自定义标签库
     */
}