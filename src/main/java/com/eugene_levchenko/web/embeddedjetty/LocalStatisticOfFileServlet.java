package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.Entities.LocalStatOfFileEntity;
import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class LocalStatisticOfFileServlet extends MyServlet {

   private ArrayList<LocalStatOfFileEntity> list=new ArrayList<LocalStatOfFileEntity>();

   private String fileName="";
   private String nameOfParam="id";
   private String paramValue="";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");

        resp.getWriter().println("<p><b><h1>Локальная статистика слов по файлу</h1></b></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/main\">Главная</a></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/ls\">Локальная статистика файлов</a></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/gs\">Глобальная статистика</a></p>");
        paramValue = req.getParameter(nameOfParam);
        setConnection();
        renderTable(resp);
    }

    public ResultSet setConnection()
    {
        ResultSet resultSet = null;
        try {
            String queryGetFileName="SELECT fullfilename FROM webprojectfilesystemdb.fullnametable where id="+paramValue+";";
            String query="SELECT word,value FROM webprojectfilesystemdb.localstatistic where file_id="+paramValue+" order by 1;";
            Statement st=connection.createStatement();
            ResultSet res=st.executeQuery(query);

            list.clear();
            while (res.next())
            {
                list.add(new LocalStatOfFileEntity(res.getString(1),res.getInt(2)));
            }
            Statement st2=connection.createStatement();
            ResultSet res2=st2.executeQuery(queryGetFileName);
            while (res2.next())
            {
                fileName=res2.getString(1);
            }
            resultSet=res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public String createTable()  {
        String table="";

        for (int i=0;i<list.size();i++)
        {
            table+="<tr> <td>"+"<a href=\"http://localhost:8080/wsf?word="
                    +list.get(i).getWord()+"\">"
                    +list.get(i).getWord()+"</a>"+"</td> <td>"
                    +list.get(i).getValue()+"</td>";
        }

        return table;
    }

    public void renderTable( HttpServletResponse resp) throws IOException {
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Статистика слов в файле: "+fileName+"</caption>\n" +
                        "   <tr>\n" +
                        "    <th>Слово</th>\n" +
                        "    <th>Значение</th>\n" +
                        "   </tr>\n" +
                        createTable()+
                        "  </table>");
    }
}