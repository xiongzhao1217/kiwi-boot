package com.kiwiboot.kiwisso.configurer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Mybatis & Mapper & PageHelper 配置
 * @author xiongzhao
 */
@Configuration
public class MybatisConfigurer {

//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//        factory.setDataSource(dataSource);
//        //配置分页插件，详情请查阅官方文档
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        //分页尺寸为0时查询所有纪录不再执行分页
//        properties.setProperty("pageSizeZero", "true");
//        //页码<=0 查询第一页，页码>=总页数查询最后一页
//        properties.setProperty("reasonable", "true");
//        //支持通过 Mapper 接口参数来传递分页参数
//        properties.setProperty("supportMethodsArguments", "true");
//        pageHelper.setProperties(properties);
//        //添加插件
//        factory.setPlugins(new Interceptor[]{pageHelper});
//        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//        return factory.getObject();
//    }
}

