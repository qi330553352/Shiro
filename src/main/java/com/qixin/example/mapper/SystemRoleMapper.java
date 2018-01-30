package com.qixin.example.mapper;

import com.qixin.example.entity.SystemRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 文    件     名： SystemRoleMapper
 * 包           名： com.qixin.example.mapper
 * 创  建   时  间： 2018/1/22 15:26
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
public interface SystemRoleMapper {

    SystemRole findById(Long id);

    Set<String> findRoles(@Param("roleIds")List<Long> roleIds);

    List<SystemRole> findAll();

    Set<String> findAllRole();

    int save(SystemRole entity);
}
