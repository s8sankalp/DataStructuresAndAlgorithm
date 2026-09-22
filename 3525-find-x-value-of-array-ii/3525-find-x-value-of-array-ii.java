import java.util.*;

class SegmentTree {
    int k, n;
    int[][] t;

    SegmentTree(int[] a, int k) {
        this.k = k;
        n = a.length;
        t = new int[4 * n][k + 1];
        build(a, 1, 0, n - 1);
    }

    void leaf(int p, int v) {
        Arrays.fill(t[p], 0);
        int r = v % k;
        t[p][r] = 1;
        t[p][k] = r;
    }

    void merge(int[] a, int[] b, int[] c) {
        Arrays.fill(c, 0);

        int x = a[k], y = b[k];
        c[k] = (x * y) % k;

        for (int i = 0; i < k; i++) {
            c[i] += a[i];
            c[(x * i) % k] += b[i];
        }
    }

    void build(int[] a, int p, int l, int r) {
        if (l == r) {
            leaf(p, a[l]);
            return;
        }

        int m = (l + r) / 2;

        build(a, p * 2, l, m);
        build(a, p * 2 + 1, m + 1, r);

        merge(t[p * 2], t[p * 2 + 1], t[p]);
    }

    void update(int p, int l, int r, int idx, int v) {
        if (l == r) {
            leaf(p, v);
            return;
        }

        int m = (l + r) / 2;

        if (idx <= m)
            update(p * 2, l, m, idx, v);
        else
            update(p * 2 + 1, m + 1, r, idx, v);

        merge(t[p * 2], t[p * 2 + 1], t[p]);
    }

    int[] query(int p, int l, int r, int L, int R) {
        if (L <= l && r <= R)
            return t[p];

        int m = (l + r) / 2;

        if (R <= m)
            return query(p * 2, l, m, L, R);

        if (L > m)
            return query(p * 2 + 1, m + 1, r, L, R);

        int[] a = query(p * 2, l, m, L, R);
        int[] b = query(p * 2 + 1, m + 1, r, L, R);
        int[] c = new int[k + 1];

        merge(a, b, c);
        return c;
    }
}

class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int l = queries[i][2];
            int x = queries[i][3];

            st.update(1, 0, n - 1, idx, val);
            ans[i] = st.query(1, 0, n - 1, l, n - 1)[x];
        }

        return ans;
    }
}