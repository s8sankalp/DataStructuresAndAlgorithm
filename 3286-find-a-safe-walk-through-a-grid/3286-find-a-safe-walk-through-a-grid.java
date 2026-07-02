class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        Queue<int[]> q=new LinkedList<>();
        int[][] bh=new int[n][m];
        q.add(new int[]{0,0,health-grid.get(0).get(0)});
        while(!q.isEmpty())
        {
            int arr[]=q.poll();
            int r=arr[0];
            int c=arr[1];
            int h=arr[2];
            if(h<1)
            {
               continue;
            }
            if(r==n-1&&c==m-1&&h>=1){
                return true;
            }
           int[]dr={0,-1,0,1};
           int []dc={1,0,-1,0};
           for(int i=0;i<4;i++)
           {
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                int h1=h-grid.get(nr).get(nc);
                if(h1>bh[nr][nc])
        {
            bh[nr][nc]=h1;
            q.add(new int[]{nr,nc,h1});
            }
    }
           }
        }
        return false;
    }
}