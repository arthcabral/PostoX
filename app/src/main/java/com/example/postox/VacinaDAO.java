package com.example.postox;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface VacinaDAO {

    @Query("SELECT * FROM Vacina WHERE vacinaId = :vacinaId LIMIT 1")
    Vacina get(int vacinaId);

    @Query("SELECT * FROM Vacina")
    List<Vacina> getAll();

    @Insert
    void insertAll(Vacina... vacina);

    @Update
    void update(Vacina... Vacina);

    @Delete
    void delete(Vacina vacina);
}
