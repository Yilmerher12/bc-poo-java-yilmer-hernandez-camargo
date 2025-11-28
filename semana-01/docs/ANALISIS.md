# Semana 1 Consultoría Empresarial "Soluciones Estratégicas"

// Me falta cambiar esto

# Análisis Orientado a Objetos - Consultoría Empresarial

## 1. Identificación del Dominio

* **Nombre del negocio:** Soluciones Estratégicas
* **Tipo:** Consultoría Empresarial
* **Descripción:** Empresa que ofrece servicios especializados a clientes corporativos a través de proyectos definidos (Marketing, Logística, Finanzas) y genera documentación legal y financiera.

---

## 2. Objetos Identificados

### Objeto Principal: ConsultingProject (Proyecto de Consultoría)
* **¿Qué es?:** El servicio o tipo de trabajo que "Soluciones Estratégicas" ofrece a un cliente. Es la unidad central de ingresos y gestión.
* **Atributos identificados:**
    * projectCode: String - Código identificador único del proyecto (ej: MKT-001).
    * projectArea: String - Área de especialización del proyecto (ej: Marketing, Logistic).
    * isActive: boolean - Indica si el proyecto se encuentra en ejecución (true) o finalizado (false).
    * projectStartDate: int - Fecha de inicio del proyecto.
    * projectBudget: double - Monto total que el cliente debe pagar por el proyecto.
* **Métodos identificados:**
    * showProjectInfo(): Muestra todos los detalles del proyecto en consola.
    * calcularTarifaDiaria(): Calcula y retorna el costo promedio por día del proyecto.
    * getProjectCode(): Retorna el código identificador del proyecto.
    * setProjectBudget(double): Permite modificar el presupuesto asignado al proyecto.

### Objeto Secundario: Facturacion (Billing)
* **¿Qué es?:** El documento legal y financiero generado por la empresa para registrar la transacción de dinero relacionada con un proyecto.
* **Atributos identificados:**
    * numeroFactura: String - Número de identificación único de la factura (ej: FACT-001).
    * fechaEmision: int - Fecha en la que se generó la factura.
    * montoTotal: double - Valor total a cobrar/pagar en esa factura.
    * proyectoAsociadoCodigo: String - El código del proyecto al que se le está cobrando.
    * estadoDePago: boolean - Indica si el cliente ya pagó (true) o si el estado está pendiente (false).
* **Métodos identificados:**
    * mostrarEstadoFactura(): Imprime los detalles y el estado de pago (PAGADA/PENDIENTE) en consola.
    * registrarPago(): Cambia el atributo estadoDePago a true cuando se confirma la recepción del dinero.
    * calcularImpuestos(double): Calcula y retorna el monto de los impuestos aplicando una tasa al montoTotal.

---

## 3. Relación entre Objetos

* **Tipo de relación:** Asociación (Uno a Uno)
* **Descripción:** Un Proyecto de Consultoría (ConsultingProject) tiene una o más Facturas (Facturacion) asociadas a su código. La Factura necesita el proyectoAsociadoCodigo del Proyecto para saber a qué trabajo se refiere el cobro.

---

## 4. Justificación del Diseño

* **¿Por qué elegí estos objetos?**
    Porque el Proyecto es el centro de las operaciones (lo que se vende y se ejecuta) y la Facturación es el centro de las finanzas (lo que genera ingresos). Son las dos entidades esenciales para que el negocio funcione y se mantenga legalmente.
* **¿Por qué estos atributos son importantes?**
    Los atributos definidos son los datos mínimos y esenciales para identificar, rastrear y valorar financieramente el trabajo. Por ejemplo, projectCode permite la trazabilidad; projectBudget y montoTotal permiten el cálculo de ingresos; y isActive/estadoDePago permiten el control del flujo de trabajo y cobranza.
* **¿Por qué estos métodos son necesarios?**
    Los métodos representan la lógica de negocio: Cálculo (para decisiones financieras), y Gestión de Estado (para que los objetos cambien su estado en el tiempo, como de pendiente a pagada).

## 5. Diferencias entre programación estructurada y POO

Ambos son paradigmas que definen cómo se estructura el código. La Programación Estructurada se enfoca la ejecucion de pasos logicos acerca de x cosa. Su estructura se basa en funciones y el uso de variables globales que puedes cambiar mientras se avanza. El problema de la Programacion Estructurada es que, en proyectos grandes, la separación de los datos y la lógica hace que el código sea difícil de escalar y mantener.

La Programación Orientada a Objetos surgió para resolver esto. Se enfoca en modelar entidades del mundo real que son los objetos. Su concepto central consiste en agrupar los datos (atributos) y las acciones (métodos) en una sola unidad llamada Clase algo que se le denomina Encapsulameiento. La POO utiliza los conceptos de la Programacion Estructurada (como los bucles y condicionales) internamente, pero aporta una capa de modularidad lo que significa que nos permite separar el codigo en modulos o partes y que hace el código más legible y robusto.

### Ejemplo conceptual de cómo se manejaría la información de un proyecto en PE y POO:
#### PE Facturación:

```
public class ProjectStructuredPE {
    //first project data
    static String projectCode1 = "PROJECT-001";
    static String projectArea1 = "Planeación Estratégica";
    static double projectBudget1 = 5000.00;

    //Second data project
    static String projectCode2 = "PROJECT-002";
    static String projectArea2 = "Análisis Financiero";
    static double projectBudget2 = 3500.00;

    public static void showProjectInfo(String code, String area, double budget) {
            System.out.println("\n--- PROJECT ---");
            System.out.println("Project's code: " + code);
            System.out.println("Project's area: " + area);
            System.out.println("Project's budget: $" + budget);
        }

        public static void main(String[] args) {
            
            System.out.println("--- Structured Programming example ---");
            showProjectInfo(projectCode1, projectArea1, projectBudget1);
            showProjectInfo(projectCode2, projectArea2, projectBudget2);
        }
    }


```
#### POO Facturación:

```
public class ConsultingProject {

    String projectCode;
    String projectArea;
    double projectBudget;

    public ConsultingProject(String code, String area, double budget) {
        this.projectCode = code;
        this.projectArea = area;
        this.projectBudget = budget;
    }

    public void showProjectInfo() {
        System.out.println("--- Project POO ---");
        System.out.println("Project's code: " + this.projectCode);
        System.out.println("Project's area: " + this.projectArea);
        System.out.println("Project's budget: $" + this.projectBudget);
    }
}

public class Main {
    public static void main (String[] args){
    ConsultingProject firstProject = new ConsultingProject("PROJECT-001", "Finanzas", 5000.00);
    ConsultingProject secondProject = new ConsultingProject("PROJECT-002", "Administracion", 3500.00);
    firstProject.showProjectInfo();
    secondProject.showProjectInfo();

    }
}
```
---
### 2. 📉 Diagrama de Clases

```mermaid
classDiagram
    direction LR

    class ConsultingProject {
        - String projectCode
        # String projectArea
        # boolean isActive
        # int projectStartDate
        - double projectBudget
        + void showProjectInfo()
        + double calcularTarifaDiaria()
        + String getProjectCode()
        + void setProjectBudget(double)
    }

    class Facturacion {
        - String numeroFactura
        - int fechaEmision
        - double montoTotal
        - String proyectoAsociadoCodigo
        - boolean estadoDePago
        + void mostrarEstadoFactura()
        + void registrarPago()
        + double calcularImpuestos(double)
    }

    ConsultingProject "1" --> "*" Facturacion : tiene un código en

```