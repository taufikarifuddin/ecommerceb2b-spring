-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2016 at 11:12 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerceb2b`
--

-- --------------------------------------------------------

--
-- Table structure for table `banners`
--

CREATE TABLE `banners` (
  `banner_id` int(10) NOT NULL,
  `banner_title` varchar(255) NOT NULL,
  `banner_image` varchar(255) NOT NULL,
  `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_visible` bit(1) DEFAULT b'0',
  `banner_order` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `banners`
--

INSERT INTO `banners` (`banner_id`, `banner_title`, `banner_image`, `date_added`, `is_visible`, `banner_order`) VALUES
(1, '123', '123', '2016-11-01 00:00:00', b'0', 0);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_id` int(10) NOT NULL,
  `member_gender` int(10) NOT NULL,
  `member_name` varchar(255) NOT NULL,
  `member_email_address` varchar(255) NOT NULL,
  `member_contact` varchar(255) NOT NULL,
  `member_contact2` varchar(255) NOT NULL,
  `member_password` varchar(255) NOT NULL,
  `member_is_active` tinyint(1) NOT NULL,
  `member_is_verified` tinyint(1) NOT NULL,
  `member_last_login` datetime DEFAULT NULL,
  `member_datecreated` datetime DEFAULT NULL,
  `member_account_modified` datetime DEFAULT NULL,
  `member_rolemember_role_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`member_id`, `member_gender`, `member_name`, `member_email_address`, `member_contact`, `member_contact2`, `member_password`, `member_is_active`, `member_is_verified`, `member_last_login`, `member_datecreated`, `member_account_modified`, `member_rolemember_role_id`) VALUES
(1, 1, '123', '123@123', '123', '123', '123', 1, 1, NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `member_address`
--

CREATE TABLE `member_address` (
  `member_address_id` int(10) NOT NULL,
  `member_stress_address_primary` varchar(255) NOT NULL,
  `member_street_address` varchar(255) DEFAULT NULL,
  `member_address_city` varchar(255) DEFAULT NULL,
  `member_address_province` varchar(255) DEFAULT NULL,
  `member_address_country` varchar(255) DEFAULT NULL,
  `member_address_post_code` int(10) DEFAULT NULL,
  `membermember_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `member_cart`
--

