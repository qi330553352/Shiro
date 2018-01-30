package com.qixin.example.controller;

import com.qixin.example.entity.SystemResource;
import com.qixin.example.service.SystemResourceService;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 文    件     名： SystemResourceController
 * 包           名： com.qixin.example.controller
 * 创  建   时  间： 2018/1/22 16:18
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@Controller
@RequestMapping(value = "/resource")
public class SystemResourceController {

    @Autowired
    private SystemResourceService resourceService;

    @ModelAttribute("types")
    public SystemResource.ResourceType[] resourceTypes() {
        return SystemResource.ResourceType.values();
    }

    @RequiresPermissions("resource:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<SystemResource> list = resourceService.findAll();
        model.addAttribute("resourceList", list);
        return "/system/resource/list";
    }

    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        log.info("参数 parentId:{}",parentId);
        SystemResource parent = resourceService.findById(parentId);
        model.addAttribute("parent", parent);
        SystemResource child = new SystemResource();
        child.setParentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("resource", child);
        model.addAttribute("op", "新增子节点");
        return "/system/resource/edit";
    }

    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.POST)
    public String create(SystemResource entity, RedirectAttributes redirect) {
        log.info("参数："+entity);
        resourceService.save(entity);
        redirect.addFlashAttribute("msg", "新增子节点成功");
        return "redirect:/resource";
    }

    @RequiresPermissions("resource:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("resource", resourceService.findById(id));
        model.addAttribute("op", "修改");
        return "/system/resource/edit";
    }

    @RequiresPermissions("resource:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(SystemResource entity, RedirectAttributes redirect) {
        log.info("参数："+entity);
        resourceService.update(entity);
        redirect.addFlashAttribute("msg", "修改成功");
        return "redirect:/resource";
    }

    @RequiresPermissions("resource:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
        log.info("参数 id:{}",id);
        resourceService.deleteById(id);
        redirect.addFlashAttribute("msg", "删除成功");
        return "redirect:/resource";
    }


}
