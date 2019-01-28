package com.eugene_levchenko.web.embeddedjetty.entities;

public class EntityAllFilesInDir {

   private int id;
   private String nameOfFile;

    public EntityAllFilesInDir(int id, String nameOfFile) {
        this.id = id;
        this.nameOfFile = nameOfFile;
    }

    @Override
    public String toString() {
        return "EntityAllFilesInDir{" +
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
