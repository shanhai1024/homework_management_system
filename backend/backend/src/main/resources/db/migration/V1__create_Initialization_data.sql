/*
 Navicat Premium Data Transfer

 Source Server         : localhostMysql
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : homework-management

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 13/05/2024 08:12:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `create_by` bigint DEFAULT NULL,
                        `create_time` datetime(6) DEFAULT NULL,
                        `del_flag` int DEFAULT NULL,
                        `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `update_by` bigint DEFAULT NULL,
                        `update_time` datetime(6) DEFAULT NULL,
                        `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` (`id`, `component`, `create_by`, `create_time`, `del_flag`, `icon`, `menu_name`, `path`, `perms`, `remark`, `status`, `update_by`, `update_time`, `visible`) VALUES (1, 'api/v1/getData', NULL, NULL, NULL, NULL, '获取数据', 'api/v1/getData', 'getData', NULL, '0', NULL, NULL, '0');
INSERT INTO `menu` (`id`, `component`, `create_by`, `create_time`, `del_flag`, `icon`, `menu_name`, `path`, `perms`, `remark`, `status`, `update_by`, `update_time`, `visible`) VALUES (2, 'api/v1/addData', NULL, NULL, NULL, NULL, '添加数据', 'api/v1/addData', 'addData', NULL, '0', NULL, NULL, '0');
COMMIT;

-- ----------------------------
-- Table structure for menu_copy1
-- ----------------------------
DROP TABLE IF EXISTS `menu_copy1`;
CREATE TABLE `menu_copy1` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `create_by` bigint DEFAULT NULL,
                              `create_time` datetime(6) DEFAULT NULL,
                              `del_flag` int DEFAULT NULL,
                              `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `update_by` bigint DEFAULT NULL,
                              `update_time` datetime(6) DEFAULT NULL,
                              `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of menu_copy1
-- ----------------------------
BEGIN;
INSERT INTO `menu_copy1` (`id`, `component`, `create_by`, `create_time`, `del_flag`, `icon`, `menu_name`, `path`, `perms`, `remark`, `status`, `update_by`, `update_time`, `visible`) VALUES (1, 'api/v1/getData', NULL, NULL, NULL, NULL, '获取数据', 'api/v1/getData', 'getData', NULL, '0', NULL, NULL, '0');
INSERT INTO `menu_copy1` (`id`, `component`, `create_by`, `create_time`, `del_flag`, `icon`, `menu_name`, `path`, `perms`, `remark`, `status`, `update_by`, `update_time`, `visible`) VALUES (2, 'api/v1/addData', NULL, NULL, NULL, NULL, '添加数据', 'api/v1/addData', 'addData', NULL, '0', NULL, NULL, '0');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `create_by` bigint DEFAULT NULL,
                        `create_time` datetime(6) DEFAULT NULL,
                        `del_flag` int DEFAULT NULL,
                        `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `role_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `update_by` bigint DEFAULT NULL,
                        `update_time` datetime(6) DEFAULT NULL,
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`id`, `create_by`, `create_time`, `del_flag`, `name`, `remark`, `role_key`, `status`, `update_by`, `update_time`) VALUES (1, NULL, NULL, 0, '开发', NULL, 'dev', '0', NULL, NULL);
INSERT INTO `role` (`id`, `create_by`, `create_time`, `del_flag`, `name`, `remark`, `role_key`, `status`, `update_by`, `update_time`) VALUES (2, NULL, NULL, 0, '运维', NULL, 'ops', '0', NULL, NULL);
INSERT INTO `role` (`id`, `create_by`, `create_time`, `del_flag`, `name`, `remark`, `role_key`, `status`, `update_by`, `update_time`) VALUES (3, NULL, NULL, 0, '测试', NULL, 'test', '0', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `menu_id` bigint DEFAULT NULL,
                             `role_id` bigint DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
BEGIN;
INSERT INTO `role_menu` (`id`, `menu_id`, `role_id`) VALUES (1, 1, 1);
INSERT INTO `role_menu` (`id`, `menu_id`, `role_id`) VALUES (2, 2, 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `create_by` bigint DEFAULT NULL,
                        `create_time` datetime(6) DEFAULT NULL,
                        `del_flag` int DEFAULT NULL,
                        `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `phonenumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `update_by` bigint DEFAULT NULL,
                        `update_time` datetime(6) DEFAULT NULL,
                        `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `user_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        PRIMARY KEY (`id`) USING BTREE,
                        UNIQUE KEY `UK_d2ia11oqhsynodbsi46m80vfc` (`nick_name`) USING BTREE,
                        UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `phonenumber`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`) VALUES (1, NULL, 1, NULL, NULL, NULL, '11', '$2a$10$28Os0hH/pgFVU79lA/qW/OtTx0v8BnHjipEAd7wQDXYJbm51G/DW2', NULL, NULL, NULL, NULL, '2023-10-19 15:10:58.475000', '11', NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `phonenumber`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`) VALUES (3, NULL, 1, NULL, NULL, NULL, 'Test', '$2a$10$WT5kwm8tFqmz/0V7tmKqlOztz4fZbY5/kxQTTi9paOEHch6u.oMnq', NULL, NULL, NULL, NULL, '2023-11-01 09:44:00.091000', 'Test', NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `phonenumber`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`) VALUES (6, NULL, 1, NULL, NULL, NULL, '22', '$2a$10$u45sWnbrYwZL2M0bT9ewZ.h5l8GSfQOMRlXs/YVe0OoXclqbfFkOy', NULL, NULL, NULL, NULL, '2023-11-01 09:51:31.876000', '22', NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `phonenumber`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`) VALUES (7, NULL, 1, NULL, NULL, NULL, '33', '$2a$10$hkowX7vdSb1OJNnUZm47fOFPVDukV8UlOERQpcZrsw7q0yqbVIfwm', NULL, NULL, NULL, NULL, '2023-11-01 09:52:59.959000', '33', NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `phonenumber`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`) VALUES (8, NULL, 1, NULL, NULL, NULL, '55', '$2a$10$xD4WG.gwPfRYxTpClwUXzeRAiDBVeyedQ9O7pAQ3qyt0aV5U1yNt2', NULL, NULL, NULL, NULL, '2023-11-01 09:59:27.792000', '55', NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `phonenumber`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`) VALUES (11, NULL, 1, NULL, NULL, NULL, '4545', '$2a$10$4Q9snDmpo1Z4BV/o7c3Iz.toaMwdKJMAp9yjKavbEjHp9yYUfdr/S', NULL, NULL, NULL, NULL, '2023-11-06 17:05:39.691000', '4545', NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `phonenumber`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`) VALUES (12, NULL, 1, NULL, NULL, NULL, '99', '$2a$10$FP4toTE/Q7NknNEtSiC.guhaz54xXnBk4Vo6TuuaccNgSdF471tHe', NULL, NULL, NULL, NULL, '2023-11-16 21:11:55.589000', '99', NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `phonenumber`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`) VALUES (14, NULL, 1, NULL, NULL, NULL, '66', '$2a$10$NX4nLwY2QVNtmS0gI9wxN.EwoyJCyiNBQMmI6.N7pIqftmk4WWCK6', NULL, NULL, NULL, NULL, '2023-11-17 10:29:48.185000', '66', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `role_id` bigint DEFAULT NULL,
                             `user_id` bigint DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` (`id`, `role_id`, `user_id`) VALUES (1, 1, 1);
INSERT INTO `user_role` (`id`, `role_id`, `user_id`) VALUES (2, 2, 1);
INSERT INTO `user_role` (`id`, `role_id`, `user_id`) VALUES (3, 1, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
