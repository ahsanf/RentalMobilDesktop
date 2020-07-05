-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2020 at 08:35 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rental_mobil`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_mobil`
--

CREATE TABLE `tb_mobil` (
  `id_mobil` int(1) NOT NULL,
  `nama_mobil` varchar(15) DEFAULT NULL,
  `merek_mobil` varchar(15) DEFAULT NULL,
  `bm_mobil` varchar(11) DEFAULT NULL,
  `harga_rental` bigint(7) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `stok` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mobil`
--

INSERT INTO `tb_mobil` (`id_mobil`, `nama_mobil`, `merek_mobil`, `bm_mobil`, `harga_rental`, `status`, `stok`) VALUES
(2, 'Avanza', 'Daihatsu', 'xxx', 400000, 'NOT READY', 0),
(5, 'veyron', 'Bugatti', 'xxx', 12222, 'NOT READY', 0),
(6, 'Murcielago', 'Lamborghini', 'xxx', 2000, 'NOT READY', 0),
(8, 'Kijang', 'Toyota', 'xxx', 400000, 'NOT READY', 0),
(9, 'Lamborghini', 'ladmas', 'xxxxx', 20000, 'NOT READY', 0),
(10, 'nama', 'toyota', 'xxx', 20000, 'NOT READY', 0),
(11, 'nama2', 'toyota ', 'xxxx', 10000, 'NOT READY', 0),
(12, 'nama3', 'nama3', 'xxxx', 20000, 'READY', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian`
--

CREATE TABLE `tb_pengembalian` (
  `id_pengembalian` int(1) NOT NULL,
  `id_rental` varchar(4) DEFAULT NULL,
  `penyewa` varchar(20) DEFAULT NULL,
  `mobil` varchar(11) DEFAULT NULL,
  `tgl_rental` date DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `lama` bigint(3) DEFAULT NULL,
  `total_bayar` bigint(8) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pengembalian`
--

INSERT INTO `tb_pengembalian` (`id_pengembalian`, `id_rental`, `penyewa`, `mobil`, `tgl_rental`, `tgl_kembali`, `lama`, `total_bayar`, `status`) VALUES
(7, '12', 'sipach', 'Murcielago', '2020-05-29', '2020-05-30', 1, 2000, 'KEMBALI'),
(8, '13', 'iqoh', 'Avanza', '2020-05-29', '2020-05-30', 1, 400000, 'KEMBALI'),
(9, '14', 'sipach', 'Avanza', '2020-05-31', '2020-06-02', 2, 800000, 'KEMBALI'),
(10, '17', 'sipach', 'veyron', '2020-06-23', '2020-06-24', 1, 12222, 'KEMBALI'),
(11, '18', 'sipach', 'veyron', '2020-06-22', '2020-06-23', 1, 12222, 'KEMBALI'),
(12, '15', 'ahsan', 'Kijang', '2020-05-30', '2020-06-23', 24, 4800000, 'KEMBALI'),
(13, '16', 'sipach', 'Avanza', '2020-06-22', '2020-06-24', 2, 800000, 'KEMBALI'),
(14, '20', 'mikel', 'Kijang', '2020-07-04', '2020-07-06', 2, 800000, 'KEMBALI'),
(15, '41', 'iqoh', 'nama', '2020-07-10', '2020-07-14', 4, 80000, 'KEMBALI');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penyewa`
--

CREATE TABLE `tb_penyewa` (
  `id_penyewa` int(1) NOT NULL,
  `nama_penyewa` varchar(20) DEFAULT NULL,
  `alamat` varchar(20) DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  `no_ktp` varchar(30) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `password` varchar(8) NOT NULL,
  `level` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penyewa`
--

INSERT INTO `tb_penyewa` (`id_penyewa`, `nama_penyewa`, `alamat`, `no_hp`, `no_ktp`, `status`, `password`, `level`) VALUES
(1, 'admin', 'asdas', 'admin', 'admin', 'NOT READY', '12345', 'admin'),
(2, 'sipach', 'Sleman', '083840006400', '340440220223232', 'NOT READY', 'apik123', 'user'),
(3, 'iqoh', 'tes', '03903234', '20392022', 'READY', '12345', 'user'),
(4, 'ahsan', 'goedena', '30403', '2032323', 'NOT READY', '12345', 'user'),
(5, 'hehe', 'hehe', '081201', '102102112', 'READY', 'hehe', 'user'),
(6, 'mikel', 'uny', '99999', '31212112', 'NOT READY', '12345', 'user'),
(7, 'danang', 'berbah', '082018218', '3004403', 'READY', '12345', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `tb_rental`
--

CREATE TABLE `tb_rental` (
  `id_rental` int(1) NOT NULL,
  `nama_penyewa` varchar(25) DEFAULT NULL,
  `nama_mobil` varchar(20) DEFAULT NULL,
  `harga_rental` bigint(20) DEFAULT NULL,
  `tgl_rental` date DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `bm_mobil` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_rental`
--

INSERT INTO `tb_rental` (`id_rental`, `nama_penyewa`, `nama_mobil`, `harga_rental`, `tgl_rental`, `status`, `bm_mobil`) VALUES
(12, 'sipach', 'Murcielago', 2000, '2020-05-29', 'SELESAI', 'xxx'),
(13, 'iqoh', 'Avanza', 400000, '2020-05-29', 'SELESAI', 'xxx'),
(14, 'sipach', 'Avanza', 400000, '2020-05-31', 'SELESAI', 'xxx'),
(15, 'ahsan', 'Kijang', 200000, '2020-05-30', 'SELESAI', 'xxx'),
(16, 'sipach', 'Avanza', 400000, '2020-06-22', 'SELESAI', 'xxx'),
(17, 'sipach', 'veyron', 12222, '2020-06-23', 'SELESAI', 'xxx'),
(18, 'sipach', 'veyron', 12222, '2020-06-22', 'SELESAI', 'xxx'),
(19, 'sipach', 'veyron', 12222, '2020-06-22', 'SEWA', 'xxx'),
(20, 'mikel', 'Kijang', 400000, '2020-07-04', 'SELESAI', 'xxx'),
(21, 'mikel', 'Avanza', 400000, '2020-07-11', 'SEWA', 'xxx'),
(22, 'iqoh', 'Lamborghini', 20000, '2020-07-17', 'SEWA', 'xxxxx'),
(23, 'iqoh', 'Lamborghini', 20000, '2020-07-11', 'SEWA', 'xxxxx'),
(24, 'ahsan', 'Lamborghini', 20000, '2020-07-04', 'SEWA', 'xxxxx'),
(25, 'ahsan', 'Lamborghini', 20000, '2020-07-17', 'SEWA', 'xxxxx'),
(26, 'danang', 'Lamborghini', 20000, '2020-07-10', 'SEWA', 'xxxxx'),
(27, 'ahsan', 'Lamborghini', 20000, '2020-07-10', 'SEWA', 'xxxxx'),
(28, 'hehe', 'Lamborghini', 20000, '2020-07-17', 'SEWA', 'xxxxx'),
(29, 'iqoh', 'Kijang', 400000, '2020-07-04', 'SEWA', 'xxx'),
(30, 'hehe', 'Kijang', 400000, '2020-07-10', 'SEWA', 'xxx'),
(31, 'hehe', 'Kijang', 400000, '2020-07-10', 'SEWA', 'xxx'),
(32, 'iqoh', 'Kijang', 400000, '2020-07-10', 'SEWA', 'xxx'),
(33, 'hehe', 'Kijang', 400000, '2020-07-10', 'SEWA', 'xxx'),
(34, 'iqoh', 'Kijang', 400000, '2020-07-10', 'SEWA', 'xxx'),
(35, 'iqoh', 'Kijang', 400000, '2020-07-10', 'SEWA', 'xxx'),
(36, 'hehe', 'nama', 20000, '2020-07-02', 'SEWA', 'xxx'),
(37, 'danang', 'nama', 20000, '2020-07-04', 'SEWA', 'xxx'),
(38, 'hehe', 'nama2', 10000, '2020-07-10', 'SEWA', 'xxxx'),
(39, 'iqoh', 'nama2', 10000, '2020-07-03', 'SEWA', 'xxxx'),
(40, 'iqoh', 'nama', 20000, '2020-07-09', 'SEWA', 'xxx'),
(41, 'iqoh', 'nama', 20000, '2020-07-10', 'SELESAI', 'xxx');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_mobil`
--
ALTER TABLE `tb_mobil`
  ADD PRIMARY KEY (`id_mobil`);

--
-- Indexes for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `id_rental` (`id_rental`),
  ADD KEY `id_penyewa` (`penyewa`,`mobil`);

--
-- Indexes for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  ADD PRIMARY KEY (`id_penyewa`);

--
-- Indexes for table `tb_rental`
--
ALTER TABLE `tb_rental`
  ADD PRIMARY KEY (`id_rental`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_mobil`
--
ALTER TABLE `tb_mobil`
  MODIFY `id_mobil` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian`
  MODIFY `id_pengembalian` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  MODIFY `id_penyewa` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tb_rental`
--
ALTER TABLE `tb_rental`
  MODIFY `id_rental` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
