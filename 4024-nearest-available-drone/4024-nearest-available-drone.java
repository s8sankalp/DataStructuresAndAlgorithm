class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int tx=target[0];
        int ty=target[1];
        int ans=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<drones.length;i++)
            {
                int x=drones[i][0];
                int y=drones[i][1];
                int range=drones[i][2];
                int dis=Math.abs(x-tx)+Math.abs(y-ty);
                if(dis<=range&&dis<min)
                {
                    min=dis;
                    ans=i;
                }
            }
        return ans;
    }
}