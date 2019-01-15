package com.eugene_levchenko.web.embeddedjetty.Entities;

public class LocalStatOfFileEntity {

   private String word;
   private int value;

    public LocalStatOfFileEntity(String word, int value) {
        this.word = word;
        this.value = value;
    }

    @Override
    public String toString() {
        return "LocalStatOfFileEntity{" +
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
