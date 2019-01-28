package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import java.sql.SQLException;
import java.util.List;

public interface IDAOGetById<E,T>  {

    List<E> getAllById(T paramValue) throws SQLException;

}
