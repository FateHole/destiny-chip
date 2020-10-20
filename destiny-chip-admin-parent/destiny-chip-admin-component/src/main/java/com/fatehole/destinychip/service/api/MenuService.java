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
}
