package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAOBase <E,K> implements IDAOBase<E,K> {
    private final SessionFactory factory;
    private Class<E> classz;

    public DAOBase(SessionFactory factory, Class<E> classz) {
        this.factory = factory;
        this.classz = classz;
    }

    public List<E> getAll() {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from "+classz.getName());
            List<EntityGlobalStat> list = query.list();
            return (List<E>) list;
        }
    }

    public final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL ,USERNAME,PASSWORD);
        return connection;
    }
}