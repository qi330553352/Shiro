package com.qixin.example.controller;

import com.qixin.example.entity.SystemUser;
import com.qixin.example.service.SystemOrganizationService;
import com.qixin.example.service.SystemRoleService;
import com.qixin.example.service.SystemUserService;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 文    件     名： SystemUserController
 * 包           名： com.qixin.example.controller
 * 创  建   时  间： 2018/1/22 14:33
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@Controller
@RequestMapping(value = "/user")
public class SystemUserController {

    @Autowired
    private SystemRoleService systemRoleService;
    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private SystemOrganizationService systemOrganizationService;

    @RequiresPermissions("user:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("userList", systemUserService.findAll());
        return "/system/user/list";
    }

    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("user", new SystemUser());
        model.addAttribute("op", "新增");
        return "/system/user/edit";
    }

    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(SystemUser user, RedirectAttributes redirectAttributes) {
        systemUserService.createUser(user);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/user";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("user", systemUserService.findOne(id));
        model.addAttribute("op", "修改");
        return "/system/user/edit";
    }

    private void setCommonData(Model model) {
        model.addAttribute("organizationList", systemOrganizationService.findAll());
        model.addAttribute("roleList", systemRoleService.findAll());
    }
}
