package com.example.postox;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsSpinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;


public class VacinadoView extends AppCompatActivity{

    LocalDatabase db;
    List<Vacina> vacinas;
    ArrayAdapter<Vacina> vacinasAdapter;
    private EditText edtNome;
    private Button btnSalvarVacinado, btnExcluirVacinado;
    private int dbVacinadoID;
    private Vacinado dbVacinado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_vacinados);
        LocalDatabase db = Room.databaseBuilder(getApplicationContext(), LocalDatabase.class, "db").build();
        edtNome = findViewById(R.id.edtNome);
        btnSalvarVacinado = findViewById(R.id.btnSalvarVacinado);
        btnExcluirVacinado = findViewById(R.id.btnExcluirVacinado);
        dbVacinadoID = getIntent().getIntExtra("VACINADO_SELECIONADO_ID", -1);
    }

        protected void onResume () {
            super.onResume();
            if (dbVacinadoID >= 0) {
                preencheVacinado();
            } else {
                btnExcluirVacinado.setVisibility(View.GONE);
            }
            preencheVacinas();
        }

        public void preencheVacinado() {
            dbVacinado = db.vacinadoModel().get(dbVacinadoID);
            edtNome.setText(dbVacinado.getNomePessoa());
        }

        private void preencheVacinas() {
            vacinas = db.vacinaModel().getAll();
            vacinasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vacinas);
            AbsSpinner spnVacinas = null;
            spnVacinas.setAdapter(vacinasAdapter);
            if(dbVacinado != null) {
                spnVacinas.setSelection(dbVacinado.getVacinaId()-1);
            }
        }

        public void salvarVacinado(View view) {
            String nomeVacinado = edtNome.getText().toString();

            if(nomeVacinado.equals("")){
                Toast.makeText(this,"é necessário um nome", Toast.LENGTH_LONG).show();
                return;
            }

            Vacinado novoVacinado = new Vacinado();
            novoVacinado.setNomePessoa(novoVacinado.nomePessoa);
            AbsSpinner spnVacinas ;
            //novoVacinado.setVacinaId(spnVacinas.get(spnVacinas.getSelectedItemPosition())).getVacinaID();

            if(dbVacinado != null) {
                novoVacinado.setNumVacinado(dbVacinadoID);
                db.vacinadoModel().update(novoVacinado.getNomePessoa(), dbVacinadoID);
                Toast.makeText(this, "Vaciando atualizado com sucesso", Toast.LENGTH_SHORT).show();
            }else{
                db.vacinadoModel().insertAll(novoVacinado);
                Toast.makeText(this, "Vacinado registrado com sucesso", Toast.LENGTH_SHORT).show();

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
            db.vacinadoModel().delete(dbVacinado);
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