public class Main {
    public static void main(String[] args) {
        System.out.println("---- DEMOSTRACIÓN DE HERENCIA Y POLIMORFISMO ----");

        // Constante para las horas de cálculo
        final int HORAS_MENSUALES = 160;

        // Arreglo que guarde cualquier tipo que herede de Consultor .
        Consultor[] equipoConsultores = new Consultor[3];

        // 1. Consultor Senior
        equipoConsultores[0] = new ConsultorSenior("CS01", "Ana Senior", "Estrategia", 60.00, 5);

        // 2. Consultor Junior
        equipoConsultores[1] = new ConsultorJunior("CJ01", "Luis Junior", "Logistica", 45.00, 1, 100.0);

        // 3. Consultor Base
        equipoConsultores[2] = new Consultor("CB01", "Maria Base", "Finanzas", 55.00, 2);


        System.out.println("\n--- CÁLCULO DE COSTO MENSUAL (" + HORAS_MENSUALES + " horas) ---");

        // Bucle para recorrer el arreglo creado
        for (int i = 0; i < equipoConsultores.length; i++) {

            // En cada interacion obtenemos un consultor
            Consultor consultorActual = equipoConsultores[i];

            // Usamoa el metodo heredado para mostrar info
            consultorActual.mostrarInformacionBase();

            // Costo total de cada objeto
            double costoTotal = consultorActual.calcularCostoMensualEstimado(HORAS_MENSUALES);

            System.out.printf("Costo Estimado Final: $%.2f%n", costoTotal);
            System.out.println("---");
        }
    }
}