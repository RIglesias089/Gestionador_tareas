package org.model;

import java.util.ArrayList;
import java.util.List;

public class GestorWorkspace {

    private String id_gestor;
    private String nombre_gestor;
    private String descripcion;

    private List<Usuario> miembros;

    private List<Evento> eventos;
    private Usuario creador;

    public GestorWorkspace(
            String id_gestor,
            String nombre_gestor,
            String descripcion,
            List<Usuario> miembros,
            Usuario creador
    ) {

        this.id_gestor = id_gestor;
        this.nombre_gestor = nombre_gestor;
        this.descripcion = descripcion;

        this.miembros = miembros;
        this.eventos = new ArrayList<>();
        this.creador = creador;

    }

    //Implementamos los getters y setters respectivos para el gestor de workspace
    public String getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(String id_gestor) {
        this.id_gestor = id_gestor;
    }

    public String getNombre_gestor() {
        return nombre_gestor;
    }

    public void setNombre_gestor(String nombre_gestor) {
        this.nombre_gestor = nombre_gestor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Usuario> miembros) {
        this.miembros = miembros;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

}
