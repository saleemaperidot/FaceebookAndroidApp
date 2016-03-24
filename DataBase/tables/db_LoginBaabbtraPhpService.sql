-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 24, 2016 at 12:04 PM
-- Server version: 5.5.47-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_LoginBaabbtraPhpService`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE IF NOT EXISTS `tbl_login` (
  `pk_int_login_id` int(11) NOT NULL AUTO_INCREMENT,
  `vchr_usename` varchar(20) DEFAULT NULL,
  `vchr_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pk_int_login_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`pk_int_login_id`, `vchr_usename`, `vchr_password`) VALUES
(1, 'info', 'info123');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_register`
--

CREATE TABLE IF NOT EXISTS `tbl_register` (
  `pk_int_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `vchr_username` varchar(20) DEFAULT NULL,
  `vchr_firstname` varchar(20) DEFAULT NULL,
  `vchr_lastname` varchar(20) DEFAULT NULL,
  `vchr_password` varchar(20) DEFAULT NULL,
  `vchr_email` varchar(20) DEFAULT NULL,
  `vchr_gender` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pk_int_user_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `tbl_register`
--

INSERT INTO `tbl_register` (`pk_int_user_id`, `vchr_username`, `vchr_firstname`, `vchr_lastname`, `vchr_password`, `vchr_email`, `vchr_gender`) VALUES
(25, 'JijoAlexander', 'jijo', 'Alexander', '123456', 'jij@baabte.com', 'male'),
(26, 'JobinPeter', 'Jobin', 'Peter', '123456', 'jobin@baabte.com', 'male'),
(27, 'Athul', 'Athul', 'Babu', '123456', 'athul@baabte.com', 'male'),
(28, 'saleemanp', 'saleema', 'np', 'saleema123', 'saleeema@baabte.com', 'female'),
(29, '', '', '', '', '', 'male'),
(30, 'hhhttt', 'hhh', 'ttt', 'rrr', 'vvvv', 'male'),
(31, 'cf', 'chxux', 'fhf', 'ffyx', 'cyxg', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_relationship`
--

CREATE TABLE IF NOT EXISTS `tbl_relationship` (
  `fk_int_user_one_id` int(11) DEFAULT NULL,
  `fk_int_user_two_id` int(11) DEFAULT NULL,
  KEY `fk_int_user_one_id` (`fk_int_user_one_id`),
  KEY `fk_int_user_two_id` (`fk_int_user_two_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
