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
}
