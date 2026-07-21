package org.model;

//Implementamos un extends para aque herede de la clase padre Usuario
public class UsuarioPremium extends Usuario{
    //planteamos el limite de grupos que tendra esta clase
    private int limite_grupos;

    //hacemos el constructor para esta clase
    public usuarioPremium(
            String id_usuario,
            String nombre_usuario,
            String email,
            String contrasena
    ){ //Hacemos la conexion con el constructor de la clase padre
        super(id_usuario, nombre_usuario, email, contrasena,true, "");
        this.limite_grupos = 6;
    }
}
