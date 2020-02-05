package com.educomser.entity;

import java.io.Serializable;

public class Email implements Serializable {

    private int id;
    private String correo;
    //-----------------------------
    private Persona persona;
    //-----------------------------

    public Email() {
    }

    public Email(String correo, Persona persona) {
        this.correo = correo;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Email{" + "id=" + id + ", correo=" + correo + ", persona=" + persona + '}';
    }

}
