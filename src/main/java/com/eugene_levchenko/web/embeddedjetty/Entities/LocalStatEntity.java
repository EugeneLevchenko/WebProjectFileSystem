package com.eugene_levchenko.web.embeddedjetty.Entities;

public class LocalStatEntity {
   private int id;
   private String name;

    public LocalStatEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "LocalStatEntity{" +
                "id=" + id +
                ", nameOfFile='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
