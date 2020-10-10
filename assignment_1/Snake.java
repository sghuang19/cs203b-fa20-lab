package assignment_1;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * in array grid
 * <p>
 * snake is represented as 0
 * <p>
 * empty grids are represented as 1
 * <p>
 * food are represented as 2
 * <p>
 * stones are represented as 3
 */
public class Snake {
    public int[][] grid;
    int width;
    int height;
    Queue<pos> queueSnake = new LinkedList<>();
    pos curPos;
    pos foodPos;

    /**
     * generate the game map of matrix
     *
     * @param width
     * @param height
     */
    public Snake(int width, int height) {
        // initialize the grid
        this.width = width;
        this.height = height;
        grid = new int[height][width];
        for (int[] ints : grid) {
            Arrays.fill(ints, 1);
        }
        foodPos = new pos(5, 5);
    }

    /**
     * start snake at position (i, j)
     *
     * @param i
     * @param j
     */
    public void StartSnake(int i, int j) {
        JFrame jf = new JFrame();
        jf.setSize(width * 20, height * 20);
        // GridLayout layout = new GridLayout(width, height)
        // JPanel jp = new JPanel(Grid);

        this.curPos = new pos(i, j);
        this.queueSnake.add(curPos);
        this.grid[i][j] = 0;
    }

    /**
     * print the grid with snake
     */
    public void ShowSnake() {
        StringBuilder resultString = new StringBuilder("\n");
        resultString.append("=".repeat(width));
        resultString.append("\n");

        for (int[] is : grid) {
            for (int i : is) {
                resultString.append(i);
            }
            resultString.append("\n");
        }

        resultString.append("=".repeat(width));
        System.out.println(resultString);
    }

    /**
     * generate food at position(x,y)
     *
     * @param x
     * @param y
     */
    public void GenerateFood(int x, int y) {
        if (!FoodOnSnake(x, y))
            this.grid[x][y] = 2;
    }

    /**
     * generate food at a random position
     */
    public void GenerateFoodRandom() {
        Random rm = new Random();
        int x = rm.nextInt(this.height);
        int y = rm.nextInt(this.width);
        while (FoodOnSnake(x, y)) {
            x = rm.nextInt(this.height);
            y = rm.nextInt(this.width);
        }
        GenerateFood(x, y);
    }

    /**
     * generate a stone at position(x,y)
     *
     * @param x
     * @param y
     */
    public void GenerateStone(int x, int y) {
        for (int[] ints : this.grid) {
            for (int i = 0; i < width; i++) {
                if (ints[i] == 3)
                    ints[i] = 1;
            }
        }
        if (!FoodOnSnake(x, y))
            this.grid[x][y] = 3;
    }

    /**
     * generate a stone at a random position
     */
    public void GenerateStoneRandom() {
        Random rm = new Random();
        int x = rm.nextInt(this.height);
        int y = rm.nextInt(this.width);
        while (FoodOnSnake(x, y)) {
            x = rm.nextInt(this.height);
            y = rm.nextInt(this.width);
        }
        GenerateStone(x, y);
    }

    /**
     * food should disappear and generates new food
     *
     * @param x
     * @param y
     * @return if food is on the snake, return true, food should disappear and
     * generates new food
     */
    public boolean FoodOnSnake(int x, int y) {
        for (pos p : this.queueSnake) {
            if (p.x == x && p.y == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * move a step according to direction
     *
     * @param direction 0-right, 1-down, 2-left, 3-up
     * @throws Error when the snake would be dead in this move
     */
    public void Move(int direction) throws Error {
        // obtain the pos of the head of the snake

        int x = this.curPos.x;
        int y = this.curPos.y;
        switch (direction) {
            case 1:
                y++;
                break;
            case 2:
                x++;
                break;
            case 3:
                y--;
                break;
            case 4:
                x--;
                break;
            default: {
                System.out.println("Invalid direction");
                return;
            }
        }

        if (JudgeEnd(x, y))
            throw new Error();

        this.curPos = new pos(x, y);
        this.queueSnake.add(this.curPos);
        if (this.grid[x][y] != 2) {
            pos p = this.queueSnake.remove();
            this.grid[p.x][p.y] = 1;
        }

        // rewrite the grid
        for (pos p : this.queueSnake) {
            this.grid[p.x][p.y] = 0;
        }
    }

    public boolean JudgeEnd(int x, int y) {
        if (x < 0 || x >= height) {
            System.out.println("You Died\nSnake hits the wall");
            return true;
        }
        if (y < 0 || y >= width) {
            System.out.println("You Died\nSnake hits the wall");
            return true;
        }
        if (this.grid[x][y] == 3) {
            System.out.println("You Died\nSnake eats the stone");
            return true;
        }
        for (pos p : this.queueSnake) {
            if (p.x == x && p.y == y) {
                System.out.println("You Died\nSnake eats itself");
                return true;
            }
        }

        return false;
    }

    public static class pos {
        public int x;
        public int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
