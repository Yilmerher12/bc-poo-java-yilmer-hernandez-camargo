# Proyecto Final: Sistema de Gestión de Consultores

## Información del Estudiante
| Campo | Valor |
|-------|-------|
| **Nombre** | Yilmer Hernandez Camargo |
| **Ficha** | 3228970A |
| **Dominio** | **Gestión de Consultores (Junior y Senior)** |
| **Fecha** | [02/12/2005] |

---

## Descripción del Sistema
Este sistema está diseñado para gestionar el ciclo de vida y la información de una plantilla de consultores, diferenciándolos por su nivel de experiencia (**Junior** y **Senior**). Su propósito principal es permitir a la gerencia realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de manera eficiente, así como generar métricas clave sobre costos y especialidades.

El sistema resuelve el problema de la dispersión de datos y facilita la toma de decisiones al calcular costos estimados mensuales (aplicando diferentes tarifas según el nivel) y filtrar la plantilla según antigüedad. La información de la plantilla es persistente, asegurando que los datos se conserven entre ejecuciones del programa mediante el uso de archivos CSV.

---

## Arquitectura del Proyecto

### Diagrama de Clases
![Diagrama de Clases UML para el Sistema de Gestión de Consultores](docs/diagrama-clases.png)

### Estructura de Paquetes
| Paquete | Contenido | Clases |
|---------|-----------|--------|
| `com.consultoria.modelo` | Entidades, Abstracción e Interfaces | `Consultor`, `ConsultorSenior`, `ConsultorJunior`, `Certificable`, `Evaluable` |
| `com.consultoria.servicio` | Lógica de negocio y persistencia | `GestorConsultores` |
| `com.consultoria.excepciones` | Excepciones personalizadas | `ContratoInvalidoException`, `CapacidadAgotadaException` |
| `com.consultoria` | Punto de entrada del sistema | `Main` |

---

## Aplicación de Conceptos POO

### Encapsulación
- Los atributos de las entidades (`idConsultor`, `tarifaPorHoraBase`, `anosDeServicio`, etc.) son **`protected`** en la clase padre (`Consultor`) para permitir el acceso directo en las clases hijas por herencia, y son accesibles al exterior solo a través de métodos `public` **getters**.
- Validaciones implementadas:
  1. **Validación de ID:** El ID del consultor debe ser único y tener exactamente 5 caracteres.
  2. **Validación de Capacidad:** El sistema lanza una excepción si se intenta agregar más consultores de la capacidad máxima definida (`MAX_CONSULTORES = 100`).

### Herencia
| Clase Padre | Clases Hijas | Atributos Heredados |
|-------------|--------------|---------------------|
| `Consultor` (Abstracta) | `ConsultorSenior`, `ConsultorJunior` | `idConsultor`, `nombreConsultor`, `tarifaPorHoraBase`, `anosDeServicio` |

### Polimorfismo
**Sobrescritura (@Override):**
- `calcularCostoMensualEstimado(int horas)` en `ConsultorSenior` y `ConsultorJunior` (Cada uno aplica diferente bono/descuento).
- `obtenerDescripcion()` en `ConsultorSenior` y `ConsultorJunior`.

**Sobrecarga (Overload):**
- *El proyecto no implementa sobrecarga directamente en los métodos de gestión.*

**Colecciones polimórficas:**
- `List<Consultor>` (`historialConsultores`) conteniendo objetos de tipo `ConsultorSenior` y `ConsultorJunior`.

### Abstracción
| Tipo | Nombre | Implementaciones |
|------|--------|------------------|
| Clase abstracta | `Consultor` | `ConsultorSenior`, `ConsultorJunior` |
| Interface | `Certificable` | `ConsultorSenior` |
| Interface | `Evaluable` | `ConsultorSenior`, `ConsultorJunior` |

### Excepciones Personalizadas
| Excepción | Tipo | Cuándo se lanza |
|-----------|------|-----------------|
| `ContratoInvalidoException` | Checked | Cuando el ID es nulo, tiene longitud incorrecta, o ya existe en el sistema. |
| `CapacidadAgotadaException` | Checked | Cuando se intenta agregar un consultor y la plantilla máxima (100) ya fue alcanzada. |

### Colecciones
| Colección | Tipo | Propósito |
|-----------|------|-----------|
| `consultoresPorId` | `Map<String, Consultor>` | Búsqueda **O(1)** por ID del consultor. |
| `historialConsultores` | `List<Consultor>` | Mantener un registro ordenado y facilitar la iteración para filtrados y reportes. |
| `conteoEspecialidades` | `Map<String, Integer>` | Almacenar y contar las ocurrencias de cada especialidad para estadísticas. |

---

## Funcionalidades del Sistema

### Menú Principal
- Agregar nuevo consultor
- Buscar consultor por ID
- Eliminar consultor por ID
- Listar todos los consultores 
- Filtrar Senior por Años de Servicio
- Mostrar Estadísticas y Conteo
- Salir (Guarda los datos)

### Operaciones Implementadas

| Operación | Descripción | Estado |
|-----------|-------------|--------|
| Agregar consultor | Crea y registra una nueva instancia (Junior/Senior), validando ID y capacidad. | ✅ |
| Buscar por ID | Búsqueda rápida del consultor usando la estructura `Map`. | ✅ |
| Listar todos | Recorre la lista de consultores e imprime la descripción. | ✅ |
| Eliminar | Remueve un consultor por su ID de ambas colecciones (`Map` y `List`). | ✅ |
| **Filtrar por Años** | Filtra y muestra solo los `ConsultorSenior` cuya antigüedad supera un límite dado. | ✅ |
| **Estadísticas** | Calcula el costo total mensual estimado y cuenta consultores por especialidad. | ✅ |
| **Persistencia** | Carga datos al inicio y guarda automáticamente al salir (`datos_consultores.csv`). | ✅ |


### Compilación y Ejecución (Terminal)

```bash
# 1. Navegar a la carpeta contenedora del src
cd proyecto-final

# 2. Compilar todos los archivos Java del proyecto
# Se usa '-d out' para colocar los archivos compilados en una carpeta de salida 'out'
javac -d out src/com/consultoria/*.java src/com/consultoria/modelo/*.java src/com/consultoria/servicio/*.java src/com/consultoria/excepciones/*.java

# 3. Ejecutar la clase principal
java -cp out com.consultoria.Main