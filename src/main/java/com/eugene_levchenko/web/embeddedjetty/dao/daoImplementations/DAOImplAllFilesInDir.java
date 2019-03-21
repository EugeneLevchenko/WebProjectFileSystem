package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOAllFilesInDirEntity;
import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class DAOImplAllFilesInDir extends DAOBase<EntityAllFilesInDir, Integer> implements IDAOAllFilesInDirEntity {
    public DAOImplAllFilesInDir( ) {
        super( EntityAllFilesInDir.class);
    }

}