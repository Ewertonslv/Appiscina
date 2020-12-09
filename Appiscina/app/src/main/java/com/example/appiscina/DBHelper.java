package com.example.appiscina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static int versao = 1;
    private static String nome = "BaseDadosLogin.db";

    public DBHelper(Context context) {
        super(context, nome, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE Table Utilizador(usuario TEXT PRIMARY KEY, password TEXT, email TEXT);";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utilizador");
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

    public String validarLogin(String usuario, String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Utilizador WHERE usuario=? AND password=?", new String[] {usuario,password});
        if(c.getCount() > 0){
            return "OK";
        }
        return "ERROR";
    }

}
