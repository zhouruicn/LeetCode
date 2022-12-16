public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                dp[0][j] = 1;
            }

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j])
                        + (obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
            }
        }

        return obstacleGrid[m - 1][n - 1] == 1 ? 0 : dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] x = new int[1][2];
        x[0] = new int[] { 1, 0 };
        Solution solution = new Solution();
        int path = solution.uniquePathsWithObstacles(x);
        System.out.println(path);
    }
}