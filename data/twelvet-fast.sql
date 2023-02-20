/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726 (5.7.26-log)
 Source Host           : dev:3306
 Source Schema         : twelvet-fast

 Target Server Type    : MySQL
 Target Server Version : 50726 (5.7.26-log)
 File Encoding         : 65001

 Date: 20/02/2023 10:18:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_login_info_0
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_info_0`;
CREATE TABLE `sys_login_info_0`  (
                                     `id` bigint(20) NOT NULL COMMENT '访问ID',
                                     `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '用户账号',
                                     `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '登录IP地址',
                                     `status` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '登录状态（0登录成功 1登录失败 2成功退出）',
                                     `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '提示信息',
                                     `access_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
                                     `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_login_info_1
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_info_1`;
CREATE TABLE `sys_login_info_1`  (
                                     `id` bigint(20) NOT NULL COMMENT '访问ID',
                                     `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '用户账号',
                                     `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '登录IP地址',
                                     `status` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '登录状态（0登录成功 1登录失败 2成功退出）',
                                     `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '提示信息',
                                     `access_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
                                     `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_login_info_2
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_info_2`;
CREATE TABLE `sys_login_info_2`  (
                                     `id` bigint(20) NOT NULL COMMENT '访问ID',
                                     `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '用户账号',
                                     `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '登录IP地址',
                                     `status` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '登录状态（0登录成功 1登录失败 2成功退出）',
                                     `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '提示信息',
                                     `access_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
                                     `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_login_info_3
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_info_3`;
CREATE TABLE `sys_login_info_3`  (
                                     `id` bigint(20) NOT NULL COMMENT '访问ID',
                                     `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '用户账号',
                                     `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '登录IP地址',
                                     `status` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '登录状态（0登录成功 1登录失败 2成功退出）',
                                     `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '提示信息',
                                     `access_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
                                     `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
