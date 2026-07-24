package org.model;

import org.enums.Estado;
import org.enums.Prioridad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarea extends Evento {

    private Prioridad prioridad;
    private Estado estado;
    private List<ChecklistItem> checklist;

    public Tarea(
            String id_evento,
            String nombre_evento,
            String descripcion,
            Usuario creador,
            LocalDate fecha,
            Prioridad prioridad,
            Estado estado
    ) {

        super(id_evento, nombre_evento, descripcion, creador, fecha);

        this.tipo = "TAREA";
        this.prioridad = prioridad;
        this.estado = estado;
        this.checklist = new ArrayList<>();
        this.setColor(obtenerColorPorPrioridad(prioridad));
    }

    //Implementamos los getters y setters de la clase
    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
        this.setColor(obtenerColorPorPrioridad(prioridad));
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<ChecklistItem> getChecklist() {
        return checklist;
    }

    //Creamos los metodos necesarios en la clase

    public void agregarChecklistItem(String texto) {
        if (texto != null && !texto.isBlank()) {
            checklist.add(new ChecklistItem(texto));
        }
    }

    public void toggleChecklistItem(int index) {
        if (index >= 0 && index < checklist.size()) {
            checklist.get(index).setCompletado(!checklist.get(index).isCompletado());
        }
    }

    public void agregarColaborador(Usuario usuario) {
        if (usuario == null) {
            return;
        }

        if (creador != null && creador.getLimiteColaboradores() > 0 && getColaboradores().size() >= creador.getLimiteColaboradores()) {
            return;
        }

        if (!getColaboradores().contains(usuario)) {
            getColaboradores().add(usuario);
        }
    }

    public String getNotificacionTexto() {
        return "Tarea '" + nombre_evento + "' con prioridad " + prioridad + " y estado " + estado + " para " + fecha + ".";
    }

    public void notificar() {
        System.out.println("Notificación de tarea: " + getNotificacionTexto());
    }

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
        System.out.println("Estado actualizado: " + estado);
    }

    private String obtenerColorPorPrioridad(Prioridad prioridad) {
        return switch (prioridad) {
            case ALTA -> "#e74c3c";
            case MEDIA -> "#f1c40f";
            case BAJA -> "#2ecc71";
        };
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("ID: " + id_evento);
        System.out.println("Nombre: " + nombre_evento);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Creador: " + creador.getNombre_usuario());
        System.out.println("Fecha: " + fecha);
        System.out.println("Estado: " + estado);
        System.out.println("Prioridad: " + prioridad);

    }

    public static Tarea crearDesdeConsola(
            Scanner scanner,
            String id,
            Usuario creador
    ) {

        System.out.print("Nombre de la tarea: ");
        String nombre = scanner.nextLine();

        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();

        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        System.out.print("Prioridad (ALTA/MEDIA/BAJA): ");
        Prioridad prioridad = Prioridad.valueOf(
                scanner.nextLine().toUpperCase()
        );

        System.out.print("Estado (PENDIENTE/EN_PROGRESO/COMPLETADO/CANCELADA): ");
        Estado estado = Estado.valueOf(
                scanner.nextLine().toUpperCase()
        );

        return new Tarea(
                id,
                nombre,
                descripcion,
                creador,
                fecha,
                prioridad,
                estado
        );

    }

    public static class ChecklistItem {
        private String texto;
        private boolean completado;

        public ChecklistItem(String texto) {
            this.texto = texto;
            this.completado = false;
        }

        public String getTexto() { return texto; }
        public boolean isCompletado() { return completado; }
        public void setCompletado(boolean completado) { this.completado = completado; }
    }
}