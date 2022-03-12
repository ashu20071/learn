package RandomProblems;

import java.util.Scanner;

public class SwapAllOddAndEvenBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        long result = new SwapAllOddAndEvenBits().swapBits(n);
        System.out.println(result);
    }

    public long swapBits(long n) {
        return ((n & 0x5555555) << 1) | ((n & 0xAAAAAAAA) >> 1);
    }
}
