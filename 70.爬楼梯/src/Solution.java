class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;

        if (n == 1) {
            return first;
        }

        if (n == 2) {
            return second;
        }
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = solution.climbStairs(4);
        System.out.println(n);
    }
}