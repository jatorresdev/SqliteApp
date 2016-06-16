package com.example.aprendiz.sqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by APRENDIZ on 10/06/2016.
 */
public class PreModificar extends AppCompatActivity {

    EditText busquedadoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_modificar);
        busquedadoc = (EditText) findViewById(R.id.txt_docBusqueda);
    }

    // Metodo para el boton premodificar
    public void modificarOnClick(View mv) {
        Intent i = new Intent(this, Modificar.class);
        busquedadoc = (EditText) findViewById(R.id.txt_docBusqueda);
        i.putExtra("id", busquedadoc.getText().toString());
        startActivity(i);
    }
}
