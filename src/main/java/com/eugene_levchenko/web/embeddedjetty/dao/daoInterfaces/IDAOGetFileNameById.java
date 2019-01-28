package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import java.sql.SQLException;

public interface IDAOGetFileNameById extends IDAOGetById
{
    String getFileNameById(int id) throws SQLException;
}
