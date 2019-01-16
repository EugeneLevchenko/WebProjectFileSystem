package com.eugene_levchenko.web.embeddedjetty.Entities;

public class LocalStatEntity {
   private int id;
   private String nameOfFile;

    public LocalStatEntity(int id, String nameOfFile) {
        this.id = id;
        this.nameOfFile = nameOfFile;
    }


    @Override
    public String toString() {
        return "LocalStatEntity{" +
                "id=" + id +
                ", nameOfFile='" + nameOfFile + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }
}
