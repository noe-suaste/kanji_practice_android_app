package com.nstudio.kanjipractice.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(primaryKeys = {"level", "id"})
public class Kanji implements Serializable {

    @NonNull
    private int level;
    @NonNull
    private int id;
    @NonNull
    private String kanji;
    @NonNull
    private String onyomi;
    @NonNull
    private String onyomi_katakana;
    @NonNull
    private String kunyomi;
    @NonNull
    private String kunyomi_hiragana;
    @NonNull
    private String meaning;
    @NonNull
    private int learned;

    public Kanji(int level, int id, @NonNull String kanji, @NonNull String onyomi, @NonNull String onyomi_katakana, @NonNull String kunyomi, @NonNull String kunyomi_hiragana, @NonNull String meaning, int learned) {
        this.level = level;
        this.id = id;
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.onyomi_katakana = onyomi_katakana;
        this.kunyomi = kunyomi;
        this.kunyomi_hiragana = kunyomi_hiragana;
        this.meaning = meaning;
        this.learned = learned;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getKanji() {
        return kanji;
    }

    public void setKanji(@NonNull String kanji) {
        this.kanji = kanji;
    }

    @NonNull
    public String getOnyomi() {
        return onyomi;
    }

    public void setOnyomi(@NonNull String onyomi) {
        this.onyomi = onyomi;
    }

    @NonNull
    public String getOnyomi_katakana() {
        return onyomi_katakana;
    }

    public void setOnyomi_katakana(@NonNull String onyomi_katakana) {
        this.onyomi_katakana = onyomi_katakana;
    }

    @NonNull
    public String getKunyomi() {
        return kunyomi;
    }

    public void setKunyomi(@NonNull String kunyomi) {
        this.kunyomi = kunyomi;
    }

    @NonNull
    public String getKunyomi_hiragana() {
        return kunyomi_hiragana;
    }

    public void setKunyomi_hiragana(@NonNull String kunyomi_hiragana) {
        this.kunyomi_hiragana = kunyomi_hiragana;
    }

    @NonNull
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(@NonNull String meaning) {
        this.meaning = meaning;
    }

    @NonNull
    public int getLearned() {
        return learned;
    }

    public void setLearned(int learned) {
        this.learned = learned;
    }
}
