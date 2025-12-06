package com.consultoria.modelo;

import java.util.ArrayList;
import java.util.List;

import com.consultoria.modelo.Consultor;
import com.consultoria.modelo.Evaluable;


// Clase ConsultorJunior que hereda y tambien implementa una interfaz
public class ConsultorJunior extends Consultor implements Evaluable {

    private static final double TARIFA_FIJA_REDUCIDA = 40.0;
    private List<Double> puntuaciones;

    public ConsultorJunior(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHoraBase, int anosDeServicio) {
        super(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHoraBase, anosDeServicio);
        this.puntuaciones = new ArrayList<>();
    }

    //MÉTODOS DE CLASE ABSTRACTA

    @Override
    public double calcularCostoMensualEstimado(int horasMensuales) {
        return TARIFA_FIJA_REDUCIDA * horasMensuales;
    }

    @Override
    public String obtenerDescripcion() {
        return "Nivel: JUNIOR | Tarifa Fija: " + TARIFA_FIJA_REDUCIDA;
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