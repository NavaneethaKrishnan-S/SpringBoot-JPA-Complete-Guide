CREATE TABLE `store`.`categories`
(
  `id` TINYINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `store`.`products`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `category_id` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_category_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `store`.`categories` (`id`)
    ON DELETE RESTRICT
);
