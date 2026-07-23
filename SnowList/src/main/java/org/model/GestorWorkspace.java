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

    public void agregarUsuario(Usuario usuario) {

        if (!miembros.contains(usuario)) {
            miembros.add(usuario);
        }

        if (!usuario.getWorkspaces().contains(this)) {
            usuario.getWorkspaces().add(this);
        }

    }

    public void agregarEvento(Evento evento) {

        eventos.add(evento);
        System.out.println("Evento agregado al Workspace: " + evento.getNombre());

    }

    public void editarEventos(Evento evento, String nuevoNombre, String nuevaDescripcion) {

        if (eventos.contains(evento)) {
            evento.setNombre(nuevoNombre);
            evento.setDescripcion(nuevaDescripcion);
            System.out.println("Evento editado: " + evento.getNombre());
        } else {
            System.out.println("Evento no encontrado en el Workspace.");
        }
    }

    public void eliminarEventos(Evento evento) {

        if (eventos.remove(evento)) {
            System.out.println("Evento eliminado del Workspace.");
        } else {
            System.out.println("Evento no encontrado en el Workspace.");
        }
    }

    public void mostrarInfoGrupo() {

        System.out.println("=== INFORMACIÓN DEL GESTOR ===");
        System.out.println("ID: " + id_gestor);
        System.out.println("Nombre: " + nombre_gestor);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Creador: " + creador.getNombre_usuario());

        System.out.println("\n--- Miembros del gestor ---");

        if (miembros.isEmpty()) {

            System.out.println("No hay miembros en el gestor.");

        } else {

            for (Usuario u : miembros) {

                System.out.println("- " + u.getNombre_usuario());

            }

        }

        System.out.println("=============================");

    }

}