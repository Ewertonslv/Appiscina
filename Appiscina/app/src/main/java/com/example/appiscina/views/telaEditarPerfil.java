package com.example.appiscina.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.appiscina.R;

public class telaEditarPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_editar_perfil);
        getSupportActionBar().setTitle("Seus dados");
    }
}