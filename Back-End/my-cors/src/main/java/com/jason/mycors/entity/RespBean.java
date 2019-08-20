package com.jason.mycors.entity;

import lombok.Data;

/**
 * 自定义的响应体实体类.
 * 封装了状态码、反馈信息、返回数据.
 *
 * @author jasonzli
 */
@Data
public class RespBean {

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 反馈消息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object object;

    /**
     * 无参构造函数.
     */
    private RespBean() {
    }

    /**
     * 全参构造函数.
     *
     * @param status  Integer，状态码
     * @param message String，反馈消息
     * @param object  Object，返回数据
     */
    private RespBean(Integer status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    /**
     * 返回执行成功的响应体.
     *
     * @param message String，反馈消息
     * @param object  Object，返回数据
     * @return RespBean，返回给前端的响应体
     */
    public static RespBean ok(String message, Object object) {
        return new RespBean(200, message, object);
    }

    /**
     * 返回执行成功的响应体.
     *
     * @param message String，反馈消息
     * @return RespBean，返回给前端的响应体
     */
    public static RespBean ok(String message) {
        return new RespBean(200, message, null);
    }

    /**
     * 返回执行错误的响应体.
     *
     * @param message String，反馈消息
     * @param object  Object，返回数据
     * @return RespBean，返回给前端的响应体
     */
    public static RespBean error(String message, Object object) {
        return new RespBean(500, message, object);
    }

    /**
     * 返回执行错误的响应体.
     *
     * @param message String，反馈消息
     * @return RespBean，返回给前端的响应体
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }
}

