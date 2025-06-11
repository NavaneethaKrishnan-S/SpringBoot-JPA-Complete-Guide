CREATE TABLE `store`.`wishlist` (
  `user_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `product_id`),
  CONSTRAINT `wishlist_users_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `store`.`users` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `wishlist_products_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `store`.`products` (`id`)
    ON DELETE CASCADE);