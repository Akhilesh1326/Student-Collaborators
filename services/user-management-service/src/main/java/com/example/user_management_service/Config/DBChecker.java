package com.example.user_management_service.Config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class DBChecker {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void printDBInfo() throws SQLException {
        System.out.println("🔍 JDBC URL: " + dataSource.getConnection().getMetaData().getURL());
        System.out.println("🔍 DB Username: " + dataSource.getConnection().getMetaData().getUserName());
    }
}