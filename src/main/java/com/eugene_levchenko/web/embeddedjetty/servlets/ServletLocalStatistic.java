package com.eugene_levchenko.web.embeddedjetty.servlets;

import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplAllFilesInDir;
import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOImplLocalStat;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOAllFilesInDirEntity;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOLocalStatOfFileEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;
import com.eugene_levchenko.web.embeddedjetty.enums.ENamesOfPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public  class ServletLocalStatistic extends ServletBaseWithTableWithParam {
    @Autowired
    private IDAOLocalStatOfFileEntity daoLocalStat;
    @Autowired
   private IDAOAllFilesInDirEntity daoFiles;

    private static String nameOfParam="id";

    public String createTable(Integer fileId)  {
        List<EntityLocalStatOfFile> list=daoLocalStat.getLocalStatByFileId(fileId);
        String table="";

        for (EntityLocalStatOfFile i: list)
        {
            String word=i.getWord();
            table+="<tr> <td>"+"<a href=\"wsf?word="
                    +word+"\">"
                    +word+"</a>"+"</td> <td>"
                    +i.getValue()+"</td>";
        }
        return table;
    }

    @Override
    protected ENamesOfPages getExcludedMenuItem() {
        return ENamesOfPages.LOCAL_STATISTIC;
    }

@Override
    public void renderTable(HttpServletResponse resp,HttpServletRequest req) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
          Integer fileId = Integer.parseInt( getParam(req,nameOfParam));
            System.out.println(fileId);
            resp.getWriter().println(
                    " <table border=\"1\">\n" +
                            "   <caption>Статистика слов в файле: "
                            +daoFiles.getById(fileId).getNameOfFile()+"</caption>\n" +
                            "   <tr>\n" +
                            "    <th>Слово</th>\n" +
                            "    <th>Значение</th>\n" +
                            "   </tr>\n" +
                            createTable(fileId)+
                            "  </table>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getCaptionPage() {
        return "Локальная статистика слов по файлу";
    }

}