package com.ztkj.dataSource.ds.dao;


import com.ztkj.core.bean.DataSourceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dell on 2017/7/19.
 */
public interface DSDao {

    /**
     * 根据用户id查询数据源
     * @param userId
     * @return
     */
    DataSourceEntity getDataSourceByUserId(@Param("userId") Integer userId);

    List<DataSourceEntity> findAll();

}
