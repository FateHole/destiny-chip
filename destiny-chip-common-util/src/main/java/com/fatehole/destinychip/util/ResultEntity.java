package com.fatehole.destinychip.util;

/**
 * 统一整个项目中的ajax请求返回的结果
 *
 * @author FateCat
 * @version 2020-10-05-22:54
 */
public class ResultEntity<T> {

    private static final String SUCCESS = "SUCCESS";

    private static final String FAILED = "FAILED";

    /**
     * 用来封装当前请求是成功还是失败
     */
    private String result;

    /**
     * 请求处理失败时返回的错误消息
     */
    private String message;

    /**
     * 要返回的数据
     */
    private T data;

    /**
     * 请求处理成功且不需需要返回数据的工具方法
     * @param <E> 类型
     * @return 不带数据ResultEntity
     */
    public static <E> ResultEntity<E> successWithOutData() {
        return new ResultEntity<>(SUCCESS, null, null);
    }

    /**
     * 请求处理成功且需要返回数据的工具方法
     * @param data 数据
     * @param <E> 类型
     * @return 带数据
     */
    public static <E> ResultEntity<E> successWithData(E data) {
        return new ResultEntity<>(SUCCESS, null, data);
    }

    /**
     * 请求处理失败后的工具方法
     * @param message 错误消息
     * @param <E> 类型
     * @return 带错误详细
     */
    public static <E> ResultEntity<E> failed(String message)  {
        return new ResultEntity<>(FAILED, message, null);
    }

    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
