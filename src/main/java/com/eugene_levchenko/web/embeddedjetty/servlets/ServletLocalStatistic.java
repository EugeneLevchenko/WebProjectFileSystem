package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplLocalStat;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOFileNameEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;
import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class ServletLocalStatistic extends ServletBase {

    private IDAOFileNameEntity dao=new DAOImplLocalStat();
    private String nameOfParam="id";
    private String paramValue="";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Локальная статистика слов по файлу</h1></b></p>");
        renderingMenu(resp, ENamesOfPages.ALL_ITEMS);
        paramValue = req.getParameter(nameOfParam);

        try {
            renderTable(resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String createTable() throws SQLException {
        List<EntityLocalStatOfFile> list=dao.getDataFromSelectByValue(paramValue);
        String table="";

        for (EntityLocalStatOfFile i: list)
        {
            String word=i.getWord();
            table+="<tr> <td>"+"<a href=\"http://localhost:8080/wsf?word="
                    +word+"\">"
                    +word+"</a>"+"</td> <td>"
                    +i.getValue()+"</td>";
        }

        return table;
    }

    public void renderTable( HttpServletResponse resp) throws IOException, SQLException {
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Статистика слов в файле: "+dao.getFileNameById(Integer.parseInt(paramValue))+"</caption>\n" +
                        "   <tr>\n" +
                        "    <th>Слово</th>\n" +
                        "    <th>Значение</th>\n" +
                        "   </tr>\n" +
                        createTable()+
                        "  </table>");
    }
}