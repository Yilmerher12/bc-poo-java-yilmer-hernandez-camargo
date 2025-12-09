# Bootcamp POO Java - Yilmer Hernandez Camargo

## Dominio del Proyecto

**Dominio Asignado:** Consultoría Empresarial "Soluciones Estratégicas"

---

## Semana 05: Polimorfismo (Sobrecarga y Sobrescritura)

### Descripción

Esta semana se profundizó en la aplicación del **Polimorfismo** en la jerarquía de consultores. Se utilizó la **sobrecarga** (`Overloading`) para ofrecer múltiples opciones de búsqueda en la clase gestora y la **sobrescritura** (`Overriding`) para modificar las reglas de negocio (`calcularCostoMensualEstimado` y `obtenerDescripcion`) según el nivel del consultor.

### Objetivos Cumplidos

* [x] Implementación de **Sobrecarga de Métodos** (`Overloading`) en la clase `GestorProyectos` para búsquedas flexibles.
* [x] Aplicación de **Sobrescritura de Métodos** (`Overriding`) con `@Override` en `ConsultorSenior` y `ConsultorJunior`.
* [x] Creación de **métodos polimórficos** en `GestorProyectos` (`procesarFacturacion`, `generarReporte`).
* [x] Demostración de **Polimorfismo Dinámico** (Dynamic Binding) mediante un `ArrayList<Consultor>` en `Main.java`.
* [x] Documentación detallada en el archivo `POLIMORFISMO.md`.

### Archivos Entregados

| Carpeta/Archivo | Contenido | Hitos de POO |
| :--- | :--- | :--- |
| `src/Consultor.java` | Clase Padre. Mejorada con sobrecarga de constructores. | Herencia |
| `src/ConsultorSenior.java` | Subclase con lógica de Bono por Antigüedad. | **Sobrescritura** (`@Override`) |
| `src/ConsultorJunior.java` | Subclase con lógica de Tarifa Fija Reducida. | **Sobrescritura** (`@Override`) |
| `src/GestorProyectos.java` | Maneja la colección de consultores. | **Sobrecarga** (Búsqueda) y **Polimorfismo Dinámico** |
| `src/ProyectoConsultoria.java` | Clase de negocio para gestión de proyectos. | Sobrecarga de Constructores |
| `src/Main.java` | Demostración de las 3 formas de polimorfismo (Sobrecarga, Sobrescritura y Array Polimórfico). | Array Polimórfico |
| `docs/POLIMORFISMO.md` | Análisis teórico y justificación de la implementación. | Documentación |

### Detalles de la Implementación Polimórfica

#### 1. Sobrecarga (`Overloading`)
Se implementó en `GestorProyectos.java` con el método `buscarConsultor`:

* `buscarConsultor(String id)`
* `buscarConsultor(int anosMinimos, int anosMaximos)`

#### 2. Sobrescritura (`Overriding`)
Se modificó el comportamiento de los siguientes métodos según el nivel del consultor:

| Método | `ConsultorSenior` | `ConsultorJunior` |
| :--- | :--- | :--- |
| `calcularCostoMensualEstimado()` | Aplica **Bono por Antigüedad** sobre el costo base. | Aplica una **Tarifa Fija Reducida**, ignorando la tarifa base. |
| `obtenerDescripcion()` | Muestra nivel y porcentaje de bono. | Muestra nivel y la tarifa reducida fija. |

### Instrucciones de Ejecución

Para compilar y ejecutar el código que demuestra la sobrecarga y el polimorfismo, sigue estos comandos:

```bash
# Navega a la carpeta que contiene los archivos .java
cd src

# Compila todos los archivos .java
javac *.java

# Ejecuta la clase principal
java Main