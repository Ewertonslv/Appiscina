package com.example.appiscina.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;


import com.example.appiscina.R;
import com.example.appiscina.adapter.propriedadeAdapter;
import com.example.appiscina.dominio.propriedade;
import com.example.appiscina.data.propriedadeDAO;

import java.util.ArrayList;
import java.util.List;
//                                                  implements  propriedadeAdapter.OnPropriedadeListener
public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button add, bt_perfil;
    RecyclerView recyclerview;
    private propriedadeDAO PropriedadeDAO;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Appiscina");



        add = findViewById(R.id.add);
        recyclerview = findViewById(R.id.recyclerview);
        bt_perfil = findViewById(R.id.bt_perfil);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        //comenta
        List<propriedade> listaPropriedades = new ArrayList<>();

        propriedade p1 = new propriedade("Ewertonslv", "ewerton@gmail" ,"123","ewerton", "Recanto araras", "", "","Nova descoberta", "200", 1, 2, 2, 1, 1, 100);
        listaPropriedades.add(p1);
        propriedade p2 = new propriedade("Ewertonslv", "ewerton@gmail" ,"123","ewerton", "Céu Azul", "", "","Recreio", "100", 1, 2, 2, 1, 1, 100);
        listaPropriedades.add(p2);
        propriedade p3 = new propriedade("Ewertonslv", "ewerton@gmail" ,"123","ewerton", "Pedacinho do Céu", "", "","Barra Nova", "150", 1, 2, 2, 1, 1, 100);
        listaPropriedades.add(p3);


        PropriedadeDAO = propriedadeDAO.getInstance(this);

        //Comenta
        //List<propriedade> listaPropriedades = PropriedadeDAO.list();

        propriedadeAdapter propriedadeAdapter = new propriedadeAdapter(listaPropriedades, this);

        recyclerview.setAdapter(propriedadeAdapter);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent i = new Intent(getApplicationContext(), addPropriedade.class);
                startActivityForResult(i, 100);
                return true;
            case R.id.bt_perfil:
                Intent i2 = new Intent(getApplicationContext(), telaPerfil.class);
                startActivity(i2);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK){

        }
    }

//    @Override
//    public void onPropriedadeClick(int posicao) {
//
//        //Intent intent = new Intent(getApplicationContext(),addPropriedade.class);
//        //intent.putExtra("Livro", propriedadeAdapter.getItem(posicao));
//        //startActivityForResult(intent, 101);
//    }
}