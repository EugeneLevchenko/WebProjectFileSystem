package com.eugene_levchenko.web.embeddedjetty.servlets;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletMainPage extends ServletBase {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        doGetCommon(req,resp,"Главная");
    }
}
//resp.setContentType("text/html;charset=UTF-8");
//resp.getWriter().println("<p><b><h1>Главная</h1></b></p>");
//renderingMenu(resp, ENamesOfPages.MAIN);