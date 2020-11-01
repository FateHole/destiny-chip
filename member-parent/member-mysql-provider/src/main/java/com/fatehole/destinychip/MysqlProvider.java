package com.fatehole.destinychip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/01/21:54
 */
@MapperScan("com.fatehole.destinychip.mapper")
@SpringBootApplication
public class MysqlProvider {

    public static void main(String[] args) {
        SpringApplication.run(MysqlProvider.class, args);
    }
}
