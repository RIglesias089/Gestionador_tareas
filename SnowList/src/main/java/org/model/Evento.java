package org.model;

public class Evento {
    //Planteamos los atributos
    protected String id_usuario;
    protected String nombre_usuario;
    protected String descripcion;
    protected String tipo;
    private String color;

    //Planteamos el constructor de la clase
    public Evento (
            String id_evento,
            String nombre_evento,
            String descripcion
    ){
        this.id_usuario = id_evento;
        this.nombre_usuario = nombre_evento;
        this.descripcion = descripcion;

    }
}
