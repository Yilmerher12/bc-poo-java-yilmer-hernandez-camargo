package interfaces;

//Interface
public interface Evaluable {

    void agregarEvaluacion(double puntuacion, String comentario);

    double obtenerPromedioEvaluacion();

    boolean esEvaluacionSuperior(double limitePuntuacion);
}