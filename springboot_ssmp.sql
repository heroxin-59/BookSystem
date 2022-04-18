/*
 Navicat Premium Data Transfer

 Source Server         : conn-localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : springboot_ssmp

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 18/04/2022 19:43:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Java', '语言', '从入门到入土');
INSERT INTO `book` VALUES (2, 'MySql', '数据库', '从删库到跑路');
INSERT INTO `book` VALUES (3, 'Spring', '框架', '开放源代码的J2EE应用程序框架');
INSERT INTO `book` VALUES (4, 'Python', '语言', '从入门到入牢');
INSERT INTO `book` VALUES (5, 'SpringBoot', '框架', '有手就行');
INSERT INTO `book` VALUES (6, 'NoSql', '数据库', '没学过');
INSERT INTO `book` VALUES (7, 'JavaWeb', '框架', '老旧知识，有丁点用');
INSERT INTO `book` VALUES (8, '操作系统', '理论', '狗看了都摇头');
INSERT INTO `book` VALUES (9, 'heroxin', '测试', 'xixi');
INSERT INTO `book` VALUES (14, 'heroxin', '测试数据123', '测试数据123');
INSERT INTO `book` VALUES (15, 'bb', 'aa', 'cc');
INSERT INTO `book` VALUES (16, 'wen', 'yan', 'jing\n');
INSERT INTO `book` VALUES (17, 'jing', 'wen', 'wenjing\n');
INSERT INTO `book` VALUES (18, 'jing', 'wen', 'hahah\n');
INSERT INTO `book` VALUES (19, '23244', '123', 'wersfsdfsd');
INSERT INTO `book` VALUES (20, 'heroxin', 'sdf', 'dsf');
INSERT INTO `book` VALUES (21, 'heroxins', 'sdf', 'sdfsd');
INSERT INTO `book` VALUES (22, 'heroxins', 'df', 'heroxin');
INSERT INTO `book` VALUES (23, 'ee', '11', 'ww');
INSERT INTO `book` VALUES (24, 'sdf', 'sdf', 'sdf');

SET FOREIGN_KEY_CHECKS = 1;
