package com.example.appiscina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;


import androidx.annotation.RequiresApi;

import com.example.appiscina.data.DBHelper;
import com.example.appiscina.data.propriedadeContract;
import com.example.appiscina.dominio.propriedade;

import java.util.ArrayList;
import java.util.List;

public class propriedadeDAO {

    private SQLiteDatabase db;
    private static propriedadeDAO instance;

    private propriedadeDAO (Context context){
        DBHelper dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();

    }

    public static propriedadeDAO getInstance(Context context){
        if (instance == null){
            instance = new propriedadeDAO(context.getApplicationContext());
        }
        return instance;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public List<propriedade> list(){
        String[] columns = {
                propriedadeContract.Collumns.usuario,
                propriedadeContract.Collumns.email,
                propriedadeContract.Collumns.password,
                propriedadeContract.Collumns.proprietario,
                propriedadeContract.Collumns.nomePropriedade,
                propriedadeContract.Collumns.cpf,
                propriedadeContract.Collumns.telefone,
                propriedadeContract.Collumns.localizacao,
                propriedadeContract.Collumns.diaria,
                propriedadeContract.Collumns.geladeira,
                propriedadeContract.Collumns.freezer,
                propriedadeContract.Collumns.microondas,
                propriedadeContract.Collumns.fogao,
                propriedadeContract.Collumns.churrasqueira,
                propriedadeContract.Collumns.mesas

        };

        List<propriedade> propriedades = new ArrayList<>();

        try(
                Cursor c = db.query(propriedadeContract.TABLE_NAME,
                        columns,
                        null,
                        null,
                        null,
                         null,
                         propriedadeContract.Collumns.nomePropriedade)
                ){

            if (c.moveToFirst()){
                do {
                    propriedade p = propriedadeDAO.fromCursor(c);
                    propriedades.add(p);
                }while (c.moveToNext());
            }

        }

        return propriedades;
    }

    private static propriedade fromCursor(Cursor c){
        String usuario = c.getString(c.getColumnIndex(propriedadeContract.Collumns.usuario));
        String email = c.getString(c.getColumnIndex(propriedadeContract.Collumns.email));
        String password = c.getString(c.getColumnIndex(propriedadeContract.Collumns.password));
        String  proprietario = c.getString(c.getColumnIndex(propriedadeContract.Collumns.proprietario));
        String  nomePropriedade = c.getString(c.getColumnIndex(propriedadeContract.Collumns.nomePropriedade));
        String  cpf = c.getString(c.getColumnIndex(propriedadeContract.Collumns.cpf));
        String  telefone = c.getString(c.getColumnIndex(propriedadeContract.Collumns.telefone));
        String localizacao = c.getString(c.getColumnIndex(propriedadeContract.Collumns.localizacao));
        String diaria = c.getString(c.getColumnIndex(propriedadeContract.Collumns.diaria));
        int geladeira = c.getInt(c.getColumnIndex(propriedadeContract.Collumns.geladeira));
        int freezer = c.getInt(c.getColumnIndex(propriedadeContract.Collumns.freezer));
        int microondas = c.getInt(c.getColumnIndex(propriedadeContract.Collumns.microondas));
        int fogao = c.getInt(c.getColumnIndex(propriedadeContract.Collumns.fogao));
        int churrasqueira = c.getInt(c.getColumnIndex(propriedadeContract.Collumns.churrasqueira));
        int mesas = c.getInt(c.getColumnIndex(propriedadeContract.Collumns.mesas));

        return new propriedade(usuario, email, password, proprietario, nomePropriedade, cpf,
                telefone, localizacao, diaria, geladeira, freezer, microondas, fogao, churrasqueira, mesas);
    }

    public  void save(propriedade propriedade){
        ContentValues values = new ContentValues();
        values.put(propriedadeContract.Collumns.usuario, propriedade.getUsuario());
        values.put(propriedadeContract.Collumns.email, propriedade.getEmail());
        values.put(propriedadeContract.Collumns.password, propriedade.getPassword());
        values.put(propriedadeContract.Collumns.proprietario, propriedade.getProprietario());
        values.put(propriedadeContract.Collumns.nomePropriedade, propriedade.getNomePropriedade());
        values.put(propriedadeContract.Collumns.cpf, propriedade.getCpf());
        values.put(propriedadeContract.Collumns.telefone, propriedade.getTelefone());
        values.put(propriedadeContract.Collumns.localizacao, propriedade.getLocalizacao());
        values.put(propriedadeContract.Collumns.diaria, propriedade.getDiaria());
        values.put(propriedadeContract.Collumns.geladeira, propriedade.getGeladeira());
        values.put(propriedadeContract.Collumns.freezer, propriedade.getFreezer());
        values.put(propriedadeContract.Collumns.microondas, propriedade.getMicroondas());
        values.put(propriedadeContract.Collumns.fogao, propriedade.getFogao());
        values.put(propriedadeContract.Collumns.churrasqueira, propriedade.getChurrasqueira());
        values.put(propriedadeContract.Collumns.mesas, propriedade.getMesas());

        //Long usuario =
        db.insert(propriedadeContract.TABLE_NAME, null, values);
        //propriedade.setUsuario();
    }

    public void update(propriedade propriedade){
        ContentValues values = new ContentValues();
        values.put(propriedadeContract.Collumns.usuario, propriedade.getUsuario());
        values.put(propriedadeContract.Collumns.email, propriedade.getEmail());
        values.put(propriedadeContract.Collumns.password, propriedade.getPassword());
        values.put(propriedadeContract.Collumns.proprietario, propriedade.getProprietario());
        values.put(propriedadeContract.Collumns.nomePropriedade, propriedade.getNomePropriedade());
        values.put(propriedadeContract.Collumns.cpf, propriedade.getCpf());
        values.put(propriedadeContract.Collumns.telefone, propriedade.getTelefone());
        values.put(propriedadeContract.Collumns.localizacao, propriedade.getLocalizacao());
        values.put(propriedadeContract.Collumns.diaria, propriedade.getDiaria());
        values.put(propriedadeContract.Collumns.geladeira, propriedade.getGeladeira());
        values.put(propriedadeContract.Collumns.freezer, propriedade.getFreezer());
        values.put(propriedadeContract.Collumns.microondas, propriedade.getMicroondas());
        values.put(propriedadeContract.Collumns.fogao, propriedade.getFogao());
        values.put(propriedadeContract.Collumns.churrasqueira, propriedade.getChurrasqueira());
        values.put(propriedadeContract.Collumns.mesas, propriedade.getMesas());

        db.update(propriedadeContract.TABLE_NAME,
                values,
                propriedadeContract.Collumns.usuario+"?",
                new String[]{String.valueOf(propriedade.getUsuario())}
                );
    }

    public void delete(propriedade propriedade){
        db.delete(propriedadeContract.TABLE_NAME,
                propriedadeContract.Collumns.usuario+"?",
                new String[]{String.valueOf(propriedade.getUsuario())}
        );
    }

}
