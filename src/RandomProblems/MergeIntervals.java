package RandomProblems;

import java.util.*;

class MergeIntervals {
    public int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] > y[0] ? 1 : -1);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int int_end = -1, length = intervals.length;
        int merged_interval_start = -1, merged_interval_end;

        for (int i = 0; i < length; i++) {
            int int_start = intervals[i][0];
            if (int_start <= int_end) {
                if (merged_interval_start == -1)
                    merged_interval_start = i - 1;
            }
            else {
                if (merged_interval_start != -1) {
                    merged_interval_end = i - 1;
                    list.add(new ArrayList<>(Arrays.asList(intervals[merged_interval_start][0], intervals[merged_interval_end][1])));
                    merged_interval_start = -1;
                }
                else if (i != 0) {
                    list.add(new ArrayList<>(Arrays.asList(intervals[i-1][0], intervals[i-1][1])));
                }
            }
            int_end = intervals[i][1];
        }

        if (merged_interval_start == -1) {
            list.add(new ArrayList<>(Arrays.asList(intervals[length-1][0], intervals[length-1][1])));
        }
        else {
            list.add(new ArrayList<>(Arrays.asList(intervals[merged_interval_start][0], intervals[length-1][1])));
        }

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 2; j++)
                answer[i][j] = list.get(i).get(j);
        }
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int[][] results = new MergeIntervals().mergeIntervals(nums);

        for (int[] result : results) {
            System.out.printf("%d %d\n", result[0], result[1]);
        }
    }
}

