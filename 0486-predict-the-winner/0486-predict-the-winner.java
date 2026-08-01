class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        return solve(0,n-1,nums)>=0;
    }
    public int solve(int i,int j,int[] nums)
    {
        if(i==j)return nums[i];
        return Math.max(nums[i]-solve(i+1,j,nums),nums[j]-solve(i,j-1,nums));
    }
}