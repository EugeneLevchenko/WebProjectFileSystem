package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.annotations.*;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;
import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DAOBase<E,T> implements IDAOBase<E,T> {

    private static Class<?> ENTITY_CLASS;

    @SuppressWarnings("unchecked")
    private Class<E> getGenericTypeClass() {
        if (ENTITY_CLASS!=null)
        {
            ENTITY_CLASS=null;
           // return (Class<E>) ENTITY_CLASS;
        }
        try {
            synchronized (this) {
               if (ENTITY_CLASS != null) {
                    return (Class<E>) ENTITY_CLASS;
                }
                String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
                ENTITY_CLASS = Class.forName(className);
            }
            return (Class<E>) ENTITY_CLASS;
        } catch (Exception e) {
            throw new IllegalStateException("Class is not parametrized with generic type!!! Please use extends <> ");
        }
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

    @Override
    public List getAllById(T paramValue) throws SQLException {
        return null;
    }

    public List<E> getAll() throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<E>  entityClass=getGenericTypeClass();

        Statement st=getConnection().createStatement();
        ResultSet res=st.executeQuery(getSelectQuery(entityClass ));

        Constructor constructors[]=entityClass.getDeclaredConstructors();
        Constructor constructorByDefault=constructors[0];

        Field[] fields= entityClass.getDeclaredFields();
        Field[] annotatedFields=new Field[fields.length];

        int lengthOfFields=0;
        for (int i=0;i<fields.length;i++)
        {
            if (fields[i].isAnnotationPresent(Column.class)||fields[i].isAnnotationPresent(Id.class))
            {
                annotatedFields[lengthOfFields]=fields[i];
                lengthOfFields++;
            }
        }

        Method[] allMethods=entityClass.getDeclaredMethods();
        Method[] getters=new Method[allMethods.length];
        int lengthGetters=0;

        for (int i=0;i<allMethods.length;i++)
        {
            if (isGetter(allMethods[i]))
            {
                getters[lengthGetters]=allMethods[i];
                lengthGetters++;
            }
        }

        Method[] setters=new Method[allMethods.length];
        int lengthSetters=0;

        for (int i=0;i<allMethods.length;i++)
        {
            if (isSetter(allMethods[i]))
            {
                setters[lengthSetters]=allMethods[i];
                lengthSetters++;
            }
        }

        DAODescriptionColumn[] descriptionOfColumn=new DAODescriptionColumn[lengthOfFields];

        for (int i=0;i<annotatedFields.length;i++)
        {
            Column column=annotatedFields[i].getAnnotation(Column.class);
            int index=getSettersIndex(annotatedFields,i,setters);
            DAODescriptionColumn columnObj=  new DAODescriptionColumn(column.name(),annotatedFields[i].getName(),
                    getters[index],setters[index],column.type());
            descriptionOfColumn[i]=columnObj;
        }
        List<E> list=new ArrayList<>();
        while (res.next())
        {
            E entity=initObj(res,constructorByDefault,descriptionOfColumn);
            list.add(entity);
        }

        return list;
    }

    private static boolean isSetter(Method method) {
        return Modifier.isPublic(method.getModifiers()) &&
                method.getReturnType().equals(void.class) &&
                method.getParameterTypes().length == 1 &&
                //  method.getName().matches("^set[A-Z].*") &&
                method.getName().startsWith("set");
    }

    private static boolean isGetter(Method method) {
        return Modifier.isPublic(method.getModifiers()) &&
                !method.getReturnType().equals(void.class) &&
                method.getParameterTypes().length == 0 &&
                //  method.getName().matches("^set[A-Z].*") &&
                method.getName().startsWith("get");
    }

    private E initObj(ResultSet res,Constructor constructorByDefault, DAODescriptionColumn[] descriptionOfColumn) throws IllegalAccessException, InvocationTargetException, InstantiationException, SQLException
    {
        Object obj= constructorByDefault.newInstance();
        for (int i=0;i<descriptionOfColumn.length;i++)
        {
            EDataType dataType=descriptionOfColumn[i].getDataType();
              Method setter=descriptionOfColumn[i].getSetter();
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

    private String getListOfColumns(Class<E> entityClass)
    {
        String result="";
        Field[] arrOfFields = entityClass.getDeclaredFields();

        for (int i=0;i<arrOfFields.length;i++)
        {
            Field field=arrOfFields[i];
            if (field.isAnnotationPresent(Column.class))
            {
                Column annotationColumn = field.getAnnotation(Column.class);
                result+= annotationColumn.name()+",";
            }

            if (field.isAnnotationPresent(Id.class))
            {
                Id annotationColumn = field.getAnnotation(Id.class);
                result+=annotationColumn.name()+",";
            }
        }
        result=result.substring(0, result.length() - 1);
        return result;
    }

    private String getSelectQuery(Class<E> clazz)
    {
        Table anno = clazz.getAnnotation(Table.class);
        String tableName=anno.name();
        String query="select "+getListOfColumns(clazz)+" from "+tableName+" order by 1;";
        return query;
    }

    private int getSettersIndex(Field[] arr, int index, Method[] setters)
    {
        String fieldName= arr[index].getName();
        for (int i=0;i<setters.length;i++)
        {
            String nameSetter=setters[i].getName().substring(3);
            nameSetter = Character.toLowerCase(nameSetter.charAt(0)) + nameSetter.substring(1);

            if (nameSetter.equals(fieldName))
            {
                return i;
            }
        }
        return -1;
    }
}