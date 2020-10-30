package com.fatehole.destinychip.service.api;

import com.fatehole.destinychip.entity.Menu;

import java.util.List;

/**
 * @author FateCat
 * @version 2020-10-20-10:56
 */
public interface MenuService {

    /**
     * 获取所有的菜单节点合集
     * @return 包含菜单对象的list集合
     */
    List<Menu> getAll();

    /**
     * 根据传来的menu对象创建节点
     * @param menu 对象
     */
    void saveMenu(Menu menu);

    /**
     * 根据传来的menu对象进行修改
     * @param menu 修改信息
     */
    void updateMenu(Menu menu);

    /**
     * 根据传过来的id,删除对应的节点
     * @param id 节点id
     */
    void removeMenu(Integer id);
}
