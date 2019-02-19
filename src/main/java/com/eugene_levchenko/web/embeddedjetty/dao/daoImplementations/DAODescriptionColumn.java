package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;

import java.lang.reflect.Method;

public class DAODescriptionColumn {

   private String columnName;
   private String fieldName;

   private Method getter;
   private Method setter;

   private EDataType dataType;

    public DAODescriptionColumn(String columnName, String fieldName, Method getter, Method setter, EDataType dataType) {
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.getter = getter;
        this.setter = setter;
        this.dataType = dataType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Method getGetter() {
        return getter;
    }

    public void setGetter(Method getter) {
        this.getter = getter;
    }

    public Method getSetter() {
        return setter;
    }

    public void setSetter(Method setter) {
        this.setter = setter;
    }

    public EDataType getDataType() {
        return dataType;
    }

    public void setDataType(EDataType dataType) {
        this.dataType = dataType;
    }
}
