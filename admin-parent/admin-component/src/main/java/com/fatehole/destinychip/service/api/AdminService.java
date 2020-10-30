package com.fatehole.destinychip.service.api;

import com.fatehole.destinychip.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author FateCat
 * @version 2020-10-04-21:37
 */
public interface AdminService {

    /**
     * 保存一个管理员用户
     * @param admin 管理员用户对象
     */
    void saveAdmin(Admin admin);

    /**
     * 获取全部管理员信息
     * @return list集合
     */
    List<Admin> getAll();

    /**
     * 根据登陆账号和密码到数据库进行校验
     * @param loginAccount 登陆账号
     * @param password 密码
     * @return 如果成功，返回Admin对象;
     *         失败抛出异常
     */
    Admin getAdminByLoginAccount(String loginAccount, String password);

    /**
     * 分页方法
     * @param keyword 搜索关键字
     * @param pageNum 页数
     * @param pageSize 每页的大小
     * @return 含有分页数据的PageInfo对象
     */
    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 删除用户
     * @param id 用户id
     */
    void remove(Integer id);

    /**
     * 根据id查出Admin对象
     * @param id id号
     * @return Admin对象
     */
    Admin getAdminById(Integer id);

    /**
     * 修改信息
     * @param admin 修改信息
     */
    void update(Admin admin);

    /**
     * 根据提交的id和角色列表，为管理员添加角色
     * @param id 管理员id
     * @param roleIdList 角色列表
     */
    void saveAdminRoleRelationship(Integer id, List<Integer> roleIdList);

    /**
     * 根据账号名查询Admin对象
     * @param username 账号名
     * @return Admin对象
     */
    Admin getAdminByLoginAccount(String username);
}
