package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.Column;
import com.eugene_levchenko.web.embeddedjetty.annotations.Entity;
import com.eugene_levchenko.web.embeddedjetty.annotations.Id;
import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;
import com.eugene_levchenko.web.embeddedjetty.ormController.EGenerationType;

       @Entity
       @Table(name = "fullnametable")
       public class EntityAllFilesInDir {

    @Id(name = "id",strategy = EGenerationType.AUTO_INCREMENT)
    private int id;

    @Column(name = "fullfilename", type = EDataType.STRING)
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }
}
