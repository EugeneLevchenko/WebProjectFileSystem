package com.eugene_levchenko.web.embeddedjetty.entities;

public class EntityGlobalStat {

   private String word;
   private int value;

    public EntityGlobalStat(String word, int value) {
        this.word = word;
        this.value = value;
    }

    @Override
    public String toString() {
        return "EntityGlobalStat{" +
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
