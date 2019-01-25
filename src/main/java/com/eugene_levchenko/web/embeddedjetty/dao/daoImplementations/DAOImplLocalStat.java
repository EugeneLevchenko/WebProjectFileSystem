package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGetFileNameById;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGetAllById;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOImplLocalStat extends DAOBase implements IDAOGetAllById, IDAOGetFileNameById {

    @Override
    public List<EntityLocalStatOfFile> getAllById(Object paramValue) {
        List<EntityLocalStatOfFile> list = new ArrayList<EntityLocalStatOfFile>();

        try {
            String selectSQL = "SELECT word,value FROM webprojectfilesystemdb.localstatistic where file_id=?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(selectSQL);
            preparedStatement.setInt(1, Integer.parseInt((String.valueOf(paramValue))));
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                list.add(new EntityLocalStatOfFile(rs.getString(1),rs.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getFileNameById(int id) throws SQLException {

        String fileName="";
        String queryGetFileName="SELECT fullfilename FROM webprojectfilesystemdb.fullnametable where id=?";

        PreparedStatement preparedStatement = getConnection().prepareStatement(queryGetFileName);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next())
        {
            fileName=rs.getString(1);
        }

        System.out.println(fileName);

        return fileName;
    }
}
