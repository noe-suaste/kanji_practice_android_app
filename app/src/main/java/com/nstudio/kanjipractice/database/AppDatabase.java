package com.nstudio.kanjipractice.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {Kanji.class},
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoKanji daoKanji();
}
