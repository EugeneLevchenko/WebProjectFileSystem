package com.eugene_levchenko.web.embeddedjetty.dao;

import com.eugene_levchenko.web.embeddedjetty.Entities.LocalStatEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AllFilesInDirDaoImpl extends BaseDao {

    private ArrayList<LocalStatEntity> list = new ArrayList<LocalStatEntity>();

    @Override
    public void getData() {
        try {
            String query = "select * from fullnametable order by 1;";
            Statement st = getConnection().createStatement();
            ResultSet res = st.executeQuery(query);
            list.clear();
            while (res.next()) {
                list.add(new LocalStatEntity(res.getInt(1), res.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LocalStatEntity> getList() {
        return list;
    }
}
