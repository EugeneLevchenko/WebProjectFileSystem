package com.eugene_levchenko.web.embeddedjetty.entities;

public class EntityWordInFileStat {

   private String nameOfFile;
   private int value;

    public EntityWordInFileStat(String nameOfFile, int value) {
        this.nameOfFile = nameOfFile;
        this.value = value;
    }

    @Override
    public String toString() {
        return "EntityWordInFileStat{" +
                "nameOfFile='" + nameOfFile + '\'' +
                ", text=" + value +
                '}';
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public int getValue() {
        return value;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
