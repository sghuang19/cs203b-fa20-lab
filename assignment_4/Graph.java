package assignment_4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {
    private boolean isDirected;
    private int[][] adjTable;

    public Graph(boolean isDirected, int[][] adjTable) {
        this.isDirected = isDirected;
        this.adjTable = adjTable;
    }

    public Graph(File file) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new FileReader(file));
        this.isDirected = Integer.parseInt(bf.readLine()) == 1;

        StringBuilder str = new StringBuilder();
        String textLine;
        while ((textLine = bf.readLine()) != null)
            str.append(textLine).append(" ");

        String[] numbs = str.toString().split(" ");
        this.adjTable = new int[numbs.length / 3][3];
        System.out.println("The numbers array is:");
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numbs.length / 3; j++) {
                adjTable[j][0] = Integer.parseInt(numbs[i++]);
                adjTable[j][1] = Integer.parseInt(numbs[i++]);
                adjTable[j][2] = Integer.parseInt(numbs[i++]);
                System.out.println(Arrays.toString(adjTable[j]) + ", ");
            }
        }

        // System.out.println("");
        bf.close();
//        System.out.println("Original:" + Arrays.toString(this.adjTable));
    }

    public boolean isDirected() {
        return isDirected;
    }

    public int[][] getAdjTable() {
        return adjTable;
    }

//    public int[][] getAdjMatrix() {
//        return
//    }
}
