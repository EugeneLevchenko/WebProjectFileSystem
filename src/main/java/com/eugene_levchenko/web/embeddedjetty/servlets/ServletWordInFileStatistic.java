package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplWordInFileStat;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityWordInFileStat;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

public  class ServletWordInFileStatistic extends ServletBaseWithTableWithParam {

    private String paramValue="";
    private String nameOfParam="word";
    private IDAOBase dao= new DAOImplWordInFileStat();



    public String createTable() throws SQLException {

        String table="";
        List<EntityWordInFileStat> list=dao.getAllById(paramValue);

        for (EntityWordInFileStat i: list) {
            table+="<tr> <td>"+i.getNameOfFile()+"</td> <td>"+i.getValue()+"</td>";
        }

        return table;
    }

    @Override
    protected ENamesOfPages getExcludedMenuItem() {
        return ENamesOfPages.ALL_ITEMS;
    }

@Override
    public void renderTable(HttpServletResponse resp, HttpServletRequest req) throws IOException, SQLException {
        paramValue= (String) getParam(req,nameOfParam);
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

    @Override
    protected String getCaptionPage() {
        return "Статистика слова в файлах";
    }
}