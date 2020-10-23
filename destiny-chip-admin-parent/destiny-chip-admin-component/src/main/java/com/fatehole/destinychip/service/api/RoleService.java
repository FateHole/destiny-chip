package com.fatehole.destinychip.service.api;

import com.fatehole.destinychip.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author FateCat
 * @version 2020-10-12-13:12
 */
public interface RoleService {

    /**
     * 根据参数返回分页对象
     * @param pageNum 页码
     * @param pageSize 页数
     * @param keyword 关键词
     * @return PageInfo对象
     */
    PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword);


    /**
     * 根据传过来的role名创建在数据库中创建对象
     * @param role 角色名
     */
    void saveRole(Role role);

    /**
     * 根究传过来的role在数据库中根究id进行修改
     * @param role 角色修改信息
     */
    void updateRole(Role role);

    /**
     * 根据传过来的id集合删除对应的role
     * @param roleIdList id集合
     */
    void removeRole(List<Integer> roleIdList);

    /**
     * 根据传来的id查出已分配的角色
     * @param id 管理员id
     * @return 包含已分配角色的集合
     */
    List<Role> getAssignedRole(Integer id);

    /**
     * 根据传来的id查出未分配的角色
     * @param id 管理员id
     * @return 包含未分配角色的集合
     */
    List<Role> getUnAssignedRole(Integer id);
}
