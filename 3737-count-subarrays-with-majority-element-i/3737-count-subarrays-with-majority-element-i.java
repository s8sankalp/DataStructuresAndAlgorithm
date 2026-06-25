class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int prefix[]=new int[n+1];
        prefix[0]=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
            {
                prefix[i+1]=prefix[i]+1;
            }
            else{
                prefix[i+1]=prefix[i]-1;
            }
        }
        int l=0,r=0;
        int ans=0;
       for (int j = 0; j < prefix.length; j++) {
    for (int i = 0; i < j; i++) {
        if (prefix[j] > prefix[i]) ans++;
    }
}
        return ans;

    }
}