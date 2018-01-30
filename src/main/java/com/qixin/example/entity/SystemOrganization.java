package com.qixin.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 文    件     名： Organization
 * 包           名： com.qixin.example.entity
 * 创  建   时  间： 2018/1/18 13:35
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Data
public class SystemOrganization implements Serializable {

    private Long id; //编号
    private String name; //组织机构名称
    private Long parentId; //父编号
    private String parentIds; //父编号列表，如1/2/
    private Boolean available = Boolean.FALSE;
}
