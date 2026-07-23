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

}
