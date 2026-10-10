class Solution {
    public long minimumReplacement(int[] nums) {
        int n=nums.length;
        int limit=nums[n-1];
        long op=0;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<=limit)
            {
                limit=nums[i];
            }
            else{
                int parts=(nums[i]+limit-1)/limit;
                op+=parts-1;
                limit=(nums[i]/parts);
            }
        }
        return op;
    }
}