class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] grp=new int[n];
        int cnt=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]-nums[i-1]>maxDiff)
            {
                cnt++;
            }
            grp[i]=cnt;
        }
        boolean[] ans=new boolean[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int u=queries[i][0];
            int v=queries[i][1];
            ans[i]=(grp[u]==grp[v]);
        }
        return ans;
    }
}