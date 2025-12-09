package com.consultoria.excepciones;

public class ContratoInvalidoException extends Exception {

    // Constructor 1: Solo mensaje
    public ContratoInvalidoException(String mensaje) {
        super(mensaje);
    }

    // Constructor 2: Mensaje y causa (para anidar otro error)
    public ContratoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
