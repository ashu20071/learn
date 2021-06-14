package RandomProblems;

public class EulerTotient {
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int phi(int n) {
        int result = 1;
        for (int i = 2; i < n; i++)
            if (gcd(i, n) == 1)
                result++;
        return result;
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 10; n++)
            System.out.println("phi(" + n + ") = " + phi(n));
    }
}