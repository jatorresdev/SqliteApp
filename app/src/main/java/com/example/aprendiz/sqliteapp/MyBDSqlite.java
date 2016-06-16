package com.example.aprendiz.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by APRENDIZ on 02/06/2016.
 */
public class MyBDSqlite extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "persona.db";
    private static final String DATABASE_TABLE = "persona";
    private static final String COLUMNA_DOCUMENTO = "_id";
    private static final String COLUMNA_NOMBRE = "nombre";
    private static final String COLUMNA_APELLIDO = "apellido";
    private static final String COLUMNA_CONTACTO = "contacto";
    private static final String COLUMNA_EMAIL = "email";

    public MyBDSqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DATABASE_TABLE +
                " (" + COLUMNA_DOCUMENTO + " INTEGER PRIMARY KEY, " +
                COLUMNA_NOMBRE + " TEXT, " +
                COLUMNA_APELLIDO + " TEXT, " +
                COLUMNA_CONTACTO + " INTEGER, " +
                COLUMNA_EMAIL + " TEXT);";

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
        values.put(COLUMNA_APELLIDO, persona.getApellido());
        values.put(COLUMNA_CONTACTO, persona.getContacto());
        values.put(COLUMNA_EMAIL, persona.getEmail());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(DATABASE_TABLE, null, values);
        db.close();
    }

    public Cursor buscarPersonas() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + DATABASE_TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c == null) {
            return null;
        } else {
            return c;
        }
    }

    public Cursor buscarPersonaModificar(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + DATABASE_TABLE + " WHERE " + COLUMNA_DOCUMENTO + " = " + id + ";";
        Cursor c = db.rawQuery(query,null);
        if (c != null){
            c.moveToFirst();
        }

        return c;
    }

    public void modificarPersona(Persona persona){
        ContentValues values = new ContentValues();
        values.put(COLUMNA_DOCUMENTO,persona.getDocumento());
        values.put(COLUMNA_NOMBRE,persona.getNombre());
        values.put(COLUMNA_CONTACTO, persona.getContacto());
        SQLiteDatabase bd =  getWritableDatabase();
        bd.update(DATABASE_TABLE,values, COLUMNA_DOCUMENTO + " = ?",new String[]{String.valueOf(persona.getDocumento())});
        bd.close();
    }
}
