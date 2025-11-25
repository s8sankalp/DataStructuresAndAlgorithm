public class stair {
    public int func(int n)
    {
        if(n==1)return 1;
        if(n==2)return 2;
        int prev2=1;
        int prev=2;
        for(int i=3;i<=n;i++)
        {
            int curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int climbStairs(int n) {
        return func(n);
    }
    public static void main(String[] args){
        stair s=new stair();
        int n=2;
        int result=s.climbStairs(n);
        System.out.println(result);
    }
}
