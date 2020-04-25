/*
package com.hthyaq.learnadmin.common.config;

import com.bstek.ureport.definition.datasource.BuildinDatasource;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Slf4j
public class Ureport2DataSource implements BuildinDatasource {
    @Autowired
    DataSource dataSource;

    @Override
    public String name() {
        return "ureport2DataSource";
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Ureport2的数据源获取连接失败！");
            log.error(Throwables.getStackTraceAsString(e));
        }
        return null;
    }
}
*/
