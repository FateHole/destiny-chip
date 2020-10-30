package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.entity.Auth;
import com.fatehole.destinychip.entity.AuthExample;
import com.fatehole.destinychip.mapper.AuthMapper;
import com.fatehole.destinychip.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author FateCat
 * @version 2020-10-24-0:00
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;


    @Override
    public List<Auth> getAll() {
        return authMapper.selectByExample(new AuthExample());
    }

    @Override
    public List<Integer> getAssignedAuthIdByRoleId(Integer roleId) {
        return authMapper.selectAssignedAuthIdByRoleId(roleId);
    }

    @Override
    public void saveRoleAuthRelationship(Map<String, List<Integer>> map) {

        // 获取roleId的值
        List<Integer> roles = map.get("roleId");
        Integer roleId = roles.get(0);

        // 删除相关的关联数据
        authMapper.deleteOldRelationship(roleId);

        // 获取authIdList
        List<Integer> authIdList = map.get("authIdArray");

        // 判断authIdList是否有效
        if (authIdList != null && authIdList.size() > 0) {
            authMapper.insertNewRelationship(roleId, authIdList);
        }
    }

    @Override
    public List<String> getAssignedAuthNameByAdminId(Integer id) {
        return authMapper.selectAssignedAuthNameByAdminId(id);
    }
}
