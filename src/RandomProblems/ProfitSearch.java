package RandomProblems;

import java.util.*;

class ProfitSearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        int rank[] = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = sc.nextInt();
        }

        int res = profitSearch(n, p, rank);

        System.out.println(res);
    }

    static int min(int[] ranks) {
        int minimum = Integer.MAX_VALUE;
        for (int rank : ranks)
            minimum = Math.min(minimum, rank);
        return minimum;
    }

    static float maxPossiblePizzas(int minutes, int[] ranks) {
        float maxPizzas = 0;
        for (int rank : ranks)
            maxPizzas += (Math.sqrt(minutes / rank));
        return maxPizzas;
    }

    static int profitSearch(int n, int p, int rank[]) {
        int start = 1, end = min(rank) * p * p;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (maxPossiblePizzas(mid, rank) >= p)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return end + 1;
    }
}


