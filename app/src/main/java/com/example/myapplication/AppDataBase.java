package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavResults.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract FavResultsDao favResultsDao();
    public static AppDataBase INSTANCE;

    public static AppDataBase getInstanceDB(Context context){
        if(INSTANCE == null){
//            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                    AppDataBase.class, "movies")
//                    .allowMainThreadQueries()
//                    .build();
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,
                    "database-name").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
