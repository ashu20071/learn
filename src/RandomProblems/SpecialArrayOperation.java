package RandomProblems;
import java.util.*;

class SpecialArrayOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() , q = sc.nextInt();

        int[] arr = new int[n], queries = new int[q];
        for(int i = 0 ; i < n; i ++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < q; i++)
            queries[i] = sc.nextInt();
        long[] result = specialArrayOperation(n, q, arr, queries);
        for (long l : result)
            System.out.println(l);
        sc.close();
    }



    static long[] specialArrayOperation(int n, int q, int[] arr, int[] queries) {
        long[] repository = new long[n + 1];
        long[] results = new long[q];
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < q; i++) {
            if (repository[queries[i]] != 0)
                results[i] = repository[queries[i]];
            else {
                max_heap.clear();
                for (int num : arr) {
                    min_heap.add(num);
                    max_heap.add(num);
                }
                for (int j = 0; j < queries[i]; j++) {
                    int min = min_heap.poll(), max = max_heap.poll();
                    min_heap.remove(max);
                    max_heap.remove(min);
                    min_heap.add(max - min);
                    max_heap.add(max - min);
                }
                long sum = 0;
                while (!min_heap.isEmpty())
                    sum += min_heap.poll();
                repository[queries[i]] = sum;
                results[i] = sum;
            }
        }
        return results;
    }
}
