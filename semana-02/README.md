# Semana 02 - Fundamentos de Clases, Objetos y Colecciones
## Bootcamp POO Java - Yilmer Hernandez Camargo
## 💼 Dominio
**Dominio Asignado:** Consultoría Empresarial "Soluciones Estratégicas"

**Nombre:** `README.md` (dentro de la carpeta `semana-01/`)

## Descripción
Implementación de la estructura base del sistema de Consultoría Empresarial. Esta semana se enfocó en:
1.  **Crear nuevas clases** (`Cliente` y `Consultor`) para expandir el dominio.
2.  **Implementar relaciones** (Agregación) en `ProyectoConsultoria` y `Facturacion` utilizando referencias a `Cliente` y `Consultor`.
3.  **Utilizar la colección `ArrayList`** dentro de la clase gestora (`GestorProyectos`) para almacenar y manipular colecciones de objetos `ProyectoConsultoria`.

## Objetivos Cumplidos (Basado en la Guía de Ejercicios)

### Ejercicio 1: Crear Nuevas Clases (30 puntos)
- [x] Clase **`Cliente.java`** creada.
- [x] Clase **`Consultor.java`** creada.

### Ejercicio 2: Implementar Relaciones (25 puntos)
- [x] Relación entre **`ProyectoConsultoria`**, **`Cliente`** y **`Consultor`**.
- [x] Relación entre **`Facturacion`** y **`Cliente`**.
- [x] Demostración de comunicación entre objetos (ej., `Facturacion` actualiza el saldo del `Cliente`).

### Ejercicio 3: Usar ArrayList (20 puntos)
- [x] Clase gestora **`GestorProyectos.java`** implementada.
- [x] Uso de `ArrayList<ProyectoConsultoria>` para manejar la lista de proyectos.

### Ejercicio 4: Main Completo (25 puntos)
- [x] El programa `Main.java` demuestra la creación de todos los objetos, las relaciones y el uso del gestor de colecciones.

## Archivos Entregados
- `src/Facturacion.java`
- `src/Cliente.java`
- `src/ProyectoConsultoria.java`
- `src/Consultor.java`
- `src/GestorProyectos.java`
- `src/Main.java`

## Instrucciones de Ejecución

```bash
cd src
javac *.java
java Main