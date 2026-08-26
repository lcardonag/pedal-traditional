package com.example.bike_commerce.configuration;

import com.example.bike_commerce.employees.entities.Employees;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.bike_commerce.employees.repositories",
        entityManagerFactoryRef = "employeesEntityManagerFactory",
        transactionManagerRef = "employeesTransactionManager"
)
public class EmployeesDataSourceConfiguration {
    @Bean(name = "employeesEntityManager")
    @ConfigurationProperties("spring.datasource.employees")
    public DataSourceProperties employeesDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "secondaryDB")
    @ConfigurationProperties("spring.datasource.employees.configuration")
    public DataSource employeesDatasource() {
        return employeesDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

//    @Bean(name = "secondaryEM")
//    public LocalContainerEntityManagerFactoryBean storingEntityManagerFactory(
//            EntityManagerFactoryBuilder builder, @Qualifier("secondaryDB") DataSource ds) {
//        return builder
//                .dataSource(ds)
//                .packages("com.test.supplier2")
//                .persistenceUnit("secondaryPU")
//                .build();
//    }

    @Bean(name = "employeesEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean employeesEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(employeesDatasource())
                .packages(Employees.class)
                .persistenceUnit("employees")
                .build();
    }

    @Bean(name = "employeesTransactionManager")
    public PlatformTransactionManager employeesTransactionManager(
            final @Qualifier("employeesEntityManagerFactory") LocalContainerEntityManagerFactoryBean employeesEntityManagerFactory) {
        return new JpaTransactionManager(
                employeesEntityManagerFactory.getObject()
        );
    }

}

