package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import java.sql.SQLException;
import java.util.List;

public interface IDAOBase<E,K>  {

    List<E> getAllById(K paramValue) throws SQLException;


    List<E> getAll() throws SQLException;
}
