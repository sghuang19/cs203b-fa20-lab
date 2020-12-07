package assignment_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ShortestPathTest {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        File file = new File("assignment_4\\numbs.txt");
        Graph graph = new Graph(file);

    }
}