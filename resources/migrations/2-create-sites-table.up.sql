CREATE TABLE IF NOT EXISTS site (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(60) NULL,
    `url` varchar(255) NOT NULL,
    `user_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_site_url`(`url`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);
