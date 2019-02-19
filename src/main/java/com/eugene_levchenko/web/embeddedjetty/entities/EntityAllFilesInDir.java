package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.*;
import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;
import com.eugene_levchenko.web.embeddedjetty.ormController.EGenerationType;

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
    @Getter(type = EDataType.INTEGER)
    public int getId() {
        return id;
    }

    @Getter(type = EDataType.STRING)
    public String getNameOfFile() {
        return nameOfFile;
    }

    @Setter(type = EDataType.INTEGER)
    public void setId(int id) {
        this.id = id;
    }

    @Setter(type = EDataType.STRING)
    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }
}
