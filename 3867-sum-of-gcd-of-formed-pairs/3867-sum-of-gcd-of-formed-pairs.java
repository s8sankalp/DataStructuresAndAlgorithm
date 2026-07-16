class Solution {
    public long gcdSum(int[] nums) {
        long max=Long.MIN_VALUE;
        int n=nums.length;
        long prefix[]=new long[n];
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            prefix[i]=gcd(nums[i],max);
        }
        Arrays.sort(prefix);
        int i=0;
        int j=n-1;
        long sum=0;
        while(i<j)
        {
            sum+=gcd(prefix[i],prefix[j]);
            i++;
            j--;
        }
        return sum;
    }
    public long gcd(long a,long b)
    {
        while(b!=0)
        {
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}