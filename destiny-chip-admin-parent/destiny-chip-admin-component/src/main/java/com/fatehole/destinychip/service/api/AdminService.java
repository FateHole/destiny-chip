package com.fatehole.destinychip.service.api;

import com.fatehole.destinychip.entity.Admin;

/**
 * @author FateCat
 * @version 2020-10-04-21:37
 */
public interface AdminService {

    /**
     * 保存一个管理员用户
     * @param admin 管理员用户对象
     * @return 影响行数
     */
    Integer saveAdmin(Admin admin);
}
