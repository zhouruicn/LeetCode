class Solution {

    public int fib(int n) {
        int first = 0;
        int second = 1;
        if (n == 0) {
            return first;
        }
        if (n == 1) {
            return second;
        }
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = solution.fib(4);
        System.out.println(n);
    }

}
