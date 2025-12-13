package gol;

interface Board {

    public void run(int turns);
    public void step();
    public int countNeighbors(int x, int y);
    public int get(int x, int y);
    public int[][] get();
}
