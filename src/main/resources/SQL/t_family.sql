/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-06-19 21:07:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_family
-- ----------------------------
DROP TABLE IF EXISTS `t_family`;
CREATE TABLE `t_family` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `lunar_birth` varchar(255) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `remind_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_family
-- ----------------------------
INSERT INTO `t_family` VALUES ('1', '宋明磊', null, null, null, null);
SET FOREIGN_KEY_CHECKS=1;
