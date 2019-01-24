package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOImplGlobalStat extends DAOBase implements IDAOBase {

    @Override
    public List<EntityGlobalStat> getAll() throws SQLException {
        List<EntityGlobalStat> list=new ArrayList<EntityGlobalStat>() ;
        String query="select * from filestatistic order by 1;";
        Statement st=getConnection().createStatement();
        ResultSet res=st.executeQuery(query);
        list.clear();
        System.out.println("after clear: "+list);
        while (res.next())
        {
            list.add(new EntityGlobalStat(res.getString(1),res.getInt(2)));
        }
        return list;
    }

}