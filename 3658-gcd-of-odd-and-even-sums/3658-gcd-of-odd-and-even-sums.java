class Solution {
    public int gcdOfOddEvenSums(int n) {
        int even=2;
        int odd=1;
        int sumeven=0;
        int sumodd=0;
        for(int i=0;i<n;i++)
        {
            sumeven+=even+2;
            sumodd+=odd+2;
        }
        return gcd(sumodd,sumeven);
    }
    public int gcd(int a, int b)
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}