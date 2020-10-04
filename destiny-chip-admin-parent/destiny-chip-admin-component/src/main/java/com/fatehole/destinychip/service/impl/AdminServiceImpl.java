package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.mapper.AdminMapper;
import com.fatehole.destinychip.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FateCat
 * @version 2020-10-04-21:39
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Integer saveAdmin(Admin admin) {
        int row = adminMapper.insert(admin);
        return row;
    }
}
