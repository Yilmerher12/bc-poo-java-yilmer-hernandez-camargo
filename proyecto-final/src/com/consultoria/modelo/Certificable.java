package com.consultoria.modelo;

public interface Certificable {

    // Métodos que tu ConsultorSenior espera implementar
    String listarCertificaciones();
    void registrarCertificacion(String nombreCertificacion, int vigenciaAnos);
    boolean verificarVigencia(String nombreCertificacion);

}