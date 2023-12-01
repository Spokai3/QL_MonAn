-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.17-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for nhakho
CREATE DATABASE IF NOT EXISTS `nhakho` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `nhakho`;

-- Dumping structure for table nhakho.nuocuong
CREATE TABLE IF NOT EXISTS `nuocuong` (
  `maNuoc` int(11) NOT NULL,
  `tenNuoc` varchar(50) NOT NULL DEFAULT '',
  `loai` varchar(50) NOT NULL DEFAULT '',
  `giaBan` double NOT NULL DEFAULT 0,
  `soLuong` int(11) NOT NULL DEFAULT 0,
  `ngayNhap` date NOT NULL,
  PRIMARY KEY (`maNuoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table nhakho.nuocuong: ~3 rows (approximately)
INSERT INTO `nuocuong` (`maNuoc`, `tenNuoc`, `loai`, `giaBan`, `soLuong`, `ngayNhap`) VALUES
	(1, 'Pepsi', 'Lon', 12000, 12, '2023-11-30'),
	(2, 'Coca', 'Chai', 12000, 12, '2023-11-30'),
	(3, 'Sprite', 'Chai', 15000, 10, '2023-11-30'),
	(4, 'Monster', 'Lon', 35000, 20, '2023-12-01');

-- Dumping structure for table nhakho.sanpham
CREATE TABLE IF NOT EXISTS `sanpham` (
  `maMonAn` int(11) NOT NULL AUTO_INCREMENT,
  `tenMonAn` varchar(50) NOT NULL,
  `loaiMonAn` varchar(50) NOT NULL,
  `nguyenLieu` varchar(50) NOT NULL,
  `giaBan` double NOT NULL DEFAULT 0,
  `soLuong` int(11) NOT NULL,
  `ngayNhap` date NOT NULL,
  PRIMARY KEY (`maMonAn`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table nhakho.sanpham: ~3 rows (approximately)
INSERT INTO `sanpham` (`maMonAn`, `tenMonAn`, `loaiMonAn`, `nguyenLieu`, `giaBan`, `soLuong`, `ngayNhap`) VALUES
	(1, 'Heo quay kho trứng', 'Kho', 'Heo', 75000, 2, '2023-11-24'),
	(2, 'Bún bò Huế', 'Nước', 'Bò', 35000, 1, '2023-11-24'),
	(5, 'Bún Riêu', 'Nước', 'Bò', 35000, 1, '2023-11-24');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
