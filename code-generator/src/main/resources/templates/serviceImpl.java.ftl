package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
<#--public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {-->

<#--}-->
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} dao;

    @Override
    public List<#noparse><</#noparse>${entity}<#noparse>></#noparse> queryByEntity(${entity} entity) {
        return dao.queryByEntity(entity);
    }

    @Override
    public Integer save(${entity} entity) {
        return dao.save(entity);
    }

    @Override
    public Integer bulkUpsert(List<#noparse><? extends</#noparse> ${entity}<#noparse>></#noparse> list) {
        return dao.bulkUpsert(list);
    }
}
</#if>
