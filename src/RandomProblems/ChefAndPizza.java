package RandomProblems;

import java.util.Scanner;

class ChefAndPizza {
    public int minRank(int[] ranks) {
        int min = Integer.MAX_VALUE;
        for (int rank : ranks)
            min = Math.min(min, rank);
        return min;
    }

    public int maxPizzas(int time, int[] rank) {
        int max = 0;
        for (int chef : rank)
            max += pizzasMadeByChef(chef, time);
        return max;
    }

    public int pizzasMadeByChef(int rank, int time) {
        double a = rank, b = -rank, c = rank - time;
        double sqrt = Math.sqrt(b * b - 4 * a * c);
        double root1 = (-b - sqrt) / (2*a);
        double root2 = (-b + sqrt) / (2*a);
        return (int) Math.max(root1, root2);
    }

    public int chefAndPizza(int p, int[] rank) {
        int start = 0, end = minRank(rank) * (p*p - p + 1);
        while (start <= end) {
            int mid = (start + end) / 2;
            if (maxPizzas(mid, rank) >= p)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return end + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        assert(t <= 1000 && t >= 1);
        for(int T = 0 ; T < t ; T++) {
            int p = scanner.nextInt();
            int n = scanner.nextInt();
            assert(p <= 1000 && p >= 1);
            assert(n <= 100 && n >= 1);
            int[] rank = new int[n];
            for(int i = 0; i < n ; i++) {
                rank[i] = scanner.nextInt();
                assert(rank[i] <= 10 && rank[i] >= 1);
            }
            int result = new ChefAndPizza().chefAndPizza(p, rank);
            System.out.println(result);
        }
    }
}