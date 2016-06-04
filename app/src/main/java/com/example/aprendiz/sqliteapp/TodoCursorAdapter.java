package com.example.aprendiz.sqliteapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by APRENDIZ on 03/06/2016.
 */
public class TodoCursorAdapter extends CursorAdapter {
    TextView documento, nombre, contacto;
    int vdocumento, vcontacto;
    String vnombre;

    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.mostrar_datos, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        documento = (TextView) view.findViewById(R.id.et_documento);
        nombre = (TextView) view.findViewById(R.id.et_nombre);
        contacto = (TextView) view.findViewById(R.id.et_contacto);
        vdocumento = cursor.getInt(cursor.getColumnIndex("documento"));
        vnombre = cursor.getString(cursor.getColumnIndex("nombre"));
        vcontacto = cursor.getInt(cursor.getColumnIndex("contacto"));

        documento.setText(String.valueOf(vdocumento));
        nombre.setText(vnombre);
        contacto.setText(String.valueOf(vcontacto));
    }

}
