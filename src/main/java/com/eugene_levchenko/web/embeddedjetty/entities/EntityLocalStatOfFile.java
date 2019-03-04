package com.eugene_levchenko.web.embeddedjetty.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(EntityComplexIdLocalStat.class)
@Table(name = "localstatistic")
public class EntityLocalStatOfFile implements Serializable {

    public void setWord(String word) {
        this.word = word;
    }

    public void setValue(int value) {
        this.value = value;
    }
    @Id
    @Column(name="file_id")
    private    Integer fileId;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
    @Id
    @Column(name="word")
    private String word;

    @Column(name="value")
    private int value;

    public EntityLocalStatOfFile(String word, int value) {
        this.word = word;
        this.value = value;
    }

    public EntityLocalStatOfFile() {

    }

    @Override
    public String toString() {
        return "EntityLocalStatOfFile{" +
                "fileid='" + fileId + '\'' +
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
