package com.eugene_levchenko.web.embeddedjetty;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyServlet extends HttpServlet {

   protected final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
   protected final static String USERNAME = "root";
   protected final static String PASSWORD = "root";

   protected Connection connection;
    {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void renderPage(HttpServletResponse resp) throws IOException {
        renderingMenu(resp);
    }

    protected void renderingMenu(HttpServletResponse resp) throws IOException {
    }

  //  protected void rendering


}