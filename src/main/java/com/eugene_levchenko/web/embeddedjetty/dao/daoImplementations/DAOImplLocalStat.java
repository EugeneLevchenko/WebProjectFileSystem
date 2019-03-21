package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOLocalStatOfFileEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.lang.invoke.ConstantCallSite;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class DAOImplLocalStat extends DAOBase<EntityLocalStatOfFile, Integer> implements IDAOLocalStatOfFileEntity {

    public DAOImplLocalStat() {
        super(EntityLocalStatOfFile.class);
    }

    @Override
    public List<EntityLocalStatOfFile> getLocalStatByFileId(Integer fileId) {

        try (Session session = factory.openSession()) {
            Criteria criteria = session.createCriteria(classz).add(Restrictions.eq("fileId", fileId));
            List<EntityLocalStatOfFile> list = criteria.list();
            System.out.println(list);
            return list;

        }
    }

    @Override
    public List<EntityLocalStatOfFile> getLocalStatisticsByWord(String word) {
        try (Session session = factory.openSession()) {
            Criteria criteria = session.createCriteria(classz).add(Restrictions.eq("word", word));
            List<EntityLocalStatOfFile> list = criteria.list();
            System.out.println(list);
            return list;

        }
    }

    @Override
    public List<EntityLocalStatOfFile> getAll() {
        return null;
    }

}