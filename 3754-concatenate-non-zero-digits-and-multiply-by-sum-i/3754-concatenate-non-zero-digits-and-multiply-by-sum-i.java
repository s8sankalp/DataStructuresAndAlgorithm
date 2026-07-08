class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long num=0;
        while(n>0)
        {
            int rem=n%10;
            sum+=rem;
            if(rem!=0)
            {
                num=num*10+(rem);
            }
            n=n/10;
        }
        num=reverse(num);
        return sum*num;
    }
    public long reverse(long num)
    {
        long n=0;
        while(num>0)
        {
            long rem=num%10;
            n=n*10+rem;
            num=num/10;
        }
        return n;
    }
}