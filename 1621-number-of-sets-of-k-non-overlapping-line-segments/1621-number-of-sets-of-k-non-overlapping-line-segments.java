class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;

        int N = n + k - 1;
        int R = 2 * k;

        long[] fact = new long[N + 1];
        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long numerator = fact[N];
        long denominator1 = power(fact[R], MOD - 2, MOD);
        long denominator2 = power(fact[N - R], MOD - 2, MOD);

        return (int) (((numerator * denominator1) % MOD * denominator2) % MOD);
    }

    private long power(long a, long b, long MOD) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}