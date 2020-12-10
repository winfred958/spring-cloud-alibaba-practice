package com.winfred.dataworks.general;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeGeneral {
    
    public static void main(String[] args) {
    
        String MODULE_NAME = "code-generator";
        String OUTPUT_DIR = "src/main/java";
        
        AutoGenerator generator = new AutoGenerator();
        
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        
        
        generator.setGlobalConfig(CodeGeneralUtils.getGlobalConfig(MODULE_NAME, OUTPUT_DIR));
        
        PackageConfig packageConfig = getPackageConfig();
        generator.setPackageInfo(packageConfig);
        
        DataSourceConfig datasourceConfig = getDataSourceConfig();
        
        generator.setDataSource(datasourceConfig);
        
        generator.setStrategy(CodeGeneralUtils.getStrategyConfig());
        
        generator.setTemplate(CodeGeneralUtils.getTemplateConfig());
        
        generator.execute();
    }
    
    /**
     * @return {@link DataSourceConfig}
     */
    private static DataSourceConfig getDataSourceConfig() {
        return new DatasourceConfigBuilder()
                .setJdbcUrl(Constant.DB_JDBC_URL)
                .setUserName(Constant.DB_USER_NAME)
                .setUserPassword(Constant.DB_USER_PASSWORD)
                .setJdbcDriverName(Constant.DB_DRIVER_NAME)
                .setSchemaName(Constant.DB_SCHEMA_NAME)
                .build();
    }
    
    /**
     * package config
     *
     * @return {@link PackageConfig}
     */
    private static PackageConfig getPackageConfig() {
        
        return new PackageConfig()
                .setParent(Constant.PACKAGE_PATH)
                .setModuleName(Constant.SUB_PACKAGE_PATH)
                .setService(Constant.DEFAULT_PACKAGE_NAME_SERVICE)
                .setServiceImpl(Constant.DEFAULT_PACKAGE_NAME_SERVICE_IMPL)
                .setController(Constant.DEFAULT_PACKAGE_NAME_CONTROLLER)
                .setEntity(Constant.DEFAULT_PACKAGE_NAME_ENTITY);
        
    }
}
