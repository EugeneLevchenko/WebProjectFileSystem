package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;
import com.eugene_levchenko.web.embeddedjetty.enums.EDataType;

import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DAOBase<E,T> implements IDAOBase<E,T> {

    static Map<Class<?>,DAODescriptionEntity> map = new HashMap<>();
    private Class<E> classz;

    private void populateEntityMetadata(){
        if (map.get(classz)!=null)
        {
            return;
        }
        synchronized (map) {
            if (map.get(classz)!=null)
            {
                return;
            }
            DAODescriptionEntity de = new DAODescriptionEntity(classz);
            map.put(classz, de);
        }
    }

    public DAOBase(Class<E> classz) {
        this.classz = classz;
        populateEntityMetadata();
    }

    //customhiberdb
    //webprojectfilesystemdb

    public final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;
    }

    public List<E> getAllById(T paramValue) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String selectQueryGetAllById=map.get(classz).getSelectQueryGetAllById(classz);
        PreparedStatement preparedStatement = getConnection().prepareStatement(selectQueryGetAllById);
        fillPreparedStatement(paramValue,preparedStatement);
        ResultSet res = preparedStatement.executeQuery();
        return getListOfEntities(res);
    }

    private void fillPreparedStatement( T paramValue,PreparedStatement preparedStatement) throws SQLException {
        EDataType dataType=map.get(classz).getTypeOfId();
        switch (dataType) {
            case INTEGER:
                preparedStatement.setInt(1, Integer.parseInt((String.valueOf(paramValue))));
                break;
            case STRING:
                preparedStatement.setString(1, (String.valueOf(paramValue)));
                break;
        }
    }

    public List<E> getAll() throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Statement st=getConnection().createStatement();
        ResultSet res=st.executeQuery(map.get(classz).getSelectQueryGetAll(classz));
        return  getListOfEntities(res);
    }

    private E initObj(ResultSet res,Constructor constructorByDefault, DAODescriptionColumn[] descriptionOfColumn) throws IllegalAccessException, InvocationTargetException, InstantiationException, SQLException
    {
        Object obj= constructorByDefault.newInstance();
        for (int i=0;i<descriptionOfColumn.length;i++)
        {
            DAODescriptionColumn daoDescriptionColumn= descriptionOfColumn[i];
            EDataType dataType=daoDescriptionColumn.getDataType();
            Method setter=daoDescriptionColumn.getSetter();
            switch (dataType) {
                case INTEGER:
                    setter.invoke(obj,res.getInt(i+1));
                    break;
                case STRING:
                    setter.invoke(obj,res.getString(i+1));
                    break;
            }
        }
        return (E) obj;
    }

    private List<E> getListOfEntities(ResultSet res) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<E> list=new ArrayList<>();
        DAODescriptionEntity daoDescriptionEntity=map.get(classz);
        Constructor constructor=daoDescriptionEntity.getConstructor();
        DAODescriptionColumn[] descriptionOfColumn = daoDescriptionEntity.getDescrOfColumn();

        while (res.next())
        {
            E entity=initObj(res,constructor,descriptionOfColumn);
            list.add(entity);
        }
        return list;
    }
}