package com.example.postox;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Vacina.class,
        parentColumns = "vacinaId", childColumns = "vacinaId"))

public class Vacinado {

        @PrimaryKey(autoGenerate = true)
        int numVacinado; //chave primária autoicrement
        int vacinaId; //chave estrangeira
        String nomePessoa;
        String cpf;
        int idade;

    public Vacinado(){

    }


    public Vacinado(int numVacinado, int vacinaId, String nomePessoa, String cpf, int idade) {
        this.numVacinado = numVacinado;
        this.vacinaId = vacinaId;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.idade = idade;
    }

    public int getNumVacinado() {
        return numVacinado;
    }

    public void setNumVacinado(int numVacinado) {
        this.numVacinado = numVacinado;
    }

    public int getVacinaId() {
        return vacinaId;
    }

    public void setVacinaId(int vacinaId) {
        this.vacinaId = vacinaId;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //public void set

}
