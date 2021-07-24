package RandomProblems;

import java.util.*;

class LargestSubArraySumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        ArrayList<Integer> res = largestSubArraySumZero(n, arr);
        for (int j : res)
            System.out.print(j + " ");
    }

    static ArrayList<Integer> largestSubArraySumZero(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max_length = 0, curr_sum = 0, index = 0;
        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];
            if (arr[i] == 0 && max_length == 0) {
                max_length = 1;
                index = i;
            }
            else if (curr_sum == 0) {
                if (max_length < i + 1) {
                    max_length = i + 1;
                    index = i;
                }
            }
            else if (map.containsKey(curr_sum)) {
                if (max_length < i - map.get(curr_sum)) {
                    max_length = i - map.get(curr_sum);
                    index = i;
                }
            }
            else
                map.put(curr_sum, i);
        }
        if (max_length == 0) {
            list.add(-1);
            return list;
        }
        for (int i = index - max_length + 1; i <= index; i++)
            list.add(arr[i]);
        return list;
    }
}
