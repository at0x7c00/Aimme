/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : admanager

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2015-12-06 13:46:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `agent_agent`
-- ----------------------------
DROP TABLE IF EXISTS `agent_agent`;
CREATE TABLE `agent_agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `lawperson` varchar(255) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `login_pwd` varchar(255) DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `service_email` varchar(255) DEFAULT NULL,
  `service_name` varchar(255) DEFAULT NULL,
  `service_phone` varchar(255) DEFAULT NULL,
  `service_qq` varchar(255) DEFAULT NULL,
  `status` enum('InUse','UnUse') DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK75EBD14B42231822` (`province_id`) USING BTREE,
  CONSTRAINT `agent_agent_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `agent_province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent_agent
-- ----------------------------
INSERT INTO `agent_agent` VALUES ('1', '', '-1', '2015-11-05 18:05:03', '', 'aaaa', 'aaaa', '6688a93ed4279c859b9a622ff23c6e14', 'a', '', '', '', '', '', '', 'InUse', '1');

-- ----------------------------
-- Table structure for `agent_area`
-- ----------------------------
DROP TABLE IF EXISTS `agent_area`;
CREATE TABLE `agent_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manageKey` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `_sort` int(11) DEFAULT NULL,
  `status` enum('InUse','UnUse') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent_area
-- ----------------------------
INSERT INTO `agent_area` VALUES ('1', 'ce164fc8ab7cddf718b37a9ef6c1c77e', 'a', '1', 'InUse');

-- ----------------------------
-- Table structure for `agent_consumptionrecord`
-- ----------------------------
DROP TABLE IF EXISTS `agent_consumptionrecord`;
CREATE TABLE `agent_consumptionrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `orgin_price` double DEFAULT NULL,
  `original_balance` double DEFAULT NULL,
  `remark` text,
  `type` enum('Comsumption','Debit') DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK37D441125BC3BC32` (`agent_id`) USING BTREE,
  CONSTRAINT `agent_consumptionrecord_ibfk_1` FOREIGN KEY (`agent_id`) REFERENCES `agent_agent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent_consumptionrecord
-- ----------------------------
INSERT INTO `agent_consumptionrecord` VALUES ('1', '1', '-1', '2015-11-06 10:23:42', null, '31fc0c60e47cd02e5724d60f674c46aa', '1', null, '0', '', 'Comsumption', '1');

-- ----------------------------
-- Table structure for `agent_province`
-- ----------------------------
DROP TABLE IF EXISTS `agent_province`;
CREATE TABLE `agent_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manageKey` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `_sort` int(11) DEFAULT NULL,
  `status` enum('InUse','UnUse') DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAECAF2A94F5C982` (`area`) USING BTREE,
  CONSTRAINT `agent_province_ibfk_1` FOREIGN KEY (`area`) REFERENCES `agent_area` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent_province
-- ----------------------------
INSERT INTO `agent_province` VALUES ('1', '1cd10914cfee967fe8f49c0e496da0c7', 'a', '1', 'InUse', '1');

-- ----------------------------
-- Table structure for `agent_recharge_record`
-- ----------------------------
DROP TABLE IF EXISTS `agent_recharge_record`;
CREATE TABLE `agent_recharge_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `check_remark` text,
  `check_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `original_balance` double DEFAULT NULL,
  `remark` text,
  `status` enum('Yes','No','Failed') DEFAULT NULL,
  `type` enum('Charge','Back') DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL,
  `checker_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK92925FAF5BC3BC32` (`agent_id`) USING BTREE,
  KEY `FK92925FAF12849760` (`checker_id`) USING BTREE,
  CONSTRAINT `agent_recharge_record_ibfk_1` FOREIGN KEY (`checker_id`) REFERENCES `sys_user` (`username`),
  CONSTRAINT `agent_recharge_record_ibfk_2` FOREIGN KEY (`agent_id`) REFERENCES `agent_agent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agent_recharge_record
-- ----------------------------
INSERT INTO `agent_recharge_record` VALUES ('1', '1', '1', null, null, '2015-11-05 20:17:28', 'b919fe9d997a7641e4d0c97e15a29d7e', '0', '', 'No', 'Back', '1', null);

-- ----------------------------
-- Table structure for `aud_audit_log`
-- ----------------------------
DROP TABLE IF EXISTS `aud_audit_log`;
CREATE TABLE `aud_audit_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aud_audit_log
-- ----------------------------

-- ----------------------------
-- Table structure for `cont_contract`
-- ----------------------------
DROP TABLE IF EXISTS `cont_contract`;
CREATE TABLE `cont_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` enum('Avaliable','InUsed','Destroy','Lost') DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `sys_log` text,
  `_apply_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK21D88B7F329EE45E` (`_apply_id`) USING BTREE,
  KEY `FK21D88B7FB51D69CF` (`type`) USING BTREE,
  CONSTRAINT `cont_contract_ibfk_1` FOREIGN KEY (`_apply_id`) REFERENCES `cont_contract_apply` (`id`),
  CONSTRAINT `cont_contract_ibfk_2` FOREIGN KEY (`type`) REFERENCES `cont_contract_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cont_contract
-- ----------------------------

-- ----------------------------
-- Table structure for `cont_contract_apply`
-- ----------------------------
DROP TABLE IF EXISTS `cont_contract_apply`;
CREATE TABLE `cont_contract_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` enum('UnProcess','Processing','Processed') DEFAULT NULL,
  `apply_time` datetime DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `process_remark` text,
  `process_time` datetime DEFAULT NULL,
  `remark` text,
  `total_price` double DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL,
  `contract_type` int(11) DEFAULT NULL,
  `processor_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK47E396AE5BC3BC32` (`agent_id`) USING BTREE,
  KEY `FK47E396AE965CECDC` (`contract_type`) USING BTREE,
  KEY `FK47E396AEA8C71163` (`processor_id`) USING BTREE,
  CONSTRAINT `cont_contract_apply_ibfk_1` FOREIGN KEY (`agent_id`) REFERENCES `agent_agent` (`id`),
  CONSTRAINT `cont_contract_apply_ibfk_2` FOREIGN KEY (`contract_type`) REFERENCES `cont_contract_type` (`id`),
  CONSTRAINT `cont_contract_apply_ibfk_3` FOREIGN KEY (`processor_id`) REFERENCES `sys_user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cont_contract_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `cont_contract_type`
