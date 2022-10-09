package com.nstudio.kanjipractice;

public class Kanji {
    private final int id;
    private final String kanji;
    private final String onyomi;
    private final String onyomi_katakana;
    private final String kunyomi;
    private final String kunyomi_hiragana;
    private final String meaning;
    private boolean learned;

    public Kanji(int id, String kanji, String onyomi, String onyomi_katakana, String kunyomi, String kunyomi_hiragana, String meaning, boolean learned) {
        this.id = id;
        this.kanji = kanji;
        this.onyomi = onyomi;
        this.onyomi_katakana = onyomi_katakana;
        this.kunyomi = kunyomi;
        this.kunyomi_hiragana = kunyomi_hiragana;
        this.meaning = meaning;
        this.learned = learned;
    }

    public int getId() {
        return id;
    }

    public String getKanji() {
        return kanji;
    }

    public String getOnyomi() {
        return onyomi;
    }

    public String getOnyomi_katakana() {
        return onyomi_katakana;
    }

    public String getKunyomi() {
        return kunyomi;
    }

    public String getKunyomi_hiragana() {
        return kunyomi_hiragana;
    }

    public String getMeaning() {
        return meaning;
    }

    public boolean getLearned(){
        return learned;
    }

    public void setLearned(boolean learned){
        this.learned = learned;
    }
}
