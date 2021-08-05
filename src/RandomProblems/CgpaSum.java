package RandomProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class CgpaSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> subjects = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            subjects.add(sc.nextInt());

        ArrayList<ArrayList<Integer>> students = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> data = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                int x = sc.nextInt();
                data.add(x);
            }
            students.add(data);
        }

        long result = cgpaSum(n, subjects, students);

        System.out.println(result);
    }

    static int calcCgpa(ArrayList<Integer> studentGrades, ArrayList<Integer> subjects) {
        int totalCredit = 0, totalGrade = 0;
        for (int i = 1; i <= 5; i++) {
            totalCredit += subjects.get(i-1);
            totalGrade += (subjects.get(i-1) * studentGrades.get(i));
        }
        return totalGrade / totalCredit;
    }

    static long cgpaSum(int n, ArrayList<Integer> subjects, ArrayList<ArrayList<Integer>> students) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> cgpa = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int curr_cgpa = calcCgpa(students.get(i), subjects);
            map.put(curr_cgpa, map.getOrDefault(curr_cgpa, 0) + 1);
            cgpa.add(curr_cgpa);
        }
        long totalPairs = 0;
        for (int i = 0; i < n; i++) {
            int curr_cgpa = cgpa.get(i);
            if (map.containsKey(10 - curr_cgpa)) {
                totalPairs += ((long) map.get(10 - curr_cgpa));
                if (10 - curr_cgpa == curr_cgpa)
                    totalPairs--;
            }
        }
        return totalPairs / 2;
    }
}
