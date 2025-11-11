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
