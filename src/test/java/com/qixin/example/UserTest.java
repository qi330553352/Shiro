package com.qixin.example;

import com.qixin.example.entity.SystemUser;
import com.qixin.example.service.SystemUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * 文    件     名： UserTest
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/22 1:16
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class UserTest {

    @Autowired
    private SystemUserService userService;

    @Test
    public void createTest(){
        Date date = new Date();
        SystemUser user = new SystemUser();
        user.setOrganizationId(0L);
        user.setUsername("administrator");
        user.setPassword("administrator");
        user.setLocked(false);
        SystemUser bean = userService.createUser(user);
        System.out.println(bean);
    }
}
