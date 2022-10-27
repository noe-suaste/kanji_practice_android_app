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

    public List<Kanji> getKanjis(){
        return database.daoKanji().getKanjisByLevel(this.level);
    }

    public List<Kanji> getSelectedKanjis(List<Integer> selected_kanjis){
        return database.daoKanji().getSelectedKanjisByLevel(this.level, selected_kanjis);
    }

    public List<Integer> getLearnedKanjis(){
        return database.daoKanji().getLearnedKanjisByLevel(this.level);
    }

    public void setLearned(Integer learned, Integer id){
        database.daoKanji().setLearned(learned, this.level, id);
    }
}
