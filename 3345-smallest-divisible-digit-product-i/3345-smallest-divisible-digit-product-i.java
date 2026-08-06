class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=t*n;i++)
        {
            int pro=1;
            int num=i;
            while(num>0)
            {
                int rem=num%10;
                pro=pro*rem;
                num/=10;
            }
            if(pro%t==0)
            {
                return i;
            }
        }
        return 0;

    }
}