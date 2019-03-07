package com.liuqi.springboot.recruit.util;

import java.io.Serializable;

/**
 * 定义一个统一返回响应结构体
 * @param <T>
 */
public class ResponseEntity<T> implements Serializable {

    /**
     * 操作失败
     */
    public static final String FAIL = "2";

    /**
     * 操作成功
     */
    public static final String SUCCESS = "1";

    /**
     * 特指token失效错误
     */
    public static final String ERROR = "0";

    private T data ;

    private String msg;

    private String code;

    public ResponseEntity(T data, String msg, String code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public ResponseEntity() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
