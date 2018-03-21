CREATE TABLE IF NOT EXISTS user (
    `id` bigint(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(30) NOT NULL,
    `password` varchar(30) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_user_name`(`name`)
);
