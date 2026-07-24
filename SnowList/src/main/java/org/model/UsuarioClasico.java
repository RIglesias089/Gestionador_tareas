package org.model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioClasico extends Usuario {

    private int limite_grupos;

    public UsuarioClasico(
            String id_usuario,
            String nombre_usuario,
            String email,
            String contrasena,
            boolean premiun
    ) {
        super(id_usuario, nombre_usuario, email, contrasena, premiun, "");
        this.limite_grupos = 2;
        this.setLimiteColaboradores(2);
    }

    public int getLimite_grupos() {
        return limite_grupos;
    }

    public UsuarioPremium volversePremiun() {

        UsuarioPremium nuevoPremium = new UsuarioPremium(
                this.getId_usuario(),
                this.getNombre_usuario(),
                this.getEmail(),
                this.getPassword()
        );

        nuevoPremium.setWorkspaces(this.getWorkspaces());

        System.out.println("El usuario " + getNombre_usuario() + " ahora es PREMIUM");

        return nuevoPremium;
    }

    @Override
    public GestorWorkspace crearWorkspace(String idWorkspace, String nombreWorkspace, String descripcionWorkspace) {

        //validar limites
        if (getWorkspaces().size() >= limite_grupos) {
            System.out.println("El usuario " + getNombre_usuario() +
                    " ha alcanzado el límite de Workspaces (2).");
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