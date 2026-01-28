public class palindrome_partition2 {
    public boolean palindrome(int i,int j,String str)
    {
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    int minCut(String s) {
       int n=s.length();
       int dp[]=new int[n+1];
       dp[n]=0;
       for(int i=n-1;i>=0;i--)
       {
        int min=Integer.MAX_VALUE;
        for(int j=i;j<n;j++)
        {
            if(palindrome(i,j,s))
            {int cost=1+dp[j+1];
            min=Math.min(min,cost);}
        }
        dp[i]=min;
       }
       return dp[0]-1;
}
public static void main(String[] args) {
    palindrome_partition2 sol = new palindrome_partition2();
    String s = "aab";
    int result = sol.minCut(s);
    System.out.println("Minimum cuts needed for palindrome partitioning: " + result);
}
}
