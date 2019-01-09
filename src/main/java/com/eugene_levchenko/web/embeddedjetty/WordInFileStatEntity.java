package com.eugene_levchenko.web.embeddedjetty;

public class WordInFileStatEntity {

    String nameOfFile;
    int value;

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
}
