package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.Entities.GlobalStatEntity;
import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class GlobalStatisticServlet extends MyServlet {

   private ArrayList<GlobalStatEntity> list=new ArrayList<GlobalStatEntity>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Глобальная статистика</h1></b></p>");
        renderingMenu(resp,NamesOfPages.GLOBAL_STATISTIC);
        setConnection();
        renderTable(resp);
    }

    public String createTable() {
        String table="";
        for (int i=0;i<list.size();i++)
        {
            table+="<tr> <td>"+"<a href=\"http://localhost:8080/wsf?word="
                    +list.get(i).getWord()+"\">"
                    +list.get(i).getWord()+"</a>"+"</td> <td>"
                    +list.get(i).getValue()+"</td>";//
        }

        return table;
    }

    public ResultSet setConnection()
    {
        ResultSet resultSet = null;
        try {
            String query="select * from filestatistic order by 1;";
            Statement st=connection.createStatement();
            ResultSet res=st.executeQuery(query);
            list.clear();
            System.out.println("after clear: "+list);
            while (res.next())
            {
                list.add(new GlobalStatEntity(res.getString(1),res.getInt(2)));
            }
            resultSet=res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
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