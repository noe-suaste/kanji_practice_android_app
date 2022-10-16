package com.nstudio.kanjipractice.database;

import androidx.room.Database;

@Database(
        entities = {Kanji.class},
        version = 1
)
public abstract class AppDatabase {
    public abstract DaoKanji daoKanji();
}
