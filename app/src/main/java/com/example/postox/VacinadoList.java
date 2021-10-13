package com.example.postox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

public class VacinadoList extends AppCompatActivity {

    LocalDatabase db;
    List<Vacinado> vacinados;
    ListView listViewVacinados;
    Intent edtIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_vacinados);
        db = LocalDatabase.getDataBase (getApplicationContext());
        listViewVacinados = findViewById(R.id.listViewVacinados);
    }

    @Override
    protected void onResume() {
        super.onResume();
        edtIntent = new Intent(this, VacinadoView.class);
        preencheVacinados();
    }



    private void preencheVacinados() {
        vacinados = db.vacinadoModel().getAll();
        ArrayAdapter<Vacinado> vacinadosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vacinados);
        listViewVacinados.setAdapter(vacinadosAdapter);
        listViewVacinados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Vacinado vacinadoselecionado = vacinados.get(position);
                edtIntent.putExtra("VACINADO_SELECIONADO_ID", vacinadoselecionado.numVacinado);
                startActivity(edtIntent);
            }
        });
    }

    public void cadastrarVacinado(View view) {

        startActivity(edtIntent);
    }

    public void voltar(View view) {
        finish();
    }
}