-- ----------------------------
DROP TABLE IF EXISTS `cont_contract_type`;
CREATE TABLE `cont_contract_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_avaliable` bigint(20) DEFAULT NULL,
  `code_prefix` varchar(255) DEFAULT NULL,
  `_destroy` bigint(20) DEFAULT NULL,
  `_inused` bigint(20) DEFAULT NULL,
  `_lost` bigint(20) DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` enum('InUse','UnUse') DEFAULT NULL,
  `total_num` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cont_contract_type
-- ----------------------------

-- ----------------------------
-- Table structure for `cust_customer`
-- ----------------------------
DROP TABLE IF EXISTS `cust_customer`;
CREATE TABLE `cust_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_address` varchar(255) DEFAULT NULL,
  `company_lawperson` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `remark` text,
  `agent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7E66584A5BC3BC32` (`agent_id`) USING BTREE,
  CONSTRAINT `cust_customer_ibfk_1` FOREIGN KEY (`agent_id`) REFERENCES `agent_agent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cust_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `inter_interview`
-- ----------------------------
DROP TABLE IF EXISTS `inter_interview`;
CREATE TABLE `inter_interview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borardcast_remark` text,
  `borardcast_status` enum('NotBorardcast','Borardcasted') DEFAULT NULL,
  `cancel_remark` varchar(255) DEFAULT NULL,
  `cancel_time` datetime DEFAULT NULL,
  `check_remark` text,
  `check_status` enum('NotCheck','Checked','CheckFailed') DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `_guest` varchar(255) DEFAULT NULL,
  `guest_phone` varchar(255) DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `other_service_progress` text,
  `price` double DEFAULT NULL,
  `rec_remark` text,
  `rec_status` enum('NotRecord','Recorded') DEFAULT NULL,
  `recharge_record_key` varchar(255) DEFAULT NULL,
  `record_remark` text,
  `record_status` enum('NotRecord','Recorded') DEFAULT NULL,
  `remark` text,
  `return_amount` double DEFAULT NULL,
  `schedule_remark` text,
  `schedule_status` enum('NotSchedule','Scheduled') DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK17D5CDDE5BC3BC32` (`agent_id`) USING BTREE,
  KEY `FK17D5CDDE2850FB8A` (`user_id`) USING BTREE,
  KEY `FK17D5CDDEFE23EF6F` (`customer_id`) USING BTREE,
  KEY `FK17D5CDDEC271D448` (`product_id`) USING BTREE,
  CONSTRAINT `inter_interview_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`username`),
  CONSTRAINT `inter_interview_ibfk_2` FOREIGN KEY (`agent_id`) REFERENCES `agent_agent` (`id`),
  CONSTRAINT `inter_interview_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `pro_product` (`id`),
  CONSTRAINT `inter_interview_ibfk_4` FOREIGN KEY (`customer_id`) REFERENCES `cust_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inter_interview
-- ----------------------------

-- ----------------------------
-- Table structure for `mat_material`
-- ----------------------------
DROP TABLE IF EXISTS `mat_material`;
CREATE TABLE `mat_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manageKey` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` enum('InUse','UnUse') DEFAULT NULL,
  `storage_num` double DEFAULT NULL,
  `material_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK79CAFD267ADD68E7` (`material_type_id`) USING BTREE,
  CONSTRAINT `mat_material_ibfk_1` FOREIGN KEY (`material_type_id`) REFERENCES `mat_material_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mat_material
-- ----------------------------

-- ----------------------------
-- Table structure for `mat_material_order`
-- ----------------------------
DROP TABLE IF EXISTS `mat_material_order`;
CREATE TABLE `mat_material_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `num` double DEFAULT NULL,
  `status` enum('unProcess','Processing','Processed') DEFAULT NULL,
  `price` double DEFAULT NULL,
  `process_remark` text,
  `process_time` datetime DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL,
  `material_id` int(11) DEFAULT NULL,
  `processor_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8573F2F55BC3BC32` (`agent_id`) USING BTREE,
  KEY `FK8573F2F51C773218` (`material_id`) USING BTREE,
  KEY `FK8573F2F5A8C71163` (`processor_id`) USING BTREE,
  CONSTRAINT `mat_material_order_ibfk_1` FOREIGN KEY (`material_id`) REFERENCES `mat_material` (`id`),
  CONSTRAINT `mat_material_order_ibfk_2` FOREIGN KEY (`agent_id`) REFERENCES `agent_agent` (`id`),
  CONSTRAINT `mat_material_order_ibfk_3` FOREIGN KEY (`processor_id`) REFERENCES `sys_user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mat_material_order
-- ----------------------------

-- ----------------------------
-- Table structure for `mat_material_type`
-- ----------------------------
DROP TABLE IF EXISTS `mat_material_type`;
CREATE TABLE `mat_material_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manageKey` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `_sort` int(11) DEFAULT NULL,
  `status` enum('InUse','UnUse') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mat_material_type
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_product`
-- ----------------------------
DROP TABLE IF EXISTS `pro_product`;
CREATE TABLE `pro_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount` double DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_product
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_common_folder`
-- ----------------------------
DROP TABLE IF EXISTS `sys_common_folder`;
CREATE TABLE `sys_common_folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folder_name` varchar(100) NOT NULL,
  `store_path` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_common_folder
