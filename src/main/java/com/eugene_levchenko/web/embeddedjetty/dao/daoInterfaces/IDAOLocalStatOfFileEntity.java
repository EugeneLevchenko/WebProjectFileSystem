package com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces;

import com.eugene_levchenko.web.embeddedjetty.entities.EntityLocalStatOfFile;

import java.sql.SQLException;
import java.util.List;

public interface IDAOLocalStatOfFileEntity extends IDAOBase<EntityLocalStatOfFile,Integer>
{

    public List<EntityLocalStatOfFile> getLocalStatByFileId(Integer fileId);
    public List<EntityLocalStatOfFile> getLocalStatisticsByWord(String word);
}
