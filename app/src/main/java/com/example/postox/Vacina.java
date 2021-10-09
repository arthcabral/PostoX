package com.example.postox;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Vacina {

    @PrimaryKey(autoGenerate = true)
    int vacinaId;
    String nomeVacina;
    String fabricante;

    public Vacina() {

    }

    public Vacina(int vacinaId, String nomeVacina, String fabricante) {
        this.vacinaId = vacinaId;
        this.nomeVacina = nomeVacina;
        this.fabricante = fabricante;
    }

    public int getVacinaId() {
        return vacinaId;
    }

    public void setVacinaId(int vacinaId) {
        this.vacinaId = vacinaId;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return this.vacinaId + ": " + this.nomeVacina;
    }
}
