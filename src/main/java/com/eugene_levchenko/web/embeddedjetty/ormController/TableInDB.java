package com.eugene_levchenko.web.embeddedjetty.ormController;

import com.eugene_levchenko.web.embeddedjetty.annotations.Column;
import com.eugene_levchenko.web.embeddedjetty.annotations.Entity;
import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOBase;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;

public class TableInDB extends DAOBase {

    static String[] ARRAY_OF_DATA_TYPES = {"INT","VARCHAR(255)"};
    public  <O> void createTableIfDoesNotExist(O obj) throws SQLException {

        if (obj.getClass().isAnnotationPresent(Entity.class)&&obj.getClass().isAnnotationPresent(Table.class))
        {
            //name of table
            Table anno = obj.getClass().getAnnotation(Table.class);
            String tableName=anno.name();
            String createTableSQL="CREATE TABLE IF NOT EXISTS "+tableName+"("+getQueryInfoOfColumns(obj)+");";
            Statement stmt = getConnection().createStatement();
            stmt.execute(createTableSQL);
        }
    }

   <O> String getQueryInfoOfColumns(O obj)
    {
        //name and type of column
        Field[] arrOfFields = obj.getClass().getDeclaredFields();
        String queryInfoOfColumns = "";
        for (int i=0;i<arrOfFields.length;i++)
        {
            if (arrOfFields[i].isAnnotationPresent(Column.class))
            {
                Column annotationColumn = arrOfFields[i].getAnnotation(Column.class);
                System.out.println(annotationColumn.name());
                System.out.println(annotationColumn.type());
                int index= EDataType.valueOf(String.valueOf(annotationColumn.type())).ordinal();
                String s= ARRAY_OF_DATA_TYPES[index];
                System.out.println(s);

                queryInfoOfColumns+=annotationColumn.name()+" "+s+",";
                System.out.println(queryInfoOfColumns);
            }
        }
        queryInfoOfColumns= queryInfoOfColumns.replaceFirst(".$","");
        System.out.println(queryInfoOfColumns);
        return queryInfoOfColumns;
    }


}