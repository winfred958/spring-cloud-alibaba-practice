CREATE TABLE account
(
    id               BIGINT(20),
    last_login_timestamp BIGINT(20),
    init_timestamp   BIGINT(20) COMMENT '数据初始化时间, 注册时间',
    update_timestamp BIGINT(20)
)