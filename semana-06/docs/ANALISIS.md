# Análisis de Diseño - Semana 06: Agencia de Consultoría de Proyectos

## 1. Identificación de Abstracciones

### Clase(s) Abstracta(s)

**Nombre:** Consultor

**¿Por qué es abstracta?**
- **Clase incompleta:** Elegí hacerla abstracta porque no tiene sentido crear un objeto de tipo "Consultor" sin saber su nivel (Senior o Junior). **La clase abstracta impide** que creemos objetos genéricos.
- **Comportamiento común:** Contiene atributos como `nombreConsultor` e `idConsultor` y el método `mostrarInformacionBasica()`. Estos datos y acciones son **iguales** para todos los consultores.
- **Comportamiento que varía:** Define el método `calcularCostoMensualEstimado()` como **abstracto**. Esto obliga a cada nivel (`Senior`, `Junior`) a implementar su **propia fórmula** de cálculo de costos.

**Jerarquía:**

Consultor
├── ConsultorSenior
└── ConsultorJunior

---

## 2. Interfaces Implementadas

### Interface 1: Certificable

**Capacidad que define:** La capacidad de un objeto para **gestionar títulos o activos formales** (certificaciones). Es el contrato para manejar una lista de certificaciones.

**Clases que la implementan:**
- **ConsultorSenior:** Tiene sentido que implemente esta interfaz porque su alto costo y experiencia deben estar respaldados por la **capacidad** de registrar y listar certificaciones oficiales de la industria.

### Interface 2: Evaluable

**Capacidad que define:** La capacidad de un objeto para **ser calificado** o puntuado por un cliente o gerente, y para calcular su promedio de desempeño.

**Clases que la implementan:**
- **ConsultorSenior:** Todos los consultores deben ser evaluados.
- **ConsultorJunior:** Tiene sentido que implemente esta interfaz porque, al ser nuevos, su desempeño y potencial deben ser **constantemente evaluados** para su desarrollo.

---

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

**Elegí clase abstracta para Consultor porque:**
- **Relación "es-un" clara:** Un Senior **ES UN** Consultor, y un Junior **ES UN** Consultor.
- **Necesitaba compartir estado (atributos):** Los consultores comparten datos protegidos como `tarifaPorHoraBase` y `anosDeServicio` que son vitales para la herencia.
- **Había comportamiento común implementable:** El método `mostrarInformacionBasica()` tiene un código que se puede escribir una sola vez y heredar.

**Elegí interfaces (Certificable, Evaluable) porque:**
- **Define una capacidad independiente de jerarquía:** La capacidad de "ser evaluado" debe ser aplicada a consultores, pero quizá también a un futuro `Proyecto`. Es modular.
- **Necesitaba múltiple implementación:** El `ConsultorSenior` necesita **dos capacidades** al mismo tiempo: ser evaluado y ser certificado. Las interfaces permiten esto, mientras que Java solo permite heredar de una clase (evitando el problema de la herencia múltiple).
- **Solo define contrato, no implementación:** Las interfaces solo establecen la regla (ej: debe haber un método `obtenerPromedioEvaluacion()`); la clase concreta (`Senior` o `Junior`) pone la lógica.

---

## 4. Principios SOLID Aplicados

### Single Responsibility Principle (SRP)
Cada clase/módulo tiene una responsabilidad única:
- `Consultor` solo maneja la información base y el contrato de costos.
- `Certificable` solo maneja la responsabilidad de la **gestión de títulos**.
- `Evaluable` solo maneja la responsabilidad de la **gestión de puntuaciones**.

### Open/Closed Principle (OCP)
El diseño está **abierto a extensión** pero **cerrado a modificación**.
- Si queremos un nuevo `ConsultorPracticante`, simplemente creamos una nueva clase que herede de `Consultor` y le implementamos `Evaluable`. **No necesitamos tocar el código** de `ConsultorSenior` o `ConsultorJunior` que ya funciona.

### Liskov Substitution Principle (LSP)
Se cumple la sustitución:
- La lista `List<Consultor>` puede contener `ConsultorSenior` y `ConsultorJunior`. Al recorrer el bucle, al llamar a `c.calcularCostoMensualEstimado()`, el código funciona correctamente porque cada subclase garantiza la implementación del método del padre.

### Interface Segregation Principle (ISP)
Creamos interfaces específicas y pequeñas:
- Dividimos las capacidades en `Certificable` y `Evaluable`. Esto evita que el `ConsultorJunior` (que no necesita certificaciones) sea **forzado a implementar** los métodos de `Certificable`, manteniendo sus responsabilidades limpias.

### Dependency Inversion Principle (DIP)
El código de alto nivel depende de abstracciones:
- En `Main.java`, el código importante depende de `Consultor` (Clase Abstracta) y de `Evaluable` (Interfaz), no de los detalles internos de las clases concretas (`ConsultorSenior`). Esto hace que el código sea flexible a cambios.

---

## 5. Mejoras Logradas

**Antes (Semana 05):**
- El código permitía crear un `new Consultor()`, lo cual no tenía sentido en el negocio.
- Era difícil aplicar nuevas capacidades (como Evaluación) a múltiples clases sin crear una herencia compleja.

**Después (Semana 06):**
- **Mejoras logradas:** Se garantiza que solo se creen objetos válidos. Se permite la **Múltiple Implementación** de capacidades.
- **Ventajas del nuevo diseño:** El código es más modular y fácil de mantener. La lógica de evaluación puede ser aplicada a otros objetos fuera de la jerarquía (ej: un `Proyecto`) sin cambiar nada.

---

## 6. Diagrama de Clases

*(Este diagrama visualiza la estructura que permite el diseño de tu sistema)*

```mermaid
graph TD;
    A[<<abstract>> Consultor]
    B(ConsultorSenior)
    C(ConsultorJunior)
    I1(<<interface>> Certificable)
    I2(<<interface>> Evaluable)
    
    A --> B;
    A --> C;
    
    B -.-> |implementa| I1;
    B -.-> |implementa| I2;
    C -.-> |implementa| I2;