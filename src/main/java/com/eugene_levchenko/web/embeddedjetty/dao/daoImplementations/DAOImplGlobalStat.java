package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGlobalStatEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;
import org.hibernate.SessionFactory;

public class DAOImplGlobalStat extends DAOBase<EntityGlobalStat, String> implements IDAOGlobalStatEntity {
    public DAOImplGlobalStat(SessionFactory factory, Class<EntityGlobalStat> classz) {
        super(factory, EntityGlobalStat.class);
    }

}