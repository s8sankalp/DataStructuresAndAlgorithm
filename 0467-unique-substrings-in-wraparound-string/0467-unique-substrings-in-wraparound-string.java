class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] maxLen = new int[26];
        int currLen = 0;

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 &&
                (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                currLen++;
            } else {
                currLen = 1;
            }

            int idx = p.charAt(i) - 'a';
            maxLen[idx] = Math.max(maxLen[idx], currLen);
        }

        int ans = 0;

        for (int len : maxLen) {
            ans += len;
        }

        return ans;
    }
}