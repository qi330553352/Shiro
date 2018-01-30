package com.qixin.example.service;

import com.qixin.example.dao.SystemUserDao;
import com.qixin.example.entity.SystemResource;
import com.qixin.example.entity.SystemUser;
import com.qixin.example.mapper.SystemResourceMapper;
import com.qixin.example.utils.Constants;
import com.qixin.example.utils.spring.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 文    件     名： UserServiceImpl
 * 包           名： com.qixin.example.service
 * 创  建   时  间： 2018/1/18 15:25
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {


    @Autowired
    private SystemUserDao userDao;
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private SystemRoleService roleService;
    @Autowired
    private SystemResourceMapper systemResourceMapper;

    /**
     * 创建用户
     * @param user
     */
    public SystemUser createUser(SystemUser user) {
        passwordHelper.encryptPassword(user); //加密密码
        return userDao.createUser(user);
    }

    @Override
    public SystemUser updateUser(SystemUser user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        SystemUser user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    @Override
    public SystemUser findOne(Long userId) {
        return userDao.findOne(userId);
    }

    @Override
    public List<SystemUser> findAll() {
        return userDao.findAll();
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public SystemUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        if(StringUtils.isEmpty(username)) return Collections.emptySet();
        if(Constants.ROOT_USER.equals(username)){
            return roleService.findAllRole();
        }else{
            SystemUser user =findByUsername(username);
            if(user == null) return Collections.emptySet();
            return roleService.findRoles(user.getRoleIds());
        }
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        if(StringUtils.isEmpty(username)) return Collections.emptySet();
        if(Constants.ROOT_USER.equals(username)){
            return systemResourceMapper.findAllPermission();
        }else{
            SystemUser user =findByUsername(username);
            if(user == null) return Collections.emptySet();
            return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
        }
    }
}
