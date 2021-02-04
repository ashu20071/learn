package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * This class holds distance info of any vertex in an Unweighted Graph.
 * The distance specified is the distance from the source vertex.
 * Last vertex is the last vertex seen in the path from source to this vertex.
 */

class DistanceInfoUW {
    private int distance;
    private int lastVertex;

    public DistanceInfoUW() {
        distance = -1;
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

// Shortest path in an unweighted graph; Weight of all edges = 1
public class ShortestPath {
    public Map<Integer, DistanceInfoUW> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfoUW> distanceTable = new HashMap<>();
        for (int i = 0; i < graph.getNumVertices(); i++)
            distanceTable.put(i, new DistanceInfoUW());

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentVertex = queue.pollFirst();
            for (int i : graph.getAdjacentVertices(currentVertex)) {
                int currentDistance = distanceTable.get(i).getDistance();
                if (currentDistance == -1) {
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);
                    // Enqueue neighbour only if it has adjacent vertices
                    if (!graph.getAdjacentVertices(i).isEmpty())
                        queue.add(i);
                }
            }
        }
        return distanceTable;
    }

    public void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfoUW> distanceTable = buildDistanceTable(graph, source);
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
