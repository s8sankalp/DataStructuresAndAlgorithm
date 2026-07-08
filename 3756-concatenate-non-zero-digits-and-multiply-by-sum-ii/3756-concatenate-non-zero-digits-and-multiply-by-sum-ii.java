class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {

        int mod = 1000000007;
        int n = s.length();

        int prefix[] = new int[n + 1];      // Sum of digits
        int cnt[] = new int[n + 1];         // Count of non-zero digits
        long x[] = new long[n + 1];         // Number formed by non-zero digits

        long pow10[] = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }

        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            prefix[i + 1] = prefix[i] + digit;

            if (digit != 0) {
                x[i + 1] = (x[i] * 10 + digit) % mod;
                cnt[i + 1] = cnt[i] + 1;
            } else {
                x[i + 1] = x[i];
                cnt[i + 1] = cnt[i];
            }
        }

        int ans[] = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1] + 1;

            long sum = prefix[r] - prefix[l];

            int length = cnt[r] - cnt[l];

            long num = (x[r] - (x[l] * pow10[length]) % mod + mod) % mod;

            ans[i] = (int) ((num * sum) % mod);
        }

        return ans;
    }
}