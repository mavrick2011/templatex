-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 11. Mai 2011 um 13:49
-- Server Version: 5.1.44
-- PHP-Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `SEWM`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Categories`
--

CREATE TABLE IF NOT EXISTS `Categories` (
  `categoryid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Daten für Tabelle `Categories`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Personaldates`
--

CREATE TABLE IF NOT EXISTS `Personaldates` (
  `personalid` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(50) NOT NULL,
  `degree` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `streetno` int(10) NOT NULL,
  `zipcode` int(10) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `bankaccount` int(30) NOT NULL,
  `uid` varchar(30) NOT NULL,
  `telephone` int(50) NOT NULL,
  `fax` int(50) DEFAULT NULL,
  PRIMARY KEY (`personalid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Daten für Tabelle `Personaldates`
--

INSERT INTO `Personaldates` (`personalid`, `company`, `degree`, `name`, `surname`, `street`, `streetno`, `zipcode`, `city`, `country`, `email`, `bankaccount`, `uid`, `telephone`, `fax`) VALUES
(1, 'RHI AG', 'Mag.', 'Susanne', 'Steiner', 'Magnesitstraße', 2, 8700, 'Leoben', 'Austria', 'susanne.hofer@rhi-ag.com', 783029837, 'ATU14187609', 502135200, 502135899),
(2, 'Magna Steyr', 'Dr.', 'Kurt', 'Hofer', 'Liebenauerhauptstraße', 317, 8045, 'Graz', 'Austria', 'k.steiner@magna.at', 890983909, 'ATU12390749', 3167890, 31678903),
(3, 'Andritz AG', 'Dipl.-Ing.', 'Anton', 'Müller', 'Statteggerstraße', 18, 8045, 'Graz', 'Austria', 'anton.mueller@andritz-ag.com', 38908294, 'ATU16573849', 31645890, 316458900),
(4, 'Bürobox GmbH', '', 'Marianne', 'Heidenbauer', 'Brückengasse', 2, 8600, 'Bruck/Mur', 'Austria', 'm.heidenbauer@buerobox.at', 789030291, 'ATU783920981', 386256234, 2147483647),
(5, 'SportingHAK', 'Bakk.', 'Elisabeth', 'Nicht', 'Leopersdorf', 29, 8643, 'Allerheiligen', 'Austria', 'elisabeth.nicht@sporting.com', 2147483647, 'ATU23758291', 38652247, 386522479);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Templates`
--

CREATE TABLE IF NOT EXISTS `Templates` (
  `category` varchar(20) NOT NULL,
  `permissionid` int(10) NOT NULL,
  `filename` varchar(20) NOT NULL,
  `file` longtext NOT NULL,
  PRIMARY KEY (`filename`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Templates`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `password` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `userid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Permission` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Daten für Tabelle `Users`
--

INSERT INTO `Users` (`password`, `username`, `userid`, `Permission`) VALUES
('leitgeb', 'mleitgeb', 1, 'user'),
('lukas', 'slukas', 2, 'user'),
('hatbauer', 'lhatbauer', 3, 'user'),
('harb', 'eharb', 4, 'user'),
('anderhuber', 'tanderhuber', 5, 'user'),
('schwelberger', 'mschwelberger', 6, 'user'),
('strasser', 'mstrasser', 7, 'admin'),
('punz', 'apunz', 8, 'user'),
('reeh', 'lreeh', 9, 'admin'),
('lecaks', 'lecaks', 10, 'user'),
('stock', 'tstock', 11, 'admin');
