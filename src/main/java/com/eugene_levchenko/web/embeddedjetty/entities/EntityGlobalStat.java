package com.eugene_levchenko.web.embeddedjetty.entities;

import javax.persistence.*;

@Entity
@Table(name = "filestatistic")
public class EntityGlobalStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="word")
    private String word;
    @Column(name="value")
    private int value;

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

    public void setWord(String word) {
        this.word = word;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
