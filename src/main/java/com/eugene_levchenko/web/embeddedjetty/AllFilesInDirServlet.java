package com.eugene_levchenko.web.embeddedjetty;

import com.eugene_levchenko.web.embeddedjetty.dao.AllFilesInDirDaoImpl;
import org.eclipse.jetty.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllFilesInDirServlet extends MyServlet {

 AllFilesInDirDaoImpl dao=new AllFilesInDirDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpStatus.OK_200);
        resp.setCharacterEncoding("KOI8-R");
        resp.getWriter().println("<p><b><h1>Локальная статистика файлов</h1></b></p>");
        renderingMenu(resp,NamesOfPages.LOCAL_STATISTIC);
        dao.getData();
        renderTable(resp);
    }

    public String createTable() {
        String table = "";
        for (int i = 0; i < dao.getList().size(); i++) {
            table += "<tr> <td>" + dao.getList().get(i).getId() + "</td> <td><a href=\"http://localhost:8080/lsf?id=" +
                    dao.getList().get(i).getId() + "\">" +
                    dao.getList().get(i).getNameOfFile() + "</a></td>";
        }
        return table;
    }

    public void renderTable(HttpServletResponse resp) throws IOException {
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Список файлов в директории</caption>\n" +
                        "   <tr>\n"+
                        "    <th>id</th>\n"+
                        "    <th>Имя файла</th>\n"+
                        "   </tr>\n"+
                        createTable()+
                        "  </table>");
    }
}