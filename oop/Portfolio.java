import java.util.ArrayList;
import java.util.Arrays;

public class Portfolio {
    private ArrayList<Project> projects;

    Portfolio() {
        projects = new ArrayList<>();
    }
    Portfolio(Project ... projects) {
        this();
        this.projects.addAll(Arrays.asList(projects));
    }
    public double getPortfolioCost() {

        double total = 0;
        for (Project project : projects) {
            total+=project.getInitialCost();
        }

        return total;
    }

    public void showPortfolio() {

        for (Project project: projects) {
            System.out.println(project.elevatorPitch());

        }

        System.out.printf("Total cost: $%.2f", getPortfolioCost());
    }
}
