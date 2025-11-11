# Semana 1 Consultoría Empresarial "Soluciones Estratégicas"

Esta es la Actividad 1 de la Semana 1. Yo heS identificado los objetos clave de la Consultoría Empresarial "Soluciones Estratégicas". Cada objeto se presenta con su definición, sus características (atributos) y sus comportamientos (métodos).

---

## Actividad 1: Identificación de Objetos

### Objeto 1: Consultor

**¿Qué es?**
Una persona especializada contratada para ejecutar y asesorar proyectos con los clientes de la firma "Soluciones Estratégicas".

**Características (Atributos):**
* nombre
* especialidad
* idConsultor
* antigüedad
* tarifaPorHora

**Comportamientos (Métodos):**
* asignarProyecto()
* registrarHorasTrabajadas()
* enviarInformes()

---

### Objeto 2: Cliente (Empresa)

**¿Qué es?**
La empresa que contrata los servicios de la consultoría Empresarial "Soluciones Estratégicas".

**Características (Atributos):**
* nit
* nombreEmpresa
* contacto
* sector
* ubicación
* estadoCuenta

**Comportamientos (Métodos):**
* solicitarServicio()
* realizarPago()
* darRecomendaciones()

---

### Objeto 3: Proyecto de Consultoría

**¿Qué es?**
El servicio o tipo de trabajo que "Soluciones Estratégicas" ofrece al cliente.

**Características (Atributos):**
* código
* área
* presupuesto
* fechaInicio
* estado

**Comportamientos (Métodos):**
* crearProyecto()
* asignarConsultor()
* finalizarProyecto()
* facturar()

---

### Objeto 4: Área de Especialidad

**¿Qué es?**
El tipo de área de especialización que ofrece "Soluciones Estratégicas" o que la empresa cliente requiere para el proyecto de consultoría.

**Características (Atributos):**
* nombreArea
* descripción
* costoBase
* consultoresLíderes

**Comportamientos (Métodos):**
* definirEstrategia()
* promocionarÁrea()
* capacitarPersonal()

---

### Objeto 5: Facturación

**¿Qué es?**
Documento legal y financiero que genera la empresa por la transacción de dinero de cada proyecto de consultoría. Es una parte primordial de la contabilidad y finanzas.

**Características (Atributos):**
* numeroFactura
* fechaEmisión
* montoTotal
* proyectoAsociado
* estadoDePago

**Comportamientos (Métodos):**
* calcularImpuestos()
* registrarPago()
* consultarEstadoPago()
* envíoEmail()