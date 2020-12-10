package ${package.Mapper};

import ${package.Entity}.${entity};
<#--import ${superMapperClassPackage};-->
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

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

   Integer insert(${entity} entity);
}
</#if>
