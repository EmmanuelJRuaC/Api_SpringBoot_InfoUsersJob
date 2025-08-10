package com.api.infousersjob.query_dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        String url = "jdbc:mysql://mysql-emmanuelrua11.alwaysdata.net/emmanuelrua11_infousersjob?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "422146";
        String password = "Ema20031011";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
