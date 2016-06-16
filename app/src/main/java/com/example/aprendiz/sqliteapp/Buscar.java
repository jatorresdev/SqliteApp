package com.example.aprendiz.sqliteapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by APRENDIZ on 03/06/2016.
 */
public class Buscar extends AppCompatActivity {
    MyBDSqlite base;
    ListView lista;
    SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_datos);

        base = new MyBDSqlite(this);
        bd = base.getWritableDatabase();
        Cursor cursor = base.buscarPersonas();
        final TodoCursorAdapter todoCursorAdapter = new TodoCursorAdapter(this, cursor);

        lista = (ListView) findViewById(R.id.lista_datos);
        lista.setAdapter(todoCursorAdapter);
        lista.setTextFilterEnabled(true);
    }
}
