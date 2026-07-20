class Solution {

    Integer[][] memo;
    Map<Character, List<Integer>> map = new HashMap<>();

    public int findRotateSteps(String ring, String key) {

        int n = ring.length();

        memo = new Integer[n][key.length()];

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }

        return dfs(0, 0, ring, key);
    }

    private int dfs(int ringPos, int keyPos, String ring, String key) {

        if (keyPos == key.length())
            return 0;

        if (memo[ringPos][keyPos] != null)
            return memo[ringPos][keyPos];

        int n = ring.length();
        int ans = Integer.MAX_VALUE;

        for (int nextPos : map.get(key.charAt(keyPos))) {

            int diff = Math.abs(nextPos - ringPos);
            int rotate = Math.min(diff, n - diff);

            ans = Math.min(ans,
                    rotate + 1 + dfs(nextPos, keyPos + 1, ring, key));
        }

        return memo[ringPos][keyPos] = ans;
    }
}