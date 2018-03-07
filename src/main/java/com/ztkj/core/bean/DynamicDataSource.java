package com.ztkj.core.bean;

import com.alibaba.druid.pool.DruidDataSource;
import com.ztkj.dataSource.ds.dao.DSDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * @author williams
 * @describe 实现动态数据源切换逻辑
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Logger log = Logger.getLogger(this.getClass());
    private Map<Object, Object> _targetDataSources;


    @Autowired
    private DSDao dsDao;

    /**
     * @see AbstractRoutingDataSource#determineCurrentLookupKey()
     * @describe 数据源为空或者为0时，自动切换至默认数据源，即在配置文件中定义的dataSource数据源
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DBContextHolder.getDBType();
        if (dataSourceName == null) {
            dataSourceName = "ds";
        } else {
            this.selectDataSource(Integer.valueOf(dataSourceName));
            if (dataSourceName.equals("0"))
                dataSourceName = "ds";
        }
        log.debug("--------> use datasource " + dataSourceName);
        return dataSourceName;
    }

    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this._targetDataSources = targetDataSources;
        super.setTargetDataSources(this._targetDataSources);
        afterPropertiesSet();
    }

    public void addTargetDataSource(String key, DruidDataSource dataSource) {
        this._targetDataSources.put(key, dataSource);
        this.setTargetDataSources(this._targetDataSources);

    }

    public DruidDataSource createDataSource(DataSourceEntity ds) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(ds.getDriverClassName());
        dataSource.setUrl(ds.getUrl());
        dataSource.setUsername(ds.getUsername());
        dataSource.setPassword(ds.getPassword());
        dataSource.setTestWhileIdle(true);
        return dataSource;
    }

    /**
     * @param userId
     * @describe 数据源存在时不做处理，不存在时创建新的数据源链接，并将新数据链接添加至缓存
     */
    public void selectDataSource(Integer userId) {
        Object sid = DBContextHolder.getDBType();
        if ("0".equals(userId + "")) {
            DBContextHolder.setDBType("0");
            return;
        }
        Object obj = this._targetDataSources.get(userId);
        if (obj != null && sid.equals(userId + "")) {
            return;
        } else {
            DruidDataSource dataSource = this.getDataSource(userId);
            if (null != dataSource)
                this.setDataSource(userId, dataSource);
        }
    }

    /**
     * @describe 查询userId对应的数据源记录
     * @param userId
     * @return
     */
    public DruidDataSource getDataSource(Integer userId) {
        this.selectDataSource(0);
        this.determineCurrentLookupKey();

        DataSourceEntity ds = null;

        try {

            ds = dsDao.getDataSourceByUserId(userId);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        if (null != ds) {
            DruidDataSource dataSource = this.createDataSource(ds);
            return dataSource;
        }
        return null;
    }

    /**
     * @param userId
     * @param dataSource
     */
    public void setDataSource(Integer userId, DruidDataSource dataSource) {
        this.addTargetDataSource(userId + "", dataSource);
        DBContextHolder.setDBType(userId + "");
    }

}