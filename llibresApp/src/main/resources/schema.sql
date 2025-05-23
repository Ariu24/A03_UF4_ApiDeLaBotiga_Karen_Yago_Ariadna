CREATE DATABASE IF NOT EXISTS botiga;

USE botiga;

CREATE TABLE IF NOT EXISTS `categories` (
  `id_categoria` bigint(20) NOT NULL AUTO_INCREMENT,
  `desc_categoria` varchar(255) NOT NULL UNIQUE,
  `status_categoria` varchar(50) NOT NULL,
  `creation_at` datetime(6) NOT NULL,
  `updated_at` datetime(6),
  PRIMARY KEY (`id_categoria`)
);

CREATE TABLE IF NOT EXISTS `subcategoria` (
  `id_subcategoria` bigint(20) NOT NULL AUTO_INCREMENT,
  `desc_subcategoria` varchar(255) NOT NULL,
  `status_subcategoria` varchar(50) NOT NULL,
  `id_categoria` bigint(20) NOT NULL, 
  `creation_at` datetime(6) NOT NULL,
  `updated_at` datetime(6),
  PRIMARY KEY (`id_subcategoria`),
  CONSTRAINT `fk_subcategoria_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categories` (`id_categoria`) ON DELETE CASCADE 
);

CREATE TABLE IF NOT EXISTS `products` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  `description` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `units` bigint(20) NOT NULL,
  `id_categoria` bigint(20) NOT NULL, 
  `id_subcategoria` bigint(20) NOT NULL, 
  `creation_at` datetime(6) NOT NULL,
  `updated_at` datetime(6),
  PRIMARY KEY (`product_id`),
  CONSTRAINT `fk_product_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categories` (`id_categoria`) ON DELETE CASCADE,
  CONSTRAINT `fk_product_subcategoria` FOREIGN KEY (`id_subcategoria`) REFERENCES `subcategoria` (`id_subcategoria`) ON DELETE CASCADE
);