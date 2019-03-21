package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOGlobalStatEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityGlobalStat;
import org.springframework.stereotype.Component;

@Component
public class DAOImplGlobalStat extends DAOBase<EntityGlobalStat, String> implements IDAOGlobalStatEntity {
    public DAOImplGlobalStat() {
        super( EntityGlobalStat.class);
    }

}