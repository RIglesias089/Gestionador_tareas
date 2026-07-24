package org.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPremium extends Usuario {

    private int limite_grupos;
    private LocalDate fechaExpiracion;

    public UsuarioPremium(
            String id_usuario,
            String nombre_usuario,
            String email,
            String contrasena
    ) {
        super(id_usuario, nombre_usuario, email, contrasena, true, "");
        this.limite_grupos = 6;
        this.setLimiteColaboradores(6);
        this.fechaExpiracion = LocalDate.now().plusMonths(1);
    }

    public int getLimite_grupos() {
        return limite_grupos;
    }

    public void renovarPremiun() {

        if (fechaExpiracion.isAfter(LocalDate.now())) {
            fechaExpiracion = fechaExpiracion.plusMonths(1);
        } else {
            fechaExpiracion = LocalDate.now().plusMonths(1);
        }

        System.out.println("Premiun renovado para " + getNombre_usuario() +
                ". Nueva fecha de expiración: " + fechaExpiracion);
    }

    public void verTiempoRestante() {

        if (fechaExpiracion.isAfter(LocalDate.now())) {
            System.out.println("El usuario " + getNombre_usuario() +
                    " tiene premiun hasta: " + fechaExpiracion);
        } else {
            System.out.println("El premiun ha expirado para " + getNombre_usuario());
        }
    }

    public Usuario veriicarEpiracion() {

        if (fechaExpiracion.isBefore(LocalDate.now())) {

            System.out.println("El premiun de " + getNombre_usuario() + " ha expirado.");

            UsuarioClasico clasico = new UsuarioClasico(
                    this.getId_usuario(),
                    this.getNombre_usuario(),
                    this.getEmail(),
                    this.getPassword(),
                    false
            );

            clasico.setWorkspaces(this.getWorkspaces());

            return clasico;
        }

        return this;
    }


    @Override
    public GestorWorkspace crearWorkspace(String idWorkspace, String nombreWorkspace, String descripcionWorkspace) {

        //validar limites
        if (getWorkspaces().size() >= limite_grupos) {
            System.out.println("El usuario " + getNombre_usuario() +
                    " ha alcanzado el límite de Workspaces (5).");
            return null;
        }

        //crear Workspace normalmente
        List<Usuario> miembros = new ArrayList<>();
        miembros.add(this);

        GestorWorkspace nuevoGestorWorkspace = new GestorWorkspace(
                idWorkspace,
                nombreWorkspace,
                descripcionWorkspace,
                miembros,
                this
        );

        getWorkspaces().add(nuevoGestorWorkspace);

        System.out.println("Se ha creado un nuevo Workspace: "
                + nombreWorkspace +
                " por el usuario: " + getNombre_usuario());

        return nuevoGestorWorkspace;
    }
}