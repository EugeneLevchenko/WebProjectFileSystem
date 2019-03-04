package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOLocalStatOfFileEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.lang.invoke.ConstantCallSite;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOImplLocalStat extends DAOBase<EntityLocalStatOfFile, Integer> implements IDAOLocalStatOfFileEntity {

    public DAOImplLocalStat(SessionFactory factory, Class<EntityLocalStatOfFile> classz) {
        super(factory, classz);
    }

    @Override
    public List<EntityLocalStatOfFile> getAllById(Integer paramValue) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        try (Session session = factory.openSession()) {

            Criteria criteria = session.createCriteria(classz).add(Restrictions.eq("fileId", paramValue));
            List<EntityLocalStatOfFile> list = criteria.list();
            System.out.println(list);
            return list;

        }

    }

    @Override
    public List<EntityLocalStatOfFile> getAll() {
        return null;
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