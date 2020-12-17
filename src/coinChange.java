import java.util.Arrays;

public class coinChange {
    static long count(int[] S, int m, int n) {
        /* first solution using recursion (overlapping sub-problems)
        //if n is 0, only 1 solution; take no coins
        if (n == 0)
            return 1;

        //if n is negative, there is no solution
        if (n < 0)
            return 0;

        //if n > 0 and no coins available; there is no solution
        if (n > 0 && m == 0)
            return 0;

        return count(S, m-1, n) + count(S, m, n-S[m-1]);
    }*/

        //optimal solution using dynamic programming (optimal substructure)

        long[] table = new long[n+1];
        Arrays.fill(table, 0);          //initialize all table values as 0

        //Base case (if given value is 0)
        table[0] = 1;

        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }

    public static void main(String[] args) {
        int[] S = {1,2,3};
        int m = S.length;
        System.out.println("Number of ways = "+count(S, m,4));
    }
}
