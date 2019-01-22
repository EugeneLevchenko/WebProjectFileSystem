package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.dao.GlobalStatDaoImpl;
import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GlobalStatisticServlet extends MyServlet {

    GlobalStatDaoImpl dao=new GlobalStatDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Глобальная статистика</h1></b></p>");
        renderingMenu(resp,NamesOfPages.GLOBAL_STATISTIC);
        dao.getData();
        renderTable(resp);
    }

    public String createTable() {
        String table="";
        for (int i=0;i<dao.getList().size();i++)
        {
            table+="<tr> <td>"+"<a href=\"http://localhost:8080/wsf?word="
                    +dao.getList().get(i).getWord()+"\">"
                    +dao.getList().get(i).getWord()+"</a>"+"</td> <td>"
                    +dao.getList().get(i).getValue()+"</td>";//
        }
        return table;
    }

    public void renderTable( HttpServletResponse resp) throws IOException {
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Глобальная статистика слов в директории</caption>\n" +
                        "   <tr>\n" +
                        "    <th>Слово</th>\n" +
                        "    <th>Значение</th>\n" +
                        "   </tr>\n" +
                        createTable()+
                        "  </table>");
    }
}