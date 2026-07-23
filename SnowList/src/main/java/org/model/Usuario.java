package org.model;

import org.interfaces.Autenticable;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario implements Autenticable {

    private String id_usuario;
    private String nombre_usuario;
    private String email;
    private String password;
    private boolean premiun;
    private String telefono;
    private int limiteColaboradores;

    private List<GestorWorkspace> workspaces;

    public Usuario() {}

    public Usuario(
            String id_usuario,
            String nombre_usuario,
            String email,
            String password,
            boolean premiun,
            String telefono
    ) {

        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.password = password;
        this.premiun = premiun;
        this.telefono = telefono;
        this.limiteColaboradores = 0;

        this.workspaces = new ArrayList<>();
    }

    public List<GestorWorkspace> getWorkspaces() {
        return workspaces;
    }

    //Plantemos todos los getters y setters

    public void setWorkspaces(List<GestorWorkspace> workspaces) {
        this.workspaces = workspaces;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gettelefono(){
        return telefono;
    }

    public void settelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPremiun() {
        return premiun;
    }

    public void setPremiun(boolean premiun) {
        this.premiun = premiun;
    }

    public int getLimiteColaboradores() {
        return limiteColaboradores;
    }

    public void setLimiteColaboradores(int limiteColaboradores) {
        this.limiteColaboradores = limiteColaboradores;
    }

    public abstract GestorWorkspace crearWorkspace(
            String idWorkspace,
            String nombreWorkspace,
            String descripcionWorkspace
    );

    public void incluirPersonasWorkspace(
            Usuario usuario,
            GestorWorkspace workspace
    ) {
        if (!workspaces.contains(workspace)) {
            System.out.println("El usuario no pertenece a este Workspace.");
            return;
        }
        workspace.agregarUsuario(usuario);
        System.out.println("Usuario agregado al Workspace: " + usuario.getNombre_usuario());
    }

    public void eliminarWorkspace(GestorWorkspace workspace) {
        if (workspaces.remove(workspace)) {
            System.out.println("Workspace eliminado por el usuario: " + nombre_usuario);
        } else {
            System.out.println("Workspace no encontrado.");
        }
    }

    @Override
    public Boolean autenticar(String email, String password) {

        return this.email.equals(email)
                && this.password.equals(password);
    }
}