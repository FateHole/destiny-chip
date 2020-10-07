package com.fatehole.destinychip.service.api;

import com.fatehole.destinychip.entity.Admin;

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
    Admin getAdminBbyLoginAccount(String loginAccount, String password);
}
