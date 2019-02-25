package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface IDAOBase<E,T>  {

    List<E> getAllById(T paramValue) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException;

    List <E> getAll() throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
