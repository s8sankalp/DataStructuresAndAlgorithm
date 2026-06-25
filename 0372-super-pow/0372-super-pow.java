class Solution {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return helper(a % MOD, b, b.length - 1);
    }

    private int helper(int a, int[] b, int idx) {
        if (idx < 0) return 1;

        int lastDigit = b[idx];

        int part1 = modPow(a, lastDigit);
        int part2 = modPow(helper(a, b, idx - 1), 10);

        return (part1 * part2) % MOD;
    }

    private int modPow(int x, int n) {
        int res = 1;

        for (int i = 0; i < n; i++) {
            res = (res * x) % MOD;
        }

        return res;
    }
}