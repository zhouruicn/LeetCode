class Solution {
    // 2 <= n <= 58
    public int integerBreak(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 3;
        int[] dp = new int[max(n + 1, 4)];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = max(dp[i], dp[i - j] * j);
            }
        }
        return dp[n];
    }

    private int max(int first, int second) {
        return first < second ? second : first;
    }

    public static void main(String[] args) {

    }

}