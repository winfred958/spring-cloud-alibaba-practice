package ${package.Mapper};

import ${package.Entity}.${entity};
<#--import ${superMapperClassPackage};-->
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
<#--public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {-->

<#--}-->

@Mapper
public interface ${table.mapperName} {

    List<${entity}> queryByEntity(${entity} entity);

    Integer save(${entity} entity);

    Integer bulkUpsert(@Param(value = "items") List<#noparse><? extends</#noparse> ${entity}<#noparse>></#noparse> list);
}
</#if>
