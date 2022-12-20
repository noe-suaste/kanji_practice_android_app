package com.nstudio.kanjipractice.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoKanji {

    @Query("SELECT * FROM kanji WHERE level = :level")
    List<Kanji> getKanjisByLevel(int level);

    @Query("SELECT * FROM kanji WHERE level = :level AND id IN(:selected_kanjis)")
    List<Kanji> getSelectedKanjisByLevel(int level, List<Integer> selected_kanjis);

    @Query("SELECT id FROM kanji WHERE level = :level AND learned = 1")
    List<Integer> getLearnedKanjisByLevel(int level);

    @Query("SELECT * FROM kanji WHERE learned = 1")
    List<Kanji> getLearnedKanjis();

    @Query("SELECT * FROM kanji WHERE learned = 1 AND id IN(:selected_kanjis)")
    List<Kanji> getSelectedLearnedKanjis(List<Integer> selected_kanjis);

    @Query("UPDATE kanji SET learned = :learned WHERE level = :level AND id = :id")
    void setLearned(int learned, int level, int id);

    @Query("SELECT SUM(learned) FROM kanji WHERE level = :level")
    Integer countLearnedByLevel(int level);

    @Query("SELECT SUM(learned) FROM kanji")
    Integer countLearned();
}
