package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.constant.DestinyChipConstant;
import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.entity.AdminExample;
import com.fatehole.destinychip.exception.LoginFailedException;
import com.fatehole.destinychip.mapper.AdminMapper;
import com.fatehole.destinychip.service.api.AdminService;
import com.fatehole.destinychip.util.DestinyChipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Admin getAdminBbyLoginAccount(String loginAccount, String password) {

        // 1、根据登陆账号查询Admin对象
        // 创建一个AdminExample对象
        AdminExample adminExample = new AdminExample();
        // 创建AdminExample的内部类Criteria
        AdminExample.Criteria criteria = adminExample.createCriteria();
        // 在Criteria对象中封装查询条件
        criteria.andLoginAccountEqualTo(loginAccount);
        // 调用AdminMapper的方法进行查询
        List<Admin> admins = adminMapper.selectByExample(adminExample);

        // 2、判断Admin对象是否为null
        if (admins == null || admins.size() == 0) {
            throw new LoginFailedException(DestinyChipConstant.MESSAGE_LOGIN_FAILED);
        }

        if (admins.size() > 1) {
            throw new RuntimeException(DestinyChipConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }

        Admin admin = admins.get(0);

        // 3、如果Admin对象为null则抛出异常
        if (admin == null) {
            throw new LoginFailedException(DestinyChipConstant.MESSAGE_LOGIN_FAILED);
        }

        // 4、如果Admin对象不为null，则将密码从Admin对象中取出
        String databasePassword = admin.getPassword();

        // 5、将表单提交的明文密码进行md5加密
        String formPassword = DestinyChipUtil.md5(password);

        // 6、将加密结果于数据库中的加密密码相比较
        if (!Objects.equals(databasePassword, formPassword)) {
            // 7、如果不一致则抛出异常
            throw new LoginFailedException(DestinyChipConstant.MESSAGE_LOGIN_FAILED);
        } else {
            // 8、否则返回Admin对象
            return admin;
        }
    }
}
