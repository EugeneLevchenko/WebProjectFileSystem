package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplWordInFileStat;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGetById;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityWordInFileStat;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;
import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class ServletWordInFileStatistic extends ServletBase {

    private String nameOfParam="word";
    private String paramValue="";
    private IDAOGetById dao=new DAOImplWordInFileStat();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setContentType("text/html;charset=UTF-8");
        paramValue = req.getParameter(nameOfParam);
        resp.getWriter().println("<p><b><h1>Статистика слова в директории</h1></b></p>");
        renderingMenu(resp, ENamesOfPages.ALL_ITEMS);

        try {
            renderTable(resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String createTable() throws SQLException {

        String table="";
        List<EntityWordInFileStat> list=dao.getAllById(paramValue);

        for (EntityWordInFileStat i: list) {
            table+="<tr> <td>"+i.getNameOfFile()+"</td> <td>"+i.getValue()+"</td>";
        }

        return table;
    }

    public void renderTable( HttpServletResponse resp) throws IOException, SQLException {
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Глобальная статистика слова: <h1 style=\"margin: 0;\"><b>"+paramValue+"</b></h1> в директории</caption>\n" +
                        "   <tr>\n" +
                        "    <th>Имя файла</th>\n" +
                        "    <th>Значение</th>\n" +
                        "   </tr>\n" +
                        createTable()+
                        "  </table>");
    }
}