-- ----------------------------
INSERT INTO `sys_common_folder` VALUES ('1', 'test', 'C:/test');
INSERT INTO `sys_common_folder` VALUES ('2', '应用软件', 'C:/software/App');
INSERT INTO `sys_common_folder` VALUES ('3', '操作系统', 'C:/software/OS');
INSERT INTO `sys_common_folder` VALUES ('4', '补丁程序', 'C:/software/Patch');
INSERT INTO `sys_common_folder` VALUES ('5', '配置文件', 'C:/software/Config');
INSERT INTO `sys_common_folder` VALUES ('6', '脚本文件', 'C:/software/Script');

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_value` date DEFAULT NULL,
  `datetime_value` datetime DEFAULT NULL,
  `descripttion1` text,
  `descripttion2` text,
  `double_value` double DEFAULT NULL,
  `float_value` float DEFAULT NULL,
  `int_value` int(11) DEFAULT NULL,
  `name` text,
  `yes_no` enum('Yes','No') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', null, null, 'smtp.yeah.net', null, null, null, null, '主机', null);
INSERT INTO `sys_config` VALUES ('2', null, null, 'mistest', null, null, null, null, '用户名', null);
INSERT INTO `sys_config` VALUES ('3', null, null, '1234%abcd', null, null, null, null, '密码', null);
INSERT INTO `sys_config` VALUES ('4', null, null, 'Yes', null, null, null, null, '发送是否验证', 'Yes');
INSERT INTO `sys_config` VALUES ('5', null, null, 'mistest@yeah.net', null, null, null, null, '发送人', null);
INSERT INTO `sys_config` VALUES ('6', null, null, null, null, null, null, null, 'http://221.122.94.10/cgi-bin/os_install.py', null);
INSERT INTO `sys_config` VALUES ('7', null, null, null, null, null, null, null, 'http://221.122.94.10/cgi-bin/write_file_ansible.py', null);
INSERT INTO `sys_config` VALUES ('8', null, null, null, null, null, null, null, 'http://221.122.94.10/cgi-bin/write_file_ansible.py', null);
INSERT INTO `sys_config` VALUES ('9', null, null, null, null, null, null, null, 'http://221.122.94.10/cgi-bin/temp_analysis.py', null);
INSERT INTO `sys_config` VALUES ('10', null, null, null, null, null, null, null, 'http://221.122.94.10/cgi-bin/file_analysis.py', null);
INSERT INTO `sys_config` VALUES ('11', null, null, null, null, null, null, null, '/var/www/html/', null);
INSERT INTO `sys_config` VALUES ('12', null, null, null, null, null, null, null, 'http://221.122.94.10/cgi-bin/list_file.py', null);
INSERT INTO `sys_config` VALUES ('13', null, null, null, null, null, null, null, 'http://221.122.94.10/cgi-bin/rsync_file.py', null);
INSERT INTO `sys_config` VALUES ('14', null, null, null, null, null, null, null, 'http://221.122.94.10:8080/', null);

-- ----------------------------
-- Table structure for `sys_department`
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manageKey` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `_version` int(11) DEFAULT '0',
  `parent` int(11) DEFAULT NULL,
  `children` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `status` enum('InUse','UnUse') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1AC988045A30A5BA` (`parent`) USING BTREE,
  KEY `FK1AC988046F03BF01` (`children`) USING BTREE,
  KEY `FK1AC98804878011D2` (`parent_id`) USING BTREE,
  CONSTRAINT `sys_department_ibfk_1` FOREIGN KEY (`children`) REFERENCES `sys_department` (`id`),
  CONSTRAINT `sys_department_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `sys_department` (`id`),
  CONSTRAINT `sys_department_ibfk_3` FOREIGN KEY (`parent`) REFERENCES `sys_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES ('1', '0e3cb5772f644a096f77b288ae03645a', '运营1部', '1', '0', null, null, null, 'InUse');
INSERT INTO `sys_department` VALUES ('2', '8477d00803903b3fcb758334f402f615', '运营2部', '2', '0', null, null, null, 'InUse');
INSERT INTO `sys_department` VALUES ('3', 'dee1bbd9f02e163f6bb227d7b224a6e6', '财务室', '1', '0', '1', null, null, 'InUse');

-- ----------------------------
-- Table structure for `sys_file`
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `createDateEnd` datetime DEFAULT NULL,
  `createDateStart` datetime DEFAULT NULL,
  `extension_name` varchar(20) DEFAULT NULL,
  `manage_key` varchar(100) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `store_name` varchar(100) DEFAULT NULL,
  `folder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK74A127AE81D99090` (`folder`) USING BTREE,
  CONSTRAINT `sys_file_ibfk_1` FOREIGN KEY (`folder`) REFERENCES `sys_common_folder` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=423 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('56', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('57', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('59', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('60', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('61', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('62', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('63', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('64', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('65', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('66', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('67', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('68', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('69', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('70', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('71', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('72', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('73', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('74', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('75', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('76', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('77', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('78', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('79', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('80', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('81', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('82', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('83', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('84', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('85', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('86', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('87', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('88', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('89', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('90', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('91', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('92', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('93', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('94', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('95', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('96', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('97', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('98', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('99', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('100', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('101', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('102', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('103', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('104', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('105', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('106', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('107', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('108', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('109', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('110', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('111', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('112', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('113', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('114', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('115', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('116', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('117', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('118', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('119', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('120', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('121', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('122', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('123', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('124', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('125', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('126', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('127', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('128', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('129', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('130', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('131', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('132', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('133', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('134', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('135', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('136', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('137', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('138', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('139', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('140', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('141', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('142', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('143', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('144', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('145', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('146', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('147', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('148', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('149', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('150', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('151', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('152', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('153', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('154', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('155', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('156', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('157', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('158', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('159', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('160', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('161', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('162', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('163', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('164', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('165', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('166', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('167', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('168', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('169', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('170', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('171', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('172', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('173', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('174', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('175', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('176', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('177', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('178', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('179', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('180', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('181', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('182', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('183', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('184', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('185', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('186', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('187', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('188', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('189', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('190', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('191', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('192', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('193', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('194', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('195', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('196', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('197', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('198', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('199', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('200', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('201', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('202', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('203', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('204', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('205', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('206', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('207', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('208', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('209', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('210', '2015-05-05 10:08:38', '2015-05-05 10:08:40', '2015-05-05 10:08:42', '.pdf', '22s23443', 'CSS3权威指南', '22发士大夫的萨菲', '1');
INSERT INTO `sys_file` VALUES ('212', '2015-06-15 15:43:17', null, null, '.xls', 'f1aaa123f5754d58a58dc56c69011c7e', '机柜信息20150611 (1).xls', '', '1');
INSERT INTO `sys_file` VALUES ('213', '2015-06-15 15:43:29', null, null, '.xls', '4d575d27ad246cc47c46266cecca389b', '存储设备信息20150611 (2).xls', '', '1');
INSERT INTO `sys_file` VALUES ('214', '2015-06-15 15:48:28', null, null, '.zip', '02ed8473b64b2022b66111333cdedc40', '云数据中心运营管理平台 (1).zip', '', '1');
INSERT INTO `sys_file` VALUES ('215', '2015-06-15 15:49:41', null, null, '.zip', '037dafa599a702418406de287281b9ec', '云数据中心运营管理平台 (53).zip', '', '1');
INSERT INTO `sys_file` VALUES ('216', '2015-06-15 15:53:53', null, null, '.xls', '02d18035e0dc796f2f6a41a43c333398', '机柜导入模板20150615 (2).xls', '', '1');
INSERT INTO `sys_file` VALUES ('217', '2015-06-15 15:54:31', null, null, '.xls', 'e301bcdebccc596176c98c66b320f51a', '交换机信息20150611.xls', '', '1');
INSERT INTO `sys_file` VALUES ('218', '2015-06-15 16:14:51', null, null, '.xls', 'c7190967f55d02d9c1bb93b924499c60', '存储设备信息20150611 (2).xls', '', '1');
INSERT INTO `sys_file` VALUES ('219', '2015-06-15 16:16:22', null, null, '.xls', 'e64cba0b38d0b33cf8d500cd084c06e9', '机柜导入模板20150615 (2).xls', '', '1');
INSERT INTO `sys_file` VALUES ('220', '2015-06-15 16:18:15', null, null, '.xls', '687ce1e0a67c6eacf2ed987da5123cc1', '机柜信息20150610 (2).xls', '', '1');
INSERT INTO `sys_file` VALUES ('221', '2015-06-15 16:31:31', null, null, '.zip', 'ea9b2b2fd8d4a3c95f059801fd9c9b08', '云数据中心运营管理平台 (19).zip', '', '1');
INSERT INTO `sys_file` VALUES ('222', '2015-06-15 17:20:34', null, null, '.zip', 'e337a286f01cf9731d779eac4d00c105', '云数据中心运营管理平台 (4).zip', '', '1');
INSERT INTO `sys_file` VALUES ('223', '2015-06-15 17:26:29', null, null, '.zip', '699a855d094267acd40ed88e5ee37c65', '云数据中心运营管理平台 (9).zip', '', '1');
INSERT INTO `sys_file` VALUES ('224', '2015-06-15 17:29:21', null, null, '.zip', '0764428107703d9000d14627541c3089', '云数据中心运营管理平台 (92).zip', '', '1');
INSERT INTO `sys_file` VALUES ('225', '2015-06-15 17:45:42', null, null, '.xls', '5a4c7ffe23bf319b586bc135202f2c48', '交换机信息20150611.xls', '', '1');
INSERT INTO `sys_file` VALUES ('226', '2015-06-15 17:50:01', null, null, '.zip', '967c4b1e1b4e694a4d0c5de178ff2f3f', '云数据中心运营管理平台 (28).zip', '', '1');
INSERT INTO `sys_file` VALUES ('227', '2015-06-15 17:52:30', null, null, '.zip', '1c8ca5d013f183714a900b6eb1eef5b0', '云数据中心运营管理平台 (27).zip', '', '1');
INSERT INTO `sys_file` VALUES ('228', '2015-06-15 17:54:26', null, null, '.zip', '821f9eb7c6e802fd8eb5f6579ebafbde', '云数据中心运营管理平台 (58).zip', '', '1');
INSERT INTO `sys_file` VALUES ('229', '2015-06-15 17:54:35', null, null, '.zip', 'f0758acf65800355c89c83e59baaa484', '云数据中心运营管理平台 (97).zip', '', '1');
INSERT INTO `sys_file` VALUES ('230', '2015-06-15 17:56:44', null, null, '.zip', '36b40f205330adb6f31edb5a7d9fd9c3', '云数据中心运营管理平台 (58).zip', '', '1');
INSERT INTO `sys_file` VALUES ('231', '2015-06-15 17:56:54', null, null, '.zip', '9939eb8fc7b8bf4677c461381470a957', '云数据中心运营管理平台 (53).zip', '', '1');
INSERT INTO `sys_file` VALUES ('232', '2015-06-15 17:57:00', null, null, '.zip', 'bcc4c9b626fe3cce1e6de6ee74a72057', '20150607155618ae0e0d733fa94c37af38ba45bf090672.zip', '', '1');
INSERT INTO `sys_file` VALUES ('233', '2015-06-15 17:58:04', null, null, '.zip', 'aa71e3f6c58fa3f5f2674a40db338898', 'bootstrap-sidebar-master.zip', '', '1');
INSERT INTO `sys_file` VALUES ('234', '2015-06-15 17:58:11', null, null, '.zip', '06271bb0e7a0c5584bb78fa1cc7d8152', 'bootstrap-sidebar-master.zip', '', '1');
INSERT INTO `sys_file` VALUES ('235', '2015-06-15 18:04:12', null, null, '.zip', 'dbf5c333e9350b7c166d94b1c57b5d4a', 'UCWA March 2014 Samples.zip', '', '1');
INSERT INTO `sys_file` VALUES ('236', '2015-06-15 18:14:54', null, null, '.zip', '769c3cdae31b6f4a879f37c376428049', '云数据中心运营管理平台 (18).zip', '', '1');
INSERT INTO `sys_file` VALUES ('237', '2015-06-15 18:16:55', null, null, '.zip', 'f898840e2f979bd3df82a00fda9099a9', '云数据中心运营管理平台 (43).zip', '', '1');
INSERT INTO `sys_file` VALUES ('238', '2015-06-15 18:23:58', null, null, '.zip', 'fb57ee7f409f758b5e052cb35254abac', 'bootstrap-sidebar-master.zip', '', '1');
INSERT INTO `sys_file` VALUES ('239', '2015-06-15 18:24:09', null, null, '.zip', 'eb2be6d130ae57c3da9e3d0534317865', '云数据中心运营管理平台 (3).zip', '', '1');
INSERT INTO `sys_file` VALUES ('240', '2015-06-15 18:33:19', null, null, '.xls', 'c9b6ba7c15aa5bb12de307c32f01787a', '小型机信息20150611.xls', '', '1');
INSERT INTO `sys_file` VALUES ('241', '2015-06-16 11:08:06', null, null, '.doc', 'c7343a5ca2e7b55b2d50f7167c6cc657', '云数据中心运营管理平台模块设计与接口.doc', '', '1');
INSERT INTO `sys_file` VALUES ('242', '2015-06-16 11:11:15', null, null, '.doc', '6f373ffa001f2cb77a53f1af502f06f8', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('243', '2015-06-16 11:16:04', null, null, '.doc', 'e7474b164c8b0d970cffe34aada6a7b5', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('244', '2015-06-16 11:16:46', null, null, '.doc', '76c436339b3fd82e94f08e2767086f89', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('245', '2015-06-16 11:32:17', null, null, '.doc', '30c1147e23098f4e9657f08beef6d853', '云数据中心运营管理平台需求分析v1.1修订版.doc', '', '1');
INSERT INTO `sys_file` VALUES ('246', '2015-06-16 11:32:54', null, null, '.doc', '21469e8fd886b2e060a2675c81a50ea0', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('247', '2015-06-16 11:36:32', null, null, '.doc', '7ac0c040d3dbb1f59f7d1a2188791569', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('248', '2015-06-16 11:50:14', null, null, '.doc', 'ff4012ad5df0c21a856c449a74ef0f75', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('249', '2015-06-16 11:52:15', null, null, '.doc', '0e260b0f559722bb619e9d5de4e26cf2', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('250', '2015-06-16 11:55:59', null, null, '.doc', '66bab6fc6ad29ec6f0b40eb50620b1e9', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('251', '2015-06-16 12:15:06', null, null, '.xls', '53a1019ca5b9bbf7a5d4ea48f6df2990', '存储设备信息20150611.xls', '', '1');
INSERT INTO `sys_file` VALUES ('252', '2015-06-16 12:17:46', null, null, '.xls', '0082fc49a037084c84e6382ba96963ca', '机柜信息20150610.xls', '', '1');
INSERT INTO `sys_file` VALUES ('253', '2015-06-16 12:18:14', null, null, '.xls', '1ce21aca82cdd41a526cc8f3c2f16f7a', '机柜信息20150610.xls', '', '1');
INSERT INTO `sys_file` VALUES ('254', '2015-06-16 12:20:30', null, null, '.xls', '1b6b4ee361a67aa169231b74f5f1ce07', '机柜导入模板20150615.xls', '', '1');
INSERT INTO `sys_file` VALUES ('255', '2015-06-18 23:24:36', null, null, '.xls', 'c39e41242b43c7ed6686ded12139a3aa', '机柜信息20150618 (13).xls', '', '1');
INSERT INTO `sys_file` VALUES ('256', '2015-06-18 23:27:18', null, null, '.xls', 'b9dc2a805b446dc9cff0f56e8f04950f', '机柜信息20150618 (1).xls', '', '1');
INSERT INTO `sys_file` VALUES ('257', '2015-06-18 23:28:01', null, null, '.xls', '2b09ef20ca0d1a3114632ed5a8ee77d7', '服务器信息20150611.xls', '', '1');
INSERT INTO `sys_file` VALUES ('258', '2015-06-18 23:30:07', null, null, '.xls', 'c369eb024c06495b1a9d4051dffd38f4', '存储设备信息20150611.xls', '', '1');
INSERT INTO `sys_file` VALUES ('259', '2015-06-19 00:00:18', null, null, '.xls', 'ec5511ca001e233035652fa9cf2a2eb3', '机柜信息20150618 (29).xls', '', '1');
INSERT INTO `sys_file` VALUES ('260', '2015-06-19 01:01:32', null, null, '.xls', 'fa97bec08e492496914614bc7515382a', '机柜信息20150618.xls', '', '1');
INSERT INTO `sys_file` VALUES ('261', '2015-06-19 01:02:02', null, null, '.xls', '530bf87282021c7252102d0fa540bf3c', '机柜信息20150618.xls', '', '1');
INSERT INTO `sys_file` VALUES ('262', '2015-06-19 01:04:31', null, null, '.xls', 'a5d7b69013da5c50c2626875d213d452', '机柜信息20150618 (37).xls', '', '1');
INSERT INTO `sys_file` VALUES ('284', '2015-06-20 00:23:53', null, null, '.xls', '72289eb34072496d5c102be925873a1f', '机柜信息20150619 (3).xls', '', '1');
INSERT INTO `sys_file` VALUES ('304', '2015-06-20 12:10:29', null, null, '.xls', '307fe9de6e850dfb1a130d02792f6287', '机柜信息20150619 (3).xls', '', '1');
INSERT INTO `sys_file` VALUES ('323', '2015-06-20 14:03:44', null, null, '.xls', '7ec9f776d292f9de4eab850242f44847', '机柜信息20150619 (3).xls', '', '1');
INSERT INTO `sys_file` VALUES ('344', '2015-06-20 15:38:50', null, null, '.xls', 'ad2597420be231b6445a1bb7bd10c086', '机柜信息20150619 (3).xls', '', '1');
INSERT INTO `sys_file` VALUES ('349', '2015-06-20 15:59:53', null, null, '.xls', 'e9af220aecedf87ade48533ff09b06e4', '机柜信息20150619 (3).xls', '', '1');
INSERT INTO `sys_file` VALUES ('350', '2015-06-20 16:00:04', null, null, '.xls', '3358c63ab7a24b9aa61e64e184e409f0', '机柜信息20150619 (3).xls', '', '1');
INSERT INTO `sys_file` VALUES ('365', '2015-06-25 10:16:21', null, null, '.doc', '638b06018e5afff21940026bb8663640', '问题清单.doc', '', '1');
INSERT INTO `sys_file` VALUES ('366', '2015-06-25 10:22:03', null, null, '.doc', '8da939c645f2391e802555f2fe8aef73', '问题清单.doc', '', '1');
INSERT INTO `sys_file` VALUES ('367', '2015-06-25 10:22:31', null, null, '.doc', '644b3968a9cb0c067162875a9efa50d2', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('368', '2015-06-26 10:42:39', null, null, '.doc', '5e649dec3ae4974b8b9e0f2550d713e8', '云数据中心运营管理平台需求分析v1.2修订版20150430.doc', '', '1');
INSERT INTO `sys_file` VALUES ('369', '2015-06-26 10:47:04', null, null, '.doc', '6e5f1118ccb07a511774490e9a786fce', '云数据中心运营管理平台需求分析v1.2修订版.doc', '', '1');
INSERT INTO `sys_file` VALUES ('370', '2015-06-26 10:47:54', null, null, '.doc', '8143c49e65b549c986f479a165b9066c', '云数据中心运营管理平台需求分析v1.1修订版20150427.doc', '', '1');
INSERT INTO `sys_file` VALUES ('372', '2015-06-29 15:24:21', null, null, '.doc', '139d83e2fc92f077ad578d4337deefbc', '智能IT服务平台20150529需求时间评估.doc', '', '1');
INSERT INTO `sys_file` VALUES ('373', '2015-06-29 15:50:15', null, null, '.xls', '8fc0e47a5f858fc353c432789b12ca9a', '智能IT服务平台20150529需求工作量评估.xls', '', '1');
INSERT INTO `sys_file` VALUES ('374', '2015-06-29 15:51:55', null, null, '.xls', 'c3f4e4d08b9afb8c570718a6ada52fa7', '存储设备导入模板20150624.xls', '', '1');
INSERT INTO `sys_file` VALUES ('375', '2015-06-29 15:54:50', null, null, '.xls', 'b0cf8ce50400114932f84b8f92fe7894', 'itop配置管理字段整理模板.xls', '', '1');
INSERT INTO `sys_file` VALUES ('376', '2015-06-29 15:56:35', null, null, '.xls', '82654fcc4bb68c1d9d2332b6871fc5b0', '路由器信息20150611.xls', '', '1');
INSERT INTO `sys_file` VALUES ('378', '2015-06-29 15:59:01', null, null, '.xls', 'a343ace2d53846f9c39138ca646ddb55', '存储设备信息20150618 (1).xls', '', '1');
INSERT INTO `sys_file` VALUES ('382', '2015-07-08 17:04:34', null, null, '.docx', 'cdebc03f4eb743044cc9a0bba9faa91b', '系统系统说明书.docx', '', '1');
INSERT INTO `sys_file` VALUES ('383', '2015-07-20 16:33:21', null, null, '.docx', 'd12c1d779b3e020f9c2332de928ff8d4', '测试上传 .docx', '', '1');
INSERT INTO `sys_file` VALUES ('384', '2015-07-28 11:48:29', null, null, '.txt', '53262a43d0017eac4c555722115627c9', '程序中用请求的URL.txt', '', '1');
INSERT INTO `sys_file` VALUES ('385', '2015-07-28 11:49:45', null, null, '.txt', '4391fef89effdf6ca97b50682ab5a607', 'osSetStep.txt', '', '1');
INSERT INTO `sys_file` VALUES ('386', '2015-07-29 15:55:39', null, null, '.xls', '5fcb97413f902a8c48eeff486db35e96', '机柜导入模板20150729.xls', '', '1');
INSERT INTO `sys_file` VALUES ('422', '2015-08-26 17:10:45', null, null, '.xls', '98709096605b180f20523ec7c38a6bd0', '服务器信息20150826 (6).xls', '', '1');

-- ----------------------------
-- Table structure for `sys_function_point`
-- ----------------------------
DROP TABLE IF EXISTS `sys_function_point`;
CREATE TABLE `sys_function_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) DEFAULT NULL,
  `is_display` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED2F861BC67030DB` (`parent`) USING BTREE,
  CONSTRAINT `sys_function_point_ibfk_1` FOREIGN KEY (`parent`) REFERENCES `sys_function_point` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=946 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_function_point
-- ----------------------------
INSERT INTO `sys_function_point` VALUES ('109', '', '0', '文件管理', '109', 'filee/list.do', '132');
INSERT INTO `sys_function_point` VALUES ('110', null, '0', '添加文件', '1', 'filee/add.do', '109');
INSERT INTO `sys_function_point` VALUES ('111', null, '0', '修改文件', '2', 'filee/update.do', '109');
INSERT INTO `sys_function_point` VALUES ('112', null, '0', '删除文件', '3', 'filee/delete.do', '109');
INSERT INTO `sys_function_point` VALUES ('113', '', '0', '文件夹管理', '113', 'commonFolder/list.do', '132');
INSERT INTO `sys_function_point` VALUES ('114', null, '0', '添加文件夹', '1', 'commonFolder/add.do', '113');
INSERT INTO `sys_function_point` VALUES ('115', '', '0', '修改文件夹', '2', 'commonFolder/update.do', '113');
INSERT INTO `sys_function_point` VALUES ('116', null, '0', '删除文件夹', '3', 'commonFolder/delete.do', '113');
INSERT INTO `sys_function_point` VALUES ('117', null, '1', '用户管理', '116', 'user/list.do', '132');
INSERT INTO `sys_function_point` VALUES ('118', null, '0', '添加用户', '1', 'user/add.do', '117');
INSERT INTO `sys_function_point` VALUES ('119', null, '0', '修改用户', '2', 'user/update.do', '117');
INSERT INTO `sys_function_point` VALUES ('120', null, '0', '删除用户', '3', 'user/delete.do', '117');
INSERT INTO `sys_function_point` VALUES ('121', null, '1', '角色管理', '119', 'role/list.do', '132');
INSERT INTO `sys_function_point` VALUES ('122', null, '0', '添加角色', '1', 'role/add.do', '121');
INSERT INTO `sys_function_point` VALUES ('123', null, '0', '修改角色', '2', 'role/update.do', '121');
INSERT INTO `sys_function_point` VALUES ('124', null, '0', '删除角色', '3', 'role/delete.do', '121');
INSERT INTO `sys_function_point` VALUES ('125', '', '1', '权限管理', '120', 'functionPoint/list.do', '132');
INSERT INTO `sys_function_point` VALUES ('132', 'fa-cog', '1', '系统管理', '100', 'admin/system', null);
INSERT INTO `sys_function_point` VALUES ('136', '', '1', '修改权限', '2', 'functionPoint/update.do', '125');
INSERT INTO `sys_function_point` VALUES ('137', '', '1', '删除权限', '3', 'functionPoint/delete.do', '125');
INSERT INTO `sys_function_point` VALUES ('138', null, '1', '设置角色', '4', 'user/setRole.do', '117');
INSERT INTO `sys_function_point` VALUES ('139', '', '1', '添加权限', '1', 'functionPoint/add.do', '125');
INSERT INTO `sys_function_point` VALUES ('140', null, '1', '设置权限', '4', 'role/setPrivilege.do', '121');
INSERT INTO `sys_function_point` VALUES ('149', ' ', '0', '修改密码', '5', 'user/updatePassword.do', '117');
INSERT INTO `sys_function_point` VALUES ('288', null, '0', '查看用户', '4', 'user/detail.do', '117');
INSERT INTO `sys_function_point` VALUES ('656', '0', '0', '系统参数配置', '1', 'config/systemConfig.do', '132');
INSERT INTO `sys_function_point` VALUES ('700', null, '1', '部门管理', '700', 'department/list.do', '132');
INSERT INTO `sys_function_point` VALUES ('701', null, '0', '部门添加', '1', 'department/add.do', '700');
INSERT INTO `sys_function_point` VALUES ('702', null, '0', '删除部门', '2', 'department/delete.do', '700');
INSERT INTO `sys_function_point` VALUES ('703', null, '0', '部门修改', '3', 'department/update.do', '700');
INSERT INTO `sys_function_point` VALUES ('705', null, '0', '部门查看', '5', 'department/detail.do', '700');

-- ----------------------------
-- Table structure for `sys_notice`
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_content` text,
  `create_time` datetime DEFAULT NULL,
  `_level` enum('High','Middle','Low') DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `_title` varchar(255) DEFAULT NULL,
  `creator_id` varchar(20) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDEF5048A834CFF89` (`creator_id`) USING BTREE,
  KEY `FKDEF5048A68C27257` (`dept_id`) USING BTREE,
  CONSTRAINT `sys_notice_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `sys_department` (`id`),
  CONSTRAINT `sys_notice_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `sys_user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `_key` varchar(255) DEFAULT NULL,
  `_type` enum('Normal','Advance') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '', '管理员', null, 'Advance');
