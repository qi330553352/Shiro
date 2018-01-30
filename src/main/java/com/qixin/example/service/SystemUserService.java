package com.qixin.example.service;

import com.qixin.example.entity.SystemUser;

import java.util.List;
import java.util.Set;

/**
 * 文    件     名： UserService
 * 包           名： com.qixin.example.service
 * 创  建   时  间： 2018/1/18 15:25
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
public interface SystemUserService {
    /**
     * 创建用户
     * @param user
     */
    SystemUser createUser(SystemUser user);

    SystemUser updateUser(SystemUser user);

    void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    void changePassword(Long userId, String newPassword);


    SystemUser findOne(Long userId);

    List<SystemUser> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    SystemUser findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);

}
