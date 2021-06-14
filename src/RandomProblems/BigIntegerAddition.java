package RandomProblems;

import java.util.Scanner;

public class BigIntegerAddition {
    static String bigIntegerAddition(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int carry = 0;
        int num;
        char[] sum = new char[num1.length()];
        for (int i = 1; i <= num1.length(); i++) {
            int numericValue = Character.getNumericValue(num1.charAt(num1.length() - i));
            if (i > num2.length())
                num = numericValue;
            else
                num = numericValue + Character.getNumericValue(num2.charAt(num2.length() - i));
            int sum_temp = (num + carry) % 10;
            sum[i-1] = Character.forDigit(sum_temp, 10);
            carry = (num + carry) / 10;
        }
        StringBuilder sum_new = new StringBuilder(String.valueOf(sum));
        if (carry != 0)
            sum_new.append(Character.forDigit(carry, 10));
        return sum_new.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        String ans = bigIntegerAddition(num1, num2);
        System.out.println(ans);
    }
}
