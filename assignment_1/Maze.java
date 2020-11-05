package assignment_1;

import java.util.Stack;

public class Maze {
    private int[][] mazeMat;
    private int width;
    private int height;

    public Maze(int[][] mazeMatrix, int width, int height) {
        this.mazeMat = mazeMatrix;
        this.width = width;
        this.height = height;
    }

    // class Node {
    // int x, y;

    // public Node(int x, int y) {
    // this.x = x;
    // this.y = y;
    // }
    // }

    /**
     * show the path from start point to end point with value 2 in matrix
     * 
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public void DFSearchPath(int startX, int startY, int endX, int endY) {
        Path path = new Path();
        Path invalid_path = new Path();
        path.push(new Node(startX, startY));

        int x = startX;
        int y = startY;

        this.mazeMat[endX][endY] = 0;

        while (!(x == endX && y == endY)) {

            // the first level index increasing indicates downward direction
            // the second level index increasing indicates rightward direction

            // step right
            if (y + 1 < width && this.mazeMat[x][y + 1] != 1 && !invalid_path.contains(x, y + 1)
                    && !path.contains(x, y + 1)) {
                path.push(new Node(x, y + 1));
                y++;
                continue;
            }

            // step down
            if (x + 1 < height && this.mazeMat[x + 1][y] != 1 && !invalid_path.contains(x + 1, y)
                    && !path.contains(x + 1, y)) {
                path.push(new Node(x + 1, y));
                x++;
                continue;
            }

            // step left
            if (y - 1 >= 0 && this.mazeMat[x][y - 1] != 1 && !invalid_path.contains(x, y) && !path.contains(x, y - 1)) {
                path.push(new Node(x, y - 1));
                y--;
                continue;
            }

            // step up
            if (x - 1 >= 0 && this.mazeMat[x - 1][y] != 1 && !invalid_path.contains(x - 1, y)
                    && !path.contains(x - 1, y)) {
                path.push(new Node(x - 1, y));
                x--;
                continue;
            }

            // all the moving directions are invalid, step back
            Node lastMoveNode = path.pop();
            x = lastMoveNode.x;
            y = lastMoveNode.y;
            invalid_path.push(lastMoveNode);
        }

        // rewrite the mazeMatrix
        for (Node step : path) {
            this.mazeMat[step.x][step.y] = 2;
        }
        this.mazeMat[startX][startY] = 3;
        this.mazeMat[endX][endY] = 4;
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

}

class Path extends Stack<Node> {

    /**
     *
     */
    private static final long serialVersionUID = 744463356338360382L;

    public Path() {

    }

    /**
     * This method is to judge by value whether a pair of coordinate exists in the
     * path or not
     * 
     * @param x the value of x coordinate to be searched
     * @param y the value of y coordinate to be searched
     * @return true if exists in the path, false otherwise
     */
    public boolean contains(int x, int y) {
        for (Node node : this) {
            if (node.x == x && node.y == y) {
                return true;
            }
        }
        return false;
    }

}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
