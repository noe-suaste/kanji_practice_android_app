package com.nstudio.kanjipractice;

import android.content.Context;

import androidx.room.Room;

import com.nstudio.kanjipractice.database.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CtrlKanji {

    private AppDatabase database;
    private Context context;
    private int level;

    public CtrlKanji(Context context, Level level){
        this.database = AppDatabase.getDatabase(context);
        switch(level) {
            case N5:
                this.level = 5;
                break;
            case N4:
                this.level = 4;
                break;
            case N3:
                this.level = 3;
                break;
            case LEARNED:
                this.level = 0;
                break;
            default:
                break;
        }
    }

    public CtrlKanji(Context context){
        this.database = AppDatabase.getDatabase(context);
    }

    public List<Kanji> getKanjis(){
        if(this.level != 0)
            return database.daoKanji().getKanjisByLevel(this.level);
        else
            return database.daoKanji().getLearnedKanjis();
    }

    public List<Kanji> getSelectedKanjis(List<Integer> selected_kanjis){
        if(this.level != 0)
            return database.daoKanji().getSelectedKanjisByLevel(this.level, selected_kanjis);
        else{
            List<Kanji> learned_kanjis = database.daoKanji().getLearnedKanjis();
            List<Kanji> selected_learned_kanjis = new ArrayList<Kanji>();
            for(Integer i : selected_kanjis){
                selected_learned_kanjis.add(learned_kanjis.get(i - 1));
            }
            return selected_learned_kanjis;
        }
    }

    public List<Integer> getLearnedKanjis(){
        return database.daoKanji().getLearnedKanjisByLevel(this.level);
    }

    public void setLearned(Integer learned, Integer id){
        database.daoKanji().setLearned(learned, this.level, id);
    }

    public Integer countLearnedByLevel(Integer level){
        return database.daoKanji().countLearnedByLevel(level);
    }

    public Integer countLearned(){
        return database.daoKanji().countLearned();
    }
}
