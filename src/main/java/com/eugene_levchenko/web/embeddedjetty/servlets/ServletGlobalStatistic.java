package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGlobalStatEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;
import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplGlobalStat;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public  class ServletGlobalStatistic extends ServletBaseWithTable {

     IDAOGlobalStatEntity dao=new DAOImplGlobalStat();

    public String createTable() throws SQLException {
        String table="";
        List<EntityGlobalStat> list=dao.getAll();

        for (EntityGlobalStat i: list)
        {
            String word=i.getWord();
            table+="<tr> <td>"+"<a href=\"wsf?word="
                    +word+"\">"
                    +word+"</a>"+"</td> <td>"
                    +i.getValue()+"</td>";//
        }
        return table;
    }

    @Override
    protected ENamesOfPages getExcludedMenuItem() {
        return ENamesOfPages.GLOBAL_STATISTIC;
    }

    @Override
    public void renderTable(HttpServletResponse resp) throws IOException, SQLException {

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

    @Override
    protected String getCaptionPage() {
        return "Глобальная статистика";
    }
}