CREATE DATABASE IF NOT EXISTS `user` CHARACTER SET 'utf8mb4';

CREATE TABLE IF NOT EXISTS `user`.`user_info`
(
    `id`               bigint                                                        NOT NULL AUTO_INCREMENT,
    `user_name`        varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
    `email`            varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'email',
    `password`         varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
    `is_active`        int(1)                                                        NOT NULL DEFAULT 0 COMMENT '是否激活, 0:未激活, 1:激活',
    `create_timestamp` bigint                                                        NOT NULL,
    `crate_datetime`   datetime                                                      NOT NULL COMMENT '创建时间(注册时间)',
    `update_timestamp` bigint                                                        NOT NULL,
    `update_datetime`  datetime                                                      NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uix_user_name` (`user_name`) USING BTREE,
    UNIQUE KEY `uix_email` (`email`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户信息';


CREATE TABLE IF NOT EXISTS `user`.`group_info`
(
    `id`               int                                                           NOT NULL AUTO_INCREMENT,
    `group_name`       varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
    `create_timestamp` bigint                                                        NOT NULL,
    `update_timestamp` bigint DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户组信息';


CREATE TABLE IF NOT EXISTS `user`.`user_group`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `user_id`          bigint NOT NULL COMMENT '',
    `group_id`         int    NOT NULL COMMENT '',
    `create_timestamp` bigint NOT NULL,
    `update_timestamp` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`) USING BTREE,
    KEY `idx_group_id` (`group_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户所属组关系';


CREATE TABLE IF NOT EXISTS `user`.`role_info`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `role_name`        int    NOT NULL COMMENT '',
    `create_timestamp` bigint NOT NULL,
    `update_timestamp` bigint DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色';

CREATE TABLE IF NOT EXISTS `user`.`group_role`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `group_id`         int    NOT NULL COMMENT '',
    `role_id`          int    NOT NULL COMMENT '',
    `create_timestamp` bigint NOT NULL,
    `update_timestamp` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_group_id` (`group_id`) USING BTREE,
    KEY `idx_role_id` (`role_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户所属组&角色关系';


CREATE TABLE IF NOT EXISTS `user`.`permission_info`
(
    `id`               int          NOT NULL AUTO_INCREMENT,
    `permission_name`  varchar(128) NOT NULL COMMENT '权限名称',
    `path`             varchar(128) NOT NULL COMMENT '服务(模块)路径',
    `patent_id`        int    DEFAULT NULL COMMENT '父路径id',
    `create_timestamp` bigint       NOT NULL,
    `update_timestamp` bigint DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='权限信息';

CREATE TABLE IF NOT EXISTS `user`.`role_permission`
(
    `id`                  bigint NOT NULL AUTO_INCREMENT,
    `role_id`             int    NOT NULL COMMENT '角色id',
    `permission_id`       int    NOT NULL COMMENT '权限id',
    `permission_strategy` int(1) NOT NULL DEFAULT 1 COMMENT '权限策略 0: allow, 1: reject',
    `create_timestamp`    bigint NOT NULL,
    `update_timestamp`    bigint          DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_role_id` (`role_id`) USING BTREE,
    KEY `idx_permission_id` (`permission_id`) USING BTREE,
    KEY `idx_permission_strategy` (`permission_strategy`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色&权限关系';
