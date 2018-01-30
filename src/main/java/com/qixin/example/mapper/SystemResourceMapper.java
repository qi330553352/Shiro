package com.qixin.example.mapper;

import com.qixin.example.entity.SystemResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 文    件     名： ResourceMapper
 * 包           名： com.qixin.example.mapper
 * 创  建   时  间： 2018/1/22 11:20
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
public interface SystemResourceMapper {

    SystemResource findById(@Param("id")Long id);

    List<SystemResource> findEntitys();

    int save(SystemResource entity);

    List<SystemResource> findMenus();

    List<SystemResource> findAll();

    Set<String> findAllPermission();

    int update(SystemResource entity);

    int deleteById(@Param("id")Long id);
}
