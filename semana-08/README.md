# README.md - Semana 08: Colecciones y Generics

## Semana 08: Colecciones y Generics - Gestión de Consultores

---

## Información del Estudiante

* **Nombre**: Yilmer Hernandez Camargo
* **Ficha**: 3228970A
* **Dominio**: Gestión de Consultores de Proyectos
* **Fecha**: [01/12/2025]

---

## Descripción del Proyecto

El sistema de gestión de consultores ha sido refactorizado para la Semana 08, reemplazando los arrays estáticos por **Colecciones Dinámicas** de Java. Esto mejora la **eficiencia** en las operaciones de búsqueda (**O(1)**), la **flexibilidad** en el almacenamiento y permite la implementación de lógica de negocio compleja (filtrado y estadísticas).

### Cambios Clave:
* **Eficiencia:** Implementación de `HashMap` para búsquedas instantáneas por ID.
* **Escalabilidad:** Migración a `ArrayList` para manejar cualquier cantidad de consultores.
* **Funcionalidad:** Nuevos métodos de filtrado (`instanceof`) y cálculos de estadísticas (`getOrDefault`).

---

## Colecciones Utilizadas

| Estructura | Nombre en Código | Propósito | Eficiencia de Búsqueda |
| :--- | :--- | :--- | :--- |
| **`HashMap<String, Consultor>`** | `consultoresPorId` | Almacenamiento por **Clave-Valor**. Se usa para **Validación de Duplicados** y **Búsqueda por ID** (O(1)). | **Instantánea (O(1))** |
| **`ArrayList<Consultor>`** | `historialConsultores` | Lista dinámica. Se usa para **Listar todos**, mantener el **Historial ordenado** y realizar operaciones de **Filtrado y Estadísticas**. | Lineal (O(n)) |
| **`HashMap<String, Integer>`** | `conteoEspecialidades` | **(Auxiliar)** Usado en el Ejercicio 3 para contar cuántos consultores hay por cada especialidad. | **Instantánea (O(1))** |

---

## Operaciones Implementadas

### CRUD con Colecciones

* **Agregar (Create):** Incluye validación de duplicados usando `HashMap.containsKey()`.
*  **Buscar (Read):** Búsqueda por ID con `HashMap.get()` (**O(1) demostrado**).
* **Eliminar (Delete):** Remoción sincronizada en `HashMap.remove()` y `ArrayList.remove()`.

### Filtrado y Conteo (Ejercicio 3)

* **Filtrado por tipo:** Se implementa `filtrarSeniorPorAnos()` usando el operador `instanceof`.
* **Conteo por Categoría:** Se implementa `contarPorEspecialidad()` usando `HashMap.getOrDefault()` para agrupación.

### Estadísticas

* **Total y Promedio:** Cálculo de `calcularCostoTotalMensual()` iterando sobre el `ArrayList`.

---

## Cómo Ejecutar

El proyecto se compila y ejecuta desde la raíz de la carpeta `semana-08/`.

### Desde terminal:
```bash
# Compilar todos los archivos .java
javac -d bin src/com/consultoria/*/*.java src/com/consultoria/*.java

# Ejecutar el programa Main
java -cp bin com.consultoria.Main