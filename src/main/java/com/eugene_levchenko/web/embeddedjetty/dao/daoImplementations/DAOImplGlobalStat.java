package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGlobalStatEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;
import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class DAOImplGlobalStat extends DAOBase<EntityGlobalStat, String> implements IDAOGlobalStatEntity {
    public DAOImplGlobalStat(SessionFactory factory, Class<EntityGlobalStat> classz) {
        super(factory, EntityGlobalStat.class);
    }

    @Override
    public List<EntityGlobalStat> getAllById(String paramValue) throws SQLException {
        return null;
    }

    // @Override
  //  public List<EntityGlobalStat> getAllById(String paramValue) throws SQLException {
    //    return null;
  //  }



    /*
    private final SessionFactory factory;
    public DAOImplGlobalStat(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final EntityGlobalStat entity) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public EntityGlobalStat read(@NotNull final String word) {
        try (final Session session = factory.openSession()) {
            final EntityGlobalStat result = session.get(EntityGlobalStat.class, word);
            return result ;
        }
    }

    @Override
    public void update(@NotNull final EntityGlobalStat entity) {
        entity.setWord("eprst");
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final EntityGlobalStat entity) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<EntityGlobalStat> getAll() {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from EntityGlobalStat");
            List<EntityGlobalStat> list = query.list();
            return list;
        }
    }
    */
}