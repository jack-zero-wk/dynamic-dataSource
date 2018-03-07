package com.ztkj.core.bean;

import java.io.Serializable;

/**
 * Created by dell on 2017/7/18.
 */
public class DataSourceEntity implements Serializable {

    private Integer userId;
    private Integer id;
    private String username;
    private String password;
    private String driverClassName;
    private String host;
    private String port;
    private String dbName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUrl(){
        StringBuffer stb = new StringBuffer("");
        stb.append("jdbc:mysql://");
        stb.append(host);
        stb.append(":");
        stb.append(port);
        stb.append("/");
        stb.append(dbName);
        stb.append("?characterEncoding=utf8&useSSL=false");
        return stb.toString();
    }

}
