package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.entity.Menu;
import com.fatehole.destinychip.entity.MenuExample;
import com.fatehole.destinychip.mapper.MenuMapper;
import com.fatehole.destinychip.service.api.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FateCat
 * @version 2020-10-20-10:56
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() {
        return menuMapper.selectByExample(new MenuExample());
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        // 由于pid没有传参，一定要使用有选择的更新，保证pid属性不为空
        menuMapper.updateByPrimaryKeySelective(menu);
    }
}
