package com.example.postox;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface VacinadoDAO {

    @Query("SELECT * FROM Vacinado WHERE vacinaID = :vacinaId LIMIT 1")
    Vacinado get(int vacinaId);

    @Query("SELECT * FROM Vacinado")
    List<Vacinado> getAll();

    @Query("SELECT * FROM Vacinado WHERE vacinaID IN (:vacinaId)")
    List<Vacinado> loadAllByIds(int[] vacinaId);

    @Query("SELECT * FROM Vacinado WHERE nomePessoa LIKE :name LIMIT 1")
    Vacinado findByName(String name);

    @Query("UPDATE Vacinado SET nomePessoa =:nomePessoa WHERE vacinaId =:vacinaID")
    void update(String nomePessoa, int vacinaID);

    @Insert
    void insertAll(Vacinado... vacinado);

    @Delete
    void delete(Vacinado vacinado);



}
