package com.example.appiscina.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appiscina.R;

public class telaLogin extends AppCompatActivity {

    Button bt_cadastro, bt_login;
    TextView tvRecuperacaoSenha;

    private EditText username, senha;

    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().hide();

        db = new DBHelper(this);

        bt_login = findViewById(R.id.bt_login);
        bt_cadastro = findViewById(R.id.bt_cadastro);
        tvRecuperacaoSenha = findViewById(R.id.tvRecuperacaoSenha);
        username =  findViewById(R.id.tv_username);
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

                else if(password.isEmpty()){
                    senha.setError("Campo obrigatório");
                    return;
                }


                else {
                    String res = db.validarLogin(usuario, password);
                    if (res.equals("OK"))
                    {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(telaLogin.this, "Login invalido, tente novamente!", Toast.LENGTH_LONG).show();
                    }
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