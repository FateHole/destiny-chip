package com.fatehole.destinychip.service.api;

import com.fatehole.destinychip.entity.Role;
import com.github.pagehelper.PageInfo;

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


}
