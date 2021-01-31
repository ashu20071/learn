package Graph;

import java.util.*;

public class TopologicalSort {
    public List<Integer> sort(Graph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> inDegreeMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int inDegree = graph.getInDegree(vertex);
            inDegreeMap.put(vertex, inDegree);
            if (inDegree == 0)
                queue.add(vertex);
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.pollLast();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int adjacentVertex : adjacentVertices) {
                int updatedInDegree = inDegreeMap.get(adjacentVertex) - 1;
                inDegreeMap.remove(adjacentVertex);
                inDegreeMap.put(adjacentVertex, updatedInDegree);
                if (updatedInDegree == 0)
                    queue.add(adjacentVertex);
            }
        }

        if (sortedList.size() != graph.getNumVertices())
            throw new RuntimeException("The Graph has a cycle");

        return sortedList;
    }
}
