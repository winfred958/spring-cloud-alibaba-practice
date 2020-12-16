package com.winfred.dataworks.general;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;

public class DatasourceConfigBuilder {

    private String jdbcUrl;
    private String userName;
    private String userPassword;
    private String jdbcDriverName;
    private String schemaName;

    public DataSourceConfig build() {
        return new DataSourceConfig()
                .setUrl(this.jdbcUrl)
                .setUsername(this.userName)
                .setPassword(this.userPassword)
                .setDriverName(this.jdbcDriverName)
                .setSchemaName(schemaName)
                .setDbType(DbType.MARIADB)
                .setDbQuery(new MySqlQuery())
                ;
    }

    public DatasourceConfigBuilder setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
        return this;
    }

    public DatasourceConfigBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public DatasourceConfigBuilder setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public DatasourceConfigBuilder setJdbcDriverName(String jdbcDriverName) {
        this.jdbcDriverName = jdbcDriverName;
        return this;
    }

    public DatasourceConfigBuilder setSchemaName(String schemaName) {
        this.schemaName = schemaName;
        return this;
    }
}
