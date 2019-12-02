/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : authority_management

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 27/11/2019 23:38:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `percode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parentid` int(11) NULL DEFAULT NULL,
  `parentids` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sortstring` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '权限', NULL, NULL, '其他', 0, '0', '0', 1);
INSERT INTO `sys_permission` VALUES (2, '后台首页', 'login', '/authuser/index.do', 'admin:query', 1, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (3, '后台欢迎', 'permission', '/authuser/welcome.do', 'welcome:query', 2, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (4, '管理员管理', 'menu', '', 'welcome:query', 2, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (5, '角色管理', 'secondmenu', '/authority/rolepage.do', 'role:query', 4, NULL, '1', 1);
INSERT INTO `sys_permission` VALUES (6, '权限管理', 'secondmenu', '/authority/permissionpage.do', 'permission:query', 4, NULL, '2', 1);
INSERT INTO `sys_permission` VALUES (7, '权限分配', 'secondmenu', '/authority/settingspage.do', 'setting:query', 4, NULL, '3', 1);
INSERT INTO `sys_permission` VALUES (8, '角色查询', 'permission', '/authority/getsysrole.do', 'role:query', 5, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (9, '角色添加', 'permission', '/authority/authority-role-add.do', 'permission:create', 5, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (10, '角色修改', 'permission', '/authority/authority-role-edit.do', 'permission:update', 5, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (11, '角色删除', 'permission', '/authority/authority-role-delete.do', 'permission:delete', 5, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (12, '权限查询', 'permission', '/authority/getsyspermission.do', 'permission:query', 6, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (13, '权限树查询', 'permission', '/authority/getsyspermissiontree.do', 'permission:query', 7, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (14, '角色权限值', 'permission', '/authority/getsyspermissiontreebyrole', 'permission:query', 7, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (15, '权限分配', 'permission', '/authority/updatepermissionbyroleid.do', 'permission:update', 7, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (16, '普通管理', 'menu', '', 'welcome:query', 2, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (17, '商品管理', 'secondmenu', '', '添加权限', 16, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (18, '权限添加', 'permission', '/authority/authority-permission-add.do', 'permission:create', 6, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (19, '权限修改', 'permission', '/authority/authority-permission-edit.do', 'permission:update', 6, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (20, '权限删除', 'permission', '/authority/authority-permission-delete.do', 'permission:delete', 6, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (21, '用户管理', 'secondmenu', '/authority/authority-user.do', 'user:query', 4, NULL, '1', 1);
INSERT INTO `sys_permission` VALUES (22, '用户添加', 'permission', '/authority/authority-user-add.do', 'permission:create', 21, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (23, '用户修改', 'permission', '/authority/authority-user-edit.do', 'permission:update', 21, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (24, '用户删除', 'permission', '/authority/authority-user-delete.do', 'permission:delete', 21, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (26, '2', NULL, '2', '2', 1, NULL, NULL, 1);
INSERT INTO `sys_permission` VALUES (27, '4444', NULL, '444444', '44444', 3, NULL, NULL, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '系统管理员', '至高无上的权利', 1);
INSERT INTO `sys_role` VALUES (2, '超级管理员', '一人之下', 1);
INSERT INTO `sys_role` VALUES (3, '管理员', '普通官员', 1);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_role_id` int(11) NULL DEFAULT NULL,
  `sys_permission_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 180 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (93, 2, 1);
INSERT INTO `sys_role_permission` VALUES (94, 2, 2);
INSERT INTO `sys_role_permission` VALUES (95, 2, 16);
INSERT INTO `sys_role_permission` VALUES (96, 2, 17);
INSERT INTO `sys_role_permission` VALUES (97, 2, 3);
INSERT INTO `sys_role_permission` VALUES (98, 2, 4);
INSERT INTO `sys_role_permission` VALUES (99, 2, 5);
INSERT INTO `sys_role_permission` VALUES (100, 2, 8);
INSERT INTO `sys_role_permission` VALUES (101, 2, 6);
INSERT INTO `sys_role_permission` VALUES (102, 2, 12);
INSERT INTO `sys_role_permission` VALUES (103, 2, 18);
INSERT INTO `sys_role_permission` VALUES (104, 2, 19);
INSERT INTO `sys_role_permission` VALUES (105, 2, 20);
INSERT INTO `sys_role_permission` VALUES (106, 2, 7);
INSERT INTO `sys_role_permission` VALUES (107, 2, 13);
INSERT INTO `sys_role_permission` VALUES (108, 2, 14);
INSERT INTO `sys_role_permission` VALUES (109, 2, 15);
INSERT INTO `sys_role_permission` VALUES (159, 3, 1);
INSERT INTO `sys_role_permission` VALUES (160, 3, 2);
INSERT INTO `sys_role_permission` VALUES (161, 3, 3);
INSERT INTO `sys_role_permission` VALUES (162, 3, 4);
INSERT INTO `sys_role_permission` VALUES (163, 3, 5);
INSERT INTO `sys_role_permission` VALUES (164, 3, 8);
INSERT INTO `sys_role_permission` VALUES (165, 3, 10);
INSERT INTO `sys_role_permission` VALUES (166, 3, 11);
INSERT INTO `sys_role_permission` VALUES (167, 3, 6);
INSERT INTO `sys_role_permission` VALUES (168, 3, 12);
INSERT INTO `sys_role_permission` VALUES (169, 3, 18);
INSERT INTO `sys_role_permission` VALUES (170, 3, 19);
INSERT INTO `sys_role_permission` VALUES (171, 3, 20);
INSERT INTO `sys_role_permission` VALUES (172, 3, 7);
INSERT INTO `sys_role_permission` VALUES (173, 3, 13);
INSERT INTO `sys_role_permission` VALUES (174, 3, 14);
INSERT INTO `sys_role_permission` VALUES (175, 3, 15);
INSERT INTO `sys_role_permission` VALUES (176, 3, 21);
INSERT INTO `sys_role_permission` VALUES (177, 3, 22);
INSERT INTO `sys_role_permission` VALUES (178, 3, 23);
INSERT INTO `sys_role_permission` VALUES (179, 3, 24);
INSERT INTO `sys_role_permission` VALUES (294, 1, 1);
INSERT INTO `sys_role_permission` VALUES (295, 1, 2);
INSERT INTO `sys_role_permission` VALUES (296, 1, 3);
INSERT INTO `sys_role_permission` VALUES (297, 1, 4);
INSERT INTO `sys_role_permission` VALUES (298, 1, 5);
INSERT INTO `sys_role_permission` VALUES (299, 1, 8);
INSERT INTO `sys_role_permission` VALUES (300, 1, 9);
INSERT INTO `sys_role_permission` VALUES (301, 1, 11);
INSERT INTO `sys_role_permission` VALUES (302, 1, 6);
INSERT INTO `sys_role_permission` VALUES (303, 1, 19);
INSERT INTO `sys_role_permission` VALUES (304, 1, 20);
INSERT INTO `sys_role_permission` VALUES (305, 1, 7);
INSERT INTO `sys_role_permission` VALUES (306, 1, 15);
INSERT INTO `sys_role_permission` VALUES (307, 1, 13);
INSERT INTO `sys_role_permission` VALUES (308, 1, 14);
INSERT INTO `sys_role_permission` VALUES (309, 1, 21);
INSERT INTO `sys_role_permission` VALUES (310, 1, 23);
INSERT INTO `sys_role_permission` VALUES (311, 1, 24);
INSERT INTO `sys_role_permission` VALUES (312, 1, 22);
INSERT INTO `sys_role_permission` VALUES (313, 1, 16);
INSERT INTO `sys_role_permission` VALUES (314, 1, 17);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usercode` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `salt` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `locked` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `usercode`(`usercode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'ww', 'ww', 'c4ca4238a0b923820dcc509a6f75849b', 'qwe', 1);
INSERT INTO `sys_user` VALUES (2, 'zy', 'zy', 'c4ca4238a0b923820dcc509a6f75849b', 'qwe', 1);
INSERT INTO `sys_user` VALUES (3, 'yy', 'yy', NULL, 'qwe', 1);
INSERT INTO `sys_user` VALUES (27, '33333', '33333', NULL, 'qwe', 1);
INSERT INTO `sys_user` VALUES (28, '5555', '5555', NULL, 'qwe', 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_user_id` int(11) NULL DEFAULT NULL,
  `sys_role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 2);
INSERT INTO `sys_user_role` VALUES (3, 3, 2);
INSERT INTO `sys_user_role` VALUES (6, NULL, 1);
INSERT INTO `sys_user_role` VALUES (24, 27, 3);
INSERT INTO `sys_user_role` VALUES (25, 28, 1);

SET FOREIGN_KEY_CHECKS = 1;
