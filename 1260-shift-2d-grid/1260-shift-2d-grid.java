class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int res[][]=new int[n][m];
        int total=n*m;
        k=k%(n*m);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int idx=i*m+j;
                int newidx=(idx+k)%total;
                int nr=newidx/m;
                int nc=newidx%m;
                res[nr][nc]=grid[i][j];
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<m;j++)
            {
                list.add(res[i][j]);
            }
            ans.add(list);
        }
        return ans;
    }
}