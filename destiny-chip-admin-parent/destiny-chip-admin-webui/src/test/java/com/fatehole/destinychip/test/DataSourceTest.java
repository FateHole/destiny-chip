package com.fatehole.destinychip.test;

import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.mapper.AdminMapper;
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
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testConnection() throws SQLException {

        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }

    @Test
    public void testInsert() {
        Admin admin = new Admin(null, "admin", "命猫", "12138", "admin@outlook.com", new Date());
        int row = adminMapper.insert(admin);
        System.out.println("受影响的行数：" + row);
    }

}
