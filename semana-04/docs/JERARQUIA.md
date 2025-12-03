# Jerarquía de Clases - Semana 04

## Objetivo

Demostrar la implementación de los pilares de **Herencia** y **Polimorfismo** en la jerarquía de la clase `Consultor`.

## Diagrama (ASCII Universal)

Para garantizar la visualización en cualquier entorno, se presenta el diagrama en formato ASCII:

        Consultor (Clase Padre)
               |
      +--------+---------+
      |                  |
ConsultorSenior      ConsultorJunior 

## Código del Diagrama (Mermaid)

Este es el código **seguro y corregido** para renderizar el diagrama estético. Debe funcionar si tu editor soporta Mermaid:

## Justificación

Elegimos la jerarquía basada en la clase **Consultor** porque representa un concepto que requiere **especialización de la lógica de negocio** (Polimorfismo) dependiendo del nivel del recurso.

La herencia permite que **ConsultorSenior** y **ConsultorJunior** reutilicen atributos básicos (nombre, ID, tarifa) y la funcionalidad de la clase base (`Consultor`), pero modifiquen la regla más importante: el cálculo del costo mensual. Esto garantiza que cualquier objeto (Base, Senior o Junior) pueda ser tratado como un tipo genérico `Consultor`, cumpliendo con el Polimorfismo.

## Atributos Heredados

Los siguientes atributos fueron declarados como **protected** en la clase `Consultor` para que las subclases pudieran acceder a ellos directamente en sus cálculos:

- `idConsultor` (String)
- `nombreConsultor` (String)
- `tarifaPorHora` (double)
- `anosDeServicio` (int)

## Métodos Sobrescritos

- **`calcularCostoMensualEstimado(int horasMensuales)`:**
    - **Consultor (Base):** Tarifa normal * Horas.
    - **ConsultorSenior:** Tarifa normal + **Bono por Antigüedad** (1% del costo base por cada año de servicio).
    - **ConsultorJunior:** Tarifa normal - **Descuento Fijo** (descuento predefinido debido a la curva de aprendizaje).