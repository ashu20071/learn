package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {
    private final int[][] adjacencyMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencyMatrixGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;

        adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++)
                adjacencyMatrix[i][j] = 0;
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= numVertices || v2 < 0 || v2 >= numVertices)
            throw new IllegalArgumentException("Vertex number is not valid");

        adjacencyMatrix[v1][v2] = 1;
        if (graphType == GraphType.UNDIRECTED)
            adjacencyMatrix[v2][v1] = 1;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v < 0 || v >= numVertices)
            throw new IllegalArgumentException("Vertex number is not valid");

        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1)
                adjacentVertices.add(i);
        }

        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getInDegree(int v) {
        if (v < 0 || v >= numVertices)
            throw new IllegalArgumentException("Vertex is not valid");
        int inDegree = 0;
        for (int i = 0; i < getNumVertices(); i++) {
            if (adjacencyMatrix[i][v] != 0)
                inDegree++;
        }
        return inDegree;
    }
}
