package com.example.postox;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Vacinado.class, Vacina.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {


    private static LocalDatabase INSTANCE;

    public static LocalDatabase getDataBase(Context context)  {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LocalDatabase.class, "PostoX").build();
                }

        return INSTANCE;
    }

    public abstract VacinadoDAO vacinadoModel();

    public abstract VacinaDAO vacinaModel();
}
