CREATE DATABASE IF NOT EXISTS `user` CHARACTER SET 'utf8mb4';

CREATE TABLE IF NOT EXISTS `user`.`user_address`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT,
    `user_id`          varchar(128) NOT NULL COMMENT '用户名',
    `email`            varchar(128) NOT NULL COMMENT 'email',
    `password`         varchar(128) NOT NULL COMMENT '密码',
    `is_active`        int(1)       NOT NULL DEFAULT 0 COMMENT '是否激活, 0:未激活, 1:激活',
    `create_timestamp` bigint       NOT NULL COMMENT '写入(注册)时间',
    `active_timestamp` bigint                DEFAULT 0 COMMENT '激活时间',
    `update_timestamp` bigint                DEFAULT 0 COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uix_user_id` (`user_id`) USING BTREE,
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户信息';
