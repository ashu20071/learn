package Graph;

import java.util.*;

/**
 * This class holds distance info of any vertex in an Weighted Graph.
 * The distance specified is the distance from the source vertex.
 * Last vertex is the last vertex seen in the path from source to this vertex.
 */

class DistanceInfoBF {
    private int distance;
    private int lastVertex;

    public DistanceInfoBF() {
        distance = 100000;
        lastVertex = -1;
    }

    public int getDistance() {
        return distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }
}

public class BellmanFord {
    public Map<Integer, DistanceInfoBF> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfoBF> distanceTable = new HashMap<>();
        for (int i = 0; i < graph.getNumVertices(); i++)
            distanceTable.put(i, new DistanceInfoBF());
        // Set up distance for the source node
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        LinkedList<Integer> queue = new LinkedList<>();
        // Relaxing process for every edge numEdges - 1 times
        for (int numIterations = 0; numIterations < graph.getNumVertices() - 1; numIterations++) {
            // Add all the vertices in the queue so we're sure all edges are covered
            for (int v = 0; v < graph.getNumVertices(); v++)
                queue.add(v);
            // Keep track of edges so we visit each edge just once
            Set<String> visitedEdges = new HashSet<>();
            while (!queue.isEmpty()) {
                int currentVertex = queue.pollFirst();
                for (int neighbour : graph.getAdjacentVertices(currentVertex)) {
                    String edge = String.valueOf(currentVertex) + String.valueOf(neighbour);
                    if (visitedEdges.contains(edge))
                        continue;
                    int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbour);
                    // If we find new shortest path, update in distance table
                    if (distance < distanceTable.get(neighbour).getDistance()) {
                        distanceTable.get(neighbour).setDistance(distance);
                        distanceTable.get(neighbour).setLastVertex(currentVertex);
                    }
                }
            }
        }
        // Add all the vertices to the queue one last time to check for negative cycles
        for (int i = 0; i < graph.getNumVertices(); i++)
            queue.add(i);
        // Relaxing process one last time to check for negative cycles
        while (!queue.isEmpty()) {
            int currentVertex = queue.pollFirst();
            for (int neighbour : graph.getAdjacentVertices(currentVertex)) {
                int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbour);
                if (distance < distanceTable.get(neighbour).getDistance()) {
                    throw new IllegalArgumentException("There graph has a negative cycle!");
                }
            }
        }
        return distanceTable;
    }

    public void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfoBF> distanceTable = buildDistanceTable(graph, source);
        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1)
            System.out.println("There is no path from source " + source + " to destination " + destination);
        else {
            System.out.println("Shortest path = " + source);
            while (!stack.isEmpty())
                System.out.print(" -> " + stack.pop());
        }
    }
}
