/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 10.1.34-MariaDB : Database - soul2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`soul2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `soul2`;

/*Table structure for table `tbl_dept` */

DROP TABLE IF EXISTS `tbl_dept`;

CREATE TABLE `tbl_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

/*Data for the table `tbl_dept` */

insert  into `tbl_dept`(`dept_id`,`dept_name`,`order_num`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`) values (101,'研发部门',1,'0','0','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00'),(102,'市场部门',2,'0','0','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00'),(103,'测试部门',3,'0','0','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00'),(104,'财务部门',4,'0','0','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00'),(105,'运维部门',5,'0','0','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00'),(106,'市场部门',6,'0','0','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00');

/*Table structure for table `tbl_menu` */

DROP TABLE IF EXISTS `tbl_menu`;

CREATE TABLE `tbl_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1022 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

/*Data for the table `tbl_menu` */

insert  into `tbl_menu`(`menu_id`,`menu_name`,`parent_id`,`order_num`,`url`,`menu_type`,`visible`,`perms`,`icon`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'系统管理',0,1,'#','M','0','','layui-icon-set','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','系统管理目录'),(2,'系统监控',0,2,'#','M','0','','layui-icon-camera-fill','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','系统监控目录'),(100,'用户管理',1,1,'/user/toShowUser','C','0','system:user:view','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','用户管理菜单'),(101,'角色管理',1,2,'/role/toShowRole','C','0','system:role:view','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','角色管理菜单'),(102,'菜单管理',1,3,'/menu/toShowMenu','C','0','system:menu:view','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','菜单管理菜单'),(103,'部门管理',1,4,'/dept/toShowDept','C','0','system:dept:view','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','部门管理菜单'),(109,'在线用户',2,1,'/monitor/online','C','0','monitor:online:view','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','在线用户菜单'),(111,'数据监控',2,3,'/monitor/data','C','0','monitor:data:view','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','数据监控菜单'),(112,'服务监控',2,3,'/monitor/server','C','0','monitor:server:view','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','服务监控菜单'),(1000,'用户查询',100,1,'#','F','0','system:user:list','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1001,'用户新增',100,2,'#','F','0','system:user:add','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1002,'用户修改',100,3,'#','F','0','system:user:edit','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1003,'用户删除',100,4,'#','F','0','system:user:remove','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1004,'用户导出',100,5,'#','F','0','system:user:export','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1005,'重置密码',100,6,'#','F','0','system:user:resetPwd','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1006,'角色查询',101,1,'#','F','0','system:role:list','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1007,'角色新增',101,2,'#','F','0','system:role:add','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1008,'角色修改',101,3,'#','F','0','system:role:edit','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1009,'角色删除',101,4,'#','F','0','system:role:remove','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1010,'角色导出',101,5,'#','F','0','system:role:export','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1011,'菜单查询',102,1,'#','F','0','system:menu:list','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1012,'菜单新增',102,2,'#','F','0','system:menu:add','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1013,'菜单修改',102,3,'#','F','0','system:menu:edit','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1014,'菜单删除',102,4,'#','F','0','system:menu:remove','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1015,'部门查询',103,1,'#','F','0','system:dept:list','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1016,'部门新增',103,2,'#','F','0','system:dept:add','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1017,'部门修改',103,3,'#','F','0','system:dept:edit','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00',''),(1018,'部门删除',103,4,'#','F','0','system:dept:remove','#','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','');

/*Table structure for table `tbl_role` */

DROP TABLE IF EXISTS `tbl_role`;

CREATE TABLE `tbl_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

/*Data for the table `tbl_role` */

insert  into `tbl_role`(`role_id`,`role_name`,`role_key`,`role_sort`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'管理员','admin',1,'0','0','admin','2018-03-16 11:33:00','admin','2018-03-16 11:33:00','管理员'),(2,'普通角色','common',2,'0','0','admin','2018-03-16 11:33:00','admin','2019-08-07 16:24:20','普通角色'),(3,'测试角色','ceshi',3,'0','0','admin','2019-12-31 15:40:32','admin','2019-12-31 15:42:14','');

/*Table structure for table `tbl_role_menu` */

DROP TABLE IF EXISTS `tbl_role_menu`;

CREATE TABLE `tbl_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `tbl_role_menu` */

insert  into `tbl_role_menu`(`role_id`,`menu_id`) values (1,1),(1,2),(1,100),(1,101),(1,102),(1,103),(1,109),(1,111),(1,112),(1,1000),(1,1001),(1,1002),(1,1003),(1,1004),(1,1005),(1,1006),(1,1007),(1,1008),(1,1009),(1,1010),(1,1011),(1,1012),(1,1013),(1,1014),(1,1015),(1,1016),(1,1017),(1,1018),(2,1),(2,100),(2,101),(2,1001),(2,1002),(2,1003);

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(50) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`user_id`,`dept_id`,`login_name`,`user_name`,`email`,`phonenumber`,`sex`,`avatar`,`password`,`salt`,`status`,`del_flag`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,101,'admin','豆豆','86521760@qq.com','18538062907','0',NULL,'280111d7f4fa14ff76606fe1ffa4d782','9ed6610c-6132-4d0c-a8a4-5011080ba754','0','0','admin','2018-03-16 11:33:00','admin','2020-01-01 21:15:13','管理员'),(3,101,'chenjian','陈建','chenjian3822515@163.com','18538062906','0',NULL,'f4a77e1417b03bf32d4b33a137282093','4bd21f','0','0','admin','2019-04-18 11:48:31','admin','2019-08-07 12:31:29',''),(4,101,'root2','张三','86587432@qq.com','18538062999','0',NULL,'3512abbc9c7c8daa4c3560e79f8d1858','568629be-6ca4-46eb-baaf-f6fea4c23d74','0','0','admin','2019-08-07 15:46:18','admin','2019-08-07 16:24:29',''),(5,103,'lihang','lihang','7987954@qq.com','17947934435','0',NULL,'6d70551312e8167cb363020454a3ba03','f06b8d','0','0','admin','2019-12-31 15:38:14','admin','2020-01-01 21:02:55',''),(28,NULL,'xm','xm','123456','123456','0',NULL,'ead0fe1b1aeaad09841a2ffa9d8d2abf','e16402ab-5fe9-4120-a12a-b1e453367666','0','2','',NULL,'',NULL,''),(29,NULL,'xh','xh','123456','123456','0',NULL,'285571d1304b0ef5a9c174fe2451fb2e','912efd6f-d75b-450e-b819-1e9cf474e42c','0','2','',NULL,'',NULL,'');

/*Table structure for table `tbl_user_role` */

DROP TABLE IF EXISTS `tbl_user_role`;

CREATE TABLE `tbl_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

/*Data for the table `tbl_user_role` */

insert  into `tbl_user_role`(`user_id`,`role_id`) values (1,1),(2,2),(3,2),(3,3),(4,2),(5,3);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salt` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userid`,`username`,`password`,`salt`) values (17,'root2','3512abbc9c7c8daa4c3560e79f8d1858','568629be-6ca4-46eb-baaf-f6fea4c23d74'),(18,'admin','280111d7f4fa14ff76606fe1ffa4d782','9ed6610c-6132-4d0c-a8a4-5011080ba754'),(21,'5432','2f43a00422c65488fac39c80a30f187f','7defb525-dd24-4c36-861c-67cdfbae0051');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
