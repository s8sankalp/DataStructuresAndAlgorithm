class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        java.util.TreeMap<Integer, Integer> lo = new java.util.TreeMap<>();
        java.util.TreeMap<Integer, Integer> hi = new java.util.TreeMap<>();
        long s1 = 0, s2 = 0;
        int c1 = 0, c2 = 0;

        for (int i = 0; i < n; i++) {
            int v = nums[i];

            if (lo.isEmpty() || v <= lo.lastKey()) {
                lo.merge(v, 1, Integer::sum);
                s1 += v;
                c1++;
            } else {
                hi.merge(v, 1, Integer::sum);
                s2 += v;
                c2++;
            }

            if (i >= x) {
                int z = nums[i - x];

                if (lo.containsKey(z)) {
                    lo.merge(z, -1, Integer::sum);
                    if (lo.get(z) == 0) lo.remove(z);
                    s1 -= z;
                    c1--;
                } else {
                    hi.merge(z, -1, Integer::sum);
                    if (hi.get(z) == 0) hi.remove(z);
                    s2 -= z;
                    c2--;
                }
            }

            while (c1 > (x + 1) / 2) {
                int z = lo.lastKey();
                lo.merge(z, -1, Integer::sum);
                if (lo.get(z) == 0) lo.remove(z);
                s1 -= z;
                c1--;
                hi.merge(z, 1, Integer::sum);
                s2 += z;
                c2++;
            }

            while (c1 < (x + 1) / 2 && !hi.isEmpty()) {
                int z = hi.firstKey();
                hi.merge(z, -1, Integer::sum);
                if (hi.get(z) == 0) hi.remove(z);
                s2 -= z;
                c2--;
                lo.merge(z, 1, Integer::sum);
                s1 += z;
                c1++;
            }

            if (i >= x - 1) {
                int m = lo.lastKey();
                cost[i - x + 1] = (long) m * c1 - s1 + s2 - (long) m * c2;
            }
        }

        long inf = Long.MAX_VALUE / 2;
        long[][] dp = new long[k + 1][n + 1];

        for (long[] d : dp) {
            java.util.Arrays.fill(d, inf);
        }

        dp[0][0] = 0;

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int j = 1; j <= k; j++) {
            for (int i = j * x; i <= n; i++) {
                dp[j][i] = Math.min(dp[j][i - 1],
                    dp[j - 1][i - x] + cost[i - x]);
            }
        }

        return dp[k][n];
    }
}