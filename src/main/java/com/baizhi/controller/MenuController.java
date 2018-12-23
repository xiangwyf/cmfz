package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Menu> queryAll(Model model){
        return menuService.queryAll();
//        List<Menu> menuList = menuService.queryAll();
//        model.addAttribute("list",menuList);
//        return "main/main";

    }

    @RequestMapping("/queryById")
    @ResponseBody
    public List<Menu> queryById(Menu menu){
        return menuService.queryById(menu);
    }
}
