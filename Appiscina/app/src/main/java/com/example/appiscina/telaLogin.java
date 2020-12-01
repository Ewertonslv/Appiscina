package com.example.appiscina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class telaLogin extends AppCompatActivity {

    Button bt_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().hide();


        bt_cadastro = findViewById(R.id.bt_cadastro);

        bt_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),telaCadastroUsuario.class);
                startActivity(i);
            }
        });

    }
}