package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.entity.Role;
import com.fatehole.destinychip.entity.RoleExample;
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

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void removeRole(List<Integer> roleIdList) {
        // 创建一个RoleExample对象
        RoleExample example = new RoleExample();

        // 利用创建的RoleExample对象，创建内部类Criteria对象
        RoleExample.Criteria criteria = example.createCriteria();

        // 给Criteria对象封装条件
        criteria.andIdIn(roleIdList);

        // 执行
        roleMapper.deleteByExample(example);
    }
}
