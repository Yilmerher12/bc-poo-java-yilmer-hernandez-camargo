# Semana 06: Abstracción e Interfaces

## Dominio
**Agencia de Consultoría de Proyectos**

## Descripción
Este sistema gestiona los **Consultores** (Senior y Junior) de la agencia. Utiliza una **Clase Abstracta** (`Consultor`) para forzar la implementación de reglas de negocio esenciales (cálculo de costos) y **Interfaces** para definir capacidades específicas (ser `Certificable` o `Evaluable`), demostrando el Polimorfismo y la Múltiple Implementación.

---

## Clases Abstractas Implementadas

### Consultor

- **Propósito:** Servir como el **molde base** para todos los tipos de consultores. Impide la creación de objetos genéricos (`new Consultor()`) y establece un **contrato** para las subclases.
- **Métodos abstractos:**
  - `calcularCostoMensualEstimado(int horasMensuales)`: Calcula el costo total del consultor, usando lógica específica para Senior o Junior.
  - `obtenerDescripcion()`: Genera una descripción del nivel y datos relevantes del consultor.
- **Métodos concretos:**
  - `mostrarInformacionBasica()`: Muestra el ID, nombre y especialidad (comportamiento compartido por todos).
- **Subclases:**
  - `ConsultorSenior`
  - `ConsultorJunior`

---

## Interfaces Implementadas

### Certificable

- **Capacidad:** Define la capacidad de un objeto para **gestionar, registrar y verificar certificaciones** formales.
- **Métodos:**
  - `listarCertificaciones()`: Devuelve un `String` con la lista de certificaciones.
  - `registrarCertificacion(String nombreCertificacion, int vigenciaAnos)`: Añade un nuevo certificado al registro interno.
- **Implementada por:**
  - `ConsultorSenior` (Solo los Senior tienen esta responsabilidad en el diseño).

### Evaluable

- **Capacidad:** Define la capacidad de un objeto para **ser calificado** (recibir puntuaciones) y calcular su rendimiento promedio.
- **Métodos:**
  - `agregarEvaluacion(double puntuacion, String comentario)`: Registra una nueva calificación.
  - `obtenerPromedioEvaluacion()`: Calcula y devuelve el promedio de todas las puntuaciones recibidas.
- **Implementada por:**
  - `ConsultorSenior`
  - `ConsultorJunior` (Ambos son sujetos a evaluación de desempeño).

---

## Jerarquía de Clases

```mermaid
graph TD;
    subgraph Jerarquía
        A[<<abstract>> Consultor]
        B(ConsultorSenior)
        C(ConsultorJunior)
        A --> B;
        A --> C;
    end
    
    subgraph Interfaces
        I1(<<interface>> Certificable)
        I2(<<interface>> Evaluable)
    end
    
    B -.-> |implements| I1;
    B -.-> |implements| I2;
    C -.-> |implements| I2;
  ```