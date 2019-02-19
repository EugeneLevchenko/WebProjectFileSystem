package com.eugene_levchenko.web.embeddedjetty.entities;

import com.eugene_levchenko.web.embeddedjetty.annotations.Getter;
import com.eugene_levchenko.web.embeddedjetty.annotations.Setter;
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

    @Setter(type = EDataType.STRING)
    public void setWord(String word) {
        this.word = word;
    }

    @Setter(type = EDataType.INTEGER)
    public void setValue(int value) {
        this.value = value;
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