/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 127.0.0.1:3306
 Source Schema         : apps

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 04/07/2020 14:10:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `last_app_publish_id` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `logo` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tags` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime DEFAULT NULL,
  `deleted` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for app_publish
-- ----------------------------
DROP TABLE IF EXISTS `app_publish`;
CREATE TABLE `app_publish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` int(11) NOT NULL,
  `package_size` double DEFAULT NULL,
  `package_address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `version` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `tags` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `subject` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_information` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `created_time` datetime NOT NULL,
  `updated_time` datetime DEFAULT NULL,
  `deleted` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
