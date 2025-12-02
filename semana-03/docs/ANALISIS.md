# Mejoras - Ejercicios Semanales | Semana 03

## 1. Encapsulación Completa y Validaciones (Ejercicios 1 y 3)

Se han aplicado los tres niveles de encapsulación (atributos `private`, *Getters* y *Setters*) a las **5 clases**. La **Encapsulación Completa** se logró al añadir validaciones rigurosas en los *Setters* para proteger la integridad de los datos.

### 1.1 Clase: Cliente
- **Atributos encapsulados:** `nit`, `companyName`, `accountStatus`.
- **Validaciones agregadas:** Se verifica que el `companyName` no sea nulo ni vacío. Se utiliza un método `private` (`isNitValid`) para asegurar que el `nit` cumpla con la longitud mínima requerida.

### 1.2 Clase: Consultor
- **Atributos encapsulados:** `hourlyFee`, `yearsOfService`.
- **Validaciones agregadas:** Se exige que la **Tarifa por Hora** (`hourlyFee`) sea **mayor que cero**. Se impide que los `yearsOfService` sean valores negativos.

### 1.3 Clase: ConsultingProject
- **Atributos encapsulados:** `projectBudget`, `projectCode`.
- **Validaciones agregadas:** Se exige que el **Presupuesto** (`projectBudget`) sea **positivo**. El `projectCode` debe cumplir un rango de longitud definido.

### 1.4 Clase: Billing
- **Atributos encapsulados:** `totalAmount`, `invoiceNumber`.
- **Validaciones agregadas:** Se exige que el **Monto Total** (`totalAmount`) sea **positivo**. Se verifica que el `invoiceNumber` cumpla con el formato de longitud requerido.

### 1.5 Clase: ProjectManager
- **Atributos encapsulados:** `consultancyName`, `projectsList`.
- **Validaciones agregadas:** Se exige que el `consultancyName` no sea nulo ni vacío en el constructor, asegurando que el gestor tenga siempre una identidad.

---

## 2. Constructores Sobrecargados (Ejercicio 2)

Se implementó la **Sobrecarga de Constructores** en todas las clases principales, creando opciones flexibles (Básico y Mínimo) que llaman al constructor principal usando **`this(...)`**.

### 2.1 Clase: Cliente (3 Constructores)
- **Constructor Básico:** Permite crear el objeto solo con 4 datos clave, asignando el `accountStatus` a **0.0** por defecto.
- **Constructor Mínimo:** Asigna **valores genéricos** ("N/A") a los atributos de contacto y sector.

### 2.2 Clase: Consultor (3 Constructores)
- **Constructor Básico:** Asume **0 años de servicio** por defecto.
- **Constructor Mínimo:** Asigna una tarifa base (`30.0`) y especialidad genérica ("General").

### 2.3 Clase: ConsultingProject (3 Constructores)
- **Constructor Borrador:** Permite crear el proyecto como `isActive = false` para la etapa de planificación inicial.
- **Constructor Mínimo Activo:** Permite asociar el proyecto a un `Cliente`, asumiendo que el `Consultor` será asignado más tarde (`Consultor = null`).

### 2.4 Clase: ProjectManager (2 Constructores)
- **Constructor Principal:** Recibe el nombre de la consultoría.
- **Constructor Por Defecto:** Permite inicializar el gestor sin argumentos, asignando un nombre genérico ("Consultoría Global") y una lista de proyectos vacía.

---

## 3. Beneficios Logrados

1.  **Integridad de Datos Garantizada:** Al forzar la ejecución de las validaciones en los Constructores (mediante **`this(...)`**), se asegura que **ningún objeto** en el sistema pueda ser creado con datos inconsistentes.
2.  **Facilidad de Uso (Flexibilidad):** La Sobrecarga de Constructores permite al programador crear objetos con la mínima cantidad de datos necesarios, sin tener que inventar valores para los campos opcionales.
3.  **Mantenibilidad del Código:** La lógica de validación reside en un único lugar (*Setter*), facilitando la actualización de las reglas de negocio.
