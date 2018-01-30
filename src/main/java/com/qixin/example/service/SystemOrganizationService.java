package com.qixin.example.service;

import com.qixin.example.entity.SystemOrganization;

import java.util.List;

/**
 * 文    件     名： SystemOrganizationService
 * 包           名： com.qixin.example.service
 * 创  建   时  间： 2018/1/22 15:05
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
public interface SystemOrganizationService {

    SystemOrganization findById(Long id);

    List<SystemOrganization> findAll();
}
