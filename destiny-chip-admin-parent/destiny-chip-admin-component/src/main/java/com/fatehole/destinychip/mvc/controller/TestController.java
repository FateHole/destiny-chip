package com.fatehole.destinychip.mvc.controller;

import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FateCat
 * @version 2020-10-04-23:40
 */
@Controller
public class TestController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admins")
    public String test(Model model) {

        model.addAttribute("msg", adminService.getAll());

        return "success";
    }
}
