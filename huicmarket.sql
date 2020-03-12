/*
Navicat MySQL Data Transfer

Source Server         : sssss
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : huicmarket

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2018-06-05 11:03:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addrinfo
-- ----------------------------
DROP TABLE IF EXISTS `addrinfo`;
CREATE TABLE `addrinfo` (
  `addr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货id',
  `addr_name` varchar(20) NOT NULL COMMENT '收货人',
  `address` varchar(255) NOT NULL COMMENT '收货地址',
  `addr_phone` varchar(20) NOT NULL COMMENT '收货人电话',
  `addr_post` varchar(8) NOT NULL COMMENT '邮政编码',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`addr_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `addrinfo_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of addrinfo
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品分类id',
  `cate_name` varchar(50) NOT NULL COMMENT '分类名称',
  `cparent_id` int(11) DEFAULT NULL COMMENT '分类父id',
  PRIMARY KEY (`cate_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '点心/蛋糕', '0');
INSERT INTO `category` VALUES ('2', '点心', '1');
INSERT INTO `category` VALUES ('3', '蛋糕', '1');
INSERT INTO `category` VALUES ('4', '麻薯', '2');
INSERT INTO `category` VALUES ('5', '绿豆糕', '2');
INSERT INTO `category` VALUES ('6', '鲜花饼', '2');
INSERT INTO `category` VALUES ('7', '凤梨酥', '2');
INSERT INTO `category` VALUES ('8', '榴莲酥', '2');
INSERT INTO `category` VALUES ('9', '甜甜圈', '2');
INSERT INTO `category` VALUES ('10', '华夫饼', '2');
INSERT INTO `category` VALUES ('11', '牛乳蛋糕', '3');
INSERT INTO `category` VALUES ('12', '提拉米苏', '3');
INSERT INTO `category` VALUES ('13', '蒸蛋糕', '3');
INSERT INTO `category` VALUES ('14', '马卡龙', '3');
INSERT INTO `category` VALUES ('15', '铜锣烧', '3');
INSERT INTO `category` VALUES ('16', '榴莲蛋糕', '3');
INSERT INTO `category` VALUES ('17', '蛋黄派', '3');
INSERT INTO `category` VALUES ('18', '饼干/膨化', '0');
INSERT INTO `category` VALUES ('19', '饼干', '18');
INSERT INTO `category` VALUES ('20', '膨化', '18');
INSERT INTO `category` VALUES ('21', '曲奇饼干', '19');
INSERT INTO `category` VALUES ('22', '膨化饼干', '19');
INSERT INTO `category` VALUES ('23', '燕麦饼干', '19');
INSERT INTO `category` VALUES ('24', '消化饼干', '19');
INSERT INTO `category` VALUES ('25', '薄脆饼干', '19');
INSERT INTO `category` VALUES ('26', '夹心饼干', '19');
INSERT INTO `category` VALUES ('27', '薯片', '20');
INSERT INTO `category` VALUES ('28', '锅巴', '20');
INSERT INTO `category` VALUES ('29', '玉米片', '20');
INSERT INTO `category` VALUES ('30', '虾片', '20');
INSERT INTO `category` VALUES ('31', '辣条', '20');
INSERT INTO `category` VALUES ('32', '米饼', '20');
INSERT INTO `category` VALUES ('33', '熟食/素食', '0');
INSERT INTO `category` VALUES ('34', '肉干', '33');
INSERT INTO `category` VALUES ('35', '素食', '33');
INSERT INTO `category` VALUES ('36', '猪肉脯', '34');
INSERT INTO `category` VALUES ('37', '牛肉脯', '34');
INSERT INTO `category` VALUES ('39', '烤鸭酱鸭', '34');
INSERT INTO `category` VALUES ('40', '鸭脖子', '34');
INSERT INTO `category` VALUES ('41', '豆干', '35');
INSERT INTO `category` VALUES ('42', '卤蛋', '35');
INSERT INTO `category` VALUES ('43', '海带丝', '35');
INSERT INTO `category` VALUES ('44', '脆笋', '35');
INSERT INTO `category` VALUES ('45', '坚果/炒货', '0');
INSERT INTO `category` VALUES ('46', '坚果', '45');
INSERT INTO `category` VALUES ('47', '炒货', '45');
INSERT INTO `category` VALUES ('48', '夏威夷果', '46');
INSERT INTO `category` VALUES ('49', '松子', '46');
INSERT INTO `category` VALUES ('50', '开心果', '46');
INSERT INTO `category` VALUES ('51', '腰果', '46');
INSERT INTO `category` VALUES ('52', '巴旦木', '46');
INSERT INTO `category` VALUES ('53', '杏仁', '46');
INSERT INTO `category` VALUES ('54', '花生', '46');
INSERT INTO `category` VALUES ('55', '核桃', '46');
INSERT INTO `category` VALUES ('56', '碧根果', '46');
INSERT INTO `category` VALUES ('57', '麻花', '47');
INSERT INTO `category` VALUES ('58', '猪耳酥', '47');
INSERT INTO `category` VALUES ('59', '糖果/果干', '0');
INSERT INTO `category` VALUES ('60', '糖果', '59');
INSERT INTO `category` VALUES ('61', '果干', '59');
INSERT INTO `category` VALUES ('62', '软糖', '60');
INSERT INTO `category` VALUES ('63', '硬糖', '60');
INSERT INTO `category` VALUES ('64', '薄荷糖', '60');
INSERT INTO `category` VALUES ('65', '口香糖', '60');
INSERT INTO `category` VALUES ('66', '彩虹糖', '60');
INSERT INTO `category` VALUES ('67', '芒果干', '61');
INSERT INTO `category` VALUES ('68', '葡萄干', '61');
INSERT INTO `category` VALUES ('69', '红枣', '61');
INSERT INTO `category` VALUES ('70', '蔬果干', '61');
INSERT INTO `category` VALUES ('71', '榴莲干', '61');
INSERT INTO `category` VALUES ('72', '巧克力/果冻', '0');
INSERT INTO `category` VALUES ('73', '巧克力', '72');
INSERT INTO `category` VALUES ('74', '果冻', '72');
INSERT INTO `category` VALUES ('75', '黑巧克力', '73');
INSERT INTO `category` VALUES ('76', '白巧克力', '73');
INSERT INTO `category` VALUES ('77', '巧克力豆', '73');
INSERT INTO `category` VALUES ('78', '星球杯', '73');
INSERT INTO `category` VALUES ('79', '士力架', '73');
INSERT INTO `category` VALUES ('80', '夹心巧克力', '73');
INSERT INTO `category` VALUES ('81', '布丁', '74');
INSERT INTO `category` VALUES ('82', '果肉果冻', '74');
INSERT INTO `category` VALUES ('83', '优酪果冻', '74');
INSERT INTO `category` VALUES ('84', '龟苓膏', '74');
INSERT INTO `category` VALUES ('85', '海味/腊味', '0');
INSERT INTO `category` VALUES ('86', '海味', '85');
INSERT INTO `category` VALUES ('87', '腊味', '85');
INSERT INTO `category` VALUES ('88', '鱿鱼干', '86');
INSERT INTO `category` VALUES ('89', '紫菜', '86');
INSERT INTO `category` VALUES ('90', '鱼干', '86');
INSERT INTO `category` VALUES ('91', '鱼肠', '86');
INSERT INTO `category` VALUES ('92', '基围虾', '86');
INSERT INTO `category` VALUES ('93', '腊肉', '87');
INSERT INTO `category` VALUES ('94', '腌肉', '87');
INSERT INTO `category` VALUES ('95', '火腿', '87');
INSERT INTO `category` VALUES ('96', '香肠', '87');
INSERT INTO `category` VALUES ('97', '腊肠', '87');
INSERT INTO `category` VALUES ('98', '培根', '87');
INSERT INTO `category` VALUES ('99', '鱼肠', '87');
INSERT INTO `category` VALUES ('100', '洋酒/调制酒', '0');
INSERT INTO `category` VALUES ('101', '洋酒', '100');
INSERT INTO `category` VALUES ('102', '调制酒', '100');
INSERT INTO `category` VALUES ('103', '鸡尾酒', '101');
INSERT INTO `category` VALUES ('104', '威士忌', '101');
INSERT INTO `category` VALUES ('105', '伏特加', '101');
INSERT INTO `category` VALUES ('106', '白兰地', '101');
INSERT INTO `category` VALUES ('107', '预调酒', '101');
INSERT INTO `category` VALUES ('108', '力娇酒', '101');
INSERT INTO `category` VALUES ('109', '樱花酒', '102');
INSERT INTO `category` VALUES ('110', '杨梅酒', '102');
INSERT INTO `category` VALUES ('111', '自制葡萄酒', '102');
INSERT INTO `category` VALUES ('112', '梅子酒', '102');
INSERT INTO `category` VALUES ('113', '桑葚酒', '102');
INSERT INTO `category` VALUES ('114', '蓝莓酒', '102');
INSERT INTO `category` VALUES ('115', '茶水/饮料', '0');
INSERT INTO `category` VALUES ('116', '茶水', '115');
INSERT INTO `category` VALUES ('117', '咖啡', '115');
INSERT INTO `category` VALUES ('118', '饮料', '115');
INSERT INTO `category` VALUES ('119', '红茶', '116');
INSERT INTO `category` VALUES ('120', '白茶', '116');
INSERT INTO `category` VALUES ('121', '绿茶', '116');
INSERT INTO `category` VALUES ('122', '乌龙茶', '116');
INSERT INTO `category` VALUES ('123', '花茶', '116');
INSERT INTO `category` VALUES ('124', '速溶咖啡', '117');
INSERT INTO `category` VALUES ('125', '咖啡豆', '117');
INSERT INTO `category` VALUES ('126', '咖啡粉', '117');
INSERT INTO `category` VALUES ('127', '奶精', '117');
INSERT INTO `category` VALUES ('128', '糖浆/糖包', '117');
INSERT INTO `category` VALUES ('129', '果蔬汁', '118');
INSERT INTO `category` VALUES ('130', '碳酸饮料', '118');
INSERT INTO `category` VALUES ('131', '功能饮料', '118');
INSERT INTO `category` VALUES ('132', '凉茶', '118');
INSERT INTO `category` VALUES ('133', '矿泉水', '118');
INSERT INTO `category` VALUES ('134', '果味饮料', '118');
INSERT INTO `category` VALUES ('135', '乳制饮料', '118');
INSERT INTO `category` VALUES ('136', '品牌/礼包', '0');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `user_id` int(11) DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `g_id` (`g_id`) USING BTREE,
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for detailimg
-- ----------------------------
DROP TABLE IF EXISTS `detailimg`;
CREATE TABLE `detailimg` (
  `imgid` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `g_id` int(11) NOT NULL COMMENT '商品id',
  `imgurl` varchar(255) NOT NULL COMMENT '图片url',
  `type` varchar(255) DEFAULT NULL COMMENT '图片类型 0副图  1主图',
  PRIMARY KEY (`imgid`) USING BTREE,
  KEY `g_id` (`g_id`) USING BTREE,
  CONSTRAINT `detailimg_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of detailimg
-- ----------------------------

-- ----------------------------
-- Table structure for express
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express` (
  `express_ id` int(11) NOT NULL AUTO_INCREMENT COMMENT '快递表id',
  `express_name` varchar(100) NOT NULL COMMENT '快递商品名',
  `express_detail` varchar(255) DEFAULT NULL COMMENT '快递详情',
  PRIMARY KEY (`express_ id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of express
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `g_name` varchar(255) NOT NULL COMMENT '商品名称',
  `cate_id` int(11) NOT NULL COMMENT '分类id',
  `g_img` varchar(255) DEFAULT NULL COMMENT '主图URL',
  `g_salenum` bigint(20) NOT NULL COMMENT '销量',
  `g_uptime` datetime NOT NULL COMMENT '上架时间',
  `g_status` int(11) NOT NULL COMMENT '状态（0：下架  1：上架）',
  `g_downtime` datetime NOT NULL COMMENT '下架时间',
  `s_id` int(11) NOT NULL COMMENT '店铺id',
  `g_detail` varchar(255) DEFAULT NULL COMMENT '商品详情',
  PRIMARY KEY (`g_id`) USING BTREE,
  KEY `s_id` (`s_id`) USING BTREE,
  KEY `cate_id` (`cate_id`) USING BTREE,
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `store` (`s_id`),
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`cate_id`) REFERENCES `category` (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '百草味开心果', '50', null, '50', '2018-06-03 18:42:25', '0', '2018-06-06 18:42:36', '1', '1');
INSERT INTO `goods` VALUES ('4', '百草味巴旦木', '53', null, '60', '2018-05-08 18:50:47', '0', '2018-06-29 18:50:55', '1', '2');

-- ----------------------------
-- Table structure for goodsdetail
-- ----------------------------
DROP TABLE IF EXISTS `goodsdetail`;
CREATE TABLE `goodsdetail` (
  `gd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品详情表id',
  `taste_id` int(11) NOT NULL COMMENT '口味id',
  `pack_id` int(11) NOT NULL COMMENT '包装id',
  `stock` int(11) NOT NULL COMMENT '库存',
  `gd_oldprice` decimal(10,2) NOT NULL COMMENT '原价',
  `gd_price` decimal(10,2) DEFAULT NULL COMMENT '现价',
  `g_id` int(11) DEFAULT NULL COMMENT '商品表id[外键]',
  `gd_unit` varchar(4) DEFAULT NULL COMMENT '商品单位',
  PRIMARY KEY (`gd_id`) USING BTREE,
  KEY `taste_id` (`taste_id`) USING BTREE,
  KEY `pack_id` (`pack_id`) USING BTREE,
  KEY `g_id` (`g_id`) USING BTREE,
  CONSTRAINT `goodsdetail_ibfk_1` FOREIGN KEY (`taste_id`) REFERENCES `taste` (`taste_id`),
  CONSTRAINT `goodsdetail_ibfk_2` FOREIGN KEY (`pack_id`) REFERENCES `pack` (`pack_id`),
  CONSTRAINT `goodsdetail_ibfk_3` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of goodsdetail
-- ----------------------------
INSERT INTO `goodsdetail` VALUES ('1', '1', '1', '50', '50.00', '25.00', '1', '包');
INSERT INTO `goodsdetail` VALUES ('6', '1', '1', '40', '89.00', '69.00', '4', '包');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `or_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `or_num` varchar(255) NOT NULL COMMENT '订单总价',
  `user_message` varchar(255) DEFAULT NULL COMMENT '买家留言',
  `createtime` datetime NOT NULL COMMENT '下单时间',
  `delivertime` datetime DEFAULT NULL COMMENT '发货时间',
  `confirmtime` datetime DEFAULT NULL COMMENT '确认时间',
  `addr_id` int(11) NOT NULL COMMENT '收货地址id',
  `or_status` int(11) NOT NULL COMMENT '订单状态( 0: 待发货 1：待收货  2：已收货 3：退款/售后',
  `express_id` int(11) NOT NULL COMMENT '快递表id',
  PRIMARY KEY (`or_id`) USING BTREE,
  KEY `addr_id` (`addr_id`) USING BTREE,
  KEY `express_id` (`express_id`) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`addr_id`) REFERENCES `addrinfo` (`addr_id`),
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`express_id`) REFERENCES `express` (`express_ id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `ode_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详细信息id',
  `or_id` int(11) NOT NULL COMMENT '订单id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `g_num` bigint(20) NOT NULL COMMENT '商品数量',
  `totalprice` decimal(10,2) NOT NULL COMMENT '商品总价',
  `gd_id` int(11) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`ode_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `or_id` (`or_id`) USING BTREE,
  KEY `g_id` (`gd_id`) USING BTREE,
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`or_id`) REFERENCES `order` (`or_id`),
  CONSTRAINT `orderdetail_ibfk_3` FOREIGN KEY (`gd_id`) REFERENCES `goodsdetail` (`gd_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------

-- ----------------------------
-- Table structure for pack
-- ----------------------------
DROP TABLE IF EXISTS `pack`;
CREATE TABLE `pack` (
  `pack_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '包装id',
  `pack_val` varchar(255) NOT NULL COMMENT '包装值',
  PRIMARY KEY (`pack_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pack
-- ----------------------------
INSERT INTO `pack` VALUES ('1', '200g/一袋');

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `pri_id` int(11) NOT NULL,
  `pri_url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pri_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of privilege
-- ----------------------------

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `rev_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `g_id` int(11) NOT NULL COMMENT '商品id',
  `rev_content` text COMMENT '内容',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `revparent_id` int(11) NOT NULL COMMENT '评论父id',
  `rev_date` date NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`rev_id`) USING BTREE,
  KEY `g_id` (`g_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ro_id` int(11) NOT NULL COMMENT '角色id',
  `ro_name` varchar(20) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`ro_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '店铺管理员');

-- ----------------------------
-- Table structure for role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege` (
  `ro_id` int(11) NOT NULL,
  `pri_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ro_id`) USING BTREE,
  KEY `pri_id` (`pri_id`) USING BTREE,
  CONSTRAINT `pri_id` FOREIGN KEY (`pri_id`) REFERENCES `privilege` (`pri_id`),
  CONSTRAINT `ro_id` FOREIGN KEY (`ro_id`) REFERENCES `role` (`ro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for salecar
-- ----------------------------
DROP TABLE IF EXISTS `salecar`;
CREATE TABLE `salecar` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT 'id',
  `gd_id` int(11) NOT NULL COMMENT '商品详细信息id',
  `sal_num` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`car_id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `goods_id` (`gd_id`) USING BTREE,
  CONSTRAINT `salecar_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `salecar_ibfk_2` FOREIGN KEY (`gd_id`) REFERENCES `goodsdetail` (`gd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of salecar
-- ----------------------------
INSERT INTO `salecar` VALUES ('1', '1', '1', '2');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '店铺id',
  `s_name` varchar(255) NOT NULL COMMENT '店铺名字',
  `s_logo` varchar(255) NOT NULL COMMENT '店铺logo',
  `ro_id` int(11) NOT NULL COMMENT '角色id[外键]',
  `s_status` varchar(5) NOT NULL COMMENT '商家状态 1"正常经营",2"封号"',
  `s_adminname` varchar(20) NOT NULL COMMENT '商家账号',
  `s_password` varchar(20) NOT NULL COMMENT '商家密码',
  PRIMARY KEY (`s_id`) USING BTREE,
  KEY `ro_id` (`ro_id`) USING BTREE,
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`ro_id`) REFERENCES `role` (`ro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '百草味旗舰店', '', '1', '1', 'aaa', 'aaa');

-- ----------------------------
-- Table structure for sto_exp
-- ----------------------------
DROP TABLE IF EXISTS `sto_exp`;
CREATE TABLE `sto_exp` (
  `express_id` int(11) NOT NULL,
  `store_id` int(11) DEFAULT NULL,
  KEY `express_id` (`express_id`) USING BTREE,
  KEY `store_id` (`store_id`) USING BTREE,
  CONSTRAINT `sto_exp_ibfk_1` FOREIGN KEY (`express_id`) REFERENCES `express` (`express_ id`),
  CONSTRAINT `sto_exp_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `store` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sto_exp
-- ----------------------------

-- ----------------------------
-- Table structure for system
-- ----------------------------
DROP TABLE IF EXISTS `system`;
CREATE TABLE `system` (
  `sys_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统管理员id',
  `sys_name` varchar(20) NOT NULL COMMENT '系统管理员登录名',
  `sys_password` varchar(50) NOT NULL COMMENT '系统管理员登录密码',
  PRIMARY KEY (`sys_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of system
-- ----------------------------

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `sys_id` int(11) NOT NULL,
  `ro_id` int(11) NOT NULL,
  PRIMARY KEY (`sys_id`) USING BTREE,
  KEY `ro_id` (`ro_id`) USING BTREE,
  CONSTRAINT `system_role_ibfk_1` FOREIGN KEY (`sys_id`) REFERENCES `system` (`sys_id`),
  CONSTRAINT `system_role_ibfk_2` FOREIGN KEY (`ro_id`) REFERENCES `role` (`ro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of system_role
-- ----------------------------

-- ----------------------------
-- Table structure for taste
-- ----------------------------
DROP TABLE IF EXISTS `taste`;
CREATE TABLE `taste` (
  `taste_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '口味id',
  `taste_val` varchar(20) NOT NULL COMMENT '口味值',
  PRIMARY KEY (`taste_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of taste
-- ----------------------------
INSERT INTO `taste` VALUES ('1', '原味');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(30) NOT NULL COMMENT '用户密码',
  `email` varchar(50) NOT NULL COMMENT '用户邮箱',
  `phone` char(11) NOT NULL COMMENT '用户电话',
  `gender` int(11) NOT NULL COMMENT '性别：( 0:男 1：女  2：保密)',
  `headimg` varchar(255) NOT NULL COMMENT '用户头像',
  `realname` varchar(20) NOT NULL COMMENT '真实姓名',
  `user_status` varchar(5) NOT NULL COMMENT '用户状态 1"正常" 2"封号"',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'x小红', '123', 'xiaohong@163.com', '13592968975', '1', '', '陈春红', '0');
