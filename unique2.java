public class unique2 {
     public int uniquePathsWithObstacles(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m][n];
        dp[0][0]=1;
        if(matrix[0][0] == 1||matrix[m-1][n-1]==1) return 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0&&j==0)continue;
                if(matrix[i][j]==1)continue;
                int up=i>0?dp[i-1][j]:0;
                int left=j>0?dp[i][j-1]:0;
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        unique2 u=new unique2();
        int[][] matrix={
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        int result=u.uniquePathsWithObstacles(matrix);
        System.out.println(result);
    }
}
