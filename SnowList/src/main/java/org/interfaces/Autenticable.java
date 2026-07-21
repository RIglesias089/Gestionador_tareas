package org.interfaces;

//Creamos un interface que obligara a untenticar el correo y password
public interface Autenticable {

    //Hacemos que vea que el correo y password cumplan que son iguales
    Boolean autenticar(String email, String password);
}
