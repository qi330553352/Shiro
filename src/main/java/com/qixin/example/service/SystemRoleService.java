package com.qixin.example.service;

import com.qixin.example.entity.SystemOrganization;
import com.qixin.example.entity.SystemRole;

import java.util.List;
import java.util.Set;

/**
 * 文    件     名： RoleService
 * 包           名： com.qixin.example.service
 * 创  建   时  间： 2018/1/18 23:17
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
public interface SystemRoleService {

    Set<String> findRoles(List<Long> roleIds);

    Set<String> findPermissions(Long[] longs);

    SystemRole findById(Long roleId);

    List<SystemRole> findAll();

    Set<String> findAllRole();

    int save(SystemRole entity);

    int update(SystemRole role);

    int deleteById(Long id);
}
