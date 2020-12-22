package RandomProblems;

import java.io.IOException;
import java.util.*;

public class SkipRepeat {
    List<Integer>  findNumbers(Integer[] arr) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr);
        List<Integer> list = Arrays.asList(arr);
        for (int i=1; i<arr.length; i++) {
            if (arr[i].equals(arr[i - 1])) {
                answer.add(arr[i]);
            }
        }
        for (int i=0; i<arr.length; i++) {
            if (!list.contains(i+1)) {
                answer.add(i+1);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        SkipRepeat ans = new SkipRepeat();
        System.out.println("Answer="+ans.findNumbers(arr));
    }
}
