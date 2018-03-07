package com.ztkj.core.entity;


import java.util.Map;

/**
 * Created by Zero on 2016/10/10.
 */
public class Log {

    private String requestPath = null ; // 请求地址
    private String method = null;
    private String userName = null ; // 用户名
    private Map<?,?> inputParamMap = null ; // 传入参数
    private String paramStr = "";
    private Map<String, Object> outputParamMap = null; // 存放输出结果
    private Object returned;
    private String clasz;               //路径
    private String clientIp;            //客户端IP
    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间
    private String macAdress;

    public String getRequestPath() {
        if(null == requestPath){
            requestPath = "";
        }
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getMethod() {
        if(null == method){
            method = "";
        }
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUserName() {
        if(null == userName){
            userName = "";
        }
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<?, ?> getInputParamMap() {
        return inputParamMap;
    }

    public void setInputParamMap(Map<?, ?> inputParamMap) {
        this.inputParamMap = inputParamMap;
    }

    public String getParamStr() {
        if(null == paramStr){
            paramStr = "";
        }
        return paramStr;
    }

    public void setParamStr(String paramStr) {
        this.paramStr = paramStr;
    }

    public Map<String, Object> getOutputParamMap() {
        return outputParamMap;
    }

    public void setOutputParamMap(Map<String, Object> outputParamMap) {
        this.outputParamMap = outputParamMap;
    }

    public Object getReturned() {
        return returned;
    }

    public void setReturned(Object returned) {
        this.returned = returned;
    }

    public String getClasz() {
        if(null == clasz){
            clasz = "";
        }
        return clasz;
    }

    public void setClasz(String clasz) {
        this.clasz = clasz;
    }

    public String getClientIp() {
        if(null == clientIp){
            clientIp = "";
        }
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public long getStartTimeMillis() {
        return startTimeMillis;
    }

    public void setStartTimeMillis(long startTimeMillis) {
        this.startTimeMillis = startTimeMillis;
    }

    public long getEndTimeMillis() {
        return endTimeMillis;
    }

    public void setEndTimeMillis(long endTimeMillis) {
        this.endTimeMillis = endTimeMillis;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }
}
