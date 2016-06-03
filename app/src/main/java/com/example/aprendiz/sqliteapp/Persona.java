package com.example.aprendiz.sqliteapp;

/**
 * Created by APRENDIZ on 02/06/2016.
 */
public class Persona {
    private int documento;
    private String nombre;
    private int contacto;

    // Constructor
    public Persona(){
        super();
    }

    public Persona(int documento, String nombre, int contacto){
        this.setDocumento(documento);
        this.setNombre(nombre);
        this.setContacto(contacto);
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }
}
