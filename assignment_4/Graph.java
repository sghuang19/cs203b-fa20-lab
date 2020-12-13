package assignment_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The graph stored as adjacencyList, which is a ArrayList of ArrayList of int
 * array.
 * The index of the adjacencyList indicates the vertex, and each element of the
 * adjacencyList is another ArrayList, each element of which is an int array,
 * the first element in the array represents the endVertex, the second element
 * represents the weight of the edge.
 */
public class Graph {
    private boolean isDirected;
    private ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>();

    /**
     * Empty constructor.
     */
    public Graph() {
    }

    /**
     * Constructor with isDirected and adjacencyList given.
     *
     * @param isDirected    true for directed graph, false for undirected
     * @param adjacencyList the adjacency list of the graph
     */
    public Graph(boolean isDirected, ArrayList<ArrayList<int[]>> adjacencyList) {
        this.isDirected = isDirected;
        this.adjacencyList = adjacencyList;
    }

    /**
     * Constructor with adjacencyList given only, isDirected is set to be default as
     * true.
     *
     * @param adjacencyList the adjacency list of the graph
     */
    public Graph(ArrayList<ArrayList<int[]>> adjacencyList) {
        this.isDirected = true;
        this.adjacencyList = adjacencyList;
    }

    /**
     * Constructor with the file name of the graph file.
     *
     * @param strFile the file name of the graph file
     * @throws IOException IOException
     */
    public Graph(String strFile) throws IOException {
        this.readGraphFile(strFile);
    }

