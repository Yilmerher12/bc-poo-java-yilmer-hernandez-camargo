package com.consultoria.modelo;

// Clase Padre Abstracta
public abstract class Consultor {

    //ATRIBUTOS
    protected final String idConsultor;
    protected final String nombreConsultor;
    protected final String especialidadConsultor;
    protected final double tarifaPorHoraBase;
    protected final int anosDeServicio;

    // Constructor que recibe todos los 5 datos
    public Consultor(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHoraBase, int anosDeServicio) {
        this.idConsultor = idConsultor;
        this.nombreConsultor = nombreConsultor;
        this.especialidadConsultor = especialidadConsultor;
        this.tarifaPorHoraBase = tarifaPorHoraBase;
        this.anosDeServicio = anosDeServicio;
    }

    // --- Getters Requeridos ---

    public String getIdConsultor() {
        return idConsultor;
    }
    public String getNombreConsultor() {
        return nombreConsultor;
    }
    public String getEspecialidadConsultor() {
        return especialidadConsultor;
    }
    public double getTarifaPorHoraBase() {
        return tarifaPorHoraBase;
    } // <-- CORREGIDO EL GETTER
    public int getAnosDeServicio() {
        return anosDeServicio;
    }

    // --- Métodos Abstractos (Polimorfismo) ---
    public abstract String obtenerDescripcion();
    public abstract double calcularCostoMensualEstimado(int horas);
}