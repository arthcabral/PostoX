package com.example.postox;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

public class VacinadoView extends AppCompatActivity {

    RoomDatabase.Builder<LocalDataBase> db;
    private EditText edtVacinado;
    private Button btnSalvar, btnExcluir;
    private int dbVacinadoID;
    private Vacinado dbVacinado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_vacinados);
        db = LocalDataBase.getDataBase(getApplicationContext());
        edtVacinado = findViewById(R.id.edtVacinado);
        btnSalvar = findViewById(R.id.btnSalvarVacinado);
        btnExcluir = findViewById(R.id.btnExcluirVacinnado);
        dbVacinadoID = getIntent().getIntExtra("VACINADO_SELECIONADO_ID", -1);
    }

        protected void onResume () {
            super.onResume();
            if (dbVacinadoID >= 0) {
                getDBVacinado();
            } else {
                btnExcluir.setVisibility(View.GONE);
            }
            getDBVacinadoID();
        }

        public void editarVacinado() {
           // dbVacinado = db.vacinadoModel().get(dbVacinadoID);
            edtVacinado.setText(dbVacinado.getNomePessoa());
        }

        public void salvarVacinado(View view) {
            String nomeVacinado = edtVacinado.getText().toString();

            if(nomeVacinado.equals("")){
                Toast.makeText(this,"é necessário um nome", Toast.LENGTH_LONG).show();
                return;
            }

            Vacinado thisVacinado = new Vacinado();
            thisVacinado.setVacinaId(nomeVacinado);

            if(dbVacinado != null) {
                thisVacinado.setNumVacinado(dbVacinadoID);
             //   db.vacinadoModel().update(thisVacinado);
                Toast.makeText(this, "Vaciando atualizado com sucesso", Toast.LENGTH_SHORT).show();
            }else{
              //  db.vacinadoModel().insertAll(thisVacinado);
                Toast.makeText(this, "Marca craiada com sucesso", Toast.LENGTH_SHORT).show();

            }

            finish();
        }

        public void excluirVacinado(View view) {
            new AlertDialog.Builder(this)
                .setTitle("Exclusão de Vacinado")
                .setMessage("Deseja excluir esse celular?")
                .setPositiveButton("Sim", (dialog, which) -> { excluir();})
                .setNegativeButton("Não", null)
                .show();
        }

        public void excluir() {
            //db.vacinadoModel().delete(dbVacinado);
            Toast.makeText(this, "Vacinado excluído com êxito.", Toast.LENGTH_SHORT).show();
            finish();
        }

        public void voltar(View vieww) {
            finish();
        }

        public  void cadastrarVacinado(View view) {
            startActivity(new Intent(this, VacinaView.class));
        }

}