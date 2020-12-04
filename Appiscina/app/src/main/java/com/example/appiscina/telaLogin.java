package com.example.appiscina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class telaLogin extends AppCompatActivity {

    Button bt_cadastro, bt_login;
    TextView tvRecuperacaoSenha;

    private EditText username;
    private EditText senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().hide();

        bt_login = findViewById(R.id.bt_login);
        bt_cadastro = findViewById(R.id.bt_cadastro);
        tvRecuperacaoSenha = findViewById(R.id.tvRecuperacaoSenha);
        username =  findViewById(R.id.username);
        senha =  findViewById(R.id.senha);

        bt_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),telaCadastroUsuario.class);
                startActivity(i);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = username.getText().toString();
                String password = senha.getText().toString();

                if(usuario.isEmpty()){
                    username.setError("Campo obrigatório");
                    return;
                }

                if(password.isEmpty()){
                    senha.setError("Campo obrigatório");
                    return;
                }

                if(usuario.equals("ewerton") && (password.equals("123"))) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);

                    finish();

                }else{
                    //Toast.makeText(this, "usuário ou senha incorreto!", Toast.LENGTH_LONG).show();
                }

            }
        });



        tvRecuperacaoSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),telaRedefinicaoSenha.class);
                startActivity(i);
            }
        });


    }
}