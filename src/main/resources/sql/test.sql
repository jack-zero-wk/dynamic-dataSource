/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-03-07 13:59:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for datasource
-- ----------------------------
DROP TABLE IF EXISTS `datasource`;
CREATE TABLE `datasource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `host` varchar(50) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `dbName` varchar(100) DEFAULT NULL,
  `dbUser` varchar(50) DEFAULT NULL,
  `dbPwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datasource
-- ----------------------------
INSERT INTO `datasource` VALUES ('1', '192.168.200.135', '3306', 'db_admin', 'root', '123456');
INSERT INTO `datasource` VALUES ('2', '192.168.200.135', '3306', 'db_test', 'root', '123456');
INSERT INTO `datasource` VALUES ('3', '192.168.200.135', '3306', 'db_test2', 'root', '123456');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `datasourceId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `datasourceId` (`datasourceId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2017-06-28 11:54:56', 'test', 'e10adc3949ba59abbe56e057f20f883e', '上海市', '18888888888', '2');
INSERT INTO `user` VALUES ('2', '2017-06-28 14:58:38', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '上海市', '18888888889', '1');
INSERT INTO `user` VALUES ('3', '2017-06-28 15:47:37', 'user1', 'e10adc3949ba59abbe56e057f20f883e', '上海市杨浦区', '18888888881', '3');
