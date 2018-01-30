package com.qixin.example;

import com.qixin.example.entity.SystemResource;
import com.qixin.example.mapper.SystemResourceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 文    件     名： InitResource
 * 包           名： com.qixin.example
 * 创  建   时  间： 2018/1/22 11:41
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class InitResource {

    @Autowired
    private SystemResourceMapper resourceMapper;

    @Test
    public void initData(){
        resourceMapper.save(new SystemResource("资源", SystemResource.ResourceType.menu,"",0L,"0/","",false));
        resourceMapper.save(new SystemResource("用户管理", SystemResource.ResourceType.menu,"/user",1L,"0/1/","user:*",false));
        resourceMapper.save(new SystemResource("资源管理", SystemResource.ResourceType.menu,"/resource",1L,"0/1/","resource:*",false));
        resourceMapper.save(new SystemResource("角色管理", SystemResource.ResourceType.menu,"/role",1L,"0/1/","role:*",false));
        resourceMapper.save(new SystemResource("组织机构管理", SystemResource.ResourceType.menu,"/organization",1L,"0/1/","organization:*",false));
    }
}
