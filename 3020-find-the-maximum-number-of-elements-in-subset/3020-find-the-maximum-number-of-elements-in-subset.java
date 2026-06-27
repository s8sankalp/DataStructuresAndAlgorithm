class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special handling for 1
        if (freq.containsKey(1L)) {
            int ones = freq.get(1L);
            ans = Math.max(ans, ones % 2 == 1 ? ones : ones - 1);
        }

        for (long start : freq.keySet()) {

            if (start == 1)
                continue;

            long x = start;
            int len = 0;

            while (freq.getOrDefault(x, 0) >= 2) {
                len += 2;
                x = x * x;

                // avoid overflow
                if (x > 1_000_000_000L)
                    break;
            }

            if (freq.getOrDefault(x, 0) >= 1)
                len += 1;
            else
                len -= 1;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}