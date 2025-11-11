# Semana 2 Consultoría Empresarial "Soluciones Estratégicas"

### Diferencias entre programación estructurada y POO

Ambos son paradigmas que definen cómo se estructura el código. La Programación Estructurada se enfoca la ejecucion de pasos logicos acerca de x cosa. Su estructura se basa en funciones y el uso de variables globales que puedes cambiar mientras se avanza. El problema de la Programacion Estructurada es que, en proyectos grandes, la separación de los datos y la lógica hace que el código sea difícil de escalar y mantener.

La Programación Orientada a Objetos surgió para resolver esto. Se enfoca en modelar entidades del mundo real que son los objetos. Su concepto central consiste en agrupar los datos (atributos) y las acciones (métodos) en una sola unidad llamada Clase algo que se le denomina Encapsulameiento. La POO utiliza los conceptos de la Programacion Estructurada (como los bucles y condicionales) internamente, pero aporta una capa de modularidad lo que significa que nos permite separar el codigo en modulos o partes y que hace el código más legible y robusto.

### Ejemplo conceptual de cómo se manejaría la información de un proyecto en PE POO:
#### PE Facturación:

```
public class CalculoFacturaPE {

    static double tarifaPorHora = 20000.0;
    static double horasAsesoradas = 2.5; 
    static double costoBase = 200000.0;

    public static double calcularCosto(double tarifa, double horas, double base) {
        return (tarifa * horas) + base;
    }

    public static void main(String[] args) {
        double costoFinal = calcularCosto(tarifaPorHora, horasAsesoradas, costoBase);
        
        System.out.println("Costo Final (PE): " + costoFinal);
    }
}

```
#### POO Facturación:

```
public class ItemFacturable {

    double tarifaPorHora;
    double horasAsesoradas;
    double costoBase;

    public ItemFacturable(double tarifa, double horas, double base) {
        this.tarifaPorHora = tarifa;
        this.horasAsesoradas = horas;
        this.costoBase = base;
    }

    public double calcularCosto() {
        return (this.tarifaPorHora * this.horasAsesoradas) + this.costoBase;
    }
}

public class Main {

    public static void main(String[] args) {
        ItemFacturable asesoriaMarketing = new ItemFacturable(20000.0, 2.5, 200000.0);
        
        double costoFinal = asesoriaMarketing.calcularCosto();

        System.out.println("Costo Final (POO): " + costoFinal);
    }
}
```

**Instrucciones:**
- Investiga las diferencias entre programación estructurada y POO
- Escribe un ejemplo conceptual de cómo se manejaría la información de un proyecto en:
  1. **Programación estructurada** (usando variables sueltas y funciones)
  2. **Programación orientada a objetos** (usando una clase)

**Entregable:** Documento comparativo con ejemplos explicados.