package RandomProblems;

import java.util.*;

class LongestSubstringWithAtMostKDistinctCharacter {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int window_start = 0, window_end;
        int max_length = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (window_end = 0; window_end < s.length(); window_end++) {
            map.put(s.charAt(window_end), map.getOrDefault(s.charAt(window_end), 0) + 1);
            if (map.size() <= k)
                max_length = Math.max(max_length, window_end - window_start + 1);
            else {
                while (map.size() > k) {
                    char curr = s.charAt(window_start);
                    map.put(curr, map.get(curr) - 1);
                    if (map.get(curr) == 0)
                        map.remove(curr);
                    window_start++;
                }
            }
        }

        return max_length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();

        int result = new LongestSubstringWithAtMostKDistinctCharacter().lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(result);
    }
}

