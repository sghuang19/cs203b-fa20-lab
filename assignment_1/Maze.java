package assignment_1;

public class Maze {
    private int[][] mazeMat;
    private int width;
    private int height;

    public Maze(int[][] mazeMatrix, int width, int height) {
        this.mazeMat = mazeMatrix;
        this.width = width;
        this.height = height;
    }

    class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void DFSearchPath(int startX, int startY, int endX, int endY) {
    }

    @Override
    public String toString() {
        String ResultString = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ResultString += mazeMat[i][j] + " ";
            }
            ResultString += "\n";
        }
        return ResultString;
    }

    public void DFSearchPath(int startX, int startY, int endX, int endY)
    // show the path from start point to end point with value 2 in matrix.
}
