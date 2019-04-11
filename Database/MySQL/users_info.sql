/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : invoice

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 11/04/2019 08:38:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users_info
-- ----------------------------
DROP TABLE IF EXISTS `users_info`;
CREATE TABLE `users_info`  (
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(11) NOT NULL,
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'user information' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_info
-- ----------------------------
INSERT INTO `users_info` VALUES ('frankie', 23, '71b7546f-5bee-11e9-84f8-00ff7b45dafa');
INSERT INTO `users_info` VALUES ('asan', 24, '');
INSERT INTO `users_info` VALUES ('pangzi', 22, '');
INSERT INTO `users_info` VALUES ('pangzi2', 23, '');
INSERT INTO `users_info` VALUES ('Qin', 25, 'b15414c4-c6c5-4b26-9498-279ea06276f0');

SET FOREIGN_KEY_CHECKS = 1;
