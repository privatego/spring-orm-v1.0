package javax.core.common;

import java.io.Serializable;

/**
 * @author: blessed
 * @Date: 2019/4/23
 */
public class ResultMsg<T> implements Serializable {

    private int status; //状态码
    private String msg; //状态码的解释
    private T data; //存放任意结果

    public ResultMsg() {
    }

    public ResultMsg(int status) {
        this.status = status;
    }

    public ResultMsg(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultMsg(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
