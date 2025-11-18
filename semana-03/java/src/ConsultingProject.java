import javax.print.DocFlavor;

public class ConsultingProject {
    private String projectId;
    private String projectArea;
    private double projectBudget;

    public ConsultingProject(String projectId, String projectArea, double projectBudget ) {
        this.projectId = projectId;
        this.projectArea = projectArea;
        this.projectBudget = projectBudget ;
    }
    public void ShowProjectInfo(){
        System.out.println("Project's Id: " + projectId);
        System.out.println("Project's Area: " + projectArea );
        System.out.println("Project's duration: " + projectBudget);
    }
}
