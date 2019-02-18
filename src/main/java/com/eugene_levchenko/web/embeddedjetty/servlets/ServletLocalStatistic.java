package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplLocalStat;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOLocalStatOfFileEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

public  class ServletLocalStatistic extends ServletBaseWithTableWithParam {

    private IDAOLocalStatOfFileEntity dao= new DAOImplLocalStat();


    private String nameOfParam="id";
    private int id =0;

    public String createTable() throws SQLException {
        List<EntityLocalStatOfFile> list=dao.getAllById(id);
        String table="";

        for (EntityLocalStatOfFile i: list)
        {
            String word=i.getWord();
            table+="<tr> <td>"+"<a href=\"wsf?word="
                    +word+"\">"
                    +word+"</a>"+"</td> <td>"
                    +i.getValue()+"</td>";
        }
        return table;
    }

    @Override
    protected ENamesOfPages getExcludedMenuItem() {
        return ENamesOfPages.LOCAL_STATISTIC;
    }

@Override
    public void renderTable(HttpServletResponse resp,HttpServletRequest req) throws IOException {
        try {
          id = Integer.parseInt( getParam(req,nameOfParam));
            System.out.println(id);
            resp.getWriter().println(
                    " <table border=\"1\">\n" +
                            "   <caption>Статистика слов в файле: "
                            +dao.getFileNameById(id)+"</caption>\n" +
                            "   <tr>\n" +
                            "    <th>Слово</th>\n" +
                            "    <th>Значение</th>\n" +
                            "   </tr>\n" +
                            createTable()+
                            "  </table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getCaptionPage() {
        return "Локальная статистика слов по файлу";
    }

}