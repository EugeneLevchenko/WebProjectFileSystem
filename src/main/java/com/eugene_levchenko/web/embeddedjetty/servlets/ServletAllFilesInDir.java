package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplAllFilesInDir;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOAllFilesInDirEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@Component
public class ServletAllFilesInDir extends ServletBaseWithTable{
    @Autowired
    IDAOAllFilesInDirEntity dao;
   // IDAOAllFilesInDirEntity dao=new DAOImplAllFilesInDir(factory,EntityAllFilesInDir.class);

    public String createTable() throws SQLException {
        String table = "";
        List<EntityAllFilesInDir> list = dao.getAll();

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
    protected void renderTable(HttpServletResponse resp) throws IOException, SQLException {
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
    protected ENamesOfPages getExcludedMenuItem() {
       return ENamesOfPages.LOCAL_STATISTIC;
    }

    @Override
    protected String getCaptionPage() {
         return "Статистика файлов в директории";
    }
}
