package com.qixin.example.controller;

import com.qixin.example.entity.SystemResource;
import com.qixin.example.entity.SystemUser;
import com.qixin.example.service.SystemResourceService;
import com.qixin.example.utils.ReturnDataMap;
import com.qixin.example.utils.bind.annotation.CurrentUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 文    件     名： LayoutsController
 * 包           名： com.qixin.example.controller
 * 创  建   时  间： 2018/1/18 20:07
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Log4j2
@Controller
@RequestMapping(value = "/Layouts")
public class LayoutsController {

    @Autowired
    private SystemResourceService systemResourceService;

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView index(@CurrentUser SystemUser user) {
        ReturnDataMap map = new ReturnDataMap(true,"数据返回成功");
        List<SystemResource> menus = systemResourceService.findMenus();
        map.put("menus", menus);
        return new ModelAndView("/layouts/index",map);
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){

        return "/layouts/welcome";
    }

}
