package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.ColumnSetter;
import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;

public class EntityLocalStatOfFile {

   private String word;
   private int value;



    @Override
    public String toString() {
        return "EntityLocalStatOfFile{" +
                "word='" + word + '\'' +
                ", value=" + value +
                '}';
    }

    @ColumnSetter(type = EDataType.STRING)
    public void setWord(String word) {
        this.word = word;
    }

    @ColumnSetter(type = EDataType.INTEGER)
    public void setValue(int value) {
        this.value = value;
    }

    public String getWord() {
        return word;
    }

    public int getValue() {
        return value;
    }
}