package com.dingdang.orm.framework;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 抽象类里面可以写一些默认的功能
 * 但是不能被实例化，被实例化之前必须给我把动态参数配置好
 * 通过子类继承父类，然后new子类，就会先new，子类把配置信息传送父类
 */
public abstract class BaseDaoSupport<T extends Serializable, PK extends Serializable> {

    protected abstract void setDataSource(DataSource dataSource);

    public List<T> select(QueryRule queryRule){
        QueryRuleSqlBuilder builder = new QueryRuleSqlBuilder(queryRule);
        builder.getWhereSql();
        builder.getOrderSql();
        builder.getValues();

        return null;
    }

    public List<Map<String, Object>> selectBySql(String sql, Object ...args){


        return null;
    }


}
