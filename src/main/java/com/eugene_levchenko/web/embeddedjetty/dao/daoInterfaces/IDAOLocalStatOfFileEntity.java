package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;

import java.sql.SQLException;

public interface IDAOLocalStatOfFileEntity extends IDAOBase<EntityLocalStatOfFile,Integer>
{
    String getFileNameById(int id) throws SQLException;
}
