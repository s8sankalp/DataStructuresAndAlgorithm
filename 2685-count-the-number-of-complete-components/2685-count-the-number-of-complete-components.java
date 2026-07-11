class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] it:edges)
        {
            int u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count=0;
        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                List<Integer> comp=new ArrayList<>();
                dfs(adj,i,vis,comp);
                int node=comp.size();
                int edgecount=0;
                for(int it:comp)
                {
                    edgecount+=adj.get(it).size();
                }
                edgecount=edgecount/2;
                if(edgecount==(node*(node-1))/2)
                {
                    count++;
                }

            }
        }
        return count;
    }
    public void dfs( List<List<Integer>> adj,int node,int[] vis,List<Integer> comp)
    {
        vis[node]=1;
        comp.add(node);
        for(int it:adj.get(node))
        {
            if(vis[it]==0)
            {
                dfs(adj,it,vis,comp);
            }
        }
    }
}