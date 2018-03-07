/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : db_test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-03-07 14:00:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES ('1', 'asdfwef', 'http://localhost');
INSERT INTO `t_test` VALUES ('7', 'æ¢è¡Œ', '11');
INSERT INTO `t_test` VALUES ('8', 'æ˜¯', '');
INSERT INTO `t_test` VALUES ('9', 'æ˜¯', '');
INSERT INTO `t_test` VALUES ('10', 'åŽ»', '');
INSERT INTO `t_test` VALUES ('11', '啊', '');
