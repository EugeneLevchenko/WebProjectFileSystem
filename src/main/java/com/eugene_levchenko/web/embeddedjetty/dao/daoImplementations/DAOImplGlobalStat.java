package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGlobalStatEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOImplGlobalStat extends DAOBase<EntityGlobalStat,String> implements IDAOGlobalStatEntity {

}