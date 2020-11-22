CREATE DATABASE IF NOT EXISTS `im_item` CHARACTER SET 'utf8mb4';


CREATE TABLE IF NOT EXISTS `im_item`.`item_info`
(
    `id`               bigint(20)  NOT NULL AUTO_INCREMENT,
    `item_sn`          varchar(24) NOT NULL COMMENT '商品编号',
    `item_status`      int(3)      NOT NULL DEFAULT 1 COMMENT '商品状态, 1: 商家, 2: 下架',
    `category_id`      int(11)     NOT NULL COMMENT '商品所属分类',
    `brand_id`         int(11)     NOT NULL COMMENT '商品所属品牌',
    `agency_id`        int(11)     NOT NULL COMMENT '经销商id',
    `update_user`      varchar(64)          DEFAULT NULL COMMENT '编辑人',
    `create_timestamp` bigint(13)  NOT NULL,
    `update_timestamp` bigint(13)  NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
    COMMENT '商品表'
;

CREATE TABLE IF NOT EXISTS `im_item`.`item_description`
(
    `id`                  bigint(20)  NOT NULL AUTO_INCREMENT,
    `item_sn`             varchar(24) NOT NULL COMMENT '商品编号',
    `item_short_describe` int(3)      NOT NULL DEFAULT 1 COMMENT '商品状态',
    `item_describe`       int(11)     NOT NULL COMMENT '商品所属分类',
    `item_picture`        varchar(255) COMMENT '商品主图',
    `update_user`         varchar(64)          DEFAULT NULL COMMENT '编辑人',
    `create_timestamp`    bigint(13)  NOT NULL,
    `update_timestamp`    bigint(13)  NULL,
    PRIMARY KEY (`id`)
)
    COMMENT '商品描述信息'
;

CREATE TABLE IF NOT EXISTS `im_item`.`item_category`
(
    `id`               int(11)      NOT NULL AUTO_INCREMENT,
    `category_name`    varchar(128) NOT NULL COMMENT '商品分类名称',
    `level`            int(1)       NOT NULL COMMENT '几级分类',
    `parent_id`        int(11) DEFAULT NULL,
    `create_timestamp` bigint(13)   NOT NULL,
    `update_timestamp` bigint(13)   NULL,
    PRIMARY KEY (`id`)
)
    COMMENT '商品分类'
;

CREATE TABLE IF NOT EXISTS `im_item`.`item_brand`
(
    id int
)
    COMMENT '商品品牌'
;

CREATE TABLE IF NOT EXISTS `im_item`.`item_agency`
(
    id int
)
    COMMENT '商家'
;
