package com.fatehole.destinychip.mvc.controller;

import com.fatehole.destinychip.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author FateCat
 * @version 2020-10-04-23:40
 */
@Controller
public class TestController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admins")
    public String test(Model model, HttpServletRequest request) {

        model.addAttribute("msg", adminService.getAll());
        int i = 19 / 0;

        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/array")
    public String test1(@RequestParam("array[]")List<Integer> array) {

        array.forEach(System.out::println);
        return "success";
    }

}
