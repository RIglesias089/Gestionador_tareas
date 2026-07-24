package org.strategy;

//Crearemos el area de strategys para poder hacer las notificaciones para los recordatorios que se guarden
//para este primero plantearemos que sera una interface para que se implemente

public interface NotificacionesStrategy {
    void enviarnotificaion(String mensaje);
}
