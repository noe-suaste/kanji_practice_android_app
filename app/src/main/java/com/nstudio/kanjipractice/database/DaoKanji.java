package com.nstudio.kanjipractice.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoKanji {

    @Query("SELECT * FROM Kanji WHERE level = 5")
    ArrayList<Kanji> getN5Kanjis();

    @Query("SELECT * FROM Kanji WHERE level = 5 AND id IN(:selected_kanjis)")
    ArrayList<Kanji> getSelectedN5Kanjis(List<Integer> selected_kanjis);

    @Query("SELECT id FROM Kanji WHERE level = 5 AND learned = 1")
    ArrayList<Integer> getLearnedN5Kanjis();

    @Query("SELECT * FROM Kanji WHERE level = 4")
    ArrayList<Kanji> getN4Kanjis();

    @Query("SELECT * FROM Kanji WHERE level = 4 AND id IN(:selected_kanjis)")
    ArrayList<Kanji> getSelectedN4Kanjis(List<Integer> selected_kanjis);

    @Query("SELECT id FROM Kanji WHERE level = 4 AND learned = 1")
    ArrayList<Integer> getLearnedN4Kanjis();

    @Query("SELECT * FROM Kanji WHERE learned = 1")
    ArrayList<Kanji> getLearnedKanjis();

    @Query("SELECT * FROM Kanji WHERE learned = 1 AND id IN(:selected_kanjis)")
    ArrayList<Kanji> getSelectedLearnedKanjis(List<Integer> selected_kanjis);

    @Query("UPDATE kanji SET learned = :learned WHERE level = :level AND id = :id")
    void setLearned(int learned, int level, int id);
}
