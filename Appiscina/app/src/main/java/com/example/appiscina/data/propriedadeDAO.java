package com.example.appiscina.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;


import androidx.annotation.RequiresApi;

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
                propriedadeContract.Columns.usuario,
                propriedadeContract.Columns.email,
                propriedadeContract.Columns.password,
                propriedadeContract.Columns.proprietario,
                propriedadeContract.Columns.nomePropriedade,
                propriedadeContract.Columns.cpf,
                propriedadeContract.Columns.telefone,
                propriedadeContract.Columns.localizacao,
                propriedadeContract.Columns.diaria,
                propriedadeContract.Columns.geladeira,
                propriedadeContract.Columns.freezer,
                propriedadeContract.Columns.microondas,
                propriedadeContract.Columns.fogao,
                propriedadeContract.Columns.churrasqueira,
                propriedadeContract.Columns.mesas

        };

        List<propriedade> propriedades = new ArrayList<>();

        try(
        Cursor c = db.query(propriedadeContract.TABLE_NAME,
                        columns,
                        null,
                        null,
                        null,
                        null,
                         propriedadeContract.Columns.nomePropriedade)
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
        String usuario = c.getString(c.getColumnIndex(propriedadeContract.Columns.usuario));
        String email = c.getString(c.getColumnIndex(propriedadeContract.Columns.email));
        String password = c.getString(c.getColumnIndex(propriedadeContract.Columns.password));
        String  proprietario = c.getString(c.getColumnIndex(propriedadeContract.Columns.proprietario));
        String  nomePropriedade = c.getString(c.getColumnIndex(propriedadeContract.Columns.nomePropriedade));
        String  cpf = c.getString(c.getColumnIndex(propriedadeContract.Columns.cpf));
        String  telefone = c.getString(c.getColumnIndex(propriedadeContract.Columns.telefone));
        String localizacao = c.getString(c.getColumnIndex(propriedadeContract.Columns.localizacao));
        String diaria = c.getString(c.getColumnIndex(propriedadeContract.Columns.diaria));
        int geladeira = c.getInt(c.getColumnIndex(propriedadeContract.Columns.geladeira));
        int freezer = c.getInt(c.getColumnIndex(propriedadeContract.Columns.freezer));
        int microondas = c.getInt(c.getColumnIndex(propriedadeContract.Columns.microondas));
        int fogao = c.getInt(c.getColumnIndex(propriedadeContract.Columns.fogao));
        int churrasqueira = c.getInt(c.getColumnIndex(propriedadeContract.Columns.churrasqueira));
        int mesas = c.getInt(c.getColumnIndex(propriedadeContract.Columns.mesas));

        return new propriedade(usuario, email, password, proprietario, nomePropriedade, cpf,
                telefone, localizacao, diaria, geladeira, freezer, microondas, fogao, churrasqueira, mesas);
    }

    public  void save(propriedade propriedade){
        ContentValues values = new ContentValues();
        values.put(propriedadeContract.Columns.usuario, propriedade.getUsuario());
        values.put(propriedadeContract.Columns.email, propriedade.getEmail());
        values.put(propriedadeContract.Columns.password, propriedade.getPassword());
        values.put(propriedadeContract.Columns.proprietario, propriedade.getProprietario());
        values.put(propriedadeContract.Columns.nomePropriedade, propriedade.getNomePropriedade());
        values.put(propriedadeContract.Columns.cpf, propriedade.getCpf());
        values.put(propriedadeContract.Columns.telefone, propriedade.getTelefone());
        values.put(propriedadeContract.Columns.localizacao, propriedade.getLocalizacao());
        values.put(propriedadeContract.Columns.diaria, propriedade.getDiaria());
        values.put(propriedadeContract.Columns.geladeira, propriedade.getGeladeira());
        values.put(propriedadeContract.Columns.freezer, propriedade.getFreezer());
        values.put(propriedadeContract.Columns.microondas, propriedade.getMicroondas());
        values.put(propriedadeContract.Columns.fogao, propriedade.getFogao());
        values.put(propriedadeContract.Columns.churrasqueira, propriedade.getChurrasqueira());
        values.put(propriedadeContract.Columns.mesas, propriedade.getMesas());

        //Long usuario =
        db.insert(propriedadeContract.TABLE_NAME, null, values);
        //propriedade.setUsuario();
    }

    public void update(propriedade propriedade){
        ContentValues values = new ContentValues();
        values.put(propriedadeContract.Columns.usuario, propriedade.getUsuario());
        values.put(propriedadeContract.Columns.email, propriedade.getEmail());
        values.put(propriedadeContract.Columns.password, propriedade.getPassword());
        values.put(propriedadeContract.Columns.proprietario, propriedade.getProprietario());
        values.put(propriedadeContract.Columns.nomePropriedade, propriedade.getNomePropriedade());
        values.put(propriedadeContract.Columns.cpf, propriedade.getCpf());
        values.put(propriedadeContract.Columns.telefone, propriedade.getTelefone());
        values.put(propriedadeContract.Columns.localizacao, propriedade.getLocalizacao());
        values.put(propriedadeContract.Columns.diaria, propriedade.getDiaria());
        values.put(propriedadeContract.Columns.geladeira, propriedade.getGeladeira());
        values.put(propriedadeContract.Columns.freezer, propriedade.getFreezer());
        values.put(propriedadeContract.Columns.microondas, propriedade.getMicroondas());
        values.put(propriedadeContract.Columns.fogao, propriedade.getFogao());
        values.put(propriedadeContract.Columns.churrasqueira, propriedade.getChurrasqueira());
        values.put(propriedadeContract.Columns.mesas, propriedade.getMesas());

        db.update(propriedadeContract.TABLE_NAME,
                values,
                propriedadeContract.Columns.usuario+"?",
                new String[]{String.valueOf(propriedade.getUsuario())}
                );
    }

    public void delete(propriedade propriedade){
        db.delete(propriedadeContract.TABLE_NAME,
                propriedadeContract.Columns.usuario+"?",
                new String[]{String.valueOf(propriedade.getUsuario())}
        );
    }

}
