package com.winfred.dataworks.general;

public interface Constant {
    String DB_JDBC_URL = "jdbc:mysql://192.168.137.101:13306/test?useUnicode=true" +
            "&characterEncoding=utf-8&serverTimezone=UTC";
    String DB_USER_NAME = "root";
    String DB_USER_PASSWORD = "123456";
    String DB_DRIVER_NAME = "com.mysql.jdbc.Driver";
    String DB_SCHEMA_NAME = "test";

    /**
     * package 信息
     */
    String PACKAGE_PATH = "com.winfred";
    String SUB_PACKAGE_PATH = "test";

    String DEFAULT_PACKAGE_NAME_ENTITY = "entity";
    String DEFAULT_PACKAGE_NAME_MAPPER = "mapper";
    String DEFAULT_PACKAGE_NAME_XML = "mapper.xml";
    String DEFAULT_PACKAGE_NAME_SERVICE = "service";
    String DEFAULT_PACKAGE_NAME_SERVICE_IMPL = "service.impl";
    String DEFAULT_PACKAGE_NAME_CONTROLLER = "controller";
}
