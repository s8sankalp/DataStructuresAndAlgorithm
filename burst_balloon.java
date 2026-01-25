import java.util.ArrayList;
import java.util.List;

public class burst_balloon {
    public int maxCoins(int[] nums) {
    int n=nums.length;
        List<Integer> list=new ArrayList<>();
        for(int num:nums)
       {
        list.add(num);
       }
       list.add(0,1);
       list.add(1);
        int dp[][]=new int[n+2][n+2];
        for(int i=n;i>=1;i--)
        {
            for(int j=1;j<=n;j++)
            {
                if(i>j)continue;
                int maxi=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int cost=list.get(i-1)*list.get(k)*list.get(j+1)+dp[i][k-1]+dp[k+1][j];
                    maxi=Math.max(maxi,cost);
                }
                dp[i][j]=maxi;
            }
        }
    return dp[1][n];
}
public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        // Create an instance of burst_balloon class
         burst_balloon sol = new burst_balloon();

        // Print the result
        System.out.println("Maximum coins obtained: " + sol.maxCoins(nums));
    }

}
