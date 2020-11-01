CREATE DATABASE `destiny_chip` CHARACTER SET utf8mb4;

USE `destiny_chip`;

-- 管理员表
DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `login_account` VARCHAR(255) NULL UNIQUE DEFAULT NULL COMMENT '登陆账号',
    `username` VARCHAR(30) NULL DEFAULT NULL COMMENT '用户昵称',
    `password` VARCHAR(255) NULL DEFAULT NULL COMMENT '登陆密码',
    `email` VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱地址',
    `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
);

-- 角色表
DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` VARCHAR(100) NULL DEFAULT NULL COMMENT '表名',
    PRIMARY KEY (`id`)
);

-- 菜单表
DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `pid` INT NULL DEFAULT NULL COMMENT '父节点ID',
    `name` VARCHAR(200) NULL DEFAULT NULL COMMENT '节点名称',
    `url` VARCHAR(200) NULL DEFAULT NULL COMMENT '节点关联路径',
    `icon` VARCHAR(200) NULL DEFAULT NULL COMMENT '图标样式',
    PRIMARY KEY (`id`)
);

-- 管理员角色中间表
DROP TABLE IF EXISTS `inner_admin_role`;

CREATE TABLE `inner_admin_role` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `admin_id` INT NULL DEFAULT NULL COMMENT '管理员ID',
    `role_id` INT NULL DEFAULT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`)
);

-- 权限表
DROP TABLE IF EXISTS `t_auth`;

CREATE TABLE `t_auth` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` VARCHAR(200) NULL DEFAULT NULL COMMENT '权限值',    # 给资源分配权限时使用的值「英文」
    `title` VARCHAR(200) NULL DEFAULT NULL COMMENT '权限名',   # 在页面上显示，让用户便于查看的值「中文」
    `category_id` INT NULL DEFAULT NULL COMMENT '权限分类',
    PRIMARY KEY (`id`)
);

-- 角色权限中间表
DROP TABLE IF EXISTS `inner_role_auth`;

CREATE TABLE `inner_role_auth` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `role_id` INT NULL DEFAULT NULL COMMENT '角色ID',
    `auth_id` INT NULL DEFAULT NULL COMMENT '权限ID',
    PRIMARY KEY (`id`)
);

-- 会员表
DROP TABLE IF EXISTS `t_member`;

CREATE TABLE `t_member` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `login_account` VARCHAR(255) NULL UNIQUE DEFAULT NULL COMMENT '登陆账号',
    `username` VARCHAR(30) NULL DEFAULT NULL COMMENT '用户昵称',
    `password` VARCHAR(255) NULL DEFAULT NULL COMMENT '登陆密码',
    `email` VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱地址',
    `auth_status` INT NULL DEFAULT 0 COMMENT '0 - 未实名认证、1 - 实名认证申请中、2 - 已实名认证',
    `user_type` INT NULL DEFAULT NULL COMMENT '0 - 个人、1 - 企业',
    `real_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '真实姓名',
    `card_number` VARCHAR(255) NULL DEFAULT NULL COMMENT '卡号',
    `account_type` INT NULL DEFAULT NULL COMMENT '0 - 企业、1 - 个体、2 - 个人、3 - 政府',
    PRIMARY KEY (`id`)
);