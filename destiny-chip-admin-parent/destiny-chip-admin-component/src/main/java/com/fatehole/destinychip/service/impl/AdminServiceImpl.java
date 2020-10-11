package com.fatehole.destinychip.service.impl;

import com.fatehole.destinychip.constant.DestinyChipConstant;
import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.entity.AdminExample;
import com.fatehole.destinychip.exception.LoginAccountAlreadyInUserException;
import com.fatehole.destinychip.exception.LoginAccountAlreadyInUserForUpdateException;
import com.fatehole.destinychip.exception.LoginFailedException;
import com.fatehole.destinychip.mapper.AdminMapper;
import com.fatehole.destinychip.service.api.AdminService;
import com.fatehole.destinychip.util.DestinyChipUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Override
    public void saveAdmin(Admin admin) {
        // 密码加密
        String password = admin.getPassword();
        password = DestinyChipUtil.md5(password);
        admin.setPassword(password);

        // 生成创建时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimeStr = format.format(new Date());
        Date createTime = null;
        try {
            createTime = format.parse(createTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        admin.setCreateTime(createTime);

        // 执行
        try {
            adminMapper.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("异常全类名：" + e.getClass().getName());
            if (e instanceof DuplicateKeyException) {
                throw new LoginAccountAlreadyInUserException(DestinyChipConstant.MESSAGE_LOGIN_ACCOUNT_ALREADY_IN_USE);
            }
        }
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

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {

        // 调用PageHelper的静态方法，开启分页功能
        PageHelper.startPage(pageNum, pageSize);

        // 执行查询
        List<Admin> admins = adminMapper.selectAdminByKeyword(keyword);

        // 封装的PageInfo对象中
        return new PageInfo<>(admins);
    }

    @Override
    public void remove(Integer id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Admin admin) {
        // Selective表示有选择的更新，对null值不更新
        try {
            adminMapper.updateByPrimaryKeySelective(admin);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("异常全类名：" + e.getClass().getName());
            if (e instanceof DuplicateKeyException) {
                throw new LoginAccountAlreadyInUserForUpdateException(DestinyChipConstant.MESSAGE_LOGIN_ACCOUNT_ALREADY_IN_USE);
            }
        }
    }
}
