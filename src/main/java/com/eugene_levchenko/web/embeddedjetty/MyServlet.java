package com.eugene_levchenko.web.embeddedjetty;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyServlet extends HttpServlet {

    final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
    final static String USERNAME = "root";
    final static String PASSWORD = "root";

    Connection connection;
    {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
