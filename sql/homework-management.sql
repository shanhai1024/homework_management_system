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

 Date: 20/05/2024 21:34:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of categories
-- ----------------------------
BEGIN;
INSERT INTO `categories` (`id`, `name`) VALUES (1, '学生');
INSERT INTO `categories` (`id`, `name`) VALUES (2, '教师');
INSERT INTO `categories` (`id`, `name`) VALUES (3, '物业');
INSERT INTO `categories` (`id`, `name`) VALUES (4, '经营者');
INSERT INTO `categories` (`id`, `name`) VALUES (5, '其他');
COMMIT;

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of flyway_schema_history
-- ----------------------------
BEGIN;
INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES (1, '1', 'create Initialization data', 'SQL', 'V1__create_Initialization_data.sql', 1916892707, 'root', '2024-05-13 10:27:01', 161, 1);
INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES (2, '2', 'create echartsData', 'SQL', 'V2__create_echartsData.sql', -857170434, 'root', '2024-05-20 14:32:26', 87, 1);
COMMIT;

-- ----------------------------
-- Table structure for mandates
-- ----------------------------
DROP TABLE IF EXISTS `mandates`;
CREATE TABLE `mandates` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cut_off_time` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `upload_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mandates
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_by` bigint DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `del_flag` int DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` date DEFAULT NULL,
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
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id` int NOT NULL,
  `create_time` date DEFAULT NULL,
  `mandate_id` int DEFAULT NULL,
  `path_name` varchar(255) DEFAULT NULL,
  `statu` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of operation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` bigint DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `del_flag` int DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` date DEFAULT NULL,
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
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_d2ia11oqhsynodbsi46m80vfc` (`nick_name`) USING BTREE,
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (1, NULL, 1, NULL, NULL, NULL, '11', '$2a$10$28Os0hH/pgFVU79lA/qW/OtTx0v8BnHjipEAd7wQDXYJbm51G/DW2', NULL, NULL, NULL, '2023-10-19 15:10:58.475000', '11', NULL, '18187294890');
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (3, NULL, 1, NULL, NULL, NULL, 'Test', '$2a$10$WT5kwm8tFqmz/0V7tmKqlOztz4fZbY5/kxQTTi9paOEHch6u.oMnq', NULL, NULL, NULL, '2023-11-01 09:44:00.091000', 'Test', NULL, NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (6, NULL, 1, NULL, NULL, NULL, '22', '$2a$10$u45sWnbrYwZL2M0bT9ewZ.h5l8GSfQOMRlXs/YVe0OoXclqbfFkOy', NULL, NULL, NULL, '2023-11-01 09:51:31.876000', '22', NULL, NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (7, NULL, 1, NULL, NULL, NULL, '33', '$2a$10$hkowX7vdSb1OJNnUZm47fOFPVDukV8UlOERQpcZrsw7q0yqbVIfwm', NULL, NULL, NULL, '2023-11-01 09:52:59.959000', '33', NULL, NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (8, NULL, 1, NULL, NULL, NULL, '55', '$2a$10$xD4WG.gwPfRYxTpClwUXzeRAiDBVeyedQ9O7pAQ3qyt0aV5U1yNt2', NULL, NULL, NULL, '2023-11-01 09:59:27.792000', '55', NULL, NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (11, NULL, 1, NULL, NULL, NULL, '4545', '$2a$10$4Q9snDmpo1Z4BV/o7c3Iz.toaMwdKJMAp9yjKavbEjHp9yYUfdr/S', NULL, NULL, NULL, '2023-11-06 17:05:39.691000', '4545', NULL, NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (12, NULL, 1, NULL, NULL, NULL, '99', '$2a$10$FP4toTE/Q7NknNEtSiC.guhaz54xXnBk4Vo6TuuaccNgSdF471tHe', NULL, NULL, NULL, '2023-11-16 21:11:55.589000', '99', NULL, NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (14, NULL, 1, NULL, NULL, NULL, '66', '$2a$10$NX4nLwY2QVNtmS0gI9wxN.EwoyJCyiNBQMmI6.N7pIqftmk4WWCK6', NULL, NULL, NULL, '2023-11-17 10:29:48.185000', '66', NULL, NULL);
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (15, NULL, 1, NULL, NULL, NULL, NULL, '$2a$10$lb7juMwRJpQJIG0NUjaF0efj62KmQOEvUOdmLvuNcH4S0q/G7d9xq', NULL, NULL, NULL, '2024-05-19 12:07:13.469000', NULL, NULL, '15750013702');
INSERT INTO `user` (`id`, `avatar`, `create_by`, `create_time`, `del_flag`, `email`, `nick_name`, `password`, `sex`, `status`, `update_by`, `update_time`, `user_name`, `user_type`, `phone_number`) VALUES (16, NULL, 1, NULL, NULL, NULL, NULL, '$2a$10$OmX9pH5p1XwTm1NyH9aeRev9puWdLOX6/JBgXTc7Y6xCNj.Wjn4aC', NULL, NULL, NULL, '2024-05-19 12:20:38.844000', NULL, NULL, '15750013702');
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

-- ----------------------------
-- Table structure for yearly_data
-- ----------------------------
DROP TABLE IF EXISTS `yearly_data`;
CREATE TABLE `yearly_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `year` int NOT NULL,
  `value` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `yearly_data_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of yearly_data
-- ----------------------------
BEGIN;
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (1, 1, 2012, 56.50);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (2, 1, 2013, 82.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (3, 1, 2014, 88.70);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (4, 1, 2015, 70.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (5, 1, 2016, 53.40);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (6, 1, 2017, 300.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (7, 2, 2012, 51.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (8, 2, 2013, 51.40);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (9, 2, 2014, 55.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (10, 2, 2015, 53.30);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (11, 2, 2016, 73.80);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (12, 2, 2017, 68.70);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (13, 3, 2012, 40.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (14, 3, 2013, 62.20);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (15, 3, 2014, 69.50);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (16, 3, 2015, 36.40);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (17, 3, 2016, 45.20);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (18, 3, 2017, 32.50);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (19, 4, 2012, 25.20);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (20, 4, 2013, 37.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (21, 4, 2014, 41.20);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (22, 4, 2015, 18.00);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (23, 4, 2016, 33.90);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (24, 4, 2017, 49.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (25, 5, 2012, 25.20);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (26, 5, 2013, 37.10);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (27, 5, 2014, 41.20);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (28, 5, 2015, 18.00);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (29, 5, 2016, 33.90);
INSERT INTO `yearly_data` (`id`, `category_id`, `year`, `value`) VALUES (30, 5, 2017, 49.10);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
