/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : db5

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2020-10-25 10:52:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT '编号',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '1234');
INSERT INTO `user` VALUES ('2', 'user1', '1234');
