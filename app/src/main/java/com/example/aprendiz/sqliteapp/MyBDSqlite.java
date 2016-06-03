package com.example.aprendiz.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by APRENDIZ on 02/06/2016.
 */
public class MyBDSqlite extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "persona.db";
    private static final String DATABASE_TABLE = "persona";
    private static final String COLUMNA_DOCUMENTO = "documento";
    private static final String COLUMNA_NOMBRE = "nombre";
    private static final String COLUMNA_CONTACTO = "contacto";

    public MyBDSqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DATABASE_TABLE +
                " (" + COLUMNA_DOCUMENTO + " INTEGER PRIMARY KEY, " +
                COLUMNA_NOMBRE + " TEXT, " +
                COLUMNA_CONTACTO + " INTEGER);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXIST " + DATABASE_TABLE;
        db.execSQL(query);
        onCreate(db);
    }

    public void agregarPersona(Persona persona) {
        ContentValues values = new ContentValues();
        values.put(COLUMNA_DOCUMENTO, persona.getDocumento());
        values.put(COLUMNA_NOMBRE, persona.getNombre());
        values.put(COLUMNA_CONTACTO, persona.getContacto());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(DATABASE_TABLE, null, values);
        db.close();
    }
}
