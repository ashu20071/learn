package RandomProblems;

import java.util.*;

class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pattern = new HashMap<>();
        List<Integer> anagrams = new ArrayList<>();
        // Adding pattern characters in HashMap
        for (char pattern_char : p.toCharArray())
            pattern.put(pattern_char, pattern.getOrDefault(pattern_char, 0) + 1);
        int num_chr_matched = 0, window_size = 0;
        // Iterating through the main string while maintaining sliding window
        for (int i = 0; i < s.length(); i++) {
            char string_char = s.charAt(i);
            if (pattern.containsKey(string_char)) {
                pattern.put(string_char, pattern.get(string_char)-1);
                if (pattern.get(string_char) == 0)
                    num_chr_matched++;
            }
            window_size++;
            if (num_chr_matched == pattern.size())
                anagrams.add(i-window_size+1);
            if (window_size >= p.length()) {
                char window_left = s.charAt(i-window_size+1);
                if (pattern.containsKey(window_left)) {
                    if (pattern.get(window_left) == 0)
                        num_chr_matched--;
                    pattern.put(window_left, pattern.get(window_left)+1);
                }
                window_size--;
            }
        }
        return anagrams;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[2];
        input = scanner.nextLine().split(" ");
        String s = input[0];
        String p = input[1];
        scanner.close();

        List<Integer> result = new FindAllAnagramsInAString().findAnagrams(s,p);
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.printf("%d ", integer);
        }
    }
}
