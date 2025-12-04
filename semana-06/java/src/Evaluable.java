public interface Evaluable {

    //Metodos
    void agregarEvaluacion(double puntuacion, String comentario);

    double obtenerPromedioEvaluacion();

    boolean esEvaluacionSuperior(double limitePuntuacion);
}