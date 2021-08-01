package RandomProblems;

import java.util.*;

class MergeIntervals {
    static class Interval {
        int a, b;
        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            return x[0] > y[0] ? 1 : -1;
        });

        Stack<Interval> stack = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if (stack.isEmpty())
                stack.push(new Interval(intervals[i][0], intervals[i][1]));
            else {
                Interval curr = stack.peek();
                if (intervals[i][0] <= curr.b) {
                    stack.pop();
                    stack.push(new Interval(curr.a, Math.max(curr.b, intervals[i][1])));
                }
                else
                    stack.push(new Interval(intervals[i][0], intervals[i][1]));
            }
        }

        int[][] answer = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            Interval interval = stack.pop();
            answer[i][0] = interval.a;
            answer[i][1] = interval.b;
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
