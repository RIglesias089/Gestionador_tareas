package org.strategy;

public class NumeroNotificacion implements NotificacionesStrategy {

    //Hacemos la variable donde se guardara el numero de telefono
    private String telefono;

    //Creamos el constructor para poder hacer uso de este publicamente
    public NumeroNotificacion(String telefono) {
        this.telefono = telefono;
    }

    public NumeroNotificacion() {

    }

    @Override
    public void enviarnotificaion(String mensaje) {
        System.out.println("Enviando SMS al número: " + this.telefono);
        System.out.println("Mensaje enviado: " + mensaje);
        System.out.println("Notificación telefónica entregada con éxito.");
    }
}
