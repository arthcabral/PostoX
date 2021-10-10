package com.example.postox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listarVacinados( View view) {
        startActivity(new Intent(this, VacinadoList.class));
    }

    public void listarVacinas(View view) {
        startActivity(new Intent(this, VacinaList.class));
    }
}