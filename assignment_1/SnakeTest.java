package assignment_1;

import java.util.Scanner;

public class SnakeTest {
    public static void main(String[] args) {
        // TODO Auto-generated met
        Snake snake = new Snake(4, 4);
        snake.StartSnake(3, 3);
        snake.GenerateFoodRandom();
        snake.ShowSnake();
        int i = 0;
        Scanner sc = new Scanner(System.in);

        try {
            while (i < 1000) {
                System.out.println("the snake is going to move to");
                System.out.println("(1:right, 2:down, 3:left, 4:up)");
                int dir = sc.nextInt();
                if (i % (4 * snake.queueSnake.size()) == 0)
                    snake.GenerateStoneRandom();
                snake.GenerateFoodRandom();
                snake.Move(dir);
                snake.ShowSnake();
                i++;
            }
        } catch (Error e) {
            System.out.println("The snake is dead, GAME OVER");
        }
        sc.close();
    }
}