package com.eugene_levchenko.web.embeddedjetty.Entities;

public class GlobalStatEntity {

   private String word;
   private int value;

    public GlobalStatEntity(String word, int value) {
        this.word = word;
        this.value = value;
    }

    @Override
    public String toString() {
        return "GlobalStatEntity{" +
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
