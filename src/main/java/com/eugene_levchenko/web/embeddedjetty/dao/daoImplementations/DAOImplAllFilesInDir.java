package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOAllFilesInDirEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;
import org.hibernate.SessionFactory;

//with hiber

public class DAOImplAllFilesInDir extends DAOBase<EntityAllFilesInDir, Integer> implements IDAOAllFilesInDirEntity {
    public DAOImplAllFilesInDir(SessionFactory factory, Class classz) {
        super(factory, classz);
    }

}