package DynamicProgramming;

public class MinimumSubsetSumDiff {
    public static int minDifference(int[] arr, int n) {
        int range = 0;
        for (int value : arr)
            range += value;
        boolean[][] k = new boolean[n + 1][range + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= range; j++) {
                if (i == 0) {
                    k[i][j] = j == 0;
                }
                else if (arr[i-1] <= j)
                    k[i][j] = k[i-1][j - arr[i-1]] || k[i-1][j];
                else if (arr[i-1] > j)
                    k[i][j] = k[i-1][j];
            }
        }
        int[] a = new int[(range / 2) + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (k[n][i])
                a[i] = i;
            min = Math.min(min, range - (2 * a[i]));
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(minDifference(arr, arr.length));
    }
}
