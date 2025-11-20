 public class ConsultingProject {
        private String projectId;
        private String projectTitle;
        private double projectBudget;

        public ConsultingProject(String projectId, String projectTitle, double projectBudget) {
            this.projectId = projectId;
            this.projectTitle = projectTitle;
            this.projectBudget = projectBudget;
        }

        public void ShowProjectInfo() {
            System.out.println("Project's Id: " + projectId);
            System.out.println("Project's name is: " + projectTitle);
            System.out.println("Project's budget: " + projectBudget + " dollars.");
        }
    }
