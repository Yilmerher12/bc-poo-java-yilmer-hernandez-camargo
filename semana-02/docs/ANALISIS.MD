# Semana 2 Consultoría Empresarial "Soluciones Estratégicas"

### Diferencias entre programación estructurada y POO

Ambos son paradigmas que definen cómo se estructura el código. La Programación Estructurada se enfoca la ejecucion de pasos logicos acerca de x cosa. Su estructura se basa en funciones y el uso de variables globales que puedes cambiar mientras se avanza. El problema de la Programacion Estructurada es que, en proyectos grandes, la separación de los datos y la lógica hace que el código sea difícil de escalar y mantener.

La Programación Orientada a Objetos surgió para resolver esto. Se enfoca en modelar entidades del mundo real que son los objetos. Su concepto central consiste en agrupar los datos (atributos) y las acciones (métodos) en una sola unidad llamada Clase algo que se le denomina Encapsulameiento. La POO utiliza los conceptos de la Programacion Estructurada (como los bucles y condicionales) internamente, pero aporta una capa de modularidad lo que significa que nos permite separar el codigo en modulos o partes y que hace el código más legible y robusto.

### Ejemplo conceptual de cómo se manejaría la información de un proyecto en PE POO:
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
