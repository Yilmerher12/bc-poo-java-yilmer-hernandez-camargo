# Semana 07: Paquetes y Excepciones - Agencia de Consultoría de Proyectos

## Información del Estudiante
- **Nombre**: Yilmer Hernandez Camargo
- **Ficha**: 3228970A
- **Dominio**: Consultoría Empresarial "Soluciones Estratégicas"
- **Fecha**: 31/12/2025

## Descripción del Proyecto
Sistema de gestión para una agencia de consultoría que organiza y valida la contratación de consultores Senior y Junior. Esta semana se implementó una arquitectura profesional basada en paquetes y se añadieron validaciones robustas para manejar errores de negocio de forma controlada.

## Estructura de Paquetes
El proyecto sigue la convención estándar `com.dominio.modulo`:

| Paquete | Descripción |
| :--- | :--- |
| `com.consultoria/` | Raíz del proyecto. Contiene la clase `Main.java`. |
| `com.consultoria.modelo/` | Contiene las clases de entidad (`ConsultorSenior`, `Certificable`, etc.) que definen la estructura de datos. |
| `com.consultoria.servicio/` | Contiene la lógica de negocio (`GestorConsultores.java`), validaciones, y gestión de colecciones. |
| `com.consultoria.excepciones/` | Contiene las clases de error personalizadas del dominio. |

## Excepciones Personalizadas

### 1. ContratoInvalidoException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Se lanza cuando un dato esencial para la contratación es incorrecto (ej: El ID del contrato no tiene el formato requerido o un objeto es nulo).
- **Ejemplo**: Intentar agregar un consultor con un ID de contrato de 3 caracteres cuando se esperan 5.

### 2. CapacidadAgotadaException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Se lanza cuando el sistema intenta realizar una operación que excede un límite físico o de recursos (ej: Se intenta contratar un consultor adicional cuando el equipo ya está completo).
- **Ejemplo**: Intentar agregar el 11º consultor cuando el límite del equipo es 10.

## Cómo Ejecutar

### Desde terminal:
```bash
cd semana-07
# Compilación (ajustar según el compilador)
javac -d bin src/com/consultoria/*/*.java src/com/consultoria/*.java
# Ejecución
java -cp bin com.consultoria.Main