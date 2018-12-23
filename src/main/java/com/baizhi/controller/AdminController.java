package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/queryOne")
    public String queryOne(Admin admin, String enCode, HttpSession session){
        try {
            Admin admin1 = adminService.queryOne(admin,enCode,(String)session.getAttribute("code"));
            if(admin1!=null){
                session.setAttribute("admin",admin1);
                return "redirect:/main/main.jsp";
//                return "redirect:/menu/queryAll";
            }
            return "redirect:/login.jsp";
        }catch(Exception e){
            return "redirect:/login.jsp";

        }
    }
}
