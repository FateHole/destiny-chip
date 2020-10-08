package com.fatehole.destinychip.mvc.controller;

import com.fatehole.destinychip.constant.DestinyChipConstant;
import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author FateCat
 * @version 2020-10-07-18:12
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/toLogin")
    public String doLogin(@RequestParam("loginAccount") String loginAccount,
                          @RequestParam("password") String password,
                          HttpSession session) {
        // 调用service方法进行登陆检查
        // 如果可以返回admin对象说明验证成功，否则登陆名和密码不正确会抛出异常
        Admin admin = adminService.getAdminBbyLoginAccount(loginAccount, password);

        session.setAttribute(DestinyChipConstant.ATTR_LOGIN_NAME_ADMIN, admin);

        return "redirect:/admin/main";
    }

    @RequestMapping("/logout")
    public String doLogout(HttpSession session) {
        // 强制session失效
        session.invalidate();

        return "redirect:/admin/login";
    }

    @RequestMapping("/getPageInfo")
    public String getPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                              Model model) {

        // 调用service方法去获取PageInfo对象
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);

        // 将PageInfo对象存入模型
        model.addAttribute(DestinyChipConstant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "admin/admin-page";
    }
}
