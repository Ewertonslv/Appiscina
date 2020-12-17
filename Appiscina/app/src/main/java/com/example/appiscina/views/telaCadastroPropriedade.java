package com.example.appiscina.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.appiscina.R;

import java.util.InputMismatchException;

public class telaCadastroPropriedade extends AppCompatActivity {

    ImageView setaProximo;
    private EditText tv_proprietario, tv_nomePropriedade, tv_cpf, tv_telefone, tv_localizacao, tv_diaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_propriedade);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Cadastrar propriedade");

        setaProximo = findViewById(R.id.setaProximo);
        tv_proprietario =  findViewById(R.id.tv_proprietario);
        tv_nomePropriedade =  findViewById(R.id.tv_nomePropriedade);
        tv_cpf =  findViewById(R.id.tv_cpf);
        tv_telefone =  findViewById(R.id.tv_telefone);
        tv_localizacao =  findViewById(R.id.tv_localizacao);
        tv_diaria =  findViewById(R.id.tv_diaria);



        setaProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proprietario = tv_proprietario.getText().toString();
                String nomePropriedade = tv_nomePropriedade.getText().toString();
                String cpf = tv_cpf.getText().toString();
                String telefone = tv_telefone.getText().toString();
                String localizacao = tv_localizacao.getText().toString();
                String diaria = tv_diaria.getText().toString();

                if(proprietario.isEmpty()){
                    tv_proprietario.setError("Campo obrigatório");
                    return;
                }

                else if(nomePropriedade.isEmpty()){
                    tv_nomePropriedade.setError("Campo obrigatório");
                    return;
                }

                else if(cpf.isEmpty()){
                    tv_cpf.setError("Campo obrigatório");

                    if (cpf.equals("00000000000") ||
                            cpf.equals("11111111111") ||
                            cpf.equals("22222222222") || cpf.equals("33333333333") ||
                            cpf.equals("44444444444") || cpf.equals("55555555555") ||
                            cpf.equals("66666666666") || cpf.equals("77777777777") ||
                            cpf.equals("88888888888") || cpf.equals("99999999999") ||
                            (cpf.length() != 11)){

                    tv_cpf.setError("Formato invalido");
                    return;}
                    char dig10, dig11;
                    int sm, i, r, num, peso;

                    // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
                    try {
                        // Calculo do 1o. Digito Verificador
                        sm = 0;
                        peso = 10;
                        for (i=0; i<9; i++) {
                            // converte o i-esimo caractere do CPF em um numero:
                            // por exemplo, transforma o caractere '0' no inteiro 0
                            // (48 eh a posicao de '0' na tabela ASCII)
                            num = (int)(cpf.charAt(i) - 48);
                            sm = sm + (num * peso);
                            peso = peso - 1;
                        }

                        r = 11 - (sm % 11);
                        if ((r == 10) || (r == 11))
                            dig10 = '0';
                        else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

                        // Calculo do 2o. Digito Verificador
                        sm = 0;
                        peso = 11;
                        for(i=0; i<10; i++) {
                            num = (int)(cpf.charAt(i) - 48);
                            sm = sm + (num * peso);
                            peso = peso - 1;
                        }

                        r = 11 - (sm % 11);
                        if ((r == 10) || (r == 11))
                            dig11 = '0';
                        else dig11 = (char)(r + 48);

                        // Verifica se os digitos calculados conferem com os digitos informados.
                        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))){
                            tv_cpf.setError("Formato invalido");
                            return;
                        }
                        else                         tv_cpf.setError("Formato invalido");
                        return;
                    } catch (InputMismatchException erro) {
                        tv_cpf.setError("Formato invalido");
                        return;
                    }

                }



                else if(telefone.isEmpty()){
                    tv_telefone.setError("Campo obrigatório");
                    return;
                }
                else if(localizacao.isEmpty()){
                    tv_localizacao.setError("Campo obrigatório");
                    return;
                }

                else if(diaria.isEmpty()){
                    tv_diaria.setError("Campo obrigatório");
                    return;
                }

                else{
                    Intent i = new Intent(getApplicationContext(),tela2CadastroPropriedade.class);
                    startActivity(i);
                }



            }
        });

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar

        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, addPropriedade.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}