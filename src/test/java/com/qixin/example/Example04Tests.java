package com.qixin.example;

import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**INI配置
 * http://jinnianshilongnian.iteye.com/blog/2020820
 * 文    件     名： Example04Tests
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/31 0:15
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class Example04Tests {

    /*
        一、根对象SecurityManager
        1.1、纯Java代码写法
        1.2、等价的INI配置
        二、INI配置
        2.1、创建对象
        2.2、setter注入：常量、对象引用、嵌套属性、byte数组、Array/Set/List、Map、
     */
}
