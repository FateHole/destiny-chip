package com.fatehole.destinychip.test;

import com.fatehole.destinychip.entity.po.MemberPO;
import com.fatehole.destinychip.mapper.MemberPOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/01/21:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private DataSource dataSource;

    private final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

    @Autowired(required = false)
    private MemberPOMapper memberPOMapper;

    @Test
    public void testConnection() throws SQLException {

        Connection connection = dataSource.getConnection();
        logger.debug(connection.toString());
    }

    @Test
    public void testMapper() {
        MemberPO memberPO = new MemberPO(null, "jack", "界为", new BCryptPasswordEncoder().encode("12138"), "jack@qq.com", 1, 1, "杰克", "12131231", 2);
        memberPOMapper.insert(memberPO);
    }
}
