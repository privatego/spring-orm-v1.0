package javax.core.common.jdbc;

import com.dingdang.orm.framework.QueryRule;

import javax.core.common.Page;
import java.util.List;
import java.util.Map;

/**
 * @author: blessed
 * @Date: 2019/4/23
 */
public interface BaseDao<T, PK> {
    /**
     * 获取列表
     *
     * @param queryRule
     * @return
     * @throws Exception
     */
    List<T> select(QueryRule queryRule) throws Exception;

    /**
     * 获取分布结果
     *
     * @param queryRule
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    Page<?> select(QueryRule queryRule, int pageNo, int pageSize) throws Exception;

    /**
     * 获取分页结果
     *
     * @param sql
     * @param args
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> selectBySql(String sql, Object... args) throws Exception;

    /**
     * 根据sql获取页面
     * @param sql
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    Page<Map<String, Object>> selectBySqlToPage(String sql, Object[] param, int pageNo, int pageSize) throws Exception;

    /**
     * 删除一条
     * @param entity
     * @return
     * @throws Exception
     */
    boolean delete(T entity) throws Exception;

    /**
     * 批量删除
     * @param list
     * @return
     * @throws Exception
     */
    int deleteAll(List<T> list) throws Exception;


    /**
     * 插入一条记录并返回插入后的ID
     * @param entity
     * @return
     * @throws Exception
     */
    PK insertAndReturnId(T entity) throws Exception;

    /**
     * 插入一条记录自增ID
     * @param entity
     * @return
     * @throws Exception
     */
    boolean insert(T entity) throws Exception;

    /**
     * 批量插入
     * @param list
     * @return
     * @throws Exception
     */
    int insertAll(List<T> list) throws Exception;


    /**
     * 修改一条记录
     * @param entity
     * @return
     * @throws Exception
     */
    boolean update(T entity) throws Exception;

}
