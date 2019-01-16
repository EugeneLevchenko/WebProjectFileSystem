package com.eugene_levchenko.web.embeddedjetty;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyServlet extends HttpServlet {

    protected static String[][] ARRAY_OF_URL_AND_DESCRIPTION = {
            {"Главная","http://localhost:8080/main"},
            {"Глобальная статистика","http://localhost:8080/gs"},
            {"Локальная статистика файлов","http://localhost:8080/ls"}
    };


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
        renderingMenu(resp,NamesOfPages.MAIN);
    }

    protected void renderingMenu(HttpServletResponse resp,Enum excludedItem) throws IOException {
        int indexOfEnum=excludedItem.ordinal();
        String menuItem="";

        for (int i = 0; i < ARRAY_OF_URL_AND_DESCRIPTION.length; i++) {
            for (int j = 0; j < ARRAY_OF_URL_AND_DESCRIPTION[i].length; j++) {
                if (i!=indexOfEnum)
                {
                    menuItem+=" <li> <a href="+ ARRAY_OF_URL_AND_DESCRIPTION[i][1]+">"
                            + ARRAY_OF_URL_AND_DESCRIPTION[i][0]+"</a> </li>" ;
                    break;
                }
            }
        }

        resp.getWriter().println(" <style>\n" +
                "   ul.hr {\n" +
                "    margin: 20; \n" +
                "    padding: 40px; \n" +
                "   }\n" +
                "   ul.hr li {\n" +
                "    display: inline; \n" +
                "    margin-right: 50px; \n" +
                "    border: 1px solid #000; \n" +
                "    padding: 30px; \n" +
                "   }\n" +
                "  </style>\n" +
                " </head>\n" +
                " <body>\n" +
                "  <ul class=\"hr\">\n" +
                menuItem +
                "</ul>");
    }
}