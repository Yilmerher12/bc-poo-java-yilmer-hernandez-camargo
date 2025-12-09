package com.consultoria.modelo;

// Interfaz
public interface Certificable {

    String listarCertificaciones();

    void registrarCertificacion(String nombreCertificacion, int vigenciaAnos);

    boolean verificarVigencia(String nombreCertificacion);
}