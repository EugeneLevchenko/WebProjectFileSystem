package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletBase extends HttpServlet {

    protected static String[][] ARRAY_OF_URL_AND_DESCRIPTION = {
            {"Главная","http://localhost:8080/main"},
            {"Глобальная статистика","http://localhost:8080/gs"},
            {"Локальная статистика файлов","http://localhost:8080/ls"}
    };

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

    protected void doGetCommon(HttpServletRequest req, HttpServletResponse resp,String nameOfPage) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(getHTMLQueryPageName(nameOfPage));
        renderingMenu(resp, ENamesOfPages.MAIN);

    }

    protected String getHTMLQueryPageName(String name)
    {
        String strBegin="<p><b><h1>";
        String strEnd="</h1></b></p>";
        String strResult=strBegin+name+strEnd;
        return strResult;
    }



}