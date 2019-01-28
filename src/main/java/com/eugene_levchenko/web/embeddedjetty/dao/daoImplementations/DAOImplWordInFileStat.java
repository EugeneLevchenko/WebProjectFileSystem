package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGetById;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityWordInFileStat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOImplWordInFileStat extends DAOBase implements IDAOGetById {

    @Override
    public List<EntityWordInFileStat> getAllById(Object paramValue) throws SQLException {
        List<EntityWordInFileStat> list = new ArrayList<EntityWordInFileStat>();

        /*
            String query=
                    "SELECT fullnametable.fullfilename, localstatistic.value\n" +
                            "FROM localstatistic\n" +
                            "INNER JOIN fullnametable ON localstatistic.file_id = fullnametable.id \n" +
                            "where localstatistic.word='"+paramValue+"' order by 1;";

            Statement st=getConnection().createStatement();
            ResultSet res=st.executeQuery(query);
            list.clear();
*/

        String query=
                "SELECT fullnametable.fullfilename, localstatistic.value\n" +
                        "FROM localstatistic\n" +
                        "INNER JOIN fullnametable ON localstatistic.file_id = fullnametable.id \n" +
                        "where localstatistic.word=?";

        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setString(1, (String) paramValue);
        ResultSet rs = preparedStatement.executeQuery();
        list.clear();

            while (rs.next())
            {
                list.add(new EntityWordInFileStat(rs.getString(1),rs.getInt(2)));
            }

        return list;
    }
}