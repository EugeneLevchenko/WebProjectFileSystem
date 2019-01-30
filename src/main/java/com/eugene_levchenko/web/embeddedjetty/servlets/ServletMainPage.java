package com.eugene_levchenko.web.embeddedjetty.servlets;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletMainPage extends ServletBase {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        doGetCommon(req,resp, ENamesOfPages.MAIN,"Главная");
    }
}