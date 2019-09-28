package com.example.persondal.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DsConfig {

    @Bean(name = "studentDS")
    @Primary
    public DataSource studentDS() {
        return new HikariDataSource(studentHC());
    }

    @Bean(name = "studentHC")
    @ConfigurationProperties(prefix = "db.student")
    public HikariConfig studentHC() {
        return getHikariConfig();
    }

    private HikariConfig getHikariConfig() {
        HikariConfig hc = new HikariConfig();
        hc.setRegisterMbeans(true);
        hc.setAllowPoolSuspension(true);
        return hc;
    }




}

