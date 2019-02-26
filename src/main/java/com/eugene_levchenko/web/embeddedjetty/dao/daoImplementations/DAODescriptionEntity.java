package com.eugene_levchenko.web.embeddedjetty.dao.daoImplementations;

import com.eugene_levchenko.web.embeddedjetty.annotations.Column;
import com.eugene_levchenko.web.embeddedjetty.annotations.Id;
import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.enums.EDataType;
import com.eugene_levchenko.web.embeddedjetty.sax.SaxHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DAODescriptionEntity {


    public DAODescriptionEntity(Class<?> classz) {
        this.classz=classz;
        setDescrOfColumn();
        setTableName(classz);
        setConstructor(classz);
        setIdName(classz);
        setTypeOfId(classz);
    }

    private Class<?> classz;
    private DAODescriptionColumn[] descrOfColumn;
    private String tableName;
    private Constructor constructorEntity;
    private String idName;
    private EDataType typeOfId;


    public EDataType getTypeOfId() {
        return typeOfId;
    }

    public void setTypeOfId(Class<?> classz) {

        Field[] fields=classz.getDeclaredFields();
        for (Field f:fields)
        {
            Id id=f.getDeclaredAnnotation(Id.class);
            if (id!=null)
            {
                this.typeOfId = id.type();
            }
        }
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(Class<?> classz) {
         Field[] fields=classz.getDeclaredFields();
         for (Field f:fields)
         {
             Id id=f.getDeclaredAnnotation(Id.class);
             if (id!=null)
             {
                 this.idName = id.name();
             }
         }
    }

    private void setConstructor(Class<?> classz)
    {
        Constructor constructors[]=classz.getDeclaredConstructors();
        constructorEntity=constructors[0];
    }

    private void setTableName(Class<?> classz)
    {
        Table anno = classz.getAnnotation(Table.class);
        tableName=anno.name();
    }

    private void setDescrOfColumn()
    {
        Field[] fields= classz.getDeclaredFields();
        Field[] annotatedFields=new Field[fields.length];

        int lengthOfFields=0;
        for (int i=0;i<fields.length;i++)
        {
            Field field=fields[i];
            if (field.isAnnotationPresent(Column.class)||(field.isAnnotationPresent(Column.class)&&field.isAnnotationPresent(Id.class)))
            {
                annotatedFields[lengthOfFields]=fields[i];
                lengthOfFields++;
            }
        }

        Method[] allMethods=classz.getDeclaredMethods();
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

        descrOfColumn=new DAODescriptionColumn[lengthOfFields];

        for (int i=0;i<lengthOfFields;i++)
        {
            Column column=annotatedFields[i].getAnnotation(Column.class);
            int index=getSettersIndex(annotatedFields,i,setters);
            DAODescriptionColumn columnObj=  new DAODescriptionColumn(column.name(),annotatedFields[i].getName(),
                    getters[index],setters[index],column.type());
            descrOfColumn[i]=columnObj;
        }
    }

    public Constructor getConstructor()
    {
        return constructorEntity;
    }

    public String getTableName()
    {
        return tableName;
    }

    public DAODescriptionColumn[] getDescrOfColumn() {
        return descrOfColumn;
    }

    public String getSelectQueryGetAll(Class<?> clazz)
    {
        String query="select "+getListOfColumns(clazz)+" from "+getTableName()+";";
        if (SaxHandler.enableLogging())
        {
            System.out.println("ORM : "+query);
            System.out.println();
        }
        return query;
    }

    public String getSelectQueryGetAllById(Class<?> clazz)
    {
        String query="select "+getListOfColumns(clazz)+" from "+getTableName()+" where "+getIdName()+"=?";
        if (SaxHandler.enableLogging())
        {
            System.out.println("ORM : "+query);
            System.out.println();
        }
        return query;
    }

    public String getListOfColumns(Class<?> entityClass)
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