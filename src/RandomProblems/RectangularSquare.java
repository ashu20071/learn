package RandomProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class RectangularSquare {
    static ArrayList<Long> rectangularSquare(int n, long[][] grid, int q, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here
        ArrayList<Long> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int a = queries.get(i).get(0);
            int b = queries.get(i).get(1);
            int c = queries.get(i).get(2);
            int d = queries.get(i).get(3);
            long sum = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if ((Math.abs(x-a) <= c) && (Math.abs(y-b) <= d)) {
                        sum += grid[x][y];
                    }
                }
            }
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] grid = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextLong();
            }
        }

        int q = sc.nextInt();
        ArrayList<ArrayList<Integer>> queries = new ArrayList<ArrayList<Integer>>(q);

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int l = sc.nextInt();
            int b = sc.nextInt();

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(x);
            temp.add(y);
            temp.add(l);
            temp.add(b);
            queries.add(temp);
        }
        ArrayList<Long> ans = rectangularSquare(n, grid, q, queries);
        for (long res : ans) {
            System.out.println(res);
        }
    }
}
