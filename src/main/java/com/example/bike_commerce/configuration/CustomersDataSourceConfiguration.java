package com.example.bike_commerce.configuration;

import com.example.bike_commerce.customers.entities.Bike;
import com.example.bike_commerce.customers.entities.Order;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.bike_commerce.customers.repositories",
        entityManagerFactoryRef = "customersEntityManagerFactory",
        transactionManagerRef = "customersTransactionManager"
)
public class CustomersDataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.customers")
    public DataSourceProperties customersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.customers.configuration")
    public DataSource customersDatasource() {
        return customersDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean(name = "customersEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean customersEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(customersDatasource())
                .packages(Order.class, Bike.class)
                .persistenceUnit("customers")
                .build();
    }

    @Primary
    @Bean(name = "customersTransactionManager")
    public PlatformTransactionManager customersTransactionManager(
            final @Qualifier("customersEntityManagerFactory") LocalContainerEntityManagerFactoryBean customersEntityManagerFactory) {
        return new JpaTransactionManager(
                customersEntityManagerFactory.getObject()
        );
    }

}

