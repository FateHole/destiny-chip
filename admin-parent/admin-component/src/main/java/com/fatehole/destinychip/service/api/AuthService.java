package com.fatehole.destinychip.service.api;

import com.fatehole.destinychip.entity.Auth;

import java.util.List;
import java.util.Map;

/**
 * @author FateCat
 * @version 2020-10-24-0:00
 */
public interface AuthService {

    /**
     * 查询出所有的权限
     * @return 包含全部权限的集合
     */
    List<Auth> getAll();

    /**
     * 根据角色id查到分配的权限集合
     * @param roleId 角色id
     * @return 权限集合
     */
    List<Integer> getAssignedAuthIdByRoleId(Integer roleId);

    /**
     * 根据传来的保存权限信息
     * @param map 信息
     */
    void saveRoleAuthRelationship(Map<String, List<Integer>> map);

    /**
     * 根据管理员id查询权限名称集合
     * @param id 管理员id
     * @return 权限名集合
     */
    List<String> getAssignedAuthNameByAdminId(Integer id);
}
