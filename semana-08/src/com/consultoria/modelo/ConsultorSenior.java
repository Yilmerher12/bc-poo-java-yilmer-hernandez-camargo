package com.consultoria.modelo;
import java.util.ArrayList;
import java.util.List;

// Importamos la clase abstracta y las interfaces

import com.consultoria.modelo.Consultor;
import com.consultoria.modelo.Certificable;
import com.consultoria.modelo.Evaluable;


// Clase ConsultorJunior que hereda y tambien implementa una interfaz
public class ConsultorSenior extends Consultor implements Certificable, Evaluable {

    // Atributos necesarios para cumplir los contratos
    private List<String> certificaciones;
    private List<Double> puntuaciones;

    public ConsultorSenior(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHoraBase, int anosDeServicio) {
        super(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHoraBase, anosDeServicio);
        this.certificaciones = new ArrayList<>();
        this.puntuaciones = new ArrayList<>();
    }

    //MÉTODOS DE CLASE ABSTRACTA

    @Override
    public double calcularCostoMensualEstimado(int horasMensuales) {
        double costoBase = tarifaPorHoraBase * horasMensuales;
        double bono = costoBase * (anosDeServicio * 0.01);
        return costoBase + bono;
    }

    @Override
    public String obtenerDescripcion() {
        return "Nivel: SENIOR | Antigüedad: " + anosDeServicio + " años | Tarifa: " + tarifaPorHoraBase;
    }

    //MÉTODOS DE INTERFAZ CERTIFICABLE

    @Override
    public String listarCertificaciones() {
        if (certificaciones.isEmpty()) {
            return "Sin certificaciones registradas.";
        }
        return "Certificaciones: " + String.join(", ", certificaciones);
    }

    @Override
    public void registrarCertificacion(String nombreCertificacion, int vigenciaAnos) {
        this.certificaciones.add(nombreCertificacion + " (Vigencia: " + vigenciaAnos + " años)");
        System.out.println("Certificación '" + nombreCertificacion + "' registrada para " + nombreConsultor);
    }

    @Override
    public boolean verificarVigencia(String nombreCertificacion) {
        return certificaciones.stream().anyMatch(c -> c.contains(nombreCertificacion));
    }

    //MÉTODOS DE INTERFAZ EVALUABLE

    @Override
    public void agregarEvaluacion(double puntuacion, String comentario) {
        this.puntuaciones.add(puntuacion);
    }

    @Override
    public double obtenerPromedioEvaluacion() {
        if (puntuaciones.isEmpty()) return 0.0;
        double suma = 0;
        for (Double p : puntuaciones) {
            suma += p;
        }
        return suma / puntuaciones.size();
    }

    @Override
    public boolean esEvaluacionSuperior(double limitePuntuacion) {
        return obtenerPromedioEvaluacion() >= limitePuntuacion;
    }
}