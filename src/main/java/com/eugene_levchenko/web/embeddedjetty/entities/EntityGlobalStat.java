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

    @Setter(type = EDataType.INTEGER)
    public void setValue(int value) {
        this.value = value;
    }

    @Setter(type = EDataType.STRING)
    public void setWord(String word) {
        this.word = word;
    }


    @Override
    public String toString() {
        return "EntityGlobalStat{" +
                "word='" + word + '\'' + ", value=" + value +
                '}';
    }
@Getter(type = EDataType.STRING)
    public String getWord() {
        return word;
    }
    @Getter(type = EDataType.INTEGER)
    public int getValue() {
        return value;
    }
}
