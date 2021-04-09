public class ProjectTest {
    public static void main(String[] args) {
        Project p = new Project("Test", "Description", 13723.11);
        Project p2 = new Project("Another", "Project", 300.00);
        Portfolio portfolio = new Portfolio(p,p2);

        portfolio.showPortfolio();
    }
}
