package com.example.aprendiz.sqliteapp;

/**
 * Created by APRENDIZ on 02/06/2016.
 */
public class Persona {
    private int documento;
    private String nombre;
    private String apellido;
    private int contacto;
    private String email;

    // Constructor
    public Persona() {
        super();
    }

    public Persona(int documento, String nombre, String apellido, int contacto, String email) {
        this.setDocumento(documento);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setContacto(contacto);
        this.setEmail(email);
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
