package com.eugene_levchenko.web.embeddedjetty;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;

public class MainPageServlet extends MyServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Главная</h1></b></p>");
       renderingMenu(resp,NamesOfPages.MAIN);
        System.out.println(req.getServletPath());
    }
}