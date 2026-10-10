
import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long k = (long) k1 + k2;
        long sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            max = Math.max(max, diff[i]);
        }

        if (sum <= k) return 0;

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                needed += Math.max(0, d - mid);
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int level = low;
        long used = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            used += Math.max(0, diff[i] - level);
            diff[i] = Math.min(diff[i], level);
        }

        long remaining = k - used;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == level) {
                diff[i]--;
                remaining--;
            }
        }

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}
