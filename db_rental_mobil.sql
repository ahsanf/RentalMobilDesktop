-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2020 at 09:37 AM
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
  `status` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mobil`
--

INSERT INTO `tb_mobil` (`id_mobil`, `nama_mobil`, `merek_mobil`, `bm_mobil`, `harga_rental`, `status`) VALUES
(2, 'Avanza', 'Daihatsu', 'xxx', 400000, 'READY'),
(5, 'veyron', 'Bugatti', 'xxx', 12222, 'READY'),
(6, 'Murcielago', 'Lamborghini', 'xxx', 2000, 'READY'),
(7, 'Kijang', 'Toyota', 'xxx', 200000, 'NOT READY');

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
(9, '14', 'sipach', 'Avanza', '2020-05-31', '2020-06-02', 2, 800000, 'KEMBALI');

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
(2, 'sipach', 'Sleman', '083840006400', '340440220223232', 'READY', 'apik123', 'user'),
(3, 'iqoh', 'tes', '03903234', '20392022', 'READY', '12345', 'user'),
(4, 'ahsan', 'goedena', '30403', '2032323', 'NOT READY', '12345', 'user'),
(5, 'hehe', 'hehe', '081201', '102102112', 'READY', 'hehe', 'user');

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
(15, 'ahsan', 'Kijang', 200000, '2020-05-30', 'SEWA', 'xxx');

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
  MODIFY `id_mobil` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian`
  MODIFY `id_pengembalian` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  MODIFY `id_penyewa` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_rental`
--
ALTER TABLE `tb_rental`
  MODIFY `id_rental` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
