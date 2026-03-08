/*
 Navicat Premium Data Transfer

 Source Server         : Mysql8.0
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 08/03/2026 17:37:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `qu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目ID',
  `qu_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目内容',
  `subject_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学科id',
  `wrong_count` int NOT NULL COMMENT '答错次数',
  `qu_type` int NOT NULL COMMENT '题型',
  `kn_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '知识点内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '错题本' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('01d69621435d4a70a949f942303c8eb6', '90f8d5ed367a43468fbc0aa620f75830', '2ef952053c234876bcfe67dc61b1bf45', '【用于考试+训练】世界上面积最大的国家是（）。', '36ca54d96f434c269afa9814e5759215', 1, 1, '中国常识');
INSERT INTO `book` VALUES ('091f65688e054d3e8966d0e8b446354c', '90f8d5ed367a43468fbc0aa620f75830', '0e80bcc639aa472aa5e98aecd8c9a58c', '我国最北面的城市是哪个（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '中国常识');
INSERT INTO `book` VALUES ('0efd0fef628743c49fc944e906d9321e', '90f8d5ed367a43468fbc0aa620f75830', 'd481d614f7a74465829cf380f297ee0c', '驾驶机动车通过没有交通信号的交叉路口怎样行驶？', '36ca54d96f434c269afa9814e5759215', 1, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('0f8ec70522ce489099a1a9a09cd2ee02', '8d322e7394904df2bed4723f2c58ec92', '00739ffce4f34859ab29d10c6b45aa04', '下列河流，最终注入印度洋的是（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '地理知识');
INSERT INTO `book` VALUES ('179510411b424561a1ef997ab75c5d4e', '8d322e7394904df2bed4723f2c58ec92', '091de7090a074c84ac13663c6a0a5eb2', '【用于考试+训练】亚洲各国经济发展不平衡，下列国家中人均国民生产总值最高的是（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '亚洲知识');
INSERT INTO `book` VALUES ('19582a38c1a248dca332575b2e363b96', '90f8d5ed367a43468fbc0aa620f75830', '3c63ae9e3dae48d886997c320c863de7', '<p>驾驶机动车应当依法取得哪种证件？</p>', '36ca54d96f434c269afa9814e5759215', 1, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('1b04891096e34ce9bbd942c768dd84cb', '8d322e7394904df2bed4723f2c58ec92', '75c0ec5e6f044d5781a6e3f97a80c70d', '属于对受训者情感结果的评价主要涉及的维度和指标的是（　　）', '36ca54d96f434c269afa9814e5759215', 2, 2, '企业培训与制度');
INSERT INTO `book` VALUES ('1b1034a964b542e58bc822e19f382418', '8d322e7394904df2bed4723f2c58ec92', 'e243b3bf70a648ec8da08c93f55af26d', '<p>&ldquo;李杜文章在，光芒万丈长&rdquo;，这里的&rdquo;李杜&rdquo;指的是（）和（）。</p>\n<p>此题演示无序作答，为演示方便提供答案：李白、杜甫。</p>', '36ca54d96f434c269afa9814e5759215', 1, 4, '语文知识');
INSERT INTO `book` VALUES ('1bdf7f475909428e83ec3c1a96158280', '8d322e7394904df2bed4723f2c58ec92', '66e92fe6520d45c4a1bf8f88044fcbbf', '<p><img class=\"wscnph\" src=\"https://files.yfhl.net/2023/10/30/1698635062954-3a7db0b5.png\" /></p>\n<p>以下属于唐代诗人的有（）</p>', '36ca54d96f434c269afa9814e5759215', 3, 2, '语文知识');
INSERT INTO `book` VALUES ('28193c0d53f44d8f8a13c203b602f4a6', '8d322e7394904df2bed4723f2c58ec92', '0b6a5a93d9e8453b80f26c122f20c81f', '【用于考试】南极洲的代表动物是（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '地理知识');
INSERT INTO `book` VALUES ('28cd4cafe0ef46d7b17428361ea1ff2d', '8d322e7394904df2bed4723f2c58ec92', '19646da51e454d3d910f07696cc1f1e5', '下列选项中，属于绩效面谈的类型的有（　　）', '36ca54d96f434c269afa9814e5759215', 3, 2, '企业培训与制度');
INSERT INTO `book` VALUES ('302225761eb948a2b5e76300f0cc3f15', '8d322e7394904df2bed4723f2c58ec92', '6882fa950b3a44e58aad41a91eebbc76', '<p><img class=\"wscnph\" src=\"https://files.yfhl.net/2023/8/22/1692704478535-0f7fad7b.png\" /></p>\n<p>党的十九大报告指出，全党要更加自觉地增强（ ）自信、（ ）自信、（ ）自信、（ ）自信，既不走封闭僵化的老路，也不走改旗易帜的邪路，保持政治定力，坚持实干兴邦，始终坚持和发展中国特色社会主义。wqwqwqwq</p>', '36ca54d96f434c269afa9814e5759215', 2, 4, '语文知识');
INSERT INTO `book` VALUES ('410b38d72b054d9184cadfb1b77ce7fd', '8d322e7394904df2bed4723f2c58ec92', 'b0ace503d6524c28b1dd607a57c105e1', '机动车驾驶证遗失的，机动车驾驶人应当向哪里的车辆管理所申请补发？', '36ca54d96f434c269afa9814e5759215', 1, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('44099e969cfd41968f5e025865b184d0', '90f8d5ed367a43468fbc0aa620f75830', 'be7eb38737a84544901f1f3b0d6413be', '道路交通安全违法行为累积记分的周期是多长时间？', '36ca54d96f434c269afa9814e5759215', 1, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('4e0d94ed3db24eb2bd447c18dffaa44a', '8d322e7394904df2bed4723f2c58ec92', 'a1922aafdafa41979769bfd61da548a8', '<p>Max helps Bill with ().</p>', '36ca54d96f434c269afa9814e5759215', 1, 1, '英语知识');
INSERT INTO `book` VALUES ('594a74c72bbb400fad11279825dc99a5', '8d322e7394904df2bed4723f2c58ec92', 'e4ef758c45ca4ee3bb14b834ab7563de', '下列属于四大名花的是（）', '36ca54d96f434c269afa9814e5759215', 2, 2, '语文知识');
INSERT INTO `book` VALUES ('6c2980e59ea84acf85943a1b20249c9e', '8d322e7394904df2bed4723f2c58ec92', '05ee4104eb77411fb38753b28bb96a61', '【用于训练】亚洲人中分布不是很均匀，其中人中较稀疏的部分是（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '亚洲知识');
INSERT INTO `book` VALUES ('72a52fff332d4b39bef4b6b471f21e92', '8d322e7394904df2bed4723f2c58ec92', '16502738ea7142afa3f5a2b30fd7340a', '人们把社会生产的各个部门划分为三类产业，下列属于第三产业的是（）', '36ca54d96f434c269afa9814e5759215', 2, 1, '经济知识');
INSERT INTO `book` VALUES ('7938ae54a27a4d9195a16b2b670121a0', '8d322e7394904df2bed4723f2c58ec92', '00144a9784b4486ea59f4c44ac888769', '中国、日本位于亚洲的（）', '36ca54d96f434c269afa9814e5759215', 4, 1, '亚洲知识');
INSERT INTO `book` VALUES ('7ae87002773f495fabe55aa9b64cdafb', '8d322e7394904df2bed4723f2c58ec92', '71153b61fc98484db5955fba15aabedd', '<p>以下属于唐代诗人的有（）</p>', '36ca54d96f434c269afa9814e5759215', 3, 2, '语文知识');
INSERT INTO `book` VALUES ('80b71b7e0ee14f2ca2c898382fbb639f', '8d322e7394904df2bed4723f2c58ec92', '060910f16c3b4247abd3f9c32bac8f4c', '<p>中国古代四大发明。</p>', '36ca54d96f434c269afa9814e5759215', 1, 4, '语文知识');
INSERT INTO `book` VALUES ('883f36f1e3af4d8fbc251482681ab666', '8d322e7394904df2bed4723f2c58ec92', '0a3f8a446fcf4654aa3f351d816029d5', '亚洲地形的特点是( )', '36ca54d96f434c269afa9814e5759215', 1, 1, '亚洲知识');
INSERT INTO `book` VALUES ('88bf5ac5ee3743d5bb25c09021c14f97', '90f8d5ed367a43468fbc0aa620f75830', 'b0ace503d6524c28b1dd607a57c105e1', '机动车驾驶证遗失的，机动车驾驶人应当向哪里的车辆管理所申请补发？', '36ca54d96f434c269afa9814e5759215', 2, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('8d828b92580c46cfb09e16f0bbc532e5', '8d322e7394904df2bed4723f2c58ec92', '08f8b219924948fc8c4206b9c1ad590f', '驾驶人的机动车驾驶证被依法扣留、暂扣的情况下不得驾驶机动车。', '36ca54d96f434c269afa9814e5759215', 2, 3, '驾驶安全与规则');
INSERT INTO `book` VALUES ('91c80a56fc3b4ec493a3a0fb3d787b79', '8d322e7394904df2bed4723f2c58ec92', 'f27db377b6784bafa9eb1bdd93d770e8', '绩效考评指标的来源包括（　　）', '36ca54d96f434c269afa9814e5759215', 2, 2, '企业培训与制度');
INSERT INTO `book` VALUES ('932c8ddc524f40f9bd3b6c9e495cbefc', '8d322e7394904df2bed4723f2c58ec92', '03d06173efdb49d3a151fb48528e40b8', '<p>The two new teachers are all very tall.</p>', '36ca54d96f434c269afa9814e5759215', 2, 3, '英语知识');
INSERT INTO `book` VALUES ('a829c77a156340b3b1446035118d4566', '8d322e7394904df2bed4723f2c58ec92', '111dd1c11bc349dcb3798cc0af0ba830', '【用于训练】亚洲地形的特点是( )', '36ca54d96f434c269afa9814e5759215', 2, 1, '亚洲知识');
INSERT INTO `book` VALUES ('b98796263ccc4a2898fcdc644dc421c3', '90f8d5ed367a43468fbc0aa620f75830', '111dd1c11bc349dcb3798cc0af0ba830', '【用于训练】亚洲地形的特点是( )', '36ca54d96f434c269afa9814e5759215', 2, 1, '亚洲知识');
INSERT INTO `book` VALUES ('bf9848c155084e33b6fb97b73358d2e7', '8d322e7394904df2bed4723f2c58ec92', '7ab30154c23243a7837c91760778bddc', '著名的亚欧间的海峡是（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '地理知识');
INSERT INTO `book` VALUES ('c23333b6d07a4ceda418a02d0d2fe8a3', '8d322e7394904df2bed4723f2c58ec92', '0e80bcc639aa472aa5e98aecd8c9a58c', '我国最北面的城市是哪个（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '中国常识');
INSERT INTO `book` VALUES ('c6791454a1a44c44b947727d6ede3cb5', '90f8d5ed367a43468fbc0aa620f75830', 'c43edf71dcb243abb13d32df9605a655', '下列哪种行为会受到200元以上2000元以下罚款，并处吊销机动车驾驶证？', '36ca54d96f434c269afa9814e5759215', 1, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('c6c23d862d3444898165ed04457ccc5b', '90f8d5ed367a43468fbc0aa620f75830', '16502738ea7142afa3f5a2b30fd7340a', '人们把社会生产的各个部门划分为三类产业，下列属于第三产业的是（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '经济知识');
INSERT INTO `book` VALUES ('c8216e590a144e9ebaad1619aa4f9406', '90f8d5ed367a43468fbc0aa620f75830', 'dddd0101c95b44409907656c2291111b', '行车中遇到后方车辆要求超车时，应怎样做？', '36ca54d96f434c269afa9814e5759215', 1, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('c8fc7cbcf89b4bb4a5fbc99967a0e66a', '8d322e7394904df2bed4723f2c58ec92', '5611e5efbed5499e87f3c5cdf7832cef', '驾驶机动车遇雾、雨、雪等能见度在50米以内时，最高速度不能超过多少？', '36ca54d96f434c269afa9814e5759215', 1, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('cd7d76396e474eb582f764d49e82064b', '8d322e7394904df2bed4723f2c58ec92', 'f53c81b561b14148b07cdaf1ff26f99a', '<p>薪酬市场调查的主要方法有（　　）</p>', '36ca54d96f434c269afa9814e5759215', 2, 2, '经济知识');
INSERT INTO `book` VALUES ('d89686919f6c42fe8d78e7ead8021284', '8d322e7394904df2bed4723f2c58ec92', '029f7977ee744d9487ee5b1ed596a64f', '下面属于唐代诗人李白的作品的是（）', '36ca54d96f434c269afa9814e5759215', 1, 1, '语文知识');
INSERT INTO `book` VALUES ('e04beb3b9f81478a9ff66b3327a13765', '90f8d5ed367a43468fbc0aa620f75830', '5611e5efbed5499e87f3c5cdf7832cef', '驾驶机动车遇雾、雨、雪等能见度在50米以内时，最高速度不能超过多少？', '36ca54d96f434c269afa9814e5759215', 1, 1, '驾驶安全与规则');
INSERT INTO `book` VALUES ('e68c9c4990f741a783babbad6357be43', '8d322e7394904df2bed4723f2c58ec92', 'f80aa11cbbb54294ba1646c732607126', '以下英文四只脚的动物有（）', '36ca54d96f434c269afa9814e5759215', 2, 2, '动物知识');
INSERT INTO `book` VALUES ('eda7e70b5537460cbed71fca42da2afc', '8d322e7394904df2bed4723f2c58ec92', '62815d180ad5487a80689235718c74ec', '以下属于唐代诗人的有（）', '36ca54d96f434c269afa9814e5759215', 4, 2, '语文知识');
INSERT INTO `book` VALUES ('ef57f7da07834c08829f7b80972c740f', '8d322e7394904df2bed4723f2c58ec92', '4e04138e31ad4946b83110d91be99cdf', '下列属于四大美女的是（）', '36ca54d96f434c269afa9814e5759215', 2, 2, '语文知识');
INSERT INTO `book` VALUES ('f5f923e9b08d411db43aac70a7aaafb9', '90f8d5ed367a43468fbc0aa620f75830', '27fa1550e3314b2a82d2493cbc4b0373', '【用于考试】中国面积最大的省份是哪一个（）。', '36ca54d96f434c269afa9814e5759215', 1, 1, '中国常识');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `parent_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上层部门code',
  `dept_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门编码',
  `dept_level` int NOT NULL COMMENT '部门层级',
  `dept_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门类型（预留）',
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('01ba8601b25f40aea51ae3a9e855feef', 'A07', 'A07A01', 1, NULL, '生物技术', '2024-04-25 15:41:09', 'xxx', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('067a457ca0f14cb1a3e09c87acecdd18', '0', 'A01', 0, NULL, '计算机科学与工程学院', '2023-11-23 21:38:18', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('0808c46bd1f84b1888621637b110e4d7', 'A01', 'A01A03', 1, NULL, '计算机科学', '2023-11-23 21:40:37', 'ffb36d0a23964b748f91f70443a4fb27', '2023-12-03 14:57:16', NULL, NULL, 2);
INSERT INTO `department` VALUES ('0a5d0775aacb4a16a10d7726db4e56e6', 'A05', 'A05A02', 1, NULL, '哲学', '2024-03-20 18:13:51', 'xxx', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('0b25eaecb7a54fbab57a9b729502abae', '0', 'A04', 0, NULL, '艺术与设计学院', '2023-11-23 21:54:00', 'ffb36d0a23964b748f91f70443a4fb27', '2023-11-24 13:04:12', NULL, NULL, 2);
INSERT INTO `department` VALUES ('0b9abede1d404ecea814adea4afcbb03', '0', 'A05', 0, NULL, '文学院', '2024-03-20 18:13:27', 'xxx', NULL, NULL, NULL, 8);
INSERT INTO `department` VALUES ('29d3a44532ae4917a075feac0c8cfca4', 'A06', 'A06A02', 1, NULL, '化学工程与工艺', '2024-04-25 15:40:32', 'xxx', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('2bc865bf13fd4f77a0ed3ea924ae11bf', 'A09', 'A09A01', 1, NULL, '法学', '2024-04-25 15:42:35', 'xxx', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('392059fbc3514f89b1e4f4cfa6387992', 'A03', 'A03A01', 1, NULL, '经济学', '2023-11-23 21:42:31', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('39efb800fe9a4877a51381df2de07160', 'A01A04A01', 'A01A04A01A03', 3, NULL, '20060211班', '2023-12-03 14:56:22', 'xxx', NULL, NULL, NULL, 3);
INSERT INTO `department` VALUES ('3b7b10b69a574e01af4e5706a62ec144', '0', 'A08', 0, NULL, '外国语学院', '2024-04-25 15:41:50', 'xxx', NULL, NULL, NULL, 4);
INSERT INTO `department` VALUES ('45bea47b3d7a49448215effa3a80c9ea', 'A10', 'A10A02', 1, NULL, '考古学', '2024-04-25 15:43:30', 'xxx', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('48c66aa54c344268aa5ce30258a4f2e0', 'A04', 'A04A02', 1, NULL, '美术学', '2023-11-24 13:04:25', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('50b90ed297cc43b391d03203c10834ff', '0', 'A11', 0, NULL, '音乐学院', '2024-04-25 15:43:36', 'xxx', NULL, NULL, NULL, 7);
INSERT INTO `department` VALUES ('53a1369b6d044d809e8076b78321d817', 'A08', 'A08A02', 1, NULL, '翻译', '2024-04-25 15:42:09', 'xxx', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('626442feae3644a39327dbf516e0e466', 'A11', 'A11A02', 1, NULL, '作曲与技术理论', '2024-04-25 15:43:58', 'xxx', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('65d06fa7445949fa9eb43d4309251f09', 'A03', 'A03A02', 1, NULL, '金融学', '2023-11-23 21:43:41', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('687a5ee40f1647daa7ccd08ea71bf627', '0', 'A03', 0, NULL, '经济与管理学院', '2023-11-23 21:42:20', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 11);
INSERT INTO `department` VALUES ('6c6025b46bd54fc0bc5993e50be43741', '0', 'A07', 0, NULL, '生命科学学院', '2024-04-25 15:41:01', 'xxx', NULL, NULL, NULL, 3);
INSERT INTO `department` VALUES ('70641f343c8f4f87970e723ccf2b094e', '0', 'A09', 0, NULL, '法学院', '2024-04-25 15:42:30', 'xxx', NULL, NULL, NULL, 5);
INSERT INTO `department` VALUES ('706980f5ed9a4aa69563c43cdc7cdba5', 'A02', 'A02A02', 1, NULL, '物理学', '2023-11-23 21:41:44', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('7c53890df7bc4cfba44d600b92fbdb0e', 'A10', 'A10A01', 1, NULL, '中国史', '2024-04-25 15:43:24', 'xxx', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('7d3a59284cd34a56ae368cf70b2265d3', 'A07', 'A07A02', 1, NULL, '生态学', '2024-04-25 15:41:15', 'xxx', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('7e6be3c6c7c44ecf9115e51420eb46d3', 'A06', 'A06A01', 1, NULL, '有机化学', '2024-04-25 15:40:16', 'xxx', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('84862fde0ab9471fa1d22a9866f1c619', 'A05', 'A05A01', 1, NULL, '汉语言文学', '2024-03-20 18:13:45', 'xxx', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('86245c3d4ddf493897ccd1d088682a6a', '0', 'A10', 0, NULL, '历史学院', '2024-04-25 15:43:13', 'xxx', NULL, NULL, NULL, 6);
INSERT INTO `department` VALUES ('8e9922b9ebdf4b30b78ef92f0bdd3ce4', 'A04', 'A04A01', 1, NULL, '视觉传达设计', '2023-11-23 21:54:22', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('a8d5fc562d41450fa2b5a444a0996ab6', '0', 'A02', 0, NULL, '理学院', '2023-11-23 21:41:22', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 10);
INSERT INTO `department` VALUES ('ae3f470423c94489a330483ecf171f7b', '0', 'A06', 0, NULL, '化学学院', '2024-04-25 15:39:54', 'xxx', NULL, NULL, NULL, 9);
INSERT INTO `department` VALUES ('b20258af1290474ea15bf96d3e220fd5', 'A01A04A01', 'A01A04A01A04', 3, NULL, '20060212班', '2023-12-03 14:56:37', 'xxx', NULL, NULL, NULL, 4);
INSERT INTO `department` VALUES ('b3234873a88044ce8fa84f00df6f922d', 'A09', 'A09A02', 1, NULL, '国际法', '2024-04-25 15:42:41', 'xxx', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('bb7cafe32746434bbdeb5751a259bfc8', 'A01A04', 'A01A04A01', 2, NULL, '2020级', '2023-12-03 14:55:36', 'xxx', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('cb7f9e45845345b59ddb83baac5928e7', 'A01', 'A01A04', 1, NULL, '软件工程', '2023-11-23 21:41:13', 'ffb36d0a23964b748f91f70443a4fb27', '2023-12-03 14:57:11', NULL, NULL, 1);
INSERT INTO `department` VALUES ('d4a660962fc34a2f80f2003cb6794561', 'A01', 'A01A05', 1, NULL, '物联网工程', '2023-11-23 21:42:00', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, 3);
INSERT INTO `department` VALUES ('d8044e02090347ecbd18fd0e5febd378', 'A02', 'A02A03', 1, NULL, '应用物理学', '2023-11-23 21:41:50', 'ffb36d0a23964b748f91f70443a4fb27', '2024-04-25 15:39:42', 'ffb36d0a23964b748f91f70443a4fb27', NULL, 2);
INSERT INTO `department` VALUES ('e36fb8d128564a758f08407561565dfe', 'A08', 'A08A01', 1, NULL, '英语语言文学', '2024-04-25 15:42:02', 'xxx', NULL, NULL, NULL, 1);
INSERT INTO `department` VALUES ('e45f588be24a425eb41b1ee8531ef57e', 'A01A04A01', 'A01A04A01A02', 3, NULL, '20060210班', '2023-12-03 14:56:09', 'xxx', NULL, NULL, NULL, 2);
INSERT INTO `department` VALUES ('fb14776fad6d41da868603d4c3d1cb76', 'A11', 'A11A01', 1, NULL, '音乐表演', '2024-04-25 15:43:47', 'xxx', NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `paper_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '试卷ID',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考试标题',
  `dept_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '考试部门编码',
  `dept_text` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '考试部门名称',
  `start_time` datetime NOT NULL COMMENT '考试开始时间',
  `end_time` datetime NOT NULL COMMENT '考试结束时间',
  `statue` int NOT NULL COMMENT '考试状态 0:未开始1:已开始2:已结束',
  `open_type` int NOT NULL DEFAULT 0 COMMENT '开放权限 0:完全公开 1:指定学生2:指定部门',
  `duration` int NOT NULL COMMENT '考试时长',
  `thanks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '感谢语',
  `late_max` int NULL DEFAULT 0 COMMENT '允许迟到时间',
  `hand_min` int NULL DEFAULT 0 COMMENT '最少答题时间',
  `result_type` int NULL DEFAULT NULL COMMENT '结果显示类型（只显示分数/显示分数+答题详情/展示答题详情）',
  `qualify_score` int NOT NULL COMMENT '及格分数',
  `review_quire` tinyint NULL DEFAULT 0 COMMENT '是否需要阅卷0:不需要1:需要',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `start_job_id` int NULL DEFAULT NULL COMMENT '开始考试任务Id',
  `stop_job_id` int NULL DEFAULT NULL COMMENT '停止考试任务Id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '考试表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('074cfcac0e984a34846868762e828f8d', '43ad1b7757924908a0ce6948a893feb1', '12', '', '生物技术', '2024-06-13 22:58:00', '2024-06-13 22:59:00', 1, 1, 1, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-13 22:57:04', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 294, 295);
INSERT INTO `exam` VALUES ('12f1ae2182f24e8e9a759b96ace959c6', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 21:58:09', '2024-06-24 21:58:11', 0, 1, 2880, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:58:18', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 334, 335);
INSERT INTO `exam` VALUES ('152c961c153f408ca9fc237f58337904', '43ad1b7757924908a0ce6948a893feb1', '1', NULL, NULL, '2024-06-23 12:53:04', '2024-06-26 12:53:07', 0, 0, 4320, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 12:53:13', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 310, 311);
INSERT INTO `exam` VALUES ('221606845b8f45ac821099e79c883e4b', '43ad1b7757924908a0ce6948a893feb1', '测试倒计时2', '', '生物技术', '2024-06-04 19:02:00', '2024-06-04 19:09:29', 1, 1, 7, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-04 19:01:32', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 272, 273);
INSERT INTO `exam` VALUES ('2c881b0578a745228ebad557e9c67a1a', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-27 22:00:04', '2024-06-29 22:00:07', 0, 1, 2880, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 22:00:24', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 336, 337);
INSERT INTO `exam` VALUES ('308080102f674f119591515a72082b2c', 'dc83d0a71d4f44fc9cd1eb1359871fa0', '测试倒计时3', '', '生物技术', '2024-06-04 21:10:00', '2024-06-14 21:09:12', 1, 1, 14399, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-04 21:09:25', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 276, 277);
INSERT INTO `exam` VALUES ('3a81c6eb4134469383ed8972c33286f3', '43ad1b7757924908a0ce6948a893feb1', '1', NULL, NULL, '2024-06-22 13:34:54', '2024-06-26 13:34:57', 0, 0, 5760, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 13:35:04', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 314, 315);
INSERT INTO `exam` VALUES ('3efd8a8071714e50af31791a573a00e9', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 22:03:31', '2024-06-23 22:03:34', 0, 1, 1440, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 22:03:45', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 338, 339);
INSERT INTO `exam` VALUES ('510bfb55eabe4b748c2266bdd534e328', 'ffc4f2889a5f4718a92b0753f50ac94f', '填空题', '', '生物技术', '2024-06-13 22:46:00', '2024-06-14 22:45:32', 1, 1, 1439, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-13 22:45:40', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 290, 291);
INSERT INTO `exam` VALUES ('52af0d9f674845cf8bac10494f724965', '43ad1b7757924908a0ce6948a893feb1', '666', '', '生物技术', '2024-06-07 14:24:00', '2024-06-07 14:25:00', 1, 1, 1, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-07 14:22:42', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 280, 281);
INSERT INTO `exam` VALUES ('59cdbb9c2af240ac8da71fdab6b7c141', '724fb825e56d4f3cacb23f4ee510b53a', '测试', '', '生物技术', '2024-06-22 21:03:01', '2024-06-25 21:03:05', 0, 1, 4320, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:03:13', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 318, 319);
INSERT INTO `exam` VALUES ('6d83e19fdb4842529a7a9e44c06c1fa7', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-28 21:48:57', '2024-06-29 21:49:01', 0, 1, 1440, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:49:26', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 328, 329);
INSERT INTO `exam` VALUES ('6ec1f64a052c41dab96d2a596dc6d5b2', '43ad1b7757924908a0ce6948a893feb1', '777', '', '生物技术', '2024-06-07 14:29:04', '2024-06-21 14:27:01', 1, 1, 20157, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-07 14:27:14', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 282, 283);
INSERT INTO `exam` VALUES ('76d6d12648dd40edb5b92f52af24ed2e', 'ffc4f2889a5f4718a92b0753f50ac94f', '填空测试2', '', '生物技术', '2024-06-13 22:52:00', '2024-06-13 23:51:58', 1, 1, 59, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-13 22:51:08', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 292, 293);
INSERT INTO `exam` VALUES ('7daa7f5cc1a54993b5c2af2a5fd39f71', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 21:52:31', '2024-06-25 21:52:35', 0, 1, 4320, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:52:46', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 330, 331);
INSERT INTO `exam` VALUES ('845ae096b3914be2a95a9bc6cacbcc6c', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 21:18:45', '2024-06-29 21:18:49', 0, 1, 10080, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:18:57', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 324, 325);
INSERT INTO `exam` VALUES ('aa5c08769ccc4ea2b4b8ca891df61d4f', '724fb825e56d4f3cacb23f4ee510b53a', '555', '', '生物技术', '2024-06-14 18:18:00', '2024-06-14 19:17:31', 1, 1, 59, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-14 18:17:42', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 298, 299);
INSERT INTO `exam` VALUES ('abc4e7d86f304514b9c41110ef45f7e9', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 22:31:30', '2024-06-26 22:31:34', 0, 1, 5760, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 22:31:43', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 342, 343);
INSERT INTO `exam` VALUES ('b158f81ee61b4ea2892e40085521f15d', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 21:33:20', '2024-06-23 21:33:24', 0, 1, 1440, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:33:34', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 326, 327);
INSERT INTO `exam` VALUES ('b69c074cec98498aab9c9c09b8cb8c81', '43ad1b7757924908a0ce6948a893feb1', '1', NULL, NULL, '2024-06-22 13:33:57', '2024-06-23 13:34:01', 0, 0, 1440, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 13:34:09', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 312, 313);
INSERT INTO `exam` VALUES ('b781b99fad7c4326a9c06c0632afa143', '43ad1b7757924908a0ce6948a893feb1', '倒计时3', '', '生物技术', '2024-06-04 20:27:06', '2024-06-04 21:26:13', 1, 1, 59, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-04 20:26:23', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 274, 275);
INSERT INTO `exam` VALUES ('b7ee36f91e5f436086f9b6483a3bb5ee', 'dc83d0a71d4f44fc9cd1eb1359871fa0', '111', '', '生物技术', '2024-06-12 19:17:22', '2024-06-20 19:16:24', 1, 1, 11519, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-12 19:16:32', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 286, 287);
INSERT INTO `exam` VALUES ('b8e277ee245b4d0999c61e67de75b2fc', '43ad1b7757924908a0ce6948a893feb1', '123', '', '生物技术', '2024-06-22 12:49:18', '2024-06-27 12:49:21', 0, 0, 7200, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 12:49:34', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 300, 301);
INSERT INTO `exam` VALUES ('bf4a024fc0864905a8bc122361254a5d', '43ad1b7757924908a0ce6948a893feb1', '111111', '', '生物技术', '2024-06-13 23:02:00', '2024-06-19 23:01:31', 1, 1, 8639, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-13 23:01:39', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 296, 297);
INSERT INTO `exam` VALUES ('c05072e1b4af47bdb802ebcab900c446', 'dc83d0a71d4f44fc9cd1eb1359871fa0', '测试倒计时', '', '生物技术', '2024-06-12 19:21:00', '2024-06-12 19:21:18', 1, 1, 0, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-12 19:20:20', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 288, 289);
INSERT INTO `exam` VALUES ('c4ec77fd681840a98adf25aea3f239bc', '43ad1b7757924908a0ce6948a893feb1', '111', NULL, NULL, '2024-06-22 13:39:23', '2024-06-24 13:39:26', 0, 0, 2880, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 13:39:32', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 316, 317);
INSERT INTO `exam` VALUES ('c6a642b42e3e45559e4afedaa5c973c7', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 22:12:36', '2024-06-29 22:12:40', 0, 1, 10080, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 22:12:57', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 340, 341);
INSERT INTO `exam` VALUES ('d8b0b5613dd74765bab7d708bf9da67f', 'dc83d0a71d4f44fc9cd1eb1359871fa0', '测试倒计时', '', '生物技术', '2024-06-04 18:10:00', '2024-06-27 18:08:18', 1, 1, 33118, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-04 18:08:29', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 270, 271);
INSERT INTO `exam` VALUES ('d9fa0e5eee3b43f9aed0dccb31b64c33', '7c7e76bccd274f3bbe82863e38e64b57', '简答题', '', '生物技术', '2024-06-12 19:03:02', '2024-06-20 19:02:07', 1, 1, 11519, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-12 19:02:14', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 284, 285);
INSERT INTO `exam` VALUES ('de67d578ea804375ae8f92df1a8db128', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 21:54:42', '2024-06-26 21:54:45', 0, 1, 5760, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:55:03', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 332, 333);
INSERT INTO `exam` VALUES ('e395eda1a82c4132aae8f5c0bce4b8a4', 'dc83d0a71d4f44fc9cd1eb1359871fa0', '测试', '', '生物技术', '2024-06-04 17:55:00', '2024-06-04 17:56:06', 2, 1, 1, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-04 17:54:43', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 268, 269);
INSERT INTO `exam` VALUES ('e5414bf84a494b968c63dd3c71839978', '43ad1b7757924908a0ce6948a893feb1', '1', NULL, NULL, '2024-06-22 12:52:47', '2024-06-29 12:52:49', 0, 0, 10080, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 12:52:58', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 308, 309);
INSERT INTO `exam` VALUES ('e5a535542e154f0f9c99190af144e09f', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-22 21:11:10', '2024-06-25 21:11:12', 0, 1, 4320, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:11:26', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 322, 323);
INSERT INTO `exam` VALUES ('f34be4f589084d2da8c997bb4ed856b5', '43ad1b7757924908a0ce6948a893feb1', '测试自动提交', '', '生物技术', '2024-06-04 21:35:05', '2024-06-04 21:36:00', 1, 1, 0, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-04 21:34:29', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 278, 279);
INSERT INTO `exam` VALUES ('f56ff6f058394385b70c713257c67da9', '43ad1b7757924908a0ce6948a893feb1', '1', 'A01', '计算机科学与工程学院', '2024-06-22 12:51:06', '2024-06-23 12:51:10', 0, 2, 1440, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 12:51:21', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 304, 305);
INSERT INTO `exam` VALUES ('f6a5be25508e41eb807897a8651c855d', '43ad1b7757924908a0ce6948a893feb1', '1', NULL, NULL, '2024-06-22 12:52:26', '2024-06-25 12:52:29', 0, 0, 4320, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 12:52:36', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 306, 307);
INSERT INTO `exam` VALUES ('f83c18fe01d949d4912611dcff35a8d2', '724fb825e56d4f3cacb23f4ee510b53a', '1', '', '生物技术', '2024-06-27 21:09:30', '2024-06-28 21:09:34', 0, 1, 1440, '感谢您的作答！', 0, 0, 0, 1, 1, '2024-06-21 21:09:46', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 320, 321);
INSERT INTO `exam` VALUES ('ff7923156fa84c619726c47d1ac5d781', '43ad1b7757924908a0ce6948a893feb1', '1', NULL, NULL, '2024-06-26 12:50:45', '2024-06-28 12:50:48', 0, 0, 2880, '感谢您的作答！', 0, 0, 0, 1, 0, '2024-06-21 12:50:56', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 302, 303);

-- ----------------------------
-- Table structure for exam_record
-- ----------------------------
DROP TABLE IF EXISTS `exam_record`;
CREATE TABLE `exam_record`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `exam_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考试ID',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `passed` tinyint NULL DEFAULT NULL COMMENT '是否通过0:否1:是',
  `total_score` int NULL DEFAULT NULL COMMENT '得分',
  `review_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '阅卷人',
  `review_msg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '阅卷评语',
  `ex_state` tinyint NULL DEFAULT 0 COMMENT '异常状态',
  `ex_msg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '异常信息',
  `hand_state` tinyint NULL DEFAULT 0 COMMENT '处理状态0:未处理1:已处理',
  `review_time` datetime NULL DEFAULT NULL COMMENT '阅卷时间',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始答卷时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束答卷时间',
  `state` int NULL DEFAULT 0 COMMENT '作答状态0:未作答1:未完成2:已交卷',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '考试记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_record
-- ----------------------------
INSERT INTO `exam_record` VALUES ('0483f7fb1ac141a5994f70ccaed9a1e4', 'ff7923156fa84c619726c47d1ac5d781', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('04916989cdd944fe9e161db470547fbe', 'f56ff6f058394385b70c713257c67da9', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, 'ffb36d0a23964b748f91f70443a4fbx2', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('04d9dc750eac454fb5c2c1104157f617', 'aa5c08769ccc4ea2b4b8ca891df61d4f', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, '2024-06-14 18:18:25', NULL, 1);
INSERT INTO `exam_record` VALUES ('078bd4599b424d47aa040470198473c7', 'c4ec77fd681840a98adf25aea3f239bc', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('08cfa5d15ebe49bbb856a780c3028010', 'f6a5be25508e41eb807897a8651c855d', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('09472c6dee9348dfa357c0f7af806aeb', 'c4ec77fd681840a98adf25aea3f239bc', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('1005230334b0409eab3c2336da3592cd', '7daa7f5cc1a54993b5c2af2a5fd39f71', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('17a6ee645c744584af7d83fd4b25399b', 'b8e277ee245b4d0999c61e67de75b2fc', '9c88f734627243eca15c23464fef047f', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('19317dd5c418458eb8ea7bfb79c40a0d', '3a81c6eb4134469383ed8972c33286f3', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('1adfbd61017f4d5c844ade89a074b79a', 'ff7923156fa84c619726c47d1ac5d781', '9c88f734627243eca15c23464fef047f', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('1cb792ced62f429883b83141b9ba116f', '2c881b0578a745228ebad557e9c67a1a', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('1d666e479b464a67b09c9b382553977b', 'f6a5be25508e41eb807897a8651c855d', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('1f79eed1351d46ecab66e0dcf718c136', 'f6a5be25508e41eb807897a8651c855d', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('2320869433284a079bb34ad11899563b', 'e5414bf84a494b968c63dd3c71839978', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('26253935320b4943ba4eccd3ad506da2', '6ec1f64a052c41dab96d2a596dc6d5b2', '8d322e7394904df2bed4723f2c58ec92', 1, 3, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 1, '2024-06-07 15:04:37', '2024-06-07 14:47:46', '2024-06-07 15:04:37', 2);
INSERT INTO `exam_record` VALUES ('27627c3b7e01449a9ee6cf94a8e7a892', 'b8e277ee245b4d0999c61e67de75b2fc', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('280a3d47e4e246e4b71a99dcdf63dd3a', 'd9fa0e5eee3b43f9aed0dccb31b64c33', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, '2024-06-12 19:03:07', NULL, 1);
INSERT INTO `exam_record` VALUES ('2a0448082f7b411fac106328bb6fc730', '59cdbb9c2af240ac8da71fdab6b7c141', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('2b9fe7c01c114cb3be20654e799c49f8', 'ff7923156fa84c619726c47d1ac5d781', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('37e2a247992644c6ad217a2be117bab2', '152c961c153f408ca9fc237f58337904', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('388f02820790404fba352601e38612c4', 'e395eda1a82c4132aae8f5c0bce4b8a4', '90f8d5ed367a43468fbc0aa620f75830', 1, 10, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL, 1, '2024-06-04 18:01:38', '2024-06-04 17:56:11', '2024-06-04 18:01:38', 2);
INSERT INTO `exam_record` VALUES ('3a144b7401e64aacbe8af0da7ffa62aa', 'f6a5be25508e41eb807897a8651c855d', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('3d0fb8c582d84cad8b9966fe264ac45e', '3a81c6eb4134469383ed8972c33286f3', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('40a252b7a16f4b189ae2e4b59ffc08d1', 'b8e277ee245b4d0999c61e67de75b2fc', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('4b8d5c2dda83420b9c3e75c46ccc9679', 'f56ff6f058394385b70c713257c67da9', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, 'ffb36d0a23964b748f91f70443a4fb27', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('502c6e4033a045a4b948dd771a88ed17', '152c961c153f408ca9fc237f58337904', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('5173714ce7c0407d985e92d06d82cc31', 'b158f81ee61b4ea2892e40085521f15d', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('5298fb80e9744fcc9982f6e0e2e87022', '3a81c6eb4134469383ed8972c33286f3', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('52ca9a4a797a4192a3d25c5699348885', '12f1ae2182f24e8e9a759b96ace959c6', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('531da5f99ae24ed2a09237b91ccce115', '221606845b8f45ac821099e79c883e4b', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL, 0, NULL, '2024-06-04 19:02:27', NULL, 1);
INSERT INTO `exam_record` VALUES ('5381d6e64eab402e8e0d49bf69b01489', 'b8e277ee245b4d0999c61e67de75b2fc', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('56d6eecf51404cf49c66a86a49c82d6f', '074cfcac0e984a34846868762e828f8d', '8d322e7394904df2bed4723f2c58ec92', 1, 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 1, '2024-06-13 22:59:01', '2024-06-13 22:58:06', '2024-06-13 22:59:01', 2);
INSERT INTO `exam_record` VALUES ('56ef32d03edb49848bcf78c865c7fd93', 'f34be4f589084d2da8c997bb4ed856b5', '90f8d5ed367a43468fbc0aa620f75830', 1, 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL, 1, '2024-06-04 21:36:01', '2024-06-04 21:35:09', '2024-06-04 21:36:01', 2);
INSERT INTO `exam_record` VALUES ('589dfee2ddde4dfaab93d794c0a47632', '3efd8a8071714e50af31791a573a00e9', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('5a043506a9c845428d0a4d4bfb1affe2', 'e5414bf84a494b968c63dd3c71839978', '9c88f734627243eca15c23464fef047f', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('5c3386aec5e54b4eb4d8ed244c7593fb', 'c6a642b42e3e45559e4afedaa5c973c7', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('5d35b6f82282462a9c54d2af1dcaa824', 'ff7923156fa84c619726c47d1ac5d781', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('5dd1cadad0d54623bc751b11f6386758', 'b69c074cec98498aab9c9c09b8cb8c81', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('6c52beb49f404147ae3e4322ece4edb0', 'f6a5be25508e41eb807897a8651c855d', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('6c8f847f662e42a295c4bb4eebdb8e9e', '3a81c6eb4134469383ed8972c33286f3', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('6cb102f220704ec98d9753d25f04d1a0', 'e5414bf84a494b968c63dd3c71839978', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('6ec676f0d6ed4d0e907048f01cc935e2', '3a81c6eb4134469383ed8972c33286f3', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('6ed599424bb54b46a4f890ab8f3cefbc', '152c961c153f408ca9fc237f58337904', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('75e3869e6b884aec9e807e0728c33461', 'b8e277ee245b4d0999c61e67de75b2fc', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('7659707144714036b6330ac87b550e24', 'c05072e1b4af47bdb802ebcab900c446', '8d322e7394904df2bed4723f2c58ec92', 1, 15, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 1, '2024-06-12 19:21:28', '2024-06-12 19:21:06', '2024-06-12 19:21:27', 2);
INSERT INTO `exam_record` VALUES ('7d81d949d1af4792998edd34b8d3bcf7', 'c4ec77fd681840a98adf25aea3f239bc', '9c88f734627243eca15c23464fef047f', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('812c74f789404bebb9bac71a392b4d43', '152c961c153f408ca9fc237f58337904', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('835a07f97cea4ab7a4b18ec1efec80c9', '52af0d9f674845cf8bac10494f724965', '90f8d5ed367a43468fbc0aa620f75830', 0, 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL, 1, '2024-06-07 14:25:01', '2024-06-07 14:24:15', '2024-06-07 14:25:01', 2);
INSERT INTO `exam_record` VALUES ('848a8907625e4b9aa3f37998b6220e29', 'e5a535542e154f0f9c99190af144e09f', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('84e78ba7d5e04a4e8eb9c5e1cb7795c6', 'b781b99fad7c4326a9c06c0632afa143', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL, 0, NULL, '2024-06-04 20:27:16', NULL, 1);
INSERT INTO `exam_record` VALUES ('86af3db9d25948fe8fab49a36c6ba127', 'b69c074cec98498aab9c9c09b8cb8c81', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('8cad49e5da7246b4b0032ac253a923f4', 'c4ec77fd681840a98adf25aea3f239bc', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('8e9c56058a9348f7ac1343608c3dc7a9', 'c4ec77fd681840a98adf25aea3f239bc', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('90cd313b87d14c7a81d02e2ec6c36ee1', 'f6a5be25508e41eb807897a8651c855d', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('9263d641b61e44aa82ba09311a2c83e9', 'ff7923156fa84c619726c47d1ac5d781', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('936196db1ade4830874cf1c3e516704c', 'e5414bf84a494b968c63dd3c71839978', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('939b3667e26f45fbba7ee0d869ced092', 'c4ec77fd681840a98adf25aea3f239bc', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('9a82c5bddd024a1ea4b40be5cb433e62', '3a81c6eb4134469383ed8972c33286f3', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('9d3b2b48a1864077919b2638e7b939cc', 'e5414bf84a494b968c63dd3c71839978', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('9e8319dcb1344bd0a4551afae37b68db', 'b8e277ee245b4d0999c61e67de75b2fc', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('a17ff2b752154a93ab38d9503e124043', 'c4ec77fd681840a98adf25aea3f239bc', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('a5850f448e264f8fbab22ebee47d46af', '152c961c153f408ca9fc237f58337904', '9c88f734627243eca15c23464fef047f', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('a695afca1599437ba71a8082603d8535', '6d83e19fdb4842529a7a9e44c06c1fa7', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('ac21e91451a64e02bfca3faedc2036e5', 'f56ff6f058394385b70c713257c67da9', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, 'ffb36d0a23964b748f91f70443a4fbx7', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('b0a15c25d56f415fba70467d804538b3', '152c961c153f408ca9fc237f58337904', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('b3838b0ddea249b9a97eb946ae55e06e', 'e5414bf84a494b968c63dd3c71839978', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('b47721279ca4481cbd4c221fd1ba6597', 'ff7923156fa84c619726c47d1ac5d781', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('b94d5086fd464cfe93be6a6a666444f2', 'b8e277ee245b4d0999c61e67de75b2fc', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('bd0c15bbb1bc468aaad941455428f3ca', 'e5414bf84a494b968c63dd3c71839978', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('bd36a358d4fa499bb3edb1c21a0007fa', 'f83c18fe01d949d4912611dcff35a8d2', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('c2bb7d8ee0884f96a3125a97eb6e5384', 'f56ff6f058394385b70c713257c67da9', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, 'ffb36d0a23964b748f91f70443a4fbxv', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('c4da3edfd3f44fdb974edda370743d3b', '3a81c6eb4134469383ed8972c33286f3', '9c88f734627243eca15c23464fef047f', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('c5d7bae587044f31b877fe945d9be4cf', 'f56ff6f058394385b70c713257c67da9', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('c7ddc7499a9142bc80291a707fcee49c', 'ff7923156fa84c619726c47d1ac5d781', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('cb7b78cbd77944c0a15ab6074b5b0f1d', 'b7ee36f91e5f436086f9b6483a3bb5ee', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, '2024-06-12 19:18:40', NULL, 1);
INSERT INTO `exam_record` VALUES ('cc4df33f4bbe46de874d363499242422', 'd8b0b5613dd74765bab7d708bf9da67f', '90f8d5ed367a43468fbc0aa620f75830', NULL, NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL, 0, NULL, '2024-06-04 18:31:25', NULL, 1);
INSERT INTO `exam_record` VALUES ('d3f26dd44d97420693b3f1784f2b235f', 'b69c074cec98498aab9c9c09b8cb8c81', '9c88f734627243eca15c23464fef047f', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('d52207b91d01441ba70e68245d39138b', 'bf4a024fc0864905a8bc122361254a5d', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, '2024-06-13 23:02:26', NULL, 1);
INSERT INTO `exam_record` VALUES ('d88000bebf244d08af0deb9322352bd1', '510bfb55eabe4b748c2266bdd534e328', '8d322e7394904df2bed4723f2c58ec92', 0, 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 1, '2024-06-13 22:47:21', '2024-06-13 22:46:28', '2024-06-13 22:47:21', 2);
INSERT INTO `exam_record` VALUES ('df80ab627b884078b84e2f557f154a7e', '76d6d12648dd40edb5b92f52af24ed2e', '8d322e7394904df2bed4723f2c58ec92', 1, 4, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 1, '2024-06-13 22:52:51', '2024-06-13 22:52:22', '2024-06-13 22:52:51', 2);
INSERT INTO `exam_record` VALUES ('e4db4c886e1f451897eda5a667f944b9', 'de67d578ea804375ae8f92df1a8db128', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('e7e2d6cc306645f09b79b47b645c9e38', 'b69c074cec98498aab9c9c09b8cb8c81', 'ffb36d0a23964b748f91f70443a4fbxv', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('e8c14853cc454f16b7ee556dd63cb57b', '152c961c153f408ca9fc237f58337904', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('ea468a460bd447bfb1a8dcd210d2357d', 'abc4e7d86f304514b9c41110ef45f7e9', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('ee42721a05524a0aa98de180b7ca17ec', '308080102f674f119591515a72082b2c', '90f8d5ed367a43468fbc0aa620f75830', 1, 20, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL, 1, '2024-06-05 16:28:11', '2024-06-04 21:10:05', '2024-06-05 16:28:11', 2);
INSERT INTO `exam_record` VALUES ('f64056813c334e81b8ea1da36774dda4', 'b69c074cec98498aab9c9c09b8cb8c81', 'ffb36d0a23964b748f91f70443a4fbx7', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('fa94029abb9f47539e840f28c7a432b6', 'b69c074cec98498aab9c9c09b8cb8c81', 'ffb36d0a23964b748f91f70443a4fbx2', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('faf69988fde641178ba240b5bba81b64', 'f6a5be25508e41eb807897a8651c855d', '9c88f734627243eca15c23464fef047f', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('fcb5662a00bc4cc0802246fa5a72c1ab', 'b69c074cec98498aab9c9c09b8cb8c81', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `exam_record` VALUES ('fea734005a974e48905e57a00ac1c6eb', '845ae096b3914be2a95a9bc6cacbcc6c', '8d322e7394904df2bed4723f2c58ec92', NULL, NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL, 0, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for gl_qu
-- ----------------------------
DROP TABLE IF EXISTS `gl_qu`;
CREATE TABLE `gl_qu`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `qu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目ID',
  `gl_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '大题ID',
  `sort` int NOT NULL COMMENT '题目在大题中的排序',
  `score` int NOT NULL COMMENT '题目对应的分数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '大题题目关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gl_qu
-- ----------------------------
INSERT INTO `gl_qu` VALUES ('0acfe91b51fa44bb966ff4545fd0b9b0', '27fa1550e3314b2a82d2493cbc4b0373', '832d44cb5ab145fdbeff0eafff5ee084', 6, 5);
INSERT INTO `gl_qu` VALUES ('0b5d9df326b24b87a24999af6a4a3d28', '01fada5fe3aa4a44b650e5c4a257d21c', 'd847d3c56df84c138ab54c32119eb9aa', 2, 5);
INSERT INTO `gl_qu` VALUES ('0cdf2668bd88429d84544bb7996f3f4e', 'f27d7c56ca3d473087164fb47241725b', '832d44cb5ab145fdbeff0eafff5ee084', 17, 5);
INSERT INTO `gl_qu` VALUES ('1143a7e814564862bcb00169080d7f82', '3f51e325a16d46dba9ab791b6f1e1bbb', '832d44cb5ab145fdbeff0eafff5ee084', 47, 5);
INSERT INTO `gl_qu` VALUES ('12fc55510ffa44419b797b050d11b6d7', 'b36d73fdf1c4423ab38bb367ab23328f', '832d44cb5ab145fdbeff0eafff5ee084', 21, 5);
INSERT INTO `gl_qu` VALUES ('15a4ea2c0a2e44fb9124c3d993154738', 'a1922aafdafa41979769bfd61da548a8', '832d44cb5ab145fdbeff0eafff5ee084', 3, 5);
INSERT INTO `gl_qu` VALUES ('1643cb4a107b4260a1a48b0bd32e04d9', '3f74f08940214b829bc9636f644b7d61', '832d44cb5ab145fdbeff0eafff5ee084', 46, 5);
INSERT INTO `gl_qu` VALUES ('167f069e7cbd40158b5eb0ea3bd98ada', 'a2457c9c44694a859223908831941002', '832d44cb5ab145fdbeff0eafff5ee084', 45, 5);
INSERT INTO `gl_qu` VALUES ('1b52dbc186b24f84a1dffaeb4a0f6260', 'b071cb6cc49d4899ad3177bd69426952', '832d44cb5ab145fdbeff0eafff5ee084', 43, 5);
INSERT INTO `gl_qu` VALUES ('1c0831a08e07474988ce7f027ae12715', '111dd1c11bc349dcb3798cc0af0ba830', 'fc4cc8b56b09436f84ce45ed5dfb9691', 3, 3);
INSERT INTO `gl_qu` VALUES ('1c42a561b3f441888beebe6fc2f12da0', '14af07de63c0493d8ec7f4554bd86d32', '832d44cb5ab145fdbeff0eafff5ee084', 48, 5);
INSERT INTO `gl_qu` VALUES ('1cd3dc318a974e0ebe3d3f20c16fdc68', '35b071389f714265bf83c0a4f3ed5aeb', 'd898f7a3e4a942ffae20152fd72a1bb3', 2, 5);
INSERT INTO `gl_qu` VALUES ('270d15b3650343c58474a8bebbf5a97d', 'd4e72144095d479b9b25cadfd45a293f', '832d44cb5ab145fdbeff0eafff5ee084', 19, 5);
INSERT INTO `gl_qu` VALUES ('294a3086721d420585abdd7bbe5407d0', '778bb89404ee46699fdf3320d7750507', '832d44cb5ab145fdbeff0eafff5ee084', 32, 5);
INSERT INTO `gl_qu` VALUES ('2b352ffe18eb45e1a6be59c9fb5ca3cc', 'bd325a5aef7048e5871c8a60001394f3', '832d44cb5ab145fdbeff0eafff5ee084', 38, 5);
INSERT INTO `gl_qu` VALUES ('2c0409da0103458a8b178092ae148757', '63659d404f694a8fbea7e1ea29126dd4', '832d44cb5ab145fdbeff0eafff5ee084', 40, 5);
INSERT INTO `gl_qu` VALUES ('319a9c2e658047b4856691e30287788d', '6882fa950b3a44e58aad41a91eebbc76', '60003c14267a474d8fa737f02136b6da', 2, 5);
INSERT INTO `gl_qu` VALUES ('31c6308d79a241d1a43306251c664cf4', '2be24ca734cc4ad6b9bd1c59c605f9ee', '832d44cb5ab145fdbeff0eafff5ee084', 41, 5);
INSERT INTO `gl_qu` VALUES ('372f064e39ad4e54ab3c1ddde61377c3', '4ae568501509423a9406cb5dc38d3e29', '832d44cb5ab145fdbeff0eafff5ee084', 42, 5);
INSERT INTO `gl_qu` VALUES ('38a616a66aee4812837e3d85ac15ba82', 'be7eb38737a84544901f1f3b0d6413be', '832d44cb5ab145fdbeff0eafff5ee084', 10, 5);
INSERT INTO `gl_qu` VALUES ('3b02d2374fa844b59f80164ef845f5d0', '4793eebea0544f03951476504134ef3b', '832d44cb5ab145fdbeff0eafff5ee084', 34, 5);
INSERT INTO `gl_qu` VALUES ('43c43b6edfa94da7970071c6d96134bf', '93e59078f5aa4595a202a401d92d1902', '832d44cb5ab145fdbeff0eafff5ee084', 27, 5);
INSERT INTO `gl_qu` VALUES ('45c036e040a04477a660bfdf6d5c3f5e', '3c63ae9e3dae48d886997c320c863de7', '832d44cb5ab145fdbeff0eafff5ee084', 7, 5);
INSERT INTO `gl_qu` VALUES ('45faad069b84431293f67aafa81291f1', 'fbf302624fd14e75a940afa7fd07d0cb', '24d4478369854501ab6feb9d886b003b', 3, 5);
INSERT INTO `gl_qu` VALUES ('475483f2ad8d4a7abe59c608a296a60d', '6818caf6587c4cf6ba2468f91fc355b2', '832d44cb5ab145fdbeff0eafff5ee084', 26, 5);
INSERT INTO `gl_qu` VALUES ('49118599f3d94ddf9b132527f17ba69b', '16502738ea7142afa3f5a2b30fd7340a', 'fc4cc8b56b09436f84ce45ed5dfb9691', 4, 4);
INSERT INTO `gl_qu` VALUES ('4991b48efd1e48d0a5b3ddb95b26eb0c', '3e07606eca9c4043a91f01182e0f3560', '832d44cb5ab145fdbeff0eafff5ee084', 13, 5);
INSERT INTO `gl_qu` VALUES ('4f9a54200cec446ba03474261cbfaac4', '7ab30154c23243a7837c91760778bddc', '832d44cb5ab145fdbeff0eafff5ee084', 2, 5);
INSERT INTO `gl_qu` VALUES ('515596b3870f4d68a4fa50d0d23a8f11', '4eb53a50f92b4bd29ee4303b454d5fcd', '832d44cb5ab145fdbeff0eafff5ee084', 50, 5);
INSERT INTO `gl_qu` VALUES ('5f9997c7b626468ba2ab8c5f9ed83411', 'e243b3bf70a648ec8da08c93f55af26d', '60003c14267a474d8fa737f02136b6da', 1, 5);
INSERT INTO `gl_qu` VALUES ('602269cf44864ae78364f8bc65fc8eb8', '9856ef743e7848e9b94a61d8646519f8', '832d44cb5ab145fdbeff0eafff5ee084', 22, 5);
INSERT INTO `gl_qu` VALUES ('63e49aee00ab4017b5609ceec050e505', '28a78e2127da41b5937c19b49f0acdb3', '832d44cb5ab145fdbeff0eafff5ee084', 29, 5);
INSERT INTO `gl_qu` VALUES ('6473957848b24756b8c9c6c7d3bd2cd9', '699b5e55acd04b57a0584016f6804494', '832d44cb5ab145fdbeff0eafff5ee084', 24, 5);
INSERT INTO `gl_qu` VALUES ('6a204171703c46b5819458ac1c7ec982', '3c63ae9e3dae48d886997c320c863de7', '24d4478369854501ab6feb9d886b003b', 2, 5);
INSERT INTO `gl_qu` VALUES ('7005d43aa0c84572b70c3a15ce7d77ec', '551e87bf6abc4b9b80a7e27962dcb8a1', 'd847d3c56df84c138ab54c32119eb9aa', 3, 5);
INSERT INTO `gl_qu` VALUES ('7079b9f52db642ffa4970d010352725a', '20ec59fa41274d28af5cb4c1f8660d33', '832d44cb5ab145fdbeff0eafff5ee084', 15, 5);
INSERT INTO `gl_qu` VALUES ('71b660a3fbcf4325bbab777600f449e9', '865549d007ac4ec4b39ebaa154067f97', '832d44cb5ab145fdbeff0eafff5ee084', 28, 5);
INSERT INTO `gl_qu` VALUES ('75b70e39bd044ab197ae4428c78893f9', 'de86776fbcaf424791bee2445443a129', '540a67be10f146af8519aa2f58db9c71', 1, 5);
INSERT INTO `gl_qu` VALUES ('7898065da86c4b61bedb2be893cf71a4', '4837110c21df4c4aac1950993777bbb0', '832d44cb5ab145fdbeff0eafff5ee084', 36, 5);
INSERT INTO `gl_qu` VALUES ('79dba109cdb84f04b7c39b079b1f0404', '4f37cacdd8bf4a09b4be561c84eafdfd', '832d44cb5ab145fdbeff0eafff5ee084', 18, 5);
INSERT INTO `gl_qu` VALUES ('7bf19fd1979149228bf148c802af7b6e', '7c2eba01aaaa43639d9df205cd66ecb7', '832d44cb5ab145fdbeff0eafff5ee084', 37, 5);
INSERT INTO `gl_qu` VALUES ('7fadf2ee9a314faaab2a8cb7e4cceed8', 'cea0ede781d748c8bcb300bd71612430', '832d44cb5ab145fdbeff0eafff5ee084', 23, 5);
INSERT INTO `gl_qu` VALUES ('86659d079b284a329fcb3824af40b37a', 'c71aeeae981845a3bfdcfc38d34497a0', '832d44cb5ab145fdbeff0eafff5ee084', 35, 5);
INSERT INTO `gl_qu` VALUES ('89523a3da2f5415e87e995214d132ccd', '84dff59a482c44f592997829a0adf885', 'd847d3c56df84c138ab54c32119eb9aa', 1, 5);
INSERT INTO `gl_qu` VALUES ('8b6d867d28d14edf9540f5f6480f2078', '029f7977ee744d9487ee5b1ed596a64f', '832d44cb5ab145fdbeff0eafff5ee084', 16, 5);
INSERT INTO `gl_qu` VALUES ('9d9bb1941a654313a248e27243feab9e', '0e80bcc639aa472aa5e98aecd8c9a58c', '832d44cb5ab145fdbeff0eafff5ee084', 5, 5);
INSERT INTO `gl_qu` VALUES ('a467ed8957014940a51c1057567375c6', '61690c45efcc4e4d82915def333c0388', '24d4478369854501ab6feb9d886b003b', 1, 5);
INSERT INTO `gl_qu` VALUES ('a645cecda0d44c92bfc1bb60229507e6', 'd481d614f7a74465829cf380f297ee0c', '832d44cb5ab145fdbeff0eafff5ee084', 4, 5);
INSERT INTO `gl_qu` VALUES ('a897a0cc07474401bb8ed7f3a928757a', '381ce0c48bba4eafa9751bdbcdadd5d6', '540a67be10f146af8519aa2f58db9c71', 2, 5);
INSERT INTO `gl_qu` VALUES ('a8ef9b3a507247da82852a18510d7913', 'b0ace503d6524c28b1dd607a57c105e1', 'fc4cc8b56b09436f84ce45ed5dfb9691', 2, 2);
INSERT INTO `gl_qu` VALUES ('a9ec048170fa4c8287215f2100777495', '45973db3255b488d95dd892506748e55', 'd898f7a3e4a942ffae20152fd72a1bb3', 1, 5);
INSERT INTO `gl_qu` VALUES ('af31b7268c944a6c8880bed13d8f47df', 'a59bc2eea3bb4ecfa0fffd7abbd2b017', '832d44cb5ab145fdbeff0eafff5ee084', 33, 5);
INSERT INTO `gl_qu` VALUES ('b2c25c5d1b834be092c0f8027afef1b9', 'fbb82d91eb094350aa41ddbf6458e419', '832d44cb5ab145fdbeff0eafff5ee084', 14, 5);
INSERT INTO `gl_qu` VALUES ('b849fd03627e444094e3bb9d5a01cc44', 'c43edf71dcb243abb13d32df9605a655', '832d44cb5ab145fdbeff0eafff5ee084', 8, 5);
INSERT INTO `gl_qu` VALUES ('c39d20faa29b44ec81fc4991d3d03339', '5611e5efbed5499e87f3c5cdf7832cef', '832d44cb5ab145fdbeff0eafff5ee084', 11, 5);
INSERT INTO `gl_qu` VALUES ('c955c27414d2406483caef7e3d77ba53', 'dcce5274f1ac43b196809f1f0ace36a3', '832d44cb5ab145fdbeff0eafff5ee084', 9, 5);
INSERT INTO `gl_qu` VALUES ('c95752aba47d40d592399a33cb569bf1', 'b1caceff25914b3daed4ca946ab423f6', '832d44cb5ab145fdbeff0eafff5ee084', 25, 5);
INSERT INTO `gl_qu` VALUES ('cb5c5e8594514ec99944a65dff97e4b4', '2ef952053c234876bcfe67dc61b1bf45', '832d44cb5ab145fdbeff0eafff5ee084', 12, 5);
INSERT INTO `gl_qu` VALUES ('cc2f01f6ccf148c58676c793073be01e', 'dddd0101c95b44409907656c2291111b', 'fc4cc8b56b09436f84ce45ed5dfb9691', 1, 1);
INSERT INTO `gl_qu` VALUES ('d7db429dcf834b849848e892aed08004', 'f9e0726e82cb40289f96a929987296e9', '832d44cb5ab145fdbeff0eafff5ee084', 49, 5);
INSERT INTO `gl_qu` VALUES ('dc68d3eb9e6b410fa0d058a474f037b0', 'b448b53af2d7457680d117ae26310805', '832d44cb5ab145fdbeff0eafff5ee084', 39, 5);
INSERT INTO `gl_qu` VALUES ('dc9e3437437e4c45b1c124fb2f2cd2c8', '7647768497cf4a2cb2d191cdb4a6efa4', '832d44cb5ab145fdbeff0eafff5ee084', 30, 5);
INSERT INTO `gl_qu` VALUES ('e5eecafd1b16474a8135778afffc6651', 'c24f9337e21d4bf18f1fbadc71351dd5', '832d44cb5ab145fdbeff0eafff5ee084', 31, 5);
INSERT INTO `gl_qu` VALUES ('e7aeed313beb4dadb608b60b2a56c507', 'fe2a73f88fed4ee7bc393fd8ad47867e', '832d44cb5ab145fdbeff0eafff5ee084', 1, 5);
INSERT INTO `gl_qu` VALUES ('eb865ab3be2843dda4c1afadc29a4313', '1e3ea59523964a3fac5a4a30ef046a53', '832d44cb5ab145fdbeff0eafff5ee084', 44, 5);
INSERT INTO `gl_qu` VALUES ('fe02c8eda66a4a20a34d83fd7a29070f', '2315aae4c4394970b9d66b2f83497250', '832d44cb5ab145fdbeff0eafff5ee084', 20, 5);

-- ----------------------------
-- Table structure for group_list
-- ----------------------------
DROP TABLE IF EXISTS `group_list`;
CREATE TABLE `group_list`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `paper_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属试卷ID',
  `qu_type` int NOT NULL COMMENT '题型',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `total_score` int NOT NULL COMMENT '总分',
  `per_score` int NULL DEFAULT NULL COMMENT '每个小题的分数（当每个题目给定分数的时候。可以不用）',
  `item_rand` tinyint NOT NULL DEFAULT 0 COMMENT '选项是否乱序0:否1:是',
  `qu_rand` tinyint NOT NULL DEFAULT 0 COMMENT '题目是否乱序0:否1:是',
  `qu_count` int NULL DEFAULT NULL COMMENT '题目总数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '大题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_list
-- ----------------------------
INSERT INTO `group_list` VALUES ('24d4478369854501ab6feb9d886b003b', 'dbfd0642d773442b8c1b8602ecb3ca8e', 1, '单选题', 15, 5, 0, 0, 3);
INSERT INTO `group_list` VALUES ('540a67be10f146af8519aa2f58db9c71', '724fb825e56d4f3cacb23f4ee510b53a', 5, '简答题', 10, 5, 0, 0, 2);
INSERT INTO `group_list` VALUES ('60003c14267a474d8fa737f02136b6da', 'ffc4f2889a5f4718a92b0753f50ac94f', 4, '填空题', 10, 5, 0, 0, 2);
INSERT INTO `group_list` VALUES ('832d44cb5ab145fdbeff0eafff5ee084', 'dc83d0a71d4f44fc9cd1eb1359871fa0', 1, '单选题', 250, 5, 0, 0, 50);
INSERT INTO `group_list` VALUES ('d847d3c56df84c138ab54c32119eb9aa', '7c7e76bccd274f3bbe82863e38e64b57', 5, '简答题', 15, 5, 0, 0, 3);
INSERT INTO `group_list` VALUES ('d898f7a3e4a942ffae20152fd72a1bb3', '724fb825e56d4f3cacb23f4ee510b53a', 1, '单选题', 10, 5, 0, 0, 2);
INSERT INTO `group_list` VALUES ('fc4cc8b56b09436f84ce45ed5dfb9691', '43ad1b7757924908a0ce6948a893feb1', 1, '单选题', 10, NULL, 0, 0, 4);

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录用户名',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户IP',
  `login_state` tinyint NOT NULL COMMENT '登录状态',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  `oper_msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作信息',
  `login_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (20, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 22:32:10', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (21, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 22:33:19', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (22, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 22:57:37', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (23, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 22:59:00', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (24, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 22:59:32', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (25, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 22:59:52', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (26, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 23:00:01', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (27, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 23:02:08', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (28, '789', '0:0:0:0:0:0:0:1', 0, '2024-05-13 23:08:07', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (29, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-13 23:08:12', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (30, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-13 23:59:04', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (31, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-14 10:50:59', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (32, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-14 13:35:38', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (33, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-17 15:43:01', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (34, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-17 16:58:30', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (35, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-17 22:10:30', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (36, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-18 12:30:32', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (37, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-18 13:42:21', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (38, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-18 14:30:45', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (39, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-18 16:08:27', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (40, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-18 20:09:07', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (41, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-19 12:07:50', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (42, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-19 13:58:28', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (43, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-20 10:50:37', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (44, '张三', '0:0:0:0:0:0:0:1', 0, '2024-05-20 10:51:27', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (45, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-20 10:51:30', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (46, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-20 12:53:15', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (47, '王磊', '0:0:0:0:0:0:0:1', 0, '2024-05-20 13:20:50', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (48, '王磊', '0:0:0:0:0:0:0:1', 0, '2024-05-20 13:20:54', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (49, '王磊', '0:0:0:0:0:0:0:1', 0, '2024-05-20 13:21:14', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (50, '王磊', '0:0:0:0:0:0:0:1', 0, '2024-05-20 13:21:23', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (51, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-20 13:21:34', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (52, '王磊', '0:0:0:0:0:0:0:1', 0, '2024-05-20 13:22:55', '该用户被禁用', '本地IP');
INSERT INTO `login_log` VALUES (53, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-20 13:23:03', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (54, '王五', '0:0:0:0:0:0:0:1', 0, '2024-05-20 13:48:54', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (55, '王五', '0:0:0:0:0:0:0:1', 1, '2024-05-20 13:49:37', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (56, '李四', '0:0:0:0:0:0:0:1', 0, '2024-05-20 19:52:57', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (57, '王五', '0:0:0:0:0:0:0:1', 1, '2024-05-20 20:06:02', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (58, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-20 20:26:34', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (59, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-20 22:00:44', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (60, '王五', '0:0:0:0:0:0:0:1', 0, '2024-05-20 22:49:48', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (61, '王五', '0:0:0:0:0:0:0:1', 0, '2024-05-20 22:49:54', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (62, '王五', '0:0:0:0:0:0:0:1', 0, '2024-05-20 22:50:11', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (63, '王五', '0:0:0:0:0:0:0:1', 0, '2024-05-20 22:50:17', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (64, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-20 22:50:22', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (65, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-21 22:54:44', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (66, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-22 20:22:30', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (67, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-22 20:41:53', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (68, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-22 20:43:44', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (69, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-22 22:47:46', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (70, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-23 11:20:41', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (71, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-23 12:34:41', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (72, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-23 13:34:46', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (73, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-23 14:20:42', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (74, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-23 18:23:51', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (75, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-23 20:22:40', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (76, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-23 22:47:09', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (77, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-24 12:48:34', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (78, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-24 14:04:01', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (79, '李四', '0:0:0:0:0:0:0:1', 0, '2024-05-24 15:32:06', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (80, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-24 15:32:50', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (81, '李四', '0:0:0:0:0:0:0:1', 0, '2024-05-24 15:37:17', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (82, '张三', '0:0:0:0:0:0:0:1', 0, '2024-05-24 15:37:20', '密码错误', '本地IP');
INSERT INTO `login_log` VALUES (83, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-24 15:37:23', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (84, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-24 18:32:25', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (85, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-24 22:06:51', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (86, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-25 13:39:52', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (87, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-25 15:03:31', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (88, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-25 17:10:53', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (89, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-25 21:15:00', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (90, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-26 18:20:02', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (91, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-26 20:13:21', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (92, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-27 16:02:01', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (93, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-27 18:43:02', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (94, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-27 20:22:01', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (95, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-29 15:28:44', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (96, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-29 19:47:47', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (97, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-30 10:50:02', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (98, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-30 16:15:58', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (99, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-30 16:31:51', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (100, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-30 17:21:19', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (101, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-30 19:21:34', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (102, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-30 21:11:29', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (103, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-31 11:04:45', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (104, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-31 11:51:10', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (105, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-31 15:14:56', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (106, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-31 15:53:16', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (107, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-31 16:44:17', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (108, '张三', '0:0:0:0:0:0:0:1', 1, '2024-05-31 19:01:14', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (109, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-01 09:25:57', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (110, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-01 11:29:25', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (111, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-01 13:10:13', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (112, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-01 14:04:43', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (113, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-01 17:42:24', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (114, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-01 20:12:47', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (115, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-01 21:57:18', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (116, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-03 13:35:39', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (117, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-03 14:10:59', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (118, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-04 17:48:28', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (119, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-04 20:25:34', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (120, '王五', '0:0:0:0:0:0:0:1', 0, '2024-06-05 15:26:42', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (121, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-05 15:26:51', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (122, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-05 16:27:42', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (123, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-05 19:39:44', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (124, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-07 14:21:30', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (125, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-07 14:26:44', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (126, '王磊', '0:0:0:0:0:0:0:1', 0, '2024-06-07 14:31:53', '该用户被禁用', '本地IP');
INSERT INTO `login_log` VALUES (127, '韩晨曦', '0:0:0:0:0:0:0:1', 1, '2024-06-07 14:32:04', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (128, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-07 15:24:01', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (129, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-08 11:34:52', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (130, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 13:06:56', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (131, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 13:07:10', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (132, '张三', '0:0:0:0:0:0:0:1', 0, '2024-06-10 17:52:59', 'Redis exception; nested exception is io.lettuce.core.RedisException: java.io.IOException: 远程主机强迫关闭了一个现有的连接。', '本地IP');
INSERT INTO `login_log` VALUES (133, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 17:54:46', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (134, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 17:55:27', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (135, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 17:57:51', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (136, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 17:59:06', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (137, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 17:59:19', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (138, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 17:59:31', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (139, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 17:59:43', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (140, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 18:25:25', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (141, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 18:30:16', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (142, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-10 18:37:47', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (143, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-11 21:47:21', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (144, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-11 21:48:33', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (145, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-12 19:00:00', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (146, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-12 20:07:16', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (147, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-12 20:51:35', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (148, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-12 22:55:07', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (149, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-13 16:23:33', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (150, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-13 22:26:02', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (151, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-14 14:38:34', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (152, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-14 18:07:17', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (153, '张三', '0:0:0:0:0:0:0:1', 0, '2024-06-19 14:58:23', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 106.15.90.238:6388', '本地IP');
INSERT INTO `login_log` VALUES (154, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-19 15:12:42', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (155, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-19 17:52:35', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (156, '张三', '0:0:0:0:0:0:0:1', 0, '2024-06-19 17:59:52', 'cn.dev33.satoken.util.SaResult cannot be cast to com.jl.project.entity.vo.ResponseVO', '本地IP');
INSERT INTO `login_log` VALUES (157, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-21 21:02:02', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (158, '张三', '0:0:0:0:0:0:0:1', 1, '2024-06-21 21:33:02', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (159, '张三', '0:0:0:0:0:0:0:1', 0, '2024-07-06 16:37:36', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 106.15.90.238:6379', '本地IP');
INSERT INTO `login_log` VALUES (160, '张三', '0:0:0:0:0:0:0:1', 0, '2024-07-06 16:38:20', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 106.15.90.238:6379', '本地IP');
INSERT INTO `login_log` VALUES (161, '张三', '0:0:0:0:0:0:0:1', 1, '2024-07-06 16:40:10', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (162, '张三', '0:0:0:0:0:0:0:1', 1, '2024-07-06 16:43:07', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (163, '张三', '0:0:0:0:0:0:0:1', 1, '2024-07-06 16:44:27', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (164, '张三', '0:0:0:0:0:0:0:1', 1, '2024-07-07 10:33:52', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (165, '张三', '0:0:0:0:0:0:0:1', 1, '2024-07-07 10:36:51', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (166, '李四', '0:0:0:0:0:0:0:1', 0, '2024-07-07 10:42:05', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (167, 'admin', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:28:39', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (168, 'admin', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:29:06', '用户不存在', '本地IP');
INSERT INTO `login_log` VALUES (169, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:29:58', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (170, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:30:11', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (171, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:31:21', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (172, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:33:14', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (173, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:35:03', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (174, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:36:16', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 127.0.0.1:6379', '本地IP');
INSERT INTO `login_log` VALUES (175, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:41:44', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 127.0.0.1:6379', '本地IP');
INSERT INTO `login_log` VALUES (176, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:44:24', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 127.0.0.1:6379', '本地IP');
INSERT INTO `login_log` VALUES (177, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:46:28', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to 127.0.0.1:6379', '本地IP');
INSERT INTO `login_log` VALUES (178, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:49:49', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (179, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 16:50:59', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (180, '张三', '0:0:0:0:0:0:0:1', 1, '2026-03-08 17:06:16', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (181, '张三', '0:0:0:0:0:0:0:1', 1, '2026-03-08 17:06:34', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (182, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 17:21:19', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (183, '张三', '0:0:0:0:0:0:0:1', 0, '2026-03-08 17:24:51', 'Unable to connect to Redis; nested exception is io.lettuce.core.RedisConnectionException: Unable to connect to localhost:6379', '本地IP');
INSERT INTO `login_log` VALUES (184, '张三', '0:0:0:0:0:0:0:1', 1, '2026-03-08 17:27:42', '登录成功', '本地IP');
INSERT INTO `login_log` VALUES (185, '张三', '0:0:0:0:0:0:0:1', 1, '2026-03-08 17:33:26', '登录成功', '本地IP');

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `templ_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模板ID',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息内容',
  `msg_type` int NOT NULL COMMENT '消息类型 0：公告1：通知2：邮件',
  `send_count` int NULL DEFAULT NULL COMMENT '发送人数',
  `read_count` int NULL DEFAULT NULL COMMENT '已读人数',
  `send_time` datetime NOT NULL COMMENT '发送时间',
  `state` tinyint NULL DEFAULT NULL COMMENT '状态',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发送人Id',
  `create_user_text` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发送人姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES ('cacf15c62d244e888e07b5e8fe372491', '1', '考试通知', '您有一场考试：考试名称：1，考试时间：2024-06-22 22:31:30~2024-06-26 22:31:34', 1, 1, 0, '2024-06-21 22:31:44', 1, 'ffb36d0a23964b748f91f70443a4fb27', '张三');
INSERT INTO `msg` VALUES ('e1e8fe5d5d1542cca83b6205107ffce1', '1', '考试通知', '您有一场考试：考试名称：1，考试时间：2024-06-22 22:31:30~2024-06-26 22:31:34', 2, 1, 0, '2024-06-21 22:31:44', 1, 'ffb36d0a23964b748f91f70443a4fb27', '张三');

-- ----------------------------
-- Table structure for msg_user
-- ----------------------------
DROP TABLE IF EXISTS `msg_user`;
CREATE TABLE `msg_user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息ID',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `state` tinyint NULL DEFAULT NULL COMMENT '状态：-1异常 0未读 1已读',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户消息关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msg_user
-- ----------------------------
INSERT INTO `msg_user` VALUES ('122f77d7c9a84243b9f34dbdaed38100', 'e1e8fe5d5d1542cca83b6205107ffce1', '8d322e7394904df2bed4723f2c58ec92', 0);
INSERT INTO `msg_user` VALUES ('c2f259e5440546069fd19677a61d4d60', 'cacf15c62d244e888e07b5e8fe372491', '8d322e7394904df2bed4723f2c58ec92', 0);

-- ----------------------------
-- Table structure for oper_log
-- ----------------------------
DROP TABLE IF EXISTS `oper_log`;
CREATE TABLE `oper_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作人员名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请求地址',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户IP',
  `oper_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作地点',
  `success` tinyint NOT NULL COMMENT '是否成功',
  `oper_time` datetime NOT NULL COMMENT '操作时间',
  `request_mode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请求方式（get、post...）',
  `operation_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作方法（哪个方法处理的）',
  `request_arg` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '请求参数',
  `return_arg` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '返回参数',
  `oper_type` int NOT NULL COMMENT '操作类型（增删改...）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oper_log
-- ----------------------------
INSERT INTO `oper_log` VALUES (1, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-13 23:21:44', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (2, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-17 18:49:15', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (3, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 12:23:55', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (4, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 12:26:39', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (5, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 12:31:13', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (6, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 12:32:10', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (7, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:03:48', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (8, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:05:24', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (9, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:18:21', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (10, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:19:10', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (11, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:20:03', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (12, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:30:45', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (13, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:36:40', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (14, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:38:08', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (15, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:44:27', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (16, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:45:10', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (17, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:45:48', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (18, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:46:32', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (19, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:49:48', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (20, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:54:30', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (21, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 14:57:46', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (22, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 15:01:11', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (23, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 15:04:32', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (24, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 15:05:52', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (25, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 15:07:55', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (26, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 15:30:42', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (27, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 15:31:00', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (28, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-19 15:31:13', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (29, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-23 22:52:15', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (30, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-23 22:57:26', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (31, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-23 22:58:51', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (32, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-23 23:00:11', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (33, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-23 23:03:09', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (34, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-29 15:31:41', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (35, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-29 15:32:48', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (36, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-29 15:33:23', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (37, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-29 15:33:53', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (38, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-29 15:34:15', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);
INSERT INTO `oper_log` VALUES (39, '张三', 'http://localhost:8088/api/qu/add', '0:0:0:0:0:0:0:1', '本地IP', 1, '2024-05-29 15:40:11', 'POST', '/api/qu/add', '', '{\"status\":\"success\",\"code\":200,\"info\":\"请求成功\",\"data\":true}', 0);

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '试卷ID',
  `subject_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联学科ID',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '试卷标题',
  `dept_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属部门（专业）编码',
  `join_type` int NOT NULL COMMENT '组卷方式0:题库抽取1:指定选题 其余预留',
  `qu_count` int NOT NULL COMMENT '题目总数',
  `total_count` int NOT NULL COMMENT '试卷总分',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '试卷表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('43ad1b7757924908a0ce6948a893feb1', '12b22cf42af846969eda2800060d0efe', '测试', 'A01A04A01A02', 0, 4, 10, '2024-05-31 11:54:35', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `paper` VALUES ('724fb825e56d4f3cacb23f4ee510b53a', '12b22cf42af846969eda2800060d0efe', '555', 'A01A04A01', 0, 4, 20, '2024-06-14 18:16:45', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `paper` VALUES ('7c7e76bccd274f3bbe82863e38e64b57', '2c5594e15eee49db8c91175093d1dead', '简答题测试', 'A01A04A01A02', 0, 3, 15, '2024-06-12 19:01:53', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `paper` VALUES ('dbfd0642d773442b8c1b8602ecb3ca8e', '260ee46d9ca34589aa6b8bff9d8108d4', '123', 'A01A04A01A03', 0, 3, 15, '2024-06-08 12:12:33', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `paper` VALUES ('dc83d0a71d4f44fc9cd1eb1359871fa0', '12b22cf42af846969eda2800060d0efe', '测试', 'A01A04A01', 0, 50, 250, '2024-06-04 17:49:49', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `paper` VALUES ('ffc4f2889a5f4718a92b0753f50ac94f', '12b22cf42af846969eda2800060d0efe', '填空题', 'A01A04A01A02', 0, 2, 10, '2024-06-13 22:44:53', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);

-- ----------------------------
-- Table structure for qu
-- ----------------------------
DROP TABLE IF EXISTS `qu`;
CREATE TABLE `qu`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `repo_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属题库的ID',
  `repo_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联题库标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目内容',
  `image` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '题目图片',
  `level` tinyint NOT NULL COMMENT '题目难度0:简单1:困难',
  `analysis` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '题目分析',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `qu_type` int NOT NULL COMMENT '题型',
  `knowledge` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '知识点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '题目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qu
-- ----------------------------
INSERT INTO `qu` VALUES ('00144a9784b4486ea59f4c44ac888769', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '中国、日本位于亚洲的（）', NULL, 1, '中国和日本都位于东亚地区．根据题意．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('00739ffce4f34859ab29d10c6b45aa04', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列河流，最终注入印度洋的是（）', NULL, 0, '亚洲的河流众多，其中注入印度洋的河流有印度河、恒河、怒江等，注入太平洋的河流有长江、黄河、湄公河等，注入北冰洋的河流有鄂毕河、叶尼塞河、勒拿河等．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('01fada5fe3aa4a44b650e5c4a257d21c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>为什么说啄木鸟是树的医生？</p>', NULL, 0, '<p>啄木鸟把生病的老树治好了</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '通识知识');
INSERT INTO `qu` VALUES ('029f7977ee744d9487ee5b1ed596a64f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下面属于唐代诗人李白的作品的是（）', NULL, 0, '《将进酒》为李白作品，《登高》为杜甫作品，《琵琶行》、《长恨歌》为白居易作品。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('03d06173efdb49d3a151fb48528e40b8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>The two new teachers are all very tall.</p>', NULL, 0, '<p>The Chinese teacher is Mr Li. He&rsquo;s from China. He&rsquo;s tall and fat. He&rsquo;s very funny. And he is my friend Tim&rsquo;s father. Mr Zhang is the art teacher. He is a university student. He is 24. He is tall and strong.</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('04d3cc8511054f91b1d7d90b3a781a7e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '以下不属于机动车驾驶证审验内容的是什么？', NULL, 0, '机动车驾驶证审验内容：\n（一）道路交通安全违法行为、交通事故处理情况；\n（二）身体条件情况；\n（三）道路交通安全违法行为记分及记满12分后参加学习和考试情况。对交通违法行为或者交通事故未处理完毕的、身体条件不符合驾驶许可条件的、未按照规定参加学习、教育和考试的，不予通过审验。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('05ee4104eb77411fb38753b28bb96a61', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】亚洲人中分布不是很均匀，其中人中较稀疏的部分是（）', NULL, 1, '人口稠密地区都处在中低纬度、近海、平原地区，亚洲人口稀疏的地区在纬度位置较高的北亚，沙漠广布的西亚及气候干旱的中亚地区．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('060910f16c3b4247abd3f9c32bac8f4c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>中国古代四大发明。</p>', NULL, 0, '<p>四大发明是指中国古代对世界具有很大影响的四种发明。即造纸术、指南针、火药、印刷术。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('07ea3d4ab4004523be6636a3d0b82dd6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】世界上面积最大的国家是（）。', NULL, 0, '“俄罗斯是陆地面积最大的国家，位于欧洲东部和亚洲北部，横跨欧亚大陆，东濒太平洋，西接波罗的海芬兰湾，东西最长9000公里，南北最宽4000公里，领土面积约1707.54万平方公里。陆地邻国西北面有挪威、芬兰，西面有爱沙尼亚、拉脱维亚、立陶宛、波兰、白俄罗斯。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('08637c1ee71e49f482cbbbb434fd0d60', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '请罗列出唐宋八大家___________________。', NULL, 1, '唐宋八大家,又称为“唐宋散文八大家”,是唐代和宋代八位散文家的合称,分别为唐代柳宗元、韩愈和宋代欧阳修、苏洵、苏轼、苏辙、王安石、曾巩八位。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '语文知识');
INSERT INTO `qu` VALUES ('08f8b219924948fc8c4206b9c1ad590f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶人的机动车驾驶证被依法扣留、暂扣的情况下不得驾驶机动车。', NULL, 0, '《道路交通安全法实施条例》第二十八条规定 机动车驾驶人在机动车驾驶证丢失、损毁、超过有效期或者被依法扣留、暂扣期间以及记分达到12分的，不得驾驶机动车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('09047eb71bac4cbc83f006d1088c6308', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '四书五经是儒家思想的核心载体,请列出四书____________________。', NULL, 1, '所谓四书，指的是《大学》、《论语》、《孟子》、《中庸》这四部，这是儒家文化思想教育的基本教材；', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '语文知识');
INSERT INTO `qu` VALUES ('091de7090a074c84ac13663c6a0a5eb2', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】亚洲各国经济发展不平衡，下列国家中人均国民生产总值最高的是（）', NULL, 1, '本题还可以考查人口：人口超亿的国家有中国、印度、印度尼西亚、巴基斯坦、日本、孟加拉国等6个；各大洲人口排序：亚非欧南北美大洋洲；各大洲人口增长率：非南美亚大洋北美欧；著名的民族文化：亚洲三个人类文明发祥地：华夏文化(黄河——长江中下游地区)、印度河流域文化、两河流域文化(由幼法拉底河和底格里斯河冲积而成的美索不达米亚平原地区)；还有恒河文化、阿拉伯文化等。亚洲只有日本属于发达国家。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('0a3f8a446fcf4654aa3f351d816029d5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '亚洲地形的特点是( )', NULL, 0, '亚洲的地形特点是以高原山地为主，西部是平原，中部是高原、山地，东部是平原，地面起伏大，中部地势高，四周低这是地势特点，不是地形特点\n\n考点：本题考查亚洲的地形特点.', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('0b6a5a93d9e8453b80f26c122f20c81f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】南极洲的代表动物是（）', NULL, 0, '南极企鹅', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('0b91262df7424b27ac200fd2613f218f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】我国人口分布特点', NULL, 0, '人口基数大，新增人口多。人口分布的特点是:东多西少。为了使人口数量的增长同社会经济发展和资源环境条件相适应,我国把实行计划生育作为基本国策', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '中国常识');
INSERT INTO `qu` VALUES ('0bc3d45b603e43f0834bf670d32760cc', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '已经达到报废标准的机动车经大修后可以上路行驶。', NULL, 0, '《道路交通安全法》第十四条　国家实行机动车强制报废制度，根据机动车的安全技术状况和不同用途，规定不同的报废标准。应当报废的机动车必须及时办理注销登记。达到报废标准的机动车不得上道路行驶。因此，题干表述错误。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('0c275cc358cb4ce89f1b3ec29f12e7a3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '工资集体协商代表应依照法定程序产生。雇员一方由工会代表，未建立工会的企业，由雇员民主推举代表，并得到（　　）以上雇员同意。', NULL, 1, '工资集体协商代表应依据法定程序产生，雇员一方由工会代表，未建立工会的企业，由雇员民主推荐代表，并得到半数以上雇员同意。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '企业培训与制度');
INSERT INTO `qu` VALUES ('0c3d48ee7fc74f0bb201e377acb0f756', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '陕西“十四五”规划提出，“十四五”期间，要坚持（）工作总基调', NULL, 0, '党的二十大报告', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('0d3e353d2f864b92b992c5e4a69ac16d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '主要用于考察被测评者分析问题的能力、语言表达能力及影响力的题目类型是（　　）', NULL, 1, '两难式问题是指让被测评者在两种互有利弊的选项中选择其中的一种，并说明理由。主要用于考察被测评者分析问题的能力、语言表达能力及影响力。这种题目易于引起争论，使被测评者综合发挥自己的能力。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '企业培训与制度');
INSERT INTO `qu` VALUES ('0e5354d337a04a798eac226820186f31', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '进入左侧道路超车，无法保证与正常行驶前车的横向安全间距时，应怎样做？', NULL, 0, '没有超车条件，放弃超车是最安全的行为。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('0e80bcc639aa472aa5e98aecd8c9a58c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '我国最北面的城市是哪个（）', NULL, 0, '漠河市，隶属黑龙江省大兴安岭地区。 [1]  地处黑龙江省北部。西与内蒙古自治区呼伦贝尔市额尔古纳市为邻，南与内蒙古自治区根河市和呼中区交界，东与塔河县接壤，北隔黑龙江与俄罗斯外贝加尔边疆区（原赤塔州）和阿穆尔州相望，是中国最北端的县级行政区；地势南高北低，南北呈坡降趋势，属于寒温带大陆性季风气候。下辖6个镇，总面积18427平方千米。 [2]  根据第七次人口普查数据，截至2020年11月1日零时，漠河市常住人口为54036人。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('111dd1c11bc349dcb3798cc0af0ba830', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】亚洲地形的特点是( )', NULL, 1, '亚洲的地形特点是以高原山地为主，西部是平原，中部是高原、山地，东部是平原，地面起伏大，中部地势高，四周低这是地势特点，不是地形特点\n\n考点：本题考查亚洲的地形特点.', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('11843e16f1c14ee3b95c4e35dd8104a0', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在上道路行驶前驾驶人要按规定系好安全带。', NULL, 0, '《道路交通安全法》第五十一条：机动车行驶时，驾驶人、乘坐人员应当按规定使用安全带，摩托车驾驶人及乘坐人员应当按规定戴安全头盔。\n座椅安全带的作用是在汽车发生碰撞或紧急制动时，固定驾乘人员位置，减轻对驾乘人员的伤害。驾驶人、乘车人在汽车行驶前，系好安全带是最有效的自我保护方法，在遇到意外危险情况时可避免受到致命的伤害。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('118e37ac425d41b8b798e8266ffe78fa', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>100个包子，100个人吃，1个大人吃3个，3个小孩吃1个，多少个大人和多少小孩刚好能吃完？</p>', NULL, 0, '<p>25个大人，75个小孩</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('11a51e9754cd4cdf95ed8203695d6003', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶人持超过有效期的驾驶证可以在1年内驾驶机动车。', NULL, 0, '《道路交通安全法实施条例》第二十八条规定 机动车驾驶人在机动车驾驶证丢失、损毁、超过有效期或者被依法扣留、暂扣期间以及记分达到12分的，不得驾驶机动车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('1231b561c58948979e5acc96c89fd6e9', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】南北半球、东西半球的怎样划分的', NULL, 0, '南北半球的分界线是:赤道。东西半球的分界线是: 20° w和160° E组成的经线圈。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('13f63698fa974192bb559a9615f77218', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><strong>这是什么交通标志？</strong></p>', NULL, 0, '<p><strong>左侧变窄</strong>：用以警告车辆驾驶人注意前方左侧车行道或路面狭窄情况，遇有来车应予减速避让。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('143703e05d46497abe995da1019c1385', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><a data-v-b2458244=\"\">【自动批阅】解释成语：</a>面面相觑。</p>', NULL, 0, '<p>面面相觑：形容人们因惊惧或无可奈何而互相望着，都不说话。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('143e1fa162204c17aee2edbb10be07e3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'Jack and Mike like playing basketball .', NULL, 1, 'They are Jack and Mike . They are our good friends . They like watching TV ,but they don’t like playing basket-ball .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('14af07de63c0493d8ec7f4554bd86d32', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '青蛙为什么没参加？', NULL, 0, '文中写到“它在洞里睡着了！”真正的含义是指冬眠', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '通识知识');
INSERT INTO `qu` VALUES ('16502738ea7142afa3f5a2b30fd7340a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '人们把社会生产的各个部门划分为三类产业，下列属于第三产业的是（）', NULL, 1, '通常人们把生产的各部门划分为三类产业．农业是第一产业，包括种植业、林业、畜牧业、渔业等；工业和建筑业是第二产业；流通部门和服务部门是第三产业', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '经济知识');
INSERT INTO `qu` VALUES ('1701583f2a0f4c878ff1e3bc3087b7d8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '简述地球自转（从自转的宣言、方向、周期、产生的现象）', NULL, 0, '地球围绕地轴不停地旋转，叫做地球的自转，地球的自转方向是自西向东，自转一周的\n时间(周期)是一天，产生的地理现象是昼夜更替和时间的差异。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('172469df895c4f448e6b17f2a9ab7a28', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】南极洲的代表动物是（）', NULL, 0, '南极企鹅', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('17dea05017ef40798942c26878d0b219', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】人们把社会生产的各个部门划分为三类产业，下列属于第三产业的是（）', NULL, 1, '通常人们把生产的各部门划分为三类产业．农业是第一产业，包括种植业、林业、畜牧业、渔业等；工业和建筑业是第二产业；流通部门和服务部门是第三产业', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('185f19ac9bbe48c8aae417ffeb75f3fd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '亚洲各国经济发展不平衡，下列国家中人均国民生产总值最高的是（）', NULL, 1, '本题还可以考查人口：人口超亿的国家有中国、印度、印度尼西亚、巴基斯坦、日本、孟加拉国等6个；各大洲人口排序：亚非欧南北美大洋洲；各大洲人口增长率：非南美亚大洋北美欧；著名的民族文化：亚洲三个人类文明发祥地：华夏文化(黄河——长江中下游地区)、印度河流域文化、两河流域文化(由幼法拉底河和底格里斯河冲积而成的美索不达米亚平原地区)；还有恒河文化、阿拉伯文化等。亚洲只有日本属于发达国家。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('19646da51e454d3d910f07696cc1f1e5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列选项中，属于绩效面谈的类型的有（　　）', NULL, 1, '按照绩效面谈的具体过程及其特点，绩效面谈可以分为以下四种类型：单向劝导式面谈、双向倾听式面谈、解决问题式面谈、综合式绩效面谈。', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '企业培训与制度');
INSERT INTO `qu` VALUES ('1aaad51b7c054c65a72ea7b59a67d9b5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>李白是什么朝代的？</p>', NULL, 0, '<p>唐</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '语文知识');
INSERT INTO `qu` VALUES ('1aaaf21de13e4d738365974b639c7d3f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】分析亚洲气候类型复杂多样的原因有哪些？</p>', NULL, 0, '<p>①地跨热、温、寒三带，南北跨纬度广；②东西距离长，跨经度广；③地形复杂多样。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '气候知识');
INSERT INTO `qu` VALUES ('1af778d4eb0b4f9798f1e7045c581766', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在道路上掉头时提前开启左转向灯。', NULL, 0, '《道路交通安全法实施条例》第五十七条 机动车应当按照下列规定使用转向灯：\n（一）向左转弯、向左变更车道、准备超车、驶离停车地点或者掉头时，应当提前开启左转向灯。\n（二）向右转弯、向右变更车道、超车完毕驶回原车道、靠路边停车时，应当提前开启右转向灯。\n因此，本题答案应为正确。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('1c5cfda7469c428bb8cd59e1c899b497', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><img class=\"wscnph\" src=\"https://files.yfhl.net/2023/9/7/1694069792114-63ad4193.jpg\" /></p>', NULL, 0, '<p>此标线是可变导向车道线。左转右转还是直行都是可以的，关键看信号灯或者路面上的指示标志。两条白实线是固定导向线。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('1dd4167f55dd4ddc9a8a2985e3025620', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '泼水节是我国哪个少数民族的传统节日（）。', NULL, 0, '“泼水节是傣族、阿昌族、布朗族、佤族、德昂族以及泰语民族和东南亚地区的传统节日。泼水节又名“浴佛节”，傣语称为“比迈”（意思为新年），西双版纳及德宏地区的傣族又称此节日为“尚罕”和“尚键”，两名称均源于梵语，意为周转、变更和转移，指太阳已经在黄道十二宫运转一周开始向新的一年过渡。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('1e003831250d4b5084df788402b328bd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>将转向灯开关向下拉，右转向灯亮。</p>\n<p><img class=\"wscnph\" src=\"https://files.yfhl.net/2023/9/7/1694069939273-83bccb68.jpg\" /></p>', NULL, 0, '<p>上提是右转向灯亮起，下压是左转向灯。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('1e23710eea874a95ba217d32ed0c117e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '经纬网的用途是什么', NULL, 0, '确定地球表面某一点的位置', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('1e3ea59523964a3fac5a4a30ef046a53', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>我国<span style=\"background-color: #e03e2d;\">最北面</span>的城市是哪个（）</p>', NULL, 0, '<p>漠河市，隶属黑龙江省大兴安岭地区。 [1] 地处黑龙江省北部。西与内蒙古自治区呼伦贝尔市额尔古纳市为邻，南与内蒙古自治区根河市和呼中区交界，东与塔河县接壤，北隔黑龙江与俄罗斯外贝加尔边疆区（原赤塔州）和阿穆尔州相望，是中国最北端的县级行政区；地势南高北低，南北呈坡降趋势，属于寒温带大陆性季风气候。下辖6个镇，总面积18427平方千米。 [2] 根据第七次人口普查数据，截至2020年11月1日零时，漠河市常住人口为54036人。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('1e7b506a034849fc9b075fd93c1e000b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】我国少数民族分布最多的省份是（）。', NULL, 0, '云南是中国民族种类最多的省份，除汉族以外，人口在6000人以上的世居少数民族有25个。其中（按人口数多少为序），15个民族为云南特有，人口数均占全国该民族总人口的80%以上。\n\n2015年末，全省少数民族人口数达1583.3万人，占全省人口总数的33.4%，是全国少数民族人口数超过千万的3个省区之一。全省少数民族人口数超过100万的有6个；超过10万不到100万的有9个；超过1万不到10万的有8个；超过6000不到1万的2个。云南少数民族交错分布，表现为大杂居与小聚居，彝族、回族在全省大多数县均有分布。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('1e9753bae29d45e1a3df89a492d80062', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在没有道路中心线的狭窄山路怎样会车？', NULL, 0, '在狭窄的坡道会车：1，下坡车让上坡车先行。2、如果下坡车已行至中途而上坡车还未上坡时，下坡车先行。在没有道路中心线的狭窄山路会车：不靠山体一方的车辆先行。【狭窄路“靠山让行”】', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('1f2db6be46e44ffebe5c9de32d188151', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>对违法驾驶发生重大交通事故且构成犯罪的，不追究其刑事责任。</p>', NULL, 0, '<p>《道路交通安全法》第一百零一条规定：违反道路交通安全法律、法规的规定，发生重大交通事故，构成犯罪的，<strong>依法追究刑事责任</strong>，并由公安机关交通管理部门吊销机动车驾驶证。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('1f374b81b1ef4803ab42ec074bc42779', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>杜甫是哪个朝代的？</p>', NULL, 0, '<p>唐</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '语文知识');
INSERT INTO `qu` VALUES ('1f3a24835dec4f18917a466bb4b2db1a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】<p><a class=\"d-link\" data-v-b2458244=\"\">简述地球自转（从自转的定义、方向、周期、产生的现象）</a></p>', NULL, 0, '<p>地球围绕地轴不停地旋转，叫做地球的自转，地球的自转方向是自西向东，自转一周的 时间(周期)是一天，产生的地理现象是昼夜更替和时间的差异。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('20ec59fa41274d28af5cb4c1f8660d33', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '上道路行驶的机动车有哪种情形交通警察可依法扣留车辆？', NULL, 0, '《道路交通安全法》第九十五条：\n上道路行驶的机动车未悬挂机动车号牌，未放置检验合格标志、保险标志，或者未随车携带行驶证、驾驶证的，公安机关交通管理部门应当扣留机动车，通知当事人提供相应的牌证、标志或者补办相应手续，并可以依照本法第九十条的规定予以处罚。当事人提供相应的牌证、标志或者补办相应手续的，应当及时退还机动车。故意遮挡、污损或者不按规定安装机动车号牌的，依照本法第九十条的规定予以处罚。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('21a6204fc835484f929ee2db5dca44dd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '人们把社会生产的各个部门划分为三类产业，下列属于第三产业的是（）', NULL, 0, '通常人们把生产的各部门划分为三类产业．农业是第一产业，包括种植业、林业、畜牧业、渔业等；工业和建筑业是第二产业；流通部门和服务部门是第三产业', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('2315aae4c4394970b9d66b2f83497250', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>驾驶机动车在道路上违反《道路安全法》的行为，属于什么行为？</p>', NULL, 0, '<p><strong>驾驶机动车在道路上违反道路交通安全法的行为属于违法行为。</strong>根据《道路交通安全法》第二条规定：中华人民共和国境内的车辆驾驶人、行人、乘车人以及与道路交通活动有关的单位和个人，都应当遵守本法。<br />第八十八条&nbsp;对道路交通安全违法行为的处罚种类包括：警告、罚款、暂扣或者吊销机动车驾驶证、拘留。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('23af7575e20440ccac4b0e5b3b2f6bc3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '不得驾驶具有安全隐患的机动车上道路行驶。', NULL, 0, '《道路交通安全法》第二十一条：驾驶人驾驶机动车上道路行驶前，应当对机动车的安全技术性能进行认真检查；不得驾驶安全设施不全或者机件不符合技术标准等具有安全隐患的机动车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('23e854a363f648089e6483a7fb28373b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '世界上最长的运河是哪一条（）', NULL, 0, '京杭大运河始建于春秋时期，是世界上里程最长、工程最大的古代运河，也是最古老的运河之一，与长城、坎儿井并称为中国古代的三项伟大工程，并且使用至今，是中国古代劳动人民创造的一项伟大工程，是中国文化地位的象征之一。大运河南起余杭（今杭州），北到涿郡（今北京），途经今浙江、江苏、山东、河北四省及天津、北京两市，贯通海河、黄河、淮河、长江、钱塘江五大水系，主要水源为微山湖，大运河全长约1797公里。运河对中国南北地区之间的经济、文化发展与交流，特别是对沿线地区工农业经济的发展起了巨大作用。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('24159f753f9b4b54b7ffb69322b8eafe', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><a data-v-795acef0=\"\">【自动批阅】</a>解释成语&ldquo;聪明过人&rdquo;。</p>', NULL, 0, '<p>聪明过人：形容人资质颖慧，超过一般人。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('24234ed5714e429db9c4b24c897449c1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列选项中，不属于制度化管理的优点的是（　　）', NULL, 1, '与传统的以非正式权威为主的管理相比，制度化管理更具优越性。集中表现在以下三个方面：(1)个人与权力相分离；(2)是理性精神合理化的体现；(3)适合现代大型企业组织的需要。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '企业培训与制度');
INSERT INTO `qu` VALUES ('25aa098871f94d1199dd7dcb09ee30ca', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】分析聚落形成与发展的有利条件有哪些？</p>', NULL, 0, '<p>①水源充足；②士壤肥天；③自然资源丰富；④交通便利；⑤地形平坦。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('25ca9d543f804084af162838fe3c8d5a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】<p><a class=\"d-link\" data-v-b2458244=\"\">简述地球自转（从自转的定义、方向、周期、产生的现象）</a></p>', NULL, 0, '<p>地球围绕地轴不停地旋转，叫做地球的自转，地球的自转方向是自西向东，自转一周的 时间(周期)是一天，产生的地理现象是昼夜更替和时间的差异。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('27e7e29689884b93a77c582f8916e356', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】我国第一个南极考察基地“长城站”什么时候落成？', NULL, 0, '1985年2月20日。长城站建于1985年2月20日，坐落在南设得兰群岛乔治王岛。长城站所在的乔治王岛，是南设得兰群岛中最大的一个岛屿。北面邻德雷克海峡，与南美洲的合恩角相距960公里。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('27fa1550e3314b2a82d2493cbc4b0373', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】中国面积最大的省份是哪一个（）。', NULL, 0, '新疆维吾尔自治区，简称“新”，首府乌鲁木齐市，位于中国西北地区，是中国五个少数民族自治区之一。面积166.49万平方公里，是中国陆地面积最大的省级行政区，占中国国土总面积六分之一。2020年第七次全国人口普查常住人口为2585.23万人', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('2847894777fe4ad9afc22334dcc34782', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】中国、日本位于亚洲的（）', NULL, 1, '中国和日本都位于东亚地区．根据题意．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('28a78e2127da41b5937c19b49f0acdb3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '党的二十大报告指出 ，十年来，我们贯彻\n（），国家安全领导体制和法治体系 、战略体\n系、政策体系不断完善，在原则问题上寸步不\n让，以坚定的意志品质维护国家主权 、安全、\n发展利益，国家安全得到全面加强 。', NULL, 0, '党的二十大报告', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('28e1925ff8e743ddb1dff777571bbba3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】山东山西中的“山”是指（）。', NULL, 0, '早在战国时期，作为区域名称的山东，山西就已经出现在各种文献中，当时的山东指的是崤山以东的地区，包括韩，赵，魏，齐，楚，燕六个国家，故称为山东六国，而山西在当时指崤山以西的地区，包括关中到陕西一带，除了崤山以外，古人还认为山指的是华山 唐代张守杰曾说，谓华山之西也。\n由此可见，从战国到唐朝山指的是崤山或者华山，到了宋金时期，作为行政区域的山东，第一次出现在历史舞台上，金朝设置了山东西路和山东东路范围包括山东大部分区域和江苏小部分区域。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('2b008d983ae94c30ad6cd97ce173f05d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '亚洲各国经济发展不平衡，下列国家中人均国民生产总值最高的是（）', NULL, 0, '本题还可以考查人口：人口超亿的国家有中国、印度、印度尼西亚、巴基斯坦、日本、孟加拉国等6个；各大洲人口排序：亚非欧南北美大洋洲；各大洲人口增长率：非南美亚大洋北美欧；著名的民族文化：亚洲三个人类文明发祥地：华夏文化(黄河——长江中下游地区)、印度河流域文化、两河流域文化(由幼法拉底河和底格里斯河冲积而成的美索不达米亚平原地区)；还有恒河文化、阿拉伯文化等。亚洲只有日本属于发达国家。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('2be24ca734cc4ad6b9bd1c59c605f9ee', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】中国面积最大的省份是哪一个（）。', NULL, 0, '新疆维吾尔自治区，简称“新”，首府乌鲁木齐市，位于中国西北地区，是中国五个少数民族自治区之一。面积166.49万平方公里，是中国陆地面积最大的省级行政区，占中国国土总面积六分之一。2020年第七次全国人口普查常住人口为2585.23万人', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('2cdffda442df431a83897e1b661b94f5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '我国最大的瀑布“黄果树瀑布”位于哪个省（）。', NULL, 0, '黄果树瀑布，即黄果树大瀑布。古称白水河瀑布，亦名“黄葛墅”瀑布或“黄葛树”瀑布，贵州民间自古以来就流传有黄果树瀑布的神话故事，黄果树瀑布的名称就来自这个神话故事中结“黄果”的树。 [1]  位于中国贵州省安顺市镇宁布依族苗族自治县，属珠江水系西江干流南盘江支流北盘江支流打帮河的支流可布河下游白水河段水系，为黄果树瀑布群中规模最大的一级瀑布，是世界著名大瀑布之一。以水势浩大著称。瀑布高度为77.8米，其中主瀑高67米；瀑布宽101米，其中主瀑顶宽83.3米。黄果树瀑布属喀斯特地貌中的侵蚀裂典型瀑布。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('2d4aa0587840430bb63d7c8ce79af339', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】著名的亚欧间的海峡是（）', NULL, 0, '被称为“天下咽喉”的土耳其海峡（又称黑海海峡）是连接黑海与地中海的唯一通道，它包括博斯普鲁斯海峡（又叫伊斯坦布尔海峡）、马尔马拉海和达达尼尔海峡（又叫恰纳卡莱海峡）三部分，全长361千米，整个海峡呈东北－西南走向，是亚、欧两洲的分界线。古往今来皆为兵家必争之地，战略地位十分重要', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('2e98902ec7a24abea3ea67adfef58b41', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><a data-v-b2458244=\"\">【自动批阅】解释成语：</a>得意忘形。</p>', NULL, 0, '<p>得意忘形：形容高兴得失去了常态。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('2ef952053c234876bcfe67dc61b1bf45', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】世界上面积最大的国家是（）。', NULL, 0, '“俄罗斯是陆地面积最大的国家，位于欧洲东部和亚洲北部，横跨欧亚大陆，东濒太平洋，西接波罗的海芬兰湾，东西最长9000公里，南北最宽4000公里，领土面积约1707.54万平方公里。陆地邻国西北面有挪威、芬兰，西面有爱沙尼亚、拉脱维亚、立陶宛、波兰、白俄罗斯。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('3194ff0c260d4e0290fbe6c04f20636a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '拼装的机动车只要认为安全就可以上路行驶。', NULL, 0, '《道路交通安全法》第一百条规定：驾驶拼装的机动车或者已达到报废标准的机动车上道路行驶的，公安机关交通管理部门应当予以收缴，强制报废，处200元以上2000元以下罚款，并吊销机动车驾驶证。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('31d6d5f8eca34bb4a61e2e1a8c3e920e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>中国古代四大名著()()()()。</p>\n<p>此题演示效果：1.无序作答填空；2.一空支持近似答案；</p>\n<p>为演示方便提供参考答案：《水浒传》||水浒传、《三国演义》||三国演义、《西游记》||西游记、《红楼梦》||红楼梦。</p>', NULL, 0, '<p>【演示乱序+近似作答】</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('3223d6c63b784408bcdeef3e968a193f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '行车中遇到执行紧急任务的消防车、救护车、工程救险车时要及时让行。', NULL, 0, '《道路交通安全法》第五十三条，警车、消防车、救护车、工程救险车执行紧急任务时，可以使用警报器、标志灯具；在确保安全的前提下，不受行驶路线、行驶方向、行驶速度和信号灯的限制，其他车辆和行人应当让行。【特殊车辆都该让】', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('32dd1f691b6a454186e2aad2729187e3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '打开机动车车门时，不得妨碍其他车辆和行人通行。', NULL, 0, '《道路交通安全法实施条例》第七十七条：乘坐机动车应当遵守下列规定：\n(一)不得在机动车道上拦乘机动车;\n(二)在机动车道上不得从机动车左侧上下车;\n(三)开关车门不得妨碍其他车辆和行人通行;\n(四)机动车行驶中，不得干扰驾驶，不得将身体任何部分伸出车外，不得跳车;\n(五)乘坐两轮摩托车应当正向骑坐。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('333985d2d41048449ea405cd1f2c5aa1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车行经城市没有列车通过的铁路道口时允许超车。', NULL, 0, '《道路交通安全法》第四十三条：同车道行驶的机动车，后车应当与前车保持足以采取紧急制动措施的安全距离。有下列情形之一的，不得超车：\n（一）前车正在左转弯、掉头、超车的；\n（二）与对面来车有会车可能的；\n（三）前车为执行紧急任务的警车、消防车、救护车、工程救险车的；\n（四）行经铁路道口、交叉路口、窄桥、弯道、陡坡、隧道、人行横道、市区交通流量大的路段等没有超车条件的。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('33ab87bdc551457baaae58efcae0ae85', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Max helps Bill with ().</p>', NULL, 0, '<p>I help him with his English homework.</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '英语知识');
INSERT INTO `qu` VALUES ('33e069118a73442e9f32f93cfbf24c7f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】亚洲地形的特点是( )', NULL, 1, '亚洲的地形特点是以高原山地为主，西部是平原，中部是高原、山地，东部是平原，地面起伏大，中部地势高，四周低这是地势特点，不是地形特点\n\n考点：本题考查亚洲的地形特点.', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('343b7b1da8674f828c0c28569bac5706', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>案情：</p>\n<p>材料一</p>\n<p>改革和法治如鸟之两翼、车之两轮。我们要坚持走中国特色社会主义法治道路，加快构建中国特色社会主义法治体系，建设社会主义法治。全面依法治国，核心是坚持党的领导、人民当家作主、依法治国有机统一， 关键在于坚持觉领导立法、保证执法、支持司法、带头守法。要在全社会牢固树立宪法法律权威，弘扬宪法精神，任何组织和个人都必须在宪法法律范围内活动，都不得有超越宪法法律的特权。</p>\n<p>材料二</p>\n<p>全面推进依法治国这件大事能不能办好，最关键的是方向是不是正确、政治保证是不是坚强有力，具体讲就是要坚持党的领导，坚持中国特色社会主义制度，贯彻中国特色社会主义法治理论。&rdquo;</p>\n<p>&mdash;摘自《关于&lt;中共中央关于全面推进依法治国若干重大问题的决定&gt;的说明》</p>\n<p>根据材料，结合自己的实际工作和学习，谈谈坚定不移走中国特色社会主义法治道路的核心要义。</p>\n<p>答题要求：</p>\n<ol>\n<li>无观点或论述、照搬材料原文的不得分</li>\n<li>观点正确，表达完整、准确</li>\n<li>总字数不少于600字</li>\n</ol>', NULL, 1, '<p>依法治国是坚持和发展中国特色社会主义的本质要求和重要保障，是实现治理体系和治理能力现代化的必然要求，事关我党执政兴国，事关人民幸福安康，事关党和长治久安。全面建成小康社会、实现中华民族伟大复兴的中国梦，全面深化改革、完善和发展中国特色社会主义制度，提高党的执政能力和执政水平，必须全面推进依法治国。在推进依法治国伟大战略的过程中，坚持党的领导，坚持中国特色社会主义制度，贯彻中国特色社会主义法治理论构成中国特色社会主义法治道</p>\n<p>路的核心要义。</p>\n<p>党的领导是中国特色社会主义最本质的特征，是社会主义法治最根本的保证。把党的领导贯彻到依法治国全过程和各方面，是我国社会主义法治建设的一条基本经验。我国宪法确立了中国共产党的领导地位。坚持党的领导是社会主义法治的根本要求，是觉和的根本所在、命脉所在，是全国各族人民的利益所系、幸福所系，是全面推进依法治国的题中应有之</p>\n<p>义。</p>\n<p>中国特色社会主义制度是中国特色社会主义法治体系的根本制度基础，是全面推进依法治国的根本制度保障。中国特色社会主义制度是党领导人民奋斗、创造、积累的根本成就之一，集中体现了中国特色社会主义的特点和优势。全面依法治国战略的推进如果脱离了中国特色社会主义制度这一根本依托，必将成为无源之水、无根之木。在法治的建设过程中，始终坚持从中国的基本国情出发，汲取中华法律文化精华，借鉴但绝不照搬国外法治理念和经验，是依法治国伟大战略顺利达成的必然要求。</p>\n<p>中国特色社会主义法治理论是建设社会主义法治的根本指引。社会主义法治理论是将马克思主义普遍真理同中国实际不断结合的理论结晶，是马克思主义法治思想中国化的最新理论成果，是对我党带领全国人民探索法治道路经验的科学总结。</p>\n<p>伟大的实践离不开伟大的理论，全面深入贯彻中国特色社会主义法治理论，是保障中国特色社会主义法治建设科学性、系统性的精神内核与不二要求。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '政治知识');
INSERT INTO `qu` VALUES ('35b071389f714265bf83c0a4f3ed5aeb', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '世界上跨东西、南北距离最长的大洲是（）', NULL, 0, '在全球的七大洲中，亚洲是世界上面积最大的一洲，也是南北跨纬度最多，热量差异大； 东西跨经度仅次于南极洲，东西距离最长的大洲；大洋洲是世界上最小的一洲\n考点：本题主要考查大洲和大洋。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('3609196dc18d47008bb6fd788dcf89e6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>人力资本的投资者和受益者之间发生的收入和支出不对称现象，被称为人力资本投资的</p>', NULL, 1, '<p>从投资收益角度来看，人力资本投资者往往并不是投资的唯一受益者，其中总有一部分收益会溢出投资主体受益范围。这种投资者和受益者之问发生的收入和支出不对称现象，被称为人力资本投资的外在性。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '经济知识');
INSERT INTO `qu` VALUES ('366473d42dc14d7eb39f4216320795de', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>下面属于唐代诗人李白的作品的是（）</p>', NULL, 0, '<p>《将进酒》为李白作品，《登高》为杜甫作品，《琵琶行》、《长恨歌》为白居易作品。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('37b914b599f94aa7af806d120e87d3de', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '距离桥梁、陡坡、隧道50米以内的路段不能停车。', NULL, 0, '《道路交通安全法实施条例》第六十三条 机动车在道路上临时停车，应当遵守下列规定：交叉路口、铁路道口、急弯路、宽度不足４米的窄路、桥梁、陡坡、隧道以及距离上述地点50米以内的路段，不得停车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('381ce0c48bba4eafa9751bdbcdadd5d6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】世界气温分布规律（纬度、海陆、地形三大因素阐述）', NULL, 0, '(1)低纬度气温高，高纬度气温低(纬度因素)\n(2) 同纬度地带，夏季陆地气温高，海洋气温低;冬季相反。(海陆因素)\n(3)在山地，气温随着海拔升高而降低。(地形因素)', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('3893b95c9e1245159f8a0f67ae516c4e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '（）是我国早的伟大诗人，他创造了“楚辞”这一新诗体，开创了我国诗歌浪漫主义的风格。', NULL, 1, '屈原是我国早的伟大诗人，他创造了“楚辞”这一新诗体，开创了我国诗歌浪漫主义的风格。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('391d4f9f7b4a4996b3004616ce29b7c7', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】我国面积最大的湖泊是（）。', NULL, 0, '青海湖是我国最大的湖泊，它是一个咸水湖，面积约4450平方公里，说起来也不小了，但是如果把它放到全世界范围来看的话，青海湖实际上并非大型湖泊，单就面积而言，在全世界排名第34位，和我国国土面积世界第三的位置很不相称，世界最大湖泊里海的面积（38万平方公里），就相当于84个青海湖。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('39fec220ee844daf8bbda27c2695d5f0', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>世界三大短篇小说巨匠指（）、（）和（）三位作家。</p>\n<p>演示无序作答，为演示方便提供答案：&ldquo;三大短篇小说巨匠（Three great short story Masters），<em>是莫泊桑、契诃夫、欧&middot;亨利</em></p>', NULL, 0, '<p>&ldquo;三大短篇小说巨匠（Three great short story Masters），<em>是指法国的莫泊桑、 俄国的契诃夫、美国的欧&middot;亨利</em></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('3b63d566176c42edafe541f9c056f952', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在铁路道口、桥梁、陡坡、隧道或者容易发生危险的路段不能掉头', NULL, 0, '《道路交通安全法实施条例》第四十九条第一款：机动车在有禁止掉头或者禁止左转弯标志、标线的地点以及在铁路道口、人行横道、桥梁、急弯、陡坡、隧道或者容易发生危险的路段，不得掉头。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('3c63ae9e3dae48d886997c320c863de7', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>驾驶机动车应当依法取得哪种证件？</p>', NULL, 0, '<p>《机动车驾驶证申领和使用规定》第十条，驾驶机动车，应当依法取得<strong>机动车驾驶证</strong>。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('3c741508e1a841298b61b4cbac9462d1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>上路行驶的机动车未随车携带身份证的，交通警察可依法扣留机动车。</p>', NULL, 0, '<p>《道路交通安全法》第九十五条规定：上道路行驶的机动车未悬挂机动车号牌，未放置检验合格标志、保险标志，或者<strong>未随车携带行驶证、驾驶证</strong>的，公安机关交通管理部门应当扣留机动车。<br />不携带身份证的话，是不会被扣留车辆的。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('3d002bc9bc344878a9a6c79a351cc8f9', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】亚洲地形的特点是( )', NULL, 1, '亚洲的地形特点是以高原山地为主，西部是平原，中部是高原、山地，东部是平原，地面起伏大，中部地势高，四周低这是地势特点，不是地形特点\n\n考点：本题考查亚洲的地形特点.', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('3e07606eca9c4043a91f01182e0f3560', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '习近平总书记2015年来陕调研时对陕西提出', NULL, 0, '党的二十大报告', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('3e5fb1ac53c44d85a7ff16a3b7be7163', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>驾驶人要按照驾驶证载明的准驾车型驾驶车辆。</p>', NULL, 0, '<p>《道路交通安全法》第十九条　驾驶机动车，应当依法取得机动车驾驶证。驾驶人应当<strong>按照驾驶证载明的准驾车型驾驶机动车</strong>；驾驶机动车时，应当随身携带机动车驾驶证。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('3e703277dea94e4982e6dfae921863ca', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '行车中遇到正在进行作业的道路养护车辆、工程作业车时要注意避让。', NULL, 0, '《道路交通安全法》第五十四条：道路养护车辆、工程作业车进行作业时，在不影响过往车辆通行的前提下，其行驶路线和方向不受交通标志、标线限制，过往车辆和人员应当注意避让。【特殊车辆都该让】', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('3e76fccc6932497a97f1a8a1b937d9bd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '在路口遇有交通信号灯和交通警察指挥不一致时，按照交通信号灯通行。', NULL, 0, '《道路交通安全法》第三十八条：车辆、行人应当按照交通信号通行；遇有交通警察现场指挥时，应当按照交通警察的指挥通行；在没有交通信号的道路上，应当在确保安全、畅通的原则下通行。因此，题干表述错误。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('3eeaad1a17de49f49adefc63ea7c2968', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Jane&rsquo;s favourite food is tomatoes.</p>', NULL, 0, '<p>Jane doesn&rsquo;t like potatoes. What would she like for lunch? She would like some beef noodles What&rsquo;s her favourite food? She likes tomatoes. She says, &ldquo;Tomatoes are healthy.&rdquo;&nbsp;</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('3f51e325a16d46dba9ab791b6f1e1bbb', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '在山区冰雪道路上行车，应当采取在_____上安装防滑链等安全防范措施。', NULL, 0, '防滑链要装在驱动轮上，以增加驱动轮的抓地力，防止车辆打滑，根据不同的前后驱动模式进行安装。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('3f74f08940214b829bc9636f644b7d61', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】我国面积最大的湖泊是（）。', NULL, 0, '青海湖是我国最大的湖泊，它是一个咸水湖，面积约4450平方公里，说起来也不小了，但是如果把它放到全世界范围来看的话，青海湖实际上并非大型湖泊，单就面积而言，在全世界排名第34位，和我国国土面积世界第三的位置很不相称，世界最大湖泊里海的面积（38万平方公里），就相当于84个青海湖。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('3fcc901fa2c24167ac1027705299579f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '亚洲地形的特点是( )', NULL, 1, '亚洲的地形特点是以高原山地为主，西部是平原，中部是高原、山地，东部是平原，地面起伏大，中部地势高，四周低这是地势特点，不是地形特点\n\n考点：本题考查亚洲的地形特点.', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('3fce6bf288de44f7bed860444b424a0f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '山东山西中的“山”是指（）。', NULL, 0, '早在战国时期，作为区域名称的山东，山西就已经出现在各种文献中，当时的山东指的是崤山以东的地区，包括韩，赵，魏，齐，楚，燕六个国家，故称为山东六国，而山西在当时指崤山以西的地区，包括关中到陕西一带，除了崤山以外，古人还认为山指的是华山 唐代张守杰曾说，谓华山之西也。\n由此可见，从战国到唐朝山指的是崤山或者华山，到了宋金时期，作为行政区域的山东，第一次出现在历史舞台上，金朝设置了山东西路和山东东路范围包括山东大部分区域和江苏小部分区域。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('40b4c6f1922c44f8899916b1558ee0ab', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车上道路行驶，不允许超过限速标志标明的最高时速。', NULL, 0, '《道路交通安全法》第四十二条：机动车上道路行驶，不得超过限速标志标明的最高时速。在没有限速标志的路段，应当保持安全车速。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('40e11970f558432692e1512b3560777a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '亚洲人中分布不是很均匀，其中人中较稀疏的部分是（）', NULL, 1, '人口稠密地区都处在中低纬度、近海、平原地区，亚洲人口稀疏的地区在纬度位置较高的北亚，沙漠广布的西亚及气候干旱的中亚地区．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('4288abcc8744434ca876310672beb5c4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><a data-v-b2458244=\"\">【自动批阅】</a><a data-v-b2458244=\"\">解释</a><a data-v-b2458244=\"\">成语：神机妙算。</a></p>', NULL, 0, '<p>神机妙算：形容善于估计复杂的变化的情势,决定策略。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('42ab48c0fad041dface8a9f818f0635d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Max and Bill live().</p>', NULL, 0, '<p>My best friend is Bill. He lives near me.&nbsp;</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '英语知识');
INSERT INTO `qu` VALUES ('43fab8135e6f42f3b39eb69cda2ced24', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>诗仙是指（）</p>', NULL, 0, '<p>&ldquo;诗仙是指李白，他的诗富于自我表现的主观抒情色彩十分浓烈，感情的表达具有一种排山倒海、一泻千里的气势。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('45973db3255b488d95dd892506748e55', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】下列河流哪一条是世界最长（）。', NULL, 0, '尼罗河最长，其次是亚马逊河，然后长江', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('45b256005ba14af6ba1d5c98c3de9d43', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '距离宽度不足4米的窄路50米以内的路段不能停车。', NULL, 0, '《道路安全法实施条例》第六十三条，机动车在道路上临时停车应当遵守下列规定：\n（2）交叉路口、铁路道口、急转弯、宽度不足4米的窄路、桥梁、陡坡、隧道以及距离上述地点50米以内的路段，不得停车；【口5】\n（3）公共汽车站、急救站、加油站、消防栓或者消防队（站）门前以及距离上述地点30米以内的路段，除使用上述设施的以外，不得停车；【站3】', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('4661ff6da9cc4d299cb32f054b2273e3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Max and Bill live().</p>', NULL, 0, '<p>My best friend is Bill. He lives near me.&nbsp;</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '英语知识');
INSERT INTO `qu` VALUES ('46c13edbaf394c6d8de5166453fb8585', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在道路上超车完毕驶回原车道时需提前开启右转向灯。', NULL, 0, '题干表述正确。根据《道路交通安全法实施条例》第四十七条：机动车超车时，应当：（一）提前开启左转向灯、变换使用远、近光灯或者鸣喇叭；（二）在确认有充足的安全距离后，从前车的左侧超越，在与被超车辆拉开必要的安全距离后，开启右转向灯，驶回原车道。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('46c48012bd254a4ebaf40dc547d94595', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列哪种证件是驾驶机动车上路行驶应当随车携带？', NULL, 0, '上道路行驶的机动车应当随车携带：两证、两标、一号牌。根据《道路交通安全法》第十一条：驾驶机动车上道路行驶，应当悬挂机动车号牌，放置检验合格标志、保险标志，并随车携带机动车行驶证。\n', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('479227f002ce41c4b011654215526397', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>小强数学只差6分就及格，小明数学也只差6分就及格了，但小明和小强的分数不一样，为什么？</p>', NULL, 0, '<p>一个是54分，一个是0分</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('4793eebea0544f03951476504134ef3b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '夜间驾驶机动车在窄路、窄桥会车怎样使用灯光？', NULL, 0, '《道路交通安全法实施条例》第四十八条： 在没有中心隔离设施或者没有中心线的道路上，夜间会车应当在距相对方向来车150米以外改用近光灯，在窄路、窄桥与非机动车会车时应当使用近光灯。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('4805119f6b764609b058f590136bc272', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】分析亚洲季风气候显著的原因是什么？</p>', NULL, 0, '<p>地处世界最大的大陆一亚欧大陆和世界最大的大洋一太平洋的交界处，海陆热力性质差异显著。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '气候知识');
INSERT INTO `qu` VALUES ('4837110c21df4c4aac1950993777bbb0', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Most of Max\'s fridends are ().</p>', NULL, 0, '<p>I am twelve years old. I have many friends. Most of them are as old as I.&nbsp;</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '英语知识');
INSERT INTO `qu` VALUES ('48edfaf725b64aac97ae805b796ee1ab', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车行驶中，车上少年儿童可不使用安全带。', NULL, 0, '《道路交通安全法》第五十一条：机动车行驶时，驾驶人、乘坐人员应当按规定使用安全带，摩托车驾驶人及乘坐人员应当按规定戴安全头盔。座椅安全带的作用是在汽车发生碰撞或紧急制动时，固定驾乘人员位置，减轻对驾乘人员的伤害。驾驶人、乘车人在汽车行驶前，系好安全带是最有效的自我保护方法，在遇到意外危险情况时可避免受到致命的伤害。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('4978cd0baa7a484bb966a7ae8d6bbcc4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】山东山西中的“山”是指（）。', NULL, 0, '早在战国时期，作为区域名称的山东，山西就已经出现在各种文献中，当时的山东指的是崤山以东的地区，包括韩，赵，魏，齐，楚，燕六个国家，故称为山东六国，而山西在当时指崤山以西的地区，包括关中到陕西一带，除了崤山以外，古人还认为山指的是华山 唐代张守杰曾说，谓华山之西也。\n由此可见，从战国到唐朝山指的是崤山或者华山，到了宋金时期，作为行政区域的山东，第一次出现在历史舞台上，金朝设置了山东西路和山东东路范围包括山东大部分区域和江苏小部分区域。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('49ebb77b0fcd4ba39843aa6266506024', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>汉赋四大家:（）、扬雄、（）、张衡。</p>\n<p>演示无序作答，为演示方便提供答案：<span style=\"background-color: #e03e2d;\">马相如、班固</span>，无填空顺序要求。</p>', NULL, 0, '<p>马相如、扬雄、班固、张衡</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('4a2313e291c24519ad1f0cfc40b74bc6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>机动车驾驶人在实习期内驾驶机动车不得牵引挂车。</p>', NULL, 0, '<p>《机动车驾驶证申领和使用规定》第七十七条，<strong>机动车驾驶人在实习期内</strong>不得驾驶公共汽车、营运客车或者执行任务的警车、消防车、救护车、工程救险车以及载有爆炸物品、易燃易爆化学物品、剧毒或者放射性等危险物品的机动车；驾驶的机动车<strong>不得牵引挂车</strong>。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('4ae568501509423a9406cb5dc38d3e29', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】我国第一个南极考察基地“长城站”什么时候落成？', NULL, 0, '1985年2月20日。长城站建于1985年2月20日，坐落在南设得兰群岛乔治王岛。长城站所在的乔治王岛，是南设得兰群岛中最大的一个岛屿。北面邻德雷克海峡，与南美洲的合恩角相距960公里。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('4b7e5702dd124ee787268b8337cae059', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '南北半球、东西半球的怎样划分的', NULL, 0, '南北半球的分界线是:赤道。东西半球的分界线是: 20° w和160° E组成的经线圈。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('4b958cb5ce26442db434a23d56fb6d3a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '公安机关交通管理部门对累积记分达到规定分值的驾驶人怎样处理？', NULL, 0, '《道路交通安全违法行为记分管理办法》第十七条，机动车驾驶人在一个记分周期内累积记分满12分的，公安机关交通管理部门应当扣留其机动车驾驶证，开具强制措施凭证，并送达满分教育通知书，通知机动车驾驶人参加满分学习、考试。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('4c62642f99624ea5b705282196f62ac0', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><strong>根据条件完善表内焊接工艺参数</strong></p>\n<p><strong>工件要求：</strong></p>\n<p><strong>材质：Q345R，工件尺寸：300mm&times;150mm&times;12mm</strong></p>\n<p><strong>坡口尺寸：坡口角度60&deg;；钝边：1mm；根部间隙：2-3mm</strong></p>\n<p><strong>焊接要求：</strong></p>\n<p><strong>焊接位置：平焊；焊接方法：手工钨极氩弧焊打底焊，焊条电弧焊盖面和填充，单面焊双面成型。喷嘴直径：10mm</strong></p>', NULL, 0, '<p><span style=\"color: #2dc26b;\">根据条件完善表内焊接工艺参数</span></p>\n<p><span style=\"color: #2dc26b;\">工件要求：</span></p>\n<p><span style=\"color: #2dc26b;\">材质：Q345R，工件尺寸：300mm&times;150mm&times;12mm</span></p>\n<p><span style=\"color: #2dc26b;\">坡口尺寸：坡口角度60&deg;；钝边：1mm；根部间隙：2-3mm</span></p>\n<p><span style=\"color: #2dc26b;\">焊接要求：</span></p>\n<p><span style=\"color: #2dc26b;\">焊接位置：平焊；焊接方法：手工钨极氩弧焊打底焊，焊条电弧焊盖面和填充，单面焊双面成型。喷嘴直径：10mm</span></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '机械知识');
INSERT INTO `qu` VALUES ('4e04138e31ad4946b83110d91be99cdf', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列属于四大美女的是（）', NULL, 1, '四大美女：西施、杨玉环、王昭君、貂蝉。', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '语文知识');
INSERT INTO `qu` VALUES ('4eb53a50f92b4bd29ee4303b454d5fcd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在夜间超车时怎样使用灯光？', NULL, 0, '《道路交通安全法实施条例》第四十七条规定：机动车超车时，应当提前开启左转向灯、变换使用远、近光灯或者鸣喇叭。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('4f37cacdd8bf4a09b4be561c84eafdfd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '超过机动车驾驶证有效期一年以上未换证被注销，但未超过2年的，机动车驾驶人应当如何恢复驾驶资格？', NULL, 0, '《机动车驾驶证申领和使用规定》第七十七条机动车驾驶人具有下列情形之一的，车辆管理所应当注销其机动车驾驶证：（七）超过机动车驾驶证有效期一年以上未换证的；\n有第一款第七项情形被注销机动车驾驶证未超过二年的，机动车驾驶人参加道路交通安全法律、法规和相关知识考试合格后，可以恢复驾驶资格。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('50c7a43ffb1b4113a7046227f2fc879f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列国家人口超过1亿的南亚国家是（）', NULL, 0, '世界人口超过一亿的国家，从多到少依次为：中国、印度、美国、印度尼西亚、巴西、巴基斯坦、俄罗斯、孟加拉国、尼日利亚、日本和墨西哥共有11个．其中属于南亚的是印度、巴基斯坦和孟加拉国．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('514f9d7e2ef14f0591f1e8b95da532d1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】人们把社会生产的各个部门划分为三类产业，下列属于第三产业的是（）', NULL, 1, '通常人们把生产的各部门划分为三类产业．农业是第一产业，包括种植业、林业、畜牧业、渔业等；工业和建筑业是第二产业；流通部门和服务部门是第三产业', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('520d2cd433504796bdf48eb9424340ab', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】西亚波斯湾沿岸比较富裕，其原因是（）', NULL, 1, '西亚波斯湾沿岸国家比较富裕，是因为大量出口石油资源．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('5215ebb7d33240a5b006786a0238e906', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>西汉文章两司马指的是()（）。</p>\n<p>此题演示无序作答，为演示方便提供参考答案：司马迁、司马相如</p>', NULL, 0, '<p>文章西汉两司马分别是指：司马迁、司马相如。前者是伟大的史学家、文学家，写成了中国第一部纪传体通史《史记》，是中华二十五史之首，被称誉为&ldquo;史家之绝唱，无韵之离骚&rdquo;。后者是著名的西汉辞赋家，后人称其为&ldquo;赋圣&rdquo;和&ldquo;辞宗&rdquo;，著有《子虚赋》、《上林赋》、《大人赋》、《长门赋》、《美人赋》等。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('52293ba9bcd94205875179284d9aeaf6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>简述地球自转（从自转的定义、方向、周期、产生的现象）</p>', NULL, 0, '<p>地球围绕地轴不停地旋转，叫做地球的自转，地球的自转方向是自西向东，自转一周的 时间(周期)是一天，产生的地理现象是昼夜更替和时间的差异。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('5256ba7804bc4174a184e09a9999b687', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车在道路上发生故障难以移动时要在车后50米以内设置警告标志。', NULL, 0, '机动车在道路上发生故障或者发生交通事故，妨碍交通又难以移动的，应当按照规定开启危险报警闪光灯并在车后50米至100米处设置警告标志，夜间还应当同时开启示廓灯和后位灯。因此，50米以内做法错误。\n【 扩展提示】：高速公路上要在车后150米外设置警告标志。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('52fd02ac7123407bbee13bd861d1fb6d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '例题 2：请以以下技术鉴定书为基础，以“国网陕西电力研\n发变压器状态诊断与检修决策系统”为题，写一篇国家电网每日\n要情重要信息，要求用凝练、简洁的语言说清系统原理、展现成\n果亮点、呈现技术先进性、体现技术应用情况。如涉及相关系统\n应用时间、应用情况等数据可用“*”代替。字数不超过 250 字。 材料：技术鉴定书\n简 要 技 术 说 明 及 主 要 技 术 性 能 指 标\n一、项目来源\n（1）国家重点研发计划子课题（2017YFB0902704）：《运行条件下油纸绝缘性能动态演化规律与故障\n仿真》\n（2）国家自然科学基金（52077015）：《多元混合绝缘油“结构-组分-性能”构效分析及油纸体系协同\n增效机制研究》\n（3）国网陕西省电力公司科技项目（5226KY18002M）：《基于介电响应的变压器套管绝缘状态不停电\n— 29 —\n检测技术研究》\n（4）国网陕西省电力公司科技项目（5226KY200013）：《基于数字孪生的大型变压器套管状态监测与\n智能诊断评估技术》\n（5）国网陕西省电力公司科技项目（5226KY160018）：《330kV及以上变压器运行性能智能评估系统\n及风险控制关键技术研究》\n（6）国网陕西省电力公司科技项目（5226KY16000S）：《基于振动传递函数的变压器绕组机械状态检\n测方法研究》\n二、项目主要应用领域及其技术特点\n变压器是电网关键输变电设备之一。油浸变压器内部绝缘为油纸组合绝缘，其绝缘缺陷一方面可能在\n制造与运输过程中产生，另一方面可能由于电力系统过电压、雷电冲击大电流、过负荷以及长时间运行过\n程中的绝缘失效老化等因素造成。电力变压器状态检测与潜伏性故障诊断对保障电力变压器良好的运行状\n态，支撑变压器安全经济运行具有重要的科学意义和应用价值。因此，通过电力变压器状态智能感知与动\n态评价诊断，可以有效鉴别变压器内部绝缘缺陷及缺陷发展程度，有效判断变压器绝缘状态，实现变压器\n内部故障的预警预报，提高变压器安全运行水平。本项目开展油浸变压器状态智能感知与动态评价诊断新\n技术及应用研究，具有如下技术特点：\n（1）提出了纳秒级脉冲前沿耦合注入式绕组变形在线监测技术、套管油气和电气参量集成智能监测\n技术，自主研发了变压器超声-温度-振动三合一传感器阵列装置、变压器微水-氢气-油温三合一传感装置，\n构建了油浸式变压器多状态智能传感体系，实现了变压器多状态参量融合的实时感知。\n（2）提出了集成重心校正谐波分析、向量差分干扰抑制和分层式局放噪声处理的软硬件多维去噪技\n术，实现了多种干扰共存下介损和局放信号的准确测量。\n（3）提出了纳秒脉冲频率响应和子空间独立分量分离技术、套管介电响应在线检测技术、三维数字\n孪生和重构反演技术融合的变压器故障诊断方法。\n（4）提出了融合定期评价、在线监测、带电检测、缺陷库数据的变压器健康状态多参量综合实时动\n态评价体系，建立了典型缺陷诊断模型和健康指数综合评估模型，开发了变压器动态评价诊断与检修决策\n系统，提升了变压器动态评价诊断和故障预警水平。\n三、项目的主要技术指标\n（1）合同要求的主要性能指标\n① 研制绕组变形在线监测装置；研制高压套管在线智能监测技术；研究变压器超声-温度-振动三合一\n传感器阵列技术；研制变压器微水-氢气-油温三合一传感器。\n② 针对现场电磁干扰、系统谐波、电网频率波动、环境温湿度等众多影响因素，研究介损、电容值、\n局放量等状态参量的抗干扰技术。\n③ 研究绕组、铁芯、套管故障诊断技术；基于变压器状态感知信号，研究三维数字孪生和重构反演\n技术的变压器故障诊断方法。\n④ 基于变压器多状态智能感知信号，构建变压器健康状态评价体系，建立变压器全寿命周期评估模\n型。\n（2）实际达到的性能指标\n① 发明了用于监测变压器绕组变形的脉冲耦合注入式在线监测装置，电容耦合传感器（CCS）和信\n号注入电路实现了高压纳秒激励在线安全注入，智能监测系统解决了变压器绕组变形动态实时监测的难\n— 30 —\n题，高幅值纳秒脉冲提高了变压器绕组变形监测信噪比和灵敏度。发明了变压器套管油气、电气多参量集\n成智能在线监测装置，具有油中溶解氢气、油温、油压、相对介损、相对电容、绝对介损、绝对电容、局\n放、微水等 9 大状态参量实时监测功能，监测数据通过 5G 无线传输至智能监测后台，突破了套管早期潜\n伏性故障精准诊断的技术难题。研制了变压器超声-温度-振动三合一传感器阵列，获得了传感器布阵方法\n和多信息参量矩阵特性，解决了现有监测参量相互独立且无法实现监测信号时空尺度对齐和融合关联分析\n的难题。研制了变压器微水-氢气-油温三合一传感器，实现了变压器油物理化学参量的精准测量。基于上\n述智能传感装置构建了油浸式变压器多状态智能传感体系，为变压器状态精准检测和故障预警提供了先进\n手段。\n② 提出了抑制谐波干扰的重心校正谐波分析技术，对窗谱函数主瓣相邻两点按重心法求出感知信号\n的校正频率（即重心），采用谐波分析法提取信号基波幅值，通过修正积分法调整算法积分区间积分，实\n现现场谐波干扰下变压器套管介损、电容量的精准监测，介损和电容误差可减小至 0.01%和 0.1%。提出了\n抑制环境负荷干扰的向量差分干扰抑制技术，提取变压器三相局放（泄漏电流）信息，并将其幅值矢量相\n加，若是噪声干扰信号则矢量和为 0，若矢量和大于 0 且指向某相方向，则判定该相出现局放或泄漏电流\n超标，标量监测信息矢量化消除了环境、负荷等因素的干扰，提高了异常相判别的准确性。提出了有限冲\n击响应（FIR）滤波+小波分析+包络线分析的变压器局放信号分层式噪声干扰预处理模型，建立多级横向\nFIR 滤波器滤除待测局放信号 30~300kHz 段低频噪声，采用小波分析滤除周期性干扰抑制白噪声，采用包\n络线分析、脉冲相关性分析技术滤除脉冲干扰，解决了多种干扰共存下的去噪难题，提高了变压器电信号\n监测灵敏度。\n③ 提出了基于纳秒脉冲频率响应分析法（NIFRA）的变压器绕组变形在线监测与故障诊断技术，采\n用欧氏距离、相关因数、均方误差、标准偏差指标进行故障类型分析，解决了传统频率响应法信噪比低、\n测试时间长、无法实现绕组变形故障在线诊断的难题。提出了基于子空间独立分量分离法（SDICA）的绕\n组铁芯故障诊断技术，分离效果不受振动测量位置、电压等级和负载大小影响，解决了传统方法无法有效\n分离绕组和铁心振动混合信号，无法实现故障精准诊断的难题。提出了暂态扰动或谐波激励下套管介电响\n应在线检测新方法和暂态介电响应新算法，实现了变压器套管暂态介电谱快速在线测量，解决了传统工频\n介损电容检测反映绝缘信息少、现场干扰大且需停电开展的技术难题。构建了大型变压器高精度三维模型，\n建立了物理实体与虚拟变压器之间同步运行的孪生交互方法，实现孪生体在感知数据驱动下与物理设备同\n步运行，提出了变压器缺陷及故障孪生重构反演技术，获得了故障状态下变压器运行状态信息，为故障诊\n断提供有效数据。\n④ 建立了融合定期评价、带电检测、在线监测、缺陷库数据的变压器运行状态实时动态评价体系，\n提出了油色谱、局放、振动、套管多参量、绕组及顶层油温等 9 类 22 种在线监测状态量评价标准，提出\n了红外热像、机械振动、绝缘油等 7 类 16 种带电检测状态量评价标准，构建了基于不同供应商在线监测\n装置和带电检测仪器置信度的分级评价权重方法，解决了现行行业标准（DL/T1685-2017）无实时动态评\n价方法、无法精准反应变压器实时状态的难题。建立了放电、过热、绝缘受潮、绕组变形 4 类典型缺陷的\n诊断模型，提出了融合实体感知数据、数字孪生仿真数据、数字化故障案例库的变压器缺陷综合诊断方法，\n实现了变压器缺陷溯源和智能诊断。提出了融合主成分分析法、模糊理论及证据理论的变压器全寿命周期\n性能评估方法，结合动态评价、缺陷诊断与家族病史，建立了变压器健康指数综合评估模型，解决了变压\n器多源信息难以融合应用及无法定量评估的难题。\n四、项目与国内外同类技术比较\n变压器作为电力系统中的核心关键设备，其工作状态的安全可靠直接关系到整个电力系统的连续稳定\n性。状态评估在关键检测与智能感知技术、信号去噪与深度融合、故障综合诊断、动态评价及全寿命综合\n评估方面缺乏深入性研究。提出了油浸变压器状态智能感知与动态评价诊断新技术及应用，取得了一定具\n有自主知识产权的创新成果，与国内外同类技术对比如下：\n（1）变压器状态智能感知技术是设备数字化、物联网、大数据、智能化的基础，而各类感知传感器\n及终端是变压器运行状态的神经末梢，各个维度的感知数据支撑着变压器检修决策体系，是变压器可靠运\n行的重要保障。目前，国内外都在加强变压器状态智能感知技术研究，得到了广泛应用。在局部放电高频\n电流监测、超声波监测、油色谱监测、机械振动监测方面取得了良好的效果。但针对近年来频发的变压器\n套管故障乃至本体闪爆等突发性事故，仍然缺乏安全有效的感知手段。\n本项目开发了纳秒脉冲耦合注入式在线监测装置，将传统的频响法绕组变形应用于在线检监测，解决\n了停电检测的难题。研制了氢气-油温-油压-微水四量融合传感器以及介损-电容-局放一体化宽频微电流传\n感器，可同步监测套管内物理化学参量以及电气参量精确测量。解决了传感器集成及智能化水平较低，无\n法满足变压器多运行状态检测的需要。研制了变压器超声-温度-振动三合一传感器以及微水-氢气-油温三合\n一传感器阵列，获得了传感器布阵方法和多信息参量矩阵特性，解决了现有监测参量相互独立且无法实现\n监测信号时空尺度对齐和融合关联分析的难题。部分指标优于国内外现有产品性能指标，成果被DL/ T\n846.16标委会采纳。\n（2）现有局部放电抗干扰方法主要有数字滤波器法以及小波去噪法等，但数字滤波器在抑制与局部\n放电信号频率相当的窄带周期干扰时，去噪局部放电信号畸变严重，而常规的小波去噪法在抑制白噪声时，\n也会造成局部放电信号的畸变。同时，针对套管介损、电容的抗干扰技术鲜有报道。\n本项目基于以上研究的局限性，目提出了抑制谐波干扰的重心校正谐波分析技术、抑制环境负荷干扰\n的向量差分干扰抑制技术，建立了变压器局部放电信号分层式噪声干扰预处理模型，解决了多种干扰共存\n下的去噪难题，提高了变压器电信号监测灵敏度。提出了变压器三相套管油压差压预处理技术、油温氢气\n信号均值滤波处理技术，提高了变压器物理、化学监测信号灵敏度和诊断准确性。\n（3）电力变压器的内部故障模式主要是机械故障、热故障和电故障三种类型，并且机械性故障常以\n热故障或电故障的形式表现出来。电力变压器故障征兆与故障原因之间的关系错综复杂。近年来，随着在\n线监测技术、计算机技术和人工智能技术的发展，利用油中溶解气体分析技术与模糊逻辑、专家系统和人\n工神经网络等技术融合的诊断方法有效地实现了对电力变压器内绝缘潜伏性故障的诊断。虽然有大量故障\n诊断方法已经用于变压器的状态检修中，但是模型决策层面的融合还未打通，往往拘泥于神经网络算法的\n限制，缺陷研判、故障诊断的算法效果不佳，且缺陷故障识别和推理不能', NULL, 0, '系统依托智能运检管控平台，贯通 PMS、调控云等 14 套\n系统数据，通过加装变压器物联传感装置，实时采集、分析变\n压器电、热、机 3 类 18 项监测数据，利用数字孪生技术推演确\n定故障缺陷位置、运行风险等级，自动提出检修管理策略，实\n现变压器状态自动评价、缺陷实时预警、智能辅助决策。该系\n统自 2022 年 2 月在陕西应用以来，累计完成 330 千伏及以上变\n压器动态评价 3 万余次，诊断状态异常预警 128 次，有效提升\n了变压器运行安全管控水平。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '电力知识');
INSERT INTO `qu` VALUES ('532aeadd18c347cfa432f944490ef06b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '我国第一个南极考察基地“长城站”什么时候落成？', NULL, 0, '1985年2月20日。长城站建于1985年2月20日，坐落在南设得兰群岛乔治王岛。长城站所在的乔治王岛，是南设得兰群岛中最大的一个岛屿。北面邻德雷克海峡，与南美洲的合恩角相距960公里。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('533062fda6d44dd5a3f665dce1ab3a1c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车不能进入红色叉形灯或者红色箭头灯亮的车道。', NULL, 0, '《道路交通安全法实施条例》第四十条 车道信号灯表示：(一)绿色箭头灯亮时，准许本车道车辆按指示方向通行；(二)红色叉形灯或者箭头灯亮时，禁止本车道车辆通行。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('539030c2c3814a35a429bf2ff055c3e3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '省公司领导每月至少下基层调研（）', NULL, 0, '党的二十大报告', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('55176cd71f2944cfaa3bac271dde628c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】<a data-v-b2458244=\"\">解释</a>成语：争先恐后。</p>', NULL, 0, '<p>争先恐后：抢着向前，唯恐落后。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('551e87bf6abc4b9b80a7e27962dcb8a1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>烧一根不均匀的绳要用一个小时，如何用它来判断一个小时十五分钟呢？</p>', NULL, 0, '<p>需要三根绳子。假设分别为 1 号、2 号和 3 号绳子，每个绳子都有 A、B 端。</p>\n<p>首先点燃 1 号绳子的两端，同时点燃 2 号绳子的 A 端，1 号绳子燃尽 (30min) 的同时点燃 2 号绳的 B 端，2 号绳子燃尽 (15min) 的同时点燃 3 号绳子的两端，当 3 号绳子燃尽 (30min) 的时刻就是一个小时十五分钟。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('5611e5efbed5499e87f3c5cdf7832cef', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车遇雾、雨、雪等能见度在50米以内时，最高速度不能超过多少？', NULL, 0, '机动车行驶中遇有下列情形之一的，最高行驶速度不得超过每小时30公里，其中拖拉机、电瓶车、轮式专用机械车不得超过每小时15公里：　　\n（一）进出非机动车道，通过铁路道口、急弯路、窄路、窄桥时；　　\n（二）掉头、转弯、下陡坡时；　　\n（三）遇雾、雨、雪、沙尘、冰雹，能见度在50米以内时；\n（四）在冰雪、泥泞的道路上行驶时；', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('562bbac0f5f54cf09408566f918e58dc', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>某人花19快钱买了个玩具，20快钱卖出去。他觉得不划算，又花21快钱买进，22快钱卖出去。请问它赚了多少钱？</p>', NULL, 0, '<p><strong>2元</strong></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('5645ec3461994aa5b60c6cc0277ce660', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】亚洲人中分布不是很均匀，其中人中较稀疏的部分是（）', NULL, 1, '人口稠密地区都处在中低纬度、近海、平原地区，亚洲人口稀疏的地区在纬度位置较高的北亚，沙漠广布的西亚及气候干旱的中亚地区．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('57585acc3e5e4648acdb62e512b7cde5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车遇到沙尘、冰雹、雨、雾、结冰等气象条件如何行驶？', NULL, 0, '根据《道路交通安全法》 第四十二条：机动车上道路行驶，不得超过限速标志标明的最高时速。在没有限速标志的路段，应当保持安全车速。　\n夜间行驶或者在容易发生危险的路段行驶，以及遇有沙尘、冰雹、雨、雪、雾、结冰等气象条件时，应当降低行驶速度。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('57fb065bb71a4f6589e037e92cc0a789', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在进出非机动车道时，最高速度不能超过多少？', NULL, 0, '机动车行驶中遇有下列情形之一的，最高行驶速度不得超过每小时30公里，其中拖拉机、电瓶车、轮式专用机械车不得超过每小时15公里：　　\n（一）进出非机动车道，通过铁路道口、急弯路、窄路、窄桥时；　　\n（二）掉头、转弯、下陡坡时；　　\n（三）遇雾、雨、雪、沙尘、冰雹，能见度在50米以内时；　　\n（四）在冰雪、泥泞的道路上行驶时；', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('5a69a43212544255ae8beea51f5f93de', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】我国最大的瀑布“黄果树瀑布”位于哪个省（）。', NULL, 0, '黄果树瀑布，即黄果树大瀑布。古称白水河瀑布，亦名“黄葛墅”瀑布或“黄葛树”瀑布，贵州民间自古以来就流传有黄果树瀑布的神话故事，黄果树瀑布的名称就来自这个神话故事中结“黄果”的树。 [1]  位于中国贵州省安顺市镇宁布依族苗族自治县，属珠江水系西江干流南盘江支流北盘江支流打帮河的支流可布河下游白水河段水系，为黄果树瀑布群中规模最大的一级瀑布，是世界著名大瀑布之一。以水势浩大著称。瀑布高度为77.8米，其中主瀑高67米；瀑布宽101米，其中主瀑顶宽83.3米。黄果树瀑布属喀斯特地貌中的侵蚀裂典型瀑布。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('5a91af1341964d5a86edd285ead46004', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】石头城是对我国哪座城市的美称（）。', NULL, 0, '石头城中国地域名，三大石头城分别是： 南京石头城（在江苏南京清凉山）、新疆石头城（在新疆塔什库尔干塔吉克县）、辽阳石头城（在辽宁辽阳市东）。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('5adfebd33e1240d892c48f9744b6517f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】分析全球变暖的形成原因及其影响。</p>', NULL, 0, '<p>原因：①燃烧煤等矿物质；②砍伐森林。</p>\n<p>影响：①两极冰川融化；②海平面上升；③淹没沿海低址。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '气候知识');
INSERT INTO `qu` VALUES ('5b1c91728e0748d490ac00d10f14692d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车上路行驶应当按规定悬挂号牌。', NULL, 0, '《道路交通安全法》第十一条：驾驶机动车上道路行驶，应当悬挂机动车号牌，放置检验合格标志、保险标志，并随车携带机动车行驶证。【两证两标一号牌】', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('5bbd523e6e0b4ce78dab024e9ba332f5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '同车道行驶的车辆遇前车有下列哪种情形时不得超车？', NULL, 0, '《道路交通安全法》第四十三条：同车道行驶的机动车，后车应当与前车保持足以采取紧急制动措施的安全距离。有下列情形之一的，不得超车：\n（一）前车正在左转弯、掉头、超车的；\n（二）与对面来车有会车可能的；\n（三）前车为执行紧急任务的警车、消防车、救护车、工程救险车的；\n（四）行经铁路道口、交叉路口、窄桥、弯道、陡坡、隧道、人行横道、市区交通流量大的路段等没有超车条件的。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('5c0cbd150ebb4d45a51142fbdd174d69', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>我国最北面的城市是哪个（）</p>', NULL, 0, '<p>漠河市，隶属黑龙江省大兴安岭地区。 [1] 地处黑龙江省北部。西与内蒙古自治区呼伦贝尔市额尔古纳市为邻，南与内蒙古自治区根河市和呼中区交界，东与塔河县接壤，北隔黑龙江与俄罗斯外贝加尔边疆区（原赤塔州）和阿穆尔州相望，是中国最北端的县级行政区；地势南高北低，南北呈坡降趋势，属于寒温带大陆性季风气候。下辖6个镇，总面积18427平方千米。</p>\n<p>[2] 根据第七次人口普查数据，截至2020年11月1日零时，漠河市常住人口为54036人。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('5d2ecd3950ef4fadaed89e21d1a52185', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在没有交通信号的路口要尽快通过。', NULL, 0, '驾驶机动车通过没有交通信号灯控制的路口时，应在距路口50-100米时减速，行至路口时仔细观察左右两侧道路交通情况，减速或停车瞭望，做到“一看，二慢、三通过”，直行车辆优先通行。遇到有停车让行标志的路口，要停车观察主路情况，确认安全后再通过。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('5e5d5276f90b4da597b9336c94c0b4a4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在隧道、陡坡等特殊路段不得超车。', NULL, 0, '《道路交通安全法》第四十三条：同车道行驶的机动车，后车应当与前车保持足以采取紧急制动措施的安全距离。有下列情形之一的，不得超车：\n（一）前车正在左转弯、掉头、超车的；\n（二）与对面来车有会车可能的；\n（三）前车为执行紧急任务的警车、消防车、救护车、工程救险车的；\n（四）行经铁路道口、交叉路口、窄桥、弯道、陡坡、隧道、人行横道、市区交通流量大的路段等没有超车条件的。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('5ec60ffc51dc4e6eb50a50624ad05f0a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><a data-v-795acef0=\"\">【自动批阅】</a>解释成语&ldquo;汗牛充栋&rdquo;。</p>\n<p>为演示现给出评分关键字：书籍（得分占比20%）、多（得分占比20%）</p>', NULL, 0, '<p>汗牛充栋：形容书籍极多。汗牛，牛累得出了汗。充栋，堆满了屋子。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('603cc257623f4c228ece1d61c9e0bb96', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】我国人口分布特点', NULL, 0, '人口基数大，新增人口多。人口分布的特点是:东多西少。为了使人口数量的增长同社会经济发展和资源环境条件相适应,我国把实行计划生育作为基本国策', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '中国常识');
INSERT INTO `qu` VALUES ('61690c45efcc4e4d82915def333c0388', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】沙特阿拉伯的贝都因人，居住在帐篷里，穿着宽大的袍子，过着游牧生活，主要原因是（）', NULL, 0, '沙特阿拉伯的贝都因人主要居住在西亚和北非地区，由于西亚和北非形成了炎热干燥的热带沙漠气候，沙特阿拉伯的贝都因人多喜欢穿白色宽大的长袍，白色可以反射较强的太阳光线，长袍可以阻挡强劲的风沙，住在帐篷里，是为了适应逐水草而居的游牧生活', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('61cccef6dd1e4dc8a5eb111f597b05fa', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '已注册登记的机动车，机动车所有人住所在车辆管理所管辖区域内迁移或者机动车所有人姓名（单位名称）、联系方式变更的，应当向登记地车辆管理所备案。', NULL, 0, '《机动车登记规定》第十七条规定：已注册登记的机动车，机动车所有人住所在车辆管理所管辖区域内迁移或者机动车所有人姓名（单位名称）、联系方式变更的，应当向登记地车辆管理所备案。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('62815d180ad5487a80689235718c74ec', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '以下属于唐代诗人的有（）', NULL, 0, '李白（701年－762年） ，字太白，号青莲居士，又号“谪仙人”，是唐代伟大的浪漫主义诗人，被后人誉为“诗仙”，与杜甫并称为“李杜”，为了与另两位诗人李商隐与杜牧即“小李杜”区别，杜甫与李白又合称“大李杜”。\n杜甫（712年—770年），字子美，自号少陵野老，唐代伟大的现实主义诗人，与李白合称“李杜”。\n白居易是唐代伟大的现实主义诗人，唐代三大诗人之一。白居易与元稹共同倡导新乐府运动，世称“元白”，与刘禹锡并称“刘白”。\n李贺（约公元791年-约817年），字长吉，是“长吉体诗歌开创者。”唐代河南福昌（今河南洛阳宜阳县）人，家居福昌昌谷，后世称李昌谷，是唐宗室，唐高祖李渊的叔父李亮（大郑王）后裔。', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '语文知识');
INSERT INTO `qu` VALUES ('62a9625905404c1b9ad6ddc1c45b6a64', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】<a data-v-b2458244=\"\">解释</a>成语：人声鼎沸。</p>', NULL, 0, '<p>人声鼎沸：形容人群的声音吵吵嚷嚷，就象煮开了锅一样。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('633295fa293e41198f4edd00e5fe106f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】亚洲气候的分布特点有哪些？</p>', NULL, 0, '<p>①复杂多样；②大陆性气候分布广；③季风气候显著。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '气候知识');
INSERT INTO `qu` VALUES ('63432c214e4246f88502b3818911399c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '例题 3：近期公司促请省发改委印发了空调负荷管控的工作\n方案，请参照政策文件，拟一篇争取政策类国家电网每日要情重\n要信息，要求用凝练、简洁的语言突出政策亮点、展现可让兄弟\n单位参考借鉴的政策举措，字数控制在 200 字以内。 材料：陕西省空调负荷管控工作方案\n为促进我省能源资源节约高效利用，有效应对夏、冬季高\n峰用电紧张情况，提高全社会能效水平，加快建设清洁低碳、\n安全高效的现代能源体系，制定本方案。\n一、指导思想\n以习近平新时代中国特色社会主义思想为指导，深入贯彻\n— 35 —\n党的二十大精神，全面落实党中央、国务院关于能源电力保供\n工作部署，坚持以人民为中心，坚持节约优先战略，遵循政府\n主导、电网实施、用户参与的原则，建立健全全省空调负荷管\n控工作体系和机制，加快促进全省空调用电节能增效，提升全\n社会用能效益。\n二、工作目标\n开展空调负荷可调控资源安全感知、精准控制、柔性调控\n能力建设，依托新型电力负荷管理系统（以下简称负荷管理系\n统）进行全省空调负荷特性分析，实现空调负荷感知能力全面\n提升，空调用电能效全面优化，促进全社会节能降耗氛围全面\n形成。2023 年完成空调负荷调研摸排，在负荷管理系统中建立\n空调负荷资源库，形成 120 万千瓦空调负荷调控能力。2024 年\n持续推进空调负荷资源池建设，形成 160 万千瓦空调负荷调控\n能力。2025 年确保应接尽接，形成不低于 220 万千瓦的空调负\n荷调节能力', NULL, 0, '党的二十大报告', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '政治知识');
INSERT INTO `qu` VALUES ('6343c1792ddc452c81a2974d60a0b767', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '记分满12分的驾驶人拒不参加学习和考试的将被公告驾驶证停止使用。', NULL, 0, '《道路交通安全违法行为记分管理办法》第二十九条，机动车驾驶人在一个记分周期内累积记分满12分，机动车驾驶证未被依法扣留或者收到满分教育通知书后三十日内拒不参加公安机关交通管理部门通知的满分学习、考试的，由公安机关交通管理部门公告其机动车驾驶证停止使用。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('63659d404f694a8fbea7e1ea29126dd4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】山东山西中的“山”是指（）。', NULL, 0, '早在战国时期，作为区域名称的山东，山西就已经出现在各种文献中，当时的山东指的是崤山以东的地区，包括韩，赵，魏，齐，楚，燕六个国家，故称为山东六国，而山西在当时指崤山以西的地区，包括关中到陕西一带，除了崤山以外，古人还认为山指的是华山 唐代张守杰曾说，谓华山之西也。\n由此可见，从战国到唐朝山指的是崤山或者华山，到了宋金时期，作为行政区域的山东，第一次出现在历史舞台上，金朝设置了山东西路和山东东路范围包括山东大部分区域和江苏小部分区域。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('63e8b9d3bf26413494ffd6e46206f95e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>案情：</p>\n<p>材料一</p>\n<p>改革和法治如鸟之两翼、车之两轮。我们要坚持走中国特色社会主义法治道路，加快构建中国特色社会主义法治体系，建设社会主义法治。全面依法治国，核心是坚持党的领导、人民当家作主、依法治国有机统一， 关键在于坚持觉领导立法、保证执法、支持司法、带头守法。要在全社会牢固树立宪法法律权威，弘扬宪法精神，任何组织和个人都必须在宪法法律范围内活动，都不得有超越宪法法律的特权。</p>\n<p>材料二</p>\n<p>全面推进依法治国这件大事能不能办好，最关键的是方向是不是正确、政治保证是不是坚强有力，具体讲就是要坚持党的领导，坚持中国特色社会主义制度，贯彻中国特色社会主义法治理论。&rdquo;</p>\n<p>&mdash;摘自《关于&lt;中共中央关于全面推进依法治国若干重大问题的决定&gt;的说明》</p>\n<p>根据材料，结合自己的实际工作和学习，谈谈坚定不移走中国特色社会主义法治道路的核心要义。</p>\n<p>答题要求：</p>\n<ol>\n<li>无观点或论述、照搬材料原文的不得分</li>\n<li>观点正确，表达完整、准确</li>\n<li>总字数不少于600字</li>\n</ol>', NULL, 1, '<p>依法治国是坚持和发展中国特色社会主义的本质要求和重要保障，是实现治理体系和治理能力现代化的必然要求，事关我党执政兴国，事关人民幸福安康，事关党和长治久安。全面建成小康社会、实现中华民族伟大复兴的中国梦，全面深化改革、完善和发展中国特色社会主义制度，提高党的执政能力和执政水平，必须全面推进依法治国。在推进依法治国伟大战略的过程中，坚持党的领导，坚持中国特色社会主义制度，贯彻中国特色社会主义法治理论构成中国特色社会主义法治道</p>\n<p>路的核心要义。</p>\n<p>党的领导是中国特色社会主义最本质的特征，是社会主义法治最根本的保证。把党的领导贯彻到依法治国全过程和各方面，是我国社会主义法治建设的一条基本经验。我国宪法确立了中国共产党的领导地位。坚持党的领导是社会主义法治的根本要求，是觉和的根本所在、命脉所在，是全国各族人民的利益所系、幸福所系，是全面推进依法治国的题中应有之</p>\n<p>义。</p>\n<p>中国特色社会主义制度是中国特色社会主义法治体系的根本制度基础，是全面推进依法治国的根本制度保障。中国特色社会主义制度是党领导人民奋斗、创造、积累的根本成就之一，集中体现了中国特色社会主义的特点和优势。全面依法治国战略的推进如果脱离了中国特色社会主义制度这一根本依托，必将成为无源之水、无根之木。在法治的建设过程中，始终坚持从中国的基本国情出发，汲取中华法律文化精华，借鉴但绝不照搬国外法治理念和经验，是依法治国伟大战略顺利达成的必然要求。</p>\n<p>中国特色社会主义法治理论是建设社会主义法治的根本指引。社会主义法治理论是将马克思主义普遍真理同中国实际不断结合的理论结晶，是马克思主义法治思想中国化的最新理论成果，是对我党带领全国人民探索法治道路经验的科学总结。</p>\n<p>伟大的实践离不开伟大的理论，全面深入贯彻中国特色社会主义法治理论，是保障中国特色社会主义法治建设科学性、系统性的精神内核与不二要求。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '政治知识');
INSERT INTO `qu` VALUES ('6478c468a2af48e1aebd963c2a1d55e4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'Jack and Mike like playing basketball .', NULL, 0, 'They are Jack and Mike . They are our good friends . They like watching TV ,but they don’t like playing basket-ball .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('64f7932716094d7cbd13fcc11c71dd3f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车通过漫水路时要加速行驶。', NULL, 0, '《道路交通安全法实施条例》第六十四条：机动车行经漫水路或者漫水桥时，应当停车察明水情，确认安全后，低速通过。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('65e96030cde648d5a0bf9ae570122cce', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】我国最大的瀑布“黄果树瀑布”位于哪个省（）。', NULL, 0, '黄果树瀑布，即黄果树大瀑布。古称白水河瀑布，亦名“黄葛墅”瀑布或“黄葛树”瀑布，贵州民间自古以来就流传有黄果树瀑布的神话故事，黄果树瀑布的名称就来自这个神话故事中结“黄果”的树。 [1]  位于中国贵州省安顺市镇宁布依族苗族自治县，属珠江水系西江干流南盘江支流北盘江支流打帮河的支流可布河下游白水河段水系，为黄果树瀑布群中规模最大的一级瀑布，是世界著名大瀑布之一。以水势浩大著称。瀑布高度为77.8米，其中主瀑高67米；瀑布宽101米，其中主瀑顶宽83.3米。黄果树瀑布属喀斯特地貌中的侵蚀裂典型瀑布。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('66a4c357ac7f4f0f837caf185beae248', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'There are thirty-nine Chinese students in our class', NULL, 1, 'There are forty-two students in our class .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('66a8fe46f7754647a663424d8c566909', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Jack is 12 years old.</p>', NULL, 0, '<p>My name is Jack. I am twelve years old.&nbsp;</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('66e92fe6520d45c4a1bf8f88044fcbbf', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><img class=\"wscnph\" src=\"https://files.yfhl.net/2023/10/30/1698635062954-3a7db0b5.png\" /></p>\n<p>以下属于唐代诗人的有（）</p>', NULL, 0, '<p>李白（701年－762年） ，字太白，号青莲居士，又号&ldquo;谪仙人&rdquo;，是唐代伟大的浪漫主义诗人，被后人誉为&ldquo;诗仙&rdquo;，与杜甫并称为&ldquo;李杜&rdquo;，为了与另两位诗人李商隐与杜牧即&ldquo;小李杜&rdquo;区别，杜甫与李白又合称&ldquo;大李杜&rdquo;。 杜甫（712年&mdash;770年），字子美，自号少陵野老，唐代伟大的现实主义诗人，与李白合称&ldquo;李杜&rdquo;。 白居易是唐代伟大的现实主义诗人，唐代三大诗人之一。白居易与元稹共同倡导新乐府运动，世称&ldquo;元白&rdquo;，与刘禹锡并称&ldquo;刘白&rdquo;。 李贺（约公元791年-约817年），字长吉，是&ldquo;长吉体诗歌开创者。&rdquo;唐代河南福昌（今河南洛阳宜阳县）人，家居福昌昌谷，后世称李昌谷，是唐宗室，唐高祖李渊的叔父李亮（大郑王）后裔。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '语文知识');
INSERT INTO `qu` VALUES ('6818caf6587c4cf6ba2468f91fc355b2', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】我国最大的瀑布“黄果树瀑布”位于哪个省（）。', NULL, 0, '黄果树瀑布，即黄果树大瀑布。古称白水河瀑布，亦名“黄葛墅”瀑布或“黄葛树”瀑布，贵州民间自古以来就流传有黄果树瀑布的神话故事，黄果树瀑布的名称就来自这个神话故事中结“黄果”的树。 [1]  位于中国贵州省安顺市镇宁布依族苗族自治县，属珠江水系西江干流南盘江支流北盘江支流打帮河的支流可布河下游白水河段水系，为黄果树瀑布群中规模最大的一级瀑布，是世界著名大瀑布之一。以水势浩大著称。瀑布高度为77.8米，其中主瀑高67米；瀑布宽101米，其中主瀑顶宽83.3米。黄果树瀑布属喀斯特地貌中的侵蚀裂典型瀑布。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('682d2a2f587046f8bca014db380aae48', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>一个岔路口分别通向诚实国和说谎国。来了两个人，已知一个是诚实国的，另一个是说谎国的。诚实国永远说实话，说谎国永远说谎话。现在你要去说谎国，但不知道应该走那条路，需要问这两个人。请问应该怎么问？</p>', NULL, 0, '<p>请问前面有几个国家，诚实国肯定会说两个，那么就确定了哪个是诚实的人，下面就可以直接问诚实国的人怎么去说谎国了。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('6882fa950b3a44e58aad41a91eebbc76', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><img class=\"wscnph\" src=\"https://files.yfhl.net/2023/8/22/1692704478535-0f7fad7b.png\" /></p>\n<p>党的十九大报告指出，全党要更加自觉地增强（ ）自信、（ ）自信、（ ）自信、（ ）自信，既不走封闭僵化的老路，也不走改旗易帜的邪路，保持政治定力，坚持实干兴邦，始终坚持和发展中国特色社会主义。wqwqwqwq</p>', NULL, 0, '<p><img class=\"wscnph\" src=\"https://files.yfhl.net/2023/8/22/1692704465968-c5a06c01.png\" /></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('6932483968f24f50895576a52a7b6c7e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p style=\"line-height: 150%; margin: 0pt 0pt 0.0001pt; text-align: justify; font-family: \'Times New Roman\'; font-size: 10.5pt;\"><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\"><span style=\"font-family: Times New Roman;\">1</span><span style=\"font-family: 宋体;\">．</span></span><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\"><span style=\"font-family: 宋体;\">若函数</span></span><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\"> <img src=\"https://files.yfhl.net/2023/8/11/1691723150466-1e0dc92c.png\" data-latex=\"y=log(\\sqrt {{x}^{2}+1}-x)\" /></span><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\"><span style=\"font-family: 宋体;\">，则函数y</span></span><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\">&nbsp;</span><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\"><span style=\"font-family: 宋体;\">为（</span></span><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\">&nbsp;&nbsp;</span><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\">&nbsp;&nbsp;<span style=\"font-family: 宋体;\">）</span></span><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\"><span style=\"font-family: Times New Roman;\">.</span></span></p>\n<p style=\"line-height: 150%; margin: 0pt 0pt 0.0001pt; text-align: justify; font-family: \'Times New Roman\'; font-size: 10.5pt;\"><span style=\"font-family: 宋体; line-height: 150%; font-size: 12.0000pt;\"><span style=\"font-family: Times New Roman;\">2：</span></span></p>\n<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n<tbody>\n<tr>\n<td style=\"width: 32.3316%;\">测试表格01</td>\n<td style=\"width: 32.3316%;\">测试表格01</td>\n<td style=\"width: 32.3338%;\">测试表格01</td>\n</tr>\n<tr>\n<td style=\"width: 32.3316%;\">测试表格01</td>\n<td style=\"width: 32.3316%;\">测试表格01</td>\n<td style=\"width: 32.3338%;\">测试表格01</td>\n</tr>\n</tbody>\n</table>\n<p>3：<img src=\"https://files.yfhl.net/2023/8/22/1692679793884-2b62c496.jpg\" alt=\"\" width=\"90\" height=\"68\" /></p>', NULL, 0, '<p>暂无解析</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('699b5e55acd04b57a0584016f6804494', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车在道路上发生故障，需要停车排除时，驾驶人应该怎么办？', NULL, 0, '《道路交通安全法》第五十二条，机动车在道路上发生故障，需要停车排除故障时，驾驶人应当立即开启危险报警闪光灯，将机动车移至不妨碍交通的地方停放；难以移动的，应当持续开启危险报警闪光灯，并在来车方向设置警告标志等措施扩大示警距离，必要时迅速报警。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('69cd86fc54444abbab468121be583be8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】分析亚洲季风气候显著的原因是什么？</p>', NULL, 0, '<p>地处世界最大的大陆一亚欧大陆和世界最大的大洋一太平洋的交界处，海陆热力性质差异显著。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '气候知识');
INSERT INTO `qu` VALUES ('6a567d1d69a54b24817a63faf6c382cb', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'There are thirty-nine Chinese students in our class', NULL, 0, 'There are forty-two students in our class .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('6a6d5ba7ca0843f6b82bd7b0582bf977', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '中国面积最大的省份是哪一个（）。', NULL, 0, '新疆维吾尔自治区，简称“新”，首府乌鲁木齐市，位于中国西北地区，是中国五个少数民族自治区之一。面积166.49万平方公里，是中国陆地面积最大的省级行政区，占中国国土总面积六分之一。2020年第七次全国人口普查常住人口为2585.23万人', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('6ad44a14a8cf4567940882e833e6af82', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>我国最北面的城市是哪个（）</p>', NULL, 0, '<p>漠河市，隶属黑龙江省大兴安岭地区。 [1] 地处黑龙江省北部。西与内蒙古自治区呼伦贝尔市额尔古纳市为邻，南与内蒙古自治区根河市和呼中区交界，东与塔河县接壤，北隔黑龙江与俄罗斯外贝加尔边疆区（原赤塔州）和阿穆尔州相望，是中国最北端的县级行政区；地势南高北低，南北呈坡降趋势，属于寒温带大陆性季风气候。下辖6个镇，总面积18427平方千米。</p>\n<p>[2] 根据第七次人口普查数据，截至2020年11月1日零时，漠河市常住人口为54036人。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('6c70b3ef6e1143e0b86b9c18be1b7959', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】著名的亚欧间的海峡是（）', NULL, 0, '被称为“天下咽喉”的土耳其海峡（又称黑海海峡）是连接黑海与地中海的唯一通道，它包括博斯普鲁斯海峡（又叫伊斯坦布尔海峡）、马尔马拉海和达达尼尔海峡（又叫恰纳卡莱海峡）三部分，全长361千米，整个海峡呈东北－西南走向，是亚、欧两洲的分界线。古往今来皆为兵家必争之地，战略地位十分重要', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('6d936fc697ed4adeb8a730633a2116bd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '红海为什么不断扩张', NULL, 0, '印度洋板块和非洲板块张裂形成', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('6e90badbcf0f4e419c49ec170ada3698', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】我国最北面的城市是哪个（）', NULL, 0, '漠河市，隶属黑龙江省大兴安岭地区。 [1]  地处黑龙江省北部。西与内蒙古自治区呼伦贝尔市额尔古纳市为邻，南与内蒙古自治区根河市和呼中区交界，东与塔河县接壤，北隔黑龙江与俄罗斯外贝加尔边疆区（原赤塔州）和阿穆尔州相望，是中国最北端的县级行政区；地势南高北低，南北呈坡降趋势，属于寒温带大陆性季风气候。下辖6个镇，总面积18427平方千米。 [2]  根据第七次人口普查数据，截至2020年11月1日零时，漠河市常住人口为54036人。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('6ede087829b74886857b9291fcf1ec57', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】分析全球变暖的形成原因及其影响。</p>', NULL, 0, '<p>原因：①燃烧煤等矿物质；②砍伐森林。</p>\n<p>影响：①两极冰川融化；②海平面上升；③淹没沿海低址。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('6f5edd28675b4f61bb485439774a2cb4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】我国少数民族分布最多的省份是（）。', NULL, 0, '云南是中国民族种类最多的省份，除汉族以外，人口在6000人以上的世居少数民族有25个。其中（按人口数多少为序），15个民族为云南特有，人口数均占全国该民族总人口的80%以上。\n\n2015年末，全省少数民族人口数达1583.3万人，占全省人口总数的33.4%，是全国少数民族人口数超过千万的3个省区之一。全省少数民族人口数超过100万的有6个；超过10万不到100万的有9个；超过1万不到10万的有8个；超过6000不到1万的2个。云南少数民族交错分布，表现为大杂居与小聚居，彝族、回族在全省大多数县均有分布。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('6fd3e866978c406aa4b1e1c843915533', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '为什么说啄木鸟是树的医生？', NULL, 0, '啄木鸟把生病的老树治好了', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '通识知识');
INSERT INTO `qu` VALUES ('700646ffed164b6aa9bc15e2274653aa', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】分析亚洲是世界第一大洲的原因有哪些？</p>', NULL, 0, '<p>①面积最大；②跨纬度最广；③东西距离最长。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '亚洲知识');
INSERT INTO `qu` VALUES ('7045a17b94dd43fda9b4e31183405f2b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车超车后立即开启右转向灯驶回原车道。', NULL, 0, '驾驶机动车超车后，应与被超车辆保持横向安全间距，打开右转向灯，在不影响被超越车辆正常行驶的情况下，逐渐平稳地驶回原车道。因此，题干表述错误。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('71153b61fc98484db5955fba15aabedd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>以下属于唐代诗人的有（）</p>', NULL, 0, '<p>李白（701年－762年） ，字太白，号青莲居士，又号&ldquo;谪仙人&rdquo;，是唐代伟大的浪漫主义诗人，被后人誉为&ldquo;诗仙&rdquo;，与杜甫并称为&ldquo;李杜&rdquo;，为了与另两位诗人李商隐与杜牧即&ldquo;小李杜&rdquo;区别，杜甫与李白又合称&ldquo;大李杜&rdquo;。 杜甫（712年&mdash;770年），字子美，自号少陵野老，唐代伟大的现实主义诗人，与李白合称&ldquo;李杜&rdquo;。 白居易是唐代伟大的现实主义诗人，唐代三大诗人之一。白居易与元稹共同倡导新乐府运动，世称&ldquo;元白&rdquo;，与刘禹锡并称&ldquo;刘白&rdquo;。 李贺（约公元791年-约817年），字长吉，是&ldquo;长吉体诗歌开创者。&rdquo;唐代河南福昌（今河南洛阳宜阳县）人，家居福昌昌谷，后世称李昌谷，是唐宗室，唐高祖李渊的叔父李亮（大郑王）后裔。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '语文知识');
INSERT INTO `qu` VALUES ('712513221d6549a2b900e1ab9e51ee13', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】下列河流，最终注入印度洋的是（）', NULL, 0, '亚洲的河流众多，其中注入印度洋的河流有印度河、恒河、怒江等，注入太平洋的河流有长江、黄河、湄公河等，注入北冰洋的河流有鄂毕河、叶尼塞河、勒拿河等．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('71baddfea7254ed9a5ca7a1a0369917d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'There are two American girls and one English boy in our class .', NULL, 1, 'There are also two American boys . They are Jack and Mike . They are our good friends . They like watching TV ,but they don’t like playing basket-ball .They often go to school by bike . And I often go to school on foot . There is one English girl in our class .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('7489a2978c8c49b49b8aa38dab4b0b56', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '实现员工培训规划各项目标的重要保障是（　　）', NULL, 1, '培训的方法是实现员工培训规划各项目标的重要保障，它所要解决的是“船”或“桥”的问题。为了更好地达到培训的目的，完成培训规划预定的目标，培训规划必须根据培训资源配置的状况，正确地选择适用的方法。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '企业培训与制度');
INSERT INTO `qu` VALUES ('7531af15290f4c8694021ab4b01c0c30', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>假设有一个池塘，里面有无穷多的水。现有 2 个空水壶，容积分别为5升和 6 升。问题是如何只用这2个水壶从池塘里取得 3 升的水。</p>', NULL, 0, '<p><br />先装满 5 升的水壶，然后倒到 6 升的水壶里，再装满 5 升水壶，再往 6 升水壶倒满，这样 5 升水壶就剩下四升水。然后把 6 升水壶里的水倒掉，把 5 升水壶里的四升水倒进 6 升水壶里，然后再装满 5 升水壶，再倒入 6 升水壶。这样因为 6 升水壶原先有四升水，现在就只能倒入 2 升。那 5 升水壶就只剩下 3 升水了。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('75c0ec5e6f044d5781a6e3f97a80c70d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '属于对受训者情感结果的评价主要涉及的维度和指标的是（　　）', NULL, 1, '情感结果评估主要是考评受训者在心理上对培训项目所灌输的内容的认可程度，多用于关于企业文化、职业心态等精神层面的培训。对受训者情感结果的评价主要涉及以下维度和指标：创造性、责任意识、学习成长、沟通协调能力。', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '企业培训与制度');
INSERT INTO `qu` VALUES ('7647768497cf4a2cb2d191cdb4a6efa4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '我国少数民族分布最多的省份是（）。', NULL, 0, '云南是中国民族种类最多的省份，除汉族以外，人口在6000人以上的世居少数民族有25个。其中（按人口数多少为序），15个民族为云南特有，人口数均占全国该民族总人口的80%以上。\n\n2015年末，全省少数民族人口数达1583.3万人，占全省人口总数的33.4%，是全国少数民族人口数超过千万的3个省区之一。全省少数民族人口数超过100万的有6个；超过10万不到100万的有9个；超过1万不到10万的有8个；超过6000不到1万的2个。云南少数民族交错分布，表现为大杂居与小聚居，彝族、回族在全省大多数县均有分布。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('773afc7db8e64a9887bb8d9f82ccf497', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'Lucy often does her homework on Saturday afternoons .', NULL, 0, 'She usually does her homework in the evening . She often watches TV on Saturday afternoons .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('7746f5da64f94164aacfd29cba681e59', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '人们应该从哪些方面对环境进行保护', NULL, 0, '确定地球表面某一点的位置', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('7764ea88d80c4184ba3ae8181dabf782', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '交通信号包括交通信号灯、交通标志、交通标线和交通警察的指挥。', NULL, 0, '《道路交通安全法》第二十五条，全国实行统一的道路交通信号。交通信号包括交通信号灯、交通标志、交通标线和交通警察的指挥。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('778bb89404ee46699fdf3320d7750507', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶小型载客汽车在高速公路上时速低于100公里时的最小跟车距离是多少？', NULL, 0, '《道路交通安全法实施条例》第八十条：\n机动车在高速公路上行驶，车速超过每小时100公里时，应当与同车道前车保持100米以上的距离，车速低于每小时100公里时，与同车道前车距离可以适当缩短，但最小距离不得少于50米。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('77c8d1b8e5a04046a3ba2843bbc7c486', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶小型载客汽车在高速公路行驶的最低车速为90公里/小时。', NULL, 0, '《道路交通安全法实施条例》第七十八条：高速公路应当标明车道的行驶速度，最高车速不得超过每小时120公里，最低车速不得低于每小时60公里。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('7a3245e9a7cd4072af43f082fc9e0851', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】下列河流，最终注入印度洋的是（）', NULL, 0, '亚洲的河流众多，其中注入印度洋的河流有印度河、恒河、怒江等，注入太平洋的河流有长江、黄河、湄公河等，注入北冰洋的河流有鄂毕河、叶尼塞河、勒拿河等．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('7ab30154c23243a7837c91760778bddc', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '著名的亚欧间的海峡是（）', NULL, 0, '被称为“天下咽喉”的土耳其海峡（又称黑海海峡）是连接黑海与地中海的唯一通道，它包括博斯普鲁斯海峡（又叫伊斯坦布尔海峡）、马尔马拉海和达达尼尔海峡（又叫恰纳卡莱海峡）三部分，全长361千米，整个海峡呈东北－西南走向，是亚、欧两洲的分界线。古往今来皆为兵家必争之地，战略地位十分重要', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('7ad472d5aa14425fa0557b90996a0586', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车上坡时，在将要到达坡道顶端时要加速并鸣喇叭。', NULL, 0, '《道路交通安全法实施条例》第五十九条：机动车在夜间通过急弯、坡路、拱桥、人行横道或者没有交通信号灯控制的路口时，应当交替使用远近光灯示意。机动车驶近急弯、坡道顶端等影响安全视距的路段以及超车或者遇有紧急情况时，应当减速慢行，并鸣喇叭示意。\n冲坡不冲顶，题目所说的“到达坡道顶端时要加速”描述错误，本题答案应为错误。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('7b0128511a574a709bdfc9f745b1db0b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Jack&rsquo;s favourite food is potatoes.</p>', NULL, 0, '<p>But I don&rsquo;t like tomatoes.Carrots are my favourite.</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('7b8db996799c459ca22beded29f050cf', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在没有交通信号的路口要尽快通过。', NULL, 0, '驾驶机动车通过没有交通信号灯控制的路口时，应在距路口50-100米时减速，行至路口时仔细观察左右两侧道路交通情况，减速或停车瞭望，做到“一看，二慢、三通过”，直行车辆优先通行。遇到有停车让行标志的路口，要停车观察主路情况，确认安全后再通过。\n', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('7c29b16a4126441196ce56bd22777c7b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】南北半球、东西半球的怎样划分的', NULL, 0, '南北半球的分界线是:赤道。东西半球的分界线是: 20° w和160° E组成的经线圈。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('7c2eba01aaaa43639d9df205cd66ecb7', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】中国面积最大的省份是哪一个（）。', NULL, 0, '新疆维吾尔自治区，简称“新”，首府乌鲁木齐市，位于中国西北地区，是中国五个少数民族自治区之一。面积166.49万平方公里，是中国陆地面积最大的省级行政区，占中国国土总面积六分之一。2020年第七次全国人口普查常住人口为2585.23万人', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('7dc44d23727049c3abb5e0b738a79d97', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'dog中文表示为（）', NULL, 0, '鸭子两条腿，属于家禽，而其他属于家畜', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '动物知识');
INSERT INTO `qu` VALUES ('7e98092854174cca8fbaddc0ba1dd9e4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '中国古代四大发明。', NULL, 0, '四大发明是指中国古代对世界具有很大影响的四种发明。即造纸术、指南针、火药、印刷术。', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('7f894a46cade48d2822d3cfe355903c0', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '我国面积最大的湖泊是（）。', NULL, 0, '青海湖是我国最大的湖泊，它是一个咸水湖，面积约4450平方公里，说起来也不小了，但是如果把它放到全世界范围来看的话，青海湖实际上并非大型湖泊，单就面积而言，在全世界排名第34位，和我国国土面积世界第三的位置很不相称，世界最大湖泊里海的面积（38万平方公里），就相当于84个青海湖。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('80017f2fd4814067bbfe9e1caedf85c5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '（）是古代最伟大的浪漫主义持人。', NULL, 1, '李白是古代最伟大的浪漫主义持人。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('80241f73595e47baa52d4f76663ccfc4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>中国四大海域，从北到南顺序依次为()()()()。</p>\n<p>此题演示顺序作答，为演示方便提供答案，依次填写：渤海、黄海、东海、南海，答案顺序错乱不得分</p>', NULL, 0, '<p>【演示顺序作答】注意题目的有顺序要求。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('802cfc12a33f4fe1b1cec9ab57c9d1f7', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】<a data-v-b2458244=\"\">解释</a>成语：无与伦比。</p>', NULL, 0, '<p>无与伦比：指事物非常完美,没有能跟它相比的。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('82af113d1ebb4a849f7d145d670255e2', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '地球公转会产生（）', NULL, 1, '地球自转产生的现象有：\n1、昼夜更替现象，向着太阳的半球,是白天,背着太阳的半球,是黑夜；\n2、南北半球的地转偏向力引起的各种运动旋转现象；\n3、地球上不同经度的地方,有不同的地方时；经度每隔15度,地方时相差一小时；\n4、东西部地区的时间差现象，生物作息规律现象；\n5、对地球形状的影响.地球自转所产生的惯性离心力,使得地球由两级向赤道逐渐膨胀,成为目前略扁的旋转椭球体。\n地球公转产生的现象有：\n1、根据太阳高度的差异,划分出五带：北寒、北温、热带、南温、南寒；\n2、根据获得热量多少的时间差异,划分出四季：春、夏、秋、冬；\n3、昼夜长短的变化现象；\n4、天象位置的变化；生物生长规律现象.\n5、正午太阳高度的变化；夏至日太阳直射北回归线，全球正午太阳高度从北回归线向南北两侧逐渐递减；二分日太阳直射赤道，全球正午太阳高度从赤道向两极递减，全球昼夜平分；冬至日太阳直射南回归线，全球正午高度从南回归线向南北两侧逐渐递减，南回归线及其以南的地区正午太阳高度达到最大值，北半球各纬度正午太阳高度达到最小值。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('833543d100dd47d0b86925fc4c5243b9', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】下列河流，最终注入印度洋的是（）', NULL, 0, '亚洲的河流众多，其中注入印度洋的河流有印度河、恒河、怒江等，注入太平洋的河流有长江、黄河、湄公河等，注入北冰洋的河流有鄂毕河、叶尼塞河、勒拿河等．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('842cf1df6a71424bac98dd9faebfaf56', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列属于唐宋八大家的有（）。', NULL, 1, '唐宋八大家,又称为“唐宋散文八大家”,是唐代和宋代八位散文家的合称,分别为唐代柳宗元、韩愈和宋代欧阳修、苏洵、苏轼、苏辙、王安石、曾巩八位。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('844fbf79e30e4a35afea43592d0e40ba', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '地球上0度经线和0度纬线的长度相比（）', NULL, 1, '0度经线和0度纬线相比()0度纬线的长度是0度经线的2倍。\n因为经线是半圆，赤道是大圆。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('84dff59a482c44f592997829a0adf885', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '请罗列出唐代诗人李白的四部作品。', NULL, 0, '李白深受黄老列庄思想影响，有《李太白集》传世，诗作中多以醉时写的，代表作有《望庐山瀑布》《行路难》《蜀道难》《将进酒》《梁甫吟》《早发白帝城》等多首。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '语文知识');
INSERT INTO `qu` VALUES ('859d2670f7444e969b45414108b00bd4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '企业人力资源管理制度体系可以从（　　）人手，进行规划设计。', NULL, 1, '企业人力资源管理制度体系可以从基础性管理制度和员工管理制度两个方面人手，进行规划设计。属于劳动人事基础管理方面的制度包括：组织机构和设置调整的规定，工作岗位分析与评价工作的规定等。而属于对员工管理的制度主要包括：工作时间规定；考勤规定；休假规定等。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '企业培训与制度');
INSERT INTO `qu` VALUES ('85e6df3aaf0c4b65bbf475ea2e72e702', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'Jack and Mike are our good friends .', NULL, 1, 'There are also two American boys . They are Jack and Mike . They are our good friends . They like watching TV ,but they don’t like playing basket-ball .They often go to school by bike . And I often go to school on foot . There is one English girl in our class .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('8630d4c0ec444e138f0285ac1150d59c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>宋词主要分为婉约派和豪放派，前者代表人物有（），后者代表人物有（）。</p>\n<p>此题演示效果：1.按序作答填空；2.一空支持近似答案；</p>\n<p>为演示方便提供参考答案：第一空：李清照||柳永||秦观||李煜||欧阳修；第二空：苏轼||辛弃疾||苏牧||陈亮</p>', NULL, 0, '<p>婉约派：李清照、柳永、秦观、李煜、欧阳修</p>\n<p>豪放派：苏轼、辛弃疾、苏牧、陈亮 还有一种是花间派：代表人物是温庭筠、魏承班等</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('865549d007ac4ec4b39ebaa154067f97', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>以欺骗、贿赂等不正当手段取得驾驶证被依法撤销驾驶许可的，多长时间不得重新申请驾驶许可？</p>', NULL, 0, '<p>《机动车驾驶证申领和使用规定》第九十三条，<strong>申请人以欺骗、贿赂等不正当手段取得机动车驾驶证的</strong>，公安机关交通管理部门收缴机动车驾驶证，撤销机动车驾驶许可，处二千元以下罚款；申请人<strong>在三年内不得再次申领</strong>机动车驾驶证。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('88f9f8ba351f40c3afdd24f5d764b6e6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '地球上0度经线和0度纬线的长度相比（）', NULL, 0, '0度经线和0度纬线相比()0度纬线的长度是0度经线的2倍。\n因为经线是半圆，赤道是大圆。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('8963d396120a44d1851268d48c86df37', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>８个数字&ldquo;８&rdquo;，如何使它等于1000？</p>', NULL, 0, '<p>8+8+8+88+888</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('8a897564807a4ae78b72fb714a107591', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>下面属于唐代诗人李白的作品的是（）</p>', NULL, 0, '<p>《将进酒》为李白作品，《登高》为杜甫作品，《琵琶行》、《长恨歌》为白居易作品。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('8a8dedc0561948e891bbd384362fe125', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>上路行驶的机动车使用伪造、变造的检验合格标志的，交通警察可依法扣留机动车。</p>', NULL, 0, '<p>《道路交通安全法》第九十六条，伪造、变造或者<strong>使用伪造、变造的检验合格标志</strong>、保险标志的，由公安机关交通管理部门予以收缴，<strong>扣留该机动车</strong>，处十日以下拘留，并处一千元以上三千元以下罚款；构成犯罪的，依法追究刑事责任。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('8bc89d7af5924f1d8a833379691868c7', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>驾驶拼装机动车上路行驶的驾驶人，除按规定接受罚款外，还要受到哪种处理？</p>', NULL, 0, '<p>根据《道路交通安全法》的规定，对驾驶拼装的机动车或已达到报废标准的机动车上路行驶的驾驶人，处200元以上2000元以下罚款，<strong>并吊销机动车驾驶证</strong>，对车辆予以收缴，强制报废。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('8bddfb2febcd428594817d0a25df58ad', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>按照现行规定，下列各项中必须被认定为小规模纳税人的是( )。</p>', NULL, 1, '<p>增值税两类纳税人划分标准按经营规模或核算水平区分。自1998年7 月1 日起，凡年销售额在180万元以下的小规模商业企业，无论会计核算是否健全，一律不得认定为一般纳税人。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '企业培训与制度');
INSERT INTO `qu` VALUES ('8be6003c400540e392257504aa7f4fe9', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>机动车驾驶人造成事故后逃逸构成犯罪的，吊销驾驶证且多长时间不得重新取得驾驶证？</p>', NULL, 0, '<p>《道路交通安全法》第一百零一条 违反道路交通安全法律、法规的规定，发生重大交通事故，构成犯罪的，依法追究刑事责任，并由公安机关交通管理部门吊销机动车驾驶证。<br />造成交通事故后<strong>逃逸且构成犯罪</strong>的，由公安机关交通管理部门吊销机动车驾驶证，且<strong>终生不得重新取得</strong>机动车驾驶证。【逃终生】</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('8c24ebedf58b4e7c83b67bdf95602582', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】亚洲各国经济发展不平衡，下列国家中人均国民生产总值最高的是（）', NULL, 1, '本题还可以考查人口：人口超亿的国家有中国、印度、印度尼西亚、巴基斯坦、日本、孟加拉国等6个；各大洲人口排序：亚非欧南北美大洋洲；各大洲人口增长率：非南美亚大洋北美欧；著名的民族文化：亚洲三个人类文明发祥地：华夏文化(黄河——长江中下游地区)、印度河流域文化、两河流域文化(由幼法拉底河和底格里斯河冲积而成的美索不达米亚平原地区)；还有恒河文化、阿拉伯文化等。亚洲只有日本属于发达国家。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('8ee2ce33144d4d19b625a6bbf4037da6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】亚洲各国经济发展不平衡，下列国家中人均国民生产总值最高的是（）', NULL, 1, '本题还可以考查人口：人口超亿的国家有中国、印度、印度尼西亚、巴基斯坦、日本、孟加拉国等6个；各大洲人口排序：亚非欧南北美大洋洲；各大洲人口增长率：非南美亚大洋北美欧；著名的民族文化：亚洲三个人类文明发祥地：华夏文化(黄河——长江中下游地区)、印度河流域文化、两河流域文化(由幼法拉底河和底格里斯河冲积而成的美索不达米亚平原地区)；还有恒河文化、阿拉伯文化等。亚洲只有日本属于发达国家。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('8f797d0583bf4e8eab911b5ace56347b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>伪造、变造机动车驾驶证构成犯罪的将被依法追究刑事责任。</p>', NULL, 0, '<p>《道路交通安全法》第九十六条：伪造、变造或者使用伪造、变造的机动车登记证书、号牌、行驶证、驾驶证的，由公安机关交通管理部门予以收缴，扣留该机动车，处十五日以下拘留，并处二千元以上五千元以下罚款；<strong>构成犯罪的，依法追究刑事责任。</strong></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('8f8116ef8db9424c83de6053fa5f9d6f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】<p><a class=\"d-link\" data-v-b2458244=\"\">简述地球自转（从自转的定义、方向、周期、产生的现象）</a></p>', NULL, 0, '<p>地球围绕地轴不停地旋转，叫做地球的自转，地球的自转方向是自西向东，自转一周的 时间(周期)是一天，产生的地理现象是昼夜更替和时间的差异。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('8fd3f9a314354371afa2dbe93c06a338', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶人因服兵役、出国（境）等原因延期审验期间不得驾驶机动车。', NULL, 0, '《机动车驾驶证申领和使用规定》第六十三条：\n机动车驾驶人因服兵役、出国（境）等原因，无法在规定时间内办理驾驶证期满换证、审验、提交身体条件证明的，可以向机动车驾驶证核发地车辆管理所申请延期办理。申请时应当填写申请表，并提交机动车驾驶人的身份证明、机动车驾驶证和延期事由证明。\n延期期限最长不超过三年。延期期间机动车驾驶人不得驾驶机动车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('91cfc6a1359b4d4d8b4c7edf1c9752c7', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】我国人口分布特点', NULL, 0, '人口基数大，新增人口多。人口分布的特点是:东多西少。为了使人口数量的增长同社会经济发展和资源环境条件相适应,我国把实行计划生育作为基本国策', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '中国常识');
INSERT INTO `qu` VALUES ('91f9535fd70747509647e12f81279d16', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '“诚者，天之道也。”这里的“诚”的意思解释正确的是（）。', NULL, 1, '“诚者，天之道也。”中“诚”指自然万物的客观实在性', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '企业培训与制度');
INSERT INTO `qu` VALUES ('928d49b065434efd9546dc1902c21d25', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '世界气温分布规律（纬度、海陆、地形三大因素阐述）', NULL, 0, '(1)低纬度气温高，高纬度气温低(纬度因素)\n(2) 同纬度地带，夏季陆地气温高，海洋气温低;冬季相反。(海陆因素)\n(3)在山地，气温随着海拔升高而降低。(地形因素)', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('936dbd23bc2444eeab58fcf1a2b8d61e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Max and Bill both like to ()</p>', NULL, 0, '<p>Every Sunday morning Bill and I play computer games.</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '英语知识');
INSERT INTO `qu` VALUES ('93e59078f5aa4595a202a401d92d1902', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在泥泞道路行驶时，最高速度不能超过多少？', NULL, 0, '机动车行驶中遇有下列情形之一的，最高行驶速度不得超过每小时30公里，其中拖拉机、电瓶车、轮式专用机械车不得超过每小时15公里：　　\n（一）进出非机动车道，通过铁路道口、急弯路、窄路、窄桥时；　　\n（二）掉头、转弯、下陡坡时；　　\n（三）遇雾、雨、雪、沙尘、冰雹，能见度在50米以内时；　　\n（四）在冰雪、泥泞的道路上行驶时；', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('95fa1fa5b42e4a6cb2f86cd27127e1e8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '夜间驾驶机动车通过人行横道时需要交替使用远近光灯。', NULL, 0, '《道路交通安全法实施条例》第五十九条：机动车在夜间通过急弯、坡路、拱桥、人行横道或者没有交通信号灯控制的路口时，应当交替使用远近光灯示意。因此，题干表述正确。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('963c7e0b8fc54be4b33a72067d872448', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>驾驶机动车在道路上违反道路通行规定应当接受相应的处罚。</p>', NULL, 0, '<p>驾驶机动车在道路上违反道路交通安全法的行为属于违法行为。 依据《道路交通安全法》第八十七条，公安机关交通管理部门及其交通警察应当依据事实和本法的有关规定对<strong>道路交通安全违法行为予以处罚。</strong>对于情节轻微，未影响道路通行的，指出违法行为，给予口头警告后放行。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('965e9318a29f45329b4c70acf308fab2', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】<a data-v-b2458244=\"\">解释</a>成语：小心翼翼。</p>', NULL, 0, '<p>小心翼翼：形容举动十分谨慎,一点不敢疏忽。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('9709fb53a7ff4ab69c2c367644e36465', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】泼水节是我国哪个少数民族的传统节日（）。', NULL, 0, '“泼水节是傣族、阿昌族、布朗族、佤族、德昂族以及泰语民族和东南亚地区的传统节日。泼水节又名“浴佛节”，傣语称为“比迈”（意思为新年），西双版纳及德宏地区的傣族又称此节日为“尚罕”和“尚键”，两名称均源于梵语，意为周转、变更和转移，指太阳已经在黄道十二宫运转一周开始向新的一年过渡。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('97ee55208fb648268c08afafddbe25c4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '南极洲的代表动物是（）', NULL, 0, '南极企鹅', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '动物知识');
INSERT INTO `qu` VALUES ('9856ef743e7848e9b94a61d8646519f8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】世界上面积最大的国家是（）。', NULL, 0, '“俄罗斯是陆地面积最大的国家，位于欧洲东部和亚洲北部，横跨欧亚大陆，东濒太平洋，西接波罗的海芬兰湾，东西最长9000公里，南北最宽4000公里，领土面积约1707.54万平方公里。陆地邻国西北面有挪威、芬兰，西面有爱沙尼亚、拉脱维亚、立陶宛、波兰、白俄罗斯。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('9880957f04e940acbfd21c6ea49e1b74', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>驾驶机动车在道路上违反交通安全法规的行为属于违法行为。</p>', NULL, 0, '<p><strong>驾驶机动车在道路上违反道路交通安全法的行为属于违法行为。</strong>根据《道路交通安全法》第二条规定，中华人民共和国境内的车辆驾驶人、行人、乘车人以及与道路交通活动有关的单位和个人，都应当遵守本法。<br />第八十八条&nbsp;对道路交通安全违法行为的处罚种类包括：警告、罚款、暂扣或者吊销机动车驾驶证、拘留。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('9953ff72acf24de6bd2f1cbcd83823fc', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '我国最大的淡水湖是（）。', NULL, 0, '“我国第一大淡水湖是鄱阳湖，也是中国第二大湖。鄱阳湖地处江西省的北部，长江中下游南岸，承纳赣江、抚河、信江、饶河、修河五大河，流域面积为16.2万平方公里，占江西省国土面积97%左右。鄱阳湖以松门山为界，分为南北两部分，北面为入江水道，南北长173公里，东西最宽处达74公里。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('998ab79a80fb426a9adafd419f1915c8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>桌子上有 3 只朝上的茶杯，每次翻转 2 只，能否经过若干次翻转使得 3 只杯子的杯口全部朝下呢？</p>', NULL, 0, '<p>不管经过多少次，其相当于每次翻转 1 只共翻转了偶数次，奇数不能与偶数，所以不可能。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('99e93289e0474c0c8cab82bf0466a9e3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【<a data-v-b2458244=\"\">自动批阅】</a>运用板块构造学说，分析日本多火山地震的原因。</p>', NULL, 0, '<p>位于欧亚板块、北美板块和太平洋板块的交界处，地壳运动活跃。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('9aa72e58b8d94d57addea9f776ad15fa', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Most of Max\'s fridends are ().</p>', NULL, 0, '<p>I am twelve years old. I have many friends. Most of them are as old as I.&nbsp;</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '英语知识');
INSERT INTO `qu` VALUES ('9b4511f7d6b8401496975a704a54bab1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'Jack and Mike are our good friends .', NULL, 0, 'There are also two American boys . They are Jack and Mike . They are our good friends . They like watching TV ,but they don’t like playing basket-ball .They often go to school by bike . And I often go to school on foot . There is one English girl in our class .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('9c160e4679f0497ca7256699b1ccd719', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>造成交通事故后逃逸且构成犯罪的驾驶人，将吊销驾驶证且终生不得重新取得驾驶证。</p>', NULL, 0, '<p>【<strong>假1吊2骗3醉5逃终生</strong>】《道路交通安全法》第一百零一条：违反道路交通安全法律、法规的规定，发生重大交通事故，构成犯罪的，依法追究刑事责任，并由公安机关交通管理部门吊销机动车驾驶证。<strong>造成交通事故后逃逸的，由公安机关交通管理部门吊销机动车驾驶证，且终生不得重新取得机动车驾驶证。</strong></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('9c50b04820d748cf84c776b405c35dd4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】亚洲面积最大的气候类型及其气候特征是什么？</p>', NULL, 0, '<p>气候类型：温带大陆性气候.气候特征：冬冷夏热，全年降水少。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '气候知识');
INSERT INTO `qu` VALUES ('9cbc5772ca0d4bbc8bf2ff83b51bc43a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '水电站选址应从哪些方面考虑？', NULL, 0, '确定地球表面某一点的位置', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('9d138585bc7c4d10904f33a0229d59c2', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>对驾驶已达到报废标准的机动车上路行驶的驾驶人，会受到下列哪种处罚？</p>', NULL, 0, '<p>根据《道路交通安全法》规定，驾驶拼装的机动车或者已达到报废标准的机动车上道路行驶的，公安机关交通管理部门应当予以收缴，强制报废。对驾驶前款所列机动车上道路行驶的驾驶人，处<strong>200元以上2000元以下</strong>罚款，并<strong>吊销机动车驾驶证</strong>。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('9ddaa641580c444382d4ab969e53e1a9', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】沙特阿拉伯的贝都因人，居住在帐篷里，穿着宽大的袍子，过着游牧生活，主要原因是（）', NULL, 0, '沙特阿拉伯的贝都因人主要居住在西亚和北非地区，由于西亚和北非形成了炎热干燥的热带沙漠气候，沙特阿拉伯的贝都因人多喜欢穿白色宽大的长袍，白色可以反射较强的太阳光线，长袍可以阻挡强劲的风沙，住在帐篷里，是为了适应逐水草而居的游牧生活', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('9e5077ca8b0943a09f8d37302ee53b2c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '饮酒后只要不影响驾驶操作可以短距离驾驶机动车。', NULL, 0, '《道路交通安全法》第二十二条规定：饮酒、服用国家管制的精神药品或者麻醉药品，或者患有妨碍安全驾驶机动车的疾病，或者过度疲劳影响安全驾驶的，不得驾驶机动车。本题题干表述有误，因此本题答案应为错误。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('9ecce38f0b36474cac20a4cd16ee8a92', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>有一种细菌，经过1分钟，分裂成2个，再过1分钟，又发生分裂，变成4个。这样，把一个细菌放在瓶子里到充满为止，用了1个小时。如果一开始时，将2个这种细菌放入瓶子里，那么，到充满瓶子需要多长时间?</p>', NULL, 0, '<p>59分钟</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('9f74bad9eb694fbeb32e25dac99ea39a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '地中海为什么不断缩小', NULL, 0, '亚欧板块和非洲板块不断地碰撞、挤压', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('a0f1a0b4421d4a8483e426edd6c2b90a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】分析日本河流短小，水流湍急，水能资源丰富的原因。</p>', NULL, 0, '<p>日本地形以山地、丘陵为主，南北狭长，因此河流短小，水流湍急；日本是地处东亚季风区的岛国，降水丰富，河流水量大，且落差大，水能资源丰富。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('a1559b53a84a430781a16272b58deefa', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '道路交通标线分为指示标线、警告标线、禁止标线。', NULL, 0, '《道路交通安全法实施条例》第三十条 交通标志分为：指示标志、警告标志、禁令标志、指路标志、旅游区标志、道路施工安全标志和辅助标志。 道路交通标线分为：指示标线、警告标线、禁止标线。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('a1922aafdafa41979769bfd61da548a8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Max helps Bill with ().</p>', NULL, 0, '<p>I help him with his English homework.</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '英语知识');
INSERT INTO `qu` VALUES ('a2457c9c44694a859223908831941002', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列哪种证件是驾驶机动车上路行驶应当随车携带？', NULL, 0, '上道路行驶的机动车应当随车携带：两证、两标、一号牌。根据《道路交通安全法》第十一条：驾驶机动车上道路行驶，应当悬挂机动车号牌，放置检验合格标志、保险标志，并随车携带机动车行驶证。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('a26cb4e5845644dcaec6884a89de7ff5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '距离交叉路口50米以内的路段不能停车。', NULL, 0, '【口五站三】距离交叉路口50米内路段，不得停车。根据《道路安全法实施条例》第六十三条，机动车在道路上临时停车应当遵守下列规定：\n（2）交叉路口、铁路道口、急转弯、宽度不足4米的窄路、桥梁、陡坡、隧道以及距离上述地点50米以内的路段，不得停车；【口5】\n（3）公共汽车站、急救站、加油站、消防栓或者消防队（站）门前以及距离上述地点30米以内的路段，除使用上述设施的以外，不得停车；【站3】', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('a26e2923e543499a8ba9b41d4ccad0f0', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】石头城是对我国哪座城市的美称（）。', NULL, 0, '石头城中国地域名，三大石头城分别是： 南京石头城（在江苏南京清凉山）、新疆石头城（在新疆塔什库尔干塔吉克县）、辽阳石头城（在辽宁辽阳市东）。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('a273bef0d17f41fca55a5710e136869d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车遇到漫水桥时要察明水情确认安全后再低速通过。', NULL, 0, '《道路交通安全法实施条例》第六十四条：机动车行经漫水路或者漫水桥时，应当停车察明水情，确认安全后，低速通过。\n察明水情确认安全即通过对涉水的深度、水流速度和水底情况进行调查，不可冒险涉水驾驶。涉水中，特别注意减速慢行，不要注视水流的变化，避免中途停留；涉水后，间断轻踏制动踏板，以恢复制动效能。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('a2b0e994eb3a4d2c94633efe307020e5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'Lucy often does her homework on Saturday afternoons .', NULL, 1, 'She usually does her homework in the evening . She often watches TV on Saturday afternoons .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('a472ce93226c4566b014276de794593a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】经纬网的用途是什么', NULL, 0, '确定地球表面某一点的位置', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('a4ac8920a4524028bf76ec4f4831042d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '《蜀道难》是唐代诗人李白的作品吗？', NULL, 0, '李白深受黄老列庄思想影响，有《李太白集》传世，诗作中多以醉时写的，代表作有《望庐山瀑布》《行路难》《蜀道难》《将进酒》《梁甫吟》《早发白帝城》等多首。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '语文知识');
INSERT INTO `qu` VALUES ('a5459e7d9d67454ab2bf90578489ce9d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车停稳前不能开车门和上下人员。', NULL, 0, '《道路交通安全法实施条例》第六十三条　机动车在道路上临时停车，应当遵守下列规定： (四)车辆停稳前不得开车门和上下人员，开关车门不得妨碍其他车辆和行人通行；', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('a59bc2eea3bb4ecfa0fffd7abbd2b017', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>机动车驾驶人初次申领驾驶证后的实习期是多长时间？</p>', NULL, 0, '<p>《机动车驾驶证申领和使用规定》第七十六条，机动车驾驶人<strong>初次取得</strong>汽车类准驾车型或者<strong>初次取得</strong>摩托车类准驾车型后的<strong>12个月为实习期</strong>。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('a5a15747dac14c2f8996ae62e82aa06a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶人在驾驶证丢失后3个月内还可以驾驶机动车。', NULL, 0, '《道路交通安全法实施条例》第二十八条规定 机动车驾驶人在机动车驾驶证丢失、损毁、超过有效期或者被依法扣留、暂扣期间以及记分达到12分的，不得驾驶机动车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('a6f52b36b63e43569571fccd1bfc7589', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>一口井7米深，有只蜗牛从井底往上爬，白天爬3米，晚上往下坠2米。问蜗牛几天能从井里爬出来？</p>', NULL, 0, '<p>5天</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('a7ed08dcbe4548d98e5b3978d5471492', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车上路行驶时，前排乘车人可不系安全带。', NULL, 0, '《道路交通安全法》第五十一条：机动车行驶时，驾驶人、乘坐人员应当按规定使用安全带，摩托车驾驶人及乘坐人员应当按规定戴安全头盔。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('a8187f2d23dc4015b5aa7920d01e2f1a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '诗仙是指（）', NULL, 0, '“诗仙是指李白，他的诗富于自我表现的主观抒情色彩十分浓烈，感情的表达具有一种排山倒海、一泻千里的气势。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('aa0e363c6ae04886b1caa5e4c996ace5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】世界气温分布规律（纬度、海陆、地形三大因素阐述）', NULL, 0, '(1)低纬度气温高，高纬度气温低(纬度因素)\n(2) 同纬度地带，夏季陆地气温高，海洋气温低;冬季相反。(海陆因素)\n(3)在山地，气温随着海拔升高而降低。(地形因素)', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('ab07439ebf4249f8922e87c14539606e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>如图所示，遇到这种情形怎样行驶？</p>\n<p><img class=\"wscnph\" src=\"https://files.yfhl.net/2023/9/7/1694069863975-062899db.jpg\" /></p>', NULL, 0, '<p>《道路交通安全法实施条例》第四十八条：</p>\n<p>在没有中心隔离设施或者没有中心线的道路上，在有障碍的路段，无障碍的一方先行；但有障碍的一方已驶入障碍路段而无障碍的一方未驶入时，有障碍的一方先行。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('ab9e817894024513b625fb3e61633090', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '（）是我国最早的田园诗人。', NULL, 1, '陶渊明是我国最早的东晋田园诗人。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('acaa83033e5f4d4a8df87f75b858cda5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '西亚波斯湾沿岸比较富裕，其原因是（）', NULL, 0, '西亚波斯湾沿岸国家比较富裕，是因为大量出口石油资源．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('aeca8916be004d77bf23140b6a4c47a5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '交通信号灯由红灯、绿灯和黄灯组成。', NULL, 0, '《道路交通安全法》第二十六条，交通信号灯由红灯、绿灯、黄灯组成。红灯表示禁止通行，绿灯表示准许通行，黄灯表示警示。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('b0265d784e8e4633b7e13f5dc62b9d50', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '西亚波斯湾沿岸比较富裕，其原因是（）', NULL, 1, '西亚波斯湾沿岸国家比较富裕，是因为大量出口石油资源．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('b028c1e853b24dc088dc59f434f66e53', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '我国人口分布特点', NULL, 0, '人口基数大，新增人口多。人口分布的特点是:东多西少。为了使人口数量的增长同社会经济发展和资源环境条件相适应,我国把实行计划生育作为基本国策', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '中国常识');
INSERT INTO `qu` VALUES ('b071cb6cc49d4899ad3177bd69426952', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><span style=\"color: #000000; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; white-space: normal; background-color: #ffffff; float: none; display: inline;\">&nbsp;若输出的字符串为&nbsp;</span><span class=\"katex\" style=\"margin: 0px; padding: 0px; font-kerning: auto; font-optical-sizing: auto; font-feature-settings: normal; font-variation-settings: normal; font-stretch: normal; font-size: 1.21em; line-height: 1.2; font-family: KaTeX_Main, \'Times New Roman\', serif; white-space: nowrap; text-rendering: auto; color: #000000; background-color: #ffffff;\"><span class=\"katex-mathml\" style=\"margin: 0px; padding: 0px; position: absolute; clip: rect(1px, 1px, 1px, 1px); border-width: 0px; height: 1px; width: 1px; overflow: hidden;\">ABCABCABCA</span><span class=\"katex-html\" style=\"margin: 0px; padding: 0px; display: inline-block;\" aria-hidden=\"true\"><span class=\"base\" style=\"margin: 0px; padding: 0px; position: relative; display: inline-block;\"><span class=\"mord text\" style=\"margin: 0px; padding: 0px;\"><span class=\"mord texttt\" style=\"margin: 0px; padding: 0px; font-family: KaTeX_Typewriter;\">ABCABCABCA</span></span></span></span></span><span style=\"color: #000000; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; white-space: normal; background-color: #ffffff; float: none; display: inline;\">，则下列说法正确的是（ ）</span></p>', NULL, 0, '<p><span style=\"color: #5eb95e; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; text-align: left; white-space: normal; background-color: #ffffff; float: none; display: inline;\">正确答案： A</span></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '计算机编程');
INSERT INTO `qu` VALUES ('b0ace503d6524c28b1dd607a57c105e1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车驾驶证遗失的，机动车驾驶人应当向哪里的车辆管理所申请补发？', NULL, 0, '《机动车驾驶证申领和使用规定》第六十三条，机动车驾驶证遗失的，机动车驾驶人应当向机动车驾驶证核发地或者核发地以外的车辆管理所申请补发。申请时应当填写申请表，并提交以下证明、凭证：（一）机动车驾驶人的身份证明；（二）机动车驾驶证遗失的书面声明。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('b0d2e2c2fec840fabb227b8fbe572ec7', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】南半球的等温线比北半球的等温线平直，试分析其原因。</p>', NULL, 0, '<p>南半球海洋面积广</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('b0eca373a14442db92929ecb3434df3a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】<a data-v-b2458244=\"\">解释</a>成语：身临其境。</p>', NULL, 0, '<p>身临其境：亲身面临那种境地</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('b1caceff25914b3daed4ca946ab423f6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>对驾驶拼装机动车上路行驶的驾驶人，会受到下列哪种处罚？</p>', NULL, 0, '<p>根据《道路交通安全法》第一百条规定，<strong>驾驶拼装</strong>的机动车或者已达到报废标准的机动车上道路行驶的，公安机关交通管理部门应当予以收缴，强制报废。对驾驶前款所列机动车上道路行驶的驾驶人，处<strong>200元以上2000元以下</strong>罚款，并<strong>吊销机动车驾驶证</strong>。请注意：<strong>吊销驾驶证，不是吊销行驶证。</strong></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('b2327d9428624b90adda2c48e1fd1dba', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在下列哪种路段不得超车？', NULL, 0, '《道路交通安全法》第四十三条：同车道行驶的机动车，后车应当与前车保持足以采取紧急制动措施的安全距离。有下列情形之一的，不得超车：\n（一）前车正在左转弯、掉头、超车的；\n（二）与对面来车有会车可能的；\n（三）前车为执行紧急任务的警车、消防车、救护车、工程救险车的；\n（四）行经铁路道口、交叉路口、窄桥、弯道、陡坡、隧道、人行横道、市区交通流量大的路段等没有超车条件的。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('b26d01494783429f950ad2c24a541958', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列国家人口超过1亿的南亚国家是（）', NULL, 1, '世界人口超过一亿的国家，从多到少依次为：中国、印度、美国、印度尼西亚、巴西、巴基斯坦、俄罗斯、孟加拉国、尼日利亚、日本和墨西哥共有11个．其中属于南亚的是印度、巴基斯坦和孟加拉国．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '通识知识');
INSERT INTO `qu` VALUES ('b2b38e020597434ea12b925ccf4d286b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】亚洲人中分布不是很均匀，其中人中较稀疏的部分是（）', NULL, 1, '人口稠密地区都处在中低纬度、近海、平原地区，亚洲人口稀疏的地区在纬度位置较高的北亚，沙漠广布的西亚及气候干旱的中亚地区．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('b36d73fdf1c4423ab38bb367ab23328f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '在没有中心线的道路上发现后车发出超车信号时，如果条件许可如何行驶？', NULL, 0, '驾驶机动车在没有中心线的道路上发现后车发出超车信号时，若具备让车条件，应及时开启右转向灯，减速靠右让行，必要时辅以手势示意让超，不得故意不让或让路不让速。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('b448b53af2d7457680d117ae26310805', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车在道路上发生故障，难以移动时下列做法正确的是什么？', NULL, 0, '《道路交通安全法》第五十二条，机动车在道路上发生故障，需要停车排除故障时，驾驶人应当立即开启危险报警闪光灯，将机动车移至不妨碍交通的地方停放；难以移动的，应当持续开启危险报警闪光灯，并在来车方向设置警告标志等措施扩大示警距离，必要时迅速报警。【车靠边、人撤离、即报警】', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('b63c3ecbc3a04f31a18f3dc856e9b1c6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>机动车驾驶人违法驾驶造成重大交通事故构成犯罪的，依法追究什么责任？</p>', NULL, 0, '<p>《道路交通安全法》第一百零一条，违反道路交通安全法律、法规规定，发生重大交通事故，构成犯罪的，依法追究刑事责任，并由公安机关交通管理部门吊销机动车驾驶证。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('b8c8e4a6aa1e49618bfa98c6e9bdc8b4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '党的二十大报告指出 ，十年来，我们贯彻\n（），国家安全领导体制和法治体系 、战略体\n系、政策体系不断完善，在原则问题上寸步不\n让，以坚定的意志品质维护国家主权 、安全、\n发展利益，国家安全得到全面加强 。', NULL, 0, '党的二十大报告', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('b8f4a236f75b4acd802789742e7ed025', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】我国第一个南极考察基地“长城站”什么时候落成？', NULL, 0, '1985年2月20日。长城站建于1985年2月20日，坐落在南设得兰群岛乔治王岛。长城站所在的乔治王岛，是南设得兰群岛中最大的一个岛屿。北面邻德雷克海峡，与南美洲的合恩角相距960公里。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('b9092609e6414a3f8554a7c6206f949d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】中国、日本位于亚洲的（）', NULL, 1, '中国和日本都位于东亚地区．根据题意．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('b9d77f5317b142e1adac070484a4425d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '我国的企业基本用工形式是（　　）', NULL, 1, '劳动合同用工是我国的企业基本用工形式。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '企业培训与制度');
INSERT INTO `qu` VALUES ('b9fea19edde44c32bfebd2953a080ba3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】世界上最长的运河是哪一条（）', NULL, 0, '京杭大运河始建于春秋时期，是世界上里程最长、工程最大的古代运河，也是最古老的运河之一，与长城、坎儿井并称为中国古代的三项伟大工程，并且使用至今，是中国古代劳动人民创造的一项伟大工程，是中国文化地位的象征之一。大运河南起余杭（今杭州），北到涿郡（今北京），途经今浙江、江苏、山东、河北四省及天津、北京两市，贯通海河、黄河、淮河、长江、钱塘江五大水系，主要水源为微山湖，大运河全长约1797公里。运河对中国南北地区之间的经济、文化发展与交流，特别是对沿线地区工农业经济的发展起了巨大作用。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('ba81a13b14dc4e7f8cd4982ed3f04bad', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'There are two American girls and one English boy in our class .', NULL, 0, 'There are also two American boys . They are Jack and Mike . They are our good friends . They like watching TV ,but they don’t like playing basket-ball .They often go to school by bike . And I often go to school on foot . There is one English girl in our class .', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('bad3f168e5d94860a626593ff78c6e47', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶人出现下列哪种情况，不得驾驶机动车？', NULL, 0, '《道路交通安全法实施条例》第二十八条规定 机动车驾驶人在机动车驾驶证丢失、损毁、超过有效期或者被依法扣留、暂扣期间以及记分达到12分的，不得驾驶机动车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('baf55e806d9d4001800bc87a86b5bfe4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】亚洲面积最大的气候类型及其气候特征是什么？</p>', NULL, 0, '<p>气候类型：温带大陆性气候.气候特征：冬冷夏热，全年降水少。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '气候知识');
INSERT INTO `qu` VALUES ('bb4195c345d0484487631a4b521e4502', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】下列国家人口超过1亿的南亚国家是（）', NULL, 1, '世界人口超过一亿的国家，从多到少依次为：中国、印度、美国、印度尼西亚、巴西、巴基斯坦、俄罗斯、孟加拉国、尼日利亚、日本和墨西哥共有11个．其中属于南亚的是印度、巴基斯坦和孟加拉国．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('bc7946cca9544ef287c1a4df45842344', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】著名的亚欧间的海峡是（）', NULL, 0, '被称为“天下咽喉”的土耳其海峡（又称黑海海峡）是连接黑海与地中海的唯一通道，它包括博斯普鲁斯海峡（又叫伊斯坦布尔海峡）、马尔马拉海和达达尼尔海峡（又叫恰纳卡莱海峡）三部分，全长361千米，整个海峡呈东北－西南走向，是亚、欧两洲的分界线。古往今来皆为兵家必争之地，战略地位十分重要', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('bccb1ec908d74d46811fa0c55b1d6e43', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>小王去网吧开会员卡，开卡要20元，小王没找到零钱，就给了网管一张50的，网管找回30元给小王后，小王找到20元零的，给网管20元后，网管把先前的50元还给了他，请问谁亏了？</p>', NULL, 0, '<p>网管亏了30元</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('bd082aa0a7c04762bb94ae20c06b07f8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】中国、日本位于亚洲的（）', NULL, 1, '中国和日本都位于东亚地区．根据题意．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('bd325a5aef7048e5871c8a60001394f3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>当今时代的两大主题是()。</p>', NULL, 0, '<p><label>本题考点：</label>和平与发展是当今时代的两大主题</p>\n<p><label>考点点评：</label>&nbsp;本题考查识记能力，难度一般．牢记相关知识，和平与发展是当今时代两大主题．</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('be7eb38737a84544901f1f3b0d6413be', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '道路交通安全违法行为累积记分的周期是多长时间？', NULL, 0, '《机动车驾驶证申领和使用规定》第七十一条 公安机关交通管理部门对机动车驾驶人的道路交通安全违法行为，除依法给予行政处罚外，实行道路交通安全违法行为累积记分制度，记分周期为12个月，满分为12分。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('bfe09f08170c44d582f9751b2845f627', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '初次申领的机动车驾驶证的有效期为4年。', NULL, 0, '初次申领的机动车驾驶证的有效期6年，每个计分周期均未达到12分的，换发10年的。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c04783ce70524bcdb3a3a5cdc4d0cfeb', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '夜间驾驶机动车在窄路、窄桥会车时正确的做法是使用远光灯。', NULL, 0, '《道路交通安全法实施条例》第四十八条： 在没有中心隔离设施或者没有中心线的道路上，夜间会车应当在距相对方向来车150米以外改用近光灯，在窄路、窄桥与非机动车会车时应当使用近光灯。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c119b25655f245e7a653fd55f7fe41bb', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】泼水节是我国哪个少数民族的传统节日（）。', NULL, 0, '“泼水节是傣族、阿昌族、布朗族、佤族、德昂族以及泰语民族和东南亚地区的传统节日。泼水节又名“浴佛节”，傣语称为“比迈”（意思为新年），西双版纳及德宏地区的傣族又称此节日为“尚罕”和“尚键”，两名称均源于梵语，意为周转、变更和转移，指太阳已经在黄道十二宫运转一周开始向新的一年过渡。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('c1304045e0064618ad660b64727e35ab', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '世界上面积最大的国家是（）。', NULL, 0, '“俄罗斯是陆地面积最大的国家，位于欧洲东部和亚洲北部，横跨欧亚大陆，东濒太平洋，西接波罗的海芬兰湾，东西最长9000公里，南北最宽4000公里，领土面积约1707.54万平方公里。陆地邻国西北面有挪威、芬兰，西面有爱沙尼亚、拉脱维亚、立陶宛、波兰、白俄罗斯。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('c160489406ef475aa39321789f639ddc', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列河流哪一条是世界最长（）。', NULL, 0, '尼罗河最长，其次是亚马逊河，然后长江', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('c24f9337e21d4bf18f1fbadc71351dd5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在道路上靠路边停车过程中如何使用灯光？', NULL, 0, '《道路交通安全法实施条例》第五十七条 机动车应当按照下列规定使用转向灯： (一)向左转弯、向左变更车道、准备超车、驶离停车地点或者掉头时，应当提前开启左转向灯； (二)向右转弯、向右变更车道、超车完毕驶回原车道、靠路边停车时，应当提前开启右转向灯。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c2f0101bb13d4d3abe38654b083c5c8e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】世界上最长的运河是哪一条（）', NULL, 0, '京杭大运河始建于春秋时期，是世界上里程最长、工程最大的古代运河，也是最古老的运河之一，与长城、坎儿井并称为中国古代的三项伟大工程，并且使用至今，是中国古代劳动人民创造的一项伟大工程，是中国文化地位的象征之一。大运河南起余杭（今杭州），北到涿郡（今北京），途经今浙江、江苏、山东、河北四省及天津、北京两市，贯通海河、黄河、淮河、长江、钱塘江五大水系，主要水源为微山湖，大运河全长约1797公里。运河对中国南北地区之间的经济、文化发展与交流，特别是对沿线地区工农业经济的发展起了巨大作用。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('c43edf71dcb243abb13d32df9605a655', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列哪种行为会受到200元以上2000元以下罚款，并处吊销机动车驾驶证？', NULL, 0, '《道路交通安全法》第九十九条　有下列行为之一的，由公安机关交通管理部门处二百元以上二千元以下罚款：\n（一）未取得机动车驾驶证、机动车驾驶证被吊销或者机动车驾驶证被暂扣期间驾驶机动车的；\n（二）将机动车交由未取得机动车驾驶证或者机动车驾驶证被吊销、暂扣的人驾驶的；\n（三）造成交通事故后逃逸，尚不构成犯罪的；\n（四）机动车行驶超过规定时速百分之五十的；（超过规定时速50%）\n（五）强迫机动车驾驶人违反道路交通安全法律、法规和机动车安全驾驶要求驾驶机动车，造成交通事故，尚不构成犯罪的；\n行为人有前款第二项、第四项情形之一的，可以并处吊销机动车驾驶证；有第一项、第三项、第五项至第八项情形之一的，可以并处十五日以下拘留。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c56bd615a5b44b288800b5f067845db3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车通过交叉路口要遵守交通信号。', NULL, 0, '《道路交通安全法》第四十四条：机动车通过交叉路口，应当按照交通信号灯、交通标志、交通标线或者交通警察的指挥通过；通过没有交通信号灯、交通标志、交通标线或者交通警察指挥的交叉路口时，应当减速慢行，并让行人和优先通行的车辆先行。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c5c9df4d43d84396acfd2d84f1bc69a8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '在驾驶技能准考证明的有效期内，科目二和科目三道路驾驶技能考试预约次数不得超过多少次？', NULL, 0, '在驾驶技能准考证明有效期内，科目二和科目三道路驾驶技能考试预约考试的次数不得超过五次。第五次预约考试仍不合格的，已考试合格的其他科目成绩作废。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c619705e4b794c49bf09fa56e87e6bab', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】解释成语：不可思议。</p>', NULL, 0, '<p>不可思议：指无法想象，难以理解。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('c717e33f7a4d497e8a69bf0877c91e0d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><span style=\"color: #000000; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; white-space: normal; background-color: #ffffff; float: none; display: inline;\">若输出的字符串为&nbsp;</span><span class=\"katex\" style=\"margin: 0px; padding: 0px; font-kerning: auto; font-optical-sizing: auto; font-feature-settings: normal; font-variation-settings: normal; font-stretch: normal; font-size: 1.21em; line-height: 1.2; font-family: KaTeX_Main, \'Times New Roman\', serif; white-space: nowrap; text-rendering: auto; color: #000000; background-color: #ffffff;\"><span class=\"katex-mathml\" style=\"margin: 0px; padding: 0px; position: absolute; clip: rect(1px, 1px, 1px, 1px); border-width: 0px; height: 1px; width: 1px; overflow: hidden;\">CSPCSPCSPCSP</span><span class=\"katex-html\" style=\"margin: 0px; padding: 0px; display: inline-block;\" aria-hidden=\"true\"><span class=\"base\" style=\"margin: 0px; padding: 0px; position: relative; display: inline-block;\"><span class=\"mord text\" style=\"margin: 0px; padding: 0px;\"><span class=\"mord texttt\" style=\"margin: 0px; padding: 0px; font-family: KaTeX_Typewriter;\">CSPCSPCSPCSP</span></span></span></span></span><span style=\"color: #000000; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; white-space: normal; background-color: #ffffff; float: none; display: inline;\">，则下列说法正确的是（ ）。</span></p>', NULL, 0, '<p><span style=\"color: #5eb95e; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; text-align: left; white-space: normal; background-color: #ffffff; float: none; display: inline;\">正确答案： D</span></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '计算机编程');
INSERT INTO `qu` VALUES ('c71aeeae981845a3bfdcfc38d34497a0', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】下列河流哪一条是世界最长（）。', NULL, 0, '尼罗河最长，其次是亚马逊河，然后长江', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('c7577ad4d8584ec8b02ac82daa8a5a31', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在没有中心线的城市道路上，最高速度不能超过每小时50公里。', NULL, 0, '《道路交通安全法实施条例》第四十五条：在没有限速标志、标线的道路上，机动车不得超过下列最高行驶速度：\n(一)没有道路中心线的道路，城市道路为每小时30公里，公路为每小时40公里。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c777420b32c14e3cba84dcfb8ee6b4ee', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', 'pig是指猪？', NULL, 0, 'pig的英文拼写即为猪', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('c7d459694fdd47d7991c6866b9eaee8b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<ol style=\"margin: 0px; padding: 0px 0px 0px 1.5em; list-style-position: outside; list-style-type: decimal; color: #000000; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; white-space: normal; background-color: #ffffff;\">\n<li style=\"margin: 0px; padding: 0px;\">若输入的字符串不是空串，则输入的字符串与输出的字符串一定不一样。（）</li>\n</ol>', NULL, 0, '<p><span style=\"color: #5eb95e; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; text-align: left; white-space: normal; background-color: #ffffff; float: none; display: inline;\">正确答案： B</span></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '计算机编程');
INSERT INTO `qu` VALUES ('c8168cf32c8e4b1b95b0d956b2cb159e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '世界上跨东西、南北距离最长的大洲是（）', NULL, 1, '在全球的七大洲中，亚洲是世界上面积最大的一洲，也是南北跨纬度最多，热量差异大； 东西跨经度仅次于南极洲，东西距离最长的大洲；大洋洲是世界上最小的一洲\n考点：本题主要考查大洲和大洋。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('c81bed86ea944ccd853af1f6b4a834d6', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在道路上超车时可以不使用转向灯。', NULL, 0, '《道路交通安全法实施条例》第五十七条 机动车应当按照下列规定使用转向灯：（一）向左转弯、向左变更车道、准备超车、驶离停车地点或者掉头时，应当提前开启左转向灯；（二）向右转弯、向右变更车道、超车完毕驶回原车道、靠路边停车时，应当提前开启右转向灯。\n超车必须使用转向灯，否则极易造成严重的交通事故。题目描述有误，本题答案应为错误。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c8903fbe6a664c448ed919e4f3ae5781', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<ol style=\"margin: 0px; padding: 0px 0px 0px 1.5em; list-style-position: outside; list-style-type: decimal; color: #000000; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; white-space: normal; background-color: #ffffff;\">\n<li style=\"margin: 0px; padding: 0px;\">输入的字符串应当只由大写字母组成，否则在访问数组时可能越界。（ ）</li>\n</ol>', NULL, 0, '<ol class=\"questions\" style=\"margin: 0px; padding: 0px; list-style-type: none; color: #000000; font-family: -apple-system, \'system-ui\', \'San Francisco\', \'Helvetica Neue\', \'Noto Sans CJK SC\', \'Noto Sans CJK\', \'Source Han Sans\', \'PingFang SC\', \'Microsoft YaHei\', sans-serif; font-size: medium; white-space: normal; background-color: #ffffff;\" data-v-605edee2=\"\">\n<li style=\"margin: 0.5em 0px 0px; padding: 0px; display: flex; align-items: baseline;\" data-v-605edee2=\"\">\n<div class=\"question\" style=\"margin: 0px; padding: 0px; flex-grow: 1; overflow: hidden;\" data-v-46e1892e=\"\" data-v-605edee2=\"\">\n<div style=\"margin: 0px; padding: 0px; color: #5eb95e;\" data-v-2d57df92=\"\" data-v-46e1892e=\"\">正确答案： A</div>\n</div>\n</li>\n<li style=\"margin: 0.5em 0px 0px; padding: 0px; display: flex; align-items: baseline;\" data-v-605edee2=\"\">&nbsp;</li>\n</ol>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '计算机编程');
INSERT INTO `qu` VALUES ('c928b30c38c742fb8fa440a741b26c0d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>对未取得驾驶证驾驶机动车的，追究其法律责任。</p>', NULL, 0, '<p>《机动车驾驶证申领和使用规定》第十条，驾驶机动车，应当依法取得机动车驾驶证。<br /><strong>未取得机动车驾驶证、</strong>机动车驾驶证被吊销或者机动车驾驶证被暂扣期间驾驶机动车的，由公安机关交通管理部门处二百元以上二千元以下罚款，可以并处十五日以下拘留。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('c93e2b98a7b447c28755bc7718282fc9', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '公安交通管理部门对驾驶人的交通违法行为除依法给予行政处罚外，实行下列哪种制度？', NULL, 0, '《道路交通安全法》第二十四条：公安机关交通管理部门对机动车驾驶人违反道路交通安全法律、法规的行为，除依法给予行政处罚外，实行累积记分制度。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cac21902890c41de8db1f54960c1e29c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶人的驾驶证损毁后不得驾驶机动车。', NULL, 0, '《道路交通安全法实施条例》第二十八条规定 机动车驾驶人在机动车驾驶证丢失、损毁、超过有效期或者被依法扣留、暂扣期间以及记分达到12分的，不得驾驶机动车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cadd838ce5644a5e8de64e698486e309', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '在道路上临时停车不得妨碍其他车辆和行人通行。', NULL, 0, '《道路交通安全法》第五十六条，机动车应当在规定地点停放。禁止在人行道上停放机动车；但是，依照本法第三十三条规定施划的停车泊位除外。\n在道路上临时停车的，不得妨碍其他车辆和行人通行。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cae8e39074294a4ab8a95d17018a1867', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车行经市区下列哪种道路时不得超车？', NULL, 0, '《道路交通安全法》第四十三条：同车道行驶的机动车，后车应当与前车保持足以采取紧急制动措施的安全距离。有下列情形之一的，不得超车：\n（一）前车正在左转弯、掉头、超车的；\n（二）与对面来车有会车可能的；\n（三）前车为执行紧急任务的警车、消防车、救护车、工程救险车的；\n（四）行经铁路道口、交叉路口、窄桥、弯道、陡坡、隧道、人行横道、市区交通流量大的路段等没有超车条件的。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cb03807f8dbe46dab275beaecf753631', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车通过没有交通信号和管理人员的铁路道口怎样通过？', NULL, 0, '通过无信号控制或无人看守的铁路道口时，要在道口外停车观察，做到一停（在停止线以外停车）、二看（观察左右是否有驶来的列车）、三通过（确认安全后，低速通过）。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cb62cbd93e6a44e3b303fc50493da029', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】运用板块构造学说，分析日本多火山地震的原因。</p>', NULL, 0, '<p>位于欧亚板块、北美板块和太平洋板块的交界处，地壳运动活跃。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('cbb1ac87f94a4091a0e2541995562959', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '2016年10月，习近平总书记在全国国有企业党的建设工作会议上提出，要通过加强完善党对国有企业的领导、加强和改进国有企业党的建设，使国有企业成为（）。', NULL, 0, '党的二十大报告', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('cccb2cb3a9284d2792d6100a949301db', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】我国最大的淡水湖是（）。', NULL, 0, '“我国第一大淡水湖是鄱阳湖，也是中国第二大湖。鄱阳湖地处江西省的北部，长江中下游南岸，承纳赣江、抚河、信江、饶河、修河五大河，流域面积为16.2万平方公里，占江西省国土面积97%左右。鄱阳湖以松门山为界，分为南北两部分，北面为入江水道，南北长173公里，东西最宽处达74公里。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('cd3b504c26a64a289f5c4ba3c9736ec8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '夜间在道路上会车时，距离对向来车多远将远光灯改用近光灯？', NULL, 0, '《道路交通安全法》第四十八条：在没有中心隔离设施或者没有中心线的道路上，机动车遇相对方向来车时应当遵守下列规定：\n(一)减速靠右行驶，并与其他车辆、行人保持必要的安全距离；\n(二)在有障碍的路段，无障碍的一方先行；但有障碍的一方已驶入障碍路段而无障碍的一方未驶入时，有障碍的一方先行；\n(三)在狭窄的坡路，上坡的一方先行；但下坡的一方已行至中途而上坡的一方未上坡时，下坡的一方先行；\n(四)在狭窄的山路，不靠山体的一方先行；\n(五)夜间会车应当在距相对方向来车150米以外改用近光灯，在窄路、窄桥与非机动车会车时应当使用近光灯。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cd63230177f54d0490ac6e7e05133f57', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车超车应该提前开启左转向灯、变换使用远近光灯或鸣喇叭。', NULL, 0, '《道路交通安全法实施条例》第四十七条：机动车超车时，应当提前开启左转向灯、变换使用远、近光灯或者鸣喇叭。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cd8f218ae6b24e4fbc0bfd9edee9a890', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车在夜间道路上发生故障难以移动时要开启危险报警闪光灯、示廓灯、后位灯。', NULL, 0, '《道路交通安全法实施条例》第六十条：机动车在道路上发生故障或者发生交通事故，妨碍交通又难以移动的，应当按照规定开启危险报警闪光灯并在车后50米至100米处设置警告标志，夜间还应当同时开启示廓灯和后位灯。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cde5aa625565471b9d2c94cf24e75bd0', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><a data-v-795acef0=\"\">【自动批阅】</a>解释成语&ldquo;文思敏捷&rdquo;。</p>', NULL, 0, '<p>文思敏捷：指写文章的灵感和思路非常顺畅。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('ce09560839024dc6b37076e110eaee39', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】<a data-v-b2458244=\"\">解释</a>成语：惊心动魄。</p>', NULL, 0, '<p>惊心动魄：形容使人十分惊骇紧张到极点。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('ce689d647e544ad4b9e48fe0e0f7c40f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '例题 1：请以以下材料为基础，结合工作积累，要求以陕西\n电力强化人才队伍建设为题写一篇国家电网工作动态快讯类信息，\n选三个方面展示公司人才培养的亮点和特色举措，要求字数不超\n过 500 字。 材料：国网陕西省电力有限公司关于加强高层次人才队伍\n建设的指导意见\n多年来，公司党委坚决贯彻落实国家电网公司党组部署，\n始终把人才工作作为关系事业发展全局的关键性、根本性问题\n来抓，畅通道、优结构，多措并举打造高素质人才队伍。但依\n然存在人才培养机制不够完善、人才激励效果发挥不佳、人才\n竞争实力不强等问题。目前，公司进入融合发展关键期，需要\n高度重视、高远谋划、高位推动，聚合力、激活力、提实力，\n建设一支职业素养高、业务能力强、业绩贡献大的陕电尖兵，\n为公司高质量发展提供高质量人才保障。\n一、高站位、促协同，形成人才培养合力\n坚持“党委领导、人资归口、专业主责、分级管理”的全\n覆盖人才管理模式，形成人才培养合力。\n— 17 —\n1.坚持党管人才。各级党组织要切实提高政治站位，充分\n认识人才队伍建设在公司发展中的极端重要性，把人才工作摆\n上重要议程。加强组织领导，完善各级人才工作领导小组，定\n期召开人才工作会议，研究重大事项、部署重要工作、解决重\n点问题，为人才成长和发挥作用提供更多机遇和更大空间，促\n进各类人才健康成长、施展才干。（人资部、组织部牵头，各\n部门、各单位主责）\n2.落实专业主体责任。公司人资部门要健全人才发展体系，\n制定人才管理规定，落实人才激励政策，统筹推进人才工作，\n重点抓好高层次人才选推。公司各部门要加强专业人才队伍建\n设，制定差异化专业选评标准，做好专业人才选拔、培养、使\n用、考核，建设专业高层次人才储备库，“一人一策”精准发力。\n（人资部牵头，各部门主责）\n3.落实各级管理责任。各单位要加强人才梯队建设，树立\n人才培养的大局观，为人才发展减负松绑，保障人才时间精力\n有效投入，支持人才站在更高的平台上发挥作用，做好高层次\n人才接续培养和储备。各工区、班站所要注重在现场工作中发\n现人才、立足岗位培养人才，在“师带徒”工作中发挥好导师\n在选题指导、答疑解惑、师道传承等方面的作用。（人资部牵头，\n各单位主责）\n二、定目标、优机制，坚持人才战略引领\n以高层次人才选拔为切入口，明确人才培养发展目标，优\n— 18 —\n化公司专家人才制度，形成高端人才引领带动、员工队伍齐头\n并进的大格局。\n4.明确人才战略目标。2022年，建立各专业高层次人才储\n备库，定制高层次人才精准培养计划。完善专家人才制度体系、\n开展专家人才选拔，专家人才总量达到500人，人才梯队基本形\n成。到2025年，加强高层次人才精准储备培育，实现首席专家\n“零突破”，高层次人才总量突破300人。常态化开展专家人才\n选拔，专家人才总量保持1500人，建成一支数量充足、结构合\n理、技术精湛、能力突出、作风过硬、业绩优秀的专家人才队\n伍。到2030年，力争1人入选中国电科院院士、3人入选首席专\n家，专家人才总量达到2000人，各领域高层次人才竞相迸发，\n关键核心技术人才优势逐步显现，电网权威专家人才显著增加，\n人才竞争实力大幅提升，千军万马钻技术、搞创新、强技能蔚\n然成风，高层次人才数量保持西北领先。（人资部牵头，各部\n门、各单位主责）\n5.优化人才发展体系。互通人才发展通道，“领导职务、\n职员职级、专家人才”三条通道并行互通。支持专家人才竞聘\n领导职务、晋升职员职级，跨通道发展；鼓励业绩突出、专业\n专注的领导人员参加专家人才选拔，入选后进入专家人才通道，\n聘期结束根据工作需要优先转任原职务职级相应层级的工作岗\n位。加强专家人才通道晋级和退出管理，保持专家人才通道动\n态畅通、专家人才能进能出，促进优秀人才脱颖而出。健全专\n— 19 —\n家人才体系，在原技术专家、技能工匠通道建设基础上，面向\n各级单位本部从事专业管理工作的员工增设管理类别、面向县\n公司员工增设县公司级别，调整专业划分、明确责任部门、在\n技术类增设科技研发小类，形成公司“三类六级”（管理领军、\n技术专家、技能工匠三类；国家电网公司一级，省公司二、三\n级，地市公司四、五级，县公司六级）专家人才体系，保持政\n策稳定延续。优化专家人才选评机制，坚持“人资统筹、专业\n主导”，实行“动态管控选评规模”“定期申报选评计划”“方\n案结果双备案”“逐级择优推荐”四项机制，控制总量、逐年\n增选，为高层次人才培养奠定基础。（人资部牵头，各部门、\n各单位主责）\n三、强培育、提质量，提升人才竞争实力\n以高层次人才培养为发力点，建设人才创新高地、培养基\n地，抢抓发展机遇，充分发挥人才作用，提升人才竞争实力。\n6.加强高层次人才精准储备培育。择优建立高层次人才储\n备库，公司各部门穿透摸清专业人才情况，动态建立以各级专\n家人才为基础、青年人才托举人选为补充的高层次人才储备库，\n原则上每个专业高层次人才储备不少于 5 人，其中年龄 40 岁以\n下占比不低于 20%，形成梯次培养态势和人才规模竞争优势。动\n态精准培育专业权威，对标首席专家选评标准，每年公司各部\n门在高层次人才储备库中优选 3 名左右重点培养对象，制定培\n养计划，统筹优势资源安排其参与国家电网公司工作、牵头公\n— 20 —\n司课题攻关和承担重点难点工作，全程跟踪支持促进个人业绩、\n专业影响力提升。加大项目经费支持，入选公司高层次人才储\n备库作为中国电科院院士、首席专家储备培养的，优先揭榜挂\n帅重大科研攻关、重点工程建设和重要课题研究，其中科研人\n员每年安排自主科研经费不低于 50 万元。积极争取贡献陕西智\n慧，公司各部门积极争取国家电网公司科技研发项目、管理创\n新项目、揭榜项目、标准编制、指南编制、制度制定、重大工\n程等工作，以高层次人才储备库重点培养对象为核心，组建专\n家柔性团队集中攻坚克难，展示公司人才实力。依托大赛培养\n高层次技能人才，每年力争承办 3 项以上的国家电网公司、中\n电联、陕西省等省部级技能竞赛和大赛，通过斩获竞赛大奖培\n养省部级高技能人才不少于 10 人。今年重点承办好变电运行、\n继电保护和互联网 ICT 大赛。（人资部牵头，各部门主责）\n7.分类建设人才创新高地和培养基地。依托“两院”（国\n网陕西电科院、经研院）建设科技人才创新高地，组织“两院”\n编制陕电科技人才创新高地试点建设方案，在人才引进、培养\n使用、分类评价、薪酬激励等方面先行先试，探索形成标准化、\n可复制的创新做法和典型经验，在全公司范围内推广。优化博\n士后工作站功能定位，加强与高校博士后流动站合作招生，吸\n引优秀博士进站开展研究工作，聘请公司高层次人才担任企业\n导师。依托国网陕西信通公司建设数字化人才创新高地，组织\n国网陕西信通公司编制陕电数字化人才创新高地试点建设方案，\n— 21 —\n加强信通专业联合创新实验室建设，与华为等软件企业、西安\n各大高校联合孵化新技术、新产品，加快形成一支熟悉信通主\n业核心业务、掌握先进信通技术、能够自主研发的人才队伍。\n依托各单位资源优势建设“公司级”应用型人才培养基地，各\n供电公司、国网陕西超高压公司、国网安康水电厂等单位发挥\n技术技能人才优势、专业优势、现场资源优势，分专业建设公\n司级应用型人才培养基地，促进技术技能传承。依托“两中心”\n（国网陕西技能培训中心、管理培训中心）建设人才培养服务\n基地，国网陕西技能培训中心负责技术技能人才、国网陕西管\n理培训中心负责管理人才，服务公司人才评价、培养、使用和\n管理，服务专家人才上讲台、传帮带，定期组织人才交流、专\n业讲座等活动。依托公司本部培养复合型高层次管理人才，公\n司各部门对标首席专家选评标准，重点发现和培养在本专业领\n域出类拔萃的专业管理人员，在管理创新、科技创新、重点工\n作中培养使用，支持参加国家电网公司专项工作，培养专业领\n军人物。（互联网部、人资部牵头，各部门、各单位主责）\n8.抢抓科技发展改革机遇。抢抓构建新型电力系统重大机\n遇，积极争取国家电网公司新型电力系统科技攻关行动项目，\n打造新优势领域、产出一批大成果，紧紧抓好国家电网公司新\n型电力系统科技攻关行动“2022 专项”3 个承担课题研究攻关，\n加大科技成果转化力度、强化科研人才培养和使用、加强科技\n评价激励，重点培养一批科技研发人才。抢抓科改示范企业改\n— 22 —\n革机遇，将环保中心打造为公司科技成果转化孵化平台，全力\n推进公司现有成熟成果的转化应用。建立以专业部门主导的新\n技术推广应用模式，畅通源头创新、成果转化、市场应用链条，\n结合新技术领域打造一批“拳头产品”，在系统内外推广应用，\n提升技术影响力。激发科技人员创新创效热情，探索设立青年\n创新基金，配置培养导师，引导其承担中长期战略性重大科研\n任务。发挥交大创新港作用，依托公司新型电力系统研究中心，\n发挥与西安交通大学创新港平台的产学研用结合优势，采用骨\n干技术人员带项目轮流入驻创新港的方式，做深做强合作项目\n水平，筹划国家级项目和高等级奖项，创新破难、扩大优势。（互\n联网部牵头，各部门、各单位主责）\n9.丰富人才培养使用方式。加强培训管理，实行专家人才\n聘期内专题年度轮训，每年累计集中培训时间不少于 5 天。组\n织优秀人才走进重点高校、科研院所、重要设备生产厂商开展\n技术学习、交流合作，开拓视野，提升综合能力。加强产学研\n融合，建立人才统筹使用机制、联合培养机制、项目合作机制，\n在国网学堂陕西专区设立专家人才宣传互动专栏，实时更新专\n家人才破解难题、项目研究、学术成果等信息，用人单位、专\n家人才双向选择“结对子”、跨单位挂职帮扶、交流锻炼，坚\n持“难题来源一线、交流紧扣一线、成果服务一线”。加强技\n艺传承，开设“陕电大讲堂”专家人才系列课，聘期内实行“1+N”\n（1 门精品课、N 个传授方向）课程储备计划，定期更新发布，\n— 23 —\n共享、服务于各层级、各专业培训，提升专家人才传授能力。\n搭建人才创新平台，鼓励各单位以高层次人才为核心组建柔性\n团队、技能大师工作室和专家工作室，加大人员、资金支持，\n实行人才梯队配套、科研条件配套、管理机制配套等政策支持，\n赋予人才更大的技术路线决策权、经费使用权和资源调度权，\n为人才作用发挥创造积极条件。（人资部牵头，各部门、各单\n位主责）\n四、强激励、增动力，激发人才队伍活力\n加强各级各类人才综合激励和作风建设，在薪酬待遇、福\n利保障、评先树优、宣传展示等方面持续向优秀人才倾斜。\n10.加大人才培养成效激励。对个人额外增发奖励，首次入\n选中国电科院院士人员额外增加一次性奖励 30 万元、入选首席\n专家人员额外增加一次性奖励 10 万元，公司领导在“两会”上\n颁发证书；入选国家和地方政府选评的省部级及以上人才，公\n司按照政府奖励标准加发同等水平奖励；出台科技创新专项奖\n励指导意见，对承担重大科技项目、获得高等级科技奖励、承\n担高等级技术标准制修订任务等方面的个人和团队给予重奖；\n对竞赛获奖个人和团体按照公司表彰奖励办法和大培训专项奖\n励标准就高兑现。对单位单独核定，各单位按规定执行专家人\n才薪酬待遇和人才称号奖励，公司人力资源部核定并在工资总\n额中单列；其中新增本级别以上人才薪酬待遇增长差额、人才\n称号奖励单独核增。对单位、公司部门考核加分，各单位、公\n— 24 —\n司各部门培养人才入选中国电科院院士、首席专家，在年度业\n绩考核中加分。（人资部、组织部牵头，各单位主责）\n11.强化薪酬保障激励。中国电科院院士，在职期间每年津\n贴 15 万元。退休后可进行学术聘任，期间每年发放 50 万元补\n贴。首席专家，薪酬待遇参照本单位一级职员标准确定。退休\n后可进行学术聘任，期间每年发放 40 万元补贴。二至六级专家\n人才，薪酬待遇分别参照二至六级职员标准确定，按照聘用年\n度本单位二至六级职员平均水平与本人所上岗位正常收入的差\n额核算，实行“当期兑现 80%+延期兑现 20%”，延期兑现部分\n与考核结果挂钩，确保兑现到位。深入推动电科院科技项目收\n益分红激励机制；环保公司做好国资委科改示范，扩大科技成\n果转化应用，通过争取上市多维激励科研人员。（人资部、互\n联网部牵头，各单位主责）\n12.强化人才考核激励。用好业绩考核指挥棒，将高层次人\n才培养和科研攻关转化指标纳入“两院”“两中心”以及相关\n地市公司关键业绩指标，引导各单位多出人才、多出成果、多\n出效益。优化专家人才选评标准，以价值、能力、贡献为导向，\n兼顾类别差异、专业特点、单位业务，以培养支撑公司发展、\n满足专业需求的人才为目标，科学优化专业选评标准。以年度\n工作任务书贯穿人才培养、使用、考核各环节，形成闭环管理。\n严格公司专家人才考核，按照“归口部门分级组织、责任部门\n具体实施”的方式从严考核。聘期内年度考核结果均为优秀且\n— 25 —\n符合选拔必备条件的，经评估并履行决策程序后，期满可直接\n续聘原称号，并作为专家晋级依据。年度考核不合格，取消称\n号和相应待遇。加强激励政策落地督导，定期开展人才待遇落\n地督促和指导，确保人才津贴待遇按标准发放到位，确保“师\n带徒”依据考评结果兑现到位，确保高层次人才差异化体检、\n荣誉类疗养、企业年金缴费标准增加等福利保障待遇落实到位。\n（人资部牵头，各部门、各单位主责）\n13.强化人才综合激励。深化各级党委联系服务专家机制，\n公司领导负责联系国家级人才、班子成员根据职责分工联系高\n层次人才，各单位党政一把手负责联系本单位高层次人才、班\n子成员分工联系本单位及以上级别人才，将听取专家意见建议\n作为日常联系、走访慰问的重要内容，支持帮助人才解决问题、\n发挥作用。建立人才意见反馈机制，各单位每年至少召开一次\n人才座谈会，定期开展人才工作调研和走访工作，畅通人才建\n言献策渠道，形成意见建议定期研究反馈机制。加大人才宣传\n力度，大力弘扬科学精神、创新精神、工匠精神，加大高层次\n人才宣传力度，挖掘优秀人才和攻关团队典型，在公司新闻网\n站、卓越陕电公众号、各基层单位办公场所专题宣传，营造尊\n重知识、尊重人才、尊重技能、尊重创造的浓厚氛围。做好人\n才配套保障，在人才管理上优化流程、提高效率、放权赋能；\n在人才使用上，合理精简事务性、重复性工作安排，为人才发\n展提供适合的科研环境和配套保障；进一步完善科技项目立项\n— 26 —\n机制，逐步实行“申报+下达”相结合的方式，提高立项质量和\n效率，促进人才聚精会神在科研、生产一线，发挥更大作用、\n作出更大成绩、解决更多难题。（组织部、人资部、互联网部、\n宣传部牵头，各部门、各单位主责）\n14.加强人才队伍作风建设。各级各类人才要牢牢把握公司\n高质量发展主题，强化政治意识、大局意识，紧扣“四抓四强”\n工作主线，树立强烈的事业心和责任感，坚持以“一板一眼、\n一丝不苟、严精细实、专业专注”的优良作风，稳住心神、保\n持定力、深耕专业，在重点工作、重大项目、科技创新等大战\n大考中显身手、展作为、建新功。积极适应公司创新发展需要，\n密切关注新知识、新技术，勇于创新、敢为人先、扛牢责任，\n发挥专业引领和表率作用。（人资部、组织部牵头，各部门、各\n单位主责）', NULL, 0, '：国网陕西电力强化人才队伍建设。从人才选树培\n养、价值充分发挥、畅通建言渠道三方面入手，完善工作机制，\n激发队伍活力，支撑陕西电力高质量融合发展。加强高层次人才\n培养。按照每个专业不少于 5 人的原则，动态建立高层次人才储\n备库，对标国网首席专家选评标准进行“一人一策”培育，对内\n优先挂帅重大科研攻关和重点项目研究，对外带项目入驻西安交\n通大学产学研用基地，提升人才科研能力。搭建发挥价值平台。\n整合多专业人才，成立 37 个专家团队，根据不同专业特长，与生\n— 27 —\n— 28 —\n产单位进行结对共建，定期驻点生产单位基建现场、配网改造、\n设备检修一线，研究解决现场技术难题。畅通建言献策渠道。建\n立各级党委联系服务专家人才机制，党政主要负责同志负责联系\n高层次人才，班子成员按照分工联系其他专家人才，每年至少召\n开一次专家人才座谈会，倾听诉求建议，帮助解决问题，促进发\n挥作用。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '党政建设');
INSERT INTO `qu` VALUES ('ce6a147736394b9c833d51c81730bb23', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】西亚波斯湾沿岸比较富裕，其原因是（）', NULL, 1, '西亚波斯湾沿岸国家比较富裕，是因为大量出口石油资源．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('cea0ede781d748c8bcb300bd71612430', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车通过窄路、窄桥时，最高速度不能超过多少？', NULL, 0, '机动车行驶中遇有下列情形之一的，最高行驶速度不得超过每小时30公里，其中拖拉机、电瓶车、轮式专用机械车不得超过每小时15公里：　　\n（一）进出非机动车道，通过铁路道口、急弯路、窄路、窄桥时；　　\n（二）掉头、转弯、下陡坡时；　　\n（三）遇雾、雨、雪、沙尘、冰雹，能见度在50米以内时；　　\n（四）在冰雪、泥泞的道路上行驶时；', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('cf185f1a0f6e4e1bbb7dfb8d2588ac2e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】经纬网的用途是什么', NULL, 0, '确定地球表面某一点的位置', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('cfe7c139d762415da4ca93d6013afb80', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车下陡坡、转弯、掉头时，最高速度不能超过多少？', NULL, 0, '机动车行驶中遇有下列情形之一的，最高行驶速度不得超过每小时30公里，其中拖拉机、电瓶车、轮式专用机械车不得超过每小时15公里：　　\n（一）进出非机动车道，通过铁路道口、急弯路、窄路、窄桥时；　　\n（二）掉头、转弯、下陡坡时；　　\n（三）遇雾、雨、雪、沙尘、冰雹，能见度在50米以内时；　　\n（四）在冰雪、泥泞的道路上行驶时；', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('d0a45ddcf0cc4f06bcad063d95820d4b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>四个人 ABCD 过桥，一次最多能过两个人，他们的手电能维持十七分钟，每个人所需的时间分别为 1、2、5、10；求最快可以多长时间全部过桥？</p>', NULL, 0, '<p>最快需要 17 分钟。过程如下：A 和 B 先过（2 分钟），A 回来（1 分钟），C 和 D 一起过（10 分钟），B 回来（2 分钟）接 A，A 和 B 一起（2 分钟）。T = 2 + 1 + 10 + 2 + 2 = 17 min。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '数学知识');
INSERT INTO `qu` VALUES ('d1d3eac98cdb475ca3006ea59e6d5699', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】经纬网的用途是什么', NULL, 0, '确定地球表面某一点的位置', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('d3ee73dd3d914dbaa94760315d637b3d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>未取得驾驶证的学员在道路上学习驾驶技能，下列哪种做法是正确的？</p>', NULL, 0, '<p>《机动车驾驶证申领和使用规定》第四十二条，申请人在道路上学习驾驶，应当随身携带学习驾驶证明，使用教练车或者学车专用标识签注的自学用车，在教练员或者学车专用标识签注的指导人员随车指导下，按照公安机关交通管理部门指定的路线、时间进行。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('d481d614f7a74465829cf380f297ee0c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车通过没有交通信号的交叉路口怎样行驶？', NULL, 0, '驾驶机动车通过没有交通信号灯控制的路口时，应在距路口50-100米时减速，行至路口时仔细观察左右两侧道路交通情况，减速或停车瞭望，做到“一看，二慢、三通过”，直行车辆优先通行。遇到有停车让行标志的路口，要停车观察主路情况，确认安全后再通过。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('d4d450cc97d54cb09a9526c5b687c536', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '沙特阿拉伯的贝都因人，居住在帐篷里，穿着宽大的袍子，过着游牧生活，主要原因是（）', NULL, 0, '沙特阿拉伯的贝都因人主要居住在西亚和北非地区，由于西亚和北非形成了炎热干燥的热带沙漠气候，沙特阿拉伯的贝都因人多喜欢穿白色宽大的长袍，白色可以反射较强的太阳光线，长袍可以阻挡强劲的风沙，住在帐篷里，是为了适应逐水草而居的游牧生活', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('d4e72144095d479b9b25cadfd45a293f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】我国最北面的城市是哪个（）', NULL, 0, '漠河市，隶属黑龙江省大兴安岭地区。 [1]  地处黑龙江省北部。西与内蒙古自治区呼伦贝尔市额尔古纳市为邻，南与内蒙古自治区根河市和呼中区交界，东与塔河县接壤，北隔黑龙江与俄罗斯外贝加尔边疆区（原赤塔州）和阿穆尔州相望，是中国最北端的县级行政区；地势南高北低，南北呈坡降趋势，属于寒温带大陆性季风气候。下辖6个镇，总面积18427平方千米。 [2]  根据第七次人口普查数据，截至2020年11月1日零时，漠河市常住人口为54036人。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('d56b7d164cdc4334bef14e759e319c3a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '机动车遇有停止信号时，应停在何处？', NULL, 0, '根据《道路交通安全法实施条例》第五十一条规定，机动车通过有交通信号灯控制的交叉路口，应当按照下列规定通行：\n（五）遇停止信号时，依次停在停止线以外。没有停止线的，停在路口以外。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('d5da46857db946ed944d201fa249d6a9', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】石头城是对我国哪座城市的美称（）。', NULL, 0, '石头城中国地域名，三大石头城分别是： 南京石头城（在江苏南京清凉山）、新疆石头城（在新疆塔什库尔干塔吉克县）、辽阳石头城（在辽宁辽阳市东）。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('d75ac866a5d847fa9f39cd18c7af72fa', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】南极洲的代表动物是（）', NULL, 0, '南极企鹅', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('d7b263c1cda4456db1c1468f00d1fa73', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】我国面积最大的湖泊是（）。', NULL, 0, '青海湖是我国最大的湖泊，它是一个咸水湖，面积约4450平方公里，说起来也不小了，但是如果把它放到全世界范围来看的话，青海湖实际上并非大型湖泊，单就面积而言，在全世界排名第34位，和我国国土面积世界第三的位置很不相称，世界最大湖泊里海的面积（38万平方公里），就相当于84个青海湖。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('d80b1177c88d4275a63cd408c357664c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Jack likes carrots.</p>', NULL, 0, '<p>But I don&rsquo;t like tomatoes.Carrots are my favourite.</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('da7b62c3dbd949888f8e19d294ed90cd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶人连续驾驶不得超过多长时间？', NULL, 0, '《道路交通安全法实施条例》第六十二条：连续驾驶机动车超过4小时应停车休息，停车休息时间不少于20分钟。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('da7f78889c1446718ef5acd61b53b19e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】西亚波斯湾沿岸比较富裕，其原因是（）', NULL, 1, '西亚波斯湾沿岸国家比较富裕，是因为大量出口石油资源．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('dcce5274f1ac43b196809f1f0ace36a3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车遇有前方交叉路口交通阻塞时怎么办？', NULL, 0, '《道路交通安全法实施条例》第五十三条：机动车遇有前方交叉路口交通阻塞时，应当依次停在路口以外等候，不得进入路口。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('dd38d23c395b446f878d47dacf7d0fff', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '同车道行驶的车辆遇前车有下列哪种情形时不得超车？', NULL, 0, '《道路交通安全法》第四十三条：同车道行驶的机动车，后车应当与前车保持足以采取紧急制动措施的安全距离。有下列情形之一的，不得超车：\n（一）前车正在左转弯、掉头、超车的；\n（二）与对面来车有会车可能的；\n（三）前车为执行紧急任务的警车、消防车、救护车、工程救险车的；\n（四）行经铁路道口、交叉路口、窄桥、弯道、陡坡、隧道、人行横道、市区交通流量大的路段等没有超车条件的。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('dddd0101c95b44409907656c2291111b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '行车中遇到后方车辆要求超车时，应怎样做？', NULL, 0, '行车中遇后方车辆发出超车信号时，若具备让车条件，及时开启右转向灯，减速靠右让行，必要时辅以手势示意让超，不得故意不让或让路不让速。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('de86776fbcaf424791bee2445443a129', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】世界气温分布规律（纬度、海陆、地形三大因素阐述）', NULL, 0, '(1)低纬度气温高，高纬度气温低(纬度因素)\n(2) 同纬度地带，夏季陆地气温高，海洋气温低;冬季相反。(海陆因素)\n(3)在山地，气温随着海拔升高而降低。(地形因素)', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('de9e4f6598e449ccb4a82533a2fab283', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在没有交通信号的路口遇到前方车辆缓慢行驶时要依次交替通行。', NULL, 0, '《道路交通安全法》第四十五条明确规定：在车道减少的路段、路口，或者在没有交通信号灯、交通标志、交通标线或者交通警察指挥的交叉路口遇到停车排队等候或者缓慢行驶时，机动车应当依次交替通行。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('df1f8c610ef449378839098c9fce5c07', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '服用国家管制的精神药品可以短途驾驶机动车。', NULL, 0, '《道路交通安全法》第二十二条规定：饮酒、服用国家管制的精神药品或者麻醉药品，或者患有妨碍安全驾驶机动车的疾病，或者过度疲劳影响安全驾驶的，不得驾驶机动车。本题题干表述有误，因此本题答案应为错误。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('e0171593dbe34c03a15f1fcae101c86f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>在实习期内驾驶机动车的，应当在车身后部粘贴或者悬挂哪种标志？</p>', NULL, 0, '<p>《机动车驾驶证申领和使用规定》第七十六条 机动车驾驶人初次取得汽车类准驾车型或者初次取得摩托车类准驾车型后的12个月为实习期。<br />在实习期内驾驶机动车的，应当在车身后部粘贴或者<strong>悬挂统一式样的实习标志</strong>。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('e13d501b4c4448d4a668cd4e279addd5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '社会车辆距离消防栓或者消防队(站)门前30米以内的路段不能停车。', NULL, 0, '【口五站三】距离消防站门前30米以内路段不得停车。根据《道路安全法实施条例》第六十三条，机动车在道路上临时停车应当遵守下列规定：\n（2）交叉路口、铁路道口、急转弯、宽度不足4米的窄路、桥梁、陡坡、隧道以及距离上述地点50米以内的路段，不得停车；【口5】\n（3）公共汽车站、急救站、加油站、消防栓或者消防队（站）门前以及距离上述地点30米以内的路段，除使用上述设施的以外，不得停车；【站3】', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('e243b3bf70a648ec8da08c93f55af26d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>&ldquo;李杜文章在，光芒万丈长&rdquo;，这里的&rdquo;李杜&rdquo;指的是（）和（）。</p>\n<p>此题演示无序作答，为演示方便提供答案：李白、杜甫。</p>', NULL, 0, '<p>李杜文章在,光芒万丈长中的李杜指的是李白和杜甫。出自韩愈的《调张籍》，此诗热情地赞美盛唐诗人李白和杜甫的诗文，表现出作者对他们的高度倾慕之情。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('e2ea1f15186f4d38b40952c4bc5b9b70', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车通过铁路道口时，最高速度不能超过多少？', NULL, 0, '机动车行驶中遇有下列情形之一的，最高行驶速度不得超过每小时30公里，其中拖拉机、电瓶车、轮式专用机械车不得超过每小时15公里：　　\n（一）进出非机动车道，通过铁路道口、急弯路、窄路、窄桥时；　　\n（二）掉头、转弯、下陡坡时；　　\n（三）遇雾、雨、雪、沙尘、冰雹，能见度在50米以内时；　　\n（四）在冰雪、泥泞的道路上行驶时；', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('e4ef758c45ca4ee3bb14b834ab7563de', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '下列属于四大名花的是（）', NULL, 1, '四大名花：牡丹、菊花、水仙、山茶。', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '语文知识');
INSERT INTO `qu` VALUES ('e5195111de994630a699fc8995f3341d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【<a data-v-b2458244=\"\">自动批阅】</a>乞拉朋齐被称为&ldquo;世界雨极&rdquo;，试分析其降水多的原因。</p>', NULL, 0, '<p>乞拉朋齐地处山地的迎风坡，来自印度洋的暖湿气流受山地阻挡被迫抬升，形成地形。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('e575efb3bcb64edfa0722c3d7fdc5e48', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】<a data-v-b2458244=\"\">解释</a>成语：焕然一新。</p>', NULL, 0, '<p>焕然一新：改变旧日面貌，出现崭新的气象</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '成语解释');
INSERT INTO `qu` VALUES ('e6972780de4b4407bd3e571e0c995139', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】下列国家人口超过1亿的南亚国家是（）', NULL, 1, '世界人口超过一亿的国家，从多到少依次为：中国、印度、美国、印度尼西亚、巴西、巴基斯坦、俄罗斯、孟加拉国、尼日利亚、日本和墨西哥共有11个．其中属于南亚的是印度、巴基斯坦和孟加拉国．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('e6faf9c4d0d74206bf569b785a443bed', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】我国最北面的城市是哪个（）', NULL, 0, '漠河市，隶属黑龙江省大兴安岭地区。 [1]  地处黑龙江省北部。西与内蒙古自治区呼伦贝尔市额尔古纳市为邻，南与内蒙古自治区根河市和呼中区交界，东与塔河县接壤，北隔黑龙江与俄罗斯外贝加尔边疆区（原赤塔州）和阿穆尔州相望，是中国最北端的县级行政区；地势南高北低，南北呈坡降趋势，属于寒温带大陆性季风气候。下辖6个镇，总面积18427平方千米。 [2]  根据第七次人口普查数据，截至2020年11月1日零时，漠河市常住人口为54036人。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('e76c1ff5ef234c7da6463916ae6a0f76', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p><strong>这种标志的作用是警告车辆驾驶人前方有危险，谨慎通行。</strong></p>', NULL, 0, '<p>警告标志的作用是警告车辆驾驶人、行人前方有危险，道路使用者需谨慎通过。警告标志的颜色为黄底、黑边、黑图形；形状为等边三角形（顶角朝上）或矩形。个别标志例外。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('e792f59b693c43d1af6a15a69cd2166f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【自动批阅】分析日本河流短小，水流湍急，水能资源丰富的原因。</p>', NULL, 0, '<p>日本地形以山地、丘陵为主，南北狭长，因此河流短小，水流湍急；日本是地处东亚季风区的岛国，降水丰富，河流水量大，且落差大，水能资源丰富。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('e90475bdc82d49cdaac7b6a29c068c6c', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>1+1= 3 吗？</p>', NULL, 0, '<p>略</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '计算机编程');
INSERT INTO `qu` VALUES ('e9ffef4ad4024293a92a7790afd64a43', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【<a data-v-b2458244=\"\">自动批阅】</a>南半球的等温线比北半球的等温线平直，试分析其原因。</p>', NULL, 0, '<p>南半球海洋面积广</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('eba844567d834875b75693aea2d57caf', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '说明我国疆域辽阔的优势', NULL, 0, '疆域面积大、资源丰富\n\n疆界长、邻国多、利于发展对外贸易\n\n各地气候差异大，利于农业的多样化发展和旅游业的发展', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '中国常识');
INSERT INTO `qu` VALUES ('ec8e6ca006f8472f9b933f8bb8fbe6db', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】南北半球、东西半球的怎样划分的', NULL, 0, '南北半球的分界线是:赤道。东西半球的分界线是: 20° w和160° E组成的经线圈。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('ed0df44a1df84213a9f23601993c3233', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '《道路交通安全法》第二十五条，全国实行统一的道路交通信号。交通信号包括交通信号灯、交通标志、交通标线和交通警察的指挥。', NULL, 0, '《道路交通安全法》第二十五条，全国实行统一的道路交通信号。交通信号包括交通信号灯、交通标志、交通标线和交通警察的指挥。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('ed4499d413874fe9b3f491ef62a1f0b4', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】我国少数民族分布最多的省份是（）。', NULL, 0, '云南是中国民族种类最多的省份，除汉族以外，人口在6000人以上的世居少数民族有25个。其中（按人口数多少为序），15个民族为云南特有，人口数均占全国该民族总人口的80%以上。\n\n2015年末，全省少数民族人口数达1583.3万人，占全省人口总数的33.4%，是全国少数民族人口数超过千万的3个省区之一。全省少数民族人口数超过100万的有6个；超过10万不到100万的有9个；超过1万不到10万的有8个；超过6000不到1万的2个。云南少数民族交错分布，表现为大杂居与小聚居，彝族、回族在全省大多数县均有分布。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('edf3fba0b93742da8b7931e537783190', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '亚洲人中分布不是很均匀，其中人中较稀疏的部分是（）', NULL, 0, '人口稠密地区都处在中低纬度、近海、平原地区，亚洲人口稀疏的地区在纬度位置较高的北亚，沙漠广布的西亚及气候干旱的中亚地区．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('ee11d2d88bf04f06af2d7cf9291180be', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】人们把社会生产的各个部门划分为三类产业，下列属于第三产业的是（）', NULL, 1, '通常人们把生产的各部门划分为三类产业．农业是第一产业，包括种植业、林业、畜牧业、渔业等；工业和建筑业是第二产业；流通部门和服务部门是第三产业', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('ef7573e7a7494520b06f3662058f8d88', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '党的二十大的主题是：高举中国特色社会主义伟大旗帜，全面贯彻新时代中国特色社会主义思想，弘扬（），自信自强、守正创新，踔厉奋发、勇毅前行，为全面建设社会主义现代化国家、全面推进中华民族伟大复兴而团结奋斗。', NULL, 0, '党的二十大报告', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '政治知识');
INSERT INTO `qu` VALUES ('ef9c783eec6c4f07861cca1974b359eb', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】泼水节是我国哪个少数民族的传统节日（）。', NULL, 0, '“泼水节是傣族、阿昌族、布朗族、佤族、德昂族以及泰语民族和东南亚地区的传统节日。泼水节又名“浴佛节”，傣语称为“比迈”（意思为新年），西双版纳及德宏地区的傣族又称此节日为“尚罕”和“尚键”，两名称均源于梵语，意为周转、变更和转移，指太阳已经在黄道十二宫运转一周开始向新的一年过渡。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('f0ebd095f2c04f5fa94256695db9f07e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】亚洲气候的分布特点有哪些？</p>', NULL, 0, '<p>①复杂多样；②大陆性气候分布广；③季风气候显著。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '气候知识');
INSERT INTO `qu` VALUES ('f11f2850f48741ef88196bb637b3ffc5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】人口自然增长率有可能出现负值的大洲是哪个？试分析人口增长慢有可能存在的问题及解決措施。</p>', NULL, 0, '<p>人口自然增长率有可能出现负值的大洲是欧洲。问题：①人口老龄化；②劳动力短缺；③国防兵源不足；④社会养老负担过重。措施：鼓励生育。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '政治知识');
INSERT INTO `qu` VALUES ('f27d7c56ca3d473087164fb47241725b', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】沙特阿拉伯的贝都因人，居住在帐篷里，穿着宽大的袍子，过着游牧生活，主要原因是（）', NULL, 0, '沙特阿拉伯的贝都因人主要居住在西亚和北非地区，由于西亚和北非形成了炎热干燥的热带沙漠气候，沙特阿拉伯的贝都因人多喜欢穿白色宽大的长袍，白色可以反射较强的太阳光线，长袍可以阻挡强劲的风沙，住在帐篷里，是为了适应逐水草而居的游牧生活', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '地理知识');
INSERT INTO `qu` VALUES ('f27db377b6784bafa9eb1bdd93d770e8', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '绩效考评指标的来源包括（　　）', NULL, 1, '在进行绩效考评指标体系设计时，首先要搞清楚绩效考评的指标来源，这是指标设计的前提和基础。一般而言，绩效考评指标的来源主要包括以下三个方面：(1)组织战略与经营规划；(2)部门职能与岗位职责；(3)绩效短板与不足。', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '企业培训与制度');
INSERT INTO `qu` VALUES ('f282e5f96e1a43baa9130781868227ab', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】乞拉朋齐被称为&ldquo;世界雨极&rdquo;，试分析其降水多的原因。</p>', NULL, 0, '<p>乞拉朋齐地处山地的迎风坡，来自印度洋的暖湿气流受山地阻挡被迫抬升，形成地形。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '地理知识');
INSERT INTO `qu` VALUES ('f29e898f346e41ada9c98eda58e5b473', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>【简答题自动批阅+人工确认】分析亚洲是世界第一大洲的原因有哪些？</p>', NULL, 0, '<p>①面积最大；②跨纬度最广；③东西距离最长。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '亚洲知识');
INSERT INTO `qu` VALUES ('f2ef10adbd8045228f6d0921c419d064', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '请罗列出豪放派诗人_________________。', NULL, 1, '苏轼、辛弃疾', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '语文知识');
INSERT INTO `qu` VALUES ('f31fba43ec1e4d37803cb326c9db6b5f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>请罗列出唐代诗人李白的四部作品。</p>', NULL, 0, '<p>李白深受黄老列庄思想影响，有《李太白集》传世，诗作中多以醉时写的，代表作有《望庐山瀑布》《行路难》《蜀道难》《将进酒》《梁甫吟》《早发白帝城》等多首。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '语文知识');
INSERT INTO `qu` VALUES ('f32288b64ff64ff29cf5ac8890ccd333', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>驾驶机动车违反道路交通安全法律法规发生交通事故属于交通违章行为。</p>', NULL, 0, '<p>驾驶机动车在道路上<strong>违反道路交通安全法的行为</strong>属于<strong>违法行为</strong>。<br />依据《道路交通安全法》第二条规定，中华人民共和国境内的车辆驾驶人、行人、乘车人以及与道路交通活动有关的单位和个人，都应当遵守本法。<br />第八十八条规定，对道路交通安全<strong>违法行为</strong>的处罚种类包括：警告、罚款、暂扣或者吊销机动车驾驶证、拘留。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('f3b05dfd35c248a6af6ed0097b69a768', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Max and Bill both like to ()</p>', NULL, 0, '<p>Every Sunday morning Bill and I play computer games.</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '英语知识');
INSERT INTO `qu` VALUES ('f3c1d614bc3e473c864cb593f718737f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试+训练】下列河流哪一条是世界最长（）。', NULL, 0, '尼罗河最长，其次是亚马逊河，然后长江', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('f53c81b561b14148b07cdaf1ff26f99a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>薪酬市场调查的主要方法有（　　）</p>', NULL, 1, '<p>薪酬市场调查的主要方法有：问卷调查法、面谈调查法、文献收集法、电话调查法。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '经济知识');
INSERT INTO `qu` VALUES ('f53c9e9b91b84ce5a3d7da28b3d11bbf', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车上路前应当检查车辆安全技术性能。', NULL, 0, '《道路交通安全法》第二十一条规定：驾驶人驾驶机动车上道路行驶前，应当对机动车的安全技术性能进行认真检查；不得驾驶安全设施不全或者机件不符合技术标准等具有安全隐患的机动车。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('f6135ba3e43e4197ad63725defab5fa3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于训练】我国最大的淡水湖是（）。', NULL, 0, '“我国第一大淡水湖是鄱阳湖，也是中国第二大湖。鄱阳湖地处江西省的北部，长江中下游南岸，承纳赣江、抚河、信江、饶河、修河五大河，流域面积为16.2万平方公里，占江西省国土面积97%左右。鄱阳湖以松门山为界，分为南北两部分，北面为入江水道，南北长173公里，东西最宽处达74公里。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('f651657cef734285ae2ce13eade8d12e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '道路交通标线分为指示标线、警告标线、禁止标线。', NULL, 0, '《道路交通安全法实施条例》第三十条 交通标志分为：指示标志、警告标志、禁令标志、指路标志、旅游区标志、道路施工安全标志和辅助标志。 道路交通标线分为：指示标线、警告标线、禁止标线。\n', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('f653cb7e73d14b69abb55b3e8fe129a3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '亚洲为亚洲为什么是世界第一大洲什么是世界第一大洲', NULL, 0, '面积4400万平方千米，世界上最大的大洲\n\n跨纬度最广的大洲\n\n东西距离最长的大洲\n\n人口最多的大洲', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '亚洲知识');
INSERT INTO `qu` VALUES ('f6a3abc6998c4615885e42fef3351615', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>驾驶报废机动车上路行驶的驾驶人，除按规定罚款外，还要受到哪种处理？</p>', NULL, 0, '<p>根据《道路交通安全法》规定，驾驶拼装的机动车或者已达到报废标准的机动车上道路行驶的，公安机关交通管理部门应当予以收缴，强制报废。<strong>对驾驶前款所列机动车上道路行驶的驾驶人，处200元以上2000元以下罚款，并吊销机动车驾驶证。</strong></p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('f6f63c1acfab4cb594174bf7c52fea2e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '请罗列出中国古代书法四大家___________________。', NULL, 1, '中国书法四大家，一般的是指“颜、柳、欧、赵”楷书四体的创始人：颜真卿、柳公权、欧阳询和赵孟頫。\n颜真卿，唐朝名臣、书法家，颜真卿书法精妙，擅长行、楷。初学褚遂良，后师从张旭，得其笔法。其正楷端庄雄伟，行书气势遒劲，创“颜体”楷书。\n柳公权的书法以楷书著称，初学王羲之，后来遍观唐代名家书法，吸取了颜真卿、欧阳询之长，溶汇新意，自创独树一帜的“柳体”，以骨力劲健见长。\n欧阳询，唐朝著名书法家，官员，楷书四大家之一，南梁征南大将军欧阳頠之孙，南陈左卫将军欧阳纥之子，南朝梁太平二年（公元557年）出生于衡州（今湖南衡阳），祖籍潭州临湘（今湖南长沙）。\n赵孟頫博学多才，能诗善文，懂经济，工书法，精绘艺，擅金石，通律吕，解鉴赏。尤其以书法和绘画成就最高。在绘画上，他开创元代新画风，被称为“元人冠冕”。', '2024-05-29 15:47:01', NULL, NULL, NULL, 5, '语文知识');
INSERT INTO `qu` VALUES ('f703e4148f294f5bbc683591ffad0cd1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在道路上向左变更车道时如何使用灯光？', NULL, 0, '《道路交通安全法实施条例》第五十七条规定，机动车应当按照下列规定使用转向灯：\n（一）向左转弯、向左变更车道、准备超车、驶离停车地点或者掉头时，应当提前开启左转向灯；\n（二）向右转弯、向右变更车道、超车完毕驶回原车道、靠路边停车时，应当提前开启右转向灯。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('f77f7746fd164aa99c6f2063b2d5c985', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车通过窄路、窄桥时的最高速度不能超过每小时30公里。', NULL, 0, '机动车行驶中遇有下列情形之一的，最高行驶速度不得超过每小时30公里，其中拖拉机、电瓶车、轮式专用机械车不得超过每小时15公里：　　\n（一）进出非机动车道，通过铁路道口、急弯路、窄路、窄桥时；　　\n（二）掉头、转弯、下陡坡时；　　\n（三）遇雾、雨、雪、沙尘、冰雹，能见度在50米以内时；　　\n（四）在冰雪、泥泞的道路上行驶时。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('f80aa11cbbb54294ba1646c732607126', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '以下英文四只脚的动物有（）', NULL, 0, '全部都是', '2024-05-29 15:47:01', NULL, NULL, NULL, 2, '动物知识');
INSERT INTO `qu` VALUES ('f9e0726e82cb40289f96a929987296e9', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车行经下列哪种路段时不得超车？', NULL, 0, '《道路交通安全法》第四十三条 同车道行驶的机动车，后车应当与前车保持足以采取紧急制动措施的安全距离。有下列情形之一的，不得超车：\n（一）前车正在左转弯、掉头、超车的；\n（二）与对面来车有会车可能的；\n（三）前车为执行紧急任务的警车、消防车、救护车、工程救险车的；\n（四）行经铁路道口、交叉路口、窄桥、弯道、陡坡、隧道、人行横道、市区交通流量大的路段等没有超车条件的。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('fa223b30c8144440baa50130cbce6629', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '低能见度气象条件下，驾驶机动车在高速公路上不按规定行驶的，一次记多少分？', NULL, 0, '《道路交通安全违法行为记分分值》机动车驾驶人有下列违法行为之一，一次记6分：（九）低能见度气象条件下，驾驶机动车在高速公路上不按规定行驶的；', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('fb4b2dfbda2848da990cfdf1f0eff425', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '在路口右转弯遇同车道前车等候放行信号时如何行驶？', NULL, 0, '《道路交通安全法实施条例》第五十一条：机动车通过有交通信号灯控制的交叉路口，应当按照下列规定通行，向右转弯遇有同车道前车正在等候放行信号时，依次停车等候。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('fbb82d91eb094350aa41ddbf6458e419', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>下面属于唐代诗人李白的作品的是（）</p>\n<p><img src=\"https://files.yfhl.net/2023/9/22/1695374042914-d1b7e144.jpg\" alt=\"\" width=\"636\" height=\"500\" /></p>', NULL, 0, '<p>《将进酒》为李白作品，《登高》为杜甫作品，《琵琶行》、《长恨歌》为白居易作品。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '语文知识');
INSERT INTO `qu` VALUES ('fbe1eb99f0e446f280074cd4a5fc7478', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>Jack and Jane like Monday.</p>', NULL, 0, '<p>My name is Jack. I am twelve years old. My favourite day is Monday.</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '英语知识');
INSERT INTO `qu` VALUES ('fbf302624fd14e75a940afa7fd07d0cb', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车遇到前方车辆停车排队等候或缓慢行驶时怎么办？', NULL, 0, '驾驶车辆遇到前方车辆行进缓慢或道路、路口因故堵塞时，应减速或停车，依次缓慢行驶或耐心排队等待。即便是绿灯亮，也要依次停在路口外等候，不得进入路口或停在路口内等候，以免加剧阻塞或被夹在路口内进退两难。\n《道路交通安全法》第四十五条：机动车遇有前方车辆停车排队等候或者缓慢行驶时，不得借道超车或者占用对面车道，不得穿插等候的车辆。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('fc4c68337547424ca09282fd9e2dab9a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】下列国家人口超过1亿的南亚国家是（）', NULL, 1, '世界人口超过一亿的国家，从多到少依次为：中国、印度、美国、印度尼西亚、巴西、巴基斯坦、俄罗斯、孟加拉国、尼日利亚、日本和墨西哥共有11个．其中属于南亚的是印度、巴基斯坦和孟加拉国．', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '亚洲知识');
INSERT INTO `qu` VALUES ('fd2e345ad9ce4e068b6ac5cb4d2b2894', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车在没有中心线的公路上，最高速度不能超过每小时70公里。', NULL, 0, '没有中心线的公路，限速要求≤40公里/小时。《道路交通安全法实施条例》第四十五条：机动车在道路上行驶不得超过限速标志、标线标明的速度。在没有限速标志、标线的道路上，机动车不得超过下列最高行驶速度：\n(一)没有道路中心线的道路，城市道路为每小时30公里，公路为每小时40公里；\n(二)同方向只有1条机动车道的道路，城市道路为每小时50公里，公路为每小时70公里。', '2024-05-29 15:47:01', NULL, NULL, NULL, 3, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('fda5df61229f4eb182ee326bf508f6e2', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '驾驶机动车通过急弯路时，最高速度不能超过多少？', NULL, 0, '机动车行驶中遇有下列情形之一的，最高行驶速度不得超过每小时30公里，其中拖拉机、电瓶车、轮式专用机械车不得超过每小时15公里：　　\n（一）进出非机动车道，通过铁路道口、急弯路、窄路、窄桥时；　　\n（二）掉头、转弯、下陡坡时；　　\n（三）遇雾、雨、雪、沙尘、冰雹，能见度在50米以内时；　　\n（四）在冰雪、泥泞的道路上行驶时；', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '驾驶安全与规则');
INSERT INTO `qu` VALUES ('fe2a73f88fed4ee7bc393fd8ad47867e', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '【用于考试】我国最大的淡水湖是（）。', NULL, 0, '“我国第一大淡水湖是鄱阳湖，也是中国第二大湖。鄱阳湖地处江西省的北部，长江中下游南岸，承纳赣江、抚河、信江、饶河、修河五大河，流域面积为16.2万平方公里，占江西省国土面积97%左右。鄱阳湖以松门山为界，分为南北两部分，北面为入江水道，南北长173公里，东西最宽处达74公里。”', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');
INSERT INTO `qu` VALUES ('fe50de83af2d444c8e6a05769b0d32cd', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '<p>中国古代四大发明()()()()。</p>\n<p>此题演示无序作答，为演示方便提供答案：造纸术、指南针、火药、印刷术，对填写没有顺序要求。</p>', NULL, 0, '<p>【演示乱序作答】四大发明是指中国古代对世界具有很大影响的四种发明。即造纸术、指南针、火药、印刷术。</p>', '2024-05-29 15:47:01', NULL, NULL, NULL, 4, '语文知识');
INSERT INTO `qu` VALUES ('fe52a0bf9c764d458db7f83b6627d1a1', 'ff86d60d27c943a0a16e2d7a04b9d2d4', '系统题库', '石头城是对我国哪座城市的美称（）。', NULL, 0, '石头城中国地域名，三大石头城分别是： 南京石头城（在江苏南京清凉山）、新疆石头城（在新疆塔什库尔干塔吉克县）、辽阳石头城（在辽宁辽阳市东）。', '2024-05-29 15:47:01', NULL, NULL, NULL, 1, '中国常识');

-- ----------------------------
-- Table structure for qu_answer
-- ----------------------------
DROP TABLE IF EXISTS `qu_answer`;
CREATE TABLE `qu_answer`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `qu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目ID',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目内容',
  `is_right` tinyint NOT NULL COMMENT '是否是答案0:不是1:是',
  `analysis` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '选项分析',
  `image` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选项图片',
  `tag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选项标签',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '题目答案表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qu_answer
-- ----------------------------
INSERT INTO `qu_answer` VALUES ('005b4cf1b2664aea814ee8e1feb2723e', 'e6faf9c4d0d74206bf569b785a443bed', '沈阳', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('009dbc5cee1e4a8ca8bc6a15e23b04cd', 'fbb82d91eb094350aa41ddbf6458e419', '《登高》', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('014ffa6918f14577b91bfb926818d6c2', 'b26d01494783429f950ad2c24a541958', '日本', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('01573d3512964c7fbb96123cbc49973a', '9856ef743e7848e9b94a61d8646519f8', '中国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('01b53922cbef44d9b8d60fdccf84ced1', '2ef952053c234876bcfe67dc61b1bf45', '加拿大', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('01d1a6f4c1d54312af0008a05e5dcee1', '9856ef743e7848e9b94a61d8646519f8', '加拿大', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('01f141aee0cb483e859db94f5efbb49f', '2b008d983ae94c30ad6cd97ce173f05d', '韩国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('0211f718b92e460eadd524f930b8cbd9', '1af778d4eb0b4f9798f1e7045c581766', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('03063411f4984f818e24fce500914a9c', 'e6972780de4b4407bd3e571e0c995139', '印度尼西亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('0308e57da1254aada618fdbe0f346972', 'b071cb6cc49d4899ad3177bd69426952', 'D. 输入的字符串中既有 A 又有 B', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('030a08e90b5043f3a79e412d17fdbfe6', '80017f2fd4814067bbfe9e1caedf85c5', '白居易', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('031b8fb0dc5548938c3471f2c4a20b1f', '57fb065bb71a4f6589e037e92cc0a789', '30公里/小时', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('03d2ff81a3b946fcb280797ea682f89f', '07ea3d4ab4004523be6636a3d0b82dd6', '加拿大', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('042b4b5384f1490e986a4f56809f5fa3', 'cac21902890c41de8db1f54960c1e29c', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('047ee811ddd54e8a9dadfbac41a528bd', '2ef952053c234876bcfe67dc61b1bf45', '俄罗斯', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('0493cfd57f794194ab1ababe4ecd8306', '9709fb53a7ff4ab69c2c367644e36465', '傣族', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('04f83d7a40be470ea10c8a5922a8a883', 'd4e72144095d479b9b25cadfd45a293f', '铁岭', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('050f1e1080324ed4873f2a2a726b1c13', '7489a2978c8c49b49b8aa38dab4b0b56', '培训的目标', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('05892786ac5a4944bd2a3231aebf8a85', 'c5c9df4d43d84396acfd2d84f1bc69a8', '3次', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('05e2e3d1ead847b983f96415ae898bcd', '3893b95c9e1245159f8a0f67ae516c4e', '杜甫', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('065e28ec8ae14efebe7300d5fbecaae9', 'd3ee73dd3d914dbaa94760315d637b3d', '使用私家车由教练员随车指导', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('0660fe7765204a8c8eaacae0195ac98f', '091de7090a074c84ac13663c6a0a5eb2', '新加坡', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('069f05f851f24e889c1adea13f2fc03c', '04d3cc8511054f91b1d7d90b3a781a7e', '道路交通安全违法行为、交通事故处理情况', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('06a4523147894ae9bfdefbeeb54696e2', 'a26cb4e5845644dcaec6884a89de7ff5', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('07df5da992c74aefaaec7ced077cb2b7', 'ed4499d413874fe9b3f491ef62a1f0b4', '西藏', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('07ea2f7b551b4262b74d4ad3197ea8a5', 'c119b25655f245e7a653fd55f7fe41bb', '回族', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('088c4b58a66c4a5eaccc4e1f663ccee4', 'ce6a147736394b9c833d51c81730bb23', '工亚基础雄厚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('0925ad96525148e29e444fcaa271342b', 'fe52a0bf9c764d458db7f83b6627d1a1', '南昌', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('09564dc039a847119c6dbab6c7d762f6', '060910f16c3b4247abd3f9c32bac8f4c', '造纸术', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('099ac445c634465eb35fd080fcbb7d3f', '5a91af1341964d5a86edd285ead46004', '拉萨', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('09a300aa49504184913a4d2449f5b279', 'a26e2923e543499a8ba9b41d4ccad0f0', '南京', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('0a0b7f2d3e394ac58d2d659fd749ed35', 'bad3f168e5d94860a626593ff78c6e47', '驾驶证丢失、损毁', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('0a3291efaf8d47e69512818f18b05631', 'd7b263c1cda4456db1c1468f00d1fa73', '青海湖', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('0a3f178b28dd44718caa082700b22f00', 'd7b263c1cda4456db1c1468f00d1fa73', '太湖', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('0ae36cdfd21041ecba773dad724d8edc', '4f37cacdd8bf4a09b4be561c84eafdfd', '参加安全文明驾驶常识考试合格后', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('0be9b7cc6aa54b75bede7a244c7d3d48', 'b8f4a236f75b4acd802789742e7ed025', '1980.2', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('0c330aaf65104941a077b1369bda56b5', 'fbf302624fd14e75a940afa7fd07d0cb', '穿插等候的车辆', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('0c39010eeeab439191d8c8ecee58a611', '28e1925ff8e743ddb1dff777571bbba3', '泰山', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('0c9fe74b7b9b4638b0e7d110f43d8b2b', '24234ed5714e429db9c4b24c897449c1', '个人与权力相分离', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('0cb2c6292aa446a4984b741210063d10', '97ee55208fb648268c08afafddbe25c4', '大象', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('0cf20be8bb0045b2b4a6135e43c3ecae', '62815d180ad5487a80689235718c74ec', '李白', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('0cf8677dde6a459f9bfbe1a4050ec6c5', 'c7d459694fdd47d7991c6866b9eaee8b', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('0da722743d5c4e2a9311c0d02f1aa561', 'e6972780de4b4407bd3e571e0c995139', '韩国', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('0dca46d6f26542998017f49648bea81d', 'd56b7d164cdc4334bef14e759e319c3a', '停止线以内', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('0e52710b18484403b6c51396ee8479bb', '5e5d5276f90b4da597b9336c94c0b4a4', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('0f53adc304bb4aba93f1197f6bc79a32', '0a3f8a446fcf4654aa3f351d816029d5', '地面起伏很大，中部地势高，四周地势较低', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('0f6fb8afd928471ba21e825240c6a981', '11a51e9754cd4cdf95ed8203695d6003', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('0fea4b52ccd1466b8d0ae4ad0c4a6764', '3b63d566176c42edafe541f9c056f952', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('100547d36c9f4219b42db2f8808d90e1', '5a69a43212544255ae8beea51f5f93de', '江西', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('1007c9b16faf44a2bb3da54248090f2a', '8bddfb2febcd428594817d0a25df58ad', '年不含税销售额在110万元以上的从事货物生产的纳税人', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('105157f0227649289e37970ca92581bb', 'b8c8e4a6aa1e49618bfa98c6e9bdc8b4', '全球治理观', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('10e24deb7f3f442084c6cba0dda0da0e', '0e5354d337a04a798eac226820186f31', '加速超越', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('11504a5c2a794c898f7b52fea69a09c2', '3eeaad1a17de49f49adefc63ea7c2968', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('119912c2098c4f87bc6850380b5395ca', 'e90475bdc82d49cdaac7b6a29c068c6c', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('11ceaf059dec4cb0b8d05906b2e40d93', '5a69a43212544255ae8beea51f5f93de', '四川', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('128f3afd3089403d9cff079ec3b33331', '8fd3f9a314354371afa2dbe93c06a338', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('12c76de25a424f6280713ca91891cf09', '05ee4104eb77411fb38753b28bb96a61', '西亚', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('12e4432a442b4105972403a8bf5e378c', '6882fa950b3a44e58aad41a91eebbc76', '道路', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('137d602fabc140bca22aabba52e22bb3', '8a897564807a4ae78b72fb714a107591', 'asas', 0, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('139865bca0c34b6891d52e617f94dcd4', '3fcc901fa2c24167ac1027705299579f', '地面起伏很大，中部地势高，四周地势较低', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('13a1303ff75140d18218c83e48f4ebf2', '00739ffce4f34859ab29d10c6b45aa04', '叶尼塞河', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('14546b985b174cd59be40ed595158fdd', '13f63698fa974192bb559a9615f77218', '桥面变窄', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('14a4f9f897dc473c8e62fb2cf7c3ca41', 'd75ac866a5d847fa9f39cd18c7af72fa', '企鹅', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('14f35ceae5cc4539ae9c2d902e0bbbb2', '97ee55208fb648268c08afafddbe25c4', '企鹅', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('15148c0e5e1246698d6ad6fd7b4b18f4', 'ce6a147736394b9c833d51c81730bb23', '大力发展出口加工工业', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('154bacd8b1994f3a8cd43c3f498a1ba7', 'e6faf9c4d0d74206bf569b785a443bed', '齐齐哈尔', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('154e2fd331ab4ac78f2cd9e8d2e6b4de', '3223d6c63b784408bcdeef3e968a193f', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('156075b746c14c9d9eec5152e50f15a7', 'fb4b2dfbda2848da990cfdf1f0eff425', '鸣喇叭让前车让路', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('156a659d60f148479f2fffcdbd6b32fa', 'b9fea19edde44c32bfebd2953a080ba3', '中国京杭大运河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('15e8926113674473b32acbf13a36c2e4', '514f9d7e2ef14f0591f1e8b95da532d1', '服务业', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('16080412da3048fd8c4bc23b46b15aa1', 'f32288b64ff64ff29cf5ac8890ccd333', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('161e26b3e8b44315b229a212e620faf0', 'ed4499d413874fe9b3f491ef62a1f0b4', '云南', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('165eaa18a6c747b1af2183770e7ae63d', '3c63ae9e3dae48d886997c320c863de7', '身份证', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('16808e3c81744899ba628b657258d50b', 'bd082aa0a7c04762bb94ae20c06b07f8', '东亚', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('16f8a73b73c742b8808723a39c655b85', 'd481d614f7a74465829cf380f297ee0c', '大型车先行', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('174b4365fcad4fcbba53d831dd918569', '5a91af1341964d5a86edd285ead46004', '西安', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('1777b2d12beb487fb74ac7eb1e8df390', 'fbf302624fd14e75a940afa7fd07d0cb', '占用对面车道', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('17d6cb7273c74dd996eef233dd716655', '93e59078f5aa4595a202a401d92d1902', '40公里/小时', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('17d9b030d7c0428894e541a94e384ca1', '4c62642f99624ea5b705282196f62ac0', '1', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('17e023d9ac86496cb03a59fb2c67d527', 'a5a15747dac14c2f8996ae62e82aa06a', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('17e2d8ce554646348885e8234b0f337d', 'fbe1eb99f0e446f280074cd4a5fc7478', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('17f94a523b964ac3876271f2372a0f77', '3e5fb1ac53c44d85a7ff16a3b7be7163', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('18308f5dbab545b39f2fcd97d423c18b', '539030c2c3814a35a429bf2ff055c3e3', '三次', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('186e16026b4b409981f97f71800c3b1c', '57fb065bb71a4f6589e037e92cc0a789', '50公里/小时', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('187b547d722e47c6a832339da3443941', 'b9092609e6414a3f8554a7c6206f949d', '东亚', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('188fdf6eeb2b48e88f00e1e3f91d5a33', '1e9753bae29d45e1a3df89a492d80062', '不靠山体的一方先行', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('18925656e06f4ce39c556732d16256b8', '4ae568501509423a9406cb5dc38d3e29', '1986.2', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('18c8336d02cd4508953aa194d8185619', '71baddfea7254ed9a5ca7a1a0369917d', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('18f74695529f468ea582f292ae32d2f9', '28a78e2127da41b5937c19b49f0acdb3', '党的二十大', 0, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('191c5973995346dd8ac18d7e006d6279', 'b9d77f5317b142e1adac070484a4425d', '临时性用工', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('19998166c14b4d3e8ecb9b48b0f2fd9e', '712513221d6549a2b900e1ab9e51ee13', '鄂毕河', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('19e0c68099594c2b8c337c0a8e29c5c0', '65e96030cde648d5a0bf9ae570122cce', '江西', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('19fa4cb543134eb2a5ff95b313932eb5', '6882fa950b3a44e58aad41a91eebbc76', '制度', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('1a0a79c085944a4f9d2c613c5c0c1612', 'bc7946cca9544ef287c1a4df45842344', '直布罗陀海峡', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('1aa72053db6f445ba3398684f8d67b23', '2cdffda442df431a83897e1b661b94f5', '江西', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('1aae978ba5de41e98b701e195c904b7d', '85e6df3aaf0c4b65bbf475ea2e72e702', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('1ae0d101419242a3a327cdcaf6511db5', 'cadd838ce5644a5e8de64e698486e309', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('1ae775ffcc624c8996c835f1b6efd7b1', 'c24f9337e21d4bf18f1fbadc71351dd5', '不用指示灯提示', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('1afb1cbd7cba40a49247a74bf1bdbaeb', '4661ff6da9cc4d299cb32f054b2273e3', 'in different towns.', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('1b6a5130dceb4e89b0eecb0c6a75ba4d', 'cd8f218ae6b24e4fbc0bfd9edee9a890', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('1ba8a52265f3499a9a813c1129e1491a', '5b1c91728e0748d490ac00d10f14692d', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('1bb108c01d434759974b631f36e3e6bd', '778bb89404ee46699fdf3320d7750507', '不得少于20米', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('1bb5fe2d6e7440b3811b9ecc1acb0d4a', '5611e5efbed5499e87f3c5cdf7832cef', '70公里/小时', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('1bdc6d1f112c42819cb0f0589116eb61', '50c7a43ffb1b4113a7046227f2fc879f', '印度尼西亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('1bdfed1e1963482fb2783f2c2b85cddf', '7647768497cf4a2cb2d191cdb4a6efa4', '云南', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('1cd0df1acebf470b89c9bdea26419412', '9ddaa641580c444382d4ab969e53e1a9', '地处热带，是干旱地带', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('1cde786304814f40aceb174b7694f335', 'e4ef758c45ca4ee3bb14b834ab7563de', '山茶', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('1ce0147e071c4311ab3eefd4a1cf6bed', '1c5cfda7469c428bb8cd59e1c899b497', '可变导向车道线', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('1ce2c314a7d840dfaa54100e92c9585f', '9b4511f7d6b8401496975a704a54bab1', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('1cf3af7edd0448d8912b36d72ed16612', 'c717e33f7a4d497e8a69bf0877c91e0d', 'D. 输入的字符串中既有 P 又有 R', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('1d190b6d4a8347bcb27b18404da21b07', '6882fa950b3a44e58aad41a91eebbc76', '理论', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('1d4314d9bd3444149f96f0aec8d17480', 'd5da46857db946ed944d201fa249d6a9', '南昌', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('1d97b8e2a11b4a5fa3704e411c69a1d3', '4a2313e291c24519ad1f0cfc40b74bc6', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('1e5aaa25f5fc49e5a5a182d8d6d8c689', 'b8c8e4a6aa1e49618bfa98c6e9bdc8b4', '统筹发展和安全理念', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('1e908453d27344ca8c2d5ea25842e691', 'b8c8e4a6aa1e49618bfa98c6e9bdc8b4', '总体国家安全观', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('1ebaafafad7440778e9c5c0bc5649553', 'b26d01494783429f950ad2c24a541958', '孟加拉国', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('1f0e95c6cdcf43f0a9483d6d73f260a2', '4e04138e31ad4946b83110d91be99cdf', '貂蝉', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('200cf6b5eb2947a49c9d8c88f3ed97fe', 'cb03807f8dbe46dab275beaecf753631', '空挡滑行通过', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('202410d720a148049a538c5a5959bef0', 'a59bc2eea3bb4ecfa0fffd7abbd2b017', '12个月', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('20681a6bd95e403ca8ef99164d08259b', 'ed0df44a1df84213a9f23601993c3233', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2099d8b7e13547c69ee415281a654dba', '5bbd523e6e0b4ce78dab024e9ba332f5', '减速让行', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('20bc187b4cb34ab392b2b8232ae45c09', 'dcce5274f1ac43b196809f1f0ace36a3', '从前车两侧穿插通过', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('21244598c9e34b7e9cbb365c4d79befa', '029f7977ee744d9487ee5b1ed596a64f', '《将进酒》', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('2132ae28bb8145daae2fb2b255848102', '2315aae4c4394970b9d66b2f83497250', '违规行为', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('216db2e2258f49dba170272b970f93cf', '712513221d6549a2b900e1ab9e51ee13', '勒拿河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('21cf7cefd4f547a7aa67f38238a55339', '3fce6bf288de44f7bed860444b424a0f', '恒山', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('22027448bb0e4434b3ad53c13c1370cc', '366473d42dc14d7eb39f4216320795de', '《长恨歌》', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('2290501cfb6d4b36accca9b7624375e3', '9e5077ca8b0943a09f8d37302ee53b2c', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('22a193e4e00846da908626e4e6be3b13', '0bc3d45b603e43f0834bf670d32760cc', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('22bc7a2eeaea41f2a7b42d0900009676', '2be24ca734cc4ad6b9bd1c59c605f9ee', '内蒙古', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('22c4f0cd140b4736a33b799a7148dae9', '833543d100dd47d0b86925fc4c5243b9', '叶尼塞河', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('22e02af4d4b147dcb71886c5d9af0885', '9ddaa641580c444382d4ab969e53e1a9', '气候湿热，帐篷利于防震', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('233471fec65b4a5db5e3ab367778238e', 'ab9e817894024513b625fb3e61633090', '李白', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('2338559461b4432a9c6583303f09c51e', '80241f73595e47baa52d4f76663ccfc4', '南海', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2372414652e9407199870482789698fb', '65e96030cde648d5a0bf9ae570122cce', '湖南', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('237cefd51e044e15ba431bf012ccb695', 'c93e2b98a7b447c28755bc7718282fc9', '违法登记制度', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('23a755d637eb463598d97cb620c6ff34', 'cea0ede781d748c8bcb300bd71612430', '40公里/小时', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('23e5f1b462c040108bb41a117d2e7284', 'c71aeeae981845a3bfdcfc38d34497a0', '亚马逊河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('24656b106c8b4934b5ed7273ecd624a2', '7764ea88d80c4184ba3ae8181dabf782', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('24a4cc483f8d4d45ad80d967f99b2702', '4f37cacdd8bf4a09b4be561c84eafdfd', '参加场地考试合格后', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('24ec7e39d62045f396f1da35e2282d67', 'c1304045e0064618ad660b64727e35ab', '俄罗斯', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('2528ee53143a4cb7b05831b1e6b69d9f', 'c24f9337e21d4bf18f1fbadc71351dd5', '提前开启右转向灯', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('252ba2fd4f2046139c88f68d840d1130', '029f7977ee744d9487ee5b1ed596a64f', '《登高》', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('25366235ab7e4db294058bf371195d41', '80241f73595e47baa52d4f76663ccfc4', '黄海', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('25b285458f074873a2c9362322ed1028', 'd4d450cc97d54cb09a9526c5b687c536', '气候湿热，帐篷利于防震', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('25f8dcca0a504bd6a26ea14d9a66ba28', '936dbd23bc2444eeab58fcf1a2b8d61e', 'play football', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('2610461886304625abc5c09691c99e84', 'f27d7c56ca3d473087164fb47241725b', '雨水多，漂流多', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('263849061b1249d186b366a8509d168b', '3893b95c9e1245159f8a0f67ae516c4e', '白居易', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('26fd3780ec5e469da3747bce9d4c79db', '27fa1550e3314b2a82d2493cbc4b0373', '新疆', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('270b355b35dd4b34ab8e4afa8816d41a', 'cb03807f8dbe46dab275beaecf753631', '停车确认安全后通过', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('2725b084fb634595834434f52af25d4a', '7647768497cf4a2cb2d191cdb4a6efa4', '西藏', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('272fb617434f43408e6366ea5b56fb01', '00739ffce4f34859ab29d10c6b45aa04', '鄂毕河', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('274ee5307c0342a89f43a7deb80a669f', '9c160e4679f0497ca7256699b1ccd719', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('277bd7f448fb4d55818776eac900b7b8', '3893b95c9e1245159f8a0f67ae516c4e', '屈原', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('27be811b484a48b09c3572c0ea13ea2b', '45973db3255b488d95dd892506748e55', '密西西比河', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('27eb02d666ca46d0a04993ed9884ef6e', '842cf1df6a71424bac98dd9faebfaf56', '杜甫', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('281b146c2c25431bb5ee0cbd69003856', '1e9753bae29d45e1a3df89a492d80062', '重车让空车先行', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('28688ca901a545d1b07292cbd5c4fff4', '61690c45efcc4e4d82915def333c0388', '雨水多，漂流多', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('28cfee29d8d44a00a0ef91ed04805c3f', '091de7090a074c84ac13663c6a0a5eb2', '日本', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('29179a820c6a4588a2377b86afddd2fb', '6478c468a2af48e1aebd963c2a1d55e4', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2933ad907d0248b6a9f3ee6b1a0ae577', 'b36d73fdf1c4423ab38bb367ab23328f', '保持原状态行驶', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('29766759e7de4f2d8508556b921b6ef4', 'ee11d2d88bf04f06af2d7cf9291180be', '服务业', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('29d6b9def61e4f5ebcc57318b60592f1', '7045a17b94dd43fda9b4e31183405f2b', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2a0646bd8e2a464b8e1d2290a2a83223', 'dddd0101c95b44409907656c2291111b', '保持原有车速行驶', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('2a5f0891fe614c158ca635088a2b47f8', 'f651657cef734285ae2ce13eade8d12e', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2ac6d6bb1f6b4cceb9b39908230d0328', '9709fb53a7ff4ab69c2c367644e36465', '彝族', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('2ad3c2efe48346ab96649a69d2491db9', 'cbb1ac87f94a4091a0e2541995562959', '三个力量', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('2aee979beee14cb6b4ca5c7577690066', 'c43edf71dcb243abb13d32df9605a655', '违反道路通行规定', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('2b11a5ea4ab24245a0418e129d7f6414', '45973db3255b488d95dd892506748e55', '亚马逊河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('2b13125b303645c48ec603c2fe71bc75', 'c71aeeae981845a3bfdcfc38d34497a0', '长江', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('2be493ef236343b399e6d4d47029271a', '3609196dc18d47008bb6fd788dcf89e6', '内在性', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('2bff813b55b946039ccd1b88eb621161', '7a3245e9a7cd4072af43f082fc9e0851', '鄂毕河', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('2c3b7ff06c1245a6ba20d3d7d721ffed', 'f53c9e9b91b84ce5a3d7da28b3d11bbf', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2c49d44c8ae142ad8dd8bda5cdc8701b', 'bd082aa0a7c04762bb94ae20c06b07f8', '南亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('2c963c25e4f048d6b868ceb1c4168a79', 'b071cb6cc49d4899ad3177bd69426952', 'B. 输入的字符串中既有 S 又有 B', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('2cde1e25f35a4c2faf860c81006d5473', '1e3ea59523964a3fac5a4a30ef046a53', '漠河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('2d0341b560be48a883954bb29c9db2f7', 'cea0ede781d748c8bcb300bd71612430', '60公里/小时', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('2d1c31d4db864b9c9d110952b6a517dd', '4978cd0baa7a484bb966a7ae8d6bbcc4', '泰山', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('2d307d54f95149209490b90cb0d4e59a', 'a4ac8920a4524028bf76ec4f4831042d', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2d438c8b04c0466fad4668f10a1ed8d8', 'fc4c68337547424ca09282fd9e2dab9a', '印度尼西亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('2d9340b8c28043ddbbb71c75ceb414f3', '39fec220ee844daf8bbda27c2695d5f0', '契诃夫', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2db34cb6547f49988ddbd6a780b30902', 'c43edf71dcb243abb13d32df9605a655', '驾车没带驾驶证', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('2de4496835844a77a72b5b22057e6fa6', 'f9e0726e82cb40289f96a929987296e9', '高架路', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('2dec621bf5d8422facb76c1d76e38501', 'a2b0e994eb3a4d2c94633efe307020e5', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2dff8499d0564fe4a2a0d31b3dfe1670', '391d4f9f7b4a4996b3004616ce29b7c7', '洞庭湖', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('2e71dad4bb074baf9556c5ceea7e1f88', '172469df895c4f448e6b17f2a9ab7a28', '大象', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('2e86f6b7131d4d1fb81c49d9f6b774b7', '5c0cbd150ebb4d45a51142fbdd174d69', '铁岭', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('2ecd15a0a43f44febafee521496325ec', '9aa72e58b8d94d57addea9f776ad15fa', 'thirteen years old.', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('2f151b7ad4e64b978b07bec42944a911', 'ba81a13b14dc4e7f8cd4982ed3f04bad', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2f24da1e2c46441f8bdf91cbfab8bf4e', '8630d4c0ec444e138f0285ac1150d59c', '李清照||柳永||秦观||李煜||欧阳修', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2f4f54d771ad4b09bed0dfb541109206', 'fbb82d91eb094350aa41ddbf6458e419', '《长恨歌》', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('2f59636d85c74375ba21253954f1c995', 'f9e0726e82cb40289f96a929987296e9', '环城高速', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('2f614e538c6a4240bf926e65405abf88', '8f797d0583bf4e8eab911b5ace56347b', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('2faab5af5315495cb756bcc5989ec4a9', '57585acc3e5e4648acdb62e512b7cde5', '适当提高车速', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('2fd5c9d136054228af1b378a7ebc2c1b', 'b2b38e020597434ea12b925ccf4d286b', '东亚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('306b71cd81c94e70b526e16f0ab91e6c', '6f5edd28675b4f61bb485439774a2cb4', '四川', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3094bd9dab97451dbca34e91e9c71225', '6932483968f24f50895576a52a7b6c7e', '以上结论都不正确', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('30a9ee1b1d8a4dd4bf86a6b460d8e5bc', '2cdffda442df431a83897e1b661b94f5', '四川', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('30acf85280754a8b804a695cab46301a', '3d002bc9bc344878a9a6c79a351cc8f9', '以高原山地为主', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('30bd6c1a6eab4c009b67bb1826a1df4a', 'd4e72144095d479b9b25cadfd45a293f', '齐齐哈尔', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('30ce0348b2d94a16bfb91bc1b4beeecd', 'f77f7746fd164aa99c6f2063b2d5c985', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('30fd39d9daed4aa298c48f310f6fcce9', 'cfe7c139d762415da4ca93d6013afb80', '30公里/小时', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('3109b60d47b344468668502188f28ebc', '4eb53a50f92b4bd29ee4303b454d5fcd', '开启远光灯', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('311968bd4d8043e59337267c99297d1d', 'ab07439ebf4249f8922e87c14539606e', '开启左转向灯向左行驶', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('3131309c0c764ea4b78233d9b82e7f1a', 'c2f0101bb13d4d3abe38654b083c5c8e', '中国京杭大运河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('31c3eb5beb064d7689d048345ebefbe4', '4b958cb5ce26442db434a23d56fb6d3a', '处15日以下拘留', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('31cfc4431287432696c8edd293498126', 'b2b38e020597434ea12b925ccf4d286b', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('31d474a1d08e407e9da75663d01ad7fd', 'a1922aafdafa41979769bfd61da548a8', 'His computer lessons', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('321b432e1597496ebe720abd4d3f917d', 'a2457c9c44694a859223908831941002', '机动车行驶证', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('322340c2fe0e48dd9c4fb257fb021c9c', 'fe2a73f88fed4ee7bc393fd8ad47867e', '太湖', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('3241aa047b8d4507ac22a87fdb7bdbc3', '8bc89d7af5924f1d8a833379691868c7', '追究刑事责任', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('324fef82b57c48cb9ae628fa5de4246a', 'f3c1d614bc3e473c864cb593f718737f', '亚马逊河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('3265c6e14cb64fdeb4b6038f5c91fbec', '35b071389f714265bf83c0a4f3ed5aeb', '大洋洲', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3306d21c82a84bdd8d29846394b951d2', '28a78e2127da41b5937c19b49f0acdb3', '国家全面安全观', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('3329e57300c94849bd995de6d9c2338c', 'e6faf9c4d0d74206bf569b785a443bed', '漠河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('3334190d2e724d44acfe97b3f40321f1', '833543d100dd47d0b86925fc4c5243b9', '印度河', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('338a0f7687194078bff0ef16ad683a61', '5a91af1341964d5a86edd285ead46004', '南昌', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('33b9ba23599d4c64a0b2c8e19ce6993a', 'fe50de83af2d444c8e6a05769b0d32cd', '指南针', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('33cff4cfe4bd4ff085b593bfef1debf4', '8bddfb2febcd428594817d0a25df58ad', '年不含税销售额在110万元以上的从事货物生产的纳税人', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('34a433ec6c2e43d19cf7ad6a993918a2', 'd481d614f7a74465829cf380f297ee0c', '减速慢行', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('34e545a7e6c2442b9b1a970708caf2e7', 'aeca8916be004d77bf23140b6a4c47a5', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('354e083c29e04af5841afb4b9e103321', 'da7f78889c1446718ef5acd61b53b19e', '第三产业在国内生产总值中的比重大', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('357b59e85e54481e9c34db22938e1548', '111dd1c11bc349dcb3798cc0af0ba830', '以平原为主', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('35abda92f35e4f4483c836a28393d1c1', '14af07de63c0493d8ec7f4554bd86d32', '它在睡觉', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('35dae0de50f84d3aaa2abf28bebe2924', '2847894777fe4ad9afc22334dcc34782', '南亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('36184142c47d4ce095fd763a04f284fe', '45b256005ba14af6ba1d5c98c3de9d43', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('3638b71d155e4dcdb10f59a83a9e40d4', 'f77f7746fd164aa99c6f2063b2d5c985', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('36491b1875ea4493b0a7cddb6ac6620e', 'ef7573e7a7494520b06f3662058f8d88', '伟大抗疫精神', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3662be98735842069e57011ab4762a4b', '111dd1c11bc349dcb3798cc0af0ba830', '地面起伏很大，中部地势高，四周地势较低', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('366656957d0d4da9b69e521d4315a9b4', '1c5cfda7469c428bb8cd59e1c899b497', '导向车道线', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('36aa532c3e624fa39ea12951f978b3c6', '2847894777fe4ad9afc22334dcc34782', '北亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('36edbe289d514c959ef4cfad975cccfc', 'b448b53af2d7457680d117ae26310805', '在车前方设置警告标志', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3700b7b33ba34fff82b7d9c2141e06b1', '28a78e2127da41b5937c19b49f0acdb3', '统筹发展和安全理念', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('37b2fc411252436abebc8daf5dd74b7d', '111dd1c11bc349dcb3798cc0af0ba830', '西部是山地，中部是平原，东部是高原', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('37b9915486434f24ad188af9304f954a', '5611e5efbed5499e87f3c5cdf7832cef', '30公里/小时', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('37cf332d4fcb496a98458444b1c9cfcc', 'acaa83033e5f4d4a8df87f75b858cda5', '工亚基础雄厚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('37f9a97c35dc48d6b34b7118ad6eed6c', '95fa1fa5b42e4a6cb2f86cd27127e1e8', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('3809d85fcf3d4627b275d62097e19da0', '37b914b599f94aa7af806d120e87d3de', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('384becbf01b749f3bc910cbf292a571e', '3609196dc18d47008bb6fd788dcf89e6', '失衡性', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('38744d204ce749b08e4f4185eb56e298', 'c8168cf32c8e4b1b95b0d956b2cb159e', '北美洲', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('387ee016b44d422bb04a75e7770874b9', 'ab07439ebf4249f8922e87c14539606e', '加速超越障碍后会车', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('3901cee5925d4c3c8446c86160febbf0', 'f3b05dfd35c248a6af6ed0097b69a768', 'playsports', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3902834507324b04a5669c9c42acf2b6', '31d6d5f8eca34bb4a61e2e1a8c3e920e', '《红楼梦》||红楼梦', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('390e6e98a4574524ab06addbe2f13f57', '19646da51e454d3d910f07696cc1f1e5', '单向劝导式面谈', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('39a660327b014b989b29473fffa8fdc4', 'bb4195c345d0484487631a4b521e4502', '日本', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('39f6b0b05062424e88f8452549e20c00', '3e703277dea94e4982e6dfae921863ca', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('3aab1da529be4527b52427522d31f605', 'fa223b30c8144440baa50130cbce6629', '12分', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3ac2c693daee46a2911a0d0d0daab03e', '172469df895c4f448e6b17f2a9ab7a28', '鸭嘴兽', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('3af2b781e452489a93e3d371f0c5995c', 'bfe09f08170c44d582f9751b2845f627', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('3b57a3c064804549b4f4bfb3bd7e300f', '4eb53a50f92b4bd29ee4303b454d5fcd', '开启雾灯', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('3b874029affd4f3b9ae91573e5826313', '21a6204fc835484f929ee2db5dca44dd', '建筑业', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('3ba80a2e260e4322b0fd35e31454c0e3', '11843e16f1c14ee3b95c4e35dd8104a0', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('3bd7ab1700964201ba198bd0ae32ff9e', '0c3d48ee7fc74f0bb201e377acb0f756', '3', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('3bf2d424d6fb4e3cad6e3b263150edb4', 'c71aeeae981845a3bfdcfc38d34497a0', '密西西比河', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3c357779039c48c1a415ca7f6051bd26', '35b071389f714265bf83c0a4f3ed5aeb', '非洲', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('3c7d3f5fbac24f27a146e16c88b57b4c', 'c93e2b98a7b447c28755bc7718282fc9', '强制报废制度', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3cb34b5549694145914e892e72f5556b', 'edf3fba0b93742da8b7931e537783190', '东亚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('3ccce035e5c44833aa6dd634919addc3', 'fe2a73f88fed4ee7bc393fd8ad47867e', '哈纳斯湖', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3ce9eca6786949e494d22010a5b78520', '1dd4167f55dd4ddc9a8a2985e3025620', '彝族', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('3ceb78f61303488083a5334d957daf5b', 'cd3b504c26a64a289f5c4ba3c9736ec8', '不必变换灯光', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('3d2fad8f9e3d422da81a7034e2abc09a', '9d138585bc7c4d10904f33a0229d59c2', '处15日以下拘留', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('3d412d34b0ad4770a03f2e159396fa13', '9e5077ca8b0943a09f8d37302ee53b2c', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('3d8d94e7e6134c1a8bc0499042464d6f', 'fbf302624fd14e75a940afa7fd07d0cb', '可借道超车', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('3dd432b908f741c98829a297cfd32467', '00144a9784b4486ea59f4c44ac888769', '东亚', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('3e8b127e5d704b8c809e7f95e96e52cb', '1dd4167f55dd4ddc9a8a2985e3025620', '回族', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('3f4884c71fd84192a4e600224f776d28', '57fb065bb71a4f6589e037e92cc0a789', '60公里/小时', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('3fb352f1f8e84cafba1fb998202213b6', 'e13d501b4c4448d4a668cd4e279addd5', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('3fcd64817ec24bc5be8ce7888aa1fbf8', '520d2cd433504796bdf48eb9424340ab', '拥有丰富的石油资源', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4006c1fbb4994043bcc38a98200fd9f1', '0e80bcc639aa472aa5e98aecd8c9a58c', '铁岭', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('40095d8316c94884b10f3c1a75be5949', '8be6003c400540e392257504aa7f4fe9', '20年内', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('401905851ea44accbe9387a363b964be', '3f74f08940214b829bc9636f644b7d61', '青海湖', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('4034f52343874c09a0b908922ee77a23', '2b008d983ae94c30ad6cd97ce173f05d', '新加坡', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('406c25d9ce6e4e1fbd8cb104b9e3aa40', '7489a2978c8c49b49b8aa38dab4b0b56', '培训的方法', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4097051ade164d6dae248f971d19d89e', 'f80aa11cbbb54294ba1646c732607126', '兔子', 1, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('40d047df210c4e7b9be1660a39b8585f', '3f51e325a16d46dba9ab791b6f1e1bbb', '驱动轮和被动轮', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('411a5835c1944ae1acb536784a66a51c', '172469df895c4f448e6b17f2a9ab7a28', '斑马', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('4186003e17d140889409b3683fe92972', 'bb4195c345d0484487631a4b521e4502', '孟加拉国', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('41bd1b499b1145f2b6a16c78e119ee48', '82af113d1ebb4a849f7d145d670255e2', '四季现象', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('41ee42a581954c549dcd2ce358122df4', '33e069118a73442e9f32f93cfbf24c7f', '地面起伏很大，中部地势高，四周地势较低', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('41f063cf6e7648008a011fd0da782efe', '936dbd23bc2444eeab58fcf1a2b8d61e', 'swim', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('42211bc336c04dcd918e472d0e589484', 'a26e2923e543499a8ba9b41d4ccad0f0', '拉萨', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('42302fbbde3a4adab9cb7a016c48855d', '04d3cc8511054f91b1d7d90b3a781a7e', '记满12分后参加学习和考试情况', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('42453f6627d84a5184f83db2db0fea3a', '42ab48c0fad041dface8a9f818f0635d', 'inthesamehouse.', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('42b61dedf4af4c39aa0773e8d2b65445', 'ef7573e7a7494520b06f3662058f8d88', '伟大红船精神', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('42b834dcb4da4c5eabdb99adb2547c4a', '6a567d1d69a54b24817a63faf6c382cb', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('434f6e2ead5d4b3c9e614e6943640e87', '1f2db6be46e44ffebe5c9de32d188151', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('438c56ef4d6a433da672d81c8b468105', 'ab9e817894024513b625fb3e61633090', '白居易', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('43bc16a0ed6a403994c51b2851558067', '8a897564807a4ae78b72fb714a107591', '《琵琶行》', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('441f84c22a144cedba2cceaddac8c257', '0e80bcc639aa472aa5e98aecd8c9a58c', '沈阳', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('44209ecf662649998844039479383401', '0c3d48ee7fc74f0bb201e377acb0f756', '2', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('445e625c6edd464aa3c24768cabe776d', 'fe50de83af2d444c8e6a05769b0d32cd', '印刷术', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('44c43e8359bf4086a97828bb5f87ac0f', '61cccef6dd1e4dc8a5eb111f597b05fa', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('450b1f342414472389a1a897d9f98169', 'a5459e7d9d67454ab2bf90578489ce9d', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4556bfe267bc4bc19f754f54656fb58c', '27e7e29689884b93a77c582f8916e356', '1980.2', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('46360411f06b406c819c8e67970258af', '3eeaad1a17de49f49adefc63ea7c2968', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('46594b4a3b3a411d93f077126364016b', '8c24ebedf58b4e7c83b67bdf95602582', '日本', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('468daee2a073485988f68e4769f37dcf', 'b8f4a236f75b4acd802789742e7ed025', '1986.2', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('46b27083fba7497596579e38bd1349d3', '66e92fe6520d45c4a1bf8f88044fcbbf', '李贺', 1, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('46c46b0a7f8b470d960b24c10a181f68', 'b0ace503d6524c28b1dd607a57c105e1', '暂住地', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('46e095719b784ea49af5ffa032dbff18', 'edf3fba0b93742da8b7931e537783190', '西亚', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('4710a3beb60b4206954b9c2dd41e629f', '3d002bc9bc344878a9a6c79a351cc8f9', '以平原为主', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('4715c6bc060f404b83e7d2797391b549', '3f74f08940214b829bc9636f644b7d61', '太湖', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('4749df1175f8419bb2d6b305f5a85093', '23e854a363f648089e6483a7fb28373b', '苏伊士运河', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4764441c7b9f40debf222ee664c63aa5', 'c777420b32c14e3cba84dcfb8ee6b4ee', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('47b46c86d526433a9d716e0bfd335c5f', 'dcce5274f1ac43b196809f1f0ace36a3', '进入路口内等候', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('47b848f60be04306a09fcd6fb4716c64', '5611e5efbed5499e87f3c5cdf7832cef', '40公里/小时', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('47cd96e0eabe4cc88e9c4d262e31923c', '9953ff72acf24de6bd2f1cbcd83823fc', '哈纳斯湖', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('47d5a19c9bf84f12a851146a1c83beb8', 'f27d7c56ca3d473087164fb47241725b', '气候湿热，帐篷利于防震', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('48238c9cac604523a3d0f6f676ba301e', 'bad3f168e5d94860a626593ff78c6e47', '驾驶证接近有效期', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('483ecf65c13f445da1afcb118fc2122e', 'f27d7c56ca3d473087164fb47241725b', '多地震，帐篷利于防震', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('4851206947d74f6a86a2fb264af1e27f', '04d3cc8511054f91b1d7d90b3a781a7e', '驾驶车辆累计行驶里程', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('48e944d228614ff9aabadb3eec2a38a5', '71baddfea7254ed9a5ca7a1a0369917d', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('49496fad05c04d7abaa618f9b52e8457', 'fd2e345ad9ce4e068b6ac5cb4d2b2894', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('49d68c1afde8478aa3b3d5f92230726f', '029f7977ee744d9487ee5b1ed596a64f', '《长恨歌》', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('49e90e298efc41deb5bff33c8c51eb1d', '7ab30154c23243a7837c91760778bddc', '直布罗陀海峡', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('49f23e7a634c4828b8eb2ad63eda116e', '16502738ea7142afa3f5a2b30fd7340a', '服务业', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('4a198ae0eb33427eb3906d003b382d55', '77c8d1b8e5a04046a3ba2843bbc7c486', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4a3b39d2d48a4578ac6ae8510bf839d5', '88f9f8ba351f40c3afdd24f5d764b6e6', '相等', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('4a9bb0de96f541ffa2f1610a0e85d4d2', 'bfe09f08170c44d582f9751b2845f627', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4af8d723cffc4c779553eabe762225ac', '6e90badbcf0f4e419c49ec170ada3698', '漠河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('4b0d73f1ad8740ef9f0fcd69c803d016', '4e04138e31ad4946b83110d91be99cdf', '杨玉环', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4b4d248961154a229874e8be731d2ba6', 'bc7946cca9544ef287c1a4df45842344', '土耳其海峡', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4b68ad501b56419b9d31b5b4d98b31ef', '91f9535fd70747509647e12f81279d16', '尊重事实和忠实本心的待人对物的态度', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('4b89dbfad7414373bcaa917c80ad65da', '33ab87bdc551457baaae58efcae0ae85', 'Hiscomputerlessons', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('4be80818ea4e47b58af2d16c5aa72d07', '97ee55208fb648268c08afafddbe25c4', '鸭嘴兽', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4c3a2672ce414888acbbfb4d55802790', 'ce6a147736394b9c833d51c81730bb23', '第三产业在国内生产总值中的比重大', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('4cf45a485fa4476780853df4e4a07ca7', '7045a17b94dd43fda9b4e31183405f2b', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4cfab47338ef498fbbab02929a7e6de4', '33e069118a73442e9f32f93cfbf24c7f', '以高原山地为主', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('4d037899fb9d416bbdd63f6ed70b3b50', '0d3e353d2f864b92b992c5e4a69ac16d', '两难式问题', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4d038a8e9f3b4c978fcacad6bc58e290', 'c24f9337e21d4bf18f1fbadc71351dd5', '开启危险报警闪光灯', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('4d86f9014d6d4b8e82cfd4b4061f586f', 'c5c9df4d43d84396acfd2d84f1bc69a8', '4次', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4deb353c543d4cabb04561b37b841430', '514f9d7e2ef14f0591f1e8b95da532d1', '工业', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4e43fa265d2c41b08bce4be09e83b3b2', '2ef952053c234876bcfe67dc61b1bf45', '澳大利亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('4e53720757404db98c27f19a621a59bb', 'a2b0e994eb3a4d2c94633efe307020e5', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4e65ca278d984244bd0b71c34950d43b', '23af7575e20440ccac4b0e5b3b2f6bc3', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4e6832dd80f0451c997e43d5a897e419', '0c3d48ee7fc74f0bb201e377acb0f756', '1', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('4e6d18067d73495fbc6f62f786888b2f', 'c119b25655f245e7a653fd55f7fe41bb', '彝族', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('4e828a13faa14dc2a20a643c0f1ff7f8', '5645ec3461994aa5b60c6cc0277ce660', '东亚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('4ed3a01cc2c4459682d4fa1f05171887', 'be7eb38737a84544901f1f3b0d6413be', '24个月', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('4ee8c40ed2714ac68ca5c6ff34557422', 'a1559b53a84a430781a16272b58deefa', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4eede1975ba14a9d85e10c92288f5d8c', '46c48012bd254a4ebaf40dc547d94595', '机动车登记证', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('4eee375b8c0d4fe7b96f01b7651760a7', '0b6a5a93d9e8453b80f26c122f20c81f', '大象', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('4ef0e9c3fcd945eba3b958937c2da49c', '5256ba7804bc4174a184e09a9999b687', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4f09ea486ad145739ec23aeca322ddac', '32dd1f691b6a454186e2aad2729187e3', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('4f4d25a5535c49c0bc2a8ec808928d46', '40e11970f558432692e1512b3560777a', '东亚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('4f5f65f895ee4c419925ba83350a0dfd', '3f74f08940214b829bc9636f644b7d61', '鄱阳湖', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('4f9b433264fe4b8fa520a24aa19b1903', '95fa1fa5b42e4a6cb2f86cd27127e1e8', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('505a1efc569e4d5ca0f3f6cc2a09e442', '5215ebb7d33240a5b006786a0238e906', '司马迁', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('5077f15b537048b7b48c6ddc1beaf677', 'da7f78889c1446718ef5acd61b53b19e', '拥有丰富的石油资源', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('50ace9999c49472f887cf79480d29083', 'da7f78889c1446718ef5acd61b53b19e', '大力发展出口加工工业', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('50f5fa1c9bf84880a825798e47ddb309', 'ef9c783eec6c4f07861cca1974b359eb', '彝族', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('511ce5a4947b4b7d85e9c4b2612f35e7', 'd75ac866a5d847fa9f39cd18c7af72fa', '大象', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('5145f251640d4e58ad0eeb3182277ff9', 'cd8f218ae6b24e4fbc0bfd9edee9a890', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('5162f38953ab4cd8a04249a0ca40a1a3', '6f5edd28675b4f61bb485439774a2cb4', '广西', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('519d935018e4417db802ac7a85b3d2eb', '8fd3f9a314354371afa2dbe93c06a338', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('51cc1d6f9bb5417d87f68fee0437193b', 'a1922aafdafa41979769bfd61da548a8', 'His sports lessons', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('5210e0a60505473597c85cdd3cd579aa', 'bd325a5aef7048e5871c8a60001394f3', '战争与和平', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('521458f905804f4f971b89b53f4e5c26', '143e1fa162204c17aee2edbb10be07e3', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('522b23f2eac746f69fa40dc470e7b51f', '778bb89404ee46699fdf3320d7750507', '不得少于30米', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('52aff47ac9c54a69b158d1567f298f36', 'cfe7c139d762415da4ca93d6013afb80', '50公里/小时', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('53396ff98f874d54b64ca954201dfe90', '2847894777fe4ad9afc22334dcc34782', '东亚', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('535bac5c2f5f4e77a2fb4720070a9d72', '333985d2d41048449ea405cd1f2c5aa1', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('53630208fe7f490cbbcada39cf6e4219', '48edfaf725b64aac97ae805b796ee1ab', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('5370b2dcbe794616b2f6f6f7a994c763', '07ea3d4ab4004523be6636a3d0b82dd6', '俄罗斯', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('53e217f9a0674ad7927d8e5c545b7c9d', 'e6faf9c4d0d74206bf569b785a443bed', '铁岭', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('544876f93c244229bc70a2f80ce44278', 'b0ace503d6524c28b1dd607a57c105e1', '核发地', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('546862583f264c40a1d25d5d8beab180', '9aa72e58b8d94d57addea9f776ad15fa', 'order than Max.', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('54d31ea587cd44d0b61fc5afbb8fedbd', 'e6972780de4b4407bd3e571e0c995139', '孟加拉国', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('550cdefde4d24e0c90180305a63988c7', 'f3b05dfd35c248a6af6ed0097b69a768', 'playfootball', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('555c35354924497db7f893bac6b8b3f1', 'fd2e345ad9ce4e068b6ac5cb4d2b2894', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('557467bf28824e38b80b02aec785d4c4', 'edf3fba0b93742da8b7931e537783190', '南亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('55e3f0853475496f929fc7ce75a6e9ab', '4b958cb5ce26442db434a23d56fb6d3a', '终生禁驾', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('561a41a9626e4e76999712f5beac65b5', '1e3ea59523964a3fac5a4a30ef046a53', '铁岭', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('5631f624ccc44d7f8601af5c346c267d', '9c160e4679f0497ca7256699b1ccd719', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('56a3bcf08a034314bfbf02fd9ebf223f', '42ab48c0fad041dface8a9f818f0635d', 'indifferenttowns.', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('574fc99a85b844ae8fead06cb7263c21', '5bbd523e6e0b4ce78dab024e9ba332f5', '正在超车', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('57648eed48c6444da6eba3aa5a47b94e', '8c24ebedf58b4e7c83b67bdf95602582', '韩国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('58051c4bc8f94701b9f3f7b8e8fa8e16', '532aeadd18c347cfa432f944490ef06b', '1981.2', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('58054ba8d320400b88fa3fb2e264ae19', 'c8168cf32c8e4b1b95b0d956b2cb159e', '亚洲', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5840c98758a64908b533106e2bc286a4', 'da7b62c3dbd949888f8e19d294ed90cd', '6小时', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('58ef5c6345a6408dbcf0f59e70dccee7', 'f6a3abc6998c4615885e42fef3351615', '吊销驾驶证', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5924ade7c44f449ab80040ecede6abbe', '533062fda6d44dd5a3f665dce1ab3a1c', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('593638351b91419dae5eb2ac4c75972b', '4b958cb5ce26442db434a23d56fb6d3a', '依法追究刑事责任', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('594bbbdf1f964ad89ec32bd40fb82137', '8a8dedc0561948e891bbd384362fe125', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('59857542c724419c969e04ef0760d589', '80241f73595e47baa52d4f76663ccfc4', '渤海', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('59da3fb359514713af997f376059e21b', '40e11970f558432692e1512b3560777a', '西亚', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5a9de1a3f735414b9a694df19277b81f', '8ee2ce33144d4d19b625a6bbf4037da6', '马来西亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5ac3377b422748878a48c051cde85560', '185f19ac9bbe48c8aae417ffeb75f3fd', '日本', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('5b11fe9990064e12bafaac7bb798f6a6', 'fe52a0bf9c764d458db7f83b6627d1a1', '南京', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('5b2593dd46244829b54e1ac31d0664f1', 'c160489406ef475aa39321789f639ddc', '尼罗河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5b25ccc28d004ff6aceea4ecfaab8a96', 'f703e4148f294f5bbc683591ffad0cd1', '提前开启近光灯', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5b7210679f554c379af55427ee2991ef', '5a69a43212544255ae8beea51f5f93de', '湖南', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5bbb7ce6efae46f5a328bf705985c6da', '4f37cacdd8bf4a09b4be561c84eafdfd', '参加道路交通安全法律、法规和相关知识考试合格后', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5bc928fa8cd14027989067076fea60c6', '3c63ae9e3dae48d886997c320c863de7', '工作证', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5cb8cefc47e54e3f9be677ac80011d1f', '7ad472d5aa14425fa0557b90996a0586', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('5d1a11b7069e4eb4b8201c83c7e4db2b', 'dcce5274f1ac43b196809f1f0ace36a3', '可借对向车道通过', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('5d5a6f621b3c48cdb324889108bf69ad', '7e98092854174cca8fbaddc0ba1dd9e4', '指南针', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('5d8fac9cb32b41e790d844354e4ae678', '3d002bc9bc344878a9a6c79a351cc8f9', '西部是山地，中部是平原，东部是高原', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5d902d0d68d9494284d3e22e7e3188b0', 'f9e0726e82cb40289f96a929987296e9', '中心街道', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5d92dcb411a947e8911ad24ad2b5ff96', 'cccb2cb3a9284d2792d6100a949301db', '鄱阳湖', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('5db2cd1b3c9c42edb74da51807e40f18', '1f2db6be46e44ffebe5c9de32d188151', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('5dd8f25411054aebbfc2d40e2c58e28e', '712513221d6549a2b900e1ab9e51ee13', '印度河', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5dde86da074c485fa5ec05de7b900539', '00144a9784b4486ea59f4c44ac888769', '南亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5df10bb446634456b9ece8c158c5ae90', '6e90badbcf0f4e419c49ec170ada3698', '沈阳', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5e169d79b9ac4d749ed3b2e9bee11047', 'a59bc2eea3bb4ecfa0fffd7abbd2b017', '18个月', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5e79bac4c0b74070babe0022931442a5', '0a3f8a446fcf4654aa3f351d816029d5', '以高原山地为主', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5ed5602f018848e3a80c7f2071a8dd71', '16502738ea7142afa3f5a2b30fd7340a', '农业', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5ed5c75cb56e44c6916ce3d4dbd664cf', '532aeadd18c347cfa432f944490ef06b', '1985.2', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('5f0e3d58e3ce48719ffaf2e54a91c031', 'e2ea1f15186f4d38b40952c4bc5b9b70', '40公里/小时', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('5f1028cf9d274625843929372f448d04', '80017f2fd4814067bbfe9e1caedf85c5', '陶渊明', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('5f1b26d1994143abb71164eb86d29548', 'b0265d784e8e4633b7e13f5dc62b9d50', '拥有丰富的石油资源', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('5f5d6703dd694e8f8a951cf88ecfbb4f', 'c717e33f7a4d497e8a69bf0877c91e0d', 'C. 输入的字符串中既有 J 又有 K', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('5f6eb1ff8276435c8605ca5ccd275be2', 'fc4c68337547424ca09282fd9e2dab9a', '日本', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('5f8c02bf847c496694e783b1cc1a9e40', '75c0ec5e6f044d5781a6e3f97a80c70d', '创造性', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('5f95c008b8a247f08781c8990084c1cd', '4793eebea0544f03951476504134ef3b', '关闭前照灯', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('5fdfd6e7de484e53adc545471567956f', '0d3e353d2f864b92b992c5e4a69ac16d', '开放式问题', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('5fe6e32fde104dfe9f398bac6d5d4d4d', '31d6d5f8eca34bb4a61e2e1a8c3e920e', '《水浒传》||水浒传', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('601f04d4da7f4cd5aa6bcf76344d1a61', '7647768497cf4a2cb2d191cdb4a6efa4', '四川', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('60990eee6a8a499d82f61f0a5f937541', '1c5cfda7469c428bb8cd59e1c899b497', '单向行驶线', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('610906f2b65e42ac8c84ac4e3d45ab0a', '66e92fe6520d45c4a1bf8f88044fcbbf', '白居易', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('614dcb97bbe8422ebf9f909634c08b67', '8a897564807a4ae78b72fb714a107591', 'dssd', 0, NULL, NULL, 'F');
INSERT INTO `qu_answer` VALUES ('616e75126a58446396002885dbef4818', '4a2313e291c24519ad1f0cfc40b74bc6', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('617ead40356c4550aede67c657a06c95', '859d2670f7444e969b45414108b00bd4', '规范性管理制度和员工管理制度', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('622c75c30a4d4b1d86787ac1acc93bd1', '2be24ca734cc4ad6b9bd1c59c605f9ee', '西藏', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('623b6519a2df4020a173958c6bea04c6', '71153b61fc98484db5955fba15aabedd', '杜甫', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('625a80beb1524379bceb87fb6cdbd722', '13f63698fa974192bb559a9615f77218', '左侧变窄', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('626014af2a0c45c68d410f3bf119bfec', '7dc44d23727049c3abb5e0b738a79d97', '狗', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('62b1a5b4cbba4bcaa89229c40ef0cced', '2cdffda442df431a83897e1b661b94f5', '湖南', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('62cad10740a549c6a6488d2055770092', '6a6d5ba7ca0843f6b82bd7b0582bf977', '内蒙古', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('62e06d6d923c4c0a97c0fc2084c5f9c0', '7e98092854174cca8fbaddc0ba1dd9e4', '火药', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('62e3ecfde751439299f8a2d3e0393f9d', '21a6204fc835484f929ee2db5dca44dd', '服务业', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('63178b5244a644608e118faa8c660ace', 'c43edf71dcb243abb13d32df9605a655', '造成交通事故后逃逸', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('632563606a9c46fbbac3dff8b7847b12', '8a897564807a4ae78b72fb714a107591', '《登高》', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('63acb2f6c5584cec8a14e3ec7e0c5b63', '9856ef743e7848e9b94a61d8646519f8', '澳大利亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('64420b7b256d492ca7e466df5763d1be', 'cb03807f8dbe46dab275beaecf753631', '加速尽快通过', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('6458992fa19c4b799b4dfc3ef4dd1d19', '46c13edbaf394c6d8de5166453fb8585', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('64b49c6802ae46c3900573875cb1df7b', '9709fb53a7ff4ab69c2c367644e36465', '壮族', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('655068d75c9e497e827ea199b24254a9', 'd7b263c1cda4456db1c1468f00d1fa73', '鄱阳湖', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('65748c081ddd43aabf7b4c779e56dd86', '33e069118a73442e9f32f93cfbf24c7f', '西部是山地，中部是平原，东部是高原', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('65b40edfb6904290a2384c896676bc28', 'fe50de83af2d444c8e6a05769b0d32cd', '火药', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('65bb0c88ceae406ca423972ee0f01ed6', 'c928b30c38c742fb8fa440a741b26c0d', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('660bde34886c48738e053fa140f1ee30', '0b6a5a93d9e8453b80f26c122f20c81f', '鸭嘴兽', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('663f265542d64dd98e29719dc09a51fe', '40b4c6f1922c44f8899916b1558ee0ab', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('66decea6f1e143d78a13ab4bdc9ffcc2', 'cae8e39074294a4ab8a95d17018a1867', '单向行驶路段', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('6781b71433d54393a1f937329f119142', 'fbe1eb99f0e446f280074cd4a5fc7478', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('680a8537c48d46e792391f640c4a8acb', '7ab30154c23243a7837c91760778bddc', '马六甲海峡', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('6845c27cf1444b12bb6aebefd19583ad', '185f19ac9bbe48c8aae417ffeb75f3fd', '马来西亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('6884cd80979f4b209face84de4de18f3', 'dd38d23c395b446f878d47dacf7d0fff', '减速让行', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('68a35c90b48b4615941efb6c399d842d', 'cccb2cb3a9284d2792d6100a949301db', '哈纳斯湖', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('693ec5c005af4c7698e5a96528d09129', 'b2327d9428624b90adda2c48e1fd1dba', '窄桥、弯道', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('695b4d3f5ff6479a8a2202017194bd2f', 'c7577ad4d8584ec8b02ac82daa8a5a31', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('69d583bf30c44927a813169b6c927fc8', '2b008d983ae94c30ad6cd97ce173f05d', '日本', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('69f96c01d42740e1b0e3c5b89f447f0b', 'cccb2cb3a9284d2792d6100a949301db', '洞庭湖', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('6a6de5a5981b43109e2abd8c649e3563', 'd4d450cc97d54cb09a9526c5b687c536', '雨水多，漂流多', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('6a9058bdd80649fc9bbd1896161f7432', '93e59078f5aa4595a202a401d92d1902', '30公里/小时', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('6afb7bc0d63b49509700de8a39fe328b', '1dd4167f55dd4ddc9a8a2985e3025620', '傣族', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('6b01484aa3e047078539879382fe915f', 'b0265d784e8e4633b7e13f5dc62b9d50', '大力发展出口加工工业', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('6b1c4dba257b4f8cb987ad5d52fc6a3e', '539030c2c3814a35a429bf2ff055c3e3', '二次', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('6b29a00dab1f4026a52076fa8ed8ac1d', '3893b95c9e1245159f8a0f67ae516c4e', '李白', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('6b98774a0c8a47bcbd489dfdd15627d5', 'd3ee73dd3d914dbaa94760315d637b3d', '使用所学车型的教练车由非教练员的驾驶人随车指导', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('6c009d248e2f48139b6238fd766ed516', '185f19ac9bbe48c8aae417ffeb75f3fd', '韩国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('6c7dc591a3384c939475ec6b3032c488', 'c7577ad4d8584ec8b02ac82daa8a5a31', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('6c874d6610584615bd410277b764b950', '20ec59fa41274d28af5cb4c1f8660d33', '未放置城市环保标志', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('6ca130d271ae4e4b885013eb6a115ab3', 'fc4c68337547424ca09282fd9e2dab9a', '孟加拉国', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('6cc9e226a6ba44fc9b5fd77437c34b9f', '4ae568501509423a9406cb5dc38d3e29', '1981.2', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('6ce2f1b74bda4f728d8195eec2d50b66', '31d6d5f8eca34bb4a61e2e1a8c3e920e', '《三国演义》||三国演义', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('6d60f0e531cd4c4392e6d5ff9bbf34f1', 'fbb82d91eb094350aa41ddbf6458e419', '《琵琶行》', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('6dd78a5a3ebf40b5a8ed74e037f99f08', '17dea05017ef40798942c26878d0b219', '建筑业', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('6e11b144d9064ed495c580f209a9250e', 'f27db377b6784bafa9eb1bdd93d770e8', '发展战略', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('6e2ce60944ed4b6bbd2d9d6dc2a901e6', '9aa72e58b8d94d57addea9f776ad15fa', 'twelve years old.', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('6e34ecb516d743e6ac61c4ae7aca41a2', '6c70b3ef6e1143e0b86b9c18be1b7959', '马六甲海峡', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('6eba070eb90749baa8e30f4244ecaa9d', 'bd325a5aef7048e5871c8a60001394f3', '111', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('6ebc0117168c4f7799a66d0efe4129fc', '8be6003c400540e392257504aa7f4fe9', '5年内', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('6efc9ec86ba641dfa95527d732f3c286', 'd5da46857db946ed944d201fa249d6a9', '拉萨', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('6f72abeb8d4c4799a15d0901b387ed12', '7e98092854174cca8fbaddc0ba1dd9e4', '印刷术', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('7030841c3afd4c93ab54fdb4993caaa0', '4661ff6da9cc4d299cb32f054b2273e3', 'in the school.', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('703f07da760540ba9672e2a64ef30ed6', 'd75ac866a5d847fa9f39cd18c7af72fa', '斑马', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('7044910c1a6c426cbfc5a13058a437c8', '842cf1df6a71424bac98dd9faebfaf56', '曾巩', 1, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('70803d3397a44527842d652599289739', 'bb4195c345d0484487631a4b521e4502', '印度尼西亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('70997736aca64102b09f00af8655192c', '80241f73595e47baa52d4f76663ccfc4', '东海', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('713c7e1c893b47e4a76b0158ce8c0b46', '1e9753bae29d45e1a3df89a492d80062', '速度慢的先行', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('713c955839564d64a750f5f78217eac4', '66e92fe6520d45c4a1bf8f88044fcbbf', '李白', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('71814f73390c4d8bb61eb0af64e20c41', 'da7b62c3dbd949888f8e19d294ed90cd', '4小时', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('71b432dac4b943298adca4c6acc72a68', '143e1fa162204c17aee2edbb10be07e3', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('71bb89f166604085bca377fa6699cb1d', 'f3c1d614bc3e473c864cb593f718737f', '密西西比河', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('71c970e88a96465c94b13906da193144', 'b2b38e020597434ea12b925ccf4d286b', '南亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('71e0d9e0819c4735939d1bc14b6d45d5', 'ed0df44a1df84213a9f23601993c3233', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('72117340ab604f12b9750aadeb814603', 'f6135ba3e43e4197ad63725defab5fa3', '鄱阳湖', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('7234c882f273432b813b3ff154efa156', '3fce6bf288de44f7bed860444b424a0f', '沂蒙山', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('72810194f38049a88b9e6eaee6c4a241', '9b4511f7d6b8401496975a704a54bab1', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('72f64b702e8e4262b18e508a124a7c75', '7a3245e9a7cd4072af43f082fc9e0851', '印度河', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('738aef5456a14b8890777422988ca495', '4c62642f99624ea5b705282196f62ac0', '1', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('738d94bc4fcc4f3994fe084fbb88e421', 'e2ea1f15186f4d38b40952c4bc5b9b70', '30公里/小时', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('7393dbe922a247fcb05e724b01067707', '7dc44d23727049c3abb5e0b738a79d97', '猪', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('73acc7bf85744e98ad9d057ae92a91a1', 'b1caceff25914b3daed4ca946ab423f6', '处15日以下拘留', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('73e66d9ddeb645359cd8b8838f42af11', '64f7932716094d7cbd13fcc11c71dd3f', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('73f68dea0e674d3ba0ec307cc8e7119f', '4eb53a50f92b4bd29ee4303b454d5fcd', '变换远、近光灯', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('73f9142f79c84568811e7edfc17985ad', 'd7b263c1cda4456db1c1468f00d1fa73', '洞庭湖', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('740dfc09804f43ea8f4f1cfb2487267e', '33ab87bdc551457baaae58efcae0ae85', 'Hissportslessons', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('74c4e9305a1b44d8ae4ba6191d2e67fe', '3609196dc18d47008bb6fd788dcf89e6', '外在性', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('74c8ca53e0e14cf5a1e5eef716cb87ca', 'b63c3ecbc3a04f31a18f3dc856e9b1c6', '经济责任', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('74f01897813a4b44a0f723fefc32bd26', 'dcce5274f1ac43b196809f1f0ace36a3', '依次停在路口外等候', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('74f09aaf5bfa488b9431b8a42a9003ff', '3223d6c63b784408bcdeef3e968a193f', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('7507e2783a1d47e3a73906b17ee9e9f2', '37b914b599f94aa7af806d120e87d3de', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('766d6f21edd1490b9b808a6dc4bf4341', 'bad3f168e5d94860a626593ff78c6e47', '记分达到10分', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('76a13eb52d6b44eba1140e4f38d3acd3', '5b1c91728e0748d490ac00d10f14692d', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('76b7a84526f5430ea780d2a5d6c7cf9d', '13f63698fa974192bb559a9615f77218', '右侧变窄', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('76b7e3db8639410ebd02f8e6d4cfcbd9', 'ef9c783eec6c4f07861cca1974b359eb', '傣族', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('7725b751ee0f40c9939b64245d211206', '23e854a363f648089e6483a7fb28373b', '巴拿马运河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('7727ac59a4ed4ad68298a1fed8bb22fd', '2d4aa0587840430bb63d7c8ce79af339', '马六甲海峡', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('77414c86d4a94cd3873360562f8ea5ca', '1e3ea59523964a3fac5a4a30ef046a53', '搜索 ', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('77a1723651944599a4073ed4534edf8e', 'cae8e39074294a4ab8a95d17018a1867', '主要街道', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('77d326b44cb340d4a92d8415fe06fe67', '6ad44a14a8cf4567940882e833e6af82', '铁岭', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('77f859070a974342af048b466c985f13', '5e5d5276f90b4da597b9336c94c0b4a4', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('785d6902b4fe4c779e505796b779a471', 'c160489406ef475aa39321789f639ddc', '亚马逊河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('7897c2db8cb74e0796e9302d63559920', '0d3e353d2f864b92b992c5e4a69ac16d', '排序选择型问题', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('792dbe7e49da4f6f85085ed12eef5244', '7e98092854174cca8fbaddc0ba1dd9e4', '造纸术', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('796fdd1541854ee090691cbc0061e9a4', 'e4ef758c45ca4ee3bb14b834ab7563de', '玫瑰', 0, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('79746085050545089cf4148e7097de3c', '3e5fb1ac53c44d85a7ff16a3b7be7163', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('79c4ad41f35142bba6409999dc630402', 'd56b7d164cdc4334bef14e759e319c3a', '停止线以外', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('79f06ba732404db6a316e6efabd8ce0b', '35b071389f714265bf83c0a4f3ed5aeb', '北美洲', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('7a03ac2b61a34d21b0e1024f3119cb36', 'd4d450cc97d54cb09a9526c5b687c536', '地处热带，是干旱地带', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('7a538782243643d1818d13f495ec5a0c', 'b36d73fdf1c4423ab38bb367ab23328f', '降速靠右让路', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('7ac9f688f6724c2db319269014f13459', 'be7eb38737a84544901f1f3b0d6413be', '3个月', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('7af52d3dff054fe3859000aeec4eff66', '61690c45efcc4e4d82915def333c0388', '气候湿热，帐篷利于防震', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('7b2ac342c63f47d9bb9824f68b9af46b', '3fce6bf288de44f7bed860444b424a0f', '太行山', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('7bce06d1af1641389480b2aa9a05d182', '2315aae4c4394970b9d66b2f83497250', '违法行为', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('7bfca88d716d45599f957fdd813fcf0d', 'da7b62c3dbd949888f8e19d294ed90cd', '8小时', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('7c62c25435264c05b352eda6d30540d2', '07ea3d4ab4004523be6636a3d0b82dd6', '中国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('7cfe80c8ca214db291a575dd0fb183e2', '1e7b506a034849fc9b075fd93c1e000b', '云南', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('7d2ce228e3104f24ac81b308f9054590', '57fb065bb71a4f6589e037e92cc0a789', '40公里/小时', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('7d57edf9bdb44e1f84e5ee36f0999163', 'c928b30c38c742fb8fa440a741b26c0d', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('7db6dcb7a9c44a289ac53fb9701bf9b2', 'cd63230177f54d0490ac6e7e05133f57', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('7dcf4bb7c2f84a17a2afeadc3cb6e2b8', 'ab07439ebf4249f8922e87c14539606e', '开前照灯告知对方让行', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('7ee009fe3ebe48d7a2130f95b67f0a05', 'dd38d23c395b446f878d47dacf7d0fff', '正常行驶', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('7f596ceb79f24cde9e0d9eaad86aa5f8', 'ab9e817894024513b625fb3e61633090', '杜甫', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8037effe976f4241895163add7887534', 'c717e33f7a4d497e8a69bf0877c91e0d', 'B. 输入的字符串中既有 J 又有 R', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8091e73e427b43928bd4f78d422b743a', '699b5e55acd04b57a0584016f6804494', '开启近光灯或雾灯', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('80c5359bf5ca4b75b971eab22d3fa858', 'b9092609e6414a3f8554a7c6206f949d', '北亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('80cfe14d5d204383b0dc70edb07a5385', '0e80bcc639aa472aa5e98aecd8c9a58c', '齐齐哈尔', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('812858d2247f43f096cd4eb9822b5840', '00144a9784b4486ea59f4c44ac888769', '北亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('81885f2489d54695b27caca2c81715ef', '842cf1df6a71424bac98dd9faebfaf56', '李白', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('81b03d8c27a44922a0de426e840e2539', '520d2cd433504796bdf48eb9424340ab', '大力发展出口加工工业', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('81da60a91ce449738a4fa87d1d36dc38', '21a6204fc835484f929ee2db5dca44dd', '农业', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('8201fe87bffd4d83bd04b5f72638cdb9', 'b0265d784e8e4633b7e13f5dc62b9d50', '第三产业在国内生产总值中的比重大', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('82141a701c74415a95ee36afbe6f443b', '833543d100dd47d0b86925fc4c5243b9', '勒拿河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('821cf9fc32534da794d5b7ff8db5846b', 'ed4499d413874fe9b3f491ef62a1f0b4', '广西', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('827942188775452fa513b641a49fb4b9', 'a1922aafdafa41979769bfd61da548a8', 'his English homework', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8295ee363c5b4faa84a18d286f94579a', '3e07606eca9c4043a91f01182e0f3560', '五个全面', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('82dfb212ab71412c9c45cdffe87c1e05', '33e069118a73442e9f32f93cfbf24c7f', '以平原为主', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('83280de31a5a40de92c8b8fa172c60b6', '27e7e29689884b93a77c582f8916e356', '1986.2', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('8389cd0ae01f4d36af7b086b3d50d0fa', 'e0171593dbe34c03a15f1fcae101c86f', '注意新手标志', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('839bca09d0514d09bc1e8f7015e55266', 'f703e4148f294f5bbc683591ffad0cd1', '不用开启转向灯', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('83f22d74b39e4d1bb5cf9e2386029956', 'c1304045e0064618ad660b64727e35ab', '中国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('840567ccb3b845548b10976221938883', 'cccb2cb3a9284d2792d6100a949301db', '太湖', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('8427633c999a40a6a5dd53af16b9251c', 'a8187f2d23dc4015b5aa7920d01e2f1a', '李白', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('849d26d7c84740c081bf849f4a519cac', '19646da51e454d3d910f07696cc1f1e5', '绩效计划面谈', 0, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('84ba67019de4472dbad8ddec7b3ee7ca', '4978cd0baa7a484bb966a7ae8d6bbcc4', '恒山', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('84f3fdef43004219b63cc8b1b7ba69b7', '520d2cd433504796bdf48eb9424340ab', '工亚基础雄厚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('853ffb839d074f43968dc115854bb8bc', '91f9535fd70747509647e12f81279d16', '对“天道”的真实反映', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('857583c77be54b8dbae765006ea8452b', '1dd4167f55dd4ddc9a8a2985e3025620', '壮族', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('85b7fcfadebb456d8509a3a251b1f33f', '5645ec3461994aa5b60c6cc0277ce660', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('86304bf53ba041459e5eb950307f5817', '05ee4104eb77411fb38753b28bb96a61', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('863b13052f504a63a9f2285f79158ff5', '0e5354d337a04a798eac226820186f31', '并行一段距离后再超越', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8721958bec71466b9fad790d56d44cb4', 'a8187f2d23dc4015b5aa7920d01e2f1a', '白居易', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('87250ca94f014caea580cb338467e576', 'c1304045e0064618ad660b64727e35ab', '澳大利亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('87b5908ba2214551bc90559fe9984825', '66a8fe46f7754647a663424d8c566909', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('87bbee283d454cf8a94c1ad02efe5b73', 'f27db377b6784bafa9eb1bdd93d770e8', '经营规划', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('87be5424dd284ddc950f31067231bf25', '2315aae4c4394970b9d66b2f83497250', '过失行为', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('87d1406eea454e1fa6e28c63efc387b6', 'da7f78889c1446718ef5acd61b53b19e', '工亚基础雄厚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('880ac5d8675e4cb09b8ee2cbb2988a5d', 'f703e4148f294f5bbc683591ffad0cd1', '提前开启右转向灯', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('8822fc41e17b4e8d90376e51ea066a2b', 'b448b53af2d7457680d117ae26310805', '开启车上所有灯光', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('887e00ef5be84b6fba1c71e357454f8d', '833543d100dd47d0b86925fc4c5243b9', '鄂毕河', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('88ad6f1f925442e9b27ec54494c28ae5', '6f5edd28675b4f61bb485439774a2cb4', '西藏', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('88c37e3b7e404d0bb593c1c0b15f91f5', '8a897564807a4ae78b72fb714a107591', '《长恨歌》', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('88db72eb58fe486d808b80f9695d82d2', 'fb4b2dfbda2848da990cfdf1f0eff425', '从右侧占道转弯', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('894dd54e3bc741fca41909833c137dea', '97ee55208fb648268c08afafddbe25c4', '斑马', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('89994db4d2194560b9b8c12fe8c7b944', '35b071389f714265bf83c0a4f3ed5aeb', '亚洲', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('89cb506611fa46caa4382219f07423be', 'e0171593dbe34c03a15f1fcae101c86f', '注意车距标志', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('89e38abb4629481aab3ff2fd790db3c3', '8be6003c400540e392257504aa7f4fe9', '终生', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('89f47cbfd0bd417eb7c1bb66eb8761c5', '060910f16c3b4247abd3f9c32bac8f4c', '指南针', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('8a4ce2368f5d463b8d57a791e0fe7163', 'c04783ce70524bcdb3a3a5cdc4d0cfeb', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('8a6d0f3ce5f54f9baddc6ea9f2912ce5', 'a2457c9c44694a859223908831941002', '机动车登记证', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('8a92d90c4d494e37b64ca0139c995a73', '65e96030cde648d5a0bf9ae570122cce', '贵州', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8aa8f79071944d99a251f6d55f602037', 'fbb82d91eb094350aa41ddbf6458e419', '《将进酒》', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('8abb768173044f9c9df75e07669d4454', 'b63c3ecbc3a04f31a18f3dc856e9b1c6', '直接责任', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('8ace4a0506f04967ac13d8288ff16f76', 'f3b05dfd35c248a6af6ed0097b69a768', 'swim', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('8b1bc319a1c343609ca38a62552a0d51', 'bd325a5aef7048e5871c8a60001394f3', '和平与发展', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8b2a7ffc901a41539fb56bbcb270df29', '1af778d4eb0b4f9798f1e7045c581766', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('8b307aeb790145bc9d30ae81b3fe6a97', '8a897564807a4ae78b72fb714a107591', '《将进酒》', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('8b42f38853a542b9b3091eb28d5e486a', '39fec220ee844daf8bbda27c2695d5f0', '欧·亨利', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('8b4778e08164441ebeeea6d95b9fd7cf', 'c43edf71dcb243abb13d32df9605a655', '超过规定时速50%', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8beab9776adf4138b241c6e6f6d98c39', '31d6d5f8eca34bb4a61e2e1a8c3e920e', '《西游记》||西游记', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('8c13e1b7294245caa866808743a9ebc3', '0e5354d337a04a798eac226820186f31', '谨慎超越', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('8c219a8884df43de9fabf7dc2b03695a', '0c275cc358cb4ce89f1b3ec29f12e7a3', '1／2', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8c2cfee60b87411dba8e894108799a30', '66e92fe6520d45c4a1bf8f88044fcbbf', '陶渊明', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('8ce53a7daf8643aca4fcb5f64eb4863b', '17dea05017ef40798942c26878d0b219', '服务业', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('8cf19cac27f640e8a5b7850bbc26ef11', '45973db3255b488d95dd892506748e55', '长江', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8cfaab3db8924663aaa789f7c393886c', '9953ff72acf24de6bd2f1cbcd83823fc', '太湖', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('8d10d3cdd08342a2b0e05775c7941ac0', '9709fb53a7ff4ab69c2c367644e36465', '回族', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8d35f2f253514bffb0077542e40b551f', 'a1559b53a84a430781a16272b58deefa', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('8dfc3d62bae8453494f9270042ec1b76', '6818caf6587c4cf6ba2468f91fc355b2', '四川', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('8e0c247c46f442aaa23dd59edf63884b', '844fbf79e30e4a35afea43592d0e40ba', '0度经线稍长', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8e1ee454d3754049be108eaa51f6e5e3', '5a69a43212544255ae8beea51f5f93de', '贵州', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8eb71137bed440778bdcbe66b8347f02', 'e90475bdc82d49cdaac7b6a29c068c6c', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('8f87862fc4b54ef58d2a1c7d33084a6a', 'f651657cef734285ae2ce13eade8d12e', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('8fb5acbfd9d54e31a7f9529b58a863ef', '17dea05017ef40798942c26878d0b219', '农业', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('8fc4ecfec38a47be97e913723d5666c7', 'd5da46857db946ed944d201fa249d6a9', '南京', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('8feec59cc4a5487da176cd99078291cc', '4e04138e31ad4946b83110d91be99cdf', '东施', 0, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('9033396eb1864ba99dbc65208bc5495d', '24234ed5714e429db9c4b24c897449c1', '理性精神合理化的体现', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('905ce99ac5b64a5faf74f4d05bbd353e', '111dd1c11bc349dcb3798cc0af0ba830', '以高原山地为主', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('906f8711078d436daef11e4f33170b36', '23e854a363f648089e6483a7fb28373b', '中国京杭大运河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9077030730844c7ab8e20c0e36d1063e', '05ee4104eb77411fb38753b28bb96a61', '东亚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9096efda2699408fa5f6da58e8a3b7ef', '9880957f04e940acbfd21c6ea49e1b74', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('9098945b835b41839f8be6003454386e', 'e76c1ff5ef234c7da6463916ae6a0f76', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('90d2f5e4165e4a4093e1e145bafd0906', 'f6a3abc6998c4615885e42fef3351615', '撤销驾驶许可', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('90e80af8b4694f2788b670cd69420072', 'a4ac8920a4524028bf76ec4f4831042d', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('91325fd7c4774838a77e523be8271410', '93e59078f5aa4595a202a401d92d1902', '15公里/小时', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('914790edac7a4800aa8974619f8307fc', 'cfe7c139d762415da4ca93d6013afb80', '40公里/小时', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('91649ff35cea4299bfb2aa3fe6ddd5d8', '865549d007ac4ec4b39ebaa154067f97', '1年内', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('91671c5039ce467195bb2768edc418bb', 'b2327d9428624b90adda2c48e1fd1dba', '城市快速路', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('917592252125492daabe09fa1634d425', '00739ffce4f34859ab29d10c6b45aa04', '印度河', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('918424f788474d81aca2f8357ef14f42', 'd481d614f7a74465829cf380f297ee0c', '左侧车辆先行', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('91881f75584b4748b28ef20ca860dd6b', 'd4d450cc97d54cb09a9526c5b687c536', '多地震，帐篷利于防震', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('918a66d91593479b8a3ff5a63262880d', '0c275cc358cb4ce89f1b3ec29f12e7a3', '2／3', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('91d466661866493b99e86ce1fa6e992d', 'e2ea1f15186f4d38b40952c4bc5b9b70', '50公里/小时', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('925f33fd889541f58a377985ad09d9de', '3e703277dea94e4982e6dfae921863ca', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('92634816ef76412cace418226e0d86d6', 'c160489406ef475aa39321789f639ddc', '长江', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9358b0cae8b5457a950a53be0e8eff98', 'c160489406ef475aa39321789f639ddc', '密西西比河', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('93612cd36bc9407283b1e2a262012a2c', '366473d42dc14d7eb39f4216320795de', '《登高》', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('93727fce654941069e308815efa80e23', 'b63c3ecbc3a04f31a18f3dc856e9b1c6', '民事责任', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('938c46f076604cdf8cde9f2ef9071b34', '3c741508e1a841298b61b4cbac9462d1', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('93980311a0f640b5b9f7c829ceedf9dc', '3e76fccc6932497a97f1a8a1b937d9bd', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('9477bf932ec74ff2b8911a7c5cc19e30', '49ebb77b0fcd4ba39843aa6266506024', '班固', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('94b6cca2deba4d569d3728b58e13b5b7', '1e003831250d4b5084df788402b328bd', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('94da25c53e1b458883afa827dff25ae1', 'a8187f2d23dc4015b5aa7920d01e2f1a', '陶渊明', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('954a4f29d674436dbe8331761ff59b95', '1c5cfda7469c428bb8cd59e1c899b497', '方向引导线', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('95feabbcb06f4215ac590b23ea0108ae', '844fbf79e30e4a35afea43592d0e40ba', '0度经线不到0度纬线的1/2', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('960d747d89704633ba88f7c3b719504b', 'ef7573e7a7494520b06f3662058f8d88', '伟大建党精神', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('96a63efb0a754eac9d994c8d2c0a3cb6', '42ab48c0fad041dface8a9f818f0635d', 'intheschool.', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('96d39f512bbe46cdbfbe71933913c0c0', 'ce6a147736394b9c833d51c81730bb23', '拥有丰富的石油资源', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9726af9b7402411694ebd0a9509a26af', 'a7ed08dcbe4548d98e5b3978d5471492', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('972f2540f64842e99f0c1972cad74de3', '6ad44a14a8cf4567940882e833e6af82', '齐齐哈尔', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9760fde8c9ff49b0bf1c115a9b9da233', '19646da51e454d3d910f07696cc1f1e5', '绩效考评面谈', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9771464d398f4fc1b250a42db38fd140', '539030c2c3814a35a429bf2ff055c3e3', '四次', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('9780c5d3e24c4ccbabbc6430b482ab51', 'd56b7d164cdc4334bef14e759e319c3a', '路口右侧', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('97d0122c98df4933a263250bea3bde9c', '5645ec3461994aa5b60c6cc0277ce660', '南亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('980c4cd705654683a364a6b525dca0e9', '2cdffda442df431a83897e1b661b94f5', '贵州', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('986b6ed0852f432d93244f89c1aae91d', 'be7eb38737a84544901f1f3b0d6413be', '12个月', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9873bd5b592c4955aa4f225679f87be3', 'ee11d2d88bf04f06af2d7cf9291180be', '农业', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9881e5b09f96409d9aed777caf2c0231', '1e7b506a034849fc9b075fd93c1e000b', '四川', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('98a3d42decc24d3cbfec8809947c9dab', '40e11970f558432692e1512b3560777a', '南亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('98a4fd376cc946a2be0239e40bcd8457', '6ad44a14a8cf4567940882e833e6af82', '漠河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('992051530efa4cca9f514c941388f473', 'fc4c68337547424ca09282fd9e2dab9a', '韩国', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('99359f00ce0c4d88b496f1f5a69f1229', 'c7d459694fdd47d7991c6866b9eaee8b', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('9971fcad1e494e4cbcd3c1e8de0e7990', 'cadd838ce5644a5e8de64e698486e309', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('9a2a321cf9454c5680be94495b3748ca', 'b9fea19edde44c32bfebd2953a080ba3', '苏伊士运河', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9a3fd2a9fac347a48f02eedecff27dde', '3e07606eca9c4043a91f01182e0f3560', '五个扎实', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9a4f6a87602d431ebf629858a1ce0fa9', 'a273bef0d17f41fca55a5710e136869d', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('9a886d09748f48e091ef04be828b6d1b', 'cd3b504c26a64a289f5c4ba3c9736ec8', '100米以内', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9a95e193b3924633be5382fdd7a424e2', 'c5c9df4d43d84396acfd2d84f1bc69a8', '6次', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('9aa42d1e0a374d7a979e14db473f78ff', '57585acc3e5e4648acdb62e512b7cde5', '保持匀速行驶', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9ad480a62dd4410ea98dead05f8f5ab5', 'fa223b30c8144440baa50130cbce6629', '6分', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9b7a5b89cd2b4bd09de6fdc6135e18fc', 'bc7946cca9544ef287c1a4df45842344', '马六甲海峡', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9b7cbb9c70ea4ddcae786ee54ac40b3f', '05ee4104eb77411fb38753b28bb96a61', '南亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9b870300f6914efd9c77d3fa156a2570', '172469df895c4f448e6b17f2a9ab7a28', '企鹅', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9b907c7c73df4f7998ecd88edfcab0e3', '5c0cbd150ebb4d45a51142fbdd174d69', '漠河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9c37bf32594b42a6bf84fba20090e0d7', '63659d404f694a8fbea7e1ea29126dd4', '沂蒙山', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9c491e0e6bb646d9bed6d69d2129bc9e', '61690c45efcc4e4d82915def333c0388', '多地震，帐篷利于防震', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('9c580ebc564247aa8e47e5154cac775b', 'fa223b30c8144440baa50130cbce6629', '3分', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9c659fd8ac834073aa7b5c9ff6fd1836', 'fb4b2dfbda2848da990cfdf1f0eff425', '从前车左侧转弯', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9c8735bae9d746beb9a0bd4731a8b5ac', '62815d180ad5487a80689235718c74ec', '白居易', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9cb5bca199cd423d92dacd0ea10a87f8', '3e07606eca9c4043a91f01182e0f3560', '四项要素', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9cdc66953f384381b0ab86b69b44e1e0', '6818caf6587c4cf6ba2468f91fc355b2', '江西', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('9cf1f7663ed64aedbd48609f68dc1a88', '42ab48c0fad041dface8a9f818f0635d', 'neareachoher.', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9d0dd6f4d1f840a98cf5969bb72da9c3', 'f703e4148f294f5bbc683591ffad0cd1', '提前开启左转向灯', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9d0ebd1b20934c4db63df43f00a871c1', '75c0ec5e6f044d5781a6e3f97a80c70d', '主动性', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9d21ec85953a47c1bd6d7495dd5f2db6', '8f797d0583bf4e8eab911b5ace56347b', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('9d396bcc78c14cb6ab5d6749e9bf1fe3', '2be24ca734cc4ad6b9bd1c59c605f9ee', '四川', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9d3bdc02159d4bccb0036619098bf39f', '091de7090a074c84ac13663c6a0a5eb2', '马来西亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('9d53371e95e04e459b6a7bb6f9682cb0', '64f7932716094d7cbd13fcc11c71dd3f', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('9d60d466ea084c76bc21ce1c1f23ae2c', 'ef7573e7a7494520b06f3662058f8d88', '伟大长征精神', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9e1edb224e3e4c33941dc858a1fcf999', 'f6135ba3e43e4197ad63725defab5fa3', '哈纳斯湖', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('9e390698f3ef4f5795c3cfe71b67d5db', '6e90badbcf0f4e419c49ec170ada3698', '铁岭', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9e4b5b7002954a859c462c61d9101fb9', 'cbb1ac87f94a4091a0e2541995562959', '四个力量', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9e5652a388c3489aae38ef500666882a', 'ee11d2d88bf04f06af2d7cf9291180be', '建筑业', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9e5a99dba0a1429d9e53cb717539a4b8', 'be7eb38737a84544901f1f3b0d6413be', '6个月', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9e7a71dbea3d4f658c42048c722310c6', 'fe52a0bf9c764d458db7f83b6627d1a1', '西安', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('9e9797a0a16f42f081fb33ecb39f31ee', 'f3b05dfd35c248a6af6ed0097b69a768', 'playcomputergames', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9ea7e16fbbcd4960b53650cfc1d88f9f', 'c1304045e0064618ad660b64727e35ab', '加拿大', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('9ebd2fdf4c2847d1af93ceffde82c019', 'f80aa11cbbb54294ba1646c732607126', '猫', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9f1ab3f63d934026bad23eb3b93184aa', 'f53c81b561b14148b07cdaf1ff26f99a', '电话调查法', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('9f4292adb9894a58be0bd3900efbc79e', '45973db3255b488d95dd892506748e55', '尼罗河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9f581e17afd94055b178e2615ccc9017', '24234ed5714e429db9c4b24c897449c1', '适合现代大型企业组织的需要', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('9f7fb042e3f24f508f33d22af36f5409', '844fbf79e30e4a35afea43592d0e40ba', '0度纬线稍长', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('9fa27401aa9046fd8c46aa63c1dbb06a', '1e9753bae29d45e1a3df89a492d80062', '靠山体的一方先行', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a00b625d5d3b4f4ca326639c8b7c87ff', '20ec59fa41274d28af5cb4c1f8660d33', '未携带身份证', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('a01cddf0a2c84fca9b5046bd68d4dc0d', '8ee2ce33144d4d19b625a6bbf4037da6', '韩国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('a0626090203a469f8ac514a704b8f8d0', 'cac21902890c41de8db1f54960c1e29c', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('a0ab2998f4194aa58533aad7a47e5f6a', 'b9092609e6414a3f8554a7c6206f949d', '南亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a0c609b2a51b42b08b3733155829cb56', 'ee11d2d88bf04f06af2d7cf9291180be', '工业', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('a0dbf421091d4cb2b3b5dfdbb164c4d9', 'c8168cf32c8e4b1b95b0d956b2cb159e', '非洲', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('a0e277fc20b047f6a807a2cf7af9f47b', '4793eebea0544f03951476504134ef3b', '关闭所有灯光', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('a12f7133711040c5872f5fc064ecb407', '9aa72e58b8d94d57addea9f776ad15fa', 'younger than Max.', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a1680704fca149df8bd9098d1a48f407', '699b5e55acd04b57a0584016f6804494', '将车停在道路中间', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a1b5102b51df45be8caa35ecbd6e277c', '80017f2fd4814067bbfe9e1caedf85c5', '杜甫', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('a25b8fed8eae49bd887c1a89bdcbf3f5', 'c93e2b98a7b447c28755bc7718282fc9', '累积记分制度', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a2a379dac088472db86b29d4a69e617f', 'cea0ede781d748c8bcb300bd71612430', '50公里/小时', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a2a8a5da648e45a38a48808c61abe56c', 'b2327d9428624b90adda2c48e1fd1dba', '城市高架路', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('a2c70851f3d04ec5a0d73e31464f8810', 'f80aa11cbbb54294ba1646c732607126', '牛', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a2cc5c6420f84d25b9ae4d813636770c', 'e6972780de4b4407bd3e571e0c995139', '日本', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a2f6eb0d3d1e449d99f5bbb93bab31af', 'e4ef758c45ca4ee3bb14b834ab7563de', '水仙', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a3085868213c49928a50c1ab6a50c191', '04d3cc8511054f91b1d7d90b3a781a7e', '驾驶人身体条件', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a3cde98d7fc6442f8eaa9c4a0cad219d', 'c717e33f7a4d497e8a69bf0877c91e0d', 'A. 输入的字符串中既有 P 又有 K', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('a3e03ad7c5dd4430a764f365f10a8a78', '865549d007ac4ec4b39ebaa154067f97', '5年内', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a4dc060efa204fd7b98225e44b6cdd40', '28e1925ff8e743ddb1dff777571bbba3', '恒山', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a4f7c31d78ac475f9ad1f4e488985e10', '33ab87bdc551457baaae58efcae0ae85', 'hismathshomework', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('a4fe8ff6a361499c918873a102e20698', 'b0ace503d6524c28b1dd607a57c105e1', '居住地', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a516fb07b8fb476cbbda1ef51d7ddfd5', '5d2ecd3950ef4fadaed89e21d1a52185', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('a5174afc9a9249e7988c42962b423b2e', 'df1f8c610ef449378839098c9fce5c07', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('a535c74af2074f758cc1cf82f33b2673', '4837110c21df4c4aac1950993777bbb0', 'thirteenyearsold.', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a53cfe049fc1485c9dee31f6d0a45f2a', '03d06173efdb49d3a151fb48528e40b8', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('a592539465d2498a883c425a2d5144dd', '82af113d1ebb4a849f7d145d670255e2', '时间差异', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a5c490ac63ff482686f70fa72c3dee54', 'c24f9337e21d4bf18f1fbadc71351dd5', '变换使用远近光灯', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('a741bd2bbca94394a643cf0d3b9514b1', 'fda5df61229f4eb182ee326bf508f6e2', '50公里/小时', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a7973f8dd2b447c8ae786e065b42758a', '61690c45efcc4e4d82915def333c0388', '地处热带，是干旱地带', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('a7b159bf986845eb9ea4769a9d619de9', '62815d180ad5487a80689235718c74ec', '陶渊明', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a7d05ea6ba1242bb9ddc1d560197e3e5', 'bd082aa0a7c04762bb94ae20c06b07f8', '北亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a7db2409ed5b43f6a5f5d4c9dfea33ea', '27e7e29689884b93a77c582f8916e356', '1981.2', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('a80f8dccd5934f0d920bf76ea27cd4f1', '9ddaa641580c444382d4ab969e53e1a9', '多地震，帐篷利于防震', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a8e6d88a933749828d753c1f65388a99', '6343c1792ddc452c81a2974d60a0b767', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('a8e931ceaf3c4b428d8a92204104eb58', '39fec220ee844daf8bbda27c2695d5f0', '莫泊桑', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('a9068afab2d44a22bb08c1d32b77773b', 'a2457c9c44694a859223908831941002', '机动车保险单', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('a984f949e2b14522a64bb01ac3896346', 'c2f0101bb13d4d3abe38654b083c5c8e', '巴拿马运河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a9d9a282013e480695b82b602159312f', '8ee2ce33144d4d19b625a6bbf4037da6', '日本', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('a9dda476dcd542789b9ea5fe26da3b05', 'cd3b504c26a64a289f5c4ba3c9736ec8', '50米以内', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('a9df639e80d24a73abb3f7493473da43', '46c13edbaf394c6d8de5166453fb8585', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('a9e081a7e75346f8a9c683aded2f74b6', '859d2670f7444e969b45414108b00bd4', '基础性管理制度和规范性管理制度', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('aa364e022d4e429d858baca73f9734fd', '936dbd23bc2444eeab58fcf1a2b8d61e', 'play sports', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('aa3b18cf2b5b46ecbbf6e616ce1706dc', '19646da51e454d3d910f07696cc1f1e5', '解决问题式面谈', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('aa53acb918de460aa56be3e9c11db521', '9856ef743e7848e9b94a61d8646519f8', '俄罗斯', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ab642085a29449958e9e0637afdb512c', '3e07606eca9c4043a91f01182e0f3560', '五项要求', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ab98b3978b154dcdb334c3c4e3f8c9b8', '7489a2978c8c49b49b8aa38dab4b0b56', '培训的费用', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('abcd7c1f200043b1aaf55569407d5eea', 'de9e4f6598e449ccb4a82533a2fab283', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('abe10a2c2f574f2e99e6364de2b0d875', 'e243b3bf70a648ec8da08c93f55af26d', '杜甫', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('ac2bd9b1d90a4804bd73bce1ac839e2a', '8bc89d7af5924f1d8a833379691868c7', '吊销驾驶证', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('acabc51a965341ddbc3b28a0d3d8b89a', '61cccef6dd1e4dc8a5eb111f597b05fa', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('ad830ff809cb48468e20dbe7981a716b', '2315aae4c4394970b9d66b2f83497250', '违章行为', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('adadc4edaaed4c5780ac330fd64952d4', 'b2b38e020597434ea12b925ccf4d286b', '西亚', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('ae2449e92cc444ac8fef5073e57e391b', 'a59bc2eea3bb4ecfa0fffd7abbd2b017', '16个月', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('ae37778e3e734ad39d651684a1c47d48', 'b2327d9428624b90adda2c48e1fd1dba', '山区道路', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('ae393858c42f4621b555d84e27a90901', '3c63ae9e3dae48d886997c320c863de7', '机动车驾驶证', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ae644d1b98df48cc8f215be3c9271b82', 'acaa83033e5f4d4a8df87f75b858cda5', '拥有丰富的石油资源', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ae8c9308095d4c8795abba7cade6197e', '699b5e55acd04b57a0584016f6804494', '将车停到不妨碍交通的地方', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('aee586c642654e2fb6775432e757e7d4', '7a3245e9a7cd4072af43f082fc9e0851', '叶尼塞河', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('aef1f640941142978d15479e61eeacab', '23af7575e20440ccac4b0e5b3b2f6bc3', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('af3bbc7857a847d6b749f992fff06d7b', '6a6d5ba7ca0843f6b82bd7b0582bf977', '西藏', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('af9e58ad98d44ab799faa54b57e00b1c', '936dbd23bc2444eeab58fcf1a2b8d61e', 'play computer games', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('afd76d0c24ce47f1a3567decbb962b4d', '4eb53a50f92b4bd29ee4303b454d5fcd', '关闭前大灯', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('afde20dde7824d7285a8a00a4a9aaf87', 'b26d01494783429f950ad2c24a541958', '韩国', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('afe91980c0b34331ac331513ef4057e2', '8bc89d7af5924f1d8a833379691868c7', '处10日以下拘留', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('aff946fb5eaa4700a9e4cfa280cb1467', 'b071cb6cc49d4899ad3177bd69426952', 'C. 输入的字符串中既有 A 又有 P', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b01aa4bff1224f929ad1633fbd591fa2', '844fbf79e30e4a35afea43592d0e40ba', '相等', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b0aa284400584c67be3ac6237f5e67c5', 'da7b62c3dbd949888f8e19d294ed90cd', '10小时', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('b0daf93c7d434011b913600eabd7f83e', '66a8fe46f7754647a663424d8c566909', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('b13d65d13a444d64a45232765d5eba6c', 'f27db377b6784bafa9eb1bdd93d770e8', '绩效短板', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('b1476080bd6a49d482767bc302b708b6', 'b448b53af2d7457680d117ae26310805', '禁止车上人员下车', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b15d86adef884a0e996160aab531bbc8', '3d002bc9bc344878a9a6c79a351cc8f9', '地面起伏很大，中部地势高，四周地势较低', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('b1dfb3ffd9fa48b8808ece7b88f5e925', 'f53c9e9b91b84ce5a3d7da28b3d11bbf', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('b227976fe6fa47b18714cf089299900c', '17dea05017ef40798942c26878d0b219', '工业', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('b29a484f69e448c298a19e68add7c5ab', '63659d404f694a8fbea7e1ea29126dd4', '泰山', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('b2c6c56befe04717ab5ac340736bd0ae', '7f894a46cade48d2822d3cfe355903c0', '洞庭湖', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b2d23bf08b8b408cb648e8e24c147f7f', '4e04138e31ad4946b83110d91be99cdf', '王昭君', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b3a25d7dd23f4690a7a6228b7fc2924a', '2b008d983ae94c30ad6cd97ce173f05d', '马来西亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('b3c4277e7f2d4575b67aa550370df595', '0bc3d45b603e43f0834bf670d32760cc', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('b3efe97d453f4f33a4e5c8721b7cb5f6', '9d138585bc7c4d10904f33a0229d59c2', '处20以上200元以下罚款', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b3fcecf1d575422faaa911c1e8b7a5b8', '7c2eba01aaaa43639d9df205cd66ecb7', '西藏', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('b4bfc4f69000435db5b6359a4e21182e', 'f53c81b561b14148b07cdaf1ff26f99a', '随机抽查法', 0, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('b4d50c44bc5e4a6b9134991aa314637e', 'a26e2923e543499a8ba9b41d4ccad0f0', '南昌', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('b4f536f2a89c45778c223ffacaf1d5e5', 'd4e72144095d479b9b25cadfd45a293f', '漠河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('b543c3c493c84d3f83b6352cb905e95f', 'b9092609e6414a3f8554a7c6206f949d', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('b55db47dcff045f6a314908a31fc2fa0', '85e6df3aaf0c4b65bbf475ea2e72e702', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('b5c3011b095846ff92bce31f9ed1376f', 'cae8e39074294a4ab8a95d17018a1867', '单向两条行车道', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b666e315122143959947c33a303f2a35', '14af07de63c0493d8ec7f4554bd86d32', '它在玩耍', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('b696a9ea7cfd4a4a84dc8347005ed6d8', '08f8b219924948fc8c4206b9c1ad590f', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('b7327b5ea9d14aa7bcfcb05efd2c9483', '62815d180ad5487a80689235718c74ec', '李贺', 1, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('b80688ad8cc949ab854765650ea8b84f', 'f6a3abc6998c4615885e42fef3351615', '强制恢复车况', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b85991e839994fa985aa711b742e02fb', '0c275cc358cb4ce89f1b3ec29f12e7a3', '全部', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('b89d78293ad84bf4b72a8ea4b3cb9a28', 'cbb1ac87f94a4091a0e2541995562959', '六个力量', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('b974798474ea4d63893c57879c323ed1', '4661ff6da9cc4d299cb32f054b2273e3', 'in the same house.', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b98913c83a374af4a87c735d97fea7f4', 'c119b25655f245e7a653fd55f7fe41bb', '壮族', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('b9bca0c4961a41ca9ffec268e6c93bb7', '11a51e9754cd4cdf95ed8203695d6003', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('ba6dff52d39c4bb0a94171e17a566f1f', '75c0ec5e6f044d5781a6e3f97a80c70d', '责任意识', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('ba7d91ad73964a7a9dda0b0cd2cfaaa2', '4978cd0baa7a484bb966a7ae8d6bbcc4', '太行山', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('bab92b3f5cdb4dfbbe656e7f97197e90', '0b6a5a93d9e8453b80f26c122f20c81f', '企鹅', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('bb96356f207f47cf994d89ed3811710d', 'f80aa11cbbb54294ba1646c732607126', '马', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('bbf5ebedaf8c446f830c0ceae0cca4fa', '6a6d5ba7ca0843f6b82bd7b0582bf977', '新疆', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('bc4404553ab1411abf8fed88792e58ea', 'ed4499d413874fe9b3f491ef62a1f0b4', '四川', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('bc68f72b6e8a432296c8354540429fec', '9953ff72acf24de6bd2f1cbcd83823fc', '鄱阳湖', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('bc9af8527b8a4d228cf168eea02c55be', '8bddfb2febcd428594817d0a25df58ad', '年不含销售额为150万元以下，会计核算制度健全的从事货物零售的纳税人', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('bd151eab92834678ba223fdf9abd49e6', '9d138585bc7c4d10904f33a0229d59c2', '吊销机动车驾驶证', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('bd8a0a037fea4f07b7e81f194a398611', 'e243b3bf70a648ec8da08c93f55af26d', '李白', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('bdb2cf20df5f487397de86a2af39bde4', '4837110c21df4c4aac1950993777bbb0', 'twelveyearsold.', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('be411a347cd44aefb6c9fb4d431690d6', '27e7e29689884b93a77c582f8916e356', '1985.2', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('be628d1191da4fd2a6fbe9aa826abde1', '4c62642f99624ea5b705282196f62ac0', '1', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('be72ea9ba2ff4b8eaccd41b5b1363ad5', '71153b61fc98484db5955fba15aabedd', '白居易', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('bec64454109a4fcfb83f9e476046bb72', '71153b61fc98484db5955fba15aabedd', '李白', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('bf145945caae40c0aef944ef6afb4060', '060910f16c3b4247abd3f9c32bac8f4c', '印刷术', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('bf214d7487924dabb09654d6961b578a', '859d2670f7444e969b45414108b00bd4', '规范性管理制度和岗位管理制度', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('bf4e39c4fc3b416cb017a673fd7dec24', '3fcc901fa2c24167ac1027705299579f', '西部是山地，中部是平原，东部是高原', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('bf641c50d68046f28a1ba81a2aa9738e', 'bad3f168e5d94860a626593ff78c6e47', '记分达到6分', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('bfc62126392e42578feae067d27fb95c', 'f3c1d614bc3e473c864cb593f718737f', '尼罗河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c03494d9d297424cbda731066309c72a', '9ddaa641580c444382d4ab969e53e1a9', '雨水多，漂流多', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('c0443dd4cf0d44fc8975e7ef33eef484', '8c24ebedf58b4e7c83b67bdf95602582', '马来西亚', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c08596e29b1a4b8f89931e81088d0588', '6932483968f24f50895576a52a7b6c7e', '奇函数', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c0afbc6034a74cf08e8f2e318d8407a2', 'dddd0101c95b44409907656c2291111b', '不让行', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c0bb361fa7b74d3d8ff24820f34b77ee', '5a91af1341964d5a86edd285ead46004', '南京', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c0fc19e8d3ea4821a96a5aeac5a19a6a', '520d2cd433504796bdf48eb9424340ab', '第三产业在国内生产总值中的比重大', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('c17c772b64194c19abe17463afba6289', 'ef9c783eec6c4f07861cca1974b359eb', '壮族', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('c1988c086675439fb733276d638542fd', '4e04138e31ad4946b83110d91be99cdf', '西施', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c1f913d8b0a3483aba907d72e9f6705f', 'b8f4a236f75b4acd802789742e7ed025', '1981.2', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c27aba8b65904e13b1608f44af4fa685', 'acaa83033e5f4d4a8df87f75b858cda5', '大力发展出口加工工业', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c28125ffb3b743da91243a4ee8eb8ba9', '11843e16f1c14ee3b95c4e35dd8104a0', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('c2c7140049e64381851a6201e8540325', '1e7b506a034849fc9b075fd93c1e000b', '西藏', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c37582a0bb5948cc9ce05a24226ecca2', 'b071cb6cc49d4899ad3177bd69426952', 'A. 输入的字符串中既有 S 又有 P', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c3b2e36dadf8444c8546885f8a4d7dd9', '4978cd0baa7a484bb966a7ae8d6bbcc4', '沂蒙山', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('c3cd445acc2b4a11b2aa83db10c8d8bf', '45b256005ba14af6ba1d5c98c3de9d43', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('c3f91a39f2104c328b9a1aeb44a739eb', '3fcc901fa2c24167ac1027705299579f', '以高原山地为主', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c3fac3e51c6846b28f1a9eab6a6a938a', 'd4e72144095d479b9b25cadfd45a293f', '沈阳', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c4234c269d07498c868e6fa80608c182', '3194ff0c260d4e0290fbe6c04f20636a', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('c4792a752b0f4545932b4ab4d1e1dd25', '20ec59fa41274d28af5cb4c1f8660d33', '未悬挂机动车号牌', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c481969c44eb44a0a5027097656ec25d', '88f9f8ba351f40c3afdd24f5d764b6e6', '0度经线稍长', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c4dbd42206d8498e8139092602b98274', '2d4aa0587840430bb63d7c8ce79af339', '土耳其海峡', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c512e6b31cac4c02975327277d442d7e', 'f80aa11cbbb54294ba1646c732607126', '狗', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c51b30d130f6436caa9fdee520df8535', 'c2f0101bb13d4d3abe38654b083c5c8e', '苏伊士运河', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c550b95cb34f4da6bdd707be40c1ef35', 'ab9e817894024513b625fb3e61633090', '陶渊明', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c604744e95ec46bba4087de247349fec', 'c119b25655f245e7a653fd55f7fe41bb', '傣族', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c6657f37a5244b77afdb9c75721e76af', '3f51e325a16d46dba9ab791b6f1e1bbb', '驱动轮', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c6927473cb44419d89e4a731b4316b85', 'a273bef0d17f41fca55a5710e136869d', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('c6a7be7f468e4ed495a699447606a017', 'c56bd615a5b44b288800b5f067845db3', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('c6b3651dfbda4a978aa292748dbc3da4', '71153b61fc98484db5955fba15aabedd', '陶渊明', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c6f0f8588f1a447185e24d2c9aef57ef', '6e90badbcf0f4e419c49ec170ada3698', '齐齐哈尔', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('c706b5a638c94b72aa5d5d8c2120bacc', '6818caf6587c4cf6ba2468f91fc355b2', '贵州', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c76d56a16007418881bbc73021e8e989', '0c3d48ee7fc74f0bb201e377acb0f756', '4', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c7a9a5331def4d0883199dd2d1bc2e46', '33ab87bdc551457baaae58efcae0ae85', 'hisEnglishhomework', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c7b089c5341243b8b66e85b1d757d9a2', '7f894a46cade48d2822d3cfe355903c0', '鄱阳湖', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c7bc4fb306664ba2abeff0cd5ea21c3a', 'b1caceff25914b3daed4ca946ab423f6', '处200以上2000元以下罚款', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('c7bdd74c07c1450c875b769097515f46', 'ef7573e7a7494520b06f3662058f8d88', '李贺', 0, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('c7cb8900bfa049d7b13ec594cc01c0ed', '4b958cb5ce26442db434a23d56fb6d3a', '进行法律法规教育，重新考试', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c7d4d82ddd8b4ec5a71e0b8b4c049656', '3f74f08940214b829bc9636f644b7d61', '洞庭湖', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('c80ba3b51dc24cae9b371ded05917c78', '27fa1550e3314b2a82d2493cbc4b0373', '四川', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c88c1dc71a6a4f51983b84edf7813872', 'ab07439ebf4249f8922e87c14539606e', '停车让对方车辆通过', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c88df016371d4fd3a2f4d658bb03775a', '80017f2fd4814067bbfe9e1caedf85c5', '李白', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c8d97c0535104a719ceddec998a150f6', '20ec59fa41274d28af5cb4c1f8660d33', '未携带保险合同', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c8f9e311183f4dbd89141791a3c7d75a', '75c0ec5e6f044d5781a6e3f97a80c70d', '沟通协调能力', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c91170052cb44908b423468f620ff332', '1e7b506a034849fc9b075fd93c1e000b', '广西', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c92d118748c44063b3ffaa20640b9178', '19646da51e454d3d910f07696cc1f1e5', '总结反馈式面谈', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c981f0682ed94bd5a465b62f65b65052', 'c93e2b98a7b447c28755bc7718282fc9', '奖励里程制度', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('c9877e79cc394892a92c3406cb0b3842', 'd80b1177c88d4275a63cd408c357664c', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('c99b61d1002a4b0c8531213e3b03333f', 'ba81a13b14dc4e7f8cd4982ed3f04bad', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('c9a64f27d9b149dbbf764bc1c4dcb34f', 'b448b53af2d7457680d117ae26310805', '开启危险报警闪光灯', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c9b0d27be65945d7bbb974d93d6f3edd', '57585acc3e5e4648acdb62e512b7cde5', '按平常速度行驶', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('c9b9eac1a2514613866d8c90768ec189', '5c0cbd150ebb4d45a51142fbdd174d69', '\n沈阳', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('c9cd762ababb443991bc944a4013d794', '859d2670f7444e969b45414108b00bd4', '基础性管理制度和员工管理制度', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ca0f01551785430ea2240023b24c9e0d', '43fab8135e6f42f3b39eb69cda2ced24', '陶渊明', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('caea0cbb577f4ed5817b7bf7b11f55d1', '4ae568501509423a9406cb5dc38d3e29', '1985.2', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('caee3f9e188c4368b499f8ea17a0b7e2', 'f53c81b561b14148b07cdaf1ff26f99a', '面谈调查法', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('cb25b91ace9645d8884729f6b493805d', '7dc44d23727049c3abb5e0b738a79d97', '猫', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('cb72a9fba3a547058df4d023dd82e224', '88f9f8ba351f40c3afdd24f5d764b6e6', '0度纬线稍长', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('cbc1f2a724404409a7785c6e60100302', '91f9535fd70747509647e12f81279d16', '诚信是做人的根本', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('cbeafa5a605942a7be89d10c05638cc9', '514f9d7e2ef14f0591f1e8b95da532d1', '建筑业', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('cbed86135da04918b7106dbb831b0a8e', '4837110c21df4c4aac1950993777bbb0', 'youngerthanMax.', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('cc378a97e9644b868c7c82f8ef571a52', '6c70b3ef6e1143e0b86b9c18be1b7959', '土耳其海峡', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('cc8ea2597b3b45e3a7196c24f431ea22', 'b63c3ecbc3a04f31a18f3dc856e9b1c6', '刑事责任', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('cd15574c724a4dfebe2e1d6061c62347', '1e003831250d4b5084df788402b328bd', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('cd945cdcb5894efb8cdef2a79f800b5f', 'ef9c783eec6c4f07861cca1974b359eb', '回族', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('cdd0c1d58a9741c6bc34146cd719c63f', 'd481d614f7a74465829cf380f297ee0c', '加速通过', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ce35b5ee7e604156a30f842651418d98', '66e92fe6520d45c4a1bf8f88044fcbbf', '杜甫', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ce56ade583d74066a0398a84a98e54be', '28e1925ff8e743ddb1dff777571bbba3', '太行山', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ce8538a9fcaa44ab88de2b1ba86a2083', 'de9e4f6598e449ccb4a82533a2fab283', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('cea40f3cc79e41ada76b3d6341551d7f', '57585acc3e5e4648acdb62e512b7cde5', '降低行驶速度', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('cecd035412cf44518dee88f198df2215', '62815d180ad5487a80689235718c74ec', '杜甫', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('cedfbccf78c1427e8cb46d5d65173adc', 'b9d77f5317b142e1adac070484a4425d', '劳务派遣用工', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('cf33c65a7cf64896b2c4f82deb985241', '6818caf6587c4cf6ba2468f91fc355b2', '湖南', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('cfee2ea6f52f4225bd73786054a9a8ff', 'a5459e7d9d67454ab2bf90578489ce9d', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('cffce309c1b548dcaa7a2288686d5544', 'f9e0726e82cb40289f96a929987296e9', '交叉路口', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('d04bdd5fceb64a1e97221b0ab2a34483', 'f6135ba3e43e4197ad63725defab5fa3', '太湖', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('d094c00db2134639a70bb857b03addd9', '842cf1df6a71424bac98dd9faebfaf56', '陶渊明', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('d097d80be6774b89b15c5c4e243b987d', '7c2eba01aaaa43639d9df205cd66ecb7', '新疆', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('d0a7bfae44a34d71ba6a86a59e17628b', '6343c1792ddc452c81a2974d60a0b767', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d0c438dfa6ee4f229ecf597d8f54a52a', '27fa1550e3314b2a82d2493cbc4b0373', '内蒙古', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('d0fd455423ff4457bb36648e39ff7f5e', '07ea3d4ab4004523be6636a3d0b82dd6', '澳大利亚', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('d14499cbc9ad437484c2277e735e9f38', '91f9535fd70747509647e12f81279d16', '自然万物的客观实在性', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('d1944087c66441998cc08bf0f719d36a', 'f53c81b561b14148b07cdaf1ff26f99a', '上门拜访法', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('d1b3475b2f0d4e3d819f2a0bc202abb6', 'a26cb4e5845644dcaec6884a89de7ff5', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d1b91e808f824725aa02a2a3a733f5cd', '0a3f8a446fcf4654aa3f351d816029d5', '西部是山地，中部是平原，东部是高原', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('d1d883524802407aae8c01fdd3a016f0', 'df1f8c610ef449378839098c9fce5c07', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d2007bed90f34c9faf31451b51a7d49d', 'd80b1177c88d4275a63cd408c357664c', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d2c4957d9eef4f2a964230c21c0ab8ca', 'b1caceff25914b3daed4ca946ab423f6', '依法追究刑事责任', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('d2fc51a97b61476fb3ede5ad74d6d627', 'c81bed86ea944ccd853af1f6b4a834d6', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d2ff0a53941342f6a4a4eef432fb5ad4', 'c56bd615a5b44b288800b5f067845db3', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d355a12d5ae646eb9f533d087dee5e94', '66a4c357ac7f4f0f837caf185beae248', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d3d84bd207994a2099e8341b96e6c242', '49ebb77b0fcd4ba39843aa6266506024', '马相如', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d3ed5410f31941ba9c567ac3712429e6', '6932483968f24f50895576a52a7b6c7e', '偶函数', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('d407ee7ea73b4a6397a4311bb4a32d7e', 'a2457c9c44694a859223908831941002', '出厂合格证明', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('d48023301df549fbbff6248fa60f89d4', 'fb4b2dfbda2848da990cfdf1f0eff425', '依次停车等候', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('d57f57c3220946b6a4afc344eabb5514', 'c8168cf32c8e4b1b95b0d956b2cb159e', '大洋洲', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('d5844e06539d418c93776475843494cb', 'e4ef758c45ca4ee3bb14b834ab7563de', '牡丹', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('d586a68e1e6c4743bd2a409c9cb19739', '4f37cacdd8bf4a09b4be561c84eafdfd', '参加道路驾驶技能考试合格后', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('d5acbe4df0de4ef787304ffb867572c9', '00144a9784b4486ea59f4c44ac888769', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('d5add0fde306416fabdb2284f5e0d94e', '366473d42dc14d7eb39f4216320795de', '《将进酒》', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('d5fe7997bdcd4a2883c6944bfcf318be', 'b36d73fdf1c4423ab38bb367ab23328f', '迅速停车让行', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('d6081b530bd64a3190efe8826a51bed6', 'c777420b32c14e3cba84dcfb8ee6b4ee', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d69b5f006150427baa5dcafef1a70278', '6c70b3ef6e1143e0b86b9c18be1b7959', '直布罗陀海峡', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('d6f77be710434c61927bf9ea3a124ab7', '7f894a46cade48d2822d3cfe355903c0', '太湖', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('d77aa1f79a0347e3b150afe274dac068', 'b0265d784e8e4633b7e13f5dc62b9d50', '工亚基础雄厚', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('d78dd99cbff247359b3889da409bfca6', '7489a2978c8c49b49b8aa38dab4b0b56', '规划的实施', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('d7981e55826e43c08df8de3c14b040ac', '6ad44a14a8cf4567940882e833e6af82', '沈阳', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('d7ec488497064f14880a3b78741d7437', '5611e5efbed5499e87f3c5cdf7832cef', '50公里/小时', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('d8010876e9d749d1945385a0d6c716d7', 'dd38d23c395b446f878d47dacf7d0fff', '正在停车', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('d85aa81f1f214c638b37ef0e0f43e709', '63659d404f694a8fbea7e1ea29126dd4', '太行山', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('d88f362668004b09be54ef9dd5d29bde', '77c8d1b8e5a04046a3ba2843bbc7c486', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('d8d1bd2f2ecd4fb68c424f82f46128da', '82af113d1ebb4a849f7d145d670255e2', '日期差异', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('d98625ff33654e82b526534dfa211f75', '7f894a46cade48d2822d3cfe355903c0', '青海湖', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('da03c6c36e4b4e53b04497f5060184a8', 'bb4195c345d0484487631a4b521e4502', '韩国', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('da29936d27f2418bbae90073978b24c0', 'f6a3abc6998c4615885e42fef3351615', '收缴驾驶证', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('daa5ab607e4c4b83a8b13c61a09f2f0d', 'c71aeeae981845a3bfdcfc38d34497a0', '尼罗河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('db03d52cdb734b4d91aea2ad38760879', '6a6d5ba7ca0843f6b82bd7b0582bf977', '四川', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('db4d57caa9884d4b818de4bcef9ca6d0', '46c48012bd254a4ebaf40dc547d94595', '出厂合格证明', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('dba13c7bb9ea46338371caa890650920', '4c62642f99624ea5b705282196f62ac0', '1', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('dc52a2b9a9454133b9af18915c55e17e', 'd56b7d164cdc4334bef14e759e319c3a', '路口中间', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('dc84ec7d67d24948a61eebe362551555', 'aeca8916be004d77bf23140b6a4c47a5', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('dc8964951e4b43918ef51b35e63eba88', '28a78e2127da41b5937c19b49f0acdb3', '\n总体国家安全观', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('dc9b61579f484a7eab2f70de8524fcec', '514f9d7e2ef14f0591f1e8b95da532d1', '农业', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('dcce226d3a474d72b6e50e5b15b61736', '9d138585bc7c4d10904f33a0229d59c2', '追究刑事责任', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('dd03f3d414c84e7e84b2bf560096b726', '50c7a43ffb1b4113a7046227f2fc879f', '孟加拉国', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('dd2b7359d2d64f2cade1ad888201d292', '029f7977ee744d9487ee5b1ed596a64f', '《琵琶行》', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('dd82029a721e4a09b32189c30c5f5df2', 'e0171593dbe34c03a15f1fcae101c86f', '注意避让标志', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('dda9142fea054412b9e21fbc472e7d2a', 'b8f4a236f75b4acd802789742e7ed025', '1985.2', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('de324d5dfbb041c2884894d425b44eb1', '391d4f9f7b4a4996b3004616ce29b7c7', '青海湖', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('de4a36afbd2642d09dbdd7382ea08ce6', '7c2eba01aaaa43639d9df205cd66ecb7', '内蒙古', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('dec9704f5a6d4e049c3fb9f4eb1f0a89', '4837110c21df4c4aac1950993777bbb0', 'orderthanMax.', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('df2d2079c6234719baa2e0125fa45830', '7b0128511a574a709bdfc9f745b1db0b', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('df39f23056ef4af888ffd3408a548696', 'a1922aafdafa41979769bfd61da548a8', 'his maths homework', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('df3bd578bef949d99a4e635f5bb7ddd1', '2d4aa0587840430bb63d7c8ce79af339', '直布罗陀海峡', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('df6b4ebd60dc4e99811152dd71473d02', 'cae8e39074294a4ab8a95d17018a1867', '交通流量大的路段', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('df6f69adf73443ceab42f661ae9a8840', '7ab30154c23243a7837c91760778bddc', '土耳其海峡', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('df746ac334be4f2aad8b11744dae83e0', '7b8db996799c459ca22beded29f050cf', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('df8ec9f416e544a083df0c403d655d9b', 'f6135ba3e43e4197ad63725defab5fa3', '洞庭湖', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('df9d5b54f79142e19dcf9b377779de57', 'edf3fba0b93742da8b7931e537783190', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('dfdf219be4f44c3e9e686ca8ac5627ce', 'fbf302624fd14e75a940afa7fd07d0cb', '依次行驶', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('e05a6575f03b43778920d8b252a7541d', 'cd63230177f54d0490ac6e7e05133f57', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e05e31ce632c4b1e8459934fdff58711', 'b9fea19edde44c32bfebd2953a080ba3', '巴拿马运河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e0eb2d42bbbb42cb9878fd8553659ab4', '773afc7db8e64a9887bb8d9f82ccf497', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e1966511230b45e4a5b3a7eaa8757f93', '1e3ea59523964a3fac5a4a30ef046a53', '齐齐哈尔', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e1a44ec882054b729700d1549ac8c89c', '539030c2c3814a35a429bf2ff055c3e3', '一次', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('e1f3a6782de84258ae1a63071ebb2324', '5d2ecd3950ef4fadaed89e21d1a52185', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e2db63994a9e4e7ab3c1f1b709454bec', '65e96030cde648d5a0bf9ae570122cce', '四川', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e32e18096ada47e78bcaa7a41bfd2e46', 'fda5df61229f4eb182ee326bf508f6e2', '40公里/小时', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e35c94f6250d4a3c91b7322f6c1ae13b', '391d4f9f7b4a4996b3004616ce29b7c7', '鄱阳湖', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e3a3873babbd433b9ae4cfb53e830e58', '08f8b219924948fc8c4206b9c1ad590f', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e3afa6dd15bc4b5cbac5d53c739b3e7c', '3194ff0c260d4e0290fbe6c04f20636a', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e3e07708fde6420c866429f9f96a1120', '40b4c6f1922c44f8899916b1558ee0ab', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e4248bd07b6b42ab9604dcbbaa92cdc0', '712513221d6549a2b900e1ab9e51ee13', '叶尼塞河', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e467b65d6341493f9e9ca419b60e2fb9', '060910f16c3b4247abd3f9c32bac8f4c', '火药', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e46cb1a7377f44d397a20cc400b4320d', '4661ff6da9cc4d299cb32f054b2273e3', 'near each oher.', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('e4784e16d78a4651a042b610cf1194c6', '5c0cbd150ebb4d45a51142fbdd174d69', '齐齐哈尔', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e48b3548f0ad4d4f921606de8404d8df', '43fab8135e6f42f3b39eb69cda2ced24', '<img src=\"https://files.yfhl.net/2022/4/15/1650003069350-2dec91e0.png\">李白', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('e4ac0d6f4f3d40c392d35b126c1ef300', 'fe52a0bf9c764d458db7f83b6627d1a1', '拉萨', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e4c74de09ae949a9bc3faa9303ebb895', '03d06173efdb49d3a151fb48528e40b8', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e4f769eda3f14e7b8e5929daa4080859', 'bd082aa0a7c04762bb94ae20c06b07f8', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e5361d479e434af28c2b859778231741', 'dddd0101c95b44409907656c2291111b', '靠右侧加速行驶', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e5539b99f51342fa8bf7e882de466c9d', 'dddd0101c95b44409907656c2291111b', '及时减速、观察后靠右行驶让行', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('e560a978171841d8af5f97e7baf2ac09', '5645ec3461994aa5b60c6cc0277ce660', '西亚', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('e573602d3aba4181bd7d27285ccdfbf0', '82af113d1ebb4a849f7d145d670255e2', '昼夜交替', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e5abe0d1201f4242984dde84f84813aa', '4ae568501509423a9406cb5dc38d3e29', '1980.2', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('e5e92830ac14479ebd678cd4a20b3d6a', 'acaa83033e5f4d4a8df87f75b858cda5', '第三产业在国内生产总值中的比重大', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e5ecfb80420449b3b0a982beb32c2882', 'd3ee73dd3d914dbaa94760315d637b3d', '使用所学车型的教练车单独驾驶学习', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e5f4d8e75212450d99d699c69171f658', 'f3c1d614bc3e473c864cb593f718737f', '长江', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e618fde9295b4121bc4398032ba86cfc', '48edfaf725b64aac97ae805b796ee1ab', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e62634e92201400e979249c5fa59b0da', '40e11970f558432692e1512b3560777a', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e66cca10f65d415b9b7f4bfc6539c489', 'fda5df61229f4eb182ee326bf508f6e2', '30公里/小时', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('e69504211c184e6f91a3673eea71b6ab', 'bd325a5aef7048e5871c8a60001394f3', '经济与民', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e69c235428e9497696fc8f56ef7dfb51', 'd75ac866a5d847fa9f39cd18c7af72fa', '鸭嘴兽', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e6a0c64b291e4919b9ac11a5e24e087d', 'e13d501b4c4448d4a668cd4e279addd5', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e78029f94c5b470fa76e2a1e1bed403a', '366473d42dc14d7eb39f4216320795de', '《琵琶行》', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e7b7644186c04735b5155d1ae8469620', '7b0128511a574a709bdfc9f745b1db0b', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e7ef8ca3f68745b5bbe25265e3a30186', '13f63698fa974192bb559a9615f77218', '两侧变窄', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('e7f951592cc54cf79403a457eb393a73', 'b8c8e4a6aa1e49618bfa98c6e9bdc8b4', '国家全面安全观', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e80d451bc64544c99e8fad249ae2ac80', 'c8903fbe6a664c448ed919e4f3ae5781', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e81711cabcbe489a8d8a7efaf897e61b', '7b8db996799c459ca22beded29f050cf', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e82450ec22d64015ab34e120765bbb26', '50c7a43ffb1b4113a7046227f2fc879f', '韩国', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('e8ebbec858104cd180ba37468341210e', '16502738ea7142afa3f5a2b30fd7340a', '工业', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e92a4656d35f450db6d5d25c0780346f', 'e4ef758c45ca4ee3bb14b834ab7563de', '菊花', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('e9462ca500004dfca0e4a9d9544d651e', '3b63d566176c42edafe541f9c056f952', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e97c986b5dd24369be29d5c768bd0abd', 'a59bc2eea3bb4ecfa0fffd7abbd2b017', '6个月', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('e9b875e6867b409499e69aa8ba734e7e', '0a3f8a446fcf4654aa3f351d816029d5', '以平原为主', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('e9c5778d0d594785a8e0b3b21aa68557', '3c741508e1a841298b61b4cbac9462d1', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e9dee89dbe0f4acfbaf66df0e5771628', '66a4c357ac7f4f0f837caf185beae248', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('e9f3e1239bc843b9864535d4c84fbfcc', '71153b61fc98484db5955fba15aabedd', '李贺', 1, NULL, NULL, 'E');
INSERT INTO `qu_answer` VALUES ('eaad4137956c4d5e929bf593610879d8', 'c5c9df4d43d84396acfd2d84f1bc69a8', '5次', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('eab4386244fe48cdb8aea58c976e2eca', '778bb89404ee46699fdf3320d7750507', '不得少于10米', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('eac884bd794d49cbbcd113edbc39ceb2', '0d3e353d2f864b92b992c5e4a69ac16d', '资源争夺型题目', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('eaec450357cb44648dd01680aeb9e772', 'c81bed86ea944ccd853af1f6b4a834d6', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('eb42cb7f19fd4cfe87c3e47b46ca9311', '6932483968f24f50895576a52a7b6c7e', '非奇非偶', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('eb5518e4d0b04a26b36e3d04de13f40f', 'fa223b30c8144440baa50130cbce6629', '2分', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('ebbe3cf709d848d5928ca88aa2210b1f', 'b0ace503d6524c28b1dd607a57c105e1', '以上地方都可', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('ebd97333c41d48d287e7f0aaa0c7ade5', '8ee2ce33144d4d19b625a6bbf4037da6', '新加坡', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ebff16181a0b456c91809ceefbef5170', 'dd38d23c395b446f878d47dacf7d0fff', '正在掉头', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('ec55e1d48fef4b33aef00402da006fa4', '63659d404f694a8fbea7e1ea29126dd4', '恒山', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('ed2b95d57329491ba6145d305611c608', '842cf1df6a71424bac98dd9faebfaf56', '白居易', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('ed5d6cfe23194717a8852261ae796f53', '8bddfb2febcd428594817d0a25df58ad', '年不含税销售额为90万以下，会计核算制度健全的从事货物生产的纳税人', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('ed785804da9f4c46992a120685691a18', '532aeadd18c347cfa432f944490ef06b', '1986.2', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('edda112f5e3f494ab82c8f6001068fbc', '46c48012bd254a4ebaf40dc547d94595', '机动车保险单', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ee1313f0b455457ea116d9af3fc203ff', 'f53c81b561b14148b07cdaf1ff26f99a', '文献收集法', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('ee4f10bf17ba4dcdb9239283f3eef8a3', '6f5edd28675b4f61bb485439774a2cb4', '云南', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('ee5f0fd4338b4b97aced084827565a70', 'b1caceff25914b3daed4ca946ab423f6', '吊销机动车行驶证', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('eecdfe04bf3042e090ba3e50260a6dfd', '24234ed5714e429db9c4b24c897449c1', '规章制度科学明确', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('eeeebb5063a94fdfa5afeb98c071f010', '773afc7db8e64a9887bb8d9f82ccf497', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('eef04077a84b4af19358b1d622fa77f8', '93e59078f5aa4595a202a401d92d1902', '20公里/小时', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('eef0ce4d4d694b7db48d73543e0aeb55', '2847894777fe4ad9afc22334dcc34782', '东南亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ef0e88e8d74b45bfb0c26151ab39b1d3', '699b5e55acd04b57a0584016f6804494', '就地停车排除故障', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('ef115a9a4da3400e8b664fa6159ffc34', '8bc89d7af5924f1d8a833379691868c7', '暂扣驾驶证', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ef2babbcd13b46d28911c4f5e6fe97aa', '3609196dc18d47008bb6fd788dcf89e6', '替换性', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('ef6c90ffa77540bea1b6ca41a42e6934', '533062fda6d44dd5a3f665dce1ab3a1c', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('ef6d3a56b4fc40b295e96ed59cca5979', '963c7e0b8fc54be4b33a72067d872448', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('ef954bf737a54a4cabdf6df28b7b7f42', '391d4f9f7b4a4996b3004616ce29b7c7', '太湖', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('efbceb7b845b49bb9c3c2b9341c49770', 'fe2a73f88fed4ee7bc393fd8ad47867e', '鄱阳湖', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('efbfc276a9bb4c0ab6a19c0f6dafa549', '6478c468a2af48e1aebd963c2a1d55e4', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f0751971ea9142099e39f92c2c95fdf9', 'a8187f2d23dc4015b5aa7920d01e2f1a', '杜甫', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f0a4d0188f9947b6a9da0e2d3700c7af', '14af07de63c0493d8ec7f4554bd86d32', '它在冬眠', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('f0e4e8e2c437438ab0affa78d4b2936e', 'f27db377b6784bafa9eb1bdd93d770e8', '组织战略', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f0e907f351254b3db95ea234d421a379', '7dc44d23727049c3abb5e0b738a79d97', '鸭子', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f189e12b50f64d48abca968255a2d4ed', 'e76c1ff5ef234c7da6463916ae6a0f76', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f1e4bc5198df4d089252dd4da957d876', '6882fa950b3a44e58aad41a91eebbc76', '文化', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f21b2e16a0d8498fb64c52e0e2aee0eb', '532aeadd18c347cfa432f944490ef06b', '1980.2', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f2292130163d40c99962b76a4b2af655', '21a6204fc835484f929ee2db5dca44dd', '工业', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f26db9ac49af4108a22b2df35e229b21', 'e0171593dbe34c03a15f1fcae101c86f', '统一式样的实习标志', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('f2bd6699c6504aa7a94ff589212f181f', '32dd1f691b6a454186e2aad2729187e3', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f2cf3dae60dd48969246baf6f70a9e87', '88f9f8ba351f40c3afdd24f5d764b6e6', '0度经线不到0度纬线的1/2', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f2de4a70b7f0473b89113bc0e82d3c71', '3f51e325a16d46dba9ab791b6f1e1bbb', '备胎', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('f330bab9750141b38cacc87149d57e8e', 'fe2a73f88fed4ee7bc393fd8ad47867e', '洞庭湖', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f370a51e4ebb42f6b84ed0608aa53a9c', '3fce6bf288de44f7bed860444b424a0f', '泰山', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f3c800b011894ca6b685c4bb533d52cc', '3c63ae9e3dae48d886997c320c863de7', '职业资格证', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f3d622658cc541a2b553436d47ce6195', '8630d4c0ec444e138f0285ac1150d59c', '苏轼||辛弃疾||苏牧||陈亮', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f4023aee883b409ab01d945ac924a8b3', 'b9d77f5317b142e1adac070484a4425d', '劳动合同用工', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f410dd0a3bc242f4b486380ec9794cd9', 'cbb1ac87f94a4091a0e2541995562959', '五个力量', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f43abe014e7f49539ce626efb6958c7b', 'fe50de83af2d444c8e6a05769b0d32cd', '造纸术', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f47e8c50f64049ba88467e5907c8e33b', '3fcc901fa2c24167ac1027705299579f', '以平原为主', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('f52856b1789645f9bbfcbd9d33bd6dd5', '0e5354d337a04a798eac226820186f31', '放弃超车', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('f54d6fbc949a4cc6a90accb3f4324466', 'a7ed08dcbe4548d98e5b3978d5471492', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f5a58d278795462d9dbde79e36bab75f', '7764ea88d80c4184ba3ae8181dabf782', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f5b14534448a471daf0b563ddf62a8df', 'b36d73fdf1c4423ab38bb367ab23328f', '加速行驶', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f681ac3a852443e99ef943361ebefcfc', 'b26d01494783429f950ad2c24a541958', '印度尼西亚', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f69323c8b0344fc9ac2200c9ccb7a645', '6a567d1d69a54b24817a63faf6c382cb', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f708ec3e07ef4b348b2ab0d333228e4e', 'fda5df61229f4eb182ee326bf508f6e2', '60公里/小时', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f70c23a224ef4e79be0eb02c7fbfda2f', '8be6003c400540e392257504aa7f4fe9', '10年内', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f7454069407e464c9d450457759064ff', '7c2eba01aaaa43639d9df205cd66ecb7', '四川', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f77ab7f905b242cea2f3176c7a27c8fe', '28a78e2127da41b5937c19b49f0acdb3', '全球治理观', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f7ac8995839d4bbabb22b5dfe37e8063', '2be24ca734cc4ad6b9bd1c59c605f9ee', '新疆', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f7b6212fb5244725be32fa2810b7100f', '5215ebb7d33240a5b006786a0238e906', '司马相如', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f7c8f018d1b24ab09da00e2d2cad18c8', '5bbd523e6e0b4ce78dab024e9ba332f5', '正在停车', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f7e27d32d70143baa5a0c4d9f0d82f64', '14af07de63c0493d8ec7f4554bd86d32', '它在参加派对', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f80a533cf7e34674845e7c51cf28fe2b', '3e76fccc6932497a97f1a8a1b937d9bd', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f8133568e3184dfc9d242434311d5bb8', '0c275cc358cb4ce89f1b3ec29f12e7a3', '1／3', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f831e05cb7aa47bc985db40361667a3c', '7647768497cf4a2cb2d191cdb4a6efa4', '广西', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f861c520c81d4750bcf434c865b9c49e', '865549d007ac4ec4b39ebaa154067f97', '终身', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f8786f55b37e4133945cc56206b7a871', '091de7090a074c84ac13663c6a0a5eb2', '韩国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('f8b193401192479d9bacef95600939d8', 'd5da46857db946ed944d201fa249d6a9', '西安', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f8f3f660966e41b685b08848405b631e', '46c48012bd254a4ebaf40dc547d94595', '机动车行驶证', 1, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('f9107e380dbe41a0a6e5b36c90aa2448', '00739ffce4f34859ab29d10c6b45aa04', '勒拿河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('f938a1f5d2e64947b7ae51df2a2dae19', 'f32288b64ff64ff29cf5ac8890ccd333', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('f9465585257a464f9bc2d6a43935ad3e', 'a26e2923e543499a8ba9b41d4ccad0f0', '西安', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('f95c5b847de64600b2dce403d08d0003', '8c24ebedf58b4e7c83b67bdf95602582', '新加坡', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f9d36f9ee0b94a62ab617ae24cce1190', '185f19ac9bbe48c8aae417ffeb75f3fd', '新加坡', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('f9d433d8ece1438a8f0d1fd9474893bc', 'cea0ede781d748c8bcb300bd71612430', '30公里/小时', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('fa912455175a4cd1aad884fd518db915', '28e1925ff8e743ddb1dff777571bbba3', '沂蒙山', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('fb1f8bc4205d4a14a26b8d23929a67c4', '27fa1550e3314b2a82d2493cbc4b0373', '西藏', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('fb4dbeeaec624b0f84ca5afe5e8cf03e', '4793eebea0544f03951476504134ef3b', '开启近光灯', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('fb5fb92b5e004911b5a067ac256bd9b0', '7ad472d5aa14425fa0557b90996a0586', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('fb723a226e3144b7bd56207358d5528b', '4793eebea0544f03951476504134ef3b', '开启远光灯', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('fbeb977828134d5aa436f49b0cfbfddc', '0e80bcc639aa472aa5e98aecd8c9a58c', '漠河', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('fc29c1487c1f4f73bd59279716c29ae1', 'cd3b504c26a64a289f5c4ba3c9736ec8', '150米以外', 1, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('fcaf468e4a4c4e5ea0eb920d6b55a4ac', '9953ff72acf24de6bd2f1cbcd83823fc', '洞庭湖', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('fcc32aed17e140189328116a0cd5f7b9', 'cb03807f8dbe46dab275beaecf753631', '适当减速通过', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('fd33c5fd36a54304896d6d858c1bac41', 'c8903fbe6a664c448ed919e4f3ae5781', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('fd3d802f00cd42a0aedd8a4ba502cac6', 'a5a15747dac14c2f8996ae62e82aa06a', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('fd808911e85c492aa6fb57f258590cf6', 'f27d7c56ca3d473087164fb47241725b', '地处热带，是干旱地带', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('fd91c8c12a7340afb1533d50dd75792f', '50c7a43ffb1b4113a7046227f2fc879f', '日本', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('fd9fe8d4734e40c9bb5f140fc36b6970', '0b6a5a93d9e8453b80f26c122f20c81f', '斑马', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('fded82f475794079848ff8197ac39b4a', '5256ba7804bc4174a184e09a9999b687', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('fdf204247ba44bf7a4730a2cc49518c7', '7a3245e9a7cd4072af43f082fc9e0851', '勒拿河', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('fe4f31ed1aab4cc4ad8c46abacf15793', 'b9d77f5317b142e1adac070484a4425d', '聘任制用工', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('fe57dcecf6304f8ba61af0c5e40d64b4', '5bbd523e6e0b4ce78dab024e9ba332f5', '正常行驶', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('fe91df9c5690459aaeba8c19ef8248f8', '2ef952053c234876bcfe67dc61b1bf45', '中国', 0, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('fe9649ca9ac9474fbfdbc613585d0d67', 'c04783ce70524bcdb3a3a5cdc4d0cfeb', '正确', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('fec2112ca36d424ba0131bc9d500acf7', '963c7e0b8fc54be4b33a72067d872448', '错误', 0, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('fec26cbf45d44edfac6c976508e63d44', '8a8dedc0561948e891bbd384362fe125', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('fec755c55cbe48998f0a3a65a03af7da', 'cfe7c139d762415da4ca93d6013afb80', '60公里/小时', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('fefe1d6bdd39401fb76fb4aca143e486', '778bb89404ee46699fdf3320d7750507', '不得少于50米', 1, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('ff13821987a3416e861b968c4bf23942', '333985d2d41048449ea405cd1f2c5aa1', '错误', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('ff280fad0d8d4f9ca203e48022dd0b87', '3f51e325a16d46dba9ab791b6f1e1bbb', '被动轮', 0, NULL, NULL, 'B');
INSERT INTO `qu_answer` VALUES ('ff79ef1e08ec4b5490def5bc2e8675c2', '865549d007ac4ec4b39ebaa154067f97', '3年内', 1, NULL, NULL, 'A');
INSERT INTO `qu_answer` VALUES ('ff7e044c3b284b81a87b79ea98034720', '9880957f04e940acbfd21c6ea49e1b74', '正确', 1, NULL, NULL, NULL);
INSERT INTO `qu_answer` VALUES ('ff8108b40a9d4854b914057e1b576267', 'e2ea1f15186f4d38b40952c4bc5b9b70', '60公里/小时', 0, NULL, NULL, 'D');
INSERT INTO `qu_answer` VALUES ('ffa366e4af4c41d18f4ee18d425904ca', '16502738ea7142afa3f5a2b30fd7340a', '建筑业', 0, NULL, NULL, 'C');
INSERT INTO `qu_answer` VALUES ('ffc693b660834990955a84bb476a65a6', 'd3ee73dd3d914dbaa94760315d637b3d', '使用所学车型的教练车由教练员随车指导', 1, NULL, NULL, 'A');

-- ----------------------------
-- Table structure for repo
-- ----------------------------
DROP TABLE IF EXISTS `repo`;
CREATE TABLE `repo`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `dept_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门编码（专业）',
  `dept_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `subject_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学科ID',
  `subject_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学科名称',
  `total_count` int NOT NULL DEFAULT 0 COMMENT '总题数',
  `sub_count` int NOT NULL DEFAULT 0 COMMENT '主观题数',
  `obj_count` int NOT NULL DEFAULT 0 COMMENT '客观题数',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题库标题',
  `is_exam` tinyint NULL DEFAULT NULL COMMENT '是否用于考试',
  `is_train` tinyint NULL DEFAULT NULL COMMENT '是否用于训练',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '题库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repo
-- ----------------------------
INSERT INTO `repo` VALUES ('a38dd22f1c044dc0bee9c8bd725fbecf', 'A01A04A01A03', '20060211班', '260ee46d9ca34589aa6b8bff9d8108d4', '动植物生态学', 0, 0, 0, '测', 1, 1, '额', '2024-05-14 17:41:55', 'ffb36d0a23964b748f91f70443a4fb27', '2024-05-29 15:33:53', 'ffb36d0a23964b748f91f70443a4fb27');
INSERT INTO `repo` VALUES ('a9f81c2841f54bfabaac62f1b13370ac', 'A07A01', '生物技术', '12b22cf42af846969eda2800060d0efe', '分子生物学', 0, 0, 0, '生物技术', 1, 1, '测试', '2023-12-04 16:12:40', 'ffb36d0a23964b748f91f70443a4fb27', '2024-05-29 15:45:01', 'ffb36d0a23964b748f91f70443a4fb27');
INSERT INTO `repo` VALUES ('afff86d60d27c943a0a16e2d7a04b4', 'A01', '计算机科学与工程学院', '620599dad4e14a5f9478623bd1063b84', '合成化学', 0, 0, 0, '计算机题库', 1, 1, '测试', '2023-12-04 16:12:05', 'ffb36d0a23964b748f91f70443a4fb27', '2024-05-19 12:32:10', 'ffb36d0a23964b748f91f70443a4fb27');
INSERT INTO `repo` VALUES ('c85209fca14e4bafaf0f4d32540b1cfa', 'A01A04A01A02', '20060210班', '260ee46d9ca34589aa6b8bff9d8108d4', '动植物生态学', 0, 0, 0, '1', 0, 0, '1', '2024-06-08 11:37:21', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `repo` VALUES ('ff86d60d27c943a0a16e2d7a04b9d2d4', 'A05A01', '汉语言文学', '36ca54d96f434c269afa9814e5759215', '量子力学', 413, 89, 324, '系统题库', 1, 1, NULL, '2024-03-20 18:14:48', 'ffb36d0a23964b748f91f70443a4fb27', '2024-05-29 19:50:10', 'ffb36d0a23964b748f91f70443a4fb27');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `role_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'student', '学生');
INSERT INTO `role` VALUES ('2', 'teacher', '教师');
INSERT INTO `role` VALUES ('3', 'admin', '管理员');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学科名称',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述/备注',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上层学科ID',
  `dept_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属部门（专业）',
  `dept_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学科表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('12b22cf42af846969eda2800060d0efe', '分子生物学', NULL, '0', 'A07A01', '生物技术', '2024-04-25 15:50:21', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('260ee46d9ca34589aa6b8bff9d8108d4', '动植物生态学', NULL, '0', 'A07A02', '生态学', '2024-04-25 15:51:21', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('2c5594e15eee49db8c91175093d1dead', '工业催化', NULL, '0', 'A06A02', '化学工程与工艺', '2024-04-25 15:49:50', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('36ca54d96f434c269afa9814e5759215', '量子力学', NULL, '0', 'A02A02', '物理学', '2024-04-25 15:45:54', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('55608aa5fd2740d2b5dff6e657f0aeaf', '生态系统管理', NULL, '0', 'A07A02', '生态学', '2024-04-25 15:51:26', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('620599dad4e14a5f9478623bd1063b84', '合成化学', NULL, '0', 'A06A01', '有机化学', '2024-04-25 15:49:06', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('7d79356901514ebe95b5644dc220cf3e', '药物化学', NULL, '0', 'A06A01', '有机化学', '2024-04-25 15:49:15', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('842d3f0cd93a42e593d0ccd45ba248e7', '热力学', NULL, '0', 'A02A02', '物理学', '2024-04-25 15:47:30', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('8604a604915143e4a4b48de14e0a6078', '遗传学', NULL, '0', 'A07A01', '生物技术', '2024-04-25 15:50:38', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('864887d21707462ab20ef919b0b64198', '天然产物化学', NULL, '0', 'A06A01', '有机化学', '2024-04-25 15:49:11', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('c56f63fbe9ca4984a476bdcdd43e69de', '统计物理', NULL, '0', 'A02A02', '物理学', '2024-04-25 15:47:37', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('c6dbd0ec5bda48fc9fc1d5574ab94251', '化工原理', NULL, '0', 'A06A02', '化学工程与工艺', '2024-04-25 15:49:30', 'ffb36d0a23964b748f91f70443a4fb27', '2024-04-25 15:50:02', 'ffb36d0a23964b748f91f70443a4fb27');
INSERT INTO `subject` VALUES ('c6f7175297a340be94da4ef74d3c16cf', '化工制程', NULL, '0', 'A06A02', '化学工程与工艺', '2024-04-25 15:49:45', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('d92360a2a92b47f7bdb5b4a6d5457f9d', '微生物学', NULL, '0', 'A07A01', '生物技术', '2024-04-25 15:50:42', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('d952b6f071a7401faed197daa436a01b', '电磁学', NULL, '0', 'A02A02', '物理学', '2024-04-25 15:47:23', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('e843d00aa6464ba48bfb4551b809583b', '固体物理', NULL, '0', 'A02A02', '物理学', '2024-04-25 15:47:42', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('e9165e4ee63940908af91e7dda574616', '环境生态学', NULL, '0', 'A07A02', '生态学', '2024-04-25 15:51:13', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);
INSERT INTO `subject` VALUES ('ece84551b51a486899b34f27f17df103', '生物化学', NULL, '0', 'A07A01', '生物技术', '2024-04-25 15:50:30', 'ffb36d0a23964b748f91f70443a4fb27', NULL, NULL);

-- ----------------------------
-- Table structure for tmpl
-- ----------------------------
DROP TABLE IF EXISTS `tmpl`;
CREATE TABLE `tmpl`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '模板标题',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模板内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tmpl
-- ----------------------------
INSERT INTO `tmpl` VALUES ('0', '验证码', '你好，验证码是：%s，%s分钟有效');
INSERT INTO `tmpl` VALUES ('1', '考试通知', '您有一场考试：考试名称：%s，考试时间：%s~%s');

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `repo_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '题库ID（智能训练模式下非必须）',
  `answer_count` int NULL DEFAULT 0 COMMENT '回答数量',
  `right_count` int NULL DEFAULT 0 COMMENT '正确数量',
  `total_count` int NOT NULL COMMENT '总题目数量',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '训练者',
  `mode` int NOT NULL COMMENT '训练模式',
  `percent` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '训练进度',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '状态 0:未完成1:完成',
  `train_time` datetime NULL DEFAULT NULL COMMENT '最近训练时间',
  `quType` int NULL DEFAULT NULL COMMENT '题型（mode为3的时候需要）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '训练表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('0f7d4b75b5eb4ce98e706d74b89a726a', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 0, 313, '8d322e7394904df2bed4723f2c58ec92', 1, '0', 1, '2024-05-29 17:00:43', NULL);
INSERT INTO `train` VALUES ('155ef00b3a09456b949775c5e242cc9e', NULL, 12, 4, 15, '8d322e7394904df2bed4723f2c58ec92', 0, '0.8', 1, '2024-06-07 14:47:12', NULL);
INSERT INTO `train` VALUES ('16097b974c114a19be5d1ec5423d597f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 1, 211, '8d322e7394904df2bed4723f2c58ec92', 3, '0', 1, '2024-05-29 16:52:23', 1);
INSERT INTO `train` VALUES ('177191ae5cbc470c84c6281e8bc021b3', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 0, 313, '8d322e7394904df2bed4723f2c58ec92', 1, '0', 1, '2024-05-29 17:01:03', NULL);
INSERT INTO `train` VALUES ('1e5b70c857fc4e4ba607f74526483bde', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 0, 211, '8d322e7394904df2bed4723f2c58ec92', 3, '0', 1, '2024-05-29 19:37:10', 1);
INSERT INTO `train` VALUES ('384b51c9473c4e349baad6315aca8be5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 1, 211, '8d322e7394904df2bed4723f2c58ec92', 3, '0', 1, '2024-05-29 19:36:48', 1);
INSERT INTO `train` VALUES ('512494bd93a44c7e9d8a9eb696f33990', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 1, 313, '8d322e7394904df2bed4723f2c58ec92', 1, '0', 1, '2024-05-29 17:00:12', NULL);
INSERT INTO `train` VALUES ('67a5fbf77e1c426495ae213765b1763a', NULL, 0, 0, 15, '8d322e7394904df2bed4723f2c58ec92', 0, '0', 0, '2024-06-07 14:47:21', NULL);
INSERT INTO `train` VALUES ('8649044664f343a9bf7e442d111d6e80', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 1, 211, '8d322e7394904df2bed4723f2c58ec92', 3, '0', 1, '2024-05-29 19:37:27', 1);
INSERT INTO `train` VALUES ('a08d8c1dc0c842f287add25d4631026d', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 0, 10, '8d322e7394904df2bed4723f2c58ec92', 3, '0.1', 1, '2024-06-14 18:19:05', 2);
INSERT INTO `train` VALUES ('ae05c47772004e429effd69f5392faf7', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 11, 0, 10, '8d322e7394904df2bed4723f2c58ec92', 3, '1.1', 1, '2024-05-29 16:59:34', 2);
INSERT INTO `train` VALUES ('b8dca6e5612f49c7a6afe8ca5053e540', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 3, 1, 92, '8d322e7394904df2bed4723f2c58ec92', 3, '0.03', 1, '2024-05-30 12:25:48', 3);
INSERT INTO `train` VALUES ('b9174229b2f94f579861f56e963b0ac2', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 3, 0, 10, '8d322e7394904df2bed4723f2c58ec92', 3, '0.3', 1, '2024-05-29 18:31:58', 2);
INSERT INTO `train` VALUES ('c512d82f82eb42e994851f2ae017973f', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 0, 0, 313, '8d322e7394904df2bed4723f2c58ec92', 1, '0', 0, '2024-06-04 17:53:21', NULL);
INSERT INTO `train` VALUES ('d0c70f13c0244fb6a73245d635722372', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 10, 0, 10, '8d322e7394904df2bed4723f2c58ec92', 3, '1', 1, '2024-05-30 12:22:44', 2);
INSERT INTO `train` VALUES ('d65ff74bc88141c3bea27051472851a2', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 0, 313, '8d322e7394904df2bed4723f2c58ec92', 1, '0', 1, '2024-05-29 16:55:07', NULL);
INSERT INTO `train` VALUES ('d98cb15dd69943b0a35ff16752497ec5', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 1, 0, 10, '8d322e7394904df2bed4723f2c58ec92', 3, '0.1', 1, '2024-05-29 18:31:07', 2);
INSERT INTO `train` VALUES ('f0d8dd8e752841139a2b985dca4f5a08', 'ff86d60d27c943a0a16e2d7a04b9d2d4', 10, 0, 10, '8d322e7394904df2bed4723f2c58ec92', 3, '1', 1, '2024-05-29 16:30:19', 2);

-- ----------------------------
-- Table structure for train_record
-- ----------------------------
DROP TABLE IF EXISTS `train_record`;
CREATE TABLE `train_record`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `qu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目ID',
  `train_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '训练ID',
  `is_right` tinyint NULL DEFAULT NULL COMMENT '回答是否正确',
  `answer_id` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '答案ID',
  `answered` tinyint NOT NULL DEFAULT 0 COMMENT '是否回答0:未答1:已答',
  `answer` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '主观题的答案（预留）',
  `sort` int NOT NULL COMMENT '题目的排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户作答训练详情记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of train_record
-- ----------------------------
INSERT INTO `train_record` VALUES ('0619e5d77aad4727b42978c5531862aa', '62815d180ad5487a80689235718c74ec', 'd98cb15dd69943b0a35ff16752497ec5', 0, '[\"b7327b5ea9d14aa7bcfcb05efd2c9483\",\"a7b159bf986845eb9ea4769a9d619de9\"]', 1, NULL, 3);
INSERT INTO `train_record` VALUES ('0c149da2543c4d77b61c42cca01319e6', 'f53c81b561b14148b07cdaf1ff26f99a', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"9f1ab3f63d934026bad23eb3b93184aa\"]', 1, NULL, 9);
INSERT INTO `train_record` VALUES ('0d868410fe9a4ff0903f03d70a9c8556', '00144a9784b4486ea59f4c44ac888769', '16097b974c114a19be5d1ec5423d597f', 1, '[\"3dd432b908f741c98829a297cfd32467\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('11ab8054f78a40b1a5e6d9a3b077a380', '00739ffce4f34859ab29d10c6b45aa04', '155ef00b3a09456b949775c5e242cc9e', 0, '[\"13a1303ff75140d18218c83e48f4ebf2\"]', 1, NULL, 2);
INSERT INTO `train_record` VALUES ('1a7ca1c307d44a8d9c88afa2caeb8801', '19646da51e454d3d910f07696cc1f1e5', 'ae05c47772004e429effd69f5392faf7', 0, '[\"aa3b18cf2b5b46ecbbf6e616ce1706dc\",\"c92d118748c44063b3ffaa20640b9178\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('1cdcaedc9cf940d0aca03df9d92ec49b', '04d3cc8511054f91b1d7d90b3a781a7e', '155ef00b3a09456b949775c5e242cc9e', 1, '[\"4851206947d74f6a86a2fb264af1e27f\"]', 1, NULL, 6);
INSERT INTO `train_record` VALUES ('25947a74c1b347ecb9af623f03f7e6f0', '07ea3d4ab4004523be6636a3d0b82dd6', '155ef00b3a09456b949775c5e242cc9e', 1, '[\"5370b2dcbe794616b2f6f6f7a994c763\"]', 1, NULL, 9);
INSERT INTO `train_record` VALUES ('28003b827d8d4ca4a278f442620603ab', '66e92fe6520d45c4a1bf8f88044fcbbf', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"ce35b5ee7e604156a30f842651418d98\",\"610906f2b65e42ac8c84ac4e3d45ab0a\"]', 1, NULL, 4);
INSERT INTO `train_record` VALUES ('2ab2e7e096294e429f8ed26089ae26ee', '08f8b219924948fc8c4206b9c1ad590f', '155ef00b3a09456b949775c5e242cc9e', 0, '[\"e3a3873babbd433b9ae4cfb53e830e58\"]', 1, NULL, 11);
INSERT INTO `train_record` VALUES ('2cc208171efc42c5bb500b40041f29ac', 'e4ef758c45ca4ee3bb14b834ab7563de', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"e92a4656d35f450db6d5d25c0780346f\",\"a2f6eb0d3d1e449d99f5bbb93bab31af\"]', 1, NULL, 7);
INSERT INTO `train_record` VALUES ('2da859452b5249a3aa097f1efabe0ffb', '19646da51e454d3d910f07696cc1f1e5', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"390e6e98a4574524ab06addbe2f13f57\",\"9760fde8c9ff49b0bf1c115a9b9da233\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('3145d9046e31425791907f8c83a04942', 'f27db377b6784bafa9eb1bdd93d770e8', 'ae05c47772004e429effd69f5392faf7', 0, '[\"f0e4e8e2c437438ab0affa78d4b2936e\"]', 1, NULL, 8);
INSERT INTO `train_record` VALUES ('3495189045874f5296d16c8908cd0067', '00144a9784b4486ea59f4c44ac888769', '155ef00b3a09456b949775c5e242cc9e', 1, '[\"3dd432b908f741c98829a297cfd32467\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('34b48b72772945cc9331ee356416b2a6', '75c0ec5e6f044d5781a6e3f97a80c70d', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"ba6dff52d39c4bb0a94171e17a566f1f\",\"5f8c02bf847c496694e783b1cc1a9e40\"]', 1, NULL, 6);
INSERT INTO `train_record` VALUES ('3ba0fa6ff85f4f2db917c403e31870d5', '62815d180ad5487a80689235718c74ec', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"0cf20be8bb0045b2b4a6135e43c3ecae\",\"cecd035412cf44518dee88f198df2215\"]', 1, NULL, 3);
INSERT INTO `train_record` VALUES ('3d4fd7d71957451498ca0ed3cf8ddd8f', 'f53c81b561b14148b07cdaf1ff26f99a', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"ee1313f0b455457ea116d9af3fc203ff\",\"9f1ab3f63d934026bad23eb3b93184aa\"]', 1, NULL, 9);
INSERT INTO `train_record` VALUES ('4f3270e2c7914155b25b4870b35793a4', 'f27db377b6784bafa9eb1bdd93d770e8', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"87bbee283d454cf8a94c1ad02efe5b73\"]', 1, NULL, 8);
INSERT INTO `train_record` VALUES ('5587c15e5ab949769d043f4322186356', '03d06173efdb49d3a151fb48528e40b8', '155ef00b3a09456b949775c5e242cc9e', 0, '[\"a53cfe049fc1485c9dee31f6d0a45f2a\"]', 1, NULL, 5);
INSERT INTO `train_record` VALUES ('571089747fe7450282fe04bfcbc31b28', '66e92fe6520d45c4a1bf8f88044fcbbf', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"713c955839564d64a750f5f78217eac4\"]', 1, NULL, 4);
INSERT INTO `train_record` VALUES ('5eede648c245485c928e339faf6d17f0', 'f80aa11cbbb54294ba1646c732607126', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"9ebd2fdf4c2847d1af93ceffde82c019\"]', 1, NULL, 10);
INSERT INTO `train_record` VALUES ('5f52792fd4914df78adbb7d00a8cedb1', '71153b61fc98484db5955fba15aabedd', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"623b6519a2df4020a173958c6bea04c6\"]', 1, NULL, 5);
INSERT INTO `train_record` VALUES ('6195c603e7dc4a67944fd60753bff46d', '00144a9784b4486ea59f4c44ac888769', '384b51c9473c4e349baad6315aca8be5', 1, '[\"3dd432b908f741c98829a297cfd32467\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('6566e4a47acb4536a2b97d4410354b6e', '75c0ec5e6f044d5781a6e3f97a80c70d', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"5f8c02bf847c496694e783b1cc1a9e40\"]', 1, NULL, 6);
INSERT INTO `train_record` VALUES ('6b741ea4141c4f4e995b20408a005c97', '00144a9784b4486ea59f4c44ac888769', '0f7d4b75b5eb4ce98e706d74b89a726a', 0, '[\"d5acbe4df0de4ef787304ffb867572c9\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('6fbd83ca4c3a4789b3072d1e4f6d8aa0', '03d06173efdb49d3a151fb48528e40b8', 'b8dca6e5612f49c7a6afe8ca5053e540', 0, '[\"a53cfe049fc1485c9dee31f6d0a45f2a\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('748805f94b5d4742a867e5027eb4c038', '029f7977ee744d9487ee5b1ed596a64f', '155ef00b3a09456b949775c5e242cc9e', 1, '[\"21244598c9e34b7e9cbb365c4d79befa\"]', 1, NULL, 4);
INSERT INTO `train_record` VALUES ('76156e17e29644ea83a71f452a831486', 'f53c81b561b14148b07cdaf1ff26f99a', 'ae05c47772004e429effd69f5392faf7', 0, '[\"ee1313f0b455457ea116d9af3fc203ff\"]', 1, NULL, 9);
INSERT INTO `train_record` VALUES ('7c842433cb9743baa154e652d7dafbf6', 'e4ef758c45ca4ee3bb14b834ab7563de', 'ae05c47772004e429effd69f5392faf7', 0, '[\"e92a4656d35f450db6d5d25c0780346f\"]', 1, NULL, 7);
INSERT INTO `train_record` VALUES ('87ff1b95ffa44fb1af409bb173193671', '4e04138e31ad4946b83110d91be99cdf', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"c1988c086675439fb733276d638542fd\",\"4b0d73f1ad8740ef9f0fcd69c803d016\"]', 1, NULL, 2);
INSERT INTO `train_record` VALUES ('8a2d3905fcf243fd92c33e5da55dc8a9', '4e04138e31ad4946b83110d91be99cdf', 'ae05c47772004e429effd69f5392faf7', 0, '[\"c1988c086675439fb733276d638542fd\",\"4b0d73f1ad8740ef9f0fcd69c803d016\"]', 1, NULL, 2);
INSERT INTO `train_record` VALUES ('8a2dafbb76d449378566401d0db7d638', 'f80aa11cbbb54294ba1646c732607126', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"c512e6b31cac4c02975327277d442d7e\",\"bb96356f207f47cf994d89ed3811710d\"]', 1, NULL, 10);
INSERT INTO `train_record` VALUES ('8aeb3d43dbf64c729c5fb6ec639cb160', '4e04138e31ad4946b83110d91be99cdf', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"c1988c086675439fb733276d638542fd\",\"4b0d73f1ad8740ef9f0fcd69c803d016\"]', 1, NULL, 2);
INSERT INTO `train_record` VALUES ('8b8700a475a64937bfa178e009c45057', '060910f16c3b4247abd3f9c32bac8f4c', '155ef00b3a09456b949775c5e242cc9e', 0, '[\"09564dc039a847119c6dbab6c7d762f6\"]', 1, NULL, 8);
INSERT INTO `train_record` VALUES ('8cac34b71c824053b4b9d081c3be4f5e', 'f80aa11cbbb54294ba1646c732607126', 'ae05c47772004e429effd69f5392faf7', 0, '[\"c512e6b31cac4c02975327277d442d7e\"]', 1, NULL, 10);
INSERT INTO `train_record` VALUES ('8eced54ddcc843be8b333800b1749222', '00144a9784b4486ea59f4c44ac888769', '512494bd93a44c7e9d8a9eb696f33990', 1, '[\"3dd432b908f741c98829a297cfd32467\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('928aa744f84e4bd8883ac2e790135a20', '091de7090a074c84ac13663c6a0a5eb2', '155ef00b3a09456b949775c5e242cc9e', 0, '[\"f8786f55b37e4133945cc56206b7a871\"]', 1, NULL, 13);
INSERT INTO `train_record` VALUES ('96cc527ed268496fa463ab5e185742dd', '71153b61fc98484db5955fba15aabedd', 'ae05c47772004e429effd69f5392faf7', 0, '[\"623b6519a2df4020a173958c6bea04c6\"]', 1, NULL, 5);
INSERT INTO `train_record` VALUES ('a53e6fa22bb84a24a7504353c73606db', '71153b61fc98484db5955fba15aabedd', 'b9174229b2f94f579861f56e963b0ac2', 0, '[\"bec64454109a4fcfb83f9e476046bb72\",\"623b6519a2df4020a173958c6bea04c6\",\"be72ea9ba2ff4b8eaccd41b5b1363ad5\",\"c6b3651dfbda4a978aa292748dbc3da4\",\"e9f3e1239bc843b9864535d4c84fbfcc\"]', 1, NULL, 5);
INSERT INTO `train_record` VALUES ('ab76765c7fbe4812991405a0ab77786a', '0bc3d45b603e43f0834bf670d32760cc', 'b8dca6e5612f49c7a6afe8ca5053e540', 1, '[\"22a193e4e00846da908626e4e6be3b13\"]', 1, NULL, 3);
INSERT INTO `train_record` VALUES ('ade1bfea22404a308f5e17e8d7a7a0f6', '66e92fe6520d45c4a1bf8f88044fcbbf', 'ae05c47772004e429effd69f5392faf7', 0, '[\"713c955839564d64a750f5f78217eac4\",\"ce35b5ee7e604156a30f842651418d98\"]', 1, NULL, 4);
INSERT INTO `train_record` VALUES ('b9562bf98f76445ebf0aea5d4b0cb5cd', '00144a9784b4486ea59f4c44ac888769', 'd65ff74bc88141c3bea27051472851a2', 0, '[\"d5acbe4df0de4ef787304ffb867572c9\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('bd493e448041400a99feeea69f3eb7c8', '00144a9784b4486ea59f4c44ac888769', '8649044664f343a9bf7e442d111d6e80', 1, '[\"3dd432b908f741c98829a297cfd32467\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('bf0ff23b530a418aa75916f7c9cba04d', 'f27db377b6784bafa9eb1bdd93d770e8', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"b13d65d13a444d64a45232765d5eba6c\",\"6e11b144d9064ed495c580f209a9250e\"]', 1, NULL, 8);
INSERT INTO `train_record` VALUES ('c27cc96e75c34529b8eab5ba40fc43f1', '62815d180ad5487a80689235718c74ec', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"0cf20be8bb0045b2b4a6135e43c3ecae\",\"cecd035412cf44518dee88f198df2215\"]', 1, NULL, 3);
INSERT INTO `train_record` VALUES ('cab758a90b5c47608970e7de88482102', '00144a9784b4486ea59f4c44ac888769', '1e5b70c857fc4e4ba607f74526483bde', 0, '[\"5dde86da074c485fa5ec05de7b900539\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('cd971eca3c2b414795851b6b9802be16', '19646da51e454d3d910f07696cc1f1e5', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"390e6e98a4574524ab06addbe2f13f57\",\"9760fde8c9ff49b0bf1c115a9b9da233\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('d49a93fbe5fb49ed8d38d089246fea68', '19646da51e454d3d910f07696cc1f1e5', 'a08d8c1dc0c842f287add25d4631026d', 0, '[\"390e6e98a4574524ab06addbe2f13f57\",\"9760fde8c9ff49b0bf1c115a9b9da233\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('d74afb3592544407a2473b199662d2e1', 'e4ef758c45ca4ee3bb14b834ab7563de', 'd0c70f13c0244fb6a73245d635722372', 0, '[\"e92a4656d35f450db6d5d25c0780346f\"]', 1, NULL, 7);
INSERT INTO `train_record` VALUES ('da13f91c81e64224bf356bbfe5f0762a', '0a3f8a446fcf4654aa3f351d816029d5', '155ef00b3a09456b949775c5e242cc9e', 0, '[\"d1b91e808f824725aa02a2a3a733f5cd\"]', 1, NULL, 14);
INSERT INTO `train_record` VALUES ('dba8aaa19ebf4e719826a1867aaefc3a', '71153b61fc98484db5955fba15aabedd', 'f0d8dd8e752841139a2b985dca4f5a08', 0, '[\"623b6519a2df4020a173958c6bea04c6\",\"bec64454109a4fcfb83f9e476046bb72\"]', 1, NULL, 5);
INSERT INTO `train_record` VALUES ('dc46418642ab4841abd11e70c34cb9cd', '00144a9784b4486ea59f4c44ac888769', '177191ae5cbc470c84c6281e8bc021b3', 0, '[\"812858d2247f43f096cd4eb9822b5840\"]', 1, NULL, 1);
INSERT INTO `train_record` VALUES ('ddc61609e3ec4c948d6df19f132df1fb', '0b6a5a93d9e8453b80f26c122f20c81f', '155ef00b3a09456b949775c5e242cc9e', 0, '[\"660bde34886c48738e053fa140f1ee30\"]', 1, NULL, 15);
INSERT INTO `train_record` VALUES ('e25579c839a4429db3f42b04a2e076a2', '75c0ec5e6f044d5781a6e3f97a80c70d', 'ae05c47772004e429effd69f5392faf7', 0, '[\"ba6dff52d39c4bb0a94171e17a566f1f\"]', 1, NULL, 6);
INSERT INTO `train_record` VALUES ('e62959eb56e74c86bf43d7da7122df6f', '62815d180ad5487a80689235718c74ec', 'b9174229b2f94f579861f56e963b0ac2', 0, '[\"0cf20be8bb0045b2b4a6135e43c3ecae\",\"cecd035412cf44518dee88f198df2215\",\"9c8735bae9d746beb9a0bd4731a8b5ac\",\"a7b159bf986845eb9ea4769a9d619de9\",\"b7327b5ea9d14aa7bcfcb05efd2c9483\"]', 1, NULL, 3);
INSERT INTO `train_record` VALUES ('e843aa835e564164a18f5a2b39a41ed8', '05ee4104eb77411fb38753b28bb96a61', '155ef00b3a09456b949775c5e242cc9e', 0, '[\"86304bf53ba041459e5eb950307f5817\"]', 1, NULL, 7);
INSERT INTO `train_record` VALUES ('f5e4866252f94189b60bf5bed112167e', '66e92fe6520d45c4a1bf8f88044fcbbf', 'b9174229b2f94f579861f56e963b0ac2', 0, '[\"713c955839564d64a750f5f78217eac4\",\"ce35b5ee7e604156a30f842651418d98\",\"610906f2b65e42ac8c84ac4e3d45ab0a\",\"8c2cfee60b87411dba8e894108799a30\",\"46b27083fba7497596579e38bd1349d3\"]', 1, NULL, 4);
INSERT INTO `train_record` VALUES ('f613b3d2215a4ae6a50fdffa5e283a07', '08f8b219924948fc8c4206b9c1ad590f', 'b8dca6e5612f49c7a6afe8ca5053e540', 0, '[\"e3a3873babbd433b9ae4cfb53e830e58\"]', 1, NULL, 2);
INSERT INTO `train_record` VALUES ('f76c67a6c93d4f57ad61b4b8d9c33e3b', '62815d180ad5487a80689235718c74ec', 'ae05c47772004e429effd69f5392faf7', 0, '[\"0cf20be8bb0045b2b4a6135e43c3ecae\",\"cecd035412cf44518dee88f198df2215\"]', 1, NULL, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ID',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `dept_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门编号',
  `dept_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  `state` tinyint NULL DEFAULT 0 COMMENT '状态0:正常1:禁用',
  `sex` tinyint NULL DEFAULT NULL COMMENT '性别0:女1:男',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '盐值',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8d322e7394904df2bed4723f2c58ec92', '李四', '', 'xxxx', 'A01A04A01A02', '20060210班', 0, 1, NULL, '97d6433fa64acf2267ccfcd5fb0bce76', '111a31', '李四', 'student', '2023-11-26 16:38:29', NULL, '2024-06-21 15:21:21', '8d322e7394904df2bed4723f2c58ec92');
INSERT INTO `user` VALUES ('90f8d5ed367a43468fbc0aa620f75830', '王五', '', '', 'A03A01', '经济学', 0, 1, NULL, '97d6433fa64acf2267ccfcd5fb0bce76', '111a31', '王五', 'student', '2024-04-25 13:56:46', 'ffb36d0a23964b748f91f70443a4fb27', '2024-06-04 17:55:57', 'ffb36d0a23964b748f91f70443a4fb27');
INSERT INTO `user` VALUES ('9c88f734627243eca15c23464fef047f', '王麻子', '', NULL, 'A07A01', '生物技术', 0, 1, NULL, '97d6433fa64acf2267ccfcd5fb0bce76', '111a31', '王麻子', 'teacher', '2024-05-04 19:49:41', 'ffb36d0a23964b748f91f70443a4fb27', '2024-06-20 21:26:36', 'ffb36d0a23964b748f91f70443a4fb27');
INSERT INTO `user` VALUES ('ffb36d0a23964b748f91f70443a4fb27', '张三', '', '', 'A01A04A01A02', '生物技术', 0, 1, '666', '97d6433fa64acf2267ccfcd5fb0bce76', '111a31', '张三', 'admin', '2023-11-22 15:10:01', '', '2024-06-19 23:18:05', 'ffb36d0a23964b748f91f70443a4fb27');
INSERT INTO `user` VALUES ('ffb36d0a23964b748f91f70443a4fbx2', 'qwe', '', '', 'A01A04A01A02', '20060210班', 0, NULL, '', '97d6433fa64acf2267ccfcd5fb0bce76', '111a31', 'qwe', 'student', '2023-11-22 15:10:01', '', '2024-05-20 13:28:46', 'ffb36d0a23964b748f91f70443a4fb27');

-- ----------------------------
-- Table structure for user_answer
-- ----------------------------
DROP TABLE IF EXISTS `user_answer`;
CREATE TABLE `user_answer`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `answered` tinyint NOT NULL DEFAULT 0 COMMENT '是否已答0:未答1:已答',
  `qu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联的题目Id',
  `answer_id` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '答案Id',
  `examRecord_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属记录Id',
  `is_right` tinyint NULL DEFAULT NULL COMMENT '是否答对0:错1:对',
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `sort` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '题目排序（只在乱序的时候生效）',
  `score` int NOT NULL DEFAULT 0 COMMENT '得分',
  `answer` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '填空，主观题答案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户答案表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_answer
-- ----------------------------
INSERT INTO `user_answer` VALUES ('002ec320422b45f181d63acacd4e3019', 0, '3e07606eca9c4043a91f01182e0f3560', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('00a50030e8e947f3bb782dcbba25322a', 0, '4837110c21df4c4aac1950993777bbb0', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('029c6376198d437a9a115280961b88df', 0, '6818caf6587c4cf6ba2468f91fc355b2', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('029caa8bc41c469e9942de0d48735f4a', 0, '7c2eba01aaaa43639d9df205cd66ecb7', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('03366e92485144319bd2fe71fd997efd', 0, '778bb89404ee46699fdf3320d7750507', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('03fc2a2f96424db68d9934b63020bdbc', 0, 'c24f9337e21d4bf18f1fbadc71351dd5', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('05a4d00026f444fda1d76e0b08e57d06', 0, 'b36d73fdf1c4423ab38bb367ab23328f', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('05b69f69ff3a4c2d8439a03e452b7243', 0, '778bb89404ee46699fdf3320d7750507', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('06337368bbb3471cae2ce9e305f9e43b', 0, 'de86776fbcaf424791bee2445443a129', NULL, '04d9dc750eac454fb5c2c1104157f617', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('07693b879a004b619be08880723b3042', 0, 'fbb82d91eb094350aa41ddbf6458e419', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('07cdd910d1394488b7529d3c785b7d32', 0, 'a2457c9c44694a859223908831941002', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('0853567bc54a4df686eae9b9e199e754', 1, '27fa1550e3314b2a82d2493cbc4b0373', '[\"26fd3780ec5e469da3747bce9d4c79db\"]', 'ee42721a05524a0aa98de180b7ca17ec', 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('08c35275ce3b492d9f968cb2714dbfdf', 0, 'be7eb38737a84544901f1f3b0d6413be', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('0a6f89b10d76476c83afe846b545cfee', 1, '84dff59a482c44f592997829a0adf885', NULL, '280a3d47e4e246e4b71a99dcdf63dd3a', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, '<p>111</p>');
INSERT INTO `user_answer` VALUES ('0b977fe483194c2ab2d88aa6875c1d9f', 0, '4ae568501509423a9406cb5dc38d3e29', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('0d7c6060e22c488f89fcbf38f4c17ce3', 0, '865549d007ac4ec4b39ebaa154067f97', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('0e17411421a34ee79da7b1c3d08f2c70', 1, '0e80bcc639aa472aa5e98aecd8c9a58c', '[\"4006c1fbb4994043bcc38a98200fd9f1\"]', '7659707144714036b6330ac87b550e24', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('0e9d521798894e9bb50ff91d8ad6efe4', 0, '20ec59fa41274d28af5cb4c1f8660d33', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('0eb8dac2fe05456ba8596e19c8c2923e', 0, '27fa1550e3314b2a82d2493cbc4b0373', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('0ed584bda3b44aabad2fba95ed7a71bd', 0, '2be24ca734cc4ad6b9bd1c59c605f9ee', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('106d0bfe06734a34b2289511ccadfd36', 1, '0e80bcc639aa472aa5e98aecd8c9a58c', '[\"4006c1fbb4994043bcc38a98200fd9f1\"]', 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('10e58d2fac94491aae94a46a6b3e5b79', 0, 'f9e0726e82cb40289f96a929987296e9', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('110b4a84a26842169602a99a3e2aa7cb', 0, '7ab30154c23243a7837c91760778bddc', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('1193a61da4ea46e3b8aa34c00c78dccb', 0, 'b071cb6cc49d4899ad3177bd69426952', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('11c87d8160244e8fa206f790a83cc666', 0, '2315aae4c4394970b9d66b2f83497250', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('12892f9ba86444969ab9a79eea9a335b', 0, '20ec59fa41274d28af5cb4c1f8660d33', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('139068b09935497781e76cff569390cb', 0, '2ef952053c234876bcfe67dc61b1bf45', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('13b624bc34b14ba1ba748e99e0d0d242', 0, '3f74f08940214b829bc9636f644b7d61', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('1425eaf04251456bbaa3f6b2685cf0be', 1, 'be7eb38737a84544901f1f3b0d6413be', '[\"986b6ed0852f432d93244f89c1aae91d\"]', '7659707144714036b6330ac87b550e24', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('144488cdd4d3448abeb13d0254b2fd10', 0, 'a1922aafdafa41979769bfd61da548a8', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('16a859ace23b4fc2ab9c88a719c16ba9', 1, '2ef952053c234876bcfe67dc61b1bf45', '[\"4e43fa265d2c41b08bce4be09e83b3b2\"]', 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('17885bbdf6f74a7d8b82b2136f3cacbf', 0, '4f37cacdd8bf4a09b4be561c84eafdfd', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('1828a70a69aa4397a6b088f35ce9abf1', 0, '029f7977ee744d9487ee5b1ed596a64f', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('18f0903fa8b24ea5b95e55f56decd297', 0, '2ef952053c234876bcfe67dc61b1bf45', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('18fa89580b9d452e9fce79124659ff45', 1, '27fa1550e3314b2a82d2493cbc4b0373', '[\"c80ba3b51dc24cae9b371ded05917c78\"]', '388f02820790404fba352601e38612c4', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('19c81bceae1741bcb6ab2c3d83bf7929', 0, 'bd325a5aef7048e5871c8a60001394f3', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('19e79f555436435d9ddaf158530e40ed', 0, '4ae568501509423a9406cb5dc38d3e29', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('1a9c9b29f77a43f5ae1b1e3e3790ea9a', 0, 'bd325a5aef7048e5871c8a60001394f3', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('1b70fd7a686b44649311ef0ad7103d5e', 0, 'dddd0101c95b44409907656c2291111b', NULL, '84e78ba7d5e04a4e8eb9c5e1cb7795c6', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('1dcf71e20c35473e9b05e2239fb72bee', 0, 'b0ace503d6524c28b1dd607a57c105e1', NULL, '84e78ba7d5e04a4e8eb9c5e1cb7795c6', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('1e8c6c2429f344ffa3a10409155eb11a', 0, '3f51e325a16d46dba9ab791b6f1e1bbb', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('1ff9fdda46c8429bae938ee5f0233635', 0, '28a78e2127da41b5937c19b49f0acdb3', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('2126d187c5634c118edf32d82715d1ab', 1, 'd481d614f7a74465829cf380f297ee0c', '[\"16f8a73b73c742b8808723a39c655b85\"]', 'cb7b78cbd77944c0a15ab6074b5b0f1d', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('21b7c7ccd8744bc5959a1fbd312b0917', 0, '7c2eba01aaaa43639d9df205cd66ecb7', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('2226a11be6ac4a698eb83ea27ccabb72', 0, '111dd1c11bc349dcb3798cc0af0ba830', NULL, '531da5f99ae24ed2a09237b91ccce115', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('225cd4882c454857ac7b089290f790ca', 0, '3f74f08940214b829bc9636f644b7d61', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('226962370b774dadafff9e20729be87e', 0, '699b5e55acd04b57a0584016f6804494', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('22cc0b0c48c54a51bebba1c0fb292a45', 0, 'c71aeeae981845a3bfdcfc38d34497a0', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('23ad4fa44d184bbeb6e232c44706351e', 0, 'cea0ede781d748c8bcb300bd71612430', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('249dbb91537645c2adbbde431b1dd2a7', 0, '4837110c21df4c4aac1950993777bbb0', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('24baec94346d4719818459e4c079b85a', 1, 'fe2a73f88fed4ee7bc393fd8ad47867e', '[\"efbceb7b845b49bb9c3c2b9341c49770\"]', 'cc4df33f4bbe46de874d363499242422', 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('24d473b13c284258b681d0a313fc94d1', 1, '7ab30154c23243a7837c91760778bddc', '[\"680a8537c48d46e792391f640c4a8acb\"]', '7659707144714036b6330ac87b550e24', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('26cb58e8b01d4f0d880a58b0586bfb62', 0, 'fbb82d91eb094350aa41ddbf6458e419', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('272707d12e8f4d9da87ce81e17f33fed', 0, '16502738ea7142afa3f5a2b30fd7340a', NULL, '84e78ba7d5e04a4e8eb9c5e1cb7795c6', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('27818610927643cd83643655a68a99cf', 0, 'b071cb6cc49d4899ad3177bd69426952', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('2b1ec944c87d459794d26335624932f3', 0, '4eb53a50f92b4bd29ee4303b454d5fcd', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('2c811d54b82f48949575e7478aa3def1', 0, 'b1caceff25914b3daed4ca946ab423f6', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('2e809ce4941d4bf3b6884a5d766de519', 0, '3f51e325a16d46dba9ab791b6f1e1bbb', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('3051806022614cbf80990455d36650f7', 0, 'd481d614f7a74465829cf380f297ee0c', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('31dda33e356e4d48814061b4d58abf9e', 0, '14af07de63c0493d8ec7f4554bd86d32', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('323ca2267e144f548811c9ff00e8e220', 0, 'a59bc2eea3bb4ecfa0fffd7abbd2b017', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('33d49bfd32724c17947722d395c0fd36', 0, '16502738ea7142afa3f5a2b30fd7340a', NULL, '56ef32d03edb49848bcf78c865c7fd93', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('33f371a0ba074d8c93b3c423c27d29a1', 0, 'a59bc2eea3bb4ecfa0fffd7abbd2b017', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('34586d9fa3ef4ad9a5dfc77a64021508', 0, 'd481d614f7a74465829cf380f297ee0c', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('363af302765442faa422f50b9481b5d4', 0, '3f74f08940214b829bc9636f644b7d61', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('36a1a0bc4435411cbde062c32c0fac0c', 1, 'a1922aafdafa41979769bfd61da548a8', '[\"51cc1d6f9bb5417d87f68fee0437193b\"]', '7659707144714036b6330ac87b550e24', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('36bb2d80cc5a49a2a865fb747a9ecde2', 0, '7c2eba01aaaa43639d9df205cd66ecb7', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('3702d319a4ad4936a93abc3e393f6fb6', 0, '6818caf6587c4cf6ba2468f91fc355b2', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('38350d9bd3a048389b4babfc8e85a2d5', 0, 'bd325a5aef7048e5871c8a60001394f3', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('3a01b29ffb4b406c92c01d952e40fdbc', 0, '381ce0c48bba4eafa9751bdbcdadd5d6', NULL, '04d9dc750eac454fb5c2c1104157f617', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('3b2a6df4fa9b4fdaad6a161669c0fe51', 0, 'a2457c9c44694a859223908831941002', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('3b716e2e5cea45ec81c33cc2f2067df9', 0, 'c71aeeae981845a3bfdcfc38d34497a0', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('3c9c23a076954b96867065996f15074e', 0, 'f27d7c56ca3d473087164fb47241725b', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('3d01a984668843ecb18cff6d871ceaf1', 0, 'e243b3bf70a648ec8da08c93f55af26d', NULL, 'df80ab627b884078b84e2f557f154a7e', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 4, '李白,杜甫');
INSERT INTO `user_answer` VALUES ('3e90e7ac77274294ae553182119fd3e2', 0, '3e07606eca9c4043a91f01182e0f3560', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('3f0a7e8d35fc4e72825c47abd4970699', 0, '865549d007ac4ec4b39ebaa154067f97', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('426d8896a7734b24a08ccac15e7cc5e9', 0, '6882fa950b3a44e58aad41a91eebbc76', NULL, 'd88000bebf244d08af0deb9322352bd1', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, '121wd、1我的、1的我、');
INSERT INTO `user_answer` VALUES ('436f7aa760c146aea56e627bae3b5b90', 0, 'a59bc2eea3bb4ecfa0fffd7abbd2b017', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('43efa0458e1840c8b9267ffcf31b9e0f', 0, '3c63ae9e3dae48d886997c320c863de7', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('46657d2f8d0d45938f0c93dc50c958bc', 0, 'a2457c9c44694a859223908831941002', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('46efb36e01ef4ff8ac0b9157c64625f6', 0, '6818caf6587c4cf6ba2468f91fc355b2', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('476675bd5db54e62b948dc4a2c561a6e', 0, '699b5e55acd04b57a0584016f6804494', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('47cb2f31e01540a9b262e152e014efd4', 0, '63659d404f694a8fbea7e1ea29126dd4', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('4841297cc69249de9ca0737787c9b8f1', 0, '27fa1550e3314b2a82d2493cbc4b0373', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('4b0c4f2b07c24581824dd860f7242ce2', 0, '3c63ae9e3dae48d886997c320c863de7', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('4bdad584e22442509402d4a05f5df153', 1, '029f7977ee744d9487ee5b1ed596a64f', '[\"dd2b7359d2d64f2cade1ad888201d292\"]', '7659707144714036b6330ac87b550e24', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('4cab8a888f04476e88075129698ee838', 1, 'b0ace503d6524c28b1dd607a57c105e1', '[\"544876f93c244229bc70a2f80ce44278\"]', '56ef32d03edb49848bcf78c865c7fd93', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('4d1a38b462b14241a8e4b7f214610885', 0, '699b5e55acd04b57a0584016f6804494', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('4f189e61805a40eab4e2f599e1a1a0cd', 0, 'b1caceff25914b3daed4ca946ab423f6', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('4f8f32449e0f4e18a83d2ffccc9c2135', 0, 'd4e72144095d479b9b25cadfd45a293f', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('50e92f6e6c2f410d8dd854560080bc2f', 1, 'fe2a73f88fed4ee7bc393fd8ad47867e', '[\"efbceb7b845b49bb9c3c2b9341c49770\"]', '7659707144714036b6330ac87b550e24', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('51b77a7b915e42d28502f617aa458046', 0, 'f9e0726e82cb40289f96a929987296e9', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('53b1ed7cf1ad4741be7046fa85ced228', 0, '63659d404f694a8fbea7e1ea29126dd4', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('53d40a2f35a24d5391f51d437e3e68cb', 0, '20ec59fa41274d28af5cb4c1f8660d33', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('5782f0387c60459eb82d6d1fb05ed159', 0, 'b071cb6cc49d4899ad3177bd69426952', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('59009809887c4cf5bc37b919028781bd', 0, '63659d404f694a8fbea7e1ea29126dd4', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('592e213da61e429388265cedc0b06143', 0, 'b36d73fdf1c4423ab38bb367ab23328f', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('59c50525f1184e46843fe4f970b92245', 1, 'c43edf71dcb243abb13d32df9605a655', '[\"8b4778e08164441ebeeea6d95b9fd7cf\"]', '7659707144714036b6330ac87b550e24', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('5bac072844784e1db4652cfe5acfbc9a', 1, 'b0ace503d6524c28b1dd607a57c105e1', '[\"544876f93c244229bc70a2f80ce44278\"]', '56d6eecf51404cf49c66a86a49c82d6f', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('5c135d4d0ce646cbb0e4b1d32e20c36a', 0, '7c2eba01aaaa43639d9df205cd66ecb7', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('5d03c77896f54fbd8d86a06dbb2d2b21', 0, 'cea0ede781d748c8bcb300bd71612430', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('5dae92d36c9540eca58d4b42bb940135', 0, '4793eebea0544f03951476504134ef3b', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('5ddfbdcdc3df43b4b35ca37781cebe67', 0, '1e3ea59523964a3fac5a4a30ef046a53', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('5e1d8d9bfed4420ba078e1e6637876af', 0, 'f27d7c56ca3d473087164fb47241725b', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('5edf2f02b4514f64a9c5f846855db664', 0, '0e80bcc639aa472aa5e98aecd8c9a58c', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('5f9e720707fa4e1e8199062e41d14611', 1, '01fada5fe3aa4a44b650e5c4a257d21c', NULL, '280a3d47e4e246e4b71a99dcdf63dd3a', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, '<p>777</p>');
INSERT INTO `user_answer` VALUES ('6047bfc023594e9e879f013f8ee9d6f7', 0, '3f74f08940214b829bc9636f644b7d61', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('604ce03a88154d85849fb97539d51e66', 1, '111dd1c11bc349dcb3798cc0af0ba830', '[\"357b59e85e54481e9c34db22938e1548\"]', '56d6eecf51404cf49c66a86a49c82d6f', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('6185212b84794d9d8b37aa1d02dd5e40', 0, '63659d404f694a8fbea7e1ea29126dd4', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('6308f68add7241db83becff945cda4ad', 0, '14af07de63c0493d8ec7f4554bd86d32', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('6426de1c75fa4c3c8743f0452d5e4b7a', 0, '93e59078f5aa4595a202a401d92d1902', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('65869a0afae4436dbf96d6f77a232d1c', 1, '3c63ae9e3dae48d886997c320c863de7', '[\"165eaa18a6c747b1af2183770e7ae63d\"]', 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('65bbecb540dd4a88838bdd4c4637d444', 0, 'b448b53af2d7457680d117ae26310805', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('66ff644e23f740f1a01d0808f3315271', 0, 'd4e72144095d479b9b25cadfd45a293f', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('673007a9f42447fba208ba4dfdfae678', 1, 'fe2a73f88fed4ee7bc393fd8ad47867e', '[\"efbceb7b845b49bb9c3c2b9341c49770\"]', 'cb7b78cbd77944c0a15ab6074b5b0f1d', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('68a9ad92b10e4ae79417c4cd17e432ce', 0, '63659d404f694a8fbea7e1ea29126dd4', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('6929f2424b394ec6a856554d4cfc316c', 0, 'c43edf71dcb243abb13d32df9605a655', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('69b6f1720d2f47c09ece90851dc212cd', 0, '4837110c21df4c4aac1950993777bbb0', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('6b3883ab6d9144229d2a85127db7baed', 0, 'fe2a73f88fed4ee7bc393fd8ad47867e', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('6d19561d81154beba37e463e91499f68', 0, 'c24f9337e21d4bf18f1fbadc71351dd5', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('6edd0814e2aa45c5815326d844c9a9fd', 0, '20ec59fa41274d28af5cb4c1f8660d33', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('6f9ced5bfdec47dd81139173f41c823c', 0, '9856ef743e7848e9b94a61d8646519f8', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7058ead5dddc44b7a802015b575e9c86', 0, '4837110c21df4c4aac1950993777bbb0', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('70e8d77a25eb4e7595b393ac4bbf983f', 0, 'f27d7c56ca3d473087164fb47241725b', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('71104bc6bf3844539064c51ed6fecd27', 0, '7c2eba01aaaa43639d9df205cd66ecb7', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('72404e0ac8af4a01a96ae8356105f4c9', 0, '3e07606eca9c4043a91f01182e0f3560', NULL, 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('724e39445c0b4f80b8494b464d81bedd', 0, 'b36d73fdf1c4423ab38bb367ab23328f', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('726f66fb78034ca8958a90bbe63bfb05', 1, 'dddd0101c95b44409907656c2291111b', '[\"e5539b99f51342fa8bf7e882de466c9d\"]', '56ef32d03edb49848bcf78c865c7fd93', 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 1, NULL);
INSERT INTO `user_answer` VALUES ('72a8877723d4421c984717baee67922a', 0, '7647768497cf4a2cb2d191cdb4a6efa4', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('72f1ddd5f86f4cb6a4a268afb00ecfd9', 0, '4f37cacdd8bf4a09b4be561c84eafdfd', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7375ffee70ec484bb736fbb3d9d4b262', 0, 'c24f9337e21d4bf18f1fbadc71351dd5', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('738a8b230f3241c79907af0e93ff85c9', 0, '4eb53a50f92b4bd29ee4303b454d5fcd', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7428d51b110b42e0b4ca29325d3419db', 1, 'a1922aafdafa41979769bfd61da548a8', '[\"df39f23056ef4af888ffd3408a548696\"]', 'cb7b78cbd77944c0a15ab6074b5b0f1d', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('74d835f275eb44c8b0e16ca9dbf56636', 0, 'b1caceff25914b3daed4ca946ab423f6', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('74e57f779f4b4a939689fc09a8199ea0', 0, 'a59bc2eea3bb4ecfa0fffd7abbd2b017', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('75b775d2d26a45838eaf029216e6d924', 0, 'c71aeeae981845a3bfdcfc38d34497a0', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7650a2599f2b4da69cbb54b717d099cc', 0, '2315aae4c4394970b9d66b2f83497250', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('783348568b1244f08367ba7935d64efc', 0, '2315aae4c4394970b9d66b2f83497250', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7857911394fa4c2c97070b35f9b1cdc9', 1, 'b0ace503d6524c28b1dd607a57c105e1', '[\"ebbe3cf709d848d5928ca88aa2210b1f\"]', 'd52207b91d01441ba70e68245d39138b', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 2, NULL);
INSERT INTO `user_answer` VALUES ('78d11c6d699944edbbf8352c5b3c923f', 1, 'c43edf71dcb243abb13d32df9605a655', '[\"8b4778e08164441ebeeea6d95b9fd7cf\"]', '388f02820790404fba352601e38612c4', 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('793ead9accd64ace8d1154900be268dc', 0, 'bd325a5aef7048e5871c8a60001394f3', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7995f05eec714b2ca645ba6fc408ef05', 0, 'a2457c9c44694a859223908831941002', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('79d297eeb9d64cde84477725ca9305e0', 0, '27fa1550e3314b2a82d2493cbc4b0373', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('79feb5bfe6e9406ea16d721bb75a2c9e', 0, 'c43edf71dcb243abb13d32df9605a655', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7a7fcfc5963c44f18f36577980ae1add', 0, '2ef952053c234876bcfe67dc61b1bf45', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7aed796c50d14d34b3da1bc05f4e072e', 0, '6818caf6587c4cf6ba2468f91fc355b2', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7af5df73cfe64cc4b8b30a049143cfdd', 0, '865549d007ac4ec4b39ebaa154067f97', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7bef8424fdd24213915a9d535542e449', 0, 'fbb82d91eb094350aa41ddbf6458e419', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7e138fdc2b7f46a1a63f89d78a60339d', 0, '4eb53a50f92b4bd29ee4303b454d5fcd', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('7e52bae282334498a0e44ff8c6633a94', 0, '778bb89404ee46699fdf3320d7750507', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('804916aefbdb4417907eb99f1a1dd566', 0, 'b1caceff25914b3daed4ca946ab423f6', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('818e7ccdb4a14de98ba039481a53ba70', 0, 'f9e0726e82cb40289f96a929987296e9', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8300d55938bc451fb7a0c6e764b092ec', 0, '7647768497cf4a2cb2d191cdb4a6efa4', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('84043e2cb99f430bb5e3e18da092216b', 0, '5611e5efbed5499e87f3c5cdf7832cef', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('852b89378ee845bbb5f7458d1f408950', 0, '9856ef743e7848e9b94a61d8646519f8', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('85aed2f301c94087b60632d518b416b4', 0, '14af07de63c0493d8ec7f4554bd86d32', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('85c9d4dbb0b3437ba4e96a8e6bbbd76b', 0, 'd4e72144095d479b9b25cadfd45a293f', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('85caf795b2a04424a90ac3b72ef59b4f', 0, '3f51e325a16d46dba9ab791b6f1e1bbb', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('87eb8c402a204b59bda204d51c6490d9', 0, '0e80bcc639aa472aa5e98aecd8c9a58c', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8908364dcce94e4f8f7cec2f2693a956', 0, 'f27d7c56ca3d473087164fb47241725b', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8ad0303a3f0e459b8ae971dbd50fdfe3', 0, 'c24f9337e21d4bf18f1fbadc71351dd5', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8ad92a4237d7482bb9c6f8d3898bfa46', 0, 'dcce5274f1ac43b196809f1f0ace36a3', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8b5980e694d24be084dc6ee6d90dfa9c', 0, 'b071cb6cc49d4899ad3177bd69426952', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8b8bc40e9c484ee995692a889a5f07b2', 1, '111dd1c11bc349dcb3798cc0af0ba830', '[\"3662be98735842069e57011ab4762a4b\"]', '26253935320b4943ba4eccd3ad506da2', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8bd86c2debc644ecb60a7ae5376ef5ba', 0, '7647768497cf4a2cb2d191cdb4a6efa4', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8c874912921c4192a23c0107b914bb3c', 0, '7ab30154c23243a7837c91760778bddc', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8cdd5decbe20480483d106e08eba87cb', 0, '9856ef743e7848e9b94a61d8646519f8', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8cf3b96816b049598101ff7a0ba8c487', 0, '4f37cacdd8bf4a09b4be561c84eafdfd', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8d2d6fdf33f0401ab3ac6af9f778f3ba', 0, '111dd1c11bc349dcb3798cc0af0ba830', NULL, 'd52207b91d01441ba70e68245d39138b', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8dc728b215954086982ea7fe9fb793db', 0, '111dd1c11bc349dcb3798cc0af0ba830', NULL, '84e78ba7d5e04a4e8eb9c5e1cb7795c6', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8e730bd46c2e41c39bc4af8b0d538f69', 0, '4f37cacdd8bf4a09b4be561c84eafdfd', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8eaf7ba156ca46cda1d748f9bd74706c', 0, '28a78e2127da41b5937c19b49f0acdb3', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8f26b63c8b6947b6a01d2fb065deecc8', 1, 'be7eb38737a84544901f1f3b0d6413be', '[\"9e5a99dba0a1429d9e53cb717539a4b8\"]', 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('8fad696ef8124cd3b9b60914aa932755', 1, '3c63ae9e3dae48d886997c320c863de7', '[\"ae393858c42f4621b555d84e27a90901\"]', '388f02820790404fba352601e38612c4', 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('8fdc791a17e24fbc932168acc4ad8b86', 1, '5611e5efbed5499e87f3c5cdf7832cef', '[\"47b848f60be04306a09fcd6fb4716c64\"]', 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('927fc30dd7184ab49ccc5e8cf416e069', 0, '20ec59fa41274d28af5cb4c1f8660d33', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('929b31f3cbd64b78aff6dd12ee4f816d', 0, 'dcce5274f1ac43b196809f1f0ace36a3', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('9317f5fb52df453395b22659a90e0bc3', 0, '2be24ca734cc4ad6b9bd1c59c605f9ee', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('954b45b621d047628478226e1f9ce8d9', 0, '3f74f08940214b829bc9636f644b7d61', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('95c3af55d86f4426b0dc1d8686e4e85e', 0, '3c63ae9e3dae48d886997c320c863de7', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('970d6116fc17412bb9344bb221de6f77', 0, 'e243b3bf70a648ec8da08c93f55af26d', NULL, 'd88000bebf244d08af0deb9322352bd1', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, '李白、杜甫');
INSERT INTO `user_answer` VALUES ('98259fc2e6784c1cba968794baacba58', 1, 'dddd0101c95b44409907656c2291111b', '[\"e5539b99f51342fa8bf7e882de466c9d\"]', 'd52207b91d01441ba70e68245d39138b', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 1, NULL);
INSERT INTO `user_answer` VALUES ('984aedb346984bd4ac0a52317d8af7f2', 1, '7ab30154c23243a7837c91760778bddc', '[\"df6f69adf73443ceab42f661ae9a8840\"]', 'cb7b78cbd77944c0a15ab6074b5b0f1d', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('997d10494483494cbf78e96bb2ca098b', 0, 'dcce5274f1ac43b196809f1f0ace36a3', NULL, 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('9b07d15712204a10855cf72ce8615106', 0, '5611e5efbed5499e87f3c5cdf7832cef', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('9bb77f30d6c74a639a461f6de64c2a39', 1, 'dddd0101c95b44409907656c2291111b', '[\"2a0646bd8e2a464b8e1d2290a2a83223\"]', '835a07f97cea4ab7a4b18ec1efec80c9', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('9bd40b996f1140baa8f714239774bdef', 0, '2315aae4c4394970b9d66b2f83497250', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('9d3ac8e4cefe4ac4af9f2006201f8490', 0, '699b5e55acd04b57a0584016f6804494', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('9d3bf6a75028403f99fdf5688704a356', 0, 'dcce5274f1ac43b196809f1f0ace36a3', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a00bb7bf96e24328b43a182c11201bef', 0, 'd4e72144095d479b9b25cadfd45a293f', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a017c5f1249f4ec696e2376e0106433f', 0, '45973db3255b488d95dd892506748e55', NULL, '04d9dc750eac454fb5c2c1104157f617', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a0f80a8a5ab741ac9f7aff6bc911b05e', 0, '4793eebea0544f03951476504134ef3b', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a213871186904e9bb112db7e96c36f02', 0, '9856ef743e7848e9b94a61d8646519f8', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a21cdedb6ac64419a3d14d2940a34a66', 0, '3e07606eca9c4043a91f01182e0f3560', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a2d200b42eff4e9aa2670d749a2f5ed0', 0, 'b071cb6cc49d4899ad3177bd69426952', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a3b331611f00466d96cdda18b6d95b8c', 0, 'be7eb38737a84544901f1f3b0d6413be', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a4ddc14b83ee4c2292cf982459f05c7d', 0, '029f7977ee744d9487ee5b1ed596a64f', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a5900f21d00e4a6789b51b75d98e477f', 0, '3f51e325a16d46dba9ab791b6f1e1bbb', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a59361d79484429b9fc020f43895e244', 0, '1e3ea59523964a3fac5a4a30ef046a53', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a6c0ea956924423fb9ed8361a9c6e2ee', 0, 'd481d614f7a74465829cf380f297ee0c', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a6eafbbfe5c04a40a2c07e72949f953a', 0, '3f51e325a16d46dba9ab791b6f1e1bbb', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('a84e9e9f11524572a8922ec17bc40622', 0, 'cea0ede781d748c8bcb300bd71612430', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('ab497799e92744ad8c2d30e2ab06c03f', 0, '778bb89404ee46699fdf3320d7750507', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('adb30f24183b4ffd944528430c0e7177', 1, '111dd1c11bc349dcb3798cc0af0ba830', '[\"3662be98735842069e57011ab4762a4b\"]', '56ef32d03edb49848bcf78c865c7fd93', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('adfa9f47d9d7437c87bb078678d1d538', 1, 'a1922aafdafa41979769bfd61da548a8', '[\"827942188775452fa513b641a49fb4b9\"]', 'ee42721a05524a0aa98de180b7ca17ec', 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('b0035d996dd44b0a9a6543d191337c71', 0, '4793eebea0544f03951476504134ef3b', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b09cc799566f4b75ba244e6be822c93c', 0, 'c71aeeae981845a3bfdcfc38d34497a0', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b1dbaf6fd8ab49e29edbd86cdafda68f', 1, '16502738ea7142afa3f5a2b30fd7340a', '[\"e8ebbec858104cd180ba37468341210e\"]', '26253935320b4943ba4eccd3ad506da2', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b2ceb5379ed9465898eb953cc9a4346a', 0, 'a59bc2eea3bb4ecfa0fffd7abbd2b017', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b2da322feaf548d185a198a7d082638e', 0, '2be24ca734cc4ad6b9bd1c59c605f9ee', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b3064feebb614d1c8de23d5feb37bfd7', 0, 'fbb82d91eb094350aa41ddbf6458e419', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b369c28c2aa1414584cb0b3c08ed32b7', 1, '551e87bf6abc4b9b80a7e27962dcb8a1', NULL, '280a3d47e4e246e4b71a99dcdf63dd3a', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, '<p>1231</p>');
INSERT INTO `user_answer` VALUES ('b535cd6dd6c045658810a61af8589a8c', 0, 'f27d7c56ca3d473087164fb47241725b', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b6113ae67a98451bb93a6d53df725230', 0, '5611e5efbed5499e87f3c5cdf7832cef', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b7127ed0f09249fdb3d63d1d193a308b', 0, 'cea0ede781d748c8bcb300bd71612430', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b936a64c5d6246d48fdd91a3e27d5937', 0, 'b448b53af2d7457680d117ae26310805', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('b9cc90a20c504f039eca57b73b6bf3c7', 0, '4793eebea0544f03951476504134ef3b', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('ba489f6888164ae3877b49a61bd0724a', 0, '1e3ea59523964a3fac5a4a30ef046a53', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('ba5c0f79fdfb4c0091ed30f4f08253f5', 0, 'be7eb38737a84544901f1f3b0d6413be', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('bb6949bfe9204e78891caf61869ab295', 0, '93e59078f5aa4595a202a401d92d1902', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('bce7ecbe2ab44e7aa73ad8d463c0d3d8', 1, 'fe2a73f88fed4ee7bc393fd8ad47867e', '[\"efbceb7b845b49bb9c3c2b9341c49770\"]', 'ee42721a05524a0aa98de180b7ca17ec', 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('bd381c3536e84987a27b577fe5c5ca12', 0, 'f9e0726e82cb40289f96a929987296e9', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('bd388470ace84231937d1bec26dceb6d', 0, 'a2457c9c44694a859223908831941002', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('bde3136ac6e841efa174820853029b48', 1, '16502738ea7142afa3f5a2b30fd7340a', '[\"e8ebbec858104cd180ba37468341210e\"]', '56d6eecf51404cf49c66a86a49c82d6f', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('beae599bdac64aa9925cc02fc99cf8a1', 0, '2315aae4c4394970b9d66b2f83497250', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('bff17bdd57e040eeb60bcec761adfa55', 1, '5611e5efbed5499e87f3c5cdf7832cef', '[\"d7ec488497064f14880a3b78741d7437\"]', '7659707144714036b6330ac87b550e24', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c0a72a159732498a82da39d521daab36', 0, 'c24f9337e21d4bf18f1fbadc71351dd5', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c13d9f8bb6d34a319c80b1b4d0a68efa', 0, '14af07de63c0493d8ec7f4554bd86d32', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c1df4b82a4d54d4f93883d22394efdf8', 0, '93e59078f5aa4595a202a401d92d1902', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c25c168ce7644ddbb4a5334fc57f2f87', 0, '0e80bcc639aa472aa5e98aecd8c9a58c', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c2918971c6fe46c8ace50b67d42f6d57', 0, '35b071389f714265bf83c0a4f3ed5aeb', NULL, '04d9dc750eac454fb5c2c1104157f617', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c366889859cc4521832af170ef990c78', 0, '4eb53a50f92b4bd29ee4303b454d5fcd', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c53aff10efde4b709ac05355c5bfd29c', 0, 'b0ace503d6524c28b1dd607a57c105e1', NULL, '531da5f99ae24ed2a09237b91ccce115', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c5a9193e837a40da82e1782ad2e523c8', 0, 'f9e0726e82cb40289f96a929987296e9', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c5dd6115185545bf8334150024c52226', 0, 'bd325a5aef7048e5871c8a60001394f3', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c613cd7ed35e4d79a7e84fc90a5aeb12', 0, '16502738ea7142afa3f5a2b30fd7340a', NULL, 'd52207b91d01441ba70e68245d39138b', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c651cdc2cca54a31af8fb2f826a9e4f7', 0, '3e07606eca9c4043a91f01182e0f3560', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c6f54b06326d43d481d6ae3bd9e26af6', 0, 'b1caceff25914b3daed4ca946ab423f6', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c7311b6c4d1943018e2629fdbb9486c0', 0, '4eb53a50f92b4bd29ee4303b454d5fcd', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('c84d968b455446a69aba5ba0451b1ae6', 0, '6818caf6587c4cf6ba2468f91fc355b2', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('ca38f73b299642f59ebe9389bceb23a9', 1, 'c43edf71dcb243abb13d32df9605a655', '[\"2aee979beee14cb6b4ca5c7577690066\"]', 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('cb91275da1254b63a16112e0a7febd3f', 0, '7647768497cf4a2cb2d191cdb4a6efa4', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('cbc386bf1042445bbc261e8da182df15', 0, '4ae568501509423a9406cb5dc38d3e29', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('cd98f2f627f947c6bfd3ecb4f81e90ec', 0, 'a1922aafdafa41979769bfd61da548a8', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('ce7c5770f5da4bd98fe54af2d18779c6', 1, 'b0ace503d6524c28b1dd607a57c105e1', '[\"544876f93c244229bc70a2f80ce44278\"]', '835a07f97cea4ab7a4b18ec1efec80c9', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('cf90eae10a4b41219f8117efd6a2b57a', 1, '111dd1c11bc349dcb3798cc0af0ba830', '[\"37b2fc411252436abebc8daf5dd74b7d\"]', '835a07f97cea4ab7a4b18ec1efec80c9', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('d1580d153f5f4ceba0eda44810af414d', 0, 'b448b53af2d7457680d117ae26310805', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('d1ee998b1f984c3cbfb81c9f60e918f4', 0, 'dddd0101c95b44409907656c2291111b', NULL, '531da5f99ae24ed2a09237b91ccce115', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('d410735e6b9c432c80e3023ba87f3989', 0, '16502738ea7142afa3f5a2b30fd7340a', NULL, '531da5f99ae24ed2a09237b91ccce115', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('d582fe4b50984ea0bfb7dd3fc52e50d6', 0, 'dcce5274f1ac43b196809f1f0ace36a3', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('d59059303c88423c9189cf76efa42916', 0, '2ef952053c234876bcfe67dc61b1bf45', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('d67c03cbef26409890a448044dbbcdf1', 0, 'b36d73fdf1c4423ab38bb367ab23328f', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('da3b1561945e49beaf11c62fe1cafdfc', 0, '28a78e2127da41b5937c19b49f0acdb3', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('dabd70dd283f4b469cdbb4d94501e792', 0, '699b5e55acd04b57a0584016f6804494', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('dcbee30eca164183a0863753e9970627', 0, '93e59078f5aa4595a202a401d92d1902', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('de9f322b2e1d4a9780d3c06a2dffb081', 0, '865549d007ac4ec4b39ebaa154067f97', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('e324bbb480744bb6b26708f0b4f50600', 0, 'c71aeeae981845a3bfdcfc38d34497a0', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('e4e030582e4c4cdd9366722ee12094de', 0, '28a78e2127da41b5937c19b49f0acdb3', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('e4f38a2253db49e2b53a6f246c46224f', 0, '93e59078f5aa4595a202a401d92d1902', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('e79625e2f5e34a6ebf3e06fa7132188a', 0, '029f7977ee744d9487ee5b1ed596a64f', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('e7edd507d0d9494384bb84902f9d2a41', 0, 'b36d73fdf1c4423ab38bb367ab23328f', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('e8b847572d1e4d8a961c3498202d10e8', 0, 'b448b53af2d7457680d117ae26310805', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('eb081c8f5de842a4b5659479cd2bd5af', 1, 'b0ace503d6524c28b1dd607a57c105e1', '[\"ebbe3cf709d848d5928ca88aa2210b1f\"]', '26253935320b4943ba4eccd3ad506da2', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 2, NULL);
INSERT INTO `user_answer` VALUES ('eb5ee1715b0e4f2c9b29e722b464ba4e', 1, 'dddd0101c95b44409907656c2291111b', '[\"e5539b99f51342fa8bf7e882de466c9d\"]', '26253935320b4943ba4eccd3ad506da2', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 1, NULL);
INSERT INTO `user_answer` VALUES ('ec799911e0a04364ba56b23e329ff3a2', 1, 'dddd0101c95b44409907656c2291111b', '[\"e5539b99f51342fa8bf7e882de466c9d\"]', '56d6eecf51404cf49c66a86a49c82d6f', 1, '8d322e7394904df2bed4723f2c58ec92', NULL, 1, NULL);
INSERT INTO `user_answer` VALUES ('ece27f05fa5a43529f9e8e9b603e6b90', 0, '778bb89404ee46699fdf3320d7750507', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('ee4bdd41c9bd4042a3ef220043a4199e', 0, '2be24ca734cc4ad6b9bd1c59c605f9ee', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('eee63fee5d0c4880bcc149a49368a89b', 0, '4ae568501509423a9406cb5dc38d3e29', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('ef26f96ebe924e659801859c01a1f26e', 0, 'cea0ede781d748c8bcb300bd71612430', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('efe28b22eb48476a832341a47676d60b', 0, 'b448b53af2d7457680d117ae26310805', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f0b4272c69134ac2bec62a0d52ea5366', 0, '14af07de63c0493d8ec7f4554bd86d32', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f103ba93b8a841e7addad1bc04fd82cc', 0, '6882fa950b3a44e58aad41a91eebbc76', NULL, 'df80ab627b884078b84e2f557f154a7e', 0, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, '112，1212');
INSERT INTO `user_answer` VALUES ('f12710e10642452daf7857774fd28368', 0, '4837110c21df4c4aac1950993777bbb0', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f1307952fa3647b1a61cd3436ee8877f', 1, '16502738ea7142afa3f5a2b30fd7340a', '[\"ffa366e4af4c41d18f4ee18d425904ca\"]', '835a07f97cea4ab7a4b18ec1efec80c9', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f184e0d3d3184863b0dc1e053b10451e', 0, '865549d007ac4ec4b39ebaa154067f97', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f56b6f418ac345f0878c9564d544ba4c', 0, '7647768497cf4a2cb2d191cdb4a6efa4', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f64e264e6b124fcaabc82560145d4ab8', 0, '1e3ea59523964a3fac5a4a30ef046a53', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f6605780524f48ccab8382b329014eca', 0, '28a78e2127da41b5937c19b49f0acdb3', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f84ee2d03b24417e800b474817afe8cb', 0, '1e3ea59523964a3fac5a4a30ef046a53', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f8c13c7ed92542cc911c1198d21968a8', 0, '029f7977ee744d9487ee5b1ed596a64f', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f9d1efb2c6ec43c08db7294c5716fc5a', 0, '4ae568501509423a9406cb5dc38d3e29', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('f9f0f19cd14947dc83faa36cf2215daf', 0, '9856ef743e7848e9b94a61d8646519f8', NULL, 'ee42721a05524a0aa98de180b7ca17ec', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('fade54c7bffc4bc2b1cdc6d12c341d0e', 0, '4793eebea0544f03951476504134ef3b', NULL, 'cc4df33f4bbe46de874d363499242422', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('fb9d568a43dc45aaa2b1db05d3a4f915', 1, '7ab30154c23243a7837c91760778bddc', '[\"df6f69adf73443ceab42f661ae9a8840\"]', 'ee42721a05524a0aa98de180b7ca17ec', 1, '90f8d5ed367a43468fbc0aa620f75830', NULL, 5, NULL);
INSERT INTO `user_answer` VALUES ('fcf7ce6f0a894ef8b41604c357b5f77b', 1, 'd481d614f7a74465829cf380f297ee0c', '[\"918424f788474d81aca2f8357ef14f42\"]', 'ee42721a05524a0aa98de180b7ca17ec', 0, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('feacdd8548c24a5595825f065e4ce8c5', 0, 'fbb82d91eb094350aa41ddbf6458e419', NULL, 'cb7b78cbd77944c0a15ab6074b5b0f1d', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('fec8527380744ed9bf37c65720ef8436', 0, 'd4e72144095d479b9b25cadfd45a293f', NULL, '388f02820790404fba352601e38612c4', NULL, '90f8d5ed367a43468fbc0aa620f75830', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('ff01cc5ad9654ebbac4390d1fa5fec4d', 0, '4f37cacdd8bf4a09b4be561c84eafdfd', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);
INSERT INTO `user_answer` VALUES ('fff02868e6194459a95c69be8bb3f798', 0, '2be24ca734cc4ad6b9bd1c59c605f9ee', NULL, '7659707144714036b6330ac87b550e24', NULL, '8d322e7394904df2bed4723f2c58ec92', NULL, 0, NULL);

-- ----------------------------
-- Table structure for wrong_answer
-- ----------------------------
DROP TABLE IF EXISTS `wrong_answer`;
CREATE TABLE `wrong_answer`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `book_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '错题id（非题目id）',
  `answer_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '选项id',
  `wrong_count` int NOT NULL DEFAULT 0 COMMENT '选项次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '错题答案表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wrong_answer
-- ----------------------------
INSERT INTO `wrong_answer` VALUES (1, '7938ae54a27a4d9195a16b2b670121a0', 'd5acbe4df0de4ef787304ffb867572c9', 1);
INSERT INTO `wrong_answer` VALUES (2, '28cd4cafe0ef46d7b17428361ea1ff2d', 'aa3b18cf2b5b46ecbbf6e616ce1706dc', 1);
INSERT INTO `wrong_answer` VALUES (3, '28cd4cafe0ef46d7b17428361ea1ff2d', 'c92d118748c44063b3ffaa20640b9178', 1);
INSERT INTO `wrong_answer` VALUES (4, '91c80a56fc3b4ec493a3a0fb3d787b79', 'f0e4e8e2c437438ab0affa78d4b2936e', 1);
INSERT INTO `wrong_answer` VALUES (5, 'cd7d76396e474eb582f764d49e82064b', 'ee1313f0b455457ea116d9af3fc203ff', 1);
INSERT INTO `wrong_answer` VALUES (6, '594a74c72bbb400fad11279825dc99a5', 'e92a4656d35f450db6d5d25c0780346f', 1);
INSERT INTO `wrong_answer` VALUES (7, 'ef57f7da07834c08829f7b80972c740f', 'c1988c086675439fb733276d638542fd', 1);
INSERT INTO `wrong_answer` VALUES (8, 'ef57f7da07834c08829f7b80972c740f', '4b0d73f1ad8740ef9f0fcd69c803d016', 1);
INSERT INTO `wrong_answer` VALUES (9, 'e68c9c4990f741a783babbad6357be43', 'c512e6b31cac4c02975327277d442d7e', 1);
INSERT INTO `wrong_answer` VALUES (10, '7ae87002773f495fabe55aa9b64cdafb', '623b6519a2df4020a173958c6bea04c6', 1);
INSERT INTO `wrong_answer` VALUES (11, '1bdf7f475909428e83ec3c1a96158280', '713c955839564d64a750f5f78217eac4', 1);
INSERT INTO `wrong_answer` VALUES (12, '1bdf7f475909428e83ec3c1a96158280', 'ce35b5ee7e604156a30f842651418d98', 1);
INSERT INTO `wrong_answer` VALUES (13, '1b04891096e34ce9bbd942c768dd84cb', 'ba6dff52d39c4bb0a94171e17a566f1f', 1);
INSERT INTO `wrong_answer` VALUES (14, 'eda7e70b5537460cbed71fca42da2afc', '0cf20be8bb0045b2b4a6135e43c3ecae', 1);
INSERT INTO `wrong_answer` VALUES (15, 'eda7e70b5537460cbed71fca42da2afc', 'cecd035412cf44518dee88f198df2215', 1);
INSERT INTO `wrong_answer` VALUES (16, '7938ae54a27a4d9195a16b2b670121a0', 'd5acbe4df0de4ef787304ffb867572c9', 2);
INSERT INTO `wrong_answer` VALUES (17, '7938ae54a27a4d9195a16b2b670121a0', '812858d2247f43f096cd4eb9822b5840', 1);
INSERT INTO `wrong_answer` VALUES (18, 'eda7e70b5537460cbed71fca42da2afc', 'b7327b5ea9d14aa7bcfcb05efd2c9483', 1);
INSERT INTO `wrong_answer` VALUES (19, 'eda7e70b5537460cbed71fca42da2afc', 'a7b159bf986845eb9ea4769a9d619de9', 1);
INSERT INTO `wrong_answer` VALUES (20, '7ae87002773f495fabe55aa9b64cdafb', 'bec64454109a4fcfb83f9e476046bb72', 1);
INSERT INTO `wrong_answer` VALUES (21, '7ae87002773f495fabe55aa9b64cdafb', '623b6519a2df4020a173958c6bea04c6', 2);
INSERT INTO `wrong_answer` VALUES (22, '7ae87002773f495fabe55aa9b64cdafb', 'be72ea9ba2ff4b8eaccd41b5b1363ad5', 1);
INSERT INTO `wrong_answer` VALUES (23, '7ae87002773f495fabe55aa9b64cdafb', 'c6b3651dfbda4a978aa292748dbc3da4', 1);
INSERT INTO `wrong_answer` VALUES (24, '7ae87002773f495fabe55aa9b64cdafb', 'e9f3e1239bc843b9864535d4c84fbfcc', 1);
INSERT INTO `wrong_answer` VALUES (25, 'eda7e70b5537460cbed71fca42da2afc', '0cf20be8bb0045b2b4a6135e43c3ecae', 2);
INSERT INTO `wrong_answer` VALUES (26, 'eda7e70b5537460cbed71fca42da2afc', 'cecd035412cf44518dee88f198df2215', 2);
INSERT INTO `wrong_answer` VALUES (27, 'eda7e70b5537460cbed71fca42da2afc', '9c8735bae9d746beb9a0bd4731a8b5ac', 1);
INSERT INTO `wrong_answer` VALUES (28, 'eda7e70b5537460cbed71fca42da2afc', 'a7b159bf986845eb9ea4769a9d619de9', 2);
INSERT INTO `wrong_answer` VALUES (29, 'eda7e70b5537460cbed71fca42da2afc', 'b7327b5ea9d14aa7bcfcb05efd2c9483', 2);
INSERT INTO `wrong_answer` VALUES (30, '1bdf7f475909428e83ec3c1a96158280', '713c955839564d64a750f5f78217eac4', 2);
INSERT INTO `wrong_answer` VALUES (31, '1bdf7f475909428e83ec3c1a96158280', 'ce35b5ee7e604156a30f842651418d98', 2);
INSERT INTO `wrong_answer` VALUES (32, '1bdf7f475909428e83ec3c1a96158280', '610906f2b65e42ac8c84ac4e3d45ab0a', 1);
INSERT INTO `wrong_answer` VALUES (33, '1bdf7f475909428e83ec3c1a96158280', '8c2cfee60b87411dba8e894108799a30', 1);
INSERT INTO `wrong_answer` VALUES (34, '1bdf7f475909428e83ec3c1a96158280', '46b27083fba7497596579e38bd1349d3', 1);
INSERT INTO `wrong_answer` VALUES (35, '7938ae54a27a4d9195a16b2b670121a0', '5dde86da074c485fa5ec05de7b900539', 1);
INSERT INTO `wrong_answer` VALUES (36, 'cd7d76396e474eb582f764d49e82064b', '9f1ab3f63d934026bad23eb3b93184aa', 1);
INSERT INTO `wrong_answer` VALUES (37, '28cd4cafe0ef46d7b17428361ea1ff2d', '390e6e98a4574524ab06addbe2f13f57', 1);
INSERT INTO `wrong_answer` VALUES (38, '28cd4cafe0ef46d7b17428361ea1ff2d', '9760fde8c9ff49b0bf1c115a9b9da233', 1);
INSERT INTO `wrong_answer` VALUES (39, '91c80a56fc3b4ec493a3a0fb3d787b79', '87bbee283d454cf8a94c1ad02efe5b73', 1);
INSERT INTO `wrong_answer` VALUES (40, '1bdf7f475909428e83ec3c1a96158280', '713c955839564d64a750f5f78217eac4', 2);
INSERT INTO `wrong_answer` VALUES (41, 'e68c9c4990f741a783babbad6357be43', '9ebd2fdf4c2847d1af93ceffde82c019', 1);
INSERT INTO `wrong_answer` VALUES (42, '7ae87002773f495fabe55aa9b64cdafb', '623b6519a2df4020a173958c6bea04c6', 2);
INSERT INTO `wrong_answer` VALUES (43, '1b04891096e34ce9bbd942c768dd84cb', '5f8c02bf847c496694e783b1cc1a9e40', 1);
INSERT INTO `wrong_answer` VALUES (44, 'ef57f7da07834c08829f7b80972c740f', 'c1988c086675439fb733276d638542fd', 2);
INSERT INTO `wrong_answer` VALUES (45, 'ef57f7da07834c08829f7b80972c740f', '4b0d73f1ad8740ef9f0fcd69c803d016', 2);
INSERT INTO `wrong_answer` VALUES (46, 'eda7e70b5537460cbed71fca42da2afc', '0cf20be8bb0045b2b4a6135e43c3ecae', 2);
INSERT INTO `wrong_answer` VALUES (47, 'eda7e70b5537460cbed71fca42da2afc', 'cecd035412cf44518dee88f198df2215', 2);
INSERT INTO `wrong_answer` VALUES (48, '594a74c72bbb400fad11279825dc99a5', 'e92a4656d35f450db6d5d25c0780346f', 2);
INSERT INTO `wrong_answer` VALUES (49, '932c8ddc524f40f9bd3b6c9e495cbefc', 'a53cfe049fc1485c9dee31f6d0a45f2a', 1);
INSERT INTO `wrong_answer` VALUES (50, '8d828b92580c46cfb09e16f0bbc532e5', 'e3a3873babbd433b9ae4cfb53e830e58', 1);
INSERT INTO `wrong_answer` VALUES (51, 'f5f923e9b08d411db43aac70a7aaafb9', 'c80ba3b51dc24cae9b371ded05917c78', 1);
INSERT INTO `wrong_answer` VALUES (52, '88bf5ac5ee3743d5bb25c09021c14f97', '544876f93c244229bc70a2f80ce44278', 1);
INSERT INTO `wrong_answer` VALUES (53, 'b98796263ccc4a2898fcdc644dc421c3', '3662be98735842069e57011ab4762a4b', 1);
INSERT INTO `wrong_answer` VALUES (54, '0efd0fef628743c49fc944e906d9321e', '918424f788474d81aca2f8357ef14f42', 1);
INSERT INTO `wrong_answer` VALUES (55, '091f65688e054d3e8966d0e8b446354c', '4006c1fbb4994043bcc38a98200fd9f1', 1);
INSERT INTO `wrong_answer` VALUES (56, '19582a38c1a248dca332575b2e363b96', '165eaa18a6c747b1af2183770e7ae63d', 1);
INSERT INTO `wrong_answer` VALUES (57, 'c6791454a1a44c44b947727d6ede3cb5', '2aee979beee14cb6b4ca5c7577690066', 1);
INSERT INTO `wrong_answer` VALUES (58, '44099e969cfd41968f5e025865b184d0', '9e5a99dba0a1429d9e53cb717539a4b8', 1);
INSERT INTO `wrong_answer` VALUES (59, 'e04beb3b9f81478a9ff66b3327a13765', '47b848f60be04306a09fcd6fb4716c64', 1);
INSERT INTO `wrong_answer` VALUES (60, '01d69621435d4a70a949f942303c8eb6', '4e43fa265d2c41b08bce4be09e83b3b2', 1);
INSERT INTO `wrong_answer` VALUES (61, 'c8216e590a144e9ebaad1619aa4f9406', '2a0646bd8e2a464b8e1d2290a2a83223', 1);
INSERT INTO `wrong_answer` VALUES (62, '88bf5ac5ee3743d5bb25c09021c14f97', '544876f93c244229bc70a2f80ce44278', 2);
INSERT INTO `wrong_answer` VALUES (63, 'b98796263ccc4a2898fcdc644dc421c3', '37b2fc411252436abebc8daf5dd74b7d', 1);
INSERT INTO `wrong_answer` VALUES (64, 'c6c23d862d3444898165ed04457ccc5b', 'ffa366e4af4c41d18f4ee18d425904ca', 1);
INSERT INTO `wrong_answer` VALUES (65, '0f8ec70522ce489099a1a9a09cd2ee02', '13a1303ff75140d18218c83e48f4ebf2', 1);
INSERT INTO `wrong_answer` VALUES (66, '8d828b92580c46cfb09e16f0bbc532e5', 'e3a3873babbd433b9ae4cfb53e830e58', 2);
INSERT INTO `wrong_answer` VALUES (67, '932c8ddc524f40f9bd3b6c9e495cbefc', 'a53cfe049fc1485c9dee31f6d0a45f2a', 2);
INSERT INTO `wrong_answer` VALUES (68, '179510411b424561a1ef997ab75c5d4e', 'f8786f55b37e4133945cc56206b7a871', 1);
INSERT INTO `wrong_answer` VALUES (69, '883f36f1e3af4d8fbc251482681ab666', 'd1b91e808f824725aa02a2a3a733f5cd', 1);
INSERT INTO `wrong_answer` VALUES (70, '28193c0d53f44d8f8a13c203b602f4a6', '660bde34886c48738e053fa140f1ee30', 1);
INSERT INTO `wrong_answer` VALUES (71, '6c2980e59ea84acf85943a1b20249c9e', '86304bf53ba041459e5eb950307f5817', 1);
INSERT INTO `wrong_answer` VALUES (72, 'a829c77a156340b3b1446035118d4566', '3662be98735842069e57011ab4762a4b', 1);
INSERT INTO `wrong_answer` VALUES (73, '72a52fff332d4b39bef4b6b471f21e92', 'e8ebbec858104cd180ba37468341210e', 1);
INSERT INTO `wrong_answer` VALUES (74, 'bf9848c155084e33b6fb97b73358d2e7', '680a8537c48d46e792391f640c4a8acb', 1);
INSERT INTO `wrong_answer` VALUES (75, '4e0d94ed3db24eb2bd447c18dffaa44a', '51cc1d6f9bb5417d87f68fee0437193b', 1);
INSERT INTO `wrong_answer` VALUES (76, 'c23333b6d07a4ceda418a02d0d2fe8a3', '4006c1fbb4994043bcc38a98200fd9f1', 1);
INSERT INTO `wrong_answer` VALUES (77, 'c8fc7cbcf89b4bb4a5fbc99967a0e66a', 'd7ec488497064f14880a3b78741d7437', 1);
INSERT INTO `wrong_answer` VALUES (78, 'd89686919f6c42fe8d78e7ead8021284', 'dd2b7359d2d64f2cade1ad888201d292', 1);
INSERT INTO `wrong_answer` VALUES (79, '410b38d72b054d9184cadfb1b77ce7fd', '544876f93c244229bc70a2f80ce44278', 1);
INSERT INTO `wrong_answer` VALUES (80, 'a829c77a156340b3b1446035118d4566', '357b59e85e54481e9c34db22938e1548', 1);
INSERT INTO `wrong_answer` VALUES (81, '72a52fff332d4b39bef4b6b471f21e92', 'e8ebbec858104cd180ba37468341210e', 2);
INSERT INTO `wrong_answer` VALUES (82, '28cd4cafe0ef46d7b17428361ea1ff2d', '390e6e98a4574524ab06addbe2f13f57', 2);
INSERT INTO `wrong_answer` VALUES (83, '28cd4cafe0ef46d7b17428361ea1ff2d', '9760fde8c9ff49b0bf1c115a9b9da233', 2);

SET FOREIGN_KEY_CHECKS = 1;
