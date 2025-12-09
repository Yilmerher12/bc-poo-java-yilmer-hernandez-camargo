# 🏛️ Arquitectura y Relaciones del Sistema de Consultores

Este documento detalla la estructura principal de las clases y sus relaciones, fundamentada en los principios de la Programación Orientada a Objetos (POO).

## 1. Jerarquía de Herencia y Abstracción

El sistema se basa en la clase abstracta `Consultor`, que define el contrato básico para todas las entidades de consultoría.

| Relación | Clase Padre | Clases Hijas | Justificación |
|---|---|---|---|
| **Herencia** | `Consultor` (Abstracta) | `ConsultorSenior`, `ConsultorJunior` | Reutiliza atributos comunes (`id`, `nombre`, `tarifa`, `años`) y obliga a la implementación del cálculo de costos (`calcularCostoMensualEstimado`). |

## 2. Implementación de Interfaces

Las interfaces definen capacidades específicas que las entidades deben cumplir.

| Interfaz | Clase Implementadora | Métodos Clave |
|---|---|---|
| **`Certificable`** | `ConsultorSenior` | `registrarCertificacion()`, `listarCertificaciones()` |
| **`Evaluable`** | `ConsultorSenior`, `ConsultorJunior` | `obtenerPromedioEvaluacion()`, `agregarEvaluacion()` |

## 3. Relaciones de Composición/Agregación

La clase de servicio (`GestorConsultores`) mantiene y opera sobre las colecciones de entidades.

| Objeto Cliente | Objeto Proveedor | Tipo de Relación | Propósito |
|---|---|---|---|
| `GestorConsultores` | `Consultor` (en List y Map) | **Agregación** | Gestiona el CRUD y las métricas sobre el conjunto de consultores. |
| `Main` | `GestorConsultores` | **Uso** | Proporciona el punto de entrada y el menú al usuario final. |

## 4. Persistencia y Excepciones

El sistema interactúa con el archivo de datos y maneja errores de manera controlada.

| Componente | Interacción | Tipo de Componente |
|---|---|---|
| `GestorConsultores` | `datos_consultores.csv` | Archivo CSV | Guarda y carga el estado de los consultores. |
| `GestorConsultores` | `ContratoInvalidoException` | Excepción Personalizada | Se lanza si el ID es incorrecto o duplicado. |
| `GestorConsultores` | `CapacidadAgotadaException` | Excepción Personalizada | Se lanza si se excede la capacidad máxima de la plantilla. |