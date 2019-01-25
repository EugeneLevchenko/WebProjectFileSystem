package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGetAll;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOImplAllFilesInDir extends DAOBase implements IDAOGetAll {
    @Override
    public List<EntityAllFilesInDir> getAll() {
        List<EntityAllFilesInDir> list = new ArrayList<EntityAllFilesInDir>();
        try {
            String query = "select * from fullnametable order by 1;";
            Statement st = getConnection().createStatement();
            ResultSet res = st.executeQuery(query);
            list.clear();
            while (res.next()) {
                list.add(new EntityAllFilesInDir(res.getInt(1), res.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}