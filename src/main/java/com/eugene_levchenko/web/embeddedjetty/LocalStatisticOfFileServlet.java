package com.eugene_levchenko.web.embeddedjetty;

import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LocalStatisticOfFileServlet extends HttpServlet {

    final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
    final static String USERNAME = "root";
    final static String PASSWORD = "root";
int id=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Локальная статистика слов по файлу</h1></b></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/main\">Главная</a></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/ls\">Локальная статистика файлов</a></p>");

    }


}
