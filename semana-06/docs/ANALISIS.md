# Documento de Análisis de Diseño: Semana 06

## 1. Abstracción y Clase Base (`Consultor.java`)

### Decisión de Diseño
Se refactorizó la clase `Consultor` para convertirla en una **Clase Abstracta**.

### Justificación
* **Impedir Instanciación:** Se evita crear objetos de tipo `Consultor` genérico, ya que no tiene sentido en el dominio. Todo consultor debe ser clasificado (Senior, Junior, etc.) para poder trabajar.
* **Contrato de Comportamiento:** Se definieron métodos **abstractos** (`calcularCostoMensualEstimado`, `obtenerDescripcion`). Esto obliga a todas las clases hijas (las implementaciones concretas) a sobrescribir e implementar su propia lógica específica para el cálculo de costos y la generación de reportes.
* **Encapsulamiento para Herencia:** Los atributos comunes (`idConsultor`, `anosDeServicio`) se definieron como `protected` para facilitar el acceso directo de las clases hijas al estado del consultor.

## 2. Implementación de Interfaces (Contratos de Capacidad)

Se crearon dos interfaces para modelar **capacidades** que son transversales y están desacopladas de la jerarquía de herencia.

### A. Interfaz `Certificable`
Esta interfaz encapsula la **capacidad de gestionar títulos formales y activos vendibles** (certificaciones).

* **Aplicación:** Implementada solo por `ConsultorSenior`.
* **Justificación:** En este diseño, se decidió que únicamente el consultor de nivel Senior debe tener la funcionalidad (los métodos) para registrar y listar certificaciones, ya que estas validan su tarifa y experiencia ante el cliente. Esto aísla la funcionalidad solo donde se necesita.

### B. Interfaz `Evaluable`
Esta interfaz modela la **capacidad universal de ser calificado o puntuado**.

* **Aplicación:** Implementada por `ConsultorSenior` y `ConsultorJunior`.
* **Justificación:** La acción de "ser evaluado" es un requisito transversal que aplica a todos los niveles de consultor. El uso de esta interfaz permite que el código de evaluación sea genérico (Polimorfismo de Interfaces), ya que el sistema solo necesita verificar que un objeto cumpla con el contrato `Evaluable`, sin importar si es Senior o Junior.

## 3. Demostración de Principios de POO

El `Main.java` demuestra la efectividad del diseño:

* **Polimorfismo por Herencia (Abstracta):** Al recorrer la lista de tipo `List<Consultor>`, se comprueba que el motor de Java selecciona la implementación correcta de `calcularCostoMensualEstimado` para cada objeto hijo (`Senior` usa su fórmula, `Junior` usa la suya) utilizando una única línea de código.
* **Polimorfismo por Interfaces:** Al usar variables de tipo `Certificable` o `Evaluable`, se demuestra que los objetos pueden ser referenciados por sus capacidades específicas. Esto permite utilizar las funciones de la interfaz de forma segura, incluso si el objeto real es de una clase compleja.