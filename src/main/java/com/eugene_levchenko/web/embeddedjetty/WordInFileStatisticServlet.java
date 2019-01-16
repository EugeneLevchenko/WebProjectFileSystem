package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.Entities.WordInFileStatEntity;
import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class WordInFileStatisticServlet extends MyServlet {

   private String nameOfParam="word";
   private String paramValue="";

   private ArrayList<WordInFileStatEntity> list=new ArrayList<WordInFileStatEntity>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        paramValue = req.getParameter(nameOfParam);
        resp.getWriter().println("<p><b><h1>Статистика слова в директории</h1></b></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/main\">Главная</a></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/ls\">Локальная статистика файлов</a></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/gs\">Глобальная статистика</a></p>");

            setConnection();
            renderTable(resp);
    }

    public String createTable() {
        String table="";
        for (int i=0;i<list.size();i++)
        {
            table+="<tr> <td>"+list.get(i).getNameOfFile()+"</td> <td>"+list.get(i).getValue()+"</td>";
        }
        return table;
    }

    public ResultSet setConnection()
    {
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String query="SELECT fullnametable.fullfilename, localstatistic.value\n" +
                    "FROM localstatistic\n" +
                    "INNER JOIN fullnametable ON localstatistic.file_id = fullnametable.id \n" +
                    "where localstatistic.word='"+paramValue+"' order by 1;";

            Statement st=connection.createStatement();
            ResultSet res=st.executeQuery(query);
            list.clear();

            while (res.next())
            {
                  list.add(new WordInFileStatEntity(res.getString(1),res.getInt(2)));
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
                        "   <caption>Глобальная статистика слова: <h1 style=\"margin: 0;\"><b>"+paramValue+"</b></h1> в директории</caption>\n" +
                        "   <tr>\n" +
                        "    <th>Имя файла</th>\n" +
                        "    <th>Значение</th>\n" +
                        "   </tr>\n" +
                        createTable()+
                        "  </table>");
    }
}