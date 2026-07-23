package org.model;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.strategy.EmailNotificacion;
import org.strategy.NotificacionesStrategy;
import org.strategy.NumeroNotificacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recordatorio extends Evento {

    private LocalDateTime Hora;
    private List<NotificacionesStrategy> estrategias;

    public Recordatorio(
            String id_evento,
            String nombre_evento,
            String descripcion,
            Usuario creador,
            LocalDate fecha,
            LocalDateTime Hora
    ) {
        super(id_evento, nombre_evento, descripcion, creador, fecha);

        this.tipo = "RECORDATORIO";
        this.Hora = Hora;
        this.estrategias = new ArrayList<>();
        this.setColor("#8e44ad");

        if (creador != null) {
            this.estrategias.add(new NumeroNotificacion(creador.gettelefono()));
            this.estrategias.add(new EmailNotificacion());
        }
    }

    public LocalDateTime getHora() {
        return Hora;
    }

    public void setHora(LocalDateTime Hora) {
        this.Hora = Hora;
    }

    public List<NotificacionesStrategy> getEstrategias() {
        return estrategias;
    }

    public void setEstrategias(List<NotificacionesStrategy> estrategias) {
        this.estrategias = estrategias;
    }

    public void setEstrategia(NotificacionesStrategy estrategia) {
        this.estrategias = new ArrayList<>();
        this.estrategias.add(estrategia);
    }

    @Override
    public void agregarColaborador(Usuario usuario) {
        if (usuario == null || creador == null) {
            return;
        }
        if (getColaboradores().size() >= creador.getLimiteColaboradores()) {
            System.out.println("No se puede agregar más colaboradores. Límite alcanzado: " + creador.getLimiteColaboradores());
            return;
        }
        super.agregarColaborador(usuario);
    }

    public void notificar() {
        System.out.println("Notificación de recordatorio programado: " + getNotificacionTexto());
    }

    public void activarAlarma() {
        String mensaje = "ALARMA ACTIVADA - Recordatorio: "
                + nombre_evento
                + " | Descripcion: "
                + descripcion
                + " | Fecha: "
                + fecha
                + " | Hora: "
                + Hora;

        if (creador != null) {
            mensaje += " | Creador: " + creador.getNombre_usuario();
        } else {
            mensaje += " | Creador: (no definido)";
        }

        for (NotificacionesStrategy estrategia : estrategias) {
            estrategia.enviarnotificaion(mensaje);
        }

        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Recordatorio");
            alert.setHeaderText("Recordatorio activado");
            alert.setContentText(getNotificacionTexto());
            alert.showAndWait();
        });
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====== RECORDATORIO ======");
        System.out.println("ID: " + id_evento);
        System.out.println("Nombre: " + nombre_evento);
        System.out.println("Descripcion: " + descripcion);

        if (creador != null) {
            System.out.println("Creador: " + creador.getNombre_usuario());
            System.out.println("Telefono del Creador: " + creador.gettelefono());
        } else {
            System.out.println("Creador no definido");
        }

        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + Hora);
    }

    public String getNotificacionTexto() {
        return "Recordatorio '" + nombre_evento + "' programado para " + fecha + " a las " + Hora + ".";
    }

    public static Recordatorio crearDesdeConsola(
            Scanner scanner,
            String id,
            Usuario creador
    ) {
        System.out.print("Nombre del recordatorio: ");
        String nombre = scanner.nextLine();

        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();

        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(scanner.nextLine());

        System.out.print("Hora (HH:MM): ");
        String horaStr = scanner.nextLine();

        LocalDateTime Hora = LocalDateTime.parse(
                fecha + "T" + horaStr + ":00"
        );

        return new Recordatorio(
                id,
                nombre,
                descripcion,
                creador,
                fecha,
                Hora
        );
    }
}
