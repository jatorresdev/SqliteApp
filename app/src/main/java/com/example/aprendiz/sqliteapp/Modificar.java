package com.example.aprendiz.sqliteapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


/**
 * Created by APRENDIZ on 10/06/2016.
 */
public class Modificar extends AppCompatActivity {

    MyBDSqlite base;
    EditText documento, nombre, apellido, contacto, email;
    String id;
    int vdocumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar);

        documento = (EditText) findViewById(R.id.txt_documento);
        nombre = (EditText) findViewById(R.id.txt_nombre);
        apellido = (EditText) findViewById(R.id.txt_apellido);
        contacto = (EditText) findViewById(R.id.txt_contacto);
        email = (EditText) findViewById(R.id.txt_email);

        base = new MyBDSqlite(this);

        Intent i = getIntent();
        id = i.getStringExtra("id");
        vdocumento = Integer.parseInt(id);
        Cursor c = base.buscarPersonaModificar(vdocumento);

        //Cargamos los datos del cursor a nuestra interface
        documento.setText(c.getString(c.getColumnIndexOrThrow("_id")));
        nombre.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
        apellido.setText(c.getString(c.getColumnIndexOrThrow("apellido")));
        contacto.setText(c.getString(c.getColumnIndexOrThrow("contacto")));
        email.setText(c.getString(c.getColumnIndexOrThrow("email")));
    }

    public void confirmarModificar(View mv) {
        Persona persona = new Persona(Integer.parseInt(documento.getText().toString()),
                nombre.getText().toString(),
                apellido.getText().toString(),
                Integer.parseInt(contacto.getText().toString()),
                email.getText().toString());

        persona.setDocumento(Integer.parseInt(documento.getText().toString()));
        base.modificarPersona(persona);
        limpiarCampos();
    }

    public void limpiarCampos() {
        documento.setText("");
        nombre.setText("");
        apellido.setText("");
        contacto.setText("");
        email.setText("");
    }
}
