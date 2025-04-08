CREATE TABLE `products` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `creation_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `subcategory` varchar(255) DEFAULT NULL,
  `units` bigint(20) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
);

CREATE TABLE IF NOT EXISTS category (
    id_Categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    desc_Categoria VARCHAR(255) NOT NULL,
    status_Categoria VARCHAR(50) NOT NULL,
    creation_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);