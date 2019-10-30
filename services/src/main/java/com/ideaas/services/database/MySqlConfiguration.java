package com.ideaas.services.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@ComponentScan( basePackages = "com.ideaas.*")
@EnableJpaRepositories(
        basePackages = { "com.ideaas.*"},
        entityManagerFactoryRef = "mySqlEntityManagerFactory",
        transactionManagerRef = "mySqlTransactionManager")
public class MySqlConfiguration {

    @Primary
    @Bean(name = "dataSource")
    public DataSource sqlServerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://190.210.180.187:3306/sistema_test");
        dataSource.setUsername("root");
        dataSource.setPassword("viapublica2012");
        return dataSource;
    }

    @Primary
    @Bean(name = "mySqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource barDataSource) {
        return builder
                .dataSource(barDataSource)
                .packages("com.ideaas.services.*")
                .persistenceUnit("mySqlEntityManager")
                .properties(jpaProperties())
                .build();
    }

    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        props.put("hibernate.hbm2ddl.auto", "update");
        return props;
    }

    @Primary
    @Bean(name = "mySqlTransactionManager")
    public PlatformTransactionManager barTransactionManager(
            @Qualifier("mySqlEntityManagerFactory") EntityManagerFactory mySqlEntityManagerFactory) {
        return new JpaTransactionManager(mySqlEntityManagerFactory);
    }


}
