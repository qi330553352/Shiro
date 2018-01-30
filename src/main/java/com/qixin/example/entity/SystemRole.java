package com.qixin.example.entity;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 文    件     名： Role
 * 包           名： com.qixin.example.entity
 * 创  建   时  间： 2018/1/18 13:34
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Data
public class SystemRole implements Serializable {

    private Long id; //编号
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private List<Long> resourceIds = new ArrayList<>(); //拥有的资源
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    public String getResourceIdsStr() {
        if(CollectionUtils.isEmpty(resourceIds)) return "";
        StringBuilder s = new StringBuilder();
        for(int i=0;i<resourceIds.size();i++){
            if(i==(resourceIds.size()-1)){
                s.append(resourceIds.get(i));
            }else{
                s.append(resourceIds.get(i)).append(",");
            }
        }
        return s.toString();
    }
}
