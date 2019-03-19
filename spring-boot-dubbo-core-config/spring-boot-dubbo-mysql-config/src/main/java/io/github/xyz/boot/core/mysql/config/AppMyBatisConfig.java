package io.github.xyz.boot.core.mysql.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @author zhaoyunxing
 * @date: 2018-11-30 20:27
 * @des:
 */
public class AppMyBatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(true);
        configuration.setUseGeneratedKeys(false);
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        configuration.setLazyLoadingEnabled(false);
        configuration.setDefaultStatementTimeout(5000);
        sqlSessionFactoryBean.setConfiguration(configuration);
        try {
            //添加XML目录
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:io/github/xyz/**/mappers/xml/*Mapper.xml"));
            //添加插件
            // sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor()});
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    @Bean
    //    public PageInterceptor pageInterceptor() {
    //        PageInterceptor interceptor = new PageInterceptor();
    //        Properties props = new Properties();
    //        props.setProperty("reasonable", "true");
    //        props.setProperty("helperDialect", "mysql");
    //        props.setProperty("supportMethodsArguments", "true");
    //        // props.setProperty("autoRuntimeDialect", "true");​
    //        interceptor.setProperties(props);
    //        return interceptor;
    //    }


    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
