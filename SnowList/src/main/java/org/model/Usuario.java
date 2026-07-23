package org.model;

/*Importamos la interfaz auteticable y Tambien importamos un list,
 para poder permitir que podamos crear listas dinamicas para la funcionalidad de guardar los usuarios*/
import org.interfaces.Autenticable;
import java.util.ArrayList;
import java.util.List;

/*Hacemos que la clase implemente el autenticable Es importante saber que al ser abstracta esta no puede inicializar objetos*/
public abstract class Usuario implements Autenticable{

    //Primero empezamos planteando los distintos atributos de la clase
    private String id_usuario;
    private String nombre_usuario;
    private String email;
    private String password;
    private boolean premium;
    private String telefono;
    private int limiteColaboradores;

    //Creamos una lista dinamica para el gestor de Workspace
    private List<GestorWorkspace> worksapce;

    //Para poder usar los atributos de la clase planteamos un constructor
    //Este mismo inicializa los objetos
    public Usuario(String id_usuario,
                   String nombre_usuario,
                   String email,
                   String password,
                   boolean premium,
                   String telefono) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.password = password;
        this.premium = premium;
        this.telefono = telefono;
        this.limiteColaboradores = 0;

        this.worksapce = new ArrayList<>();
    }

    //Creamos el getter o capturador para crear un workspace
    public List<GestorWorkspace> getWorksapce() {
        return worksapce;
    }

    //Creamos el setter o lector para ver si hay nuevos workspace
    public void setWorksapce(List<GestorWorkspace> worksapce) {
        this.worksapce = worksapce;
    }

    //Creamos los getters y setters para le resto de datos
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
        return premium;
    }

    public void setPremiun(boolean premium) {
        this.premium = premium;
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

    

}