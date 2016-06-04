package com.example.aprendiz.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyBDSqlite database;
    EditText documento, nombre, apellido, contacto, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        documento = (EditText) findViewById(R.id.et_documento);
        nombre = (EditText) findViewById(R.id.et_nombre);
        apellido = (EditText) findViewById(R.id.et_apellido);
        contacto = (EditText) findViewById(R.id.et_contacto);
        email = (EditText) findViewById(R.id.et_email);

        database = new MyBDSqlite(this);
    }

    public void onClickAgregar(View myView) {
        Persona persona = new Persona(Integer.parseInt(documento.getText().toString()),
                nombre.getText().toString(),
                apellido.getText().toString(),
                Integer.parseInt(contacto.getText().toString()),
                email.getText().toString());

        database.agregarPersona(persona);

        limpiarCampos();
    }

    public void mostrarLista (View my){
        Intent intent = new Intent(getApplicationContext(), Buscar.class);
        startActivity(intent);
    }

    public void limpiarCampos() {
        documento.setText("");
        nombre.setText("");
        apellido.setText("");
        contacto.setText("");
        email.setText("");
    }
}
