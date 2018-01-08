-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-01-2017 a las 06:16:03
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdturismo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alojamiento`
--

CREATE TABLE IF NOT EXISTS `alojamiento` (
  `cliente` varchar(20) NOT NULL,
  `dni` int(8) NOT NULL,
  `telefono` int(12) NOT NULL,
  `num_habitacion` int(6) NOT NULL,
  `tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alojamiento`
--

INSERT INTO `alojamiento` (`cliente`, `dni`, `telefono`, `num_habitacion`, `tipo`) VALUES
('more', 123456, 12345678, 2, ''),
('Melisa', 12345678, 12345, 1, '1'),
('lucho', 12345678, 0, 1, '1'),
('katy', 1235678, 0, 1, 'Doble');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva1`
--

CREATE TABLE IF NOT EXISTS `reserva1` (
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `dni` int(8) NOT NULL,
  `fechainio` varchar(12) NOT NULL,
  `fechafin` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva1`
--

INSERT INTO `reserva1` (`nombre`, `apellido`, `dni`, `fechainio`, `fechafin`) VALUES
(' adam', 'ccoyllo', 123456, 'dd/MM/yyyy', 'dd/MM/yyyy');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
