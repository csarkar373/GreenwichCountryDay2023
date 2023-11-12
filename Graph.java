import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
    private class Coordinate {
        int row;
        int col;
        int shortestDistance;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    // No. of vertices
    private int V;

    // Adjacency Lists
    private LinkedList<Coordinate> adj[][];

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v][v];
        for (int r = 0; r < v; ++r)
            for (int c = 0; c < v; c++) {
                adj[r][c] = new LinkedList();
            }
    }

    // Function to add an edge into the graph
    void addEdge(int r1, int c1, int r2, int c2) {
        adj[r1][c1].add(new Coordinate(r2,c2));
    }

    boolean isValid(int r, int c) {
        return (r >= 0 && r < V && c >= 0 && c < V);
    }

    // prints BFS traversal from a given source s
    void BFS(int startR, int startC, int finishR, int finishC)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[][] = new boolean[V][V];
        int shortestDistance[][] = new int[V][V];

        // Create a queue for BFS
        LinkedList<Coordinate> queue
                = new LinkedList<Coordinate>();

        // Mark the current node as visited and enqueue it
        visited[startR][startC] = true;
        queue.add(new Coordinate(startR,startC));

        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            Coordinate s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued
            // vertex s.
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Coordinate> i = adj[s.row][s.col].listIterator();
            while (i.hasNext()) {
                Coordinate n = i.next();
                if (!visited[n.row][n.col]) {
                    visited[n.row][n.col] = true;
                    shortestDistance[n.row][n.col] = shortestDistance[s.row][s.col] + 1;
                    queue.add(n);
                }
                if (n.row == finishR && n.col == finishC) {
                    System.out.println("Solution Found: " + shortestDistance[n.row][n.col]);
                }
            }
        }
    }

    // Driver code
    public static void main(String args[]) throws Exception
    {
        File f = new File("input7.txt");
        Scanner scan = new Scanner(f);
        int v = Integer.parseInt(scan.nextLine());
        String [] tokens = scan.nextLine().split(" ");
        int startC = Integer.parseInt(tokens[0]);
        int startR = Integer.parseInt(tokens[1]);

        tokens = scan.nextLine().split(" ");
        int finishC = Integer.parseInt(tokens[0]);
        int finishR = Integer.parseInt(tokens[1]);


        Graph g = new Graph(v);
        for (int row = 0; row < v; ++row) {
            for (int col = 0; col < v; ++col) {
                if (g.isValid(row-1, col-2)) g.addEdge(row, col, row-1, col-2);
                if (g.isValid(row+1, col-2)) g.addEdge(row, col, row+1, col-2);
                if (g.isValid(row-2, col-1)) g.addEdge(row, col, row-2, col-1);
                if (g.isValid(row+2, col-1)) g.addEdge(row, col, row+2, col-1);
                if (g.isValid(row-2, col+1)) g.addEdge(row, col, row-2, col+1);
                if (g.isValid(row+2, col+1)) g.addEdge(row, col, row+2, col+1);
                if (g.isValid(row-1, col+2)) g.addEdge(row, col, row-1, col+2);
                if (g.isValid(row+1, col+2)) g.addEdge(row, col, row+1, col+2);
            }
        }

        g.BFS(startR, startC, finishR, finishC);
    }
}
