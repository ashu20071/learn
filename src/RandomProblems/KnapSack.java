package RandomProblems;

public class KnapSack {
    // Dynamic approach using tabulation
    public int knapSackTabulation(int W, int[] wt, int[] val, int N) {
        int[][] k = new int[N + 1][W + 1];
        for (int n = 0; n <= N; n++) {
            for (int w = 0; w <= W; w++) {
                if (n == 0 || w == 0)
                    k[n][w] = 0;
                else if (wt[n - 1] > w)
                    k[n][w] = k[n - 1][w];
                else
                    k[n][w] = Math.max(val[n - 1] + k[n - 1][w - wt[n - 1]], k[n - 1][w]);
            }
        }
        return k[N][W];
    }

    // Dynamic approach using memoization
    public int knapSackMemoization(int W, int[] wt, int[] val, int N) {
        int[][] k = new int[N + 1][W + 1];
        // Initializing table k with -1 values
        for (int n = 0; n <= N; n++) {
            for (int w = 0; w <= W; w++) {
                k[n][w] = -1;
            }
        }
        return knapSackMUtil(W, wt, val, N, k);
    }
    // Utility function for memoization method
    private int knapSackMUtil(int w, int[] wt, int[] val, int n, int[][] k) {
        if (n == 0 || w == 0)
            return 0;
        if (k[n][w] != -1)
            return k[n][w];
        if (wt[n - 1] > w)
            k[n][w] = knapSackMUtil(w, wt, val, n - 1, k);
        else
            k[n][w] = Math.max(val[n - 1] + knapSackMUtil(w - wt[n - 1], wt, val, n - 1, k), knapSackMUtil(w, wt, val, n - 1, k));
        return k[n][w];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        KnapSack knapSack = new KnapSack();
        System.out.println(knapSack.knapSackMemoization(50, wt, val, val.length));
    }
}
