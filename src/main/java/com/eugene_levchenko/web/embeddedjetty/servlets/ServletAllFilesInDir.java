package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOAllFilesInDirEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;
import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplAllFilesInDir;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public  class ServletAllFilesInDir extends ServletBaseWithTable {

    IDAOAllFilesInDirEntity dao=new DAOImplAllFilesInDir();
    EntityAllFilesInDir entityAllFilesInDir=new EntityAllFilesInDir(10,"");

    public String createTable() throws SQLException {
        String table = "";
        List<EntityAllFilesInDir> list = dao.getAll(entityAllFilesInDir);

        for (EntityAllFilesInDir i : list) {
            int id = i.getId();
            table += "<tr> <td>" +
                    id + "</td> <td><a href=\"lsf?id=" +
                    id + "\">" +
                    i.getNameOfFile() + "</a></td>";
        }
        return table;
    }

    @Override
    protected ENamesOfPages getExcludedMenuItem() {
        return ENamesOfPages.ALL_ITEMS;
    }

    @Override
    public void renderTable(HttpServletResponse resp) throws IOException {
        try {
            resp.getWriter().println(
                    " <table border=\"1\">\n" +
                            "   <caption>Список файлов в директории</caption>\n" +
                            "   <tr>\n"+
                            "    <th>id</th>\n"+
                            "    <th>Имя файла</th>\n"+
                            "   </tr>\n"+
                            createTable()+
                            "  </table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getCaptionPage() {
        return "Локальная статистика файлов";
    }

}