package com.eugene_levchenko.web.embeddedjetty.entities;

import java.io.Serializable;

public class ComplexIdLocalStat implements Serializable {

    protected Integer fileId;
    protected String word;

    public ComplexIdLocalStat(Integer fileId, String word) {
        this.fileId = fileId;
        this.word = word;
    }

    public ComplexIdLocalStat()
    {

    }
}
