package Graph;

import java.util.List;

public interface Graph {
    enum GraphType {
        DIRECTED,
        UNDIRECTED;
    }

    int getWeightedEdge(int currentVertex, Integer neighbour);
    void addEdge(int v1, int v2);
    int getNumVertices();
    int getInDegree(int v);
    List<Integer> getAdjacentVertices(int v);
}