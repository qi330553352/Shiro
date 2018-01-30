package com.qixin.example.service;

import com.qixin.example.entity.SystemResource;
import com.qixin.example.mapper.SystemResourceMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 文    件     名： ResourceServiceImpl
 * 包           名： com.qixin.example.service
 * 创  建   时  间： 2018/1/22 11:10
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@Service
public class SystemResourceServiceImpl implements SystemResourceService {

    @Autowired
    private SystemResourceMapper resourceMapper;

    @Override
    public List<SystemResource> findMenus() {
        List<SystemResource> list = resourceMapper.findMenus();

        return list;
    }

    @Override
    public List<SystemResource> findAll() {

        return resourceMapper.findAll();
    }

    @Override
    public SystemResource findById(Long id) {

        return resourceMapper.findById(id);
    }

    @Override
    public int save(SystemResource entity) {

        return resourceMapper.save(entity);
    }

    @Override
    public int update(SystemResource entity) {

        return resourceMapper.update(entity);
    }

    @Override
    public int deleteById(Long id) {

        return resourceMapper.deleteById(id);
    }
}
