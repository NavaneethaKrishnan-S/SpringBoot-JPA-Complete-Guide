ALTER TABLE `store`.`users`
MODIFY `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
ADD CONSTRAINT unique_email UNIQUE (`email`);