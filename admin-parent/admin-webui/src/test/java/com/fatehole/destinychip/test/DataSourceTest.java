package com.fatehole.destinychip.test;

import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.mapper.AdminMapper;
import com.fatehole.destinychip.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author FateCat
 * @version 2020-10-03-14:43
 *
 * spring整合junit
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testConnection() throws SQLException {

        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }

    @Test
    public void testInsert() {
        Admin admin = new Admin(null, "chip", "芯片", "E10ADC3949BA59ABBE56E057F20F883E", "chip@168.com", new Date());

        int row = adminMapper.insert(admin);

        System.out.println("受影响的行数：" + row);
    }

    @Test
    public void testTX() {
        adminService.saveAdmin(new Admin(null, "Tom", "汤包", "1234567", "tom@163.com", new Date()));
    }

}
