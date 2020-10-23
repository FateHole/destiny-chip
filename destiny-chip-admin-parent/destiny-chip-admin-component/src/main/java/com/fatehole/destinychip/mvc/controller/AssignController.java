package com.fatehole.destinychip.mvc.controller;

import com.fatehole.destinychip.entity.Role;
import com.fatehole.destinychip.service.api.AdminService;
import com.fatehole.destinychip.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author FateCat
 * @version 2020-10-23-12:32
 */

@Controller
@RequestMapping("/assign")
public class AssignController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/role/page")
    public String toAssignRolePage(@RequestParam("id") Integer id,
                                   Model model) {

        // 查询已分配的角色
        List<Role> assignedRoles = roleService.getAssignedRole(id);

        // 查询未分配的角色
        List<Role> unAssignedRoles = roleService.getUnAssignedRole(id);

        // 存入模型
        model.addAttribute("assignedRoles", assignedRoles);
        model.addAttribute("unAssignedRoles", unAssignedRoles);

        return "admin/assign-role";
    }

    /**
     * @param roleIdList 我们允许用户在页面上取消所有已分配的角色再进行提交标单，所以可以不提供此参数
     */
    @RequestMapping("/role/assign")
    public String saveAdminRoleRelationship(@RequestParam("id") Integer id,
                                            @RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("keyword") String keyword,
                                            @RequestParam(value = "roleIdList", required = false) List<Integer> roleIdList) {

        adminService.saveAdminRoleRelationship(id, roleIdList);


        return "redirect:/admin/getPageInfo?pageNum=" + pageNum + "&keyword=" + keyword;
    }
}
