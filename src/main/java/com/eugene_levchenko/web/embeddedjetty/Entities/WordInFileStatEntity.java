package com.eugene_levchenko.web.embeddedjetty.Entities;

public class WordInFileStatEntity {

   private String nameOfFile;
   private int value;

    public WordInFileStatEntity(String nameOfFile, int value) {
        this.nameOfFile = nameOfFile;
        this.value = value;
    }

    @Override
    public String toString() {
        return "WordInFileStatEntity{" +
                "nameOfFile='" + nameOfFile + '\'' +
                ", value=" + value +
                '}';
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public int getValue() {
        return value;
    }
}
