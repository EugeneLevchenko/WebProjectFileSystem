package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAOBase <E,K> implements IDAOBase<E,K> {
    protected final SessionFactory factory;
    protected Class<E> classz;

    public DAOBase(SessionFactory factory, Class<E> classz) {
        this.factory = factory;
        this.classz = classz;
    }

    public List<E> getAll() {
        try (Session session = factory.openSession()) {
            CriteriaQuery<E> criteriaQuery = session.getCriteriaBuilder().createQuery(classz);
            criteriaQuery.from(classz);
            List<E> list = session.createQuery(criteriaQuery).getResultList();
            ////////////////

            return list;
        }
    }


    public List<E> getById(K param)
    {




        return null;
    }


    public final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL ,USERNAME,PASSWORD);
        return connection;
    }
}