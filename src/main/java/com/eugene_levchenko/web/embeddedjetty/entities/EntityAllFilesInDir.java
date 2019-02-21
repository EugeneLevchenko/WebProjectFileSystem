package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.*;
import com.eugene_levchenko.web.embeddedjetty.enums.EDataType;
import com.eugene_levchenko.web.embeddedjetty.enums.EGenerationType;

@Entity
@Table(name = "fullnametable")
public class EntityAllFilesInDir {



    @Column(name = "fullfilename", type = EDataType.STRING)
    private String nameOfFile;

    @Column(name = "id",type = EDataType.INTEGER )
    @Id(name = "id",strategy = EGenerationType.AUTO_INCREMENT,type = EDataType.INTEGER)
    private int id;

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
