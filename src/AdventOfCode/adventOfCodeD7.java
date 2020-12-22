package AdventOfCode;

import java.util.*;

public class adventOfCodeD7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();
        String s="";    int sum = 0;
        queue.add("shiny gold bags ");
        numbers.add(1);
        while (!(s = scanner.nextLine()).equals("done")){
            strings.add(s);
        }

        while (!queue.isEmpty()){
            for (String string : strings) {
                String[] str = string.split("contain");
                assert queue.peek() != null;
                if (str[0].contains(queue.peek())) {
                    List<String> set;
                    set = Arrays.asList(str[1].split(","));
                    System.out.println("Set=" + set);
                    for (String s2 : set) {
                        if (!s2.contains("no other bag")) {
                            s2 = s2.trim();
                            int n = Integer.parseInt(String.valueOf(s2.charAt(0)));
                            numbers.add(n);
                            sum += n*numbers.peek();
                            queue.add(s2.substring(2, s2.length() - 1));
                        }
                    }
                    System.out.println("Queue="+numbers);
                    System.out.println("sum="+sum);
                }
            }
            queue.poll();
            Stack<Integer> stack = new Stack<>();

            numbers.poll();
        }

        System.out.println("Answer="+sum);
    }
}
