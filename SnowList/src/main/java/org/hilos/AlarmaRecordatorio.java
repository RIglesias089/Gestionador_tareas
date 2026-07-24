package org.hilos;

import org.model.Recordatorio;

import java.time.Duration;
import java.time.LocalDateTime;

public class AlarmaRecordatorio implements  Runnable{

    private Recordatorio  recordatorio;

    public AlarmaRecordatorio(Recordatorio recordatorio){
        this.recordatorio = recordatorio;
    }

    @Override
    public void run() { //Sobrescribimos el metodo de run (el cual recordemos es obligatorio al usar un Runnable

        long tiempoEspera = Duration.between( //Comenzamos a calcular el tiempo de espera para la alarma.
                //El Duration.between calcula la diferencia entre la hora exacta y la hora programada hasta el milisegundo
                LocalDateTime.now(), //Toma la hora exacta
                recordatorio.getHora() // Es la hora programada en el recordatorio
        ).toMillis(); //convierte la diferencia a milisegundos para terminar

        if(tiempoEspera > 0){ //Verifica que la hora este en futuro siendo mayor a 0
            try {
                Thread.sleep(tiempoEspera); //pone en reposo el tiempoespera por el tiempo que falte para llegar a la hora del recordatorio
            }catch (InterruptedException e){
                Thread.currentThread().interrupt(); //si es interrumpida este tirara un mensaje de qeu fue interrumpido
                System.out.println("la alarma fue interrumpida.");
                return;
            }
        }
        recordatorio.activarAlarma(); //llama la alarma
    }
}