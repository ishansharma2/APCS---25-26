package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver() {
        // Nothing to do here
    }

    public void solve(TowerModel model) {
        this.model = model;
        solve(model.height(), 0, 2, 1);
    }

    // Recursive solve method
    private void solve(int n, int source, int destination, int auxiliary) {
        if (n == 1) {
            model.move(source, destination);
            return;
        }

        solve(n - 1, source, auxiliary, destination);
        model.move(source, destination);
        solve(n - 1, auxiliary, destination, source);
    }
}x