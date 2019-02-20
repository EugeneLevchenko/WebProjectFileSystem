package com.eugene_levchenko.web.embeddedjetty.entities;

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

    public void setWord(String word) {
        this.word = word;
    }

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