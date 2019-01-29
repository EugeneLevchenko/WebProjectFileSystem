package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ServletBaseWithTable extends ServletBase {


    public void renderTable(HttpServletResponse resp,Object dao) throws IOException {
        try {
            resp.getWriter().println(
                    " <table border=\"1\">\n" +
                            "   <caption>Список файлов в директории</caption>\n" +
                            "   <tr>\n"+
                            "    <th>id</th>\n"+
                            "    <th>Имя файла</th>\n"+
                            "   </tr>\n"+
                            createTable(dao)+
                            "  </table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String createTable(Object dao) throws SQLException {
        String table = "";
        List<EntityAllFilesInDir> list=dao.getAll();

        for (EntityAllFilesInDir i: list)
        {
            int id=i.getId();
            table += "<tr> <td>" +
                    id + "</td> <td><a href=\"http://localhost:8080/lsf?id=" +
                    id + "\">" +
                    i.getNameOfFile() + "</a></td>";
        }

        return table;
    }
}