package com.dingdang.orm.framework;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: blessed
 * @Date: 2019/4/24
 */
public class EntityOperation<T> {

    public Class<T> entityClass = null;
    public final Map<String, PropertyMapping> mappings;
    public final RowMapper<T> rowMapper;

    public final String tableName;
    public String allColum = "*";
    public Field pkField;

    public EntityOperation(Class<T> clazz, String pk) throws Exception{
        if (!clazz.isAnnotationPresent(Entity.class)){
            throw new Exception("在" + clazz.getName() + "中没有找到Entity注解，不能做ORM映射");
        }
        this.entityClass = clazz;
        Table table = entityClass.getAnnotation(Table.class);

        if (table != null){
            this.tableName = table.name();
        }else {
            this.tableName = entityClass.getSimpleName();
        }
        Map<String, Method> getters = ClassMappings.findPublicGetters(entityClass);
        Map<String, Method> setters = ClassMappings.findPublicSetters(entityClass);
        Field[] fields = ClassMappings.findFields(entityClass);
        fillPkFieldAndAllColumn(pk, fields);
        this.mappings = getPropertyMappings(getters, setters, fields);
        this.allColum = this.mappings.keySet().toString()
                .replace("[", "").replace("]", "").replaceAll(" ", "");
        this.rowMapper = createRowMapper();
    }

    private RowMapper<T> createRowMapper() {
        return null;
    }

    private Map<String, PropertyMapping> getPropertyMappings(Map<String, Method> getters, Map<String, Method> setters, Field[] fields) {
        return null;
    }

    private void fillPkFieldAndAllColumn(String pk, Field[] fields) {

    }

}
