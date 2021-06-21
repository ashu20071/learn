package RandomProblems;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {
    static int postfixExpression(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (String c : exp.split(" ")) {
            if (!c.equals("+") && !c.equals("-") && !c.equals("*"))
                stack.push(Integer.parseInt(c));
            else {
                int x = stack.pop();
                int y = stack.pop();
                switch (c) {
                    case "+" -> stack.push(y + x);
                    case "-" -> stack.push(y - x);
                    case "*" -> stack.push(y * x);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        int val = postfixExpression(exp);
        System.out.println(val);
    }
}
