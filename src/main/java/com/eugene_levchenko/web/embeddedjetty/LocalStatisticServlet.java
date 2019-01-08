package com.eugene_levchenko.web.embeddedjetty;

import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class LocalStatisticServlet extends HttpServlet {
    final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    final static String USERNAME = "root";
    final static String PASSWORD = "root";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Локальная статистика файлов</h1></b></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/main\">Главная</a></p>");

//
        try {
            renderTable(resp,setConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String createTable(ResultSet res) throws SQLException {
        String table="";
        while (res.next())
        {
            table+="<tr> <td>"+res.getInt(1)+"</td> <td><a href=\"http://localhost:8080/lsf?id="+res.getInt(1)+"\">"+res.getString(2)+"</a></td>";
        }
        return table;
    }

    public ResultSet setConnection()
    {
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String query="select * from fullnametable order by 1;";
            Statement st=connection.createStatement();
            ResultSet res=st.executeQuery(query);
            resultSet=res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void renderTable( HttpServletResponse resp,ResultSet res) throws IOException, SQLException {
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Список файлов в директории</caption>\n" +
                        "   <tr>\n" +
                        "    <th>id</th>\n" +
                        "    <th>Имя файла</th>\n" +
                        "   </tr>\n" +
                        createTable(res)+
                        "  </table>");
    }

}