INSERT INTO `sys_role` VALUES ('2', '', '用户', null, 'Normal');
INSERT INTO `sys_role` VALUES ('3', '', '请问', null, 'Normal');
INSERT INTO `sys_role` VALUES ('4', 'fdsfdsf', '代理商', null, 'Normal');

-- ----------------------------
-- Table structure for `sys_role_function_point`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_function_point`;
CREATE TABLE `sys_role_function_point` (
  `role_id` int(11) NOT NULL,
  `functionpoint_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`functionpoint_id`),
  KEY `FK896F00E08877B633` (`functionpoint_id`) USING BTREE,
  KEY `FK896F00E011FCE641` (`role_id`) USING BTREE,
  CONSTRAINT `sys_role_function_point_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `sys_role_function_point_ibfk_2` FOREIGN KEY (`functionpoint_id`) REFERENCES `sys_function_point` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_function_point
-- ----------------------------
INSERT INTO `sys_role_function_point` VALUES ('1', '109');
INSERT INTO `sys_role_function_point` VALUES ('1', '110');
INSERT INTO `sys_role_function_point` VALUES ('1', '111');
INSERT INTO `sys_role_function_point` VALUES ('1', '112');
INSERT INTO `sys_role_function_point` VALUES ('1', '113');
INSERT INTO `sys_role_function_point` VALUES ('1', '114');
INSERT INTO `sys_role_function_point` VALUES ('1', '115');
INSERT INTO `sys_role_function_point` VALUES ('1', '116');
INSERT INTO `sys_role_function_point` VALUES ('1', '117');
INSERT INTO `sys_role_function_point` VALUES ('1', '118');
INSERT INTO `sys_role_function_point` VALUES ('1', '119');
INSERT INTO `sys_role_function_point` VALUES ('1', '120');
INSERT INTO `sys_role_function_point` VALUES ('1', '121');
INSERT INTO `sys_role_function_point` VALUES ('1', '122');
INSERT INTO `sys_role_function_point` VALUES ('1', '123');
INSERT INTO `sys_role_function_point` VALUES ('1', '124');
INSERT INTO `sys_role_function_point` VALUES ('1', '125');
INSERT INTO `sys_role_function_point` VALUES ('1', '132');
INSERT INTO `sys_role_function_point` VALUES ('1', '136');
INSERT INTO `sys_role_function_point` VALUES ('1', '137');
INSERT INTO `sys_role_function_point` VALUES ('1', '138');
INSERT INTO `sys_role_function_point` VALUES ('1', '139');
INSERT INTO `sys_role_function_point` VALUES ('1', '140');
INSERT INTO `sys_role_function_point` VALUES ('1', '149');
INSERT INTO `sys_role_function_point` VALUES ('1', '288');
INSERT INTO `sys_role_function_point` VALUES ('1', '656');
INSERT INTO `sys_role_function_point` VALUES ('1', '700');
INSERT INTO `sys_role_function_point` VALUES ('1', '701');
INSERT INTO `sys_role_function_point` VALUES ('1', '702');
INSERT INTO `sys_role_function_point` VALUES ('1', '703');
INSERT INTO `sys_role_function_point` VALUES ('1', '705');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `username` varchar(20) NOT NULL,
  `chinese_name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` enum('Active','Approving','InActive') NOT NULL,
  `dept` int(11) DEFAULT NULL,
  `english_name` varchar(255) DEFAULT NULL,
  `type` enum('Local','Domain') NOT NULL,
  `head_portrait` int(11) DEFAULT NULL,
  `largPhoto` int(11) DEFAULT NULL,
  `photo` int(11) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `thisLoginTime` datetime DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `FK74A81DFD95B49B55` (`dept`) USING BTREE,
  KEY `FK74A81DFD197771A3` (`head_portrait`) USING BTREE,
  KEY `FK74A81DFD50C75491` (`largPhoto`) USING BTREE,
  KEY `FK74A81DFD294CF4BB` (`photo`) USING BTREE,
  KEY `FK74A81DFD5BC3BC32` (`agent_id`) USING BTREE,
  CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`agent_id`) REFERENCES `agent_agent` (`id`),
  CONSTRAINT `sys_user_ibfk_2` FOREIGN KEY (`head_portrait`) REFERENCES `sys_file` (`id`),
  CONSTRAINT `sys_user_ibfk_3` FOREIGN KEY (`photo`) REFERENCES `sys_file` (`id`),
  CONSTRAINT `sys_user_ibfk_4` FOREIGN KEY (`largPhoto`) REFERENCES `sys_file` (`id`),
  CONSTRAINT `sys_user_ibfk_5` FOREIGN KEY (`dept`) REFERENCES `sys_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('aaaa', 'a', '', '74b87337454200d4d33f80c4663dc5e5', '', 'Active', '1', null, 'Local', null, null, null, null, null, '1');
