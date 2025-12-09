# Bootcamp POO Java - Yilmer Hernandez Camargo

## 📌 Dominio del Proyecto

**Dominio Asignado:** Consultoría Empresarial "Soluciones Estratégicas"

---

## Semana 04: Implementación de Herencia y Polimorfismo

### Descripción

En esta actividad se implementó la **jerarquía de clases** para el dominio de Consultoría Empresarial, demostrando los pilares de la Programación Orientada a Objetos: **Herencia** y **Polimorfismo**. Se definieron diferentes tipos de consultores (`ConsultorSenior`, `ConsultorJunior`) que heredan de una clase base (`Consultor`).

### Objetivos Cumplidos

* [x] Diseño de una jerarquía de clases con una **Clase Padre** (`Consultor`).
* [x] Creación de **subclases** (`ConsultorSenior`, `ConsultorJunior`) usando la palabra clave `extends`.
* [x] Uso de atributos `protected` para facilitar el acceso a las subclases.
* [x] Implementación de constructores con la llamada `super()` a la clase padre.
* [x] Sobreescritura de métodos (`calcularCostoMensualEstimado`) usando la anotación `@Override`.
* [x] Demostración de **Polimorfismo** mediante un *array* de tipo `Consultor` en el archivo `Main.java`.

### Archivos Entregados

| Carpeta/Archivo | Descripción |
| :--- | :--- |
| `src/Consultor.java` | **Clase Padre** del sistema, define los atributos y métodos base. |
| `src/ConsultorSenior.java` | **Subclase** que hereda de `Consultor` y especializa el cálculo del costo. |
| `src/ConsultorJunior.java` | **Subclase** que hereda de `Consultor` y especializa el cálculo del costo. |
| `src/Main.java` | Contiene el método `main` para la instanciación de objetos y la demostración de polimorfismo. |
| `docs/JERARQUIA.md` | Documento que explica la jerarquía de clases, la justificación y los métodos sobrescritos. |

### Jerarquía Implementada

La clase base (`Consultor`) define la estructura general, mientras que las subclases (`ConsultorSenior`, `ConsultorJunior`) sobrescriben el método clave `calcularCostoMensualEstimado` para aplicar reglas de negocio específicas (bonos por antigüedad, descuentos fijos, etc.).


### Instrucciones de Ejecución

Para compilar y ejecutar el código de la demostración de polimorfismo, sigue estos pasos:

```bash
# Navega a la carpeta que contiene los archivos .java
cd src

# Compila todos los archivos .java
javac *.java

# Ejecuta la clase principal
java Main