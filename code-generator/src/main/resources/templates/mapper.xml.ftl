<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

</#if>
<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
<#list table.fields as field>
<#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}"/>
</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
        <result column="${field.name}" property="${field.propertyName}"/>
</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}"/>
</#if>
</#list>
    </resultMap>

</#if>
<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
<#list table.commonFields as field>
        ${field.columnName},
</#list>
        ${table.fieldNames}
    </sql>

</#if>
    <select id="queryByEntity" resultMap="BaseResultMap" parameterType="java.lang.Object">
        SELECT
        <#list table.fields as field>
            <#if field_index == 0>
        `${field.columnName}`
            <#else>
        ,`${field.columnName}`
            </#if>
        </#list>
        FROM `${table.name}`
        <where>
            <#list table.fields as field>
            <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                AND `${field.columnName}` = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
            </#list>
        </where>
    </select>

    <insert id="save" parameterType="${package.Entity}.${entity}">
        INSERT INTO `${table.name}`
        (
        <#list table.fields as field>
            <#if field_index == 0>
        `${field.columnName}`
            <#else>
        ,`${field.columnName}`
            </#if>
        </#list>
        ) VALUES
        (
        <#list table.fields as field>
            <#if field_index == 0>
        <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            <#else>
        <#noparse>,#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </#if>
        </#list>
        )
    </insert>

    <insert id="bulkUpsert" parameterType="java.util.List">
        INSERT INTO `${table.name}`
        (
        <#list table.fields as field>
            <#if field_index == 0>
        ${field.columnName}
            <#else>
        ,${field.columnName}
            </#if>
        </#list>
        )
        VALUES
        <foreach collection="items" index="index" item="item" separator=",">
            (
            <#list table.fields as field>
                 <#if field_index == 0>
            <#noparse>#{item.</#noparse>${field.propertyName}<#noparse>}</#noparse>
                 <#else>
            <#noparse>,#{item.</#noparse>${field.propertyName}<#noparse>}</#noparse>
                </#if>
            </#list>
            )
        </foreach>
        ON DUPLICATE KEY UPDATE
        <#list table.fields as field>
            <#if field.keyFlag>
        ${field.name} = VALUES(${field.name})
            </#if>
        </#list>
    </insert>
</mapper>
