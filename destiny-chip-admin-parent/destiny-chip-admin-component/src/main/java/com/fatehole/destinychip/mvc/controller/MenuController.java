package com.fatehole.destinychip.mvc.controller;

import com.fatehole.destinychip.entity.Menu;
import com.fatehole.destinychip.service.api.MenuService;
import com.fatehole.destinychip.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FateCat
 * @version 2020-10-20-11:02
 */
@RequestMapping("/menu")
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/whole/tree")
    @ResponseBody
    public ResultEntity<Menu> getWholeTreeNew() {

        // 查询全部的 Menu 对象
        List<Menu> menus = menuService.getAll();

        // 声明一个储存 root 节点的对象
        Menu root = null;

        // 创建Map对象用来储存 id 和 menu 对象之间的对应关系以便查找父节点
        Map<Integer, Menu> menuMap = new HashMap<>();

        // 遍历 menus 填充 menuMap
        for (Menu menu : menus) {
            menuMap.put(menu.getId(), menu);
        }

        // 再次遍历  menu 查找根节点、组装父节点
        for (Menu menu : menus) {
            // 获取当前 menu 对象的 pid 属性
            Integer pid = menu.getPid();

            // 如果 pid 为空，则判定为根节点
            if (pid == null) {
                // 把当前正在遍历的这个 menu 对象赋值给 root
                root = menu;
                // 如果当前节点是根节点，那么肯定没有父节点，不必继续执行
                continue;
            }
            // 如果 pid 不是 null,那么可以根据 pid 到 menuMap 中找到对应的父 menu 对象
            Menu father = menuMap.get(pid);
            // 当前节点存入父节点subset集合
            father.getChildren().add(menu);
        }
        // 经过上面的运算，根节点包含了整个树形结构，返回根节点就是返回整个树
        return ResultEntity.successWithData(root);
    }

    @ResponseBody
    @RequestMapping("/save")
    public ResultEntity<String> saveMenu(Menu menu) {

        menuService.saveMenu(menu);

        return ResultEntity.successWithData("节点创建成功！");
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResultEntity<String> updateMenu(Menu menu) {

        menuService.updateMenu(menu);

        return ResultEntity.successWithData("节点修改成功！");
    }

    @ResponseBody
    @RequestMapping("/remove")
    public ResultEntity<String> removeMenu(@RequestParam("id") Integer id) {

        menuService.removeMenu(id);

        return ResultEntity.successWithData("删除成功！");
    }
}
