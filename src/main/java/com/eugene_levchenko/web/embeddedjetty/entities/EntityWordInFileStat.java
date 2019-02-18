package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.ColumnSetter;
import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;

public class EntityWordInFileStat {

   private String nameOfFile;
   private int value;

    @Override
    public String toString() {
        return "EntityWordInFileStat{" +
                "nameOfFile='" + nameOfFile + '\'' +
                ", value=" + value +
                '}';
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public int getValue() {
        return value;
    }
    @ColumnSetter(type = EDataType.INTEGER)
    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    @ColumnSetter(type = EDataType.INTEGER)
    public void setValue(int value) {
        this.value = value;
    }
}
