package com.qixin.example;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 授权
 * http://jinnianshilongnian.iteye.com/blog/2020017
 * 文    件     名： Example03Tests
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/30 23:57
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class Example03Tests {

    @Test
    public void test1(){

    }

    /*  一、授权的三种方式
        1.1、通过写if/else授权代码块完成：
        1.2、通过在执行的Java方法上放置相应的注解完成
        1.3、在JSP/GSP页面通过相应的标签完成
        二、授权
        2.1、基于角色的访问控制（隐式角色）
        2.2、基于资源的访问控制（显示角色）
        三、Permission（字符串通配符权限）
        3.1、单个资源单个权限
        3.2、单个资源多个权限
        3.3、单个资源全部权限
        3.4、所有资源全部权限
        3.5、实例级别的权限
        3.6、Shiro对权限字符串缺失部分的处理
        3.7、WildcardPermission
        3.8、性能问题
        3.9、Authorizer、PermissionResolver及RolePermissionResolver
        3.10、定义BitAndWildPermissionResolver及BitPermission
        3.11、定义MyRolePermissionResolver
        3.12、自定义Realm
     */
}
