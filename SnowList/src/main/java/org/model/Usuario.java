package org.model;

//importamos la interfaz autenticable
import org.interfaces.Autenticable;
//Tambien importamos un list, para poder permitir que podamos crear listas dinamicas para la funcionalidad de guardar los usuarios
import java.util.ArrayList;
import java.util.List;

/*Hacemos que la clase implemente el autenticable Es importante saber que al ser abstracta esta no puede inicializar objetos*/
public abstract class Usuario implements Autenticable{

    //Primero empezamos planteando los distintos atributos de la clase
    private String id_usuario;
    private String nombre_usuario;
    private String email;
    private String password;
    private boolean premium;
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
        this.premium = premium;
        this.telefono = telefono;
    }

}