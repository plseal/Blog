/*
Navicat MySQL Data Transfer

Source Server         : localhost1
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-06-13 00:14:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_express
-- ----------------------------
DROP TABLE IF EXISTS `t_express`;
CREATE TABLE `t_express` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `e_from` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=493 DEFAULT CHARSET=utf8;
