package org.model;

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
        //mas adelante buscaremos implementar los limites de colaboradores que habran por grupo
    }

}