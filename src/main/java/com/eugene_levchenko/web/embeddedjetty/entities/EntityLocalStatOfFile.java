package com.eugene_levchenko.web.embeddedjetty.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "localstatistic")
public class EntityLocalStatOfFile implements Serializable {

    public EntityLocalStatOfFile(String word, int value) {
        this.word = word;
        this.value = value;
    }

    public EntityLocalStatOfFile() {}

     @ManyToOne
     @JoinColumn(name = "file_id", referencedColumnName = "id")
    private EntityAllFilesInDir localFile;

    public EntityAllFilesInDir getLocalFile() {
        return localFile;
    }


    @Id
    @Column(name="file_id", insertable = false,updatable = false)
    private Integer fileId;



    @Id
    @Column(name="word")
    private String word;

    @Column(name="value")
    private int value;



    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getWord() {
        return word;
    }

    public int getValue() {
        return value;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EntityLocalStatOfFile{" +
                "fileid='" + fileId + '\'' +
                "word='" + word + '\'' +
                ", value=" + value +
                '}';
    }
}
