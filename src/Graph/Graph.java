package Graph;

import java.util.List;

public interface Graph {
    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1, int v2);
    int getNumVertices();
    int getIndegree(int v);
    List<Integer> getAdjacentVertices(int v);
}