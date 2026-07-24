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
}
