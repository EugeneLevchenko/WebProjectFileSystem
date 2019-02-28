package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import java.util.List;

public interface DAO<E, K> {
    void create(E entity);
    E read(K key);
    void update(E entity);
    void delete(E entity);
    List<E> getAll();
}