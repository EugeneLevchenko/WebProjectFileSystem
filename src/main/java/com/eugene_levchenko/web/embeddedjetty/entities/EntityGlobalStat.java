package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.Entity;
import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;

import javax.persistence.Column;

@Entity
@Table(name = "table1")
public class EntityGlobalStat {

    @Column(name = "word",type = EDataType.STRING)
    public String word;

    @Column(name = "value",type = EDataType.INTEGER)
    public int value;

    public EntityGlobalStat(String word, int value) {
        this.word = word;
        this.value = value;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EntityGlobalStat{" +
                "word='" + word + '\'' +
                ", text=" + value +
                '}';
    }

    public String getWord() {
        return word;
    }

    public int getValue() {
        return value;
    }
}
