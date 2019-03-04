package com.eugene_levchenko.web.embeddedjetty.entities;

import java.io.Serializable;

public class EntityComplexIdLocalStat implements Serializable {

    protected Integer fileId;
    protected String word;



    public EntityComplexIdLocalStat(Integer fileId, String word) {
        this.fileId = fileId;
        this.word = word;

    }

    public EntityComplexIdLocalStat()
    {

    }
}
