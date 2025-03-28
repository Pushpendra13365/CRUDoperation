//package com.crudoperation.config;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "userEntityManagerFactory",
//        basePackages = {"com.crudoperation.repositoryUser"}
//    )
//public class UserDBConfig {
//
//    @Bean(name = "userDataSource")
//    @ConfigurationProperties(prefix = "spring.db2.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "userEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
//            EntityManagerFactoryBuilder builder, @Qualifier("userDataSource") DataSource dataSource) {
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "update");
//
//        return builder
//                .dataSource(dataSource)
//                .properties(properties)
//                .packages("com.crudoperation.entityUser")
//                .persistenceUnit("User")
//                .build();
//    }
//
//    @Bean(name = "userTransactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("userEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
