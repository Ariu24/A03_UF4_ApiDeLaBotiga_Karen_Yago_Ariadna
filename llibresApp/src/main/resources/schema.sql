CREATE TABLE `categories` (
  `id_categoria` bigint(20) NOT NULL AUTO_INCREMENT,
  `desc_categoria` varchar(255) DEFAULT NULL,
  `status_categoria` varchar(50) DEFAULT NULL,
  `creation_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
);

CREATE TABLE `subcategories` (
  `id_subcategoria` bigint(20) NOT NULL AUTO_INCREMENT,
  `desc_subcategoria` varchar(255) DEFAULT NULL,
  `status_subcategoria` varchar(50) DEFAULT NULL,
  `categoria_id` bigint(20) NOT NULL,
  `creation_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id_subcategoria`),
  CONSTRAINT `fk_subcategoria_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categories` (`id_categoria`) ON DELETE CASCADE
);

CREATE TABLE `products` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `units` bigint(20) DEFAULT NULL,
  `categoria_id` bigint(20) NOT NULL,
  `subcategoria_id` bigint(20) NOT NULL,
  `creation_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `fk_product_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categories` (`id_categoria`) ON DELETE CASCADE,
  CONSTRAINT `fk_product_subcategoria` FOREIGN KEY (`subcategoria_id`) REFERENCES `subcategories` (`id_subcategoria`) ON DELETE CASCADE
);
