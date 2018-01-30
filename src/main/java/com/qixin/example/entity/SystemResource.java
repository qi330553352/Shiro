package com.qixin.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 文    件     名： Resource
 * 包           名： com.qixin.example.entity
 * 创  建   时  间： 2018/1/18 13:34
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Data
public class SystemResource implements Serializable {

    private Long id; //编号
    private String name; //资源名称
    private ResourceType type = ResourceType.menu; //资源类型
    private String url; //资源路径
    private String permission; //权限字符串
    private Long parentId; //父编号
    private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;

    public static enum ResourceType {
        menu("菜单"), button("按钮");

        private final String info;

        ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }

    public SystemResource() {
    }

    public SystemResource(String name, ResourceType type, String url, Long parentId, String parentIds, String permission, Boolean available) {
        this.name = name;
        this.type = type;
        this.url = url;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.permission = permission;
        this.available = available;
    }

}
