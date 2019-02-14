package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAOBase<E,T> implements IDAOBase<E,T> {
    //customhiberdb
//webprojectfilesystemdb
    public final static String URL = "jdbc:mysql://localhost:3306/webprojectfilesystemdb";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL ,USERNAME,PASSWORD);
        return connection;
    }

    @Override
    public List getAllById(T paramValue) throws SQLException {
        return null;
    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }
    /*

    @Override
    public List<EntityGlobalStat> getAll() throws SQLException {
        List<EntityGlobalStat> list=new ArrayList<>() ;

        Table anno = entityObj.getClass().getAnnotation(Table.class);
        String tableName=anno.name();

        String query="select * from "+tableName+" order by 1;";
        Statement st=getConnection().createStatement();
        ResultSet res=st.executeQuery(query);
        list.clear();
        System.out.println("after clear: "+list);
        while (res.next())
        {
            list.add(new EntityGlobalStat(res.getString(1),res.getInt(2)));
        }
        return list;
    }


    */
}