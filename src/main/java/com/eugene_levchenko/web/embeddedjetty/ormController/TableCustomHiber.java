package com.eugene_levchenko.web.embeddedjetty.ormController;

import com.eugene_levchenko.web.embeddedjetty.annotations.Column;
import com.eugene_levchenko.web.embeddedjetty.annotations.Entity;
import com.eugene_levchenko.web.embeddedjetty.annotations.Id;
import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations.DAOBase;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCustomHiber extends DAOBase {

   private static String[] ARRAY_OF_DATA_TYPES = {"INT","VARCHAR(255)"};

   private static String[] ARRAY_OF_GENERATION_ID = {"INT NOT NULL AUTO_INCREMENT PRIMARY KEY","INT"};

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
      boolean idWasFound=false;
        System.out.println(isIdPresent(arrOfFields));

        for (int i=0;i<arrOfFields.length;i++)
        {

            if (isIdPresent(arrOfFields)&&!idWasFound)
            {

                Id annotationColumn = arrOfFields[i].getAnnotation(Id.class);
                //System.out.println(annotationColumn.name());
                int index= EGenerationType.valueOf(String.valueOf(annotationColumn.strategy())).ordinal();
                String s= ARRAY_OF_GENERATION_ID[index];
                queryInfoOfColumns+=annotationColumn.name()+" "+s+",";
                idWasFound=true;
            }
          //  if (!idWasFound)
           // {
           //     continue;
         //   }

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
        //delete the last element
        queryInfoOfColumns= queryInfoOfColumns.replaceFirst(".$","");
        System.out.println(queryInfoOfColumns);
        return queryInfoOfColumns;
    }

public boolean isIdPresent(Field[] arrOfFields)
{
    for (int i=0;i<arrOfFields.length;i++)
    {
        if (arrOfFields[i].isAnnotationPresent(Id.class))
        {
            return true;
        }
    }
   return false;
}

    public static String[] getArrayOfDataTypes() {
        return ARRAY_OF_DATA_TYPES;
    }

    public static String[] getArrayOfGenerationId() {
        return ARRAY_OF_GENERATION_ID;
    }
}