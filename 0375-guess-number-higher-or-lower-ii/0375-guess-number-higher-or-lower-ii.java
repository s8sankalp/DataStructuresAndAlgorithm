class Solution {
    int[][] dp;

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return solve(1, n);
    }

    private int solve(int left, int right) {
        if (left >= right)
            return 0;

        if (dp[left][right] != 0)
            return dp[left][right];

        int ans = Integer.MAX_VALUE;

        for (int guess = left; guess <= right; guess++) {
            int cost = guess + Math.max(
                solve(left, guess - 1),
                solve(guess + 1, right)
            );

            ans = Math.min(ans, cost);
        }

        return dp[left][right] = ans;
    }
}