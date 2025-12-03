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

```mermaid
graph TD
    classDef parent fill:#4CAF50,stroke:#388E3C,color:#ffffff;
    classDef child fill:#81C784,stroke:#4CAF50,color:#000000;
    classDef method fill:#E0F7FA,stroke:#00BCD4;
    
    subgraph Pilar de Herencia
        Consultor(fa:fa-user-tie Consultor)
        ConsultorSenior(fa:fa-star ConsultorSenior)
        ConsultorJunior(fa:fa-child ConsultorJunior)
    end
    
    %% Relaciones de Herencia
    Consultor --|> ConsultorSenior
    Consultor --|> ConsultorJunior

    %% Atributos Protegidos
    ConsultorSenior --> A[+ idConsultor: protected String]
    ConsultorSenior --> B[+ tarifaPorHora: protected double]
    ConsultorJunior --> C[+ idConsultor: protected String]
    ConsultorJunior --> D[+ anosDeServicio: protected int]

    %% Metodo Sobrescrito
    Consultor --- M1(calcularCostoMensualEstimado(horas): double)
    ConsultorSenior --- M2(Sobrescribe: Costo con Bono)
    ConsultorJunior --- M3(Sobrescribe: Costo con Descuento)
    
    class Consultor parent;
    class ConsultorSenior,ConsultorJunior child;
    class M1, M2, M3 method;
```


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