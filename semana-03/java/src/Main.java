//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    // Se instancia los 3 objetos diferentes con base a la clase ConsultingProject
    ConsultingProject financialProject = new ConsultingProject("CONS-001", "Orientacion Financiera", 3000000 );
    ConsultingProject marketingProject = new ConsultingProject("CONS-002", "Orientacion en Marketing", 4000000 );
    ConsultingProject managmentTalentProject = new ConsultingProject("CONS-003", "Gestion de talento", 4500000 );

    //Se llama al metodo ShowProjectInfo para todos los objetos
    System.out.println("\n------------First Project------------");
    financialProject.ShowProjectInfo();
    System.out.println("\n------------Second Project------------");
    marketingProject.ShowProjectInfo();
    System.out.println("\n------------Third Project------------");
    managmentTalentProject.ShowProjectInfo();


}
