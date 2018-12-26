package com.baizhi.controller;

import com.baizhi.entity.Distribution;
import com.baizhi.entity.Guru;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryAnalyse")
    @ResponseBody
    public Map<String, List> queryAnalyse(){
        return userService.queryAnalyse();
    }

    @RequestMapping("/queryDistribution")
    @ResponseBody
    public List<Distribution> queryDistribution(){
        return userService.queryByDistribution();
    }
}
