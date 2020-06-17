/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50645
Source Host           : localhost:3306
Source Database       : scu

Target Server Type    : MYSQL
Target Server Version : 50645
File Encoding         : 65001

Date: 2020-06-14 11:35:22
*/
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `reserve`
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotelId` varchar(255) NOT NULL,
  `roomId` varchar(255) NOT NULL,
  `createAt` varchar(255) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userPhone` decimal(10,0) DEFAULT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `checkInAt` varchar(255) NOT NULL,
  `checkOutAt` varchar(255) NOT NULL,
  `pay` int(11) DEFAULT NULL,
  `price` decimal(11,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES ('1323', '1297', '1', '2020-06-14', 'liyuke', '9999999999', '1323642423@qq.com', '2020-06-14', '2020-06-20', '1', '188');