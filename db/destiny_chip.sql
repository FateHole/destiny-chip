CREATE DATABASE `destiny_chip` CHARACTER SET utf8mb4;

USE `destiny_chip`;

DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
    `id` INT NOT NULL AUTO_INCREMENT,               # 主键
    `login_account` VARCHAR(255) DEFAULT NULL,      # 登陆账号
    `username` VARCHAR(30) DEFAULT NULL,            # 用户昵称
    `password` VARCHAR(50) DEFAULT NULL,            # 登陆密码
    `email` VARCHAR(50) DEFAULT NULL,               # 邮箱地址
    `create_time` DATETIME,                         # 创建时间
    PRIMARY KEY (`id`)
)