package com.example.postox;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Vacinado.class, Vacina.class}, version = 1)
public abstract class LocalDataBase extends RoomDatabase {

    private static LocalDataBase INSTANCE;

    public static LocalDataBase getDataBase(Context context)  {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LocalDataBase.class, "ControleVacinas").allowMainThreadQueries();
        }
        return INSTANCE;
    }

    public abstract VacinadoDAO vacinadoModel();

    public abstract VAcinaDAO vacinaModel();
}
