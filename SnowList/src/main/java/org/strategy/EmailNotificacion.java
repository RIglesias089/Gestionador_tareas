package org.strategy;

public class EmailNotificacion implements NotificacionesStrategy{

    @Override
    public void enviarnotificaion(String mensaje) {
        System.out.println("Correo enviado: " + mensaje);
    }
}
