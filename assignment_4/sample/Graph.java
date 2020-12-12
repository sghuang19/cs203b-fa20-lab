package assignment_4.sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    //
    public void readGraphFile(String strFile) throws IOException {
    }

    // print each vertex in a line with other vertices and their weight in ascending
    // order according to vertices number
    public String printAdjacencyList() {
        String strList = "";
        return strList;// each line prints the start vertex and other vertices numbers and weights of
                       // edges ascending
    }

    // print each weight in matrix with vertices number as row and col in ascending
    // order according to vertices number
    public String pintAdjacencyMatrix() {
        String strMatrix = "";
        return strMatrix;// each row and each line print the vertex numbers and weights ascending
    }

    // print the shortest path from startVertex to other vertices, except itself
    // output format: [shortestPathLength]v1,v2,...,vn
    // if no path from v1 to vn, print [0]null
    public String ShortestPath(int startVertex) {
        String strPath = "";
        return strPath;
    }

    public String ShortestPath(int startVertex, int endVertex) {
        String strPath = "";
        return strPath;
    }

}
