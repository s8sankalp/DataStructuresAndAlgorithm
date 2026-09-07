class Solution {
    public int distinctSubseqII(String s) {

        final long MOD = 1_000_000_007;
        long[] dp = new long[26];

        for (char ch : s.toCharArray()) {

            int idx = ch - 'a';

            long total = 0;

            
            for (int i = 0; i < 26; i++) {
                total = (total + dp[i]) % MOD;
            }

            
            dp[idx] = (total + 1) % MOD;
        }

        long ans = 0;

        for (long count : dp) {
            ans = (ans + count) % MOD;
        }

        return (int) ans;
    }
}