package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.annotations.Column;
import com.eugene_levchenko.web.embeddedjetty.annotations.ColumnSetter;
import com.eugene_levchenko.web.embeddedjetty.annotations.Id;
import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.dao.daoInterfaces.IDAOBase;

import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DAOBase<E,T> implements IDAOBase<E,T> {


    @SuppressWarnings("unchecked")
    private Class<E> getGenericTypeClass() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<E>) clazz;
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
        List<E> list=new ArrayList<>();
        Class<E>  entityClass=getGenericTypeClass();

        Statement st=getConnection().createStatement();
        ResultSet res=st.executeQuery(getSelectQuery(entityClass ));
        list.clear();
        System.out.println("after clear: "+list);

        //init arrays

        Constructor constructors[]=entityClass.getDeclaredConstructors();
        Constructor constructorByDefault=constructors[0];

        Method[] allMethods=entityClass.getDeclaredMethods();
        System.out.println(allMethods);

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

        for (int i=0;i<lengthSetters;i++)
        {
            Object[] arrayOfParams=  setters[i].getParameterTypes();
        }

        while (res.next())
        {
            E entity=null;
            entity=  initObj(res,constructorByDefault,setters,lengthSetters);
            list.add(entity);
            //  System.out.println(obj);
            // list.add((E) obj);
            //list.add(new EntityGlobalStat(res.getString(1),res.getInt(2)));
        }

        return list;
    }

    private static boolean isSetter(Method method) {
        return Modifier.isPublic(method.getModifiers()) &&
                method.getReturnType().equals(void.class) &&
                method.getParameterTypes().length == 1 &&
                method.getName().matches("^set[A-Z].*") &&
                method.isAnnotationPresent(ColumnSetter.class);
    }

    private E initObj(ResultSet res,Constructor constructorByDefault, Method[] setters,int lengthSetters) throws IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        Object obj= constructorByDefault.newInstance();

        // Class[] parameterTypes = setters[0].getParameterTypes();
        Field[] arrOfFields= obj.getClass().getDeclaredFields();
        //  if ( setters[0].getParameterTypes())

        //  if (arrOfFields[0].getType().isAssignableFrom(myType))

        for (int i=0;i<arrOfFields.length;i++)
        {
            Column typeOfField = arrOfFields[i].getAnnotation(Column.class);
            System.out.println("type of field= "+typeOfField.type());
            for (int z=0;z<lengthSetters;z++)
            {
                ColumnSetter typeOfSetter = setters[z].getAnnotation(ColumnSetter.class);
                System.out.println("type of setter= "+typeOfSetter.type());
                 if (typeOfField.type().ordinal()==typeOfSetter.type().ordinal())
                 {
                     System.out.println("d");
                     setters[z].invoke(obj,res.getString(1));

                 }
            }

            //Column ta = arrOfFields[i].getAnnotation(Column.class);
          //  System.out.println(ta.type());




/*
            for (int x=0;x<lengthSetters;x++)
            {
                Class[] typeOfSetter = setters[x].getParameterTypes();
                typeOfSetter[0].getTypeName();

                System.out.println("type of setter= "+typeOfSetter[0].getTypeName());
                System.out.println("type of field= "+arrOfFields[i].getType().getTypeName());
                if (arrOfFields[i].getType().equals(typeOfSetter[0]))
                {
                    System.out.println("suit");
                    setters[x].invoke(obj,res.getInt(2));
                   // setters[x].invoke(obj,res.getString(1));
                    break;


                }
            }
//
*/
        }
        setters[0].invoke(obj,res.getInt(2));
        setters[1].invoke(obj,res.getString(1));

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
        //  result=result.replaceFirst(".$","");
        result=result.substring(0, result.length() - 1);
        System.out.println("select= "+result);
        return result;
    }

    private String getSelectQuery(Class<E> clazz)
    {
        //return null;

        Table anno = clazz.getAnnotation(Table.class);
        String tableName=anno.name();
        String query="select "+getListOfColumns(clazz)+" from "+tableName+" order by 1;";
        return query;

    }

    private int getColumnIndex()
    {
        return 0;
    }


}