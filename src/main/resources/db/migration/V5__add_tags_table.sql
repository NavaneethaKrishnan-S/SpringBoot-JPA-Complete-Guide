CREATE TABLE `store`.`tags` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `store`.`user_tags` (
  `user_id` BIGINT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `tag_id`),
  CONSTRAINT `users_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `store`.`users` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `tags_fk`
    FOREIGN KEY (`tag_id`)
    REFERENCES `store`.`tags` (`id`)
    ON DELETE CASCADE);


