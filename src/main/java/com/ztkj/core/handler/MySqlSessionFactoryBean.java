package com.ztkj.core.handler;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;

import java.io.IOException;

/**
 * Created by Zero on 2016/8/31.
 *
 */
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

    @Override
    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
        try {
            return super.buildSqlSessionFactory();
        } catch (NestedIOException e) {
            e.printStackTrace(); // XML 有错误时打印异常。
            throw new NestedIOException("Failed to parse mapping resource: '"  + "'", e);
        } finally {
            ErrorContext.instance().reset();
        }
    }
}
