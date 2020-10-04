package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.entity.AdminExample;
import com.fatehole.destinychip.mapper.AdminMapper;
import com.fatehole.destinychip.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FateCat
 * @version 2020-10-04-21:39
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }
}
