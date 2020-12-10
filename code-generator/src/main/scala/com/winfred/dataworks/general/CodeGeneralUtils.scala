package com.winfred.dataworks.general


import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
import com.baomidou.mybatisplus.generator.config.{GlobalConfig, StrategyConfig, TemplateConfig}

object CodeGeneralUtils {

  def getGlobalConfig(moduleName: String, dir: String = "src/marin/java"): GlobalConfig = {
    val globalConfig = new GlobalConfig()
    globalConfig
      .setOutputDir(s"${System.getProperty("user.dir")}/${moduleName}/${dir}")
      .setAuthor("winfred958")
      .setOpen(false)
      .setFileOverride(true)
      .setEnableCache(true)
      .setSwagger2(true)
      .setEntityName("%sEntity")
      .setMapperName("%sDao")
      .setXmlName("%sMapper")
      .setServiceName("%sService")
      .setServiceImplName("%sServiceImpl")
      .setIdType(IdType.NONE)
      .setBaseColumnList(false)
      .setBaseResultMap(true)

  }

  def getStrategyConfig: StrategyConfig = {
    val strategyConfig = new StrategyConfig()
    strategyConfig
      .setNaming(NamingStrategy.underline_to_camel)
      .setEntityLombokModel(true)
      .setSkipView(true)
      .setColumnNaming(NamingStrategy.underline_to_camel)

  }

  def getTemplateConfig: TemplateConfig = {
    val templateConfig = new TemplateConfig()
    templateConfig.setXml(s"/templates/mapper.xml")
  }
}
