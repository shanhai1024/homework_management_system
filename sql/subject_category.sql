/*
 Navicat Premium Data Transfer

 Source Server         : localhostMysql
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : jichi-clubh

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 14/05/2024 15:41:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for subject_category
-- ----------------------------
DROP TABLE IF EXISTS `subject_category`;
CREATE TABLE `subject_category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_name` varchar(16) DEFAULT NULL COMMENT '分类名称',
  `category_type` tinyint DEFAULT NULL COMMENT '分类类型',
  `image_url` varchar(64) DEFAULT NULL COMMENT '图标连接',
  `parent_id` bigint DEFAULT NULL COMMENT '父级id',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除 0: 未删除 1: 已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COMMENT='题目分类';

SET FOREIGN_KEY_CHECKS = 1;
