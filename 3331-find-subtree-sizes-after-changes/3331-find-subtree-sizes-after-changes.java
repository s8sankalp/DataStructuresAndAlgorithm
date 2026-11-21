class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] ans = new int[n];
        int[] last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, tree, s, last, ans);

        return ans;
    }

    private void dfs(int node, List<Integer>[] tree, String s, int[] last, int[] ans) {
        int c = s.charAt(node) - 'a';
        int prev = last[c];

        last[c] = node;

        for (int child : tree[node]) {
            int ch = s.charAt(child) - 'a';
            int originalParent = -1;

            if (last[ch] != -1) {
                originalParent = last[ch];
            }

            dfs(child, tree, s, last, ans);

            if (originalParent != -1) {
                ans[originalParent] += ans[child];
            } else {
                ans[node] += ans[child];
            }
        }

        ans[node]++;

        last[c] = prev;
    }
}
