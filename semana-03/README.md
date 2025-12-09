# Semana 03 - Encapsulación y Constructores
## Bootcamp POO Java - Yilmer Hernandez Camargo
## Dominio
**Dominio Asignado:** Consultoría Empresarial "Soluciones Estratégicas"

**Nombre:** `README.md` (dentro de la carpeta `semana-03/`)


## 🎯 Objetivos Cumplidos de la Semana

Esta semana nos enfocamos en **proteger la integridad de los datos** y hacer que la creación de objetos fuera más flexible, cumpliendo con los siguientes requisitos:

- [x] **Encapsulación Completa:** Todos los atributos de todas las clases (`Cliente`, `Consultor`, `Facturacion`, `ProyectoConsultoria`, `GestorProyectos`) son `private`.
- [x] **Getters y Setters:** Implementamos los métodos de acceso necesarios.
- [x] **Validaciones:** Agregamos reglas de negocio y validaciones en los *setters* y constructores (ej., asegurando que el presupuesto sea positivo y que el NIT sea válido).
- [x] **Sobrecarga de Constructores:** Cada clase principal tiene mínimo **tres constructores** para permitir la creación de objetos con diferentes niveles de información inicial.
- [x] **Documento MEJORAS.md:** Documentamos todas las mejoras realizadas en ese archivo.

---

## Archivos Entregados

El proyecto de la Semana 03 incluye los archivos principales del modelo de negocio, todos refactorizados con las mejoras de encapsulación:

### Clases en JAVA (`src/`)
- `Cliente.java`
- `Consultor.java`
- `Facturacion.java`
- `GestorProyectos.java`
- `ProyectoConsultoria.java`
- `Main.java` Contiene la demostración de la sobrecarga y las validaciones

### Documentación
- `MEJORAS.md` Contiene la explicación detallada de las validaciones y constructores aplicados.

---

## Instrucciones de Ejecución

Para ejecutar la demostración que hicimos con los constructores y la lógica de facturación:

```bash
cd src
javac *.java
java Main