CREATE TABLE `member_cart` (
  `member_cart_id` int(10) NOT NULL,
  `member_cart_added` datetime DEFAULT CURRENT_TIMESTAMP,
  `member_cart_qty` int(10) NOT NULL,
  `membermember_id` int(10) NOT NULL,
  `productproduct_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `member_role`
--

CREATE TABLE `member_role` (
  `member_role_id` int(10) NOT NULL,
  `member_role_key` varchar(255) NOT NULL,
  `member_role_desc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `member_order_id` int(10) NOT NULL,
  `membermember_id` int(10) NOT NULL,
  `order_statusorder_status_id` int(10) NOT NULL,
  `order_date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `member_member_name` varchar(255) NOT NULL,
  `payment_methodpayment_method_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_comment`
--

CREATE TABLE `order_comment` (
  `order_comment_id` int(10) NOT NULL,
  `order_comment_message` varchar(255) DEFAULT NULL,
  `order_comment_date_added` int(10) DEFAULT NULL,
  `membermember_id` int(10) NOT NULL,
  `ordermember_order_id` int(10) NOT NULL,
  `member_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE `order_item` (
  `member_item_order_id` int(10) NOT NULL,
  `order_item_qty` int(10) NOT NULL,
  `order_item_final_price` int(10) NOT NULL,
  `productproduct_id` int(10) NOT NULL,
  `ordermember_order_id` int(10) NOT NULL,
  `product_product_name` varchar(255) DEFAULT NULL,
  `product_product_category_id` int(10) DEFAULT NULL,
  `product_product_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_status`
--

CREATE TABLE `order_status` (
  `order_status_id` int(10) NOT NULL,
  `order_status_name` varchar(255) NOT NULL,
  `order_status_desc` varchar(255) NOT NULL,
  `order_status_icon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `payment_method_id` int(10) NOT NULL,
  `payment_method_name` varchar(255) DEFAULT NULL,
  `payment_method_desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`payment_method_id`, `payment_method_name`, `payment_method_desc`) VALUES
(1, 'BCA', 'Pembayaran via rekening BCA');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(10) NOT NULL,
  `product_name` varchar(225) NOT NULL,
  `product_date_added` datetime DEFAULT CURRENT_TIMESTAMP,
  `product_last_modified` datetime DEFAULT CURRENT_TIMESTAMP,
  `product_desc` varchar(255) DEFAULT NULL,
  `product_viewed` int(10) DEFAULT '0',
  `product_default_price` int(10) NOT NULL,
  `is_visible` tinyint(1) DEFAULT NULL,
  `product_categoryproduct_category_id` int(10) NOT NULL,
  `product_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_date_added`, `product_last_modified`, `product_desc`, `product_viewed`, `product_default_price`, `is_visible`, `product_categoryproduct_category_id`, `product_code`) VALUES
(4, 'Segiempat renda', NULL, NULL, 'Segiempat renda (lace), bahan katun lembut dengan pinggiran renda dua sisi, warna bervariasi, ukuran 115 x 115', 0, 33000, 0, 23, 'SE01'),
(5, 'Instan Motif Bunga', NULL, NULL, 'Instan Motif Bunga, bahan katun rayon.', 0, 35000, 0, 25, 'IM01'),
(6, 'Pashmina ima', NULL, NULL, 'Pashmina ima, ukuran 120 x 75, bahan imascraft, tegak digunakan.', 0, 40000, 0, 24, 'PI01');

-- --------------------------------------------------------

--
-- Table structure for table `product_category`
--

CREATE TABLE `product_category` (
  `product_category_id` int(10) NOT NULL,
  `product_category_name` varchar(255) NOT NULL,
  `product_category_icon` varchar(255) NOT NULL,
  `product_category_desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_category`
--

INSERT INTO `product_category` (`product_category_id`, `product_category_name`, `product_category_icon`, `product_category_desc`) VALUES
(23, 'Segi Empat', 'square-o', 'Kerudung yang berbentuk segi empat'),
(24, 'Pashmina', 'sticky-note-o', 'Kerudung yang memiliki segiempat panjang'),
(25, 'Instan', 'user', 'Krudung yang dapat digunakan secara instan / mudah di pakai dengan langsung memakai di kepala'),
(26, 'Bergu', 'user', 'Kerudung instan yang memiliki pet'),
(27, 'Pashmina Instan', 'user-secret', 'Kerudung Pashmina yang bisa langsung di pakai secara instan');

-- --------------------------------------------------------

--
-- Table structure for table `product_discount`
--

CREATE TABLE `product_discount` (
  `product_discount_id` int(10) NOT NULL,
  `product_discount_tracehold` int(10) NOT NULL,
  `product_discount_price` int(10) NOT NULL,
  `productproduct_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_discount`
--

INSERT INTO `product_discount` (`product_discount_id`, `product_discount_tracehold`, `product_discount_price`, `productproduct_id`) VALUES
(1, 20, 32000, 4),
(2, 50, 30000, 4),
(3, 10, 32000, 5),
(4, 15, 30000, 5),
(5, 20, 38000, 6),
(6, 20, 35000, 6);

-- --------------------------------------------------------

--
-- Table structure for table `product_image`
--

CREATE TABLE `product_image` (
  `product_image_id` int(10) NOT NULL,
  `product_image_image` varchar(255) NOT NULL,
  `productproduct_id` int(10) NOT NULL,
  `product_image_order` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_image`
--

INSERT INTO `product_image` (`product_image_id`, `product_image_image`, `productproduct_id`, `product_image_order`) VALUES
(2, '1482399330475.jpg', 4, 1),
(3, '1482399338799.jpg', 4, 2),
(4, '1482399417191.jpg', 5, 1),
(5, '1482399423182.jpg', 5, 2),
(6, '1482399514461.jpg', 6, 1),
(7, '1482399522251.jpg', 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `product_review`
--

CREATE TABLE `product_review` (
  `product_review_id` int(10) NOT NULL,
  `product_review_rating` double NOT NULL,
  `product_review_comment` varchar(255) NOT NULL,
  `productproduct_id` int(10) NOT NULL,
  `membermember_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product_tag`
--

CREATE TABLE `product_tag` (
  `product_tag_id` int(10) NOT NULL,
  `productproduct_id` int(10) NOT NULL,
  `tagtag_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `proof_of_payment`
--

CREATE TABLE `proof_of_payment` (
  `proof_of_payment_id` int(10) NOT NULL,
  `proof_of_payment_image` varchar(255) NOT NULL,
  `proof_of_payment_upload_date` date NOT NULL,
  `ordermember_order_id` int(10) NOT NULL,
  `is_valid` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
  `tag_id` int(10) NOT NULL,
  `tag_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `banners`
--
ALTER TABLE `banners`
  ADD PRIMARY KEY (`banner_id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`),
  ADD KEY `FKmember430953` (`member_rolemember_role_id`);

--
-- Indexes for table `member_address`
--
ALTER TABLE `member_address`
  ADD PRIMARY KEY (`member_address_id`),
  ADD KEY `FKmember_add583444` (`membermember_id`);

--
-- Indexes for table `member_cart`
--
ALTER TABLE `member_cart`
  ADD PRIMARY KEY (`member_cart_id`),
  ADD KEY `FKmember_car677429` (`membermember_id`),
  ADD KEY `FKmember_car817685` (`productproduct_id`);

--
-- Indexes for table `member_role`
--
ALTER TABLE `member_role`
  ADD PRIMARY KEY (`member_role_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`member_order_id`),
  ADD KEY `FKorder612617` (`order_statusorder_status_id`),
  ADD KEY `FKorder770056` (`payment_methodpayment_method_id`);

--
-- Indexes for table `order_comment`
--
ALTER TABLE `order_comment`
  ADD PRIMARY KEY (`order_comment_id`),
  ADD KEY `FKorder_comm500181` (`ordermember_order_id`);

--
-- Indexes for table `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`member_item_order_id`),
  ADD KEY `FKorder_item713581` (`ordermember_order_id`);

--
-- Indexes for table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`order_status_id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`payment_method_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD UNIQUE KEY `product_code` (`product_code`),
  ADD KEY `FKproduct647818` (`product_categoryproduct_category_id`);

--
-- Indexes for table `product_category`
--
ALTER TABLE `product_category`
  ADD PRIMARY KEY (`product_category_id`);

--
-- Indexes for table `product_discount`
--
ALTER TABLE `product_discount`
  ADD PRIMARY KEY (`product_discount_id`),
  ADD KEY `FKproduct_di508430` (`productproduct_id`);

--
-- Indexes for table `product_image`
--
ALTER TABLE `product_image`
  ADD PRIMARY KEY (`product_image_id`),
  ADD KEY `FKproduct_im866868` (`productproduct_id`);

--
-- Indexes for table `product_review`
--
ALTER TABLE `product_review`
  ADD PRIMARY KEY (`product_review_id`),
  ADD KEY `FKproduct_re927640` (`productproduct_id`),
  ADD KEY `FKproduct_re212615` (`membermember_id`);

--
-- Indexes for table `product_tag`
--
ALTER TABLE `product_tag`
  ADD PRIMARY KEY (`product_tag_id`),
  ADD KEY `FKproduct_ta23552` (`productproduct_id`),
  ADD KEY `FKproduct_ta463212` (`tagtag_id`);

--
-- Indexes for table `proof_of_payment`
--
ALTER TABLE `proof_of_payment`
  ADD PRIMARY KEY (`proof_of_payment_id`),
  ADD KEY `FKproof_of_p197380` (`ordermember_order_id`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`tag_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `banners`
--
ALTER TABLE `banners`
  MODIFY `banner_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `member_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `member_address`
--
ALTER TABLE `member_address`
  MODIFY `member_address_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `member_cart`
--
ALTER TABLE `member_cart`
  MODIFY `member_cart_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `member_role`
--
ALTER TABLE `member_role`
  MODIFY `member_role_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `member_order_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `order_comment`
--
ALTER TABLE `order_comment`
  MODIFY `order_comment_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `order_item`
--
ALTER TABLE `order_item`
  MODIFY `member_item_order_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `payment_method_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `product_category`
--
ALTER TABLE `product_category`
  MODIFY `product_category_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `product_discount`
--
ALTER TABLE `product_discount`
  MODIFY `product_discount_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `product_image`
--
ALTER TABLE `product_image`
  MODIFY `product_image_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `product_review`
--
ALTER TABLE `product_review`
  MODIFY `product_review_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `proof_of_payment`
--
ALTER TABLE `proof_of_payment`
  MODIFY `proof_of_payment_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `tag_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `member_address`
--
ALTER TABLE `member_address`
  ADD CONSTRAINT `member` FOREIGN KEY (`membermember_id`) REFERENCES `member` (`member_id`);

--
-- Constraints for table `member_cart`
--
ALTER TABLE `member_cart`
  ADD CONSTRAINT `member_cart_ibfk_1` FOREIGN KEY (`membermember_id`) REFERENCES `member` (`member_id`),
  ADD CONSTRAINT `member_cart_ibfk_2` FOREIGN KEY (`productproduct_id`) REFERENCES `product` (`product_id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`payment_methodpayment_method_id`) REFERENCES `payment_method` (`payment_method_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_comment`
--
ALTER TABLE `order_comment`
  ADD CONSTRAINT `oerder` FOREIGN KEY (`ordermember_order_id`) REFERENCES `order` (`member_order_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `order` FOREIGN KEY (`ordermember_order_id`) REFERENCES `order` (`member_order_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product_discount`
--
ALTER TABLE `product_discount`
  ADD CONSTRAINT `product_discount_ibfk_1` FOREIGN KEY (`productproduct_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product_image`
--
ALTER TABLE `product_image`
  ADD CONSTRAINT `product_image_ibfk_1` FOREIGN KEY (`productproduct_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product_review`
--
ALTER TABLE `product_review`
  ADD CONSTRAINT `product_review_ibfk_1` FOREIGN KEY (`productproduct_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product_tag`
--
ALTER TABLE `product_tag`
  ADD CONSTRAINT `product` FOREIGN KEY (`productproduct_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `product_tag_ibfk_1` FOREIGN KEY (`tagtag_id`) REFERENCES `tag` (`tag_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `proof_of_payment`
--
ALTER TABLE `proof_of_payment`
  ADD CONSTRAINT `proof_of_payment_ibfk_1` FOREIGN KEY (`ordermember_order_id`) REFERENCES `order` (`member_order_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
