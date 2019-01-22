package com.eugene_levchenko.web.embeddedjetty.dao;

import com.eugene_levchenko.web.embeddedjetty.Entities.GlobalStatEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GlobalStatDaoImpl extends BaseDao {

    private ArrayList<GlobalStatEntity> list ;

    @Override
    public void getData() {
        try {
            String query="select * from filestatistic order by 1;";
            Statement st=getConnection().createStatement();
            ResultSet res=st.executeQuery(query);
            getList().clear();
            System.out.println("after clear: "+getList());
            while (res.next())
            {
                getList().add(new GlobalStatEntity(res.getString(1),res.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<GlobalStatEntity> getList() {
        return list;
    }
}
