class Solution {
    private static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid.append((char) ('a' + i));
            }
            half[i] = freq[i] / 2;
        }

        if (countWays(half) < k) return "";

        int len = 0;
        for (int x : half) len += x;

        StringBuilder left = new StringBuilder();

        while (left.length() < len) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();
        return left.toString() + mid.toString() + right.toString();
    }

    private long countWays(int[] cnt) {
        int total = 0;
        for (int x : cnt) total += x;

        long ans = 1;
        int rem = total;

        for (int x : cnt) {
            ans *= nCk(rem, x);
            if (ans >= LIMIT) return LIMIT;
            rem -= x;
        }

        return ans;
    }

    private long nCk(int n, int k) {
        if (k > n) return 0;

        k = Math.min(k, n - k);
        long ans = 1;

        for (int i = 1; i <= k; i++) {
            ans = ans * (n - i + 1) / i;
            if (ans >= LIMIT) return LIMIT;
        }

        return ans;
    }
}