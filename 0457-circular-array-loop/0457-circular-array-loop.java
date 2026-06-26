class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i;
            int fast = next(nums, i);

            while (nums[slow] * nums[fast] > 0 &&
                   nums[slow] * nums[next(nums, fast)] > 0) {

                if (slow == fast) {
                    if (slow == next(nums, slow)) {
                        break;
                    }
                    return true;
                }

                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }

            int val = nums[i];
            int idx = i;

            while (nums[idx] * val > 0) {
                int nextIdx = next(nums, idx);
                nums[idx] = 0;
                idx = nextIdx;
            }
        }

        return false;
    }

    private int next(int[] nums, int index) {
        int n = nums.length;
        return ((index + nums[index]) % n + n) % n;
    }
}