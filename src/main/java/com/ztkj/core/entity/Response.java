package com.ztkj.core.entity;

/**
 * Created by root on 17-5-8.
 */
public class Response {

    public static final Integer FAIL_CODE = 101;

    public static final Integer SUCCESS_CODE = 100;

    private Integer code;
    private Object body;
    private String msg;

    public Response() {
    }

    public Response(Integer code, Object body, String msg) {
        this.code = code;
        this.body = body;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Response setCode(Integer code) {
        this.code = code;
        return  this;
    }

    public Object getBody() {
        return body;
    }

    public Response setBody(Object body) {
        this.body = body;
        return  this;
    }

    public String getMsg() {
        return msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return  this;
    }

    public static Response getSuccessInstance(Object body){
        return new Response(100,body,null);
    }

    public static Response getErrorInstance(Object body,String msg){
        return new Response(101,body,msg);
    }

}