INSERT INTO `sys_user` VALUES ('admin', 'admin', 'admin@localhost.com', '0cc175b9c0f1b6a831c399e269772661', '133026500000', 'Active', '1', null, 'Local', null, null, null, '2015-12-06 13:42:13', '2015-12-06 13:46:24', null);

-- ----------------------------
-- Table structure for `sys_user_area`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_area`;
CREATE TABLE `sys_user_area` (
  `user_id` varchar(20) NOT NULL,
  `area_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`area_id`),
  KEY `FK6604A18F6849B302` (`area_id`) USING BTREE,
  KEY `FK6604A18F2850FB8A` (`user_id`) USING BTREE,
  CONSTRAINT `sys_user_area_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`username`),
  CONSTRAINT `sys_user_area_ibfk_2` FOREIGN KEY (`area_id`) REFERENCES `agent_area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_area
-- ----------------------------
INSERT INTO `sys_user_area` VALUES ('admin', '1');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userName` varchar(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`userName`,`role_id`),
  KEY `FK660C5178D1093C23` (`role_id`) USING BTREE,
  KEY `FK660C51786F229ACA` (`userName`) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `sys_user` (`username`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('admin', '1');
INSERT INTO `sys_user_role` VALUES ('aaaa', '4');

-- ----------------------------
-- Table structure for `trade_trade_record`
-- ----------------------------
DROP TABLE IF EXISTS `trade_trade_record`;
CREATE TABLE `trade_trade_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `manageKey` varchar(255) DEFAULT NULL,
  `remark` text,
  `trade_time` datetime DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD94CBA875BC3BC32` (`agent_id`) USING BTREE,
  CONSTRAINT `trade_trade_record_ibfk_1` FOREIGN KEY (`agent_id`) REFERENCES `agent_agent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade_trade_record
-- ----------------------------
INSERT INTO `trade_trade_record` VALUES ('1', '-1', '-1', 'a5ae4c451c2629fd81b496742bdc4216', '消费:1', '2015-11-06 10:23:42', '1');
