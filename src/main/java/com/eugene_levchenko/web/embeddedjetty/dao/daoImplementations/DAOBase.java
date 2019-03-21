package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Component
public abstract class DAOBase <E,K> implements IDAOBase<E,K> {
    @Autowired
    protected  SessionFactory factory;

    protected Class<E> classz;

    public DAOBase( Class<E> classz) {

        this.classz = classz;
    }

    public List<E> getAll() {
        try (Session session = factory.openSession()) {
            CriteriaQuery<E> criteriaQuery = session.getCriteriaBuilder().createQuery(classz);
            criteriaQuery.from(classz);
            List<E> list = session.createQuery(criteriaQuery).getResultList();
            return list;
        }
    }

@Override
    public E getById(K key) {
       try (Session session = factory.openSession()) {
           E result = session.find(classz,key);
            return result;
    }
    }

}