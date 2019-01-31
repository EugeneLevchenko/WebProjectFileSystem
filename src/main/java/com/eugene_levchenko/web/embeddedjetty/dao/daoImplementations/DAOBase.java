package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAOBase {

    public final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL ,USERNAME,PASSWORD);
        return connection;
    }
}