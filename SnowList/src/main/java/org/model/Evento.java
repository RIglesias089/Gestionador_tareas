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

    //Implementamos los gettes y setters de la clase
    public String getId() { return id_evento; }
    public void setId(String id_evento) { this.id_evento = id_evento; }

    public String getNombre() { return nombre_evento; }
    public void setNombre(String nombre_evento) { this.nombre_evento = nombre_evento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Usuario getCreador() { return creador; }
    public void setCreador(Usuario creador) { this.creador = creador; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getColor() { return color != null ? color : "#f1f1f1"; }
    public void setColor(String color) { this.color = color; }

    public List<Usuario> getColaboradores() { return colaboradores; }
    public void setColaboradores(List<Usuario> colaboradores) { this.colaboradores = colaboradores; }

    public void agregarColaborador(Usuario usuario) {
        if (usuario != null && !colaboradores.contains(usuario)) {
            colaboradores.add(usuario);
        }
    }

    public String getNotificacionTexto() {
        return tipo + " '" + nombre_evento + "' programado para " + fecha + ".";
    }

    
}
