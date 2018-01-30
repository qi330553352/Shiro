package com.qixin.example.dao;

import com.qixin.example.entity.SystemUser;

import java.util.List;

/**
 * 文    件     名： UserDao
 * 包           名： com.qixin.example.dao
 * 创  建   时  间： 2018/1/18 23:15
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
public interface SystemUserDao {

    SystemUser updateUser(SystemUser user);

    void deleteUser(Long userId);

    SystemUser findOne(Long userId);

    List<SystemUser> findAll();

    SystemUser findByUsername(String username);

    SystemUser createUser(SystemUser user);
}
