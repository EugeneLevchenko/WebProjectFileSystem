package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;


import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOSelectWithParam;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityWordInFileStat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOImplWordInFileStat extends DAOBase implements IDAOSelectWithParam {

    @Override
    public List<EntityWordInFileStat> getDataFromSelectByValue(int paramValue) throws SQLException {
        List<EntityWordInFileStat> list = new ArrayList<EntityWordInFileStat>();
            String query=
                    "SELECT fullnametable.fullfilename, localstatistic.value\n" +
                            "FROM localstatistic\n" +
                            "INNER JOIN fullnametable ON localstatistic.file_id = fullnametable.id \n" +
                            "where localstatistic.word='"+paramValue+"' order by 1;";

            Statement st=getConnection().createStatement();
            ResultSet res=st.executeQuery(query);
            list.clear();

            while (res.next())
            {
                list.add(new EntityWordInFileStat(res.getString(1),res.getInt(2)));
            }

        return list;
    }


}
