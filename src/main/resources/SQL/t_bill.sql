/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-09-20 15:31:46
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
  `bill_percent` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bill
-- ----------------------------
INSERT INTO `t_bill` VALUES ('1', '李田田代购公司1', '李田田1', '13588888889', '宣传单11', '2000', '100', '200000', '铜版纸11', '尾款结清', '100%');
INSERT INTO `t_bill` VALUES ('2', '公司2', '关羽', '1356789234', '圣旨', '10', '1000', '10000', '金色', '已交定金', '20%');
INSERT INTO `t_bill` VALUES ('3', '公司3', '刘备', '13792214223', '草鞋宣传单', '100', '10', '1000', '尽快印刷好', '接到活儿', '10%');
