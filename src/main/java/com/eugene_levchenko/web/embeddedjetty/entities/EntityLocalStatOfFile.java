package com.eugene_levchenko.web.embeddedjetty.entities;

public class EntityLocalStatOfFile {

   private String word;
   private int value;

    public EntityLocalStatOfFile(String word, int value) {
        this.word = word;
        this.value = value;
    }

    @Override
    public String toString() {
        return "EntityLocalStatOfFile{" +
                "word='" + word + '\'' +
                ", value=" + value +
                '}';
    }

    public String getWord() {
        return word;
    }

    public int getValue() {
        return value;
    }
}