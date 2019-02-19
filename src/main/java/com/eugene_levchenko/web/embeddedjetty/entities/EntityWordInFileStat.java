package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.Getter;
import com.eugene_levchenko.web.embeddedjetty.annotations.Setter;
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

    @Getter(type = EDataType.STRING)
    public String getNameOfFile() {
        return nameOfFile;
    }

    @Getter(type = EDataType.INTEGER)
    public int getValue() {
        return value;
    }

    @Setter(type = EDataType.INTEGER)
    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    @Setter(type = EDataType.INTEGER)
    public void setValue(int value) {
        this.value = value;
    }
}
