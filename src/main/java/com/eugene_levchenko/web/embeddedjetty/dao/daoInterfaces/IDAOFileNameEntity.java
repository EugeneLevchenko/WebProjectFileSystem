package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import java.sql.SQLException;

public interface IDAOFileNameEntity extends IDAOSelectWithParam
{
    String getFileNameById(int id) throws SQLException;
}
