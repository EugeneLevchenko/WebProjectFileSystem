package com.eugene_levchenko.web.embeddedjetty.entities;

import javax.persistence.*;

@Entity
@Table(name = "fullnametable")
public class EntityAllFilesInDir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="fullfilename")
    private String nameOfFile;

    //@OneToMany()
   // List<EntityLocalStatOfFile> list=new ArrayList<>();

    public EntityAllFilesInDir()
    {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }
}
