class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<0)
            {
                nums[i]=-1*(nums[i]);
            }
        }
        Arrays.sort(nums);
        int l=0;
        int r=n-1;
        long sum=0;
        while(l<=r)
        {
            sum+=nums[r]*nums[r];
            if(l<r)
            {sum-=nums[l]*nums[l];}
            l++;
            r--;
        }
        return sum;
    }
}