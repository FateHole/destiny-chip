package com.fatehole.destinychip.mvc.controller;

import com.fatehole.destinychip.entity.Role;
import com.fatehole.destinychip.service.api.RoleService;
import com.fatehole.destinychip.util.ResultEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author FateCat
 * @version 2020-10-12-13:13
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/getPageInfo")
    public ResultEntity<PageInfo<Role>> getPageInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "keyword", defaultValue = "") String keyword) {

        // 调用service方法获取分页数据
        PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);

        // 封装到ResultEntity对象中返回（如果上面的操作抛出的异常，交给异常映射机制处理）
        return ResultEntity.successWithData(pageInfo);
    }

    @ResponseBody
    @RequestMapping("/save")
    public ResultEntity<String> saveRole(Role role) {

        roleService.saveRole(role);

        return ResultEntity.successWithData("成功");
    }
}
