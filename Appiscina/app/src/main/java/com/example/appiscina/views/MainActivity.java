package com.example.appiscina.views;

import androidx.annotation.NonNull;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button add, bt_perfil;
    RecyclerView recyclerview;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Appiscina");

        //imageView.setVisibility(View.GONE);





        add = findViewById(R.id.add);
        recyclerview = findViewById(R.id.recyclerview);
        bt_perfil = findViewById(R.id.bt_perfil);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        List<propriedade> listaPropriedades = new ArrayList<>();

//        propriedade p1 = new propriedade(usuario, email, password, "Ewerton Silva", "Recanto Aráras ", "12345", "99004403", "Barra nova", "100", geladeira, freezer, microondas, fogao, churrasqueira, 0);
//        listaPropriedades.add(p1);
//        propriedade p2 = new propriedade(usuario, email, password, "Alberto gomes", "Céu azul", "12dd345", "9900dd4403", "Nova descoberta", "150", geladeira, freezer, microondas, fogao, churrasqueira, 1);
//        listaPropriedades.add(p2);
//        propriedade p3 = new propriedade(usuario, email, password, "Larissa medeiros", "Lagoa azul", "12dd345", "9900dd4403", "Recreio", "250", geladeira, freezer, microondas, fogao, churrasqueira, 0);
//        listaPropriedades.add(p3);



        propriedadeAdapter propriedadeAdapter = new propriedadeAdapter(listaPropriedades, this);

        recyclerview.setAdapter(propriedadeAdapter);

//        bt_perfil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(),telaPerfil.class);
//                startActivity(i);
//            }
//        });

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
                startActivity(i);
                return true;
            case R.id.bt_perfil:
                Intent i2 = new Intent(getApplicationContext(), telaPerfil.class);
                startActivity(i2);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}