class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i] + (dp[j - 1] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
