package com.danielK.mientrashagolimonadadef;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManger",
        basePackages = {"com.danielK.mientrashagolimonadadef.repo.user"})
public class BDMariaDB {
    @Autowired
    private Environment env;

    @Bean(name="userDataSource")
    public DataSource userDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("persistente.datasource.url"));
        dataSource.setUsername(env.getProperty("persistente.datasource.username"));
        dataSource.setPassword(env.getProperty("persistente.datasource.password"));
        return dataSource;

    }
    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDatasource());
        em.setPackagesToScan("com.danielK.mientrashagolimonadadef.modelo.user");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Map<String,Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("persistente.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("persistente.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("persistente.jpa.properties.hibernate.dialect"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = "userTransactionManger")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
