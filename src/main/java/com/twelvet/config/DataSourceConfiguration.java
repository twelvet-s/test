package com.twelvet.config;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.provider.AbstractDataSourceProvider;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源配置：
 * <p>
 * 使用{@link com.baomidou.dynamic.datasource.annotation.DS}注解，切换数据源
 * <p>
 * <code>@DS(DataSourceConfiguration.SHARDING_DATA_SOURCE_NAME)</code>
 */
@Configuration
public class DataSourceConfiguration {
    /**
     * 分表数据源名称
     */
    public static final String SHARDING_DATA_SOURCE_NAME = "shardingsphere";

    /**
     * 动态数据源配置项
     */
    @Autowired
    private DynamicDataSourceProperties properties;

    /**
     * 1. 建议springboot2.5.0 以下版本或者发现不加@Lazy值是null的情况都打开@Lazy
     * 2. Compared with using SpringBoot Starter, if you encounter such problems,
     * you should directly use ShardingSphere's JDBC Driver to configure it as a JDBC data source, that is,
     * use `org.apache.shardingsphere:shardingsphere-jdbc-core:5.1.2` instead of `org.apache.shardingsphere:shardingsphere-jdbc-core-spring-boot-starter:5.1.2`.
     * For more information see <a href="https://shardingsphere.apache.org/document/current/en/user-manual/shardingsphere-jdbc/jdbc-driver/">JDBC Driver</a>
     */
    @Autowired
    private DataSource shardingSphereDataSource;

    @Bean
    public DynamicDataSourceProvider dynamicDataSourceProvider() {
        return new AbstractDataSourceProvider() {
            @Override
            public Map<String, DataSource> loadDataSources() {
                Map<String, DataSource> dataSourceMap = new HashMap<>();
                //把shardingSphereDataSource 加入多数据源，到时候使用的时候就可以@DS("shardingSphere")
                dataSourceMap.put(SHARDING_DATA_SOURCE_NAME, shardingSphereDataSource);
                return dataSourceMap;
            }
        };
    }

    @Primary
    @Bean
    public DataSource dataSource() {
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setPrimary(properties.getPrimary());
        dataSource.setStrict(properties.getStrict());
        dataSource.setStrategy(properties.getStrategy());
        dataSource.setP6spy(properties.getP6spy());
        dataSource.setSeata(properties.getSeata());
        return dataSource;
    }

}
