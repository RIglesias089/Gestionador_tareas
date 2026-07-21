package org.model;

public class Usuario {

    //Primero empezamos planteando los distintos atributos de la clase
    private String id_usuario;
    private String nombre_usuario;
    private String email;
    private String password;
    private boolean premiun;
    private String telefono;

    //Para poder usar los atributos de la clase planteamos un constructor
    //Este mismo inicializa los objetos

    public Usuario(String id_usuario,
                   String nombre_usuario,
                   String email,
                   String password,
                   boolean premium,
                   String telefono) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.password = password;
        this.premiun = premiun;
        this.telefono = telefono;
    }

}