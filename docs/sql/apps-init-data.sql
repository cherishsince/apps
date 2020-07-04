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

 Date: 04/07/2020 14:07:31
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
-- Records of app
-- ----------------------------
BEGIN;
INSERT INTO `app` VALUES (1, NULL, NULL, NULL, '网易云音乐', 'https://dss1.bdstatic.com/6OF1bjeh1BF3odCf/it/u=3438481165,1970845286&fm=74&app=80&f=PNG&size=f121,121?sec=1880279984&t=7c1333975198c371732774d54cbeb1e3', 'Android、iOS', '网易云', '2020-07-04 09:21:56', NULL, 0);
INSERT INTO `app` VALUES (2, 1, 2, NULL, '网易云音乐(开发版)', 'https://dss1.bdstatic.com/6OF1bjeh1BF3odCf/it/u=3438481165,1970845286&fm=74&app=80&f=PNG&size=f121,121?sec=1880279984&t=7c1333975198c371732774d54cbeb1e3', 'Android', 'Android 网易云', '2020-07-04 09:22:37', NULL, 0);
INSERT INTO `app` VALUES (3, 1, NULL, NULL, '网易云音乐(测试版)', 'https://dss1.bdstatic.com/6OF1bjeh1BF3odCf/it/u=3438481165,1970845286&fm=74&app=80&f=PNG&size=f121,121?sec=1880279984&t=7c1333975198c371732774d54cbeb1e3', 'Android', 'Android 网易云', '2020-07-04 09:23:06', NULL, 0);
INSERT INTO `app` VALUES (4, 1, 12, NULL, '网易云音乐(预发布版)', 'https://dss1.bdstatic.com/6OF1bjeh1BF3odCf/it/u=3438481165,1970845286&fm=74&app=80&f=PNG&size=f121,121?sec=1880279984&t=7c1333975198c371732774d54cbeb1e3', 'iOS', 'iOS 版本', '2020-07-04 09:24:04', NULL, 0);
INSERT INTO `app` VALUES (5, 1, 4, NULL, '网易云音乐(发布版)', 'https://dss1.bdstatic.com/6OF1bjeh1BF3odCf/it/u=3438481165,1970845286&fm=74&app=80&f=PNG&size=f121,121?sec=1880279984&t=7c1333975198c371732774d54cbeb1e3', 'Mac', 'Mac版本', '2020-07-04 12:07:39', NULL, 0);
INSERT INTO `app` VALUES (10, NULL, NULL, NULL, 'QQ音乐', 'https://dss0.bdstatic.com/6Ox1bjeh1BF3odCf/it/u=3182904533,679607419&fm=74&app=80&f=PNG&size=f121,121?sec=1880279984&t=72cab909b2d45615ac780ab8545449d5', 'Android', 'QQ 音乐', '2020-07-04 09:25:13', NULL, 0);
INSERT INTO `app` VALUES (11, 10, NULL, NULL, 'QQ音乐-Mac版本', 'https://dss0.bdstatic.com/6Ox1bjeh1BF3odCf/it/u=3182904533,679607419&fm=74&app=80&f=PNG&size=f121,121?sec=1880279984&t=72cab909b2d45615ac780ab8545449d5', 'Mac', 'QQ音乐-Mac版本', '2020-07-04 12:07:01', NULL, 0);
INSERT INTO `app` VALUES (12, 10, NULL, NULL, 'QQ音乐-Windows版本', 'https://dss0.bdstatic.com/6Ox1bjeh1BF3odCf/it/u=3182904533,679607419&fm=74&app=80&f=PNG&size=f121,121?sec=1880279984&t=72cab909b2d45615ac780ab8545449d5', 'Windows', 'QQ音乐-Windows版本', '2020-07-04 12:32:43', NULL, 0);
COMMIT;

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

-- ----------------------------
-- Records of app_publish
-- ----------------------------
BEGIN;
INSERT INTO `app_publish` VALUES (2, 2, 22.1, 'https://aszs-test-download.oss-cn-shenzhen.aliyuncs.com/data/upload/apk/2020/7/3/f8bfc01e9b9e.apk', '33.3', 'iOS', '需要卸载重装', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 09:55:04', NULL, 0);
INSERT INTO `app_publish` VALUES (3, 5, 89.2, 'http://d1.music.126.net/dmusic/NeteaseMusic_2.3.2_832_web.dmg', '2020.04.23', 'Mac', '2020新版本', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (4, 5, 89.2, 'http://d1.music.126.net/dmusic/NeteaseMusic_2.3.2_832_web.dmg', '2020.04.23', 'Mac', '2020新版本-1', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (5, 5, 89.2, 'http://d1.music.126.net/dmusic/NeteaseMusic_2.3.2_832_web.dmg', '2020.04.23', 'Mac', '2020新版本-2', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (6, 5, 89.2, 'http://d1.music.126.net/dmusic/NeteaseMusic_2.3.2_832_web.dmg', '2020.04.23', 'Mac', '2020新版本-3', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (7, 5, 89.2, 'http://d1.music.126.net/dmusic/NeteaseMusic_2.3.2_832_web.dmg', '2020.04.23', 'Mac', '2020新版本-4', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (8, 2, 89.2, 'http://d1.music.126.net/dmusic/NeteaseMusic_2.3.2_832_web.dmg', '2020.04.23', 'Mac', '2020新版本-4', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (9, 4, 89.2, 'https://aszs-test-download.oss-cn-shenzhen.aliyuncs.com/data/upload/ipa/2020/6/8/d4ecd10359c2.ipa,https://test.mc.cn/data/upload/2020/6/8/8e186c458ed2.plist', '2020.04.23', 'Mac', '2020新版本-10', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (10, 4, 89.2, 'https://aszs-test-download.oss-cn-shenzhen.aliyuncs.com/data/upload/ipa/2020/6/8/d4ecd10359c2.ipa,https://test.mc.cn/data/upload/2020/6/8/8e186c458ed2.plist', '2020.04.23', 'Mac', '2020新版本-11', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (11, 2, 89.2, 'http://d1.music.126.net/dmusic/NeteaseMusic_2.3.2_832_web.dmg', '2020.04.23', 'Mac', '2020新版本-13', '修复bug\n\n1.优化-数据库查询结构\n2.优化-数据计算问题\n3.优化-处理数据溢出，和内存溢出，各种溢出', '2020-07-04 12:09:28', NULL, 0);
INSERT INTO `app_publish` VALUES (12, 4, 23.4, 'https://aszs-test-download.oss-cn-shenzhen.aliyuncs.com/data/upload/ipa/2020/6/8/d4ecd10359c2.ipa,https://test.mc.cn/data/upload/2020/6/8/8e186c458ed2.plist', '1.0.1', 'Android', '2020新UI新视觉', '主程序:\n1.接入聊天xx\n2.播放模块（开发中）\n\n修复bug\n播放器：\n1.解决iOS后台不能播放问题\n\n聊天模块：\n 1.未添加好友，不应该有备注头像\n2.备注了头像，消息列表页、聊天对话页、加我的人页，也要更改头像\n3.提示设置头像成功，实际病没有生效，点进去查看的时候显示备注头像\n4.点击备注头像选择查看大图，依然显示原头像\n\n提现铃声:\n1.离线状态下，点击事件时，应该提示无网络\n2.离线状态下播放限制\n3.增加iOS临时设置\n4.优化Android10.0新功能\n5.网络异常提醒页面', '2020-07-04 09:54:12', NULL, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
