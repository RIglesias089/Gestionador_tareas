package org.model;

public class GestorWorkspace {
    //Planteamos sus atributos
    private String id_gestor;
    private String nombre_gestor;
    private String descripcion;

    //Creamos el constructor de el GestoWorkspace
    public gestorWorkspace(
            String id_gestor,
            String nombre_gestor,
            String descripcion
    ){
        this.id_gestor = id_gestor;
        this.nombre_gestor = nombre_gestor;
        this.descripcion = descripcion;

    }

}
