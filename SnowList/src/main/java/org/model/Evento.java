package org.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Evento {

    protected String id_evento;
    protected String nombre_evento;
    protected String descripcion;
    protected Usuario creador;
    protected LocalDate fecha;
    protected String tipo;

    private String color;
    private List<Usuario> colaboradores;

    public Evento() {}

    public Evento(String id_evento, String nombre_evento, String descripcion, Usuario creador, LocalDate fecha) {
        this.id_evento = id_evento;
        this.nombre_evento = nombre_evento;
        this.descripcion = descripcion;
        this.creador = creador;
        this.fecha = fecha;
        this.tipo = "EVENTO";
        this.color = "#f1f1f1";
        this.colaboradores = new ArrayList<>();
    }

    
}
