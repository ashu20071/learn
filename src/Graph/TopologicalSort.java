package Graph;

import java.util.*;

public class TopologicalSort {
    public List<Integer> sort(Graph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);
            if (indegree == 0)
                queue.add(vertex);
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int adjacentVertex : adjacentVertices) {
                int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
                indegreeMap.remove(adjacentVertex);
                indegreeMap.put(adjacentVertex, updatedIndegree);
                if (updatedIndegree == 0)
                    queue.add(adjacentVertex);
            }
        }

        if (sortedList.size() != graph.getNumVertices())
            throw new RuntimeException("The Graph has a cycle");

        return sortedList;
    }
}
