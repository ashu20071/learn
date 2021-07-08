package RandomProblems;

public class SpiralOrder {
    public static void main(String[] args) {
        int n = 3;
        int[][] result = spiralMatrixII(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] spiralMatrixII(int n) {
        int[][] matrix = new int[n][n];
        int i, k = 0, l = 0, m = n;
        int counter = 1;
        while (k < m && l < n) {
            for (i = l; i < n; i++)
                matrix[k][i] = counter++;
            k++;
            for (i = k; i < m; i++)
                matrix[i][n-1] = counter++;
            n--;
            if (k < m) {
                for (i = n-1; i >= l; i--)
                    matrix[m-1][i] = counter++;
                m--;
            }
            if (l < n) {
                for (i = m-1; i >= k; i--)
                    matrix[i][l] = counter++;
                l++;
            }
        }
        return matrix;
    }
}
