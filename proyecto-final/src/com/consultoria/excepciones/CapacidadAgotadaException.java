package com.consultoria.excepciones;

public class CapacidadAgotadaException extends Exception {

    public CapacidadAgotadaException(String mensaje) {
        super(mensaje);
    }

    public CapacidadAgotadaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}