package javax.core.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: blessed
 * @Date: 2019/4/23
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_PAGE_SIZE = 20;

    private int pageSize = DEFAULT_PAGE_SIZE;//每页的记录数

    private long start;//当前页第一条记录在List中的们位置，从0开始

    private List<T> rows;//当前页中存放的记录

    private long total;//总记录数

    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>());
    }

    public Page(int pageSize, long start, long total, List<T> rows) {
        this.pageSize = pageSize;
        this.start = start;
        this.total = total;
        this.rows = rows;
    }

    public boolean hasNextPage(){
        return this.getPageNo() < this.getTotalPageCount() - 1;
    }

    private long getTotalPageCount() {
        if (total % pageSize == 0){
            return total / pageSize;
        }else {
            return total / pageSize + 1;
        }
    }

    public long getPageNo(){
        return start / pageSize + 1;
    }

    public boolean hasPreviousPage(){
        return this.getPageNo() > 1;
    }

    protected static int getStartOfPage(int pageNo){
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    private static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
