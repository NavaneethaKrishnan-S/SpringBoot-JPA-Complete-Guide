CREATE TABLE `store`.`profiles` (
  `id` BIGINT NOT NULL,
  `bio` TEXT NULL,
  `phone_number` VARCHAR(15) NULL,
  `date_of_birth` DATE NULL,
  `loyalty_points` INT UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `users__fk`
    FOREIGN KEY (`id`)
    REFERENCES `store`.`users` (`id`)
);