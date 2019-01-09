package com.eugene_levchenko.web.embeddedjetty;

public class LocalStatOfFileEntity {

    String word;
    int value;

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
}
