// Es una interfaz
public interface Certificable {

    //Metodos
    String listarCertificaciones();

    void registrarCertificacion(String nombreCertificacion, int vigenciaAnos);

    boolean verificarVigencia(String nombreCertificacion);
}