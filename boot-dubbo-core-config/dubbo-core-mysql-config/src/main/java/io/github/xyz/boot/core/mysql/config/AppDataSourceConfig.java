package io.github.xyz.boot.core.mysql.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author zhaoyunxing
 * @date: 2018-11-30 20:14
 * @des:
 */
public class AppDataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource writeDataSource() {
        return new DruidDataSource();
    }
}
