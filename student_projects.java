import java.util.ArrayList;
import java.util.List;

class Project {
    String studentName;
    int completionTime; // in days
    boolean onTime;

    public Project(String studentName, int completionTime, boolean onTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
        this.onTime = onTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public boolean isOnTime() {
        return onTime;
    }
}

class ProjectAnalyzer {
    List<Project> projects;

    public ProjectAnalyzer() {
        projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void analyzeProjects() {
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        double totalCompletionTime = 0;

        for (Project project : projects) {
            if (project.isOnTime()) {
                onTimeCount++;
            } else if (project.getCompletionTime() > 0) {
                lateCount++;
            } else {
                earlyCount++;
            }

            totalCompletionTime += project.getCompletionTime();
        }

        int totalProjects = projects.size();
        double averageCompletionTime = totalCompletionTime / totalProjects;

        System.out.println("Number of projects completed on time: " + onTimeCount);
        System.out.println("Number of projects completed late: " + lateCount);
        System.out.println("Number of projects completed early: " + earlyCount);
        System.out.println("Average completion time for projects: " + averageCompletionTime + " days");
    }
}

public class Main {
    public static void main(String[] args) {
        ProjectAnalyzer analyzer = new ProjectAnalyzer();

        // Example usage:
        analyzer.addProject(new Project("Alice", 5, true));
        analyzer.addProject(new Project("Bob", 7, false));
        analyzer.addProject(new Project("Charlie", -2, false));

        analyzer.analyzeProjects();
    }
}
