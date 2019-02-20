package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.*;
import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;

@Entity
@Table(name = "filestatistic")
public class EntityGlobalStat {

    @Column(name = "word",type = EDataType.STRING)
    public String word;

    @Column(name = "value",type = EDataType.INTEGER)
    public int value;

    public void setValue(int value) {
        this.value = value;
    }

    public void setWord(String word) {
        this.word = word;
    }


    @Override
    public String toString() {
        return "EntityGlobalStat{" +
                "word='" + word + '\'' + ", value=" + value +
                '}';
    }

    public String getWord() {
        return word;
    }
    public int getValue() {
        return value;
    }
}
