# Análisis de Polimorfismo - Consultoría de Proyectos

## 1. Sobrecarga (Overloading)

### Métodos Sobrecargados

Se implementó la sobrecarga en la clase **`GestorProyectos.java`** con el método `buscarConsultor`, permitiendo tres formas distintas de búsqueda:

1.  `buscarConsultor(String id)`: Búsqueda por el código único del consultor.
2.  `buscarConsultor(String especialidad, boolean esEspecialidad)`: Búsqueda por el área de especialización.
3.  `buscarConsultor(int anosMinimos, int anosMaximos)`: Búsqueda por un rango de años de servicio.

### Justificación

La sobrecarga tiene sentido en la clase gestora, ya que es la responsable de manejar la colección de consultores. Permite que la interfaz de búsqueda sea **simple y consistente**, usando un único nombre (`buscarConsultor`) para satisfacer distintas necesidades del usuario sin obligarlo a recordar múltiples nombres de métodos.

---

## 2. Sobrescritura (Overriding)

La sobrescritura se implementó en las subclases `ConsultorSenior` y `ConsultorJunior` para modificar el comportamiento heredado del Padre (`Consultor`).

### Tabla Comparativa

| Método | Clase Padre (`Consultor`) | Subclase 1 (`ConsultorSenior`) | Subclase 2 (`ConsultorJunior`) |
| :--- | :--- | :--- | :--- |
| `calcularCostoMensualEstimado()` | Tarifa base * horas. | **Sobrescribe:** Agrega un bono del 1% del costo base por cada año de servicio. | **Sobrescribe:** Ignora la tarifa base y usa una tarifa fija reducida. |
| `obtenerDescripcion()` | Retorna la descripción base y genérica. | **Sobrescribe:** Retorna la descripción detallada del nivel y antigüedad. | **Sobrescribe:** Retorna la descripción del nivel y la tarifa fija. |

### Código Ejemplo (`ConsultorSenior.java`)

```java
// Ejemplo de sobrescritura de costo
@Override
public double calcularCostoMensualEstimado(int horasMensuales) {
    double costoBase = super.calcularCostoMensualEstimado(horasMensuales);
    double bono = costoBase * (getAnosDeServicio() * 0.01); 
    return costoBase + bono;
}

// Ejemplo de sobrescritura de descripción
@Override
public String obtenerDescripcion() {
    return "CONSULTOR SENIOR: " + getNombreConsultor() + " | Antigüedad: " + getAnosDeServicio() + " años";
}