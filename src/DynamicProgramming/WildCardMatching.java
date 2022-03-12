package DynamicProgramming;

public class WildCardMatching {
    public static boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        boolean dp[][] = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 0) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }

                }
            }
        }

        return dp[slen][plen];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
    }
}
