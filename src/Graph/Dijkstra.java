package Graph;

import java.util.*;

/**
 * This class holds distance info of any vertex in an Weighted Graph.
 * The distance specified is the distance from the source vertex.
 * Last vertex is the last vertex seen in the path from source to this vertex.
 */

class DistanceInfo {
    private int distance;
    private int lastVertex;

    public DistanceInfo() {
        distance = Integer.MAX_VALUE;
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


public class Dijkstra {
    public Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return Integer.compare(v1.getDistance(), v2.getDistance());
            }
        });
        for (int i = 0; i < graph.getNumVertices(); i++)
            distanceTable.put(i, new DistanceInfo());
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);
        // Add source vertex info in vertexInfo map and add it to the queue
        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        vertexInfoMap.put(source, sourceVertexInfo);
        queue.add(sourceVertexInfo);

        while (!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();
            for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
                // Get the new distance accounting for the weighted edge
                int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbour);
                // If we find a new shortest path to the neighbour, update distance and last vertex in table
                if (distance < distanceTable.get(neighbour).getDistance()) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);
                    // We've found a new short path to the neighbour so remove the the old node from the queue
                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null)
                        queue.remove(neighbourVertexInfo);
                    // Add the updated neighbour vertex info to the map and queue
                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                }
            }
        }
        return distanceTable;
    }

    public void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);
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
            System.out.print("Shortest path = " + source);
            while (!stack.isEmpty())
                System.out.print(" -> " + stack.pop());
        }
    }
}
