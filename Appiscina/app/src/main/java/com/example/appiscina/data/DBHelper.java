package com.example.appiscina.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static int versao = 1;
    private static String nome = "BaseDadosLogin.db";

    private static DBHelper instance;

    private static String SQL_CREATE = String.format(
        "CREATE TABLE %s (%s TEXT PRYMARY KEY, "+
                "%s TEXT, %s TEXT, %s TEXT, %s TEXT," +
                "%s TEXT,%s TEXT, %s TEXT,%s TEXT," +
                "%s INTEGER, %s INTEGER,%s INTEGER," +
                "%s INTEGER,%s INTEGER, %s INTEGER)",
                propriedadeContract.TABLE_NAME,
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
    );

    public static String SQL_DROP = "DROP TABLE IF EXISTS "+propriedadeContract.TABLE_NAME;

    public DBHelper(Context context) {
        super(context, nome, null, versao);
    }

    public static DBHelper getInstance(Context context){
        if (instance == null){
            instance = new DBHelper(context);
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_DROP);
        db.execSQL(SQL_CREATE);




//        String str = "CREATE Table Utilizador(" +
//                "usuario TEXT PRIMARY KEY," +
//                " password TEXT," +
//                " email TEXT" +
//                ");";
//        db.execSQL(str);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS Utilizador");
        onCreate(db);

    }


    public long criarUtilizador (String username, String password, String email){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("usuario", username);
        cv.put("password", password);
        cv.put("email", email);
        long result = db.insert("Utilizador", null, cv);

        return result;
    }


    //Função para validar o login
    public String validarLogin(String usuario, String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Utilizador WHERE usuario=? AND password=?", new String[] {usuario,password});
        if(c.getCount() > 0){
            return "OK";
        }
        return "ERROR";
    }

}
