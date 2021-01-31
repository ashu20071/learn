package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencySetGraph implements Graph {
    private List<GraphNode> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySetGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;
        for (int i = 0; i < numVertices; i++)
            vertexList.add(new GraphNode(i));
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= numVertices || v2 < 0 || v2 >= numVertices)
            throw new IllegalArgumentException("Vertex is not valid");
        vertexList.get(v1).addEdge(v2);
        if (graphType == GraphType.UNDIRECTED)
            vertexList.get(v2).addEdge(v1);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v < 0 || v >= numVertices)
            throw new IllegalArgumentException("Vertex is not valid");
        return vertexList.get(v).getAdjacentVertices();
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        if (visited[currentVertex] == 1)
            return;
        visited[currentVertex] = 1;
        List<Integer> list = graph.getAdjacentVertices(currentVertex);
        for (int vertex : list)
            depthFirstTraversal(graph, visited, vertex);
        System.out.print(currentVertex+" ");

        //For unconnected graph, traverse through all vertices
        /*
        for (int i = 0; i < numVertices; i++)
            depthFirstTraversal(graph, visited, i);
         */
    }

    public void breadthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentVertex);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (visited[vertex] == 1)
                continue;
            System.out.print(vertex+" ");
            visited[vertex] = 1;

            List<Integer> list = graph.getAdjacentVertices(vertex);
            for (int v : list) {
                if (visited[v] != 1)
                    queue.add(v);
            }
        }
        //For unconnected graph, traverse through all vertices
        /*
        for (int i = 0; i < numVertices; i++)
            breadthFirstTraversal(graph, visited, i);
         */
    }

    public int getIndegree(int v) {
        if (v < 0 || v >= numVertices)
            throw new IllegalArgumentException("Vertex is not valid");
        int indegree = 0;
        for (int i = 0; i < getNumVertices(); i++) {
            if (getAdjacentVertices(i).contains(v))
                indegree++;
        }
        return indegree;
    }
}
