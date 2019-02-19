package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.entities.EntityAllFilesInDir;

import java.lang.reflect.Constructor;

public class DAODescriptionEntity {

    private DAODescriptionColumn[] descrOfColumn;

    private String tableName;

    Constructor constructorEntity;

    public DAODescriptionColumn[] getDescrOfColumn() {
        return descrOfColumn;
    }

    public void setDescrOfColumn(DAODescriptionColumn[] descrOfColumn) {
        this.descrOfColumn = descrOfColumn;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Constructor getConstructorEntity() {
        return constructorEntity;
    }

    public void setConstructorEntity(Constructor constructorEntity) {
        this.constructorEntity = constructorEntity;
    }
}
