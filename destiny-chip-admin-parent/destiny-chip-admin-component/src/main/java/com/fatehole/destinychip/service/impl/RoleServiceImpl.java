package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.entity.Role;
import com.fatehole.destinychip.mapper.RoleMapper;
import com.fatehole.destinychip.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FateCat
 * @version 2020-10-12-13:12
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {

        // 开启分页的功能
        PageHelper.startPage(pageNum, pageSize);

        // 执行查询
        List<Role> roles = roleMapper.selectRoleByKeyword(keyword);

        // 封装为PageInfo对象返回
        return new PageInfo<>(roles);
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
    }
}
