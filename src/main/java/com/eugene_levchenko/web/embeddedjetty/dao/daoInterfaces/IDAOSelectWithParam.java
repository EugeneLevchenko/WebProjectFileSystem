package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import java.sql.SQLException;
import java.util.List;

public interface IDAOSelectWithParam<T>  {

    List<T> getDataFromSelectByValue(int paramValue) throws SQLException;

}
