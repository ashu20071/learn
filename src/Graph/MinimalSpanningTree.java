package Graph;

import java.util.*;

public class MinimalSpanningTree {
    // Prim's minimal spanning tree algorithm
    public void primSpanningTree(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo o1, VertexInfo o2) {
                return Integer.compare(o1.getDistance(), o2.getDistance());
            }
        });
        // Initialize distance table with default values
        for (int i = 0; i < graph.getNumVertices(); i++)
            distanceTable.put(i, new DistanceInfo());
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);
        // Add source vertex to vertex info map
        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        VertexInfo sourceVertex = new VertexInfo(source, 0);
        vertexInfoMap.put(source, sourceVertex);
        queue.add(sourceVertex);
        // Initialize spanning tree set and visited edges set
        Set<String> spanningTree = new HashSet<>();
        Set<Integer> visitedVertices = new HashSet<>();
        // Iterate through the queue of vertices and explore each neighbour
        while (!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();
            // Check if the vertex is already visited
            if (visitedVertices.contains(currentVertex))
                continue;
            visitedVertices.add(currentVertex);
            // Check if current vertex is not the source; else it won't have an edge yet
            if (currentVertex != source) {
                String edge = currentVertex + String.valueOf(distanceTable.get(currentVertex).getLastVertex());
                spanningTree.add(edge);
            }
            // Iterate through the neighbours of current vertex
            for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
                int distance = graph.getWeightedEdge(currentVertex, neighbour);
                // Update distance table if new distance is shorter than existing one
                if (distance < distanceTable.get(neighbour).getDistance()) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);
                    // Set new calculated values for neighbour in vertex info map
                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null)
                        queue.remove(neighbourVertexInfo);
                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                    queue.add(neighbourVertexInfo);
                }
            }
        }
        // Print the spanning tree
        System.out.print("Minimal spanning tree for the given graph = ");
        for (String edge : spanningTree)
            System.out.print(edge+" ");
    }

    // Kruskal's minimal spanning tree algorithm
    public void kruskalSpanningTree(Graph graph) {
        // Create a priority queue to store edges based on their weight
        PriorityQueue<EdgeInfo> queue = new PriorityQueue<>(new Comparator<EdgeInfo>() {
            @Override
            public int compare(EdgeInfo o1, EdgeInfo o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        // Add all edges in graph to the priority queue
        for (int i = 0; i < graph.getNumVertices(); i++) {
            for (int neighbour : graph.getAdjacentVertices(i))
                queue.add(new EdgeInfo(i, neighbour, graph.getWeightedEdge(i, neighbour)));
        }
        // Create set for visited edges and spanning tree edges
        Set<Integer> visitedVertices = new HashSet<>();
        Set<EdgeInfo> spanningTree = new HashSet<>();
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i < graph.getNumVertices(); i++)
            edgeMap.put(i, new HashSet<>());
        // Iterate through the queue
        while (!queue.isEmpty()) {
            EdgeInfo currentEdge = queue.poll();
            // Add current edge to map and check if it has cycle
            // If yes remove that edge and process other edges in queue
            edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
            if (hasCycle(edgeMap)) {
                edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
                continue;
            }
            spanningTree.add(currentEdge);
            // Add both vertices to the visited vertices list to avoid repeat processing
            visitedVertices.add(currentEdge.getVertex1());
            visitedVertices.add(currentEdge.getVertex2());
        }
        // Check if all vertices are covered in the graph
        if (visitedVertices.size() == graph.getNumVertices())
            System.out.println("Minimal spanning tree for given graph = "+spanningTree);
        else
            System.out.println("Spanning tree not possible for given graph!");
    }

    // Method to detect cycle in given edgeMap
    private boolean hasCycle(Map<Integer, Set<Integer>> edgeMap) {
        for (Integer sourceVertex : edgeMap.keySet()) {
            Set<Integer> visitedVertices = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(sourceVertex);
            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                if (visitedVertices.contains(currentVertex))
                    return true;
                visitedVertices.add(currentVertex);
                queue.addAll(edgeMap.get(currentVertex));
            }
        }
        return false;
    }
}
