package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGetAll;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;
import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplGlobalStat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ServletGlobalStatistic extends ServletBase {

    IDAOGetAll dao=new DAOImplGlobalStat();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        doGetCommon(req,resp,ENamesOfPages.GLOBAL_STATISTIC,"Глобальная статистика");
        renderTable(resp);
    }

    public String createTable() throws SQLException {
        String table="";
        List<EntityGlobalStat> list=dao.getAll();

        for (EntityGlobalStat i: list)
        {
            String word=i.getWord();
            table+="<tr> <td>"+"<a href=\"http://localhost:8080/wsf?word="
                    +word+"\">"
                    +word+"</a>"+"</td> <td>"
                    +i.getValue()+"</td>";//
        }
        return table;
    }

    public void renderTable( HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println(
                    " <table border=\"1\">\n" +
                            "   <caption>Глобальная статистика слов в директории</caption>\n" +
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
}