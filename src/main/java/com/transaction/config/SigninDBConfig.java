package com.transaction.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.transaction.mapper.signin"}, sqlSessionFactoryRef = "signinSqlSessionFactory")
public class SigninDBConfig {

    @Autowired
    @Qualifier("signinDataSource")
    private DataSource signinDataSource;

    @Bean
    public SqlSessionFactory signinSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(signinDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/signin/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate signinSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(signinSqlSessionFactory());
    }

    @Bean(name = "signinTransactionManager")
    public DataSourceTransactionManager signinTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(signinDataSource);
        return transactionManager;
    }

}
