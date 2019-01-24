package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOFileNameEntity;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOSelectWithParam;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOImplLocalStat extends DAOBase implements IDAOSelectWithParam, IDAOFileNameEntity {
    @Override
    public List<EntityLocalStatOfFile> getDataFromSelectByValue(int paramValue) {
        List<EntityLocalStatOfFile> list = new ArrayList<EntityLocalStatOfFile>();

        try {
            String query="SELECT word,value FROM webprojectfilesystemdb.localstatistic where file_id=" +
                    ""+paramValue+" order by 1;";
            Statement st=getConnection().createStatement();
            ResultSet res=st.executeQuery(query);
            list.clear();
            while (res.next())
            {
                list.add(new EntityLocalStatOfFile(res.getString(1),res.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getFileNameById(int id) throws SQLException {

        String fileName="";

        String queryGetFileName="SELECT fullfilename FROM webprojectfilesystemdb.fullnametable where id="+ id +";";

        Statement st2=getConnection().createStatement();
        ResultSet res2=st2.executeQuery(queryGetFileName);

        while (res2.next())
        {
            fileName=res2.getString(1);
        }

        System.out.println(fileName);

        return fileName;
    }
}
