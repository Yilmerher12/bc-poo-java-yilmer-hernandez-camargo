# Mejoras - Semana 03
## Bootcamp POO Java - **Yilmer Hernandez Camargo**

## Encapsulación Aplicada

Mi principal objetivo esta semana fue asegurar que **todos los datos importantes** de mis clases estuvieran protegidos. Puse todos los atributos como `private` y ahora solo se pueden modificar a través de *setters*. 

### Clase: Cliente
- **Atributos encapsulados:** Protegí datos como el **NIT**, el **nombre de la empresa** y el **estado de cuenta**.
- **Validaciones agregadas:** Me aseguro de que el **NIT** tenga un mínimo de 6 caracteres y que el **nombre de la empresa** no se quede vacío.

### Clase: Consultor
- **Atributos encapsulados:** Encapsulé la **tarifa por hora**, los **años de servicio** y el **ID del consultor**.
- **Validaciones agregadas:** Puse reglas para que el **ID** empiece con 'C', la **tarifa** sea positiva y los **años de servicio** no sean negativos.

### Clase: Facturacion
- **Atributos encapsulados:** Protegí el **número de factura** y el **monto total**.
- **Validaciones agregadas:** Verifico que el **número de factura** tenga el largo exacto (7 caracteres) y que el **monto total** sea mayor que cero.

### Clase: ProyectoConsultoria
- **Atributos encapsulados:** Protegí el **código del proyecto**, el **área** y el **presupuesto**.
- **Validaciones agregadas:** Me aseguro de que el **código** esté entre 5 y 10 caracteres, que el **área** no esté vacía y que el **presupuesto** sea positivo.

---

## Constructores Sobrecargados

Implementé la **sobrecarga de constructores** en mis clases principales. Esto significa que puedo crear un objeto de diferentes maneras, dándole solo la información esencial y dejando que el sistema asigne valores por defecto al resto de los campos.

### Clase: Cliente
- **Constructor 1:** Uso este cuando tengo **todos los datos** del cliente (el constructor más completo).
- **Constructor 2:** Uso este cuando sé que el cliente **no tiene un saldo inicial**, asignando **0.0** por defecto.
- **Constructor 3:** Lo uso cuando solo sé el **NIT** y el **nombre de la empresa**, y el sistema asigna valores "N/A" para el contacto.

### Clase: Consultor
- **Constructor 1:** Uso el constructor **completo** (con 5 parámetros).
- **Constructor 2:** Lo uso cuando **no sé los años de servicio** del consultor (los dejo en **0** por defecto).
- **Constructor 3:** Lo uso cuando solo sé el **ID** y el **nombre**, y asigno una tarifa base de **30.0** y especialidad "General".

### Clase: Facturacion
- **Constructor 1:** Uso el constructor **completo** (con 5 parámetros).
- **Constructor 2:** Lo uso cuando solo tengo el **número de factura**, el **cliente** y el **proyecto relacionado**, dejando el monto en **0.0**.

---

## Beneficios Logrados

1.  **Datos Seguros y de Calidad:** Lo más importante es que las validaciones hacen que mis objetos sean **confiables**. Evito errores como presupuestos negativos o datos nulos que podrían dañar el sistema.
2.  **Facilidad para Crear Objetos:** La sobrecarga me permite crear objetos de forma **rápida y flexible** en el programa `Main`, sin tener que proporcionar siempre todos los datos.
3.  **Código Limpio y Ordenado:** Al usar los constructores sencillos para llamar al constructor completo (`this(...)`), evito repetir código y mantengo la lógica de inicialización en un solo lugar.

---
