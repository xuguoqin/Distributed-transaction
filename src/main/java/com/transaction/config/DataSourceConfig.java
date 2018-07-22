package com.transaction.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "signinDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.signin")
    public DataSource signinDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "integralDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.integral")
    public DataSource integralDataSource() {
        return DataSourceBuilder.create().build();
    }

}
