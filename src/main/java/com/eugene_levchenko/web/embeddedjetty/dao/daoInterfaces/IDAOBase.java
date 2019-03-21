package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface IDAOBase<E,K>  {


   E getById(K key);
    List<E> getAll() throws SQLException;
}
