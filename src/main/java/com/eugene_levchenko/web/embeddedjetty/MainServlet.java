package com.eugene_levchenko.web.embeddedjetty;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Главная</h1></b></p>");
       // resp.getWriter().println("<a href=\"http://localhost:8080/gs\">Глобальная статистика</a>");
      //  resp.getWriter().println("<a href=\"http://localhost:8080/gs\">Локальная статистика</a>");
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
                "<li> <a href=\"http://localhost:8080/gs\">Глобальная статистика</a> </li> <li> <a href=\"http://localhost:8080/ls\">Локальная статистика файлов</a> </li> "+
                "  </ul>");
    }
}
