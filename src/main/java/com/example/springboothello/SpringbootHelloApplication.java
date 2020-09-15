package com.example.springboothello;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
@MapperScan("com.example.springboothello.mapper")
public class SpringbootHelloApplication {
    @Bean
    public ApplicationRunner runner(@Autowired DataSource dataSource) {
        return args -> {
            Connection connection = dataSource.getConnection();
        };
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

//    @Bean
//    public DataSource dataSource(
//            @Value("${spring.datasource.driver-class-name}") String DriverClassName,
//            @Value("${spring.datasource.url}") String url,
//            @Value("${spring.datasource.username}") String username,
//            @Value("${spring.datasource.password}") String password,
//            @Value("${spring.datasource.hikari.auto-commit}") String autoCommit,
//            @Value("${spring.datasource.hikari.connection-timeout}") String connectionTimeout,
//            @Value("${spring.datasource.hikari.validation-timeout}") String validationTimeout,
//            @Value("${spring.datasource.hikari.max-lifetime}") String maxLifetime,
//            @Value("${spring.datasource.hikari.maximum-pool-size}") String maximumPoolSize,
//            @Value("${spring.datasource.hikari.minimum-idle}") String minimumIdle
//    ) {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(DriverClassName);
//        config.setJdbcUrl(url);
//        config.setUsername(username);
//        config.setPassword(password);
//        config.addDataSourceProperty("autoCommit",autoCommit);
//        config.addDataSourceProperty("connectionTimeout",connectionTimeout);
//        config.addDataSourceProperty("validationTimeout",validationTimeout);
//        config.addDataSourceProperty("maxLifetime",maxLifetime);
//        config.addDataSourceProperty("maximumPoolSize",maximumPoolSize);
//        config.addDataSourceProperty("minimumIdle",minimumIdle);
//        return new HikariDataSource(config);
//    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloApplication.class, args);
    }

}
