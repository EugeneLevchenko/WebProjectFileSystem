package com.eugene_levchenko.web.embeddedjetty.entities;


import com.eugene_levchenko.web.embeddedjetty.annotations.Column;
import com.eugene_levchenko.web.embeddedjetty.annotations.Entity;
import com.eugene_levchenko.web.embeddedjetty.annotations.Id;
import com.eugene_levchenko.web.embeddedjetty.annotations.Table;
import com.eugene_levchenko.web.embeddedjetty.enums.EDataType;
import com.eugene_levchenko.web.embeddedjetty.enums.EGenerationType;

@Entity
@Table(name = "localstatistic")
public class EntityLocalStatOfFile {


    @Column(name = "word",type = EDataType.STRING)
   private String word;
    @Column(name = "value",type = EDataType.INTEGER)
   private int value;
    @Id(name = "file_id",strategy = EGenerationType.DEFAULT,type = EDataType.INTEGER)
    private int fileId;

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