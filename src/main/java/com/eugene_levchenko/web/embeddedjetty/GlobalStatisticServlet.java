package com.eugene_levchenko.web.embeddedjetty;

import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class GlobalStatisticServlet extends HttpServlet {

    final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
    final static String USERNAME = "root";
    final static String PASSWORD = "root";

    ArrayList<GlobalStatEntity> list=new ArrayList<GlobalStatEntity>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException
    {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Глобальная статистика</h1></b></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/main\">Главная</a></p>");
        try {
            renderTable(resp,setConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String createTable(ResultSet res) throws SQLException {
        String table="";
        for (int i=0;i<list.size();i++)
        {
          //  table+="<tr> <td>"+list.get(i).word+"</td> <td>"+list.get(i).value+"</td>";
            table+="<tr> <td>"+"<a href=\"http://localhost:8080/wsf?word="+list.get(i).word+"\">"+list.get(i).word+"</a>"+"</td> <td>"+list.get(i).value+"</td>";//
        }
        return table;
    }

    public ResultSet setConnection()
    {
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String query="select * from filestatistic order by 1;";
            Statement st=connection.createStatement();
            ResultSet res=st.executeQuery(query);
list.clear();
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

    public void renderTable( HttpServletResponse resp,ResultSet res) throws IOException, SQLException {
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Глобальная статистика слов в директории</caption>\n" +
                        "   <tr>\n" +
                        "    <th>Слово</th>\n" +
                        "    <th>Значение</th>\n" +
                        "   </tr>\n" +
                        createTable(res)+
                        "  </table>");
    }
}
