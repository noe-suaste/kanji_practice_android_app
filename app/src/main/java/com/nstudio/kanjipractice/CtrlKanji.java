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

    public CtrlKanji(Context context){
        //this.database = Room.databaseBuilder(
        //        context,
        //        AppDatabase.class,
        //        "Kanjis.db"
        //).createFromAsset("Kanjis.db").allowMainThreadQueries().build();
    }
}
