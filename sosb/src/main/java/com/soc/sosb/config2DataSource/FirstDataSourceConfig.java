package com.soc.sosb.config2DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.first.repository"},
entityManagerFactoryRef = "firstEntitymanagerfactory",
        transactionManagerRef = "firstTransactionManager")
public class FirstDataSourceConfig {

    @Primary
    @Bean(name= "firstDataSource")
    @ConfigurationProperties(prefix = "first.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

}