    /**
     * Read graph file, this method will set the graph object to be the graph
     * specified in the graph file, and returns the adjacency list.
     *
     * @param strFile the file name of the graph file
     * @return the adjacency list read
     * @throws IOException IOException
     */
    public ArrayList<ArrayList<int[]>> readGraphFile(String strFile) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(strFile));
        this.isDirected = Integer.parseInt(bf.readLine()) == 1;

        StringBuilder str = new StringBuilder();
        String textLine;
        while ((textLine = bf.readLine()) != null)
            str.append(textLine).append(" ");
        bf.close();
        String[] numbs = str.toString().split(" ");

        // System.out.println("The numbers array is:");
        // for (String string : numbs) {
        // System.out.println(string);
        // }

        for (int i = 0; i < numbs.length; i += 3) {
            // System.out.println("=========");
            // System.out.println(i);
            int startVertex = Integer.parseInt(numbs[i]);
            int endVertex = Integer.parseInt(numbs[i + 1]);
            int weight = Integer.parseInt(numbs[i + 2]);
            this.addEdge(startVertex, endVertex, weight);
            // System.out.println(i);
            // System.out.println("=========");
            if (!isDirected)
                this.addEdge(endVertex, startVertex, weight);
        }
        return adjacencyList;
    }

    public boolean isDirected() {
        return isDirected;
    }

    /**
     * @return the adjacencyList of the graph
     */
    public ArrayList<ArrayList<int[]>> getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * @return the size of the graph
     */
    public int size() {
        return this.adjacencyList.size();
    }

    /**
     * Extend the size of the adjacency list to the index of the vertex, equivalent
     * with adding this node
     *
     * @param vertex the index of the vertex
     * @return if the node already exists, return false, else return true
     */
    public boolean addVertex(int vertex) {
        if (this.existsVertex(vertex))
            return false;
        while (!this.existsVertex(vertex))
            this.adjacencyList.add(new ArrayList<>());
        return true;
    }

    /**
     * Add an edge with start vertex, end vertex and weight given, will not override
     * edge exist.
     *
     * @param startVertex the index of the start vertex of the edge
     * @param endVertex   the index of the end vertex of the edge
     * @param weight      the weight of the edge
     */
    public void addEdge(int startVertex, int endVertex, int weight) {
        this.addVertex(startVertex);
        this.addVertex(endVertex);
        this.adjacencyList.get(startVertex).add(new int[]{endVertex, weight});
    }

    /**
     * To get whether a vertex exists in the adjacency list or not.
     *
     * @param vertex the index of the vertex to be verified
     * @return If the vertex exists in the adjacency list, return true, else return
     * false
     */
    public boolean existsVertex(int vertex) {
        return this.adjacencyList.size() > vertex;
    }

    /**
     * Print each vertex in a line with other vertices and their weight in ascending
     * order according to vertices number.
     *
     * @return Each line prints the start vertex and other vertices numbers and
     * weights of edges ascending.
     */
    public String printAdjacencyList() {
        StringBuilder strList = new StringBuilder();
        for (int i = 0; i < this.adjacencyList.size(); i++) {
            strList.append(i).append(":");
            for (int[] edge : this.adjacencyList.get(i))
                strList.append("(").append(i).append(",").append(edge[0]).append(":").append(edge[1]).append(")");
            strList.append("\n");
            // System.out.println(i);
        }
        return strList.toString();
    }

    /**
     * Print each weight in matrix with vertices number as row and col in ascending
     * order according to vertices number.
     *
     * @return Each row and each line print the vertex numbers and weights
     * ascending.
     */
    public String printAdjacencyMatrix() {
        int graphSize = this.size();
        int[][] adjacencyMatrix = new int[graphSize][graphSize];
        for (int[] is : adjacencyMatrix)
            Arrays.fill(is, 0);

        for (int i = 0; i < graphSize; i++) {
            for (int[] is : this.adjacencyList.get(i))
                adjacencyMatrix[is[0]][i] = is[1];
        }

        StringBuilder strMatrix = new StringBuilder();
        for (int[] is : adjacencyMatrix) {
            for (int i : is)
                strMatrix.append(i).append(" ");
            strMatrix.append("\n");
        }
        return strMatrix.toString();
    }

    /**
     * Print the shortest path from startVertex to other vertices, except itself.
     *
     * @param startVertex the start vertex of the path
     * @return [shortestPathLength]v1, v2, ..., vn. If no path from v1 to vn, print
     * [0]null
     */
    @SuppressWarnings("unchecked")
    public String ShortestPath(int startVertex) {
        int size = this.size();
        ArrayList<Integer>[] path = new ArrayList[size];

        boolean[] relaxed = new boolean[size];
        relaxed[startVertex] = true;

        int[] distance = new int[size];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;
        for (int[] is : this.adjacencyList.get(startVertex))
            distance[is[0]] = is[1];

        for (int i = 0; i < size - 1; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < size; j++) {
                if (!relaxed[j] && distance[j] < min) {
                    min = distance[j];
                    k = j;
                }
            }
            if (min == Integer.MAX_VALUE) break;

            relaxed[k] = true;
            for (int[] is : this.adjacencyList.get(k)) {
                if (distance[is[0]] > min + is[1]) {
                    distance[is[0]] = min + is[1];
                    ArrayList<Integer> temp = new ArrayList<>();
                    if (path[k] != null)
                        temp.addAll(path[k]);
                    temp.add(k);
                    path[is[0]] = temp;
                }
            }
        }

        for (int i = 0; i < size; i++)
            distance[i] = distance[i] == Integer.MAX_VALUE ? 0 : distance[i];


        StringBuilder strPath = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == startVertex) continue;
            strPath.append("[").append(distance[i]).append("]");
            if (distance[i] == 0) {
                strPath.append("null\n");
                continue;
            }
            strPath.append(startVertex).append(",");
            if (path[i] != null) {
                for (int j : path[i])
                    strPath.append(j).append(",");
            }
            strPath.append(i).append("\n");
        }

        return strPath.toString();
    }

    /**
     * Print the shortest path from startVertex to the endVertex, except itself.
     *
     * @param startVertex the start vertex of the path
     * @param endVertex   the end vertex of the path
     * @return [shortestPathLength]v1, v2, ..., vn. If no path from v1 to vn, print
     * [0]null
     */
    public String ShortestPath(int startVertex, int endVertex) {
        String[] path = ShortestPath(startVertex).split("\n");
        int i = endVertex > startVertex ? endVertex - 1 : endVertex;
        return path[i];
    }
}
