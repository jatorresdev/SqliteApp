package com.example.aprendiz.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyBDSqlite database;
    EditText documento, nombre, contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        documento = (EditText) findViewById(R.id.et_documento);
        nombre = (EditText) findViewById(R.id.et_nombre);
        contacto = (EditText) findViewById(R.id.et_contacto);

        database = new MyBDSqlite(this);
    }

    public void onClickAgregar(View myView) {
        Persona persona = new Persona(Integer.parseInt(documento.getText().toString()),
                nombre.getText().toString(),
                Integer.parseInt(contacto.getText().toString()));

        database.agregarPersona(persona);

        limpiarCampos();
    }

    public void limpiarCampos() {
        documento.setText("");
        nombre.setText("");
        contacto.setText("");
    }
}
