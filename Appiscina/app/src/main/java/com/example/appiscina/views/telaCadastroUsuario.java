package com.example.appiscina.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appiscina.R;

public class telaCadastroUsuario extends AppCompatActivity {

    Button bt_cadastrar;
    private EditText tv_email, tv_username, password1, password2;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_usuario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Cadastro");

        db = new DBHelper(this);

        tv_email =  findViewById(R.id.tv_email);
        tv_username =  findViewById(R.id.tv_username);
        password1 =  findViewById(R.id.password1);
        password2 =  findViewById(R.id.password2);
        bt_cadastrar =  findViewById(R.id.bt_cadastrar);

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strEmail = tv_email.getText().toString();
                String usuario = tv_username.getText().toString();
                String senha1 = password1.getText().toString();
                String senha2 = password2.getText().toString();


                if(strEmail.isEmpty()){
                    tv_email.setError("Campo obrigatório");
                    return;
                }

                else if(usuario.isEmpty()){
                    tv_username.setError("Campo obrigatório");
                    return;
                }

                else if(senha1.isEmpty()){
                    password1.setError("Campo obrigatório");
                    return;
                }


                else if(senha2.isEmpty()){
                    password2.setError("Campo obrigatório");
                    return;
                }

                else if (!senha1.equals(senha2)){
                    Toast.makeText(telaCadastroUsuario.this, "As senhas não correspondem", Toast.LENGTH_LONG).show();
                }else {
                    long res = db.criarUtilizador(usuario, senha1, strEmail);
                    if(res>0){
                        Toast.makeText(telaCadastroUsuario.this, "Cadastro completo", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), telaLogin.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(telaCadastroUsuario.this, "Cadastro invalido, tente novamente!", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });





    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar

        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, telaLogin.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }



}