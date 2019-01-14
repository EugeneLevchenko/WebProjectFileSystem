package com.eugene_levchenko.web.embeddedjetty;

import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class LocalStatisticServlet extends MyServlet {

    ArrayList<LocalStatEntity> list = new ArrayList<LocalStatEntity>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Локальная статистика файлов</h1></b></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/main\">Главная</a></p>");
        resp.getWriter().println("<p><a href=\"http://localhost:8080/gs\">Глобальная статистика</a></p>");
        setConnection();
        renderTable(resp);
    }

    public String createTable() {

        String table = "";

        for (int i = 0; i < list.size(); i++) {

            table += "<tr> <td>" + list.get(i).id + "</td> <td><a href=\"http://localhost:8080/lsf?id=" +
                    list.get(i).id + "\">" +
                    list.get(i).name + "</a></td>";
        }
        return table;
    }

    public ResultSet setConnection() {
        ResultSet resultSet = null;
        try {

            String query = "select * from fullnametable order by 1;"; //
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            list.clear();

            while (res.next()) {
                list.add(new LocalStatEntity(res.getInt(1), res.getString(2)));
            }
            resultSet = res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void renderTable(HttpServletResponse resp) throws IOException {
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Список файлов в директории</caption>\n" +
                        "   <tr>\n" +
                        "    <th>id</th>\n" +
                        "    <th>Имя файла</th>\n" +
                        "   </tr>\n" +
                        createTable() +
                        "  </table>");
    }
}