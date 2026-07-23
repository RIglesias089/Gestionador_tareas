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

    //Implementamos los getters y setters de la clase
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

    //Creamos los override necesarios
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

    

}
