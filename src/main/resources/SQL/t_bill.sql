/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-09-12 18:42:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_bill
-- ----------------------------
DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE `t_bill` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_contact` varchar(100) DEFAULT NULL,
  `customer_tel` varchar(100) DEFAULT NULL,
  `bill_name` varchar(100) DEFAULT NULL,
  `bill_num` varchar(100) DEFAULT NULL,
  `bill_unit_price` varchar(100) DEFAULT NULL,
  `bill_all_price` varchar(100) DEFAULT NULL,
  `bill_require` varchar(100) DEFAULT NULL,
  `bill_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bill
-- ----------------------------
INSERT INTO `t_bill` VALUES ('1', '李田田代购公司', null, null, '宣传单', null, null, null, null, '正在印刷');
