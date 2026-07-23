package org.model;

import java.util.ArrayList;
import java.util.List;

//Implementamos un extends para que haga herencia de Usuario a esta clase
public class UsuarioClasico extends Usuario {

    //planteamos la limitenate de grupos
    private int limite_grupos;

    //Planteamos el constructor de esta clase
    public UsuarioClasico(
            String id_usuario,
            String nombre_usuario,
            String email,
            String contrasena,
            boolean premiun

    ) { //Hacemos la conexion de contructores con la clase padre con el uso de "super"
        super(id_usuario, nombre_usuario, email, contrasena, premiun, "");
        this.limite_grupos = 2; //damos el valor limite de grupos que puede tener el usuario clasico
        this.setLimiteColaboradores(2); //Limites de colaboradores en el grupo
    }

    public int getLimite_grupos() {
        return limite_grupos;
    }

    public UsuarioPremium volversePremium(){

        UsuarioPremium nuevoPremium = new UsuarioPremium(
                this.getId_usuario(),
                this.getNombre_usuario(),
                this.getEmail(),
                this.getPassword()
        );

        nuevoPremium.setWorksapce(this.getWorksapce());

        System.out.println("El usuario " + getNombre_usuario() + " Ahora es Premium");
        return nuevoPremium;
    }

    @Override
    public GestorWorkspace crearWorkspace(String idWorkspace, String nombreWorkspace, String descripcionWorkspace){
        //Validamos los limites
        if (getWorksapce().size() >= limite_grupos) {
            System.out.println("El usuario " + getNombre_usuario() + " Ha alcanzado el limite de workspace (2)");
            return null;
        }
    }
}