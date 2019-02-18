package com.eugene_levchenko.web.embeddedjetty.ormController;

import com.eugene_levchenko.web.embeddedjetty.annotations.Column;
import com.eugene_levchenko.web.embeddedjetty.annotations.Entity;
import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOBase;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertCustomHiber extends DAOBase {


    public <T,O> void add(T data,O obj) throws SQLException {

        String tableName="";
        String columnName="";

        //get Table name
        if (obj.getClass().isAnnotationPresent(Entity.class)&&obj.getClass().isAnnotationPresent(Table.class))
        {
            //name of table
            Table anno = obj.getClass().getAnnotation(Table.class);
            tableName=anno.name();
        }

        //get Column name
        Field[] arrOfFields = obj.getClass().getDeclaredFields();

        for (int i=0;i<arrOfFields.length;i++)
        {
            if (arrOfFields[i].isAnnotationPresent(Column.class)) {
                Column annotationColumn = arrOfFields[i].getAnnotation(Column.class);
                columnName=annotationColumn.name();
            }
        }

        String query = " insert into "+tableName+" ("+columnName+")"
                + " values (?)";

        PreparedStatement preparedStmt = getConnection().prepareStatement(query);
        preparedStmt.setString (1, (String) data);
        preparedStmt.execute();
    }


}
