package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplLocalStat;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOLocalStatOfFileEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public  class ServletWordInFileStatistic extends ServletBaseWithTableWithParam {
    private String nameOfParam="word";
    private IDAOLocalStatOfFileEntity dao=new DAOImplLocalStat(factory, EntityLocalStatOfFile.class);

    public String createTable(String word)  {

        String table="";
        List<EntityLocalStatOfFile> list=dao.getLocalStatisticsByWord(word);

        for (EntityLocalStatOfFile i: list) {
            table+="<tr> <td>"+i.getLocalFile().getNameOfFile()+"</td> <td>"+i.getValue()+"</td>";
        }
        return table;
    }

    @Override
    protected ENamesOfPages getExcludedMenuItem() {
        return ENamesOfPages.ALL_ITEMS;
    }

@Override
    public void renderTable(HttpServletResponse resp, HttpServletRequest req) throws IOException, SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String word=getParam(req,nameOfParam);
        resp.getWriter().println(
                " <table border=\"1\">\n" +
                        "   <caption>Глобальная статистика слова: <h1 style=\"margin: 0;\"><b>"+word+"</b></h1> в директории</caption>\n" +
                        "   <tr>\n" +
                        "    <th>Имя файла</th>\n" +
                        "    <th>Значение</th>\n" +
                        "   </tr>\n" +
                        createTable(word)+
                        "  </table>");
    }

    @Override
    protected String getCaptionPage() {
        return "Статистика слова в файлах";
    }
}