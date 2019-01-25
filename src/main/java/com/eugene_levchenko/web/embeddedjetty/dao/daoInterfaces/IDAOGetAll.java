package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import java.sql.SQLException;
import java.util.List;

public interface IDAOGetAll<T> {

    List<T> getAll() throws SQLException;

}
