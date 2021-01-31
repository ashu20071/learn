package Graph;

import java.util.*;

public class GraphNode {
    private int vertex;
    private Set<Integer> adjacencySet = new HashSet<>();

    public GraphNode(int vertex) {
        this.vertex = vertex;
    }

    public int getVertex() {
        return vertex;
    }

    public void addEdge(int vertex) {
        adjacencySet.add(vertex);
    }

    public List<Integer> getAdjacentVertices() {
        List<Integer> sortedList = new ArrayList<>(adjacencySet);
        Collections.sort(sortedList);
        return sortedList;
    }
}
