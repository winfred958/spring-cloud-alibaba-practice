CREATE TABLE account
(
    id               BIGINT(20) AUTO_INCREMENT,
    email            VARCHAR(255),
    phone_number     VARCHAR(255),
    password_hash    VARCHAR(255),
    name             VARCHAR(255),
    active_status    INT,
    active_timestamp BIGINT(20) COMMENT '账号激活时间',
    init_timestamp   BIGINT(20) COMMENT '数据初始化时间, 注册时间',
    update_timestamp BIGINT(20)
)