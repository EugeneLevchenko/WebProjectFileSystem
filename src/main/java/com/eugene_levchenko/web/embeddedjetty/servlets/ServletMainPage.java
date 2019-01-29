package com.eugene_levchenko.web.embeddedjetty.servlets;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;
import org.eclipse.jetty.http.HttpStatus;

public class ServletMainPage extends ServletBase {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<p><b><h1>Главная</h1></b></p>");
        renderingMenu(resp, ENamesOfPages.MAIN);
    }
}