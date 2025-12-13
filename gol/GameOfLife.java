public class GameOfLife implements Board {

    // Integers: 0 or 1 for alive or dead
    private int[][] board;

    public GameOfLife(int x, int y) {
        // Construct a 2d array of the given x and y size.
        board = new int[x][y]; // defaults to all 0s
    }

    // Set values on the board
    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                board[i + x][j + y] = data[i][j];
            }
        }
    }

        // Set values on the board
    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                board[i + x][j + y] = data[i][j];
            }
        }
    }

    // Run the simulation for a number of turns
    public void run(int turns) {
        for (int t = 0; t < turns; t++) {
            step();
        }
    }

}
// Step the simulation forward one turn.
    public void step() {
        print();

        int rows = board.length;
        int cols = board[0].length;

        int[][] next = new int[rows][cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                int neighbors = countNeighbors(x, y);
                int current = get(x, y);

                // Conway's rules:
                // Alive cell survives if it has 2 or 3 neighbors
                // Dead cell becomes alive if it has exactly 3 neighbors
                if (current == 1) {
                    next[x][y] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    next[x][y] = (neighbors == 3) ? 1 : 0;
                }
            }
        }
        board = next;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;

        // Count all 8 neighbors using wraparound get()
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                count += get(x + dx, y + dy);
            }
        }

        return count;
    }
  // Get a value from the board with "wrap around"
    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit = board[0].length;
        return board[(x + xLimit) % xLimit][(y + yLimit) % yLimit];
    }

    // Test helper to get the whole board state
    public int[][] get() {
        return board;
    }

    // Test helper to print the current state
    public void print() {
        // Print the header
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y % 10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x % 10);
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 1) {
                    System.out.print("⬛");
                } else {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}