package com.qixin.example.utils.taglib;

import com.qixin.example.entity.SystemOrganization;
import com.qixin.example.entity.SystemResource;
import com.qixin.example.entity.SystemRole;
import com.qixin.example.service.SystemOrganizationService;
import com.qixin.example.service.SystemResourceService;
import com.qixin.example.service.SystemRoleService;
import com.qixin.example.utils.spring.SpringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 文    件     名： Functions
 * 包           名： com.qixin.example.utils.taglib
 * 创  建   时  间： 2018/1/22 14:49
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
public class Functions {

    public static boolean in(Iterable iterable, Object element) {
        return iterable != null && CollectionUtils.contains(iterable.iterator(), element);
    }

    public static String organizationName(Long organizationId) {
        SystemOrganization organization = getSystemOrganization().findById(organizationId);
        if(organization == null) {
            return "";
        }
        return organization.getName();
    }

    public static String roleNames(Collection<Long> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)) return "";
        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            SystemRole role = getSystemRoleService().findById(roleId);
            if(role == null) return "";
            s.append(role.getDescription());
            s.append(",");
        }
        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }
        return s.toString();
    }

    public static String resourceNames(Collection<Long> resourceIds) {
        if(CollectionUtils.isEmpty(resourceIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long resourceId : resourceIds) {
            SystemResource resource = getSystemResourceService().findById(resourceId);
            if(resource == null) {
                return "";
            }
            s.append(resource.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }

    private static SystemOrganizationService systemOrganizationService;
    private static SystemRoleService systemRoleService;
    private static SystemResourceService systemResourceService;

    public static SystemOrganizationService getSystemOrganization() {
        if(systemOrganizationService == null) {
            systemOrganizationService = SpringUtils.getBean(SystemOrganizationService.class);
        }
        return systemOrganizationService;
    }

    public static SystemRoleService getSystemRoleService() {
        if(systemRoleService == null) {
            systemRoleService = SpringUtils.getBean(SystemRoleService.class);
        }
        return systemRoleService;
    }

    public static SystemResourceService getSystemResourceService() {
        if(systemResourceService == null) {
            systemResourceService = SpringUtils.getBean(SystemResourceService.class);
        }
        return systemResourceService;
    }
}
