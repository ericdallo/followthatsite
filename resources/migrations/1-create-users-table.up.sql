CREATE TABLE IF NOT EXISTS user (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(60) NOT null,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_user_name`(`name`)
);
