package com.pdl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//自动扫描包
@ComponentScan(basePackages ="com.pdl")
//引入配置类,其被引入的文件为自配置类,
//@Import(JdbcConfig.class)
//表示读取外部配置文件
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    public class Jdbcconfig {
        @Value("${jdbc.drive}")
        private String drive;
        @Value("${jdbc.url}")
        private String url;
        @Value("${jdbc.name}")
        private String name;
        @Value("${jdbc.password}")
        private String password;

        @Bean(name="runner")
        public QueryRunner createQueryRunner(@Qualifier("ds")DataSource ds){
            return new QueryRunner(ds);
        }
        @Bean("ds")
        public DataSource createDataSource(){
            //连接数据库
            try {
                DruidDataSource source = new DruidDataSource();
                source.setDriverClassName(drive);
                source.setUrl(url);
                source.setPassword(password);
                source.setUsername(name);
                System.out.println(source);
                return source;
            } catch (Exception e) {
                //System.out.println("2345");
                throw new RuntimeException();
            }
        }

    }
}
