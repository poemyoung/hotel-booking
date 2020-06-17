/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : hotel_system

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 15/06/2020 23:04:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reserves
-- ----------------------------
DROP TABLE IF EXISTS `reserves`;
CREATE TABLE `reserves` (
  `id` int NOT NULL,
  `hotelId` int DEFAULT NULL,
  `roomId` int NOT NULL,
  `createAt` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `userPhone` varchar(255) NOT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `checkInAt` date NOT NULL,
  `checkOutAt` date NOT NULL,
  `pay` enum('Alipay','WeChat Pay','Unionpay') NOT NULL,
  `price` decimal(11,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of reserves
-- ----------------------------
BEGIN;
INSERT INTO `reserves` VALUES (1, 1297, 1, '2020-06-11 22:33:33', 'Jena Dunn', '1-262-831-7615', 'id@non.net', '2020-06-19', '2020-07-14', ' Unionpay', 143);
INSERT INTO `reserves` VALUES (2, 2616, 2, '2020-06-03 16:23:19', 'Marshall Maynard', '1-793-408-3314', 'ipsum.cursus@Uttinciduntvehicula.ca', '2020-06-18', '2020-06-21', ' Unionpay', 220);
INSERT INTO `reserves` VALUES (3, 8363, 3, '2020-06-14 06:13:39', 'Yoshio Stanton', '1-200-822-3797', 'mattis.velit@velmauris.co.uk', '2020-06-17', '2020-07-27', 'Alipay', 264);
INSERT INTO `reserves` VALUES (4, 45147, 4, '2020-06-09 03:19:25', 'Jade Burton', '1-321-549-1867', 'tempus.non.lacinia@odiotristique.co.uk', '2020-06-19', '2020-07-12', 'Alipay', 234);
INSERT INTO `reserves` VALUES (5, 47634, 5, '2020-06-07 00:31:21', 'Lacy Burgess', '1-614-243-4447', 'amet@sempercursus.ca', '2020-06-15', '2020-06-21', ' Unionpay', 169);
INSERT INTO `reserves` VALUES (6, 47635, 6, '2020-06-10 02:47:24', 'Jamal Mcknight', '1-531-555-0581', 'mollis@Nulla.com', '2020-06-16', '2020-07-11', 'Alipay', 125);
INSERT INTO `reserves` VALUES (7, 48343, 7, '2020-06-10 11:58:50', 'Bertha Lee', '1-948-150-2737', 'metus.sit.amet@massalobortisultrices.edu', '2020-06-20', '2020-07-27', 'WeChat Pay', 156);
INSERT INTO `reserves` VALUES (8, 61518, 8, '2020-06-07 20:12:45', 'Samantha Barrett', '1-970-929-5507', 'ornare.elit@egetipsum.co.uk', '2020-06-19', '2020-07-27', 'Alipay', 117);
INSERT INTO `reserves` VALUES (9, 61520, 9, '2020-06-02 20:32:42', 'Judah Grant', '1-681-103-6328', 'eros.Nam@necimperdietnec.edu', '2020-06-20', '2020-07-22', ' Unionpay', 186);
INSERT INTO `reserves` VALUES (10, 61521, 10, '2020-06-07 05:28:02', 'Halee Kane', '1-321-263-8075', 'ut.lacus@et.org', '2020-06-15', '2020-06-25', 'WeChat Pay', 103);
INSERT INTO `reserves` VALUES (11, 61529, 11, '2020-06-08 05:58:56', 'Prescott Ortega', '1-728-488-4567', 'in.consequat@massanon.co.uk', '2020-06-16', '2020-07-17', ' Unionpay', 156);
INSERT INTO `reserves` VALUES (12, 61530, 12, '2020-06-04 15:02:53', 'Hunter Randall', '1-609-919-0310', 'ullamcorper.velit@tellusAenean.net', '2020-06-16', '2020-07-11', ' Unionpay', 212);
INSERT INTO `reserves` VALUES (13, 61534, 13, '2020-06-07 22:50:51', 'Louis Owens', '1-904-350-3871', 'aliquam.eros@Vivamus.com', '2020-06-17', '2020-07-13', 'Alipay', 116);
INSERT INTO `reserves` VALUES (14, 61535, 14, '2020-06-02 19:30:19', 'Hedy Martinez', '1-499-557-3721', 'nisl@vel.org', '2020-06-17', '2020-07-08', 'WeChat Pay', 253);
INSERT INTO `reserves` VALUES (15, 61542, 15, '2020-06-05 02:08:22', 'Francesca Dalton', '1-797-353-2664', 'aliquet.Proin.velit@Maurisvestibulumneque.net', '2020-06-20', '2020-06-30', 'Alipay', 86);
INSERT INTO `reserves` VALUES (16, 1297, 16, '2020-06-12 17:15:59', 'Alec Greene', '1-611-909-6169', 'ut.ipsum@nequeMorbi.net', '2020-06-17', '2020-07-11', ' Unionpay', 167);
INSERT INTO `reserves` VALUES (17, 2616, 17, '2020-06-02 18:16:49', 'Tarik Browning', '1-132-212-4539', 'eget@mattis.edu', '2020-06-15', '2020-07-06', ' Unionpay', 121);
INSERT INTO `reserves` VALUES (18, 8363, 18, '2020-06-03 18:39:03', 'Kieran Watkins', '1-102-419-1058', 'libero.et@nulla.ca', '2020-06-20', '2020-07-06', 'Alipay', 125);
INSERT INTO `reserves` VALUES (19, 45147, 19, '2020-06-06 03:16:26', 'Abel Obrien', '1-207-659-2650', 'mollis.dui.in@senectus.com', '2020-06-16', '2020-06-29', 'Alipay', 177);
INSERT INTO `reserves` VALUES (20, 47634, 20, '2020-06-09 10:28:15', 'Jaden Marshall', '1-648-389-0693', 'venenatis@tempusnonlacinia.com', '2020-06-15', '2020-07-29', 'Alipay', 279);
INSERT INTO `reserves` VALUES (21, 47635, 21, '2020-06-14 23:40:56', 'Yuri Rivers', '1-707-218-9869', 'sed.facilisis.vitae@egestasa.ca', '2020-06-19', '2020-07-10', ' Unionpay', 211);
INSERT INTO `reserves` VALUES (22, 48343, 22, '2020-06-05 15:05:25', 'Ora Cooley', '1-890-159-0466', 'felis.ullamcorper.viverra@utsemNulla.ca', '2020-06-19', '2020-07-18', ' Unionpay', 135);
INSERT INTO `reserves` VALUES (23, 61518, 23, '2020-06-07 09:25:52', 'Oren Petersen', '1-577-358-3145', 'quam@vehiculaPellentesque.org', '2020-06-15', '2020-07-15', ' Unionpay', 170);
INSERT INTO `reserves` VALUES (24, 61520, 24, '2020-06-06 14:11:46', 'Summer Klein', '1-502-538-0161', 'faucibus.ut.nulla@pede.net', '2020-06-20', '2020-07-20', 'Alipay', 148);
INSERT INTO `reserves` VALUES (25, 61521, 25, '2020-06-03 11:15:38', 'Colby Conrad', '1-997-361-5010', 'sit.amet.massa@tellusAeneanegestas.net', '2020-06-15', '2020-07-08', ' Unionpay', 113);
INSERT INTO `reserves` VALUES (26, 61529, 26, '2020-06-06 13:02:43', 'Malik Mccarty', '1-483-747-5074', 'consequat@Nunc.com', '2020-06-19', '2020-06-29', 'Alipay', 105);
INSERT INTO `reserves` VALUES (27, 61530, 27, '2020-06-07 05:29:24', 'Rebekah Torres', '1-332-951-3116', 'molestie.orci@et.ca', '2020-06-19', '2020-07-13', 'WeChat Pay', 271);
INSERT INTO `reserves` VALUES (28, 61534, 28, '2020-06-12 08:39:42', 'Ciara Hendricks', '1-780-442-4234', 'enim.Curabitur.massa@nonloremvitae.edu', '2020-06-15', '2020-06-23', 'WeChat Pay', 223);
INSERT INTO `reserves` VALUES (29, 61535, 29, '2020-06-05 07:32:28', 'Nissim Higgins', '1-686-727-2756', 'porttitor@Pellentesquehabitant.co.uk', '2020-06-15', '2020-06-27', ' Unionpay', 196);
INSERT INTO `reserves` VALUES (30, 61542, 30, '2020-06-08 17:12:38', 'Tanner Rosales', '1-555-505-9144', 'nunc.In@atvelitCras.org', '2020-06-15', '2020-07-25', ' Unionpay', 239);
INSERT INTO `reserves` VALUES (31, 61544, 31, '2020-06-10 09:58:40', 'Jocelyn Moody', '1-728-491-1540', 'dolor.dolor@rutrumnon.org', '2020-06-20', '2020-07-27', 'Alipay', 279);
INSERT INTO `reserves` VALUES (32, 61552, 32, '2020-06-09 06:41:46', 'Rhona Stone', '1-557-544-5244', 'eu.ultrices@infaucibus.com', '2020-06-20', '2020-06-25', ' Unionpay', 75);
INSERT INTO `reserves` VALUES (33, 71800, 33, '2020-06-07 15:52:22', 'Minerva Richards', '1-526-883-4479', 'dis.parturient.montes@velit.ca', '2020-06-17', '2020-07-27', 'WeChat Pay', 103);
INSERT INTO `reserves` VALUES (34, 72647, 34, '2020-06-05 05:58:38', 'Duncan Camacho', '1-413-872-8501', 'odio.tristique.pharetra@lectusNullam.org', '2020-06-16', '2020-06-26', 'WeChat Pay', 96);
INSERT INTO `reserves` VALUES (35, 76784, 35, '2020-06-14 15:47:38', 'McKenzie Nguyen', '1-744-185-2920', 'felis@interdumNunc.ca', '2020-06-19', '2020-06-29', 'WeChat Pay', 124);
INSERT INTO `reserves` VALUES (36, 91637, 36, '2020-06-04 01:57:39', 'Myles Carter', '1-597-181-4895', 'Suspendisse@Integer.co.uk', '2020-06-20', '2020-07-09', 'WeChat Pay', 184);
INSERT INTO `reserves` VALUES (37, 96298, 37, '2020-06-04 23:49:17', 'Kelly Petersen', '1-349-784-1248', 'scelerisque.sed.sapien@nullaIntegervulputate.com', '2020-06-16', '2020-07-05', 'Alipay', 153);
INSERT INTO `reserves` VALUES (38, 103872, 38, '2020-06-14 09:01:58', 'Germane Holman', '1-952-390-7011', 'purus@odiovel.edu', '2020-06-16', '2020-07-03', 'WeChat Pay', 213);
INSERT INTO `reserves` VALUES (39, 108387, 39, '2020-06-02 03:37:08', 'Demetrius Ruiz', '1-452-708-8999', 'sit.amet.ultricies@fringillaeuismodenim.ca', '2020-06-19', '2020-07-18', 'Alipay', 265);
INSERT INTO `reserves` VALUES (40, 108422, 40, '2020-06-08 19:35:29', 'Mira Woods', '1-277-291-6853', 'et.eros.Proin@Mauris.ca', '2020-06-17', '2020-07-16', ' Unionpay', 249);
INSERT INTO `reserves` VALUES (41, 108444, 41, '2020-06-09 16:27:21', 'Alden Dejesus', '1-104-971-7091', 'ipsum.Curabitur@elementumpurusaccumsan.ca', '2020-06-17', '2020-07-03', 'Alipay', 242);
INSERT INTO `reserves` VALUES (42, 108464, 42, '2020-06-11 19:39:06', 'Darryl Parsons', '1-152-168-8462', 'Donec.vitae.erat@egestasnuncsed.com', '2020-06-16', '2020-07-09', ' Unionpay', 165);
INSERT INTO `reserves` VALUES (43, 108499, 43, '2020-06-10 12:21:43', 'Alvin Long', '1-568-880-0219', 'in.aliquet.lobortis@facilisisvitae.ca', '2020-06-16', '2020-07-27', 'WeChat Pay', 231);
INSERT INTO `reserves` VALUES (44, 108573, 44, '2020-06-09 20:30:00', 'Sylvester Marquez', '1-335-752-8270', 'ornare.tortor.at@dolordapibus.edu', '2020-06-19', '2020-06-29', 'WeChat Pay', 183);
INSERT INTO `reserves` VALUES (45, 108666, 45, '2020-06-14 13:38:28', 'Olga Potter', '1-994-821-3658', 'eu.augue@gravidasagittisDuis.net', '2020-06-19', '2020-06-25', 'Alipay', 169);
INSERT INTO `reserves` VALUES (46, 108712, 46, '2020-06-06 19:05:36', 'Herrod Booker', '1-317-692-1860', 'leo@velvulputateeu.net', '2020-06-18', '2020-06-25', ' Unionpay', 122);
INSERT INTO `reserves` VALUES (47, 108736, 47, '2020-06-13 00:11:15', 'Hector Pitts', '1-250-943-2126', 'Proin.nisl@egestasnuncsed.ca', '2020-06-20', '2020-07-07', ' Unionpay', 218);
INSERT INTO `reserves` VALUES (48, 109035, 48, '2020-06-12 12:22:16', 'Medge Hendrix', '1-661-636-7144', 'ornare.elit@Pellentesquetincidunt.net', '2020-06-20', '2020-07-25', ' Unionpay', 169);
INSERT INTO `reserves` VALUES (49, 178024, 49, '2020-06-12 08:41:44', 'Ocean Emerson', '1-175-918-1898', 'scelerisque.mollis.Phasellus@ipsum.com', '2020-06-15', '2020-06-30', 'WeChat Pay', 95);
INSERT INTO `reserves` VALUES (50, 181793, 50, '2020-06-13 12:33:52', 'Chaim Tyler', '1-464-601-7228', 'eleifend@consectetuerrhoncusNullam.com', '2020-06-20', '2020-07-11', 'WeChat Pay', 167);
INSERT INTO `reserves` VALUES (51, 181807, 51, '2020-06-12 03:49:51', 'Quinlan Trujillo', '1-502-243-9170', 'porttitor.vulputate@natoquepenatibuset.com', '2020-06-18', '2020-07-30', 'Alipay', 63);
INSERT INTO `reserves` VALUES (52, 186790, 52, '2020-06-12 17:29:08', 'Thane Nicholson', '1-450-413-4605', 'lobortis.augue@ametconsectetueradipiscing.org', '2020-06-20', '2020-07-01', 'Alipay', 124);
INSERT INTO `reserves` VALUES (53, 193923, 53, '2020-06-09 02:01:43', 'Macaulay Taylor', '1-737-364-2389', 'auctor@eu.co.uk', '2020-06-17', '2020-07-26', 'WeChat Pay', 281);
INSERT INTO `reserves` VALUES (54, 197453, 54, '2020-06-14 01:24:56', 'Rhiannon Frank', '1-955-288-2833', 'non.dapibus.rutrum@estacmattis.org', '2020-06-19', '2020-06-25', 'Alipay', 279);
INSERT INTO `reserves` VALUES (55, 222032, 55, '2020-06-02 15:08:59', 'Pamela Skinner', '1-231-732-5471', 'vel@luctussit.co.uk', '2020-06-18', '2020-06-23', 'WeChat Pay', 271);
INSERT INTO `reserves` VALUES (56, 234485, 56, '2020-06-08 13:58:06', 'Boris Mclaughlin', '1-629-873-0708', 'Fusce.mollis.Duis@elementumdui.com', '2020-06-19', '2020-07-07', ' Unionpay', 297);
INSERT INTO `reserves` VALUES (57, 237499, 57, '2020-06-11 01:30:25', 'Katelyn Hanson', '1-470-463-1868', 'adipiscing.elit.Etiam@accumsan.edu', '2020-06-20', '2020-07-10', 'Alipay', 279);
INSERT INTO `reserves` VALUES (58, 241347, 58, '2020-06-02 14:43:25', 'Jack Mcintosh', '1-378-118-5755', 'Donec.elementum.lorem@gravidanon.ca', '2020-06-17', '2020-07-10', 'WeChat Pay', 136);
INSERT INTO `reserves` VALUES (59, 246238, 59, '2020-06-06 11:05:44', 'Kaye Avila', '1-142-982-9907', 'fringilla.euismod@rutrumeuultrices.net', '2020-06-17', '2020-07-11', ' Unionpay', 183);
INSERT INTO `reserves` VALUES (60, 246239, 60, '2020-06-02 08:09:57', 'Warren Joyce', '1-823-695-8544', 'eu.euismod@arcuNuncmauris.ca', '2020-06-19', '2020-07-25', ' Unionpay', 90);
INSERT INTO `reserves` VALUES (61, 246240, 61, '2020-06-14 05:46:16', 'Armando Pace', '1-829-575-7629', 'erat.Etiam@sitamet.edu', '2020-06-20', '2020-07-07', ' Unionpay', 101);
INSERT INTO `reserves` VALUES (62, 246247, 62, '2020-06-06 06:28:59', 'Walter Ball', '1-267-291-6757', 'orci.Ut@et.ca', '2020-06-15', '2020-06-30', 'Alipay', 68);
INSERT INTO `reserves` VALUES (63, 255273, 63, '2020-06-04 02:45:44', 'Iona Sellers', '1-267-651-4472', 'est.arcu.ac@imperdietnecleo.net', '2020-06-19', '2020-07-29', ' Unionpay', 288);
INSERT INTO `reserves` VALUES (64, 255331, 64, '2020-06-11 23:28:16', 'Grace Fuentes', '1-550-179-0370', 'orci@estmollisnon.ca', '2020-06-17', '2020-06-28', 'WeChat Pay', 290);
INSERT INTO `reserves` VALUES (65, 255388, 65, '2020-06-09 03:32:59', 'Lane Lucas', '1-222-891-6550', 'fringilla.est.Mauris@semper.ca', '2020-06-17', '2020-06-22', ' Unionpay', 285);
INSERT INTO `reserves` VALUES (66, 255997, 66, '2020-06-08 01:08:49', 'Connor Gill', '1-770-921-5261', 'fermentum@lobortis.edu', '2020-06-17', '2020-07-19', ' Unionpay', 201);
INSERT INTO `reserves` VALUES (67, 262433, 67, '2020-06-05 02:41:30', 'Alisa Oconnor', '1-619-866-4361', 'Vivamus.euismod.urna@Sed.org', '2020-06-16', '2020-07-13', 'Alipay', 214);
INSERT INTO `reserves` VALUES (68, 263527, 68, '2020-06-08 09:17:17', 'Keaton West', '1-213-182-0100', 'urna.et.arcu@sapien.org', '2020-06-20', '2020-07-24', 'WeChat Pay', 292);
INSERT INTO `reserves` VALUES (69, 264250, 69, '2020-06-07 19:55:14', 'Penelope Blankenship', '1-657-432-9187', 'penatibus@nullaIn.edu', '2020-06-15', '2020-07-28', ' Unionpay', 299);
INSERT INTO `reserves` VALUES (70, 264364, 70, '2020-06-05 16:29:45', 'Dahlia Moss', '1-756-577-3531', 'pretium.aliquet.metus@tempor.com', '2020-06-17', '2020-07-06', 'Alipay', 188);
INSERT INTO `reserves` VALUES (71, 264365, 71, '2020-06-03 23:38:39', 'John Gregory', '1-953-489-9734', 'augue@lacusAliquamrutrum.edu', '2020-06-18', '2020-06-28', 'Alipay', 266);
INSERT INTO `reserves` VALUES (72, 264367, 72, '2020-06-12 11:36:23', 'Emerald Mcgee', '1-713-639-1275', 'congue.elit.sed@semperduilectus.com', '2020-06-18', '2020-06-27', 'WeChat Pay', 74);
INSERT INTO `reserves` VALUES (73, 266502, 73, '2020-06-13 21:47:16', 'Kadeem Donaldson', '1-139-937-6799', 'congue@eleifendegestas.org', '2020-06-16', '2020-07-24', 'Alipay', 71);
INSERT INTO `reserves` VALUES (74, 266504, 74, '2020-06-09 17:55:01', 'Holmes Campbell', '1-560-187-8422', 'Quisque@rutrum.com', '2020-06-17', '2020-06-26', ' Unionpay', 157);
INSERT INTO `reserves` VALUES (75, 266528, 75, '2020-06-12 07:55:09', 'Cheyenne Stone', '1-579-153-5062', 'Etiam@etmagnisdis.net', '2020-06-18', '2020-07-30', ' Unionpay', 95);
INSERT INTO `reserves` VALUES (76, 266793, 76, '2020-06-12 04:20:52', 'Xanthus Jefferson', '1-404-995-6003', 'magna.a@risus.co.uk', '2020-06-18', '2020-07-25', 'Alipay', 70);
INSERT INTO `reserves` VALUES (77, 267694, 77, '2020-06-04 12:30:07', 'Logan Hill', '1-669-790-7582', 'magna@eratvel.net', '2020-06-16', '2020-07-12', 'WeChat Pay', 174);
INSERT INTO `reserves` VALUES (78, 270887, 78, '2020-06-06 18:49:02', 'Sawyer Mcdaniel', '1-421-862-2428', 'tellus.faucibus.leo@eunequepellentesque.net', '2020-06-16', '2020-07-08', 'WeChat Pay', 272);
INSERT INTO `reserves` VALUES (79, 270891, 79, '2020-06-04 20:42:24', 'Micah Gibbs', '1-650-503-9427', 'faucibus.Morbi@duiCum.edu', '2020-06-16', '2020-07-21', 'Alipay', 255);
INSERT INTO `reserves` VALUES (80, 271559, 80, '2020-06-08 00:27:29', 'Denton Andrews', '1-101-893-2892', 'In.mi.pede@sit.org', '2020-06-15', '2020-07-11', ' Unionpay', 135);
INSERT INTO `reserves` VALUES (81, 271589, 81, '2020-06-06 03:11:01', 'Richard Shaw', '1-597-144-2634', 'rutrum.magna@pede.org', '2020-06-19', '2020-07-13', 'WeChat Pay', 157);
INSERT INTO `reserves` VALUES (82, 284440, 82, '2020-06-14 04:55:39', 'Wesley Potter', '1-611-172-5202', 'mi.tempor@malesuadaIntegerid.com', '2020-06-15', '2020-07-15', 'WeChat Pay', 226);
INSERT INTO `reserves` VALUES (83, 284452, 83, '2020-06-02 09:17:38', 'Ezekiel Bean', '1-710-437-1836', 'rutrum.Fusce.dolor@Proinultrices.edu', '2020-06-20', '2020-07-28', ' Unionpay', 75);
INSERT INTO `reserves` VALUES (84, 289936, 84, '2020-06-12 04:27:56', 'Ulysses Ortiz', '1-365-356-4583', 'tellus.sem.mollis@Integer.net', '2020-06-18', '2020-07-20', ' Unionpay', 222);
INSERT INTO `reserves` VALUES (85, 290278, 85, '2020-06-13 04:06:38', 'Aurelia Woods', '1-800-272-6332', 'magna.Sed.eu@Cum.net', '2020-06-16', '2020-06-22', ' Unionpay', 246);
INSERT INTO `reserves` VALUES (86, 290994, 86, '2020-06-08 10:45:00', 'Kim Webb', '1-915-347-7631', 'gravida.sagittis.Duis@nec.ca', '2020-06-19', '2020-07-08', 'Alipay', 288);
INSERT INTO `reserves` VALUES (87, 292184, 87, '2020-06-09 06:53:20', 'Aurora Wiggins', '1-431-757-8609', 'In.scelerisque.scelerisque@ullamcorper.net', '2020-06-18', '2020-07-17', 'WeChat Pay', 232);
INSERT INTO `reserves` VALUES (88, 292519, 88, '2020-06-12 07:26:59', 'Hamilton Gilbert', '1-975-128-6574', 'ornare.placerat@enimSuspendisse.edu', '2020-06-17', '2020-07-16', 'Alipay', 85);
INSERT INTO `reserves` VALUES (89, 292687, 89, '2020-06-12 01:36:05', 'Wing Lindsay', '1-106-444-5526', 'ac.ipsum@nonarcu.edu', '2020-06-18', '2020-07-20', 'Alipay', 188);
INSERT INTO `reserves` VALUES (90, 293574, 90, '2020-06-09 06:00:32', 'Zoe Camacho', '1-696-793-1656', 'orci.in@CurabiturmassaVestibulum.com', '2020-06-16', '2020-07-20', 'Alipay', 87);
INSERT INTO `reserves` VALUES (91, 293612, 91, '2020-06-13 10:40:56', 'Neil Cohen', '1-852-423-4749', 'Suspendisse.dui@cursusNuncmauris.co.uk', '2020-06-20', '2020-07-01', ' Unionpay', 261);
INSERT INTO `reserves` VALUES (92, 294005, 92, '2020-06-13 07:09:31', 'Linda Edwards', '1-599-880-7524', 'sit.amet.consectetuer@Cumsociisnatoque.edu', '2020-06-19', '2020-07-28', 'Alipay', 245);
INSERT INTO `reserves` VALUES (93, 298047, 93, '2020-06-04 09:45:48', 'Kaseem Dyer', '1-493-806-2024', 'ipsum.dolor.sit@consequatlectus.com', '2020-06-17', '2020-06-26', 'Alipay', 256);
INSERT INTO `reserves` VALUES (94, 298051, 94, '2020-06-13 16:31:15', 'Adria Guerra', '1-780-709-9299', 'ligula.eu@at.org', '2020-06-16', '2020-06-28', 'Alipay', 190);
INSERT INTO `reserves` VALUES (95, 298116, 95, '2020-06-14 18:13:07', 'Angelica Brooks', '1-799-742-6445', 'Integer@necluctus.org', '2020-06-19', '2020-07-04', 'Alipay', 140);
INSERT INTO `reserves` VALUES (96, 298759, 96, '2020-06-09 15:02:49', 'Slade Lucas', '1-914-824-5713', 'magna.Praesent.interdum@a.net', '2020-06-16', '2020-07-17', 'WeChat Pay', 272);
INSERT INTO `reserves` VALUES (97, 299614, 97, '2020-06-13 03:22:29', 'Walker Mcneil', '1-199-501-8481', 'velit@utquamvel.com', '2020-06-19', '2020-06-26', 'Alipay', 110);
INSERT INTO `reserves` VALUES (98, 299743, 98, '2020-06-10 08:45:22', 'Christine Dudley', '1-767-275-4579', 'cursus@tincidunttempus.co.uk', '2020-06-19', '2020-07-07', ' Unionpay', 139);
INSERT INTO `reserves` VALUES (99, 300406, 99, '2020-06-04 05:58:51', 'Kibo Wilcox', '1-215-626-4867', 'condimentum@quam.com', '2020-06-20', '2020-07-05', ' Unionpay', 97);
INSERT INTO `reserves` VALUES (100, 300424, 100, '2020-06-12 02:56:34', 'Mary Goodwin', '1-369-879-8223', 'lobortis@laciniaorciconsectetuer.co.uk', '2020-06-17', '2020-06-29', ' Unionpay', 217);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
