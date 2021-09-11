package RandomProblems;

import java.util.*;

class StringWithinString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first_string = sc.next();
        String second_string = sc.next();
        int answer = stringWithinString(first_string, second_string);
        System.out.println(answer);
        sc.close();
    }

    static int stringWithinString(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int min_windowSize = Integer.MAX_VALUE, window_start = 0, window_end = 0, num_charsMatched = 0;

        for (; window_end < s.length(); window_end++) {
            char ch = s.charAt(window_end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    num_charsMatched++;
            }

            while (num_charsMatched == map.size()) {
                char aChar = s.charAt(window_start);
                min_windowSize = Math.min(min_windowSize, window_end - window_start + 1);
                if (map.containsKey(aChar)) {
                    if (map.get(aChar) == 0)
                        num_charsMatched--;
                    map.put(aChar, map.get(aChar) + 1);
                }
                window_start++;
            }
        }

        return (min_windowSize == Integer.MAX_VALUE) ? -1 : min_windowSize;
    }
}
