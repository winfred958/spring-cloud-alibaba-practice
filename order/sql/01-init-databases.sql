CREATE DATABASE IF NOT EXISTS `ec_order` CHARACTER SET 'utf8mb4';


CREATE TABLE IF NOT EXISTS `ec_order`.`order_info`
(
    `id`               bigint                                                       NOT NULL AUTO_INCREMENT,
    `order_sn`         varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单编号',
    `user_id`          int                                                          NOT NULL COMMENT '用户id',
    `order_status`     int                                                          NOT NULL DEFAULT '1' COMMENT '订单状态',
    `order_amount`     double(18, 2)                                                NOT NULL COMMENT '订单金额',
    `create_timestamp` bigint                                                       NOT NULL,
    `crate_datetime`   datetime                                                     NOT NULL COMMENT '订单创建时间',
    `update_timestamp` bigint                                                       NOT NULL,
    `update_datetime`  datetime                                                     NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uix_order_sn` (`order_sn`) USING BTREE,
    KEY `idx_order_status` (`order_status`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='订单表';


# CREATE TABLE IF NOT EXISTS `ec_order`.`order_item`
# (
#     id int
# )
# ;
#
# CREATE TABLE IF NOT EXISTS `ec_order`.`order_shipping`
# (
#     id int
# )
# ;
