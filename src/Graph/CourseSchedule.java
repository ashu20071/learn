package Graph;

import java.util.*;

/**
 * Class to create a schedule from given list of courses and pre-requisites.
 * There can be many possible schedules, this will return one of those valid schedules.
 * We use topological sort to sort the courses (vertices) so that pre-requisites always come before the required course.
 */

public class CourseSchedule {
    public List<String> courseSchedule(List<String> courseList, Map<String, List<String>> preReq) {
        Graph schedule = new AdjacencyMatrixGraph(courseList.size(), Graph.GraphType.DIRECTED);
        // Create helper maps to hold courses indexed with ids
        Map<String, Integer> courseIdMap = new HashMap<>();
        Map<Integer, String> idCourseMap = new HashMap<>();
        // Populate the helper maps with courses, giving them vertex ids
        for (int i = 0; i < courseList.size(); i++) {
            courseIdMap.put(courseList.get(i), i);
            idCourseMap.put(i, courseList.get(i));
        }
        // Iterate through the preReq map to populate the graph
        for (Map.Entry<String, List<String>> entry : preReq.entrySet()) {
            // Add edge for every pre-requisite leading to the designated course
            for (String course : entry.getValue())
                schedule.addEdge(courseIdMap.get(entry.getKey()), courseIdMap.get(course));
        }
        // Call topological function to sort the course list
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> courseIdList = topologicalSort.sort(schedule);
        List<String> courseSchedule = new ArrayList<>();
        // Convert integer list to final courseSchedule string list
        for (Integer course : courseIdList)
            courseSchedule.add(idCourseMap.get(course));
        return courseSchedule;
    }

    public static void main(String[] args) {
        List<String> courseList = new ArrayList<>(Arrays.asList("CS 101", "CS 102", "CS 103", "CS 104", "CS 105",
                "CS 106", "CS 107"));
        Map<String, List<String>> preReq = new HashMap<>();
        preReq.put("CS 101", new ArrayList<>(Arrays.asList("CS 102", "CS 103", "CS 105")));
        preReq.put("CS 104", new ArrayList<>(Collections.singletonList("CS 105")));
        preReq.put("CS 105", new ArrayList<>(Collections.singletonList("CS 107")));
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.courseSchedule(courseList, preReq));
    }
}
