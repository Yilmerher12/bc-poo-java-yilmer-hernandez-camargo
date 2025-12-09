package com.consultoria.modelo;

public interface Evaluable {

    // Métodos que tu ConsultorSenior espera implementar
    void agregarEvaluacion(double puntuacion, String comentario);
    double obtenerPromedioEvaluacion();
    boolean esEvaluacionSuperior(double limitePuntuacion);